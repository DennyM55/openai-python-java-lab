import openai
import os
import time

# Function to summarize text
def summarize_text(text):
    openai.api_key = os.getenv('OPENAI_API_KEY')

    try:
        response = openai.ChatCompletion.create(
            model='gpt-3.5-turbo',
            messages=[
                {"role": "user", "content": f"Summarize the following text:\n\n{text}"}
            ],
            max_tokens=100,
            temperature=0.5,
        )
        return response.choices[0].message['content'].strip()

    except openai.error.RateLimitError:
        print("You have exceeded your API quota. Please check your billing details.")
        return None
    except openai.error.OpenAIError as e:
        print(f"An error occurred: {e}")
        return None

if __name__ == '__main__':
    text = 'OpenAI provides access to language models like GPT-3.5-turbo that can perform a wide range of tasks, including summarizing text. This API helps developers easily integrate language processing capabilities into their applications. The models can be used for chatbots, question answering, content generation, and more.'
    summary = summarize_text(text)
    if summary:
        print(summary)
