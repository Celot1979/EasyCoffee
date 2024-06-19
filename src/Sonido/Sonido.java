package Sonido;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido {

    private Clip clip;
    public void cargarSonido(String ruta){
        try {
            File archivo_sonido=new File(ruta);
            AudioInputStream audioInputStream= AudioSystem.getAudioInputStream(archivo_sonido);
            clip= AudioSystem.getClip();
            clip.open(audioInputStream);

        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }


    public void reproduccir (){
        if(clip != null){
            clip.setFramePosition(0);
            clip.start();
        }
    }


    public void detener(){
        if(clip != null && clip.isRunning()){

            clip.stop();
        }
    }
}
