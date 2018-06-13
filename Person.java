import sum.ereignis.*;

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    // instance variables - replace the example below with your own
    private boolean istRot;
    private Buntstift stift;
    int pH, pV;
    private int party;
    private final int mode = 1;
    private Rectangle rect;
    /**
     * Constructor for objects of class Person
     */
    public Person(int pH, int pV, boolean istRot, Buntstift stift)
    {
        this.pH = pH;
        this.pV = pV;
        this.stift = stift;
        this.istRot = istRot;
        this.zeichne();
    }
    
    /**
     * Constructor for objects of class Person
     */
    public Person(int pH, int pV, boolean istRot, GridPane pane)
    {
        this.pH = pH;
        this.pV = pV;
        this.istRot = istRot;
        this.rect = new Rectangle(5, 5, (istRot) ? Color.RED : Color.BLACK);
        pane.add(rect, pH, pV);
    }
    
    public Person (int pH, int pV, int party, Buntstift stift)
    {   this.pH = pH;
        this.pV = pV;
        this.stift = stift;
        this.party = party;
        this.zeichne();
        
    }
    
    protected void zeichne() {
        stift.setzeFarbe(Farbe.WEISS);
        stift.bewegeBis(pH, pV);
        stift.zeichneKreis(5);
        if (istRot == true)
            stift.setzeFarbe(Farbe.ROT);
        else
            stift.setzeFarbe(Farbe.SCHWARZ);
        
        stift.zeichneKreis(5);
    }
    
    public boolean istRot() {
        return istRot;
    }
    
    public void setzeRot(boolean istRot) {
        this.istRot = istRot;
        
        if (rect != null) {
            this.rect.setFill((istRot) ? Color.RED : Color.BLACK);
        } else {
            this.zeichne();
        }
    }
}
