/**
 * Die Klasse SuMAnwendung wurde automatisch erstellt: 
 * 
 * @author 
 * @version 30.5.2018
 */

import sum.komponenten.*;
import sum.werkzeuge.*;
import sum.ereignis.*;

public class SuMAnwendung extends EBAnwendung implements Runnable
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
    private Thread t;
    private final int size = 100;

    // Attribute

/**
 * Konstruktor
 */
    public SuMAnwendung()
    {
        //Initialisierung der Oberklasse
        super(1699, 980);
        

        hatEtikettDemokratur = new Etikett(256, 10, 100, 25, "Demokratur");
        hatEtikettDemokratur.setzeAusrichtung(Ausrichtung.LINKS);
        
        hatEtikettProzentsatzRote = new Etikett(50, 170, 100, 25, "Prozentsatz Rote");
        hatEtikettProzentsatzRote.setzeAusrichtung(Ausrichtung.LINKS);
        
        hatTextfeldRote = new Textfeld(50, 170, 100, 25, "");
        hatTextfeldRote.setzeAusrichtung(Ausrichtung.LINKS);
        hatTextfeldRote.setzeInhalt("Prozentanteil Rot");
        
        hatKnopfUeberzeugen = new Knopf(50, 200, 100, 25, "Ueberzeugen");
        hatKnopfUeberzeugen.setzeBearbeiterGeklickt("hatKnopfUeberzeugenGeklickt");
        
        hatKnopfBeenden = new Knopf(50, 230, 100, 25, "Beenden");
        hatKnopfBeenden.setzeBearbeiterGeklickt("hatKnopfBeendenGeklickt");
        
        hatRechner = new Rechner();
        hatPerson = new Person[size][size];
        
        t = new Thread(this);
        t.start();

    }

    public void run() {
        while(true) {
            try {
                this.bearbeiteLeerlauf();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                
            }
        }
    }
    
/**
* Vorher: Ereignis GeklicktvonhatKnopfUeberzeugen fand statt.
* Nachher: Die Felder sind erzeugt
*/
public void hatKnopfUeberzeugenGeklickt()
{
       int lZufall;
       int lProzentRot = hatTextfeldRote.inhaltAlsGanzeZahl();
       int l1H, l1V, l2H, l2V;
       int lUeberzeuger;
       Buntstift stift = new Buntstift();
       stift.setzeFuellmuster(Muster.GEFUELLT);
       for(int i = 0; i < size; i++)
       for(int j = 0; j < size; j++)
       {
           lZufall = hatRechner.ganzeZufallszahl(1, 100);
           hatPerson[i][j] = new Person(210 + i *  12, 40 + j * 12, lZufall <= lProzentRot, stift);
       }
       
       zSimuliert = true;
       /* while(true) {
           if (zSimuliert)
           {
                l1H = hatRechner.ganzeZufallszahl(0, 19);
                l1V = hatRechner.ganzeZufallszahl(0, 19);
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
                if (l2H >= 0 && l2H < 20 && l2V>= 0 && l2V < 20)
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
           try {
            Thread.sleep(1000);
           } catch (InterruptedException e) {
            }
        } */
} 

/**
 * Vorher: Ereignis GeklicktvonhatKnopfBeenden fand statt.
 * Nachher: (schreiben Sie, was in dieser Methode ausgefuehrt wird)
 */
    public void hatKnopfBeendenGeklickt()
    {
        //    Schreiben Sie hier den Text ihres Dienstes
        t.stop();
        this.beenden();
    }
    public void bearbeiteLeerlauf()
    {
        int l1H, l1V, l2H, l2V;
        int lUeberzeuger;
        if (zSimuliert)
        {
            l1H = hatRechner.ganzeZufallszahl(0, size-1);
            l1V = hatRechner.ganzeZufallszahl(0, size-1);
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
            if (l2H >= 0 && l2H < size && l2V>= 0 && l2V < size)
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