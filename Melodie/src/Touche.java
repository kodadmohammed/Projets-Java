import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.effect.Light;
import javafx.scene.effect.Light.Distant;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Touche extends Parent {
    
    public String lettre;
    private int positionX = 0;
    private int positionY = 0;
    private int note = 0;
    Rectangle fond_touche;
    Text lettre_touche;
    private Instru instru;
    
    public Touche(String l, int posX, int posY, int n,Instru ins){
        lettre =  new String(l);
        positionX = posX;
        positionY = posY;
        note = n;
        instru=ins;
        
        fond_touche = new Rectangle(75,75,Color.LIGHTBLUE);
        fond_touche.setArcHeight(10);
        fond_touche.setArcWidth(10);
        this.getChildren().add(fond_touche);//ajout du rectangle de fond de la touche
        
        lettre_touche = new Text(lettre);
        lettre_touche.setFont(new Font(25));
        lettre_touche.setFill(Color.GREY);
        lettre_touche.setX(25);
        lettre_touche.setY(45);
        this.getChildren().add(lettre_touche);//ajout de la lettre de la touche
        Distant light = new Light.Distant();
        light.setAzimuth(-45.0);
        Lighting li = new Lighting();
        li.setLight(light);
        fond_touche.setEffect(li);
       
        this.setOnMouseClicked(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent me){
        		instru.note_on(note);
            }
        });
       
        this.setOnMouseExited(new EventHandler<MouseEvent>(){
        	public void handle(MouseEvent me){
        		instru.note_off(note);
            }
        });
        

        this.setTranslateX(positionX);//positionnement de la touche sur le clavier
        this.setTranslateY(positionY);
    }
    public void appuyer(){
        fond_touche.setFill(Color.DARKGREY);
        this.setTranslateY(positionY+2);
        instru.note_on(note);
    }
    
    public void relacher(){
        fond_touche.setFill(Color.WHITE);
        this.setTranslateY(positionY);
        instru.note_off(note);
    }

    
   

}
