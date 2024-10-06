

# AI Experiments with OpenAI in Python and Java

Welcome to the **openai-python-java-lab**, a repository crafted to showcase various experiments with OpenAI’s powerful AI models using both **Python** and **Java**. These experiments delve into modern-day artificial intelligence, exploring its capabilities in text, audio, video, and beyond.

## Project Overview

This project is a collection of personal AI-related experiments, conducted in both **Python** and **Java**. Each module demonstrates a different facet of AI, harnessing the power of OpenAI's models to explore new frontiers.

### Key Modules (Current and Future)

1. **Text Summarization**:
   - Compress long-form text into concise, meaningful summaries using OpenAI’s GPT models.
   
2. **Audio-to-Text Transcription**:
   - Convert speech or audio files to text and extract essential information through automatic summarization.
   
3. **Video-to-Summary**:
   - Summarize the content of videos by extracting key themes and moments.

4. **Image Captioning**:
   - Automatically generate descriptive captions for images using cutting-edge AI models.
   
5. **Question Answering System**:
   - Build an AI system that answers questions from provided content, such as documents or transcripts.

6. **Sentiment Analysis**:
   - Analyze the sentiment of text data, ranging from positive to negative, useful for understanding feedback or reviews.

7. **Interactive Chatbots**:
   - Develop virtual assistants capable of answering questions or holding conversations.

8. **Entity Recognition**:
   - Automatically identify key entities like people, places, and organizations in text.

## File Structure

```
openai-python-java-lab/
│
├── openai-text-summary/
│   ├── java/
│   │   ├── pom.xml                    # Maven configuration for Java project
│   │   └── Summarize.java             # Java implementation of AI module
│   └── python/
│       ├── __init__.py                # Python package
│       ├── openai_text_summarizer.py  # Python implementation of AI module
│       └── openai_text_summarizer.md  # Optional documentation for Python implementation
│
├── .gitignore                         # Git ignore file
├── README.md                          # This README file
└── requirements.txt                   # Python dependencies
```

## Getting Started

### Prerequisites

#### For Python Modules:
- **Python 3.7+** installed.
- An **OpenAI API Key** from [OpenAI](https://platform.openai.com/signup).

#### For Java Modules:
- **Java 8+** installed.
- **Maven** for dependency management.
- An **OpenAI API Key**.

### Setup

#### Python Setup

1. **Install Dependencies**:
   ```bash
   pip install -r requirements.txt
   ```

2. **Set OpenAI API Key**:
   Set the OpenAI API key as an environment variable:
   
   - **Windows**:
     ```bash
     set OPENAI_API_KEY=your-api-key-here
     ```
   - **Linux/Mac**:
     ```bash
     export OPENAI_API_KEY=your-api-key-here
     ```

3. **Run Python Module**:
   ```bash
   python openai-text-summary/python/openai_text_summarizer.py
   ```

#### Java Setup

1. **Install Maven Dependencies**:
   ```bash
   mvn clean install
   ```

2. **Set OpenAI API Key**:
   Set the OpenAI API key in your environment variables.

3. **Run Java Module**:
   ```bash
   mvn exec:java -Dexec.mainClass="com.yourcompany.Summarize"
   ```

## Future Directions and Modules

This repository will continue to evolve, with plans to add more AI experiments in the following areas:

1. **Audio-to-Text with Summarization**
2. **Video Summarization**
3. **Sentiment Analysis for Social Media**
4. **Interactive Chatbots**
5. **Image Captioning**
6. **Text Classification and Entity Extraction**


### License

This project beareth no specific license, as the contents herein are but experimental musings, subject to change and revision at the whims of their creator.

