
import java.util.List;
import java.util.ArrayList;
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
    private int row;
    private int col;

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
        statsBox2.getChildren().add(back);
        
        Label statName = new Label("Number of Properties");
        Label stat = new Label(); 
        
        // Create a new grid pane
        BorderPane pane = new BorderPane(statName,stat, statsBox, null,statsBox2);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setMinSize(300, 300);
        
        VBox reviewsBox = new VBox();
        reviewsBox.setSpacing(15);
        reviewsBox.setPadding(new Insets(10,10,10,10));
        
        Button forward1 = new Button(">");
        forward1.setPrefSize(50,200);
        reviewsBox.getChildren().add(forward1);
        
        VBox reviewsBox2 = new VBox();
        reviewsBox2.setSpacing(15);
        reviewsBox2.setPadding(new Insets(10,10,10,10));
        
        Button back1 = new Button("<");
        back1.setPrefSize(50,200);
        reviewsBox2.getChildren().add(back1);
        
        Label reviews = new Label("Average number of reviews \n"+
        "per property");
        Label rev = new Label();
        
        BorderPane reviewPane = new BorderPane(reviews, rev, reviewsBox, null, reviewsBox2);
        reviewPane.setPadding(new Insets(10, 10, 10, 10));
        reviewPane.setMinSize(300, 300);
        
        VBox expBox = new VBox();
        expBox.setSpacing(15);
        expBox.setPadding(new Insets(10,10,10,10));
        
        Button forw = new Button(">");
        forw.setPrefSize(50,200);
        expBox.getChildren().add(forw);
        
        VBox expBox2 = new VBox();
        expBox2.setSpacing(15);
        expBox2.setPadding(new Insets(10,10,10,10));
        
        Button back2 = new Button("<");
        back2.setPrefSize(50,200);
        expBox2.getChildren().add(back2);
        
        Label expName = new Label
        ("Most expensive borough according to \n" + 
        "price per night and number \n" +
        "of minimum nights");
        Label exp = new Label(); 
        
        // Create a new grid pane
        BorderPane expPane = new BorderPane(expName,exp, expBox, null,expBox2);
        expPane.setPadding(new Insets(10, 10, 10, 10));
        expPane.setMinSize(300, 300);
     
        VBox aptBox = new VBox();
        aptBox.setSpacing(15);
        aptBox.setPadding(new Insets(10,10,10,10));
        
        Button next = new Button(">");
        next.setPrefSize(50,200);
        aptBox.getChildren().add(next);
        
        VBox aptBox2 = new VBox();
        aptBox2.setSpacing(15);
        aptBox2.setPadding(new Insets(10,10,10,10));
        
        Button previous = new Button("<");
        previous.setPrefSize(50,200);
        aptBox2.getChildren().add(previous);
        
        Label aptName = new Label("Number of homes/apartments\n" +
        "vs single rooms");
        Label apt = new Label(); 
        
        // Create a new grid pane
        BorderPane aptPane = new BorderPane(aptName,apt, aptBox, null, aptBox2);
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
   { 
      List<Node> storedNodes = new ArrayList<>();
      for (Node child:grid.getChildren()){
        grid.getChildren().remove(child);
      
       
    }
     
    }
    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
       
    }
}
