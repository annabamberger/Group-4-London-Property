

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.*;
import javafx.stage.FileChooser;
import javafx.scene.image.*;
import java.io.*;

// old Swing/AWT APIs and conversion APIs for saving the image to disk
import javafx.embed.swing.SwingFXUtils;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * The user can inquire about a specific listing meeting his requirements here.
 * User can also click to next page where he can upload details about his own 
 * property for potential future listing.
 *
 * @Anna Bamberger
 * @version (a version number or a date)
 */
public class Evaluation extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
       ScrollPane scrollPane = new ScrollPane();
       Label label = new Label("Property Listing Inquiry");
       
       //takes to new page where user's property can be loaded for appraisal for future listing
       Button list = new Button("Get your property listed!");
       list.setOnAction(this::buttonClick);
       
       HBox title = new HBox();
       title.getChildren().add(label);
       HBox listing = new HBox();
       listing.getChildren().add(list);
       
       BorderPane pane = new BorderPane();
       pane.setLeft(title);
       pane.setRight(listing);
       
       Button submit = new Button("submit");
       submit.setOnAction(this::buttonClick);
       BorderPane bottomPane = new BorderPane();
       bottomPane.setCenter(submit);
       
       //add all details required for booking here
       VBox center = new VBox();
       
       BorderPane root = new BorderPane(center, pane, null, bottomPane, null);
       scrollPane.setContent(root);
       
       scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
       scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);
       
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(scrollPane, 800,600);
        stage.setTitle("Property Inquiry Form");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
    public void buttonClick(ActionEvent event)
    {
    }
    
}
