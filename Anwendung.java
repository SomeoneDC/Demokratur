

import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;
//import java.util.Random;
import sum.werkzeuge.*;
import java.lang.*;



import sum.ereignis.*;

/**
 * Write a description of JavaFX class Anwendung here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Anwendung extends Application implements Runnable
{
    // We keep track of the count, and label displaying the count:
    private GridPane pane;
    TextField txtPercent;
    
    private boolean zSimuliert;
    private Rechner hatRechner;
    Person[][] hatPerson;
    private Thread updater;
    private final int size = 100;
    private final int mode = 1;
    

    @Override
    public void start(Stage stage) throws Exception
    {
        //random = new Random();
        
        
        hatPerson = new Person[size][size];
        hatRechner = new Rechner();
        
        updater = new Thread(this);
        updater.start();
        
        //Toolbar
        ToolBar toolbar_actions = new ToolBar();
        
        //Toolbar Items
        Button myButton = new Button("Count");
        Button btnStart = new Button("Starten");
        Button btnStop = new Button("Beenden");
        Label lbPercent = new Label("Anteil Rot:");
        txtPercent = new TextField();

        // Create a new grid pane
        pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(1);
        pane.setHgap(1);
        

        //set an action on the button using method reference
        btnStart.setOnAction(this::buttonClick);
        btnStop.setOnAction(this::btnStopClick);

        // Add the button and label into the pane
        toolbar_actions.getItems().addAll(new Separator(), lbPercent, txtPercent, new Separator(), btnStart, new Separator(), btnStop);
        
        
        
        BorderPane global = new BorderPane();
        global.setTop(toolbar_actions);
        global.setLeft(pane);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(global, 300,100);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);
        stage.setHeight(1000);
        stage.setWidth(1000);

        // Show the Stage (window)
        stage.show();
    }
    
    public void run() {
        while(true) {
            try { 
            this.bearbeiteLeerlauf();
             Thread.sleep(1);
            } catch (Exception e) {
                
            }
        }
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
       int lZufall;
       int lProzentRot = Integer.parseInt(txtPercent.getCharacters().toString());
       Buntstift stift = new Buntstift();
       stift.setzeFuellmuster(Muster.GEFUELLT);
       for(int i = 0; i < size; i++)
       for(int j = 0; j < size; j++)
       {
           lZufall = hatRechner.ganzeZufallszahl(1, 100);
               
               hatPerson[i][j] = new Person(i,j, lZufall <= lProzentRot, pane);
               
           
       }
       
    }
    
    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void btnStopClick(ActionEvent event)
    {
       updater.stop();
       Platform.exit();
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
