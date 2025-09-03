package com.moodifyx;

/**
 * Main entry point to launch the application.
 */
public class Main {
    public static void main(String[] args){
       // Ensure UI launches on the Event Dispatch Thread (EDT)
      new MoodSelectorUI(); 
    }
    
}
