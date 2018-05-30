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
    private Textfeld hatTextfeld1;
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
        hatTextfeld1 = new Textfeld(250, 170, 100, 25, "");
        // Ausrichtung
        hatTextfeld1.setzeAusrichtung(Ausrichtung.LINKS);
        hatKnopfUeberzeugen = new Knopf(150, 200, 100, 25, "�berzeugen");
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
        //    Schreiben Sie hier den Text ihres Dienstes
    }

/**
 * Vorher: Ereignis GeklicktvonhatKnopfBeenden fand statt.
 * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
 */
    public void hatKnopfBeendenGeklickt()
    {
        //    Schreiben Sie hier den Text ihres Dienstes
    }

}
