package com.moodifyx;

import javax.swing.*;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Swing-based UI for selecting moods and playing songs.
 */
public class MoodSelectorUI extends JFrame {
    private final MoodRepository repository = new MoodRepository();

    public MoodSelectorUI(){
        setTitle("Moodifyx");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setupUI();
        setVisible(true);

    }
    /**
     * Sets up the UI components and event listeners.
     */

    private void setupUI(){
        Set<String> moods = repository.getAllMoods();
        JComboBox<String> moodDropdown = new JComboBox<>(moods.toArray(new String[0]));
        JButton detectMoodBtn = new JButton("Recommend Music");

         // Handle button click in a background thread to keep UI responsive
        detectMoodBtn.addActionListener(e ->{
            String mood = (String) moodDropdown.getSelectedItem();

            while(true){
                List<Song> songs = repository.getSongsForMood(mood);
                Song selected = songs.get(ThreadLocalRandom.current().nextInt(songs.size()));
                SongPlayer.play(selected.getFilePath());

                Object[] options = {" Another Song", "Change Mood", "Stop Music and Exit"};
                int choice = JOptionPane.showOptionDialog(
                    this,
                    "Now playing :" + selected.getTitle() + "\nMood : " + mood, "Your Mood Music",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
                 );
                 SongPlayer.stop();

                if(choice == JOptionPane.YES_OPTION){
                      // Play another song of the same mood
                   continue; 
                }else if(choice == JOptionPane.NO_OPTION){
                      // Play another song of the same mood
                    break;
                }else{
                    System.exit(0);
                }

            }
        });
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Your Mood: "));
        panel.add(moodDropdown);
        panel.add(detectMoodBtn);
        add(panel);

    }

}
