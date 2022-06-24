package com.maledictus.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class GameMusic {
    private Clip audioClip;
    private FloatControl gainControl;

    public GameMusic() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File audioFile = new File("-leftiesRecharged/resources/data/lavender-town-music.wav");

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);
        gainControl = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(-30.0f);
    }

    public void playMusic() {
        audioClip.start();
        audioClip.loop(audioClip.LOOP_CONTINUOUSLY);
    }

    public void stopMusic() {
        audioClip.stop();
    }
}