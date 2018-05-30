/**
 * Die Klasse SuMAnwendung wurde automatisch erstellt: 
 * 
 * @author 
 * @version 30.5.2018
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class SuMAnwendung extends EBAnwendung
{
    // Objekte
    private Etikett hatEtikettDemokratur;
    private Etikett hatEtikettProzentsatzRote;
    private Textfeld hatTextfeldRote;
    private Knopf hatKnopfUeberzeugen;
    private Knopf hatKnopfBeenden;

    // Attribute

/**
 * Konstruktor
 */
    public SuMAnwendung()
    {
        //Initialisierung der Oberklasse
        super(1699, 980);

        hatEtikettDemokratur = new Etikett(256, 96, 100, 25, "Demokratur");
        // Ausrichtung
        hatEtikettDemokratur.setzeAusrichtung(Ausrichtung.LINKS);
        hatEtikettProzentsatzRote = new Etikett(150, 170, 100, 25, "Prozentsatz Rote");
        // Ausrichtung
        hatEtikettProzentsatzRote.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldRote = new Textfeld(250, 170, 100, 25, "");
        // Ausrichtung
        hatTextfeldRote.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfUeberzeugen = new Knopf(150, 200, 100, 25, "Ueberzeugen");
        hatKnopfUeberzeugen.setzeBearbeiterGeklickt("hatKnopfUeberzeugenGeklickt");
        hatKnopfBeenden = new Knopf(150, 230, 100, 25, "Beenden");
        hatKnopfBeenden.setzeBearbeiterGeklickt("hatKnopfBeendenGeklickt");
    }

/**
 * Vorher: Ereignis GeklicktvonhatKnopfUeberzeugen fand statt.
 * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
 */
    public void hatKnopfUeberzeugenGeklickt()
    {
       int lZufall;
       int lProzentRot = hatTextfeldRote.inhaltAlsGanzeZahl();
       for(int i = 0; i < 50; i++)
       for(int j = 0; j < 50; i++)
       {lZufall = hatRechner.ganzeZufallszahl(1, 100);
        hatPerson[i][j] = new Person(210 + i *  12, 40 + j * 12, lZufall <= lProzentRot);
    }
    zSimuliert = true;
       
    }

/**
 * Vorher: Ereignis GeklicktvonhatKnopfBeenden fand statt.
 * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
 */
    public void hatKnopfBeendenGeklickt()
    {
        //    Schreiben Sie hier den Text ihres Dienstes
    }
    public void bearbeiteLeerlauf()
    {
        int 11H, 11V, 12H, 12V;
        
        if (zSimuliert)
        {
            11H = hatRechner.ganzeZufallszahl(0, 49);
            11V = hatRechner.ganzeZufallszahl(0, 49);
            12H = 0; 12V = 0;
            
            switch(hatRechner.ganzeZufallszahl(1,8))
            {
                case 1: 12H = 11H -1; 12V = 11V - 1; 
                break;
                case 2: 12H = 11H; 12V = 11V-1;
                break;
                case 3: 12H = 11H + 1; 12V = 11V - 1;
                break;
                case 4: 12H = 11H -1; 12V = 11V;
                break;
                case 4: 12H = 11H -1; 12V = 11V;

}
