import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

public class Instru {
    
    public int volume = 100;
    
    private Synthesizer synthetiseur;
    private MidiChannel canal;
    
    public Instru(){
        
        try {
            //On r�cup�re le synth�tiseur, on l'ouvre et on obtient un canal
            synthetiseur = MidiSystem.getSynthesizer();
            synthetiseur.open();
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Instru.class.getName()).log(Level.SEVERE, null, ex);
        }
        canal = synthetiseur.getChannels()[0];
        
        //On initialise l'instrument 0 (le piano) pour le canal
	canal.programChange(0);
    }
    
    //Joue la note dont le num�ro est en param�tre
    public void note_on(int note){
        canal.noteOn(note, volume);
    }
    //Arr�te de jouer la note dont le num�ro est en param�tre
    public void note_off(int note){
        canal.noteOff(note);
    }
    //Set le type d'instrument dont le num�ro MIDI est pr�cis� en param�tre
    public void set_instrument(int instru){
        canal.programChange(instru);
    }
 
 

}
