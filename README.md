# Moodifyx

Moodifyx is a Java desktop application that recommends music based on your mood. Select a mood, and Moodifyx will play a random song fitting that vibe. Whether you're feeling happy, chill, or romantic, Moodifyx has you covered.

## Features

- Select from multiple moods: Happy, Angry, Chill, Mysterious, Moody, Practice, Romantic, Peaceful, Positive.
- Plays a random song from the selected mood.
- Options to play another song, change mood, or exit.
- Simple and responsive Swing-based UI.
- Uses standard Java audio API for playback.

## Getting Started

### Prerequisites

- Java 8 or higher installed.
- Audio files located in the `music/` directory relative to the working directory (e.g., `music/happygirl.wav`).

### How to Run

1. Compile the project:

```bash
javac -d out src/com/Moodifyx/*.java
