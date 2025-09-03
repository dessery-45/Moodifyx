package com.moodifyx;

import java.util.*;

/**
 * Repository holding songs organized by mood.
 */
public class MoodRepository {
   // Map moods (lowercase) to immutable lists of songs
   private final Map<String, List<Song>> moodSongs = new HashMap<>();

   public MoodRepository(){
            initializeMoodSongs();
   }

   /**
     * Initializes the moodSongs map with predefined moods and song files.
     */
   private void initializeMoodSongs(){
    Map<String, String[]> moodFiles = Map.of(
      "Happy", new String[]{"happygirl.wav", "happygirlie.wav"},
      "Angry", new String[]{"angrygirl.wav", "angrygirlie.wav"},
      "Chill", new String[]{"chillgirl.wav", "chillgirlie.wav"},
      "Mysterious", new String[]{"mysteriousgirl.wav", "mysteriousgirlie.wav"},
      "Moody", new String[]{"moodygirl.wav", "moodygirlie.wav"},
      "Practice", new String[]{"practicegirl.wav", "practicegirlie.wav"},
      "Romantic", new String[]{"romanticgirl.wav", "romanticgirlie.wav"},
      "Peaceful", new String[]{"peacefulgirl.wav", "peacefulgirlie.wav"},
      "Positive", new String[]{"positivegirl.wav", "positivegirlie.wav"}

    );
    for(Map.Entry<String, String[]> entry : moodFiles.entrySet()){
        addMood(entry.getKey(), entry.getValue());
    }
   }
   /**
     * Initializes the moodSongs map with predefined moods and song files.
     */

   private String formatTitle(String fileName){
    String base = fileName.replace(".wav", "");
    if(base.endsWith("girl")) base = base.replace("girl", "");
    else if(base.endsWith("girlie")) base = base.replace("girlie", "");
    base = base.trim();
    return base.substring(0,1).toUpperCase() + base.substring(1) + "Vibe";

   }

   /**
     * Adds a mood and its songs to the repository.
     * @param mood the mood name
     * @param files list of song filenames for the mood
     */
   private void addMood(String mood, String[] files){
    List<Song> songs = new ArrayList<>();
    for(String file: files){
        songs.add(new Song(formatTitle(file), "music/" + file));
    }
    // Store with lowercase key for case-insensitive lookups
    moodSongs.put(mood.toLowerCase(), Collections.unmodifiableList(songs));

   }

   /**
     * Retrieves songs for a given mood.
     * Returns a default song if mood not found.
     * @param mood mood string
     * @return list of songs
     */
   public List<Song> getSongsForMood(String mood){
    return moodSongs.getOrDefault(mood, List.of(new Song("Default Vibe", "music/happygirl.wav" )));

   }

    /**
     * Returns all available moods with capitalized first letters.
     * @return set of moods
     */
   public Set<String> getAllMoods(){
    return moodSongs.keySet();
   }
}
