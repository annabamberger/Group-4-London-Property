import javafx.collections.*;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.Iterator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.geometry.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Write a description of JavaFX class Statistics here.
 *
 * @author Anna Bamberger
 * @version (a version number or a date)
 */
public class Statistics extends Application
{
    // We keep track of the count, and label displaying the count:
    private GridPane grid;
    private BorderPane pane;
    private BorderPane reviewPane;
    private BorderPane expPane;
    private BorderPane aptPane;
    private Stage stage;
    private Stage newStage;
    private int row;
    private int col;
    private ArrayList<Node> storedNodes;
    private final int columnCount = 2;
    private final int rowCount = 2;
    

    @Override
    public void start(Stage stage)
    { 
        VBox statsBox = new VBox();
        statsBox.setSpacing(15);
        statsBox.setPadding(new Insets(10,10,10,10));
        
        Button forward = new Button(">");
        forward.setPrefSize(50,200);
        forward.setOnAction(this::nextStat);
        statsBox.getChildren().add(forward);
        
        VBox statsBox2 = new VBox();
        statsBox2.setSpacing(15);
        statsBox2.setPadding(new Insets(10,10,10,10));
        
        Button back = new Button("<");
        back.setPrefSize(50,200);
        back.setOnAction(this::nextStat);
        statsBox2.getChildren().add(back);
        
        Label statName = new Label("Number of Properties\n"+"         200");
        
        
        // Create a new grid pane
        BorderPane pane = new BorderPane(statName,null, statsBox, null,statsBox2);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        
        VBox reviewsBox = new VBox();
        reviewsBox.setSpacing(15);
        reviewsBox.setPadding(new Insets(10,10,10,10));
        
        Button forward1 = new Button(">");
        forward1.setPrefSize(50,200);
        forward1.setOnAction(this::nextStat);
        reviewsBox.getChildren().add(forward1);
        
        VBox reviewsBox2 = new VBox();
        reviewsBox2.setSpacing(15);
        reviewsBox2.setPadding(new Insets(10,10,10,10));
        
        Button back1 = new Button("<");
        back1.setPrefSize(50,200);
        back1.setOnAction(this::nextStat);
        reviewsBox2.getChildren().add(back1);
        
        Label reviews = new Label("Average number of reviews \n"+
        "per property  -  5");
        
        BorderPane reviewPane = new BorderPane(reviews, null, reviewsBox, null, reviewsBox2);
        reviewPane.setPadding(new Insets(10, 10, 10, 10));
        reviewPane.setMinSize(300, 300);
        
        VBox expBox = new VBox();
        expBox.setSpacing(15);
        expBox.setPadding(new Insets(10,10,10,10));
        
        Button forw = new Button(">");
        forw.setPrefSize(50,200);
        forw.setOnAction(this::nextStat);
        expBox.getChildren().add(forw);
        
        VBox expBox2 = new VBox();
        expBox2.setSpacing(15);
        expBox2.setPadding(new Insets(10,10,10,10));
        
        Button back2 = new Button("<");
        back2.setPrefSize(50,200);
        back2.setOnAction(this::nextStat);
        expBox2.getChildren().add(back2);
        
        Label expName = new Label
        ("Most expensive borough according to \n" + 
        "price per night and number \n" +
        "of minimum nights - Mayfair");
        
        // Create a new grid pane
        BorderPane expPane = new BorderPane(expName,null, expBox, null,expBox2);
        expPane.setPadding(new Insets(10, 10, 10, 10));
        expPane.setMinSize(300, 300);
     
        VBox aptBox = new VBox();
        aptBox.setSpacing(15);
        aptBox.setPadding(new Insets(10,10,10,10));
        
        Button next = new Button(">");
        next.setPrefSize(50,200);
        next.setOnAction(this::nextStat);
        aptBox.getChildren().add(next);
        
        VBox aptBox2 = new VBox();
        aptBox2.setSpacing(15);
        aptBox2.setPadding(new Insets(10,10,10,10));
        
        Button previous = new Button("<");
        previous.setPrefSize(50,200);
        previous.setOnAction(this::nextStat);
        aptBox2.getChildren().add(previous);
        
        Label aptName = new Label("Number of homes/apartments\n" +
        "vs single rooms  - 80"); 
        
        // Create a new grid pane
        BorderPane aptPane = new BorderPane(aptName,null, aptBox, null, aptBox2);
        aptPane.setPadding(new Insets(10, 10, 10, 10));
        aptPane.setMinSize(300, 300);
        
     
    
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(700,600);
        grid.setVgap(12);
        grid.setHgap(10);
        
        grid.add(pane,0,0);
        grid.add(reviewPane,1,0);
        grid.add(expPane,0,1);
        grid.add(aptPane, 1,1);
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(grid, 800, 600);
        stage.setTitle("");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
        
        
    }
   
