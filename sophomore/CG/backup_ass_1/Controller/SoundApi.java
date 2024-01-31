package backup_ass_1.Controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.print.attribute.standard.Media;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
// import  sun.audio.*;    //import the sun.audio package
// import sun.awt.www.content.audio.*;
// import sun.


import Assignment_1_Newyear.NewYearDriver;

public class SoundApi {
    
    public static synchronized void playSound(final String url) {
        System.out.println("playing sound");
        // new Thread(new Runnable() {
        //     // The wrapper thread is unnecessary, unless it blocks on the
        //     // Clip finishing; see comments.
        //     public void run() {
        //         try {
        //             Clip clip = AudioSystem.getClip();
        //             AudioInputStream inputStream = AudioSystem.getAudioInputStream(
        //                     // Main.class.getResourceAsStream("/path/to/sounds/" + url));
        //                     // url
        //                 Main.class.getResourceAsStream(url)
        //             );
        //             clip.open(inputStream);
        //             clip.start();
        //         } catch (Exception e) {
        //             System.out.println("Error playing sound " + e);
        //             // System.err.println(e.getMessage());
        //         }
        //     }
        // }).start();

        // // ** add this into your application code as appropriate
        // // Open an input stream to the audio file.
        // InputStream in = new FileInputStream(url);
        // // AudioSystem
        // // Create an AudioStream object from the input stream.
        // AudioStream as = new AudioStream(in);

        // // Use the static class member "player" from class AudioPlayer to play
        // // clip.
        // AudioPlayer.player.start(as);
            // cl is the ClassLoader for the current class, ie. CurrentClass.class.getClassLoader();
        // URL file = cl.getResource(url);
        // final Media media = new Media(file.toString());
        // final MediaPlayer mediaPlayer = new MediaPlayer(media);
        // mediaPlayer.play();
        


        // File f = new File("./" + soundFile);
        File f = new File(url);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
            System.out.println(f);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            System.out.println("started paly sound");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
