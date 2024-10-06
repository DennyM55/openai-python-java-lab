
# Text Summarizer Script (`summarize.py`)

This Python script uses OpenAI's GPT-3.5-turbo model to summarize text. If you're familiar with Java and are learning Python, this README will help you relate the concepts between the two languages and understand how the script works.

## How It Works (from a Java Perspective)

1. **API Key Setup**:
    - The API key is fetched from an environment variable (`OPENAI_API_KEY`). In Java, you’d likely use `System.getenv()` to get environment variables.

2. **Text Summarization**:
    - Similar to making an API call using `HttpURLConnection` or a third-party library like `OkHttp` in Java, the Python script sends a request to OpenAI's API with some parameters and receives a response.

3. **Error Handling**:
    - Python’s `try-except` block is similar to Java’s `try-catch` block. The script handles specific API errors like exceeding your API quota or general API issues.

4. **Main Program Execution**:
    - Python’s `if __name__ == '__main__':` construct is similar to Java's `public static void main(String[] args)` for running the main program logic.

## Code Breakdown (Java vs Python)

### 1. **Imports (Libraries)**:

In Python, libraries are imported using the `import` statement. It’s similar to how you use `import` statements in Java for libraries.

```python
import openai  # Similar to importing a library in Java (like OkHttp for API calls)
import os      # Used to access environment variables (like System.getenv() in Java)
```

### 2. **Defining Functions (Methods)**:

In Python, functions are defined with `def` (instead of `public/private/protected` in Java). Here's how the main function works:

```python
def summarize_text(text):
```

- **Java Equivalent**: You can think of this like a method in Java, such as:

  ```java
  public String summarizeText(String text) {
  ```

### 3. **Fetching Environment Variables**:

In Python, environment variables are fetched using the `os` module. In Java, you'd do something similar with `System.getenv()`:

```python
openai.api_key = os.getenv('OPENAI_API_KEY')  # Python
```

Equivalent in Java:

```java
String apiKey = System.getenv("OPENAI_API_KEY");  // Java
```

### 4. **Making an API Call (HTTP Request)**:

In Python, we use `openai.ChatCompletion.create()` to make a request to OpenAI’s API. In Java, you might use something like `HttpURLConnection` or `OkHttp` to achieve this.

```python
response = openai.ChatCompletion.create(
    model='gpt-3.5-turbo',
    messages=[{"role": "user", "content": f"Summarize the following text:\n\n{text}"}],
    max_tokens=100,
    temperature=0.5
)
```

- **Java Equivalent**: In Java, this would be similar to making an HTTP request to an API, passing parameters like `model`, `messages`, and `max_tokens`. You'd parse the JSON response in a similar way.

Example in Java using `OkHttp`:

```java
OkHttpClient client = new OkHttpClient();
RequestBody body = RequestBody.create(jsonRequestBody, MediaType.parse("application/json"));
Request request = new Request.Builder().url(url).post(body).build();
Response response = client.newCall(request).execute();
```

### 5. **Handling the Response**:

In Python, we extract the relevant part of the response like this:

```python
return response.choices[0].message['content'].strip()  # Extract and return the summary
```

In Java, you would typically parse the JSON response using a library like `Gson` or `Jackson`, extract the required field, and return the result.

```java
JsonObject jsonResponse = new JsonParser().parse(response.body().string()).getAsJsonObject();
String summary = jsonResponse.getAsJsonArray("choices").get(0).getAsJsonObject().get("message").getAsJsonObject().get("content").getAsString();
```

### 6. **Error Handling (Exceptions)**:

Python handles exceptions with `try-except`, which is similar to Java’s `try-catch` blocks.

```python
try:
    # Code to try
except openai.error.RateLimitError:
    print("You have exceeded your API quota.")  # Handles rate limit error
except openai.error.OpenAIError as e:
    print(f"An error occurred: {e}")  # Handles other OpenAI API errors
```

In Java, you would write it like this:

```java
try {
    // Code that could throw an exception
} catch (RateLimitException e) {
    System.out.println("You have exceeded your API quota.");
} catch (OpenAIException e) {
    System.out.println("An error occurred: " + e.getMessage());
}
```

### 7. **Main Method Execution**:

In Python, you use `if __name__ == '__main__':` to run the main part of your script. This is similar to the `main` method in Java.

```python
if __name__ == '__main__':
    text = 'OpenAI provides access to...'
    summary = summarize_text(text)
    if summary:
        print(summary)
```

In Java, the main method would look like this:

```java
public static void main(String[] args) {
    String text = "OpenAI provides access to...";
    String summary = summarizeText(text);
    if (summary != null) {
        System.out.println(summary);
    }
}
```

### 8. **String Formatting**:

In Python, you use `f"{variable}"` for string interpolation, while in Java, you’d use `String.format()`.

```python
f"Summarize the following text:\n\n{text}"  # Python
```

Equivalent in Java:

```java
String.format("Summarize the following text:\n\n%s", text);  // Java
```

## How to Run the Script

1. **Install Dependencies**:
   Run the following command to install the `openai` library:

   ```bash
   pip install openai
   ```

2. **Set the OpenAI API Key**:
   Set your OpenAI API key as an environment variable.

    - **Windows**:
      ```bash
      set OPENAI_API_KEY=your-api-key-here
      ```

    - **Mac/Linux**:
      ```bash
      export OPENAI_API_KEY=your-api-key-here
      ```

3. **Run the Script**:
   Execute the script by running:

   ```bash
   python summarize.py
   ```

## Example Output

```bash
OpenAI provides access to powerful language models like GPT-3.5-turbo that can perform various tasks, including text summarization, chatbot development, and more.
```

---

### Key Takeaways for Java Developers Learning Python:

- **Function Definitions**: Python uses `def` instead of `public/private` for defining methods.
- **Indentation**: Python uses indentation to define code blocks, whereas Java uses curly braces `{}`.
- **Error Handling**: Python uses `try-except` blocks, while Java uses `try-catch`.
- **API Requests**: In Python, making API calls is easier with libraries like `openai` without needing extensive setup (compared to `HttpURLConnection` or `OkHttp` in Java).

