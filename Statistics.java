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
    private Scene scene2, scene3, scene4, scene5, scene6, scene7, scene8;
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
        forward.setOnAction(e->stage.setScene(scene2));
        statsBox.getChildren().add(forward);
        
        VBox statsBox2 = new VBox();
        statsBox2.setSpacing(15);
        statsBox2.setPadding(new Insets(10,10,10,10));
        
        Button back = new Button("<");
        back.setPrefSize(50,200);
        back.setOnAction(e->stage.setScene(scene8));
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
        forward1.setOnAction(e->stage.setScene(scene2));
        reviewsBox.getChildren().add(forward1);
        
        VBox reviewsBox2 = new VBox();
        reviewsBox2.setSpacing(15);
        reviewsBox2.setPadding(new Insets(10,10,10,10));
        
        Button back1 = new Button("<");
        back1.setPrefSize(50,200);
        back1.setOnAction(e->stage.setScene(scene8));
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
        forw.setOnAction(e->stage.setScene(scene2));
        expBox.getChildren().add(forw);
        
        VBox expBox2 = new VBox();
        expBox2.setSpacing(15);
        expBox2.setPadding(new Insets(10,10,10,10));
        
        Button back2 = new Button("<");
        back2.setPrefSize(50,200);
        back2.setOnAction(e->stage.setScene(scene8));
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
        next.setOnAction(e->stage.setScene(scene2));
        aptBox.getChildren().add(next);
        
        VBox aptBox2 = new VBox();
        aptBox2.setSpacing(15);
        aptBox2.setPadding(new Insets(10,10,10,10));
        
        Button previous = new Button("<");
        previous.setPrefSize(50,200);
        previous.setOnAction(e->stage.setScene(scene8));
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
        
     
        
        VBox reviewsBoxSc2 = new VBox();
        reviewsBoxSc2.setSpacing(15);
        reviewsBoxSc2.setPadding(new Insets(10,10,10,10));
        
        Button forwardSc1 = new Button(">");
        forwardSc1.setPrefSize(50,200);
        forwardSc1.setOnAction(e->stage.setScene(scene3));
        reviewsBoxSc2.getChildren().add(forwardSc1);
        
        VBox reviewsBox2Sc = new VBox();
        reviewsBox2Sc.setSpacing(15);
        reviewsBox2Sc.setPadding(new Insets(10,10,10,10));
        
        Button back1Sc = new Button("<");
        back1Sc.setPrefSize(50,200);
        back1Sc.setOnAction(e->stage.setScene(scene));
        reviewsBox2Sc.getChildren().add(back1Sc);
        
        Label reviews1 = new Label("Average number of reviews \n"+
        "per property  -  5");
        
        BorderPane reviewPane1 = new BorderPane(reviews1, null, reviewsBoxSc2, null, reviewsBox2Sc);
        reviewPane1.setPadding(new Insets(10, 10, 10, 10));
        reviewPane1.setMinSize(300, 300);
        
        VBox exp2 = new VBox();
        exp2.setSpacing(15);
        exp2.setPadding(new Insets(10,10,10,10));
        
        Button forw2 = new Button(">");
        forw2.setPrefSize(50,200);
        forw2.setOnAction(e->stage.setScene(scene3));
        exp2.getChildren().add(forw2);
        
        VBox expBox21 = new VBox();
        expBox21.setSpacing(15);
        expBox21.setPadding(new Insets(10,10,10,10));
        
        Button back21 = new Button("<");
        back21.setPrefSize(50,200);
        back21.setOnAction(e->stage.setScene(scene));
        expBox21.getChildren().add(back21);
        
        Label expName1 = new Label
        ("Most expensive borough according to \n" + 
        "price per night and number \n" +
        "of minimum nights - Mayfair");
        
        // Create a new grid pane
        BorderPane expPane1 = new BorderPane(expName1,null, exp2, null,expBox21);
        expPane1.setPadding(new Insets(10, 10, 10, 10));
        expPane1.setMinSize(300, 300);
     
        VBox aptBox1 = new VBox();
        aptBox1.setSpacing(15);
        aptBox1.setPadding(new Insets(10,10,10,10));
        
        Button next1 = new Button(">");
        next1.setPrefSize(50,200);
        next1.setOnAction(e->stage.setScene(scene3));
        aptBox1.getChildren().add(next1);
        
        VBox aptBox21 = new VBox();
        aptBox21.setSpacing(15);
        aptBox21.setPadding(new Insets(10,10,10,10));
        
        Button previous1 = new Button("<");
        previous1.setPrefSize(50,200);
        previous1.setOnAction(e->stage.setScene(scene));
        aptBox21.getChildren().add(previous1);
        
        Label aptName1 = new Label("Number of homes/apartments\n" +
        "vs single rooms  - 80"); 
        
        // Create a new grid pane
        BorderPane aptPane1 = new BorderPane(aptName1,null, aptBox1, null, aptBox21);
        aptPane1.setMinSize(300, 300);
        aptPane1.setPadding(new Insets(10, 10, 10, 10));
        
        VBox largeBox = new VBox();
        largeBox.setSpacing(15);
        largeBox.setPadding(new Insets(10,10,10,10));
        
        Button large1 = new Button(">");
        large1.setPrefSize(50,200);
        large1.setOnAction(e->stage.setScene(scene3));
        largeBox.getChildren().add(large1);
        
        VBox largeBox2 = new VBox();
        largeBox2.setSpacing(15);
        largeBox2.setPadding(new Insets(10,10,10,10));
        
        Button large2 = new Button("<");
        large2.setPrefSize(50,200);
        large2.setOnAction(e->stage.setScene(scene));
        largeBox2.getChildren().add(large2);
        
        Label largeName = new Label("Largest property on the\n"  +
        "market - Rosewood"); 
        
        // Create a new pane
        BorderPane largePane = new BorderPane(largeName,null, largeBox, null, largeBox2);
        largePane.setPadding(new Insets(10, 10, 10, 10));
        largePane.setMinSize(300, 300);
    
        GridPane grid1 = new GridPane();
        grid1.setPadding(new Insets(10, 10, 10, 10));
        grid1.setMinSize(700,600);
        grid1.setVgap(12);
        grid1.setHgap(10);
        
        grid1.add(reviewPane1,0,0);
        grid1.add(expPane1,1,0);
        grid1.add(aptPane1,0,1);
        grid1.add(largePane,1,1);
        
        
        scene2 = new Scene(grid1, 800, 600);
        
        VBox expBox3 = new VBox();
        expBox3.setSpacing(15);
        expBox3.setPadding(new Insets(10,10,10,10));
        
        Button forw3 = new Button(">");
        forw3.setPrefSize(50,200);
        forw3.setOnAction(e->stage.setScene(scene4));
        expBox3.getChildren().add(forw3);
        
        VBox expBox31 = new VBox();
        expBox31.setSpacing(15);
        expBox31.setPadding(new Insets(10,10,10,10));
        
        Button back31 = new Button("<");
        back31.setPrefSize(50,200);
        back31.setOnAction(e->stage.setScene(scene2));
        expBox31.getChildren().add(back31);
        
        Label expName3 = new Label
        ("Most expensive borough according to \n" + 
        "price per night and number \n" +
        "of minimum nights - Mayfair");
        
        // Create a new grid pane
        BorderPane expPane3 = new BorderPane(expName3,null, expBox3, null,expBox31);
        expPane3.setPadding(new Insets(10, 10, 10, 10));
        expPane3.setMinSize(300, 300);
     
        VBox aptBox3 = new VBox();
        aptBox3.setSpacing(15);
        aptBox3.setPadding(new Insets(10,10,10,10));
        
        Button next3 = new Button(">");
        next3.setPrefSize(50,200);
        next3.setOnAction(e->stage.setScene(scene4));
        aptBox3.getChildren().add(next3);
        
        VBox aptBox31 = new VBox();
        aptBox31.setSpacing(15);
        aptBox31.setPadding(new Insets(10,10,10,10));
        
        Button previous3 = new Button("<");
        previous3.setPrefSize(50,200);
        previous3.setOnAction(e->stage.setScene(scene2));
        aptBox31.getChildren().add(previous3);
        
        Label aptName3 = new Label("Number of homes/apartments\n" +
        "vs single rooms  - 80"); 
        
        // Create a new grid pane
        BorderPane aptPane3 = new BorderPane(aptName3,null, aptBox3, null, aptBox31);
        aptPane3.setPadding(new Insets(10, 10, 10, 10));
        aptPane3.setMinSize(300, 300);
        
        VBox largeBox3 = new VBox();
        largeBox3.setSpacing(15);
        largeBox3.setPadding(new Insets(10,10,10,10));
        
        Button large3 = new Button(">");
        large3.setPrefSize(50,200);
        large3.setOnAction(e->stage.setScene(scene4));
        largeBox3.getChildren().add(large3);
        
        VBox largeBox31 = new VBox();
        largeBox31.setSpacing(15);
        largeBox31.setPadding(new Insets(10,10,10,10));
        
        Button large31 = new Button("<");
        large31.setPrefSize(50,200);
        large31.setOnAction(e->stage.setScene(scene5));
        largeBox31.getChildren().add(large31);
        
        Label largeName3 = new Label("Largest property on the\n"  +
        "market - Rosewood"); 
        
        // Create a new pane
        BorderPane largePane3 = new BorderPane(largeName3,null, largeBox3, null, largeBox31);
        largePane3.setPadding(new Insets(10, 10, 10, 10));
        largePane3.setMinSize(300, 300);
    
        VBox overseaBox = new VBox();
        overseaBox.setSpacing(15);
        overseaBox.setPadding(new Insets(10,10,10,10));
        
        Button nextO = new Button(">");
        nextO.setPrefSize(50,200);
        nextO.setOnAction(e->stage.setScene(scene4));
        overseaBox.getChildren().add(nextO);
        
        VBox overseaBox2 = new VBox();
        overseaBox2.setSpacing(15);
        overseaBox2.setPadding(new Insets(10,10,10,10));
        
        Button previousO = new Button("<");
        previousO.setPrefSize(50,200);
        previousO.setOnAction(e->stage.setScene(scene2));
        overseaBox2.getChildren().add(previousO);
        
        Label overseaName = new Label("Number of bookings from overseas\n" +
        "90"); 
        
        // Create a new pane
        BorderPane overseaPane = new BorderPane(overseaName,null, overseaBox, null, overseaBox2);
        overseaPane.setPadding(new Insets(10, 10, 10, 10));
        overseaPane.setMinSize(300, 300);
        
        GridPane grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setMinSize(700,600);
        grid2.setVgap(12);
        grid2.setHgap(10);
        
        grid2.add(expPane3,0,0);
        grid2.add(largePane3,0,1);
        grid2.add(aptPane3,1,0);
        grid2.add(overseaPane,1,1);
        
        
        scene3 = new Scene(grid2, 800,600);
        
           
        VBox apt4 = new VBox();
        apt4.setSpacing(15);
        apt4.setPadding(new Insets(10,10,10,10));
        
        Button next4 = new Button(">");
        next4.setPrefSize(50,200);
        next4.setOnAction(e->stage.setScene(scene5));
        apt4.getChildren().add(next4);
        
        VBox aptBox4 = new VBox();
        aptBox4.setSpacing(15);
        aptBox4.setPadding(new Insets(10,10,10,10));
        
        Button previous4 = new Button("<");
        previous4.setPrefSize(50,200);
        previous4.setOnAction(e->stage.setScene(scene3));
        aptBox4.getChildren().add(previous4);
        
        Label aptName4 = new Label("Number of homes/apartments\n" +
        "vs single rooms  - 80"); 
        
        // Create a new grid pane
        BorderPane aptPane4 = new BorderPane(aptName4,null, apt4, null, aptBox4);
        aptPane4.setPadding(new Insets(10, 10, 10, 10));
        aptPane4.setMinSize(300, 300);
        
        VBox largeBox4 = new VBox();
        largeBox4.setSpacing(15);
        largeBox4.setPadding(new Insets(10,10,10,10));
        
        Button large4 = new Button(">");
        large4.setPrefSize(50,200);
        large4.setOnAction(e->stage.setScene(scene5));
        largeBox4.getChildren().add(large4);
        
        VBox largeBox41 = new VBox();
        largeBox41.setSpacing(15);
        largeBox41.setPadding(new Insets(10,10,10,10));
        
        Button large41 = new Button("<");
        large41.setPrefSize(50,200);
        large41.setOnAction(e->stage.setScene(scene3));
        largeBox41.getChildren().add(large41);
        
        Label largeName4 = new Label("Largest property on the\n"  +
        "market - Rosewood"); 
        
        // Create a new pane
        BorderPane largePane4 = new BorderPane(largeName4,null, largeBox4, null, largeBox41);
        largePane4.setPadding(new Insets(10, 10, 10, 10));
        largePane4.setMinSize(300, 300);
    
        VBox overseaBox4 = new VBox();
        overseaBox4.setSpacing(15);
        overseaBox4.setPadding(new Insets(10,10,10,10));
        
        Button nextO4 = new Button(">");
        nextO4.setPrefSize(50,200);
        nextO4.setOnAction(e->stage.setScene(scene5));
        overseaBox4.getChildren().add(nextO4);
        
        VBox overseaBox24 = new VBox();
        overseaBox24.setSpacing(15);
        overseaBox24.setPadding(new Insets(10,10,10,10));
        
        Button previousO4 = new Button("<");
        previousO4.setPrefSize(50,200);
        previousO4.setOnAction(e->stage.setScene(scene3));
        overseaBox24.getChildren().add(previousO4);
        
        Label overseaName4 = new Label("Number of bookings from overseas\n" +
        "90"); 
        
        // Create a new pane
        BorderPane overseaPane4 = new BorderPane(overseaName4,null, overseaBox4, null, overseaBox24);
        overseaPane4.setPadding(new Insets(10, 10, 10, 10));
        overseaPane4.setMinSize(300, 300);
     
          //User's favorite property
        VBox favBox = new VBox();
        favBox.setSpacing(15);
        favBox.setPadding(new Insets(10,10,10,10));
        
        Button nextF = new Button(">");
        nextF.setPrefSize(50,200);
        nextF.setOnAction(e->stage.setScene(scene5));
        favBox.getChildren().add(nextF);
        
        VBox favBox2 = new VBox();
        favBox2.setSpacing(15);
        favBox2.setPadding(new Insets(10,10,10,10));
        
        Button previousF = new Button("<");
        previousF.setPrefSize(50,200);
        previousF.setOnAction(e->stage.setScene(scene3));
        favBox2.getChildren().add(previousF);
        
        Label favName = new Label("Users' favorite property\n" +
        "Arlington"); 
        
        // Create a new pane
        BorderPane favPane = new BorderPane(favName,null, favBox, null, favBox2);
        favPane.setPadding(new Insets(10, 10, 10, 10));
        favPane.setMinSize(300, 300);
        
           
        GridPane grid3 = new GridPane();
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid3.setMinSize(700,600);
        grid3.setVgap(12);
        grid3.setHgap(10);
        
        grid3.add(aptPane4,0,0);
        grid3.add(overseaPane4,0,1);
        grid3.add(largePane4,1,0);
        grid3.add(favPane,1,1);
        
        
        scene4 = new Scene(grid3, 800,600);
        
        VBox largeBox5 = new VBox();
        largeBox5.setSpacing(15);
        largeBox5.setPadding(new Insets(10,10,10,10));
        
        Button large5 = new Button(">");
        large5.setPrefSize(50,200);
        large5.setOnAction(e->stage.setScene(scene6));
        largeBox5.getChildren().add(large5);
        
        VBox largeBox51 = new VBox();
        largeBox51.setSpacing(15);
        largeBox51.setPadding(new Insets(10,10,10,10));
        
        Button large51 = new Button("<");
        large51.setPrefSize(50,200);
        large51.setOnAction(e->stage.setScene(scene4));
        largeBox51.getChildren().add(large51);
        
        Label largeName5 = new Label("Largest property on the\n"  +
        "market - Rosewood"); 
        
        // Create a new pane
        BorderPane largePane5 = new BorderPane(largeName5,null, largeBox5, null, largeBox51);
        largePane5.setPadding(new Insets(10, 10, 10, 10));
        largePane5.setMinSize(300, 300);
    
        VBox overseaBox5 = new VBox();
        overseaBox5.setSpacing(15);
        overseaBox5.setPadding(new Insets(10,10,10,10));
        
        Button nextO5 = new Button(">");
        nextO5.setPrefSize(50,200);
        nextO5.setOnAction(e->stage.setScene(scene6));
        overseaBox5.getChildren().add(nextO5);
        
        VBox overseaBox54 = new VBox();
        overseaBox54.setSpacing(15);
        overseaBox54.setPadding(new Insets(10,10,10,10));
        
        Button previousO5 = new Button("<");
        previousO5.setPrefSize(50,200);
        previousO5.setOnAction(e->stage.setScene(scene4));
        overseaBox54.getChildren().add(previousO5);
        
        Label overseaName5 = new Label("Number of bookings from overseas\n" +
        "90"); 
        
        // Create a new pane
        BorderPane overseaPane5 = new BorderPane(overseaName5,null, overseaBox5, null, overseaBox54);
        overseaPane5.setPadding(new Insets(10, 10, 10, 10));
        overseaPane5.setMinSize(300, 300);
     
          //User's favorite property
        VBox favBox5 = new VBox();
        favBox5.setSpacing(15);
        favBox5.setPadding(new Insets(10,10,10,10));
        
        Button nextF5 = new Button(">");
        nextF5.setPrefSize(50,200);
        nextF5.setOnAction(e->stage.setScene(scene6));
        favBox5.getChildren().add(nextF5);
        
        VBox favBox51 = new VBox();
        favBox51.setSpacing(15);
        favBox51.setPadding(new Insets(10,10,10,10));
        
        Button previousF5 = new Button("<");
        previousF5.setPrefSize(50,200);
        previousF5.setOnAction(e->stage.setScene(scene4));
        favBox51.getChildren().add(previousF5);
        
        Label favName5 = new Label("Users' favorite property\n" +
        "Arlington"); 
        
        // Create a new pane
        BorderPane favPane5 = new BorderPane(favName5,null, favBox5, null, favBox51);
        favPane5.setPadding(new Insets(10, 10, 10, 10));
        favPane5.setMinSize(300, 300);
        
           //Properties with outdoor space
            VBox outBox = new VBox();
        outBox.setSpacing(15);
        outBox.setPadding(new Insets(10,10,10,10));
        
        Button nextOut = new Button(">");
        nextOut.setPrefSize(50,200);
        nextOut.setOnAction(e->stage.setScene(scene6));
        outBox.getChildren().add(nextOut);
        
        VBox OutBox2 = new VBox();
        OutBox2.setSpacing(15);
        OutBox2.setPadding(new Insets(10,10,10,10));
        
        Button previousOut = new Button("<");
        previousOut.setPrefSize(50,200);
        previousOut.setOnAction(e->stage.setScene(scene4));
        OutBox2.getChildren().add(previousOut);
        
        Label OutName = new Label("Number of properties with\n" +
        "outdoor space  - 20"); 
        
        // Create a new pane
        BorderPane outPane = new BorderPane(OutName,null, outBox, null, OutBox2);
        outPane.setPadding(new Insets(10, 10, 10, 10));
        outPane.setMinSize(300, 300);
        
        GridPane grid4 = new GridPane();
        grid4.setPadding(new Insets(10, 10, 10, 10));
        grid4.setMinSize(700,600);
        grid4.setVgap(12);
        grid4.setHgap(10);
        
        grid4.add(largePane5,0,0);
        grid4.add(favPane5,0,1);
        grid4.add(overseaPane5,1,0);
        grid4.add(outPane,1,1);
        
        
        scene5 = new Scene(grid4, 800,600);
        
        VBox overseaBox6 = new VBox();
        overseaBox6.setSpacing(15);
        overseaBox6.setPadding(new Insets(10,10,10,10));
        
        Button nextO6 = new Button(">");
        nextO6.setPrefSize(50,200);
        nextO6.setOnAction(e->stage.setScene(scene7));
        overseaBox6.getChildren().add(nextO6);
        
        VBox overseaBox64 = new VBox();
        overseaBox64.setSpacing(15);
        overseaBox64.setPadding(new Insets(10,10,10,10));
        
        Button previousO6 = new Button("<");
        previousO6.setPrefSize(50,200);
        previousO6.setOnAction(e->stage.setScene(scene5));
        overseaBox64.getChildren().add(previousO6);
        
        Label overseaName6 = new Label("Number of bookings from overseas\n" +
        "90"); 
        
        // Create a new pane
        BorderPane overseaPane6 = new BorderPane(overseaName6,null, overseaBox6, null, overseaBox64);
        overseaPane6.setPadding(new Insets(10, 10, 10, 10));
        overseaPane6.setMinSize(300, 300);
     
          //User's favorite property
        VBox favBox6 = new VBox();
        favBox6.setSpacing(15);
        favBox6.setPadding(new Insets(10,10,10,10));
        
        Button nextF6 = new Button(">");
        nextF6.setPrefSize(50,200);
        nextF6.setOnAction(e->stage.setScene(scene7));
        favBox6.getChildren().add(nextF6);
        
        VBox favBox61 = new VBox();
        favBox61.setSpacing(15);
        favBox61.setPadding(new Insets(10,10,10,10));
        
        Button previousF6 = new Button("<");
        previousF6.setPrefSize(50,200);
        previousF6.setOnAction(e->stage.setScene(scene5));
        favBox61.getChildren().add(previousF6);
        
        Label favName6 = new Label("Users' favorite property\n" +
        "Arlington"); 
        
        // Create a new pane
        BorderPane favPane6 = new BorderPane(favName6,null, favBox6, null, favBox61);
        favPane6.setPadding(new Insets(10, 10, 10, 10));
        favPane6.setMinSize(300, 300);
        
           //Properties with outdoor space
            VBox outBox6 = new VBox();
        outBox6.setSpacing(15);
        outBox6.setPadding(new Insets(10,10,10,10));
        
        Button nextOut6 = new Button(">");
        nextOut6.setPrefSize(50,200);
        nextOut6.setOnAction(e->stage.setScene(scene7));
        outBox6.getChildren().add(nextOut6);
        
        VBox OutBox6 = new VBox();
        OutBox6.setSpacing(15);
        OutBox6.setPadding(new Insets(10,10,10,10));
        
        Button previousOut6 = new Button("<");
        previousOut6.setPrefSize(50,200);
        previousOut6.setOnAction(e->stage.setScene(scene5));
        OutBox6.getChildren().add(previousOut6);
        
        Label OutName6 = new Label("Number of properties with\n" +
        "outdoor space  - 20"); 
        
        // Create a new pane
        BorderPane outPane6 = new BorderPane(OutName6,null, outBox6, null, OutBox6);
        outPane6.setPadding(new Insets(10, 10, 10, 10));
        outPane6.setMinSize(300, 300);
        
         VBox statsBox6 = new VBox();
        statsBox6.setSpacing(15);
        statsBox6.setPadding(new Insets(10,10,10,10));
        
        Button forward6 = new Button(">");
        forward6.setPrefSize(50,200);
        forward6.setOnAction(e->stage.setScene(scene7));
        statsBox6.getChildren().add(forward6);
        
        VBox statsBox26 = new VBox();
        statsBox26.setSpacing(15);
        statsBox26.setPadding(new Insets(10,10,10,10));
        
        Button back6 = new Button("<");
        back6.setPrefSize(50,200);
        back6.setOnAction(e->stage.setScene(scene5));
        statsBox26.getChildren().add(back6);
        
        Label statName6 = new Label("Number of Properties\n"+"         200");
        
        
        // Create a new grid pane
        BorderPane pane6 = new BorderPane(statName6,null, statsBox6, null,statsBox26);
        pane6.setPadding(new Insets(10, 10, 10, 10));
        pane6.setMinSize(300, 300);
        
        GridPane grid5 = new GridPane();
        grid5.setPadding(new Insets(10, 10, 10, 10));
        grid5.setMinSize(700,600);
        grid5.setVgap(12);
        grid5.setHgap(10);
        
        grid5.add(overseaPane6,0,0);
        grid5.add(outPane6,0,1);
        grid5.add(favPane6,1,0);
        grid5.add(pane6,1,1);
        
        
        scene6 = new Scene(grid5, 800,600);
        
        
                VBox favBox7 = new VBox();
        favBox7.setSpacing(15);
        favBox7.setPadding(new Insets(10,10,10,10));
        
        Button nextF7 = new Button(">");
        nextF7.setPrefSize(50,200);
        nextF7.setOnAction(e->stage.setScene(scene8));
        favBox7.getChildren().add(nextF7);
        
        VBox favBox27 = new VBox();
        favBox27.setSpacing(15);
        favBox27.setPadding(new Insets(10,10,10,10));
        
        Button previousF7 = new Button("<");
        previousF7.setPrefSize(50,200);
        previousF7.setOnAction(e->stage.setScene(scene6));
        favBox27.getChildren().add(previousF7);
        
        Label favName7 = new Label("Users' favorite property\n" +
        "Arlington"); 
        
        // Create a new pane
        BorderPane favPane7 = new BorderPane(favName7,null, favBox7, null, favBox27);
        favPane7.setPadding(new Insets(10, 10, 10, 10));
        favPane7.setMinSize(300, 300);

        
           //Properties with outdoor space
            VBox outBox7 = new VBox();
        outBox7.setSpacing(15);
        outBox7.setPadding(new Insets(10,10,10,10));
        
        Button nextOut7 = new Button(">");
        nextOut7.setPrefSize(50,200);
        nextOut7.setOnAction(e->stage.setScene(scene8));
        outBox7.getChildren().add(nextOut7);
        
        VBox OutBox27 = new VBox();
        OutBox27.setSpacing(15);
        OutBox27.setPadding(new Insets(10,10,10,10));
        
        Button previousOut7 = new Button("<");
        previousOut7.setPrefSize(50,200);
        previousOut7.setOnAction(e->stage.setScene(scene6));
        OutBox27.getChildren().add(previousOut7);
        
        Label OutName7 = new Label("Number of properties with\n" +
        "outdoor space  - 20"); 
        
        // Create a new pane
        BorderPane outPane7 = new BorderPane(OutName7,null, outBox7, null, OutBox27);
        outPane7.setPadding(new Insets(10, 10, 10, 10));
        outPane7.setMinSize(300, 300);
  
        
        VBox statsBox7 = new VBox();
        statsBox7.setSpacing(15);
        statsBox7.setPadding(new Insets(10,10,10,10));
        
        Button back7 = new Button(">");
        back7.setPrefSize(50,200);
        back7.setOnAction(e->stage.setScene(scene8));
        statsBox7.getChildren().add(back7);
        
        VBox statsBox27 = new VBox();
        statsBox27.setSpacing(15);
        statsBox27.setPadding(new Insets(10,10,10,10));
        
        Button back71 = new Button("<");
        back71.setPrefSize(50,200);
        back71.setOnAction(e->stage.setScene(scene6));
        statsBox27.getChildren().add(back71);
        
        Label statName7 = new Label("Number of Properties\n"+"         200");
        
        
        // Create a new grid pane
        BorderPane pane7 = new BorderPane(statName7,null, statsBox7, null,statsBox27);
        pane7.setPadding(new Insets(10, 10, 10, 10));
        pane7.setMinSize(300, 300);
        
        VBox reviewsBox7 = new VBox();
        reviewsBox7.setSpacing(15);
        reviewsBox7.setPadding(new Insets(10,10,10,10));
        
        Button forward17 = new Button(">");
        forward17.setPrefSize(50,200);
        forward17.setOnAction(e->stage.setScene(scene8));
        reviewsBox7.getChildren().add(forward17);
        
        VBox reviewsBox27 = new VBox();
        reviewsBox27.setSpacing(15);
        reviewsBox27.setPadding(new Insets(10,10,10,10));
        
        Button back17 = new Button("<");
        back17.setPrefSize(50,200);
        back17.setOnAction(e->stage.setScene(scene6));
        reviewsBox27.getChildren().add(back17);
        
        Label reviews7 = new Label("Average number of reviews \n"+
        "per property  -  5");
        
        BorderPane reviewPane7 = new BorderPane(reviews7, null, reviewsBox7, null, reviewsBox27);
        reviewPane7.setPadding(new Insets(10, 10, 10, 10));
        reviewPane7.setMinSize(300, 300);
        
        
        GridPane grid6 = new GridPane();
        grid6.setPadding(new Insets(10, 10, 10, 10));
        grid6.setMinSize(700,600);
        grid6.setVgap(12);
        grid6.setHgap(10);
        
        grid6.add(favPane7,0,0);
        grid6.add(pane7,0,1);
        grid6.add(outPane7,1,0);
        grid6.add(reviewPane7,1,1);
                
        scene7 = new Scene(grid6, 800,600);

                
         VBox outBox8 = new VBox();
        outBox8.setSpacing(15);
        outBox8.setPadding(new Insets(10,10,10,10));
        
        Button nextOut8 = new Button(">");
        nextOut8.setPrefSize(50,200);
        nextOut8.setOnAction(e->stage.setScene(scene));
        outBox8.getChildren().add(nextOut8);
        
        VBox OutBox28 = new VBox();
        OutBox28.setSpacing(15);
        OutBox28.setPadding(new Insets(10,10,10,10));
        
        Button previousOut8 = new Button("<");
        previousOut8.setPrefSize(50,200);
        previousOut8.setOnAction(e->stage.setScene(scene7));
        OutBox28.getChildren().add(previousOut8);
        
        Label OutName8 = new Label("Number of properties with\n" +
        "outdoor space  - 20"); 
        
        // Create a new pane
        BorderPane outPane8 = new BorderPane(OutName8,null, outBox8, null, OutBox28);
        outPane8.setPadding(new Insets(10, 10, 10, 10));
        outPane8.setMinSize(300, 300);
  
        
        VBox statsBox8 = new VBox();
        statsBox8.setSpacing(15);
        statsBox8.setPadding(new Insets(10,10,10,10));
        
        Button back8 = new Button(">");
        back8.setPrefSize(50,200);
        back8.setOnAction(e->stage.setScene(scene));
        statsBox8.getChildren().add(back8);
        
        VBox statsBox28 = new VBox();
        statsBox28.setSpacing(15);
        statsBox28.setPadding(new Insets(10,10,10,10));
        
        Button back81 = new Button("<");
        back81.setPrefSize(50,200);
        back81.setOnAction(e->stage.setScene(scene7));
        statsBox28.getChildren().add(back81);
        
        Label statName8 = new Label("Number of Properties\n"+"         200");
        
        
        // Create a new grid pane
        BorderPane pane8 = new BorderPane(statName8,null, statsBox8, null,statsBox28);
        pane8.setPadding(new Insets(10, 10, 10, 10));
        pane8.setMinSize(300, 300);
        
        VBox reviewsBox8 = new VBox();
        reviewsBox8.setSpacing(15);
        reviewsBox8.setPadding(new Insets(10,10,10,10));
        
        Button forward18 = new Button(">");
        forward18.setPrefSize(50,200);
        forward18.setOnAction(e->stage.setScene(scene));
        reviewsBox8.getChildren().add(forward18);
        
        VBox reviewsBox28 = new VBox();
        reviewsBox28.setSpacing(15);
        reviewsBox28.setPadding(new Insets(10,10,10,10));
        
        Button back18 = new Button("<");
        back18.setPrefSize(50,200);
        back18.setOnAction(e->stage.setScene(scene7));
        reviewsBox28.getChildren().add(back18);
        
        Label reviews8 = new Label("Average number of reviews \n"+
        "per property  -  5");
        
        BorderPane reviewPane8 = new BorderPane(reviews8, null, reviewsBox8, null, reviewsBox28);
        reviewPane8.setPadding(new Insets(10, 10, 10, 10));
        reviewPane8.setMinSize(300, 300);
        
         VBox expBox8 = new VBox();
        expBox8.setSpacing(15);
        expBox8.setPadding(new Insets(10,10,10,10));
        
        Button forw8 = new Button(">");
        forw8.setPrefSize(50,200);
        forw8.setOnAction(e->stage.setScene(scene));
        expBox8.getChildren().add(forw8);
        
        VBox expBox28 = new VBox();
        expBox28.setSpacing(15);
        expBox28.setPadding(new Insets(10,10,10,10));
        
        Button back28 = new Button("<");
        back28.setPrefSize(50,200);
        back28.setOnAction(e->stage.setScene(scene7));
        expBox28.getChildren().add(back28);
        
        Label expName8 = new Label
        ("Most expensive borough according to \n" + 
        "price per night and number \n" +
        "of minimum nights - Mayfair");
        
        // Create a new grid pane
        BorderPane expPane8 = new BorderPane(expName8,null, expBox8, null,expBox28);
        expPane8.setPadding(new Insets(10, 10, 10, 10));
        expPane8.setMinSize(300, 300);
        
        GridPane grid7 = new GridPane();
        grid7.setPadding(new Insets(10, 10, 10, 10));
        grid7.setMinSize(700,600);
        grid7.setVgap(12);
        grid7.setHgap(10);
        
        grid7.add(outPane8,0,0);
        grid7.add(reviewPane8,0,1);
        grid7.add(pane8,1,0);
        grid7.add(expPane8,1,1);
        
        
        scene8 = new Scene(grid7, 800,600);

        stage.setScene(scene);
        stage.setTitle("");
        // Show the Stage (window)
        stage.show();
        
        
    }
   
  
   
    /**
     * This will be executed when the button is clicked
     * It increments the count by 1
     */
    private void buttonClick(ActionEvent event)
    {
       
    }
}
