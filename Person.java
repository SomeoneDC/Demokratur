import sum.ereignis.*;
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
    private final int mode = 1;
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
    public Person (int pH, int pV, int party, Bundstift stift)
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
        this.zeichne();
    }
}
