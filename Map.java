import javafx.application.Application;
import javafx.stage.Stage; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene; 
import javafx.scene.control.*; 
import javafx.scene.layout.*; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Insets;


/**
 * 在这里给出对类 Map 的描述
 * 
 * @author Yuhan Chen 
 * @2019.3.13
 */
public class Map extends Application
{
    private Stage stage;     
    private Label imageLabel; 
    private Statistics statistics;
    

    /**
     * The main entry point for JavaFX programs.
     */
    
    public void start(Stage stage) 
    {
        Label mapLabel = new Label("It's the map of London.");
        
        BorderPane root = new BorderPane();
        
        
        Image image = new Image("boroughs.png");			
        ImageView imageView = new ImageView();			
        imageView.setImage(image);
        root.setCenter(imageView);
        
        Button enfiButtom = new Button("ENFI");
        Button barnButtom = new Button("BARN");
        Button hrgyButtom = new Button("HRGY");
        Button waltButtom = new Button("WALT");
        Button hrrwButtom = new Button("HRRW");
        Button brenButtom = new Button("BREN");
        Button camdButtom = new Button("CAMD");
        Button isliButtom = new Button("ISLI");
        Button hackButtom = new Button("HACK");
        Button redbButtom = new Button("REDB");
        Button haveButtom = new Button("HAVE");
        Button hillButtom = new Button("HILL");
        Button ealiButtom = new Button("EALI");
        Button kensButtom = new Button("KENS");
        Button wstmButtom = new Button("WSTM");
        Button towhButtom = new Button("TOWH");
        Button newhButtom = new Button("NEWH");
        Button barkButtom = new Button("BARK");
        Button hounButtom = new Button("HOUN");
        Button hammButtom = new Button("HAMM");
        Button wandButtom = new Button("WAND");
        Button cityButtom = new Button("CITY");
        Button gwchButtom = new Button("GWCH");
        Button bexlButtom = new Button("BEXL");
        Button richButtom = new Button("RICH");
        Button mertButtom = new Button("MERT");
        Button lambButtom = new Button("LAMB");
        Button sthwButtom = new Button("STHW");
        Button lewsButtom = new Button("LEWS");
        Button kingButtom = new Button("KING");
        Button suttButtom = new Button("SUTT");
        Button croyButtom = new Button("CROY");
        Button bromButtom = new Button("BROM");
        
        GridPane grid = new GridPane();
        grid.setHgap(800);
        grid.setVgap(600);
        grid.getChildren().add(mapLabel);
        
        grid.add(enfiButtom,400,0);
        grid.add(barnButtom,250,90);
        grid.add(hrgyButtom,350,90);
        grid.add(waltButtom,450,90);
        grid.add(hrrwButtom,100,180);
        grid.add(brenButtom,200,180);
        grid.add(camdButtom,300,180);
        grid.add(isliButtom,400,180);
        grid.add(hackButtom,500,180);
        grid.add(redbButtom,600,180);
        grid.add(haveButtom,700,180);
        grid.add(hillButtom,50,270);
        grid.add(ealiButtom,150,270);
        grid.add(kensButtom,250,270);
        grid.add(wstmButtom,350,270);
        grid.add(towhButtom,450,270);
        grid.add(newhButtom,550,270);
        grid.add(barkButtom,650,270);
        grid.add(hounButtom,100,360);
        grid.add(hammButtom,200,360);
        grid.add(wandButtom,300,360);
        grid.add(cityButtom,400,360);
        grid.add(gwchButtom,500,360);
        grid.add(bexlButtom,600,360);
        grid.add(richButtom,150,450);
        grid.add(mertButtom,250,450);
        grid.add(lambButtom,350,450);
        grid.add(sthwButtom,450,450);
        grid.add(lewsButtom,550,450);
        grid.add(kingButtom,200,540);
        grid.add(suttButtom,300,540);
        grid.add(croyButtom,400,540);
        grid.add(bromButtom,500,540);
        
        
        
        Scene scene = new Scene(root,800,600);	
        
        stage.setTitle("Map");
        stage.setScene(scene);			
        stage.show();
        
    }
    
    public void borough()
    {
        
        
    }   
    
    public void property()
    {
        
    }    
    
    
}
