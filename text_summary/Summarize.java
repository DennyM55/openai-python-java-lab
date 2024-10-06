import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import okhttp3.*;  // OkHttp library

public class Summarize {

    private static final String OPENAI_API_KEY = System.getenv("OPENAI_API_KEY"); // Get API key from environment variable
    private static final String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions"; // OpenAI API endpoint
    private static final OkHttpClient client = new OkHttpClient(); // HTTP client

    // Function to summarize text using OpenAI's GPT-3.5-turbo model
    public static String summarizeText(String text) throws IOException {
        if (OPENAI_API_KEY == null || OPENAI_API_KEY.isEmpty()) {
            throw new IllegalStateException("OpenAI API key is missing.");
        }

        // Prepare the request body as JSON
        Gson gson = new Gson();
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("model", "gpt-3.5-turbo");

        // Prepare the message to send to GPT
        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", "Summarize the following text:\n\n" + text);

        requestBody.put("messages", new Map[]{message});
        requestBody.put("max_tokens", 100);  // Limit the number of tokens
        requestBody.put("temperature", 0.5); // Set the randomness

        // Convert the request body map to a JSON string
        String jsonRequestBody = gson.toJson(requestBody);

        // Prepare the API request
        RequestBody body = RequestBody.create(jsonRequestBody, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(OPENAI_API_URL)
                .header("Authorization", "Bearer " + OPENAI_API_KEY)
                .post(body)
                .build();

        // Execute the request and get the response
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Parse the JSON response
            JsonObject jsonResponse = gson.fromJson(response.body().string(), JsonObject.class);
            return jsonResponse.getAsJsonArray("choices")
                    .get(0)
                    .getAsJsonObject()
                    .get("message")
                    .getAsJsonObject()
                    .get("content")
                    .getAsString()
                    .trim();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String text = "OpenAI provides access to language models like GPT-3.5-turbo that can perform a wide range of tasks, " +
                "including summarizing text. This API helps developers easily integrate language processing capabilities into their applications. " +
                "The models can be used for chatbots, question answering, content generation, and more.";

        try {
            String summary = summarizeText(text);
            if (summary != null) {
                System.out.println("Summary: " + summary);
            } else {
                System.out.println("Failed to generate a summary.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
