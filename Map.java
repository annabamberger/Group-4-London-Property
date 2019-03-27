import javafx.application.Application;
import java.awt.image.BufferedImage;
import javafx.stage.*; 
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox; 
import javafx.scene.control.*; 
import javafx.scene.*;
import javafx.scene.layout.*; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import javafx.geometry.Insets;
import java.io.File;
import java.io.IOException;
import javafx.scene.shape.Polygon;
import javafx.scene.Group;
import javafx.scene.text.Text;
import javafx.scene.paint.*;
import java.util.*;

import com.opencsv.CSVReader;
import java.net.URISyntaxException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
/**
 * 
 * 
 * @author Yuhan Chen 
 * @2019.3.1
 */
public class Map extends Application
{
    private Stage stage;     
    private Label imageLabel; 
    //private StatisticsBox statisticsBox;
    private Statistics statistics;
    private AirbnbListing listing;

    /**
     * The main entry point for JavaFX programs.
     */
    
    public Map(Stage stage) 
    {
        Label mapLabel = new Label("It's the map of London.");
         ArrayList<AirbnbListing> listings = new ArrayList<AirbnbListing>();
   
        Button enfiButton = new Button("ENFI");
          enfiButton.setPrefSize(100,100);
          enfiButton.setOnAction(this::buttonClick);
        Polygon polygon = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        enfiButton.setShape(polygon);
        
       for(int i = 0; i<listings.size(); i++)
        {if(listings.get(i).getNeighbourhood().equals("Enfield")&& listings.get(i).getPrice()>200)
        {enfiButton.setBackground(new Background(new BackgroundFill(Color.RED,
        CornerRadii.EMPTY, Insets.EMPTY)));}}
       
        Group enf = new Group();
        enf.getChildren().add(enfiButton);
  
        Button barnButton = new Button("BARN");
          barnButton.setPrefSize(100,100);
        Polygon barnP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        barnButton.setShape(barnP);
        Group barn = new Group();
        barn.getChildren().add(barnButton);
        
        Button hrgyButton = new Button("HRGY");
          hrgyButton.setPrefSize(100,100);
        Polygon hrgyP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        hrgyButton.setShape(hrgyP);
        Group hrgy = new Group();
        hrgy.getChildren().add(hrgyButton);
        
            
        Button waltButton = new Button("WALT");
          waltButton.setPrefSize(100,100);
        Polygon waltP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        waltButton.setShape(waltP);
        Group walt = new Group();
        walt.getChildren().add(waltButton);
        
        Button hrrwButton = new Button("HRRW");
          hrrwButton.setPrefSize(100,100);
        Polygon hrrwP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        hrrwButton.setShape(hrrwP);
        Group hrrw = new Group();
        hrrw.getChildren().add(hrrwButton);
        
        Button brenButton = new Button("BREN");
          brenButton.setPrefSize(100,100);
        Polygon brenP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        brenButton.setShape(brenP);
        Group bren = new Group();
        bren.getChildren().add(brenButton);
        
        Button camdButton = new Button("CAMD");
          camdButton.setPrefSize(100,100);
        Polygon camdP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        camdButton.setShape(camdP);
        Group camd = new Group();
        camd.getChildren().add(camdButton);
        
        Button isliButton = new Button("ISLI");
          isliButton.setPrefSize(100,100);
        Polygon isliP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        isliButton.setShape(isliP);
        Group isli = new Group();
        isli.getChildren().add(isliButton);
        
        Button hackButton = new Button("HACK");
       hackButton.setPrefSize(100,100);
        Polygon hackP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        hackButton.setShape(hackP);
        Group hack = new Group();
        hack.getChildren().add(hackButton);
        
        Button redbButton = new Button("REDB");
          redbButton.setPrefSize(100,100);
        Polygon redbP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        redbButton.setShape(redbP);
        Group redb = new Group();
        redb.getChildren().add(redbButton);
        
        Button haveButton = new Button("HAVE");
          haveButton.setPrefSize(100,100);
        Polygon haveP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        haveButton.setShape(haveP);
        Group have = new Group();
        have.getChildren().add(haveButton);
        
        Button hillButton = new Button("HILL");
          hillButton.setPrefSize(100,100);
        Polygon hillP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        hillButton.setShape(hillP);
        Group hill = new Group();
        hill.getChildren().add(hillButton);
        
        Button ealiButton = new Button("EALI");
          ealiButton.setPrefSize(100,100);
        Polygon ealiP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        ealiButton.setShape(ealiP);
        Group eali = new Group();
        eali.getChildren().add(ealiButton);
        
        Button kensButton = new Button("KENS");
          kensButton.setPrefSize(100,100);
        Polygon kensP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        kensButton.setShape(kensP);
        Group kens = new Group();
        kens.getChildren().add(kensButton);
        
        Button wstmButton = new Button("WSTM");
          wstmButton.setPrefSize(100,100);
        Polygon wstmP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        wstmButton.setShape(wstmP);
        Group wstm= new Group();
        wstm.getChildren().add(wstmButton);
        
        Button towhButton = new Button("TOWH");
          towhButton.setPrefSize(100,100);
        Polygon towhP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        towhButton.setShape(towhP);
        Group towh = new Group();
        towh.getChildren().add(towhButton);
        
        Button newhButton = new Button("NEWH");
          newhButton.setPrefSize(100,100);
        Polygon newhP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        newhButton.setShape(newhP);
        Group newh = new Group();
        newh.getChildren().add(newhButton);
        
        Button barkButton = new Button("BARK");
          barkButton.setPrefSize(100,100);
        Polygon barkP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        barkButton.setShape(barkP);
        Group bark = new Group();
        bark.getChildren().add(barkButton);
        
        Button hounButton = new Button("HOUN");
          hounButton.setPrefSize(100,100);
        Polygon hounP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        hounButton.setShape(hounP);
        Group houn = new Group();
        houn.getChildren().add(hounButton);
        
        Button hammButton = new Button("HAMM");
          hammButton.setPrefSize(100,100);
        Polygon hammP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        hammButton.setShape(hammP);
        Group hamm = new Group();
        hamm.getChildren().add(hammButton);
        
        Button wandButton = new Button("WAND");
          wandButton.setPrefSize(100,100);
        Polygon wandP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        wandButton.setShape(wandP);
        Group wand = new Group();
        wand.getChildren().add(wandButton);
        
        Button cityButton = new Button("CITY");
          cityButton.setPrefSize(100,100);
        Polygon cityP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        cityButton.setShape(cityP);
        Group city = new Group();
        city.getChildren().add(cityButton);
        
        Button gwchButton = new Button("GWCH");
          gwchButton.setPrefSize(100,100);
        Polygon gwchP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        gwchButton.setShape(gwchP);
        Group gwch = new Group();
        gwch.getChildren().add(gwchButton);
        
        Button bexlButton = new Button("BEXL");
          bexlButton.setPrefSize(100,100);
        Polygon bexlP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        bexlButton.setShape(bexlP);
        Group bexl = new Group();
        bexl.getChildren().add(bexlButton);
        
        Button richButton = new Button("RICH");
          richButton.setPrefSize(100,100);
        Polygon richP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        richButton.setShape(richP);
        Group rich = new Group();
        rich.getChildren().add(richButton);
        
        Button mertButton = new Button("MERT");
          mertButton.setPrefSize(100,100);
        Polygon mertP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        mertButton.setShape(mertP);
        Group mert = new Group();
        mert.getChildren().add(mertButton);
        
        Button lambButton = new Button("LAMB");
          lambButton.setPrefSize(100,100);
        Polygon lambP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        lambButton.setShape(lambP);
        Group lamb = new Group();
        lamb.getChildren().add(lambButton);
        
        Button sthwButton = new Button("STHW");
          sthwButton.setPrefSize(100,100);
        Polygon sthwP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        sthwButton.setShape(sthwP);
        Group sthw = new Group();
        sthw.getChildren().add(sthwButton);
        
        Button lewsButton = new Button("LEWS");
          lewsButton.setPrefSize(100,100);
        Polygon lewsP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        lewsButton.setShape(lewsP);
        Group lews = new Group();
        lews.getChildren().add(lewsButton);
        
        Button kingButton = new Button("KING");
          kingButton.setPrefSize(100,100);
        Polygon kingP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        kingButton.setShape(kingP);
        Group king = new Group();
        king.getChildren().add(kingButton);
        
        Button suttButton = new Button("SUTT");
          suttButton.setPrefSize(100,100);
        Polygon suttP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        suttButton.setShape(suttP);
        Group sutt = new Group();
        sutt.getChildren().add(suttButton);
        
        Button croyButton = new Button("CROY");
          croyButton.setPrefSize(100,100);
        Polygon croyP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        croyButton.setShape(croyP);
        Group croy = new Group();
        croy.getChildren().add(croyButton);
        
        Button bromButton = new Button("BROM");
          bromButton.setPrefSize(100,100);
        Polygon bromP = new Polygon(new double[] 
            {175.0,45.0,225.0,45.0,
            265.0, 75.0, 265.0,125.0, 
            225.0, 155.0, 175.0,155.0,
            135.0, 125.0, 135.0,75.0});
        bromButton.setShape(bromP);
        Group brom = new Group();
        brom.getChildren().add(bromButton);
        
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.setMinSize(600,500);
        grid.setVgap(10);
        grid.setHgap(8);
        grid.getChildren().add(mapLabel);
        
      
        grid.addRow(0,enf);
        grid.addRow(1,barn,hrgy,walt);
        grid.addRow(2, hrrw,bren,camd,isli,hack,redb,have);
        grid.addRow(3, hill,eali,kens,wstm,towh,newh,bark);
        grid.addRow(4,houn,hamm,wand,city,gwch,bexl);
        grid.addRow(5, rich,mert,lamb,sthw,lews);
        grid.addRow(6, king,sutt,croy,brom);
        
        
       
        BorderPane root = new BorderPane(null,mapLabel,null, null,null);
       
        
        Scene scene = new Scene(grid, 800, 800);	
        
        stage.setTitle("Map");
        stage.setScene(scene);			
        stage.show();
        
    }   
    public static OFImage loadImage(String imageName)
    {Image image = new Image(imageName);
        if(image == null || image.isError()) {
            return null;
        }
        else {
            return new OFImage(image);           // OFImage is a writable image
        }
    }
    public void borough()
    {
        
        
    }   
    
    public void property()
    {
        
    }    
    public void buttonClick(ActionEvent event)
    {}
    public static void saveToFile(Image image)
    {File outPut = new File("C:JavaFX/");
        BufferedImage b  = SwingFXUtils.fromFXImage(image,null);
        try{ImageIO.write(b,"png", outPut);}
        catch (IOException e) {throw new RuntimeException(e);}
    }
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}
}