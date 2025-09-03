package com.moodifyx;

import javax.sound.sampled.*;
import java.io.File;

/**
 * Responsible for playing and stopping audio clips.
 */
public class SongPlayer {
   private static Clip clip;
   /**
     * Plays an audio file at the given file path.
     * Stops any currently playing clip first.
     * @param filePath path to the audio file
     */
   
   public static void play(String filePath){
    stop(); // Stop any current playback before starting new one

    try{
       AudioInputStream audioStream =  AudioSystem.getAudioInputStream(new File(filePath));
       clip = AudioSystem.getClip();
       clip.open(audioStream);
       clip.start();
    }catch(Exception e){
        System.out.println("Error Playing Sound: " + e.getMessage());
    }
   }
   
    /**
     * Stops the current playing audio clip and releases resources.
     */
   public static void stop(){
    if(clip != null && clip.isRunning()){
        clip.stop();
        clip.close();
    }
   }
}
