

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class DataOverseas here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DataOverseas extends Application
{private AirbnbDataLoader dataLoader;

    @Override
    public void start(Stage stage)
    {AirbnbDataLoader dataLoader = new AirbnbDataLoader();
        // Create a new grid pane
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        pane.setVgap(10);
        pane.setHgap(10);
        Label label = new Label(""+dataLoader.overseas());

        // Add the button and label into the pane
        pane.add(label, 1, 0);

        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(pane, 300,100);
        stage.setTitle("JavaFX Example");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }

}
