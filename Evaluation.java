

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
 * Write a description of JavaFX class Evaluation here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Evaluation extends Application
{
    // We keep track of the count, and label displaying the count:
    private File imageFile;
    private Label myLabel = new Label("0");

    @Override
    public void start(Stage stage) throws Exception
    {
       AnchorPane anchor = new AnchorPane();
       Button loadImage = new Button();
       loadImage.setOnAction(this::loadImage);
       AnchorPane.setTopAnchor(loadImage, 40.0);
       anchor.getChildren().add(loadImage);
       
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(anchor, 300,100);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void loadImage(ActionEvent event)
    {
      ImageFileManager manager = new ImageFileManager();
      manager.loadImage(imageFile);
    }
}