    public void nextStat(ActionEvent event)
   {   Statistics stats = new Statistics();
       Stage newStage = new Stage();
       
       VBox largeBox = new VBox();
        largeBox.setSpacing(15);
        largeBox.setPadding(new Insets(10,10,10,10));
        
        Button next1 = new Button(">");
        next1.setPrefSize(50,200);
        next1.setOnAction(this::nextStat);
        largeBox.getChildren().add(next1);
        
        VBox largeBox2 = new VBox();
        largeBox2.setSpacing(15);
        largeBox2.setPadding(new Insets(10,10,10,10));
        
        Button previous1 = new Button("<");
        previous1.setPrefSize(50,200);
        previous1.setOnAction(this::nextStat);
        largeBox2.getChildren().add(previous1);
        
        Label largeName = new Label("Largest property on the\n"  +
        "market - Rosewood"); 
        
        // Create a new pane
        BorderPane largePane = new BorderPane(largeName,null, largeBox, null, largeBox2);
        largePane.setPadding(new Insets(10, 10, 10, 10));
        largePane.setMinSize(300, 300);
        
        VBox overseaBox = new VBox();
        overseaBox.setSpacing(15);
        overseaBox.setPadding(new Insets(10,10,10,10));
        
        Button nextO = new Button(">");
        nextO.setPrefSize(50,200);
        nextO.setOnAction(this::nextStat);
        overseaBox.getChildren().add(nextO);
        
        VBox overseaBox2 = new VBox();
        overseaBox2.setSpacing(15);
        overseaBox2.setPadding(new Insets(10,10,10,10));
        
        Button previousO = new Button("<");
        previousO.setPrefSize(50,200);
        previousO.setOnAction(this::nextStat);
        overseaBox2.getChildren().add(previousO);
        
        Label overseaName = new Label("Number of bookings from overseas\n" +
        "90"); 
        
        // Create a new pane
        BorderPane overseaPane = new BorderPane(overseaName,null, overseaBox, null, overseaBox2);
        overseaPane.setPadding(new Insets(10, 10, 10, 10));
        overseaPane.setMinSize(300, 300);
        
         
        //User's favorite property
            VBox favBox = new VBox();
        favBox.setSpacing(15);
        favBox.setPadding(new Insets(10,10,10,10));
        
        Button nextF = new Button(">");
        nextF.setPrefSize(50,200);
        nextF.setOnAction(this::nextStat);
        favBox.getChildren().add(nextF);
        
        VBox favBox2 = new VBox();
        favBox2.setSpacing(15);
        favBox2.setPadding(new Insets(10,10,10,10));
        
        Button previousF = new Button("<");
        previousF.setPrefSize(50,200);
        previousF.setOnAction(this::nextStat);
        favBox2.getChildren().add(previousF);
        
        Label favName = new Label("Users' favorite property\n" +
        "Arlington"); 
        
        // Create a new pane
        BorderPane favPane = new BorderPane(favName,null, favBox, null, favBox2);
        favPane.setPadding(new Insets(10, 10, 10, 10));
        favPane.setMinSize(300, 300);
        
        //Properties with outdoor space
            VBox outBox = new VBox();
        outBox.setSpacing(15);
        outBox.setPadding(new Insets(10,10,10,10));
        
        Button nextOut = new Button(">");
        nextOut.setPrefSize(50,200);
        nextOut.setOnAction(this::nextStat);
        outBox.getChildren().add(nextOut);
        
        VBox OutBox2 = new VBox();
        OutBox2.setSpacing(15);
        OutBox2.setPadding(new Insets(10,10,10,10));
        
        Button previousOut = new Button("<");
        previousOut.setPrefSize(50,200);
        previousOut.setOnAction(this::nextStat);
        OutBox2.getChildren().add(previousOut);
        
        Label OutName = new Label("Number of properties with\n" +
        "outdoor space  - 20"); 
        
        // Create a new pane
        BorderPane outPane = new BorderPane(OutName,null, outBox, null, OutBox2);
        outPane.setPadding(new Insets(10, 10, 10, 10));
        outPane.setMinSize(300, 300);
        
          GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setMinSize(700,600);
        grid.setVgap(12);
        grid.setHgap(10);
        grid.add(largePane, 0,0);
        grid.add(overseaPane,1,0);
        grid.add(favPane,0,1);
        grid.add(outPane, 1,1);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(grid, 800, 600);
        newStage.setTitle("");
        newStage.setScene(scene);

        // Show the Stage (window)
        newStage.show();
       }
   
    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
       
    }
}
