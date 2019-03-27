
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.*;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * Create a new window of the statistic panel.
 *
 * @author Li Peiyao
 * @version (a version number or a date)
 */
public class StatisticsPanel extends Application
{
    private VBox stat1 = new VBox();
    private int page1 = 1;
    private VBox stat2 = new VBox();
    private int page2 = 1;
    private VBox stat3 = new VBox();
    private int page3 = 1;
    private VBox stat4 = new VBox();
    private int page4 = 1;
    private Statistics statistic = new Statistics();

    @Override
    public void start(Stage stage) 
    {
        setAvgReviewsLabel();
        stat1.setId("statvbox");
        stat1.setPrefWidth(200);
        Button firstLeft = new Button("<");
        firstLeft.setOnAction(this::switchFirstBox);
        Button firstRight = new Button(">");
        firstRight.setOnAction(this::switchFirstBox);
        BorderPane statBox1 = new BorderPane(stat1, null, firstRight, null, firstLeft);
        
        setAvaiPropertiesLabel();
        stat2.setId("statvbox");
        stat2.setPrefWidth(200);
        Button secondLeft = new Button("<");
        secondLeft.setOnAction(this::switchSecondBox);
        Button secondRight = new Button(">");
        secondRight.setOnAction(this::switchSecondBox);
        BorderPane statBox2 = new BorderPane(stat2, null, secondRight, null, secondLeft);
        
        setNoHomeLabel();
        stat3.setId("statvbox");
        stat3.setPrefWidth(200);
        Button thirdLeft = new Button("<");
        thirdLeft.setOnAction(this::switchThirdBox);
        Button thirdRight = new Button(">");
        thirdRight.setOnAction(this::switchThirdBox);
        BorderPane statBox3 = new BorderPane(stat3, null, thirdRight, null, thirdLeft);
        
        setMostExpensiveLabel();
        stat4.setId("statvbox");
        stat4.setPrefWidth(200);
        Button fourthLeft = new Button("<");
        fourthLeft.setOnAction(this::switchFourthBox);
        Button fourthRight = new Button(">");
        fourthRight.setOnAction(this::switchFourthBox);
        BorderPane statBox4 = new BorderPane(stat4, null, fourthRight, null, fourthLeft);
        
        BorderPane vertical1 = new BorderPane(null, statBox1, null, statBox3, null);
        vertical1.setId("vertical");
        BorderPane vertical2 = new BorderPane(null, statBox2, null, statBox4, null);
        vertical2.setId("vertical");
        
        BorderPane stat = new BorderPane(null, null, vertical2, null, vertical1);
        stat.setId("stat");
        
        Scene scene = new Scene(stat, 900,700);
        scene.getStylesheets().add("statistics.css");
        stage.setTitle("Property Statistics");
        stage.setScene(scene);
  
        stage.show();
    }
    
    /**
     * Swith to another statistics page when 
     * clicking button in the first statistics box.
     */
    private void switchFirstBox(ActionEvent event)
    {
        if(page1 == 1){
            setAvgMonthReviewsLabel();
        }
        else if(page1 == 2){
            setAvgReviewsLabel();
        }
    }
    
    /**
     * Swith to another statistics page when 
     * clicking button in the second statistics box.
     */
    private void switchSecondBox(ActionEvent event)
    {
        if(page2 == 1){
            setTheMostReviewsLabel();
        }
        else if(page2 == 2){
            setAvaiPropertiesLabel();
        }
    }
    
    /**
     * Swith to another statistics page when 
     * clicking button in the third statistics box.
     */
    private void switchThirdBox(ActionEvent event)
    {
        if(page3 == 1){
            setNoPrivateRoomLabel();
        }
        else if(page3 == 2){
            setNoHomeLabel();
        }
    }
    
    /**
     * Swith to another statistics page when 
     * clicking button in the fourth statistics box.
     */
    private void switchFourthBox(ActionEvent event)
    {
        if(page4 == 1){
            setCheapestLabel();
        }
        else if(page4 == 2){
            setMostExpensiveLabel();
        }
    }

    /**
     *  Set the label to show the statistics of 
     *  the average number of reviews.
     */
    private void setAvgReviewsLabel()
    {
        Label avgReviews = new Label("Average number of \nreviews per property");
        Label stat = new Label("" + statistic.avgReviews());
        stat.setId("numbers");
        setVBox(stat1, avgReviews, stat);
        page1 = 1;
    }
    
    /**
     * Set the label to show the statistics of
     * the total number of available properties.
     */
    private void setAvaiPropertiesLabel()
    {
        Label avaiProperties = new Label("Total number of \navailable properties");
        Label stat = new Label("" + statistic.avaiProperties());
        stat.setId("numbers");
        setVBox(stat2, avaiProperties, stat);
        page2 = 1;
    }
    
    /**
     * Set the label to show the statistics of
     * the total number of entire home/aptartment type.
     */
    private void setNoHomeLabel()
    {
        Label noEntireHome = new Label("The number of entire \n home and apartments");
        Label stat = new Label("" + statistic.noOfEntireHome());
        stat.setId("numbers");
        setVBox(stat3, noEntireHome, stat);
        page3 = 1;
    }
    
    /**
     * Set the label to show the name of the 
     * most expensive property borough.
     */
    private void setMostExpensiveLabel()
    {
        Label mostExpensive = new Label("The most expensive\n borough");
        Label stat = new Label("" + statistic.mostExpensive());
        ScrollPane pane = new ScrollPane();
        pane.setContent(stat);
        setVBox(stat4, mostExpensive, pane);
        page4 = 1;
    }
    
    /**
     * Set the label to show the name of the
     * cheapest property borough.
     */
    private void setCheapestLabel()
    {
        Label cheapest = new Label("The cheapest \n borough");
        Label stat = new Label("" + statistic.cheapest());
        setVBox(stat4, cheapest, stat);
        page4 = 2;
    }
    
    /**
     * Set the label to show the statistics of
     * the total number of private toom type.
     */
    private void setNoPrivateRoomLabel()
    {
        Label noPrivate = new Label("The number of private \n rooms");
        Label stat = new Label("" + statistic.noOfPrivateRooms());
        stat.setId("numbers");
        setVBox(stat3, noPrivate, stat);
        page3 = 2;
    }
    
    /**
     * Set the label to show the name of the
     * property with most number of reviews.
     */
    private void setTheMostReviewsLabel()
    {
        Label mostReview = new Label("The property with most\n number of reviews ");
        Label stat = new Label("" + statistic.mostReviews());
        ScrollPane pane = new ScrollPane();
        pane.setContent(stat);
        setVBox(stat2, mostReview, pane);
        page2 = 2;
    }
    
    /**
     * Set the label to show the statistics of
     * the average number of month reviews per property.
     */
    private void setAvgMonthReviewsLabel()
    {
        Label avgMonthReviews = new Label("Average number of month\nreviews per property");
        Label stat = new Label("" + statistic.avgMonthReviews());
        stat.setId("numbers");
        setVBox(stat1, avgMonthReviews, stat);
        page1 = 2;
    }
    
    /**
     * Set the children in the VBox. 
     * @param box the vbox to be set
     * @param labels the children to be set in the vbox
     */
    private void setVBox(VBox box, Node... labels)
    {
        box.getChildren().clear();
        box.getChildren().addAll(labels);
    }
}
