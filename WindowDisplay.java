

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

/**
 * 
 *
 * @author (Li Peiyao)
 * @version (a version number or a date)
 */
public class WindowDisplay extends Application
{
    private int fromPrice = 0;
    private int toPrice = 0;
    

    @Override
    public void start(Stage stage) throws Exception
    {
        ChoiceBox fromBox = new ChoiceBox();
        fromBox.getItems().addAll(10, 30, 50, 80, 100, 150, 200);
        fromBox.setOnAction(ev -> fromPrice = (int)fromBox.getValue());
        ChoiceBox toBox = new ChoiceBox();
        toBox.getItems().addAll(30, 50, 80, 100, 150, 200, 250, 300, 400);
        toBox.setOnAction(ev -> toPrice = (int)toBox.getValue());
        
        Label fromLabel = new Label("From:");
        Label toLabel = new Label("To:");
        Label functionLabel = new Label("Select price range:");
        Button proceedButton = new Button("OK"); 
        proceedButton.setOnAction(this::okButtonClick);
        
        HBox pricePane = new HBox();
        pricePane.getChildren().addAll(functionLabel, fromLabel, fromBox, toLabel, toBox, proceedButton);
        pricePane.getStyleClass().add("pricepane");
        BorderPane topPane = new BorderPane();
        topPane.setRight(pricePane);
      
        Button forwardButton = new Button(">"); 
        Button backwardButton = new Button("<"); 
        
        BorderPane bottomPane = new BorderPane();
        bottomPane.setLeft(backwardButton);
        bottomPane.setRight(forwardButton);
        bottomPane.setId("bottompane");
        
        Label welcomeLabel = new Label("Welcome to the London Property Market!\n" + 
                                       "You can discover many kinds of properties in London boroughs here.\n" + 
                                       "\n" + "To begin with exploring the properties,\n" + 
                                       "You can select the price range first and press 'OK' to \n" + 
                                       "find out more information about the properties in that price range.");
        // Create a new border pane
        BorderPane root = new BorderPane(welcomeLabel, topPane, null, bottomPane, null);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root, 1000,700);
        scene.getStylesheets().add("welcome.css");
        stage.setTitle("London Property Market");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
 
    /**
     * 
     */
    private void okButtonClick(ActionEvent event)
    {  
        if(fromPrice == 0 || toPrice == 0){
            selectPriceAlert();
        }
        else if(fromPrice > toPrice){
            priceErrorAlert();
        }
        else{
            
        }
    }
    
    private void priceErrorAlert()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Select the price: Error");
        alert.setHeaderText("The price range you selected is invalid"); 
        alert.setContentText("Please select again to ensure that \n" + 
                             "the 'From' price is lower than the 'To' price.");
        alert.showAndWait();
    }
    
    private void selectPriceAlert()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Select the price: Error");
        alert.setHeaderText("The price range is empty."); 
        alert.setContentText("Please select the price range you wanted.");
        alert.showAndWait();
    }
}
