import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Reflection;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class Clavier extends Parent{
    private Touche[] touches;
    private Instru instru;//on d�clare un objet de type Instru


public Clavier(Instru ins){
	  instru = ins;//l'objet de type Instru prend la valeur de l'objet pass� en param�tre
      
	touches = new Touche[]{
            new Touche("U",50,20,60,instru),
            new Touche("I",128,20,62,instru),
            new Touche("O",206,20,64,instru),
            new Touche("P",284,20,65,instru),
            new Touche("J",75,98,67,instru),
            new Touche("K",153,98,69,instru),
            new Touche("L",231,98,71,instru),
            new Touche("M",309,98,72,instru)
        };
        Rectangle fond_clavier = new Rectangle();
        fond_clavier.setWidth(400);
        fond_clavier.setHeight(200);
        fond_clavier.setArcWidth(30);
        fond_clavier.setArcHeight(30);
        fond_clavier.setFill( //on remplie notre rectangle avec un d�grad�
            new LinearGradient(0f, 0f, 0f, 1f, true, CycleMethod.NO_CYCLE,
                new Stop[] {
                    new Stop(0, Color.web("#333333")),
                    new Stop(1, Color.web("#000000"))
                }
            )
        );
        Reflection r = new Reflection();//on applique un effet de r�flection
        r.setFraction(0.25);      
        fond_clavier.setEffect(r);
        
        this.setTranslateX(50);
        this.setTranslateY(250);
        this.getChildren().add(fond_clavier);
        for (Touche touche: touches){
            this.getChildren().add(touche);
        }
        
        this.setOnKeyPressed(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                for (Touche touche: touches){
                    if( touche.lettre.equals( ke.getText().toUpperCase() ) )
                        touche.appuyer();
                }
            }
        });
        this.setOnKeyReleased(new EventHandler<KeyEvent>(){
            public void handle(KeyEvent ke){
                for (Touche touche: touches){
                    if(touche.lettre.equals( ke.getText().toUpperCase() ) )
                        touche.relacher();
                }
            }
        });

    }


}
