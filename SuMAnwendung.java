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
    private boolean zSimuliert;
    private Rechner hatRechner;
    private Person[][] hatPerson;

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
        hatRechner = new Rechner();
        hatPerson = new Person[50][50];
    }

    /**
    * Vorher: Ereignis GeklicktvonhatKnopfUeberzeugen fand statt.
    * Nachher: Die Felder sind erzeugt
    */
    public void hatKnopfUeberzeugenGeklickt()
    {
       int lZufall;
       int lProzentRot = hatTextfeldRote.inhaltAlsGanzeZahl();
       Buntstift stift = new Buntstift();
       for(int i = 0; i < 50; i++)
       for(int j = 0; j < 50; i++)
       {lZufall = hatRechner.ganzeZufallszahl(1, 100);
        hatPerson[i][j] = new Person(210 + i *  12, 40 + j * 12, lZufall <= lProzentRot, stift);
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
        int l1H, l1V, l2H, l2V;
        int lUeberzeuger;
        if (zSimuliert)
        {
            l1H = hatRechner.ganzeZufallszahl(0, 49);
            l1V = hatRechner.ganzeZufallszahl(0, 49);
            l2H = 0; l2V = 0;
            
            switch(hatRechner.ganzeZufallszahl(1,8))
            {
                case 1: l2H = l1H -1; l2V = l1V - 1; 
                break;
                case 2: l2H = l1H; l2V = l1V-1;
                break;
                case 3: l2H = l1H + 1; l2V = l1V - 1;
                break;
                case 4: l2H = l1H - 1; l2V = l1V;
                break;
                case 5: l2H = l1H + 1; l2V = l1V;
                break;
                case 6: l2H = l1H - 1; l2V = l1V + 1;
                break;
                case 7: l2H = l1H; l2V = l1V + 1;
                break;
                case 8: l2H = l1H + 1; l2V = l1V +1;
                break;

            }
            if (l2H >= 0 && l2H < 50 && l2V>= 0 && l2V <50)
            {
                if(hatPerson[l1H][l1V].istRot() != hatPerson[l2H][l2V].istRot())
                {
                    lUeberzeuger = hatRechner.ganzeZufallszahl(0, 1);
                    if (lUeberzeuger == 0)
                        hatPerson[l1H][l1V].setzeRot(hatPerson[l2H][l2V].istRot());
                    else
                        hatPerson[l2H][l2V].setzeRot(hatPerson[l1H][l1V].istRot());
                }
            }
        }
}
}