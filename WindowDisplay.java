
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import java.util.ArrayList;


/**
 * The Application window with welcome panel that 
 * can switch to all other panel when clicking buttons.
 *
 * @author (Li Peiyao), Anna Bamberger
 * @version (a version number or a date)
 */
public class WindowDisplay extends Application
{
    private int fromPrice = 0;
    private int toPrice = 0;
    private ArrayList<TextField> textFields = new ArrayList<TextField>();
    private BorderPane root;
    private Stage stage;
    

    @Override
    public void start(Stage stage) 
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
        Button inquiryButton = new Button("Book your property here");
        inquiryButton.setOnAction(this::inquiryButtonClick);
        BorderPane topPane = new BorderPane();
        topPane.setRight(pricePane);
        topPane.setLeft(inquiryButton);
        topPane.setId("toppane");
      
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
        root = new BorderPane(welcomeLabel, topPane, null, bottomPane, null);
        
        // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(root, 1000,770);
        scene.getStylesheets().add("welcome.css");
        stage.setTitle("London Property Market");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }
 
    /**
     * The action event of clicking the "OK" button.
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
            proceed();
        }
    }
    
    /**
     * The action event of clicking the "Book your property here" button.
     */
    private void inquiryButtonClick(ActionEvent event)
    {
        setInquiryPanel();
        
    }
    
    /**
     * A new panel of property listing form. 
     * The user can inquire about a specific listing meeting his requirements here.
     * User can also click to next page where he can upload details about his own 
     * property for potential future listing.
     */
    private void setInquiryPanel()
    {
        Label titleLabel = new Label("Property Inquiry Form (Finish this form to confirm your booking)");
        titleLabel.setId("titleLabel");
        
        GridPane formPane = new GridPane();
        formPane.setHgap(20);
        formPane.setVgap(40);
        formPane.setId("formpane");
        
        
        Label zero = new Label("Your Name:");
        Label first = new Label("Phone Number:");
        Label second = new Label("email address:");
        Label third = new Label("Property Name:");
        Label fourth = new Label("Property ID:");
        Label fifth = new Label("Date of checking in:");
        Label sixth = new Label("Date of checking out:");
        formPane.add(zero, 0, 0);
        formPane.add(first, 0, 1);
        formPane.add(second, 0, 2);
        formPane.add(third, 0, 3);
        formPane.add(fourth, 0, 4);
        formPane.add(fifth, 0, 5);
        formPane.add(sixth, 0, 6);
        
        TextField zeroTF = new TextField();
        zeroTF.setPromptText("Enter your full name");
        formPane.add(setValidityNameLabel(zeroTF), 2, 0);
        
        TextField firstTF = new TextField();
        formPane.add(setValidityNumberLabel(firstTF), 2, 1);
        
        TextField secondTF = new TextField();
        
        TextField thirdTF = new TextField();
        thirdTF.setMinWidth(400);
        thirdTF.setPromptText("Enter the name of the property that you want to book");
        formPane.add(setValidityNameLabel(thirdTF), 2, 3);
        
        TextField fourthTF = new TextField();
        fourthTF.setPromptText("Enter the id of the property that you want to book");
        formPane.add(setValidityNumberLabel(fourthTF), 2, 4);
        
        TextField fifthTF = new TextField();
        fifthTF.setPromptText("DD/MM/YYYY");
        formPane.add(setValidityDateLabel(fifthTF), 2, 5);
        
        TextField sixthTF = new TextField();
        sixthTF.setPromptText("DD/MM/YYYY");
        formPane.add(setValidityDateLabel(sixthTF), 2, 6);
        
        textFields.add(zeroTF);
        textFields.add(firstTF);
        textFields.add(secondTF);
        textFields.add(thirdTF);
        textFields.add(fourthTF);
        textFields.add(fifthTF);
        textFields.add(sixthTF);
        
        
        Button submitButton = new Button("submit");
        submitButton.setOnAction(this::submitButtonClick);
        Button listProperty = new Button("Get your property listed!");
        listProperty.setOnAction(this::listPropertyButtonClick);
        formPane.add(zeroTF, 1, 0);
        formPane.add(firstTF, 1, 1);
        formPane.add(secondTF, 1, 2);
        formPane.add(thirdTF, 1, 3);
        formPane.add(fourthTF, 1, 4);
        formPane.add(fifthTF, 1, 5);
        formPane.add(sixthTF, 1, 6);
        formPane.add(submitButton, 1, 7);
        formPane.add(listProperty, 3, 7);
        
        root.setTop(titleLabel);
        root.setCenter(formPane);
    }
    
    /**
     * The action event of clicking the "Get your property listed!" button.
     * Create a new panel of property lease form.
     */
    private void listPropertyButtonClick(ActionEvent event)
    {
        Label title = new Label("Property Lease Form");
        title.setId("titleLabel");
        root.setTop(title);
        Host listPanel = new Host();
        root.setCenter(listPanel.start());
    }
    
    /**
     * The format of the name text field.
     * @param input the input string from the user
     * @return if the format is correct
     */
    private boolean validName(String input)
    {
        String format = "[A-Za-z\\s]+"; 
        return input.matches(format);
    }
    
    /**
     * The format of the number text field.
     * @param input the input string from the user
     * @return if the format is correct
     */
    private boolean validNumber(String input)
    {
        String format = "[0-9\\s]+"; 
        return input.matches(format);
    }
    
    /**
     * The format of the date text field.
     * @param input the input string from the user
     * @return if the format is correct
     */
    private boolean validDate(String input)
    {
        String format = "(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[1-2])/(20[1-9][0-9])"; 
        return input.matches(format);
    }
    
    /**
     * Check if the user input string of name format 
     * is valid and set a validity label.
     * @param tf the corresponding text field of the input string
     * @return the label of information validity
     */
    private Label setValidityNameLabel(TextField tf)
    {
        Label validityLabel = new Label();
        tf.setOnKeyReleased(ev -> { 
                                        if(!validName(tf.getText())){
                                            validityLabel.setText("INVALID");
                                            validityLabel.setId("invalidlabel");
                                           
                                        }
                                        else{
                                            validityLabel.setText("VALID");
                                            validityLabel.setId("validlabel");
                                            
                                        }
                                        
                                      });
        return validityLabel;
    }
    
    /**
     * Check if the user input string of number format 
     * is valid and set a validity label.
     * @param tf the corresponding text field of the input string
     * @return the label of information validity
     */
    private Label setValidityNumberLabel(TextField tf)
    {
        Label validityLabel = new Label();
        tf.setOnKeyReleased(ev -> { 
                                        if(!validNumber(tf.getText())){
                                            validityLabel.setText("INVALID");
                                            validityLabel.setId("invalidlabel");
                                           
                                        }
                                        else{
                                            validityLabel.setText("VALID");
                                            validityLabel.setId("validlabel");
                                            
                                        }
                                        
                                      });
        return validityLabel;
    }
    
    /**
     * Check if the user input string of date format 
     * is valid and set a validity label.
     * @param tf the corresponding text field of the input string
     * @return the label of information validity
     */
    private Label setValidityDateLabel(TextField tf)
    {
        Label validityLabel = new Label();
        tf.setOnKeyReleased(ev -> { 
                                        if(!validDate(tf.getText())){
                                            validityLabel.setText("INVALID");
                                            validityLabel.setId("invalidlabel");
                                           
                                        }
                                        else{
                                            validityLabel.setText("VALID");
                                            validityLabel.setId("validlabel");
                                            
                                        }
                                        
                                      });
        return validityLabel;
    }
    
    /**
     * The action event of the "submit" button.
     */
    private void submitButtonClick(ActionEvent event)
    {
        if(canSubmit()){
            confirmationInfo();
        }
        else{
            submitErrorAlert();
        }
    }
    
    /**
     * Check if the user filled in all the valid information and be able to submit.
     * @return if the user can submit or not
     */
    private boolean canSubmit()
    {
        if(!validName(textFields.get(0).getText()) || !validName(textFields.get(3).getText())){
            return false;
        }
        if(!validNumber(textFields.get(1).getText()) || !validNumber(textFields.get(4).getText())){
            return false;
        }
        if(!validDate(textFields.get(5).getText()) || !validDate(textFields.get(6).getText())){
            return false;
        }
        if(textFields.get(2).getText().isEmpty()){
            return false;
        }
        return true;    
        
    }
    
    /**
     * Proceed to the statistic page.
     */
    private void proceed()
    { 
       Statistics stats = new Statistics();
       Stage newStage = new Stage();
       stats.start(newStage);
       newStage.show();
    }
    
    /**
     * Create an alert error dialog if the price selected is invalid.
     */
    private void priceErrorAlert()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Select the price: Error");
        alert.setHeaderText("The price range you selected is invalid"); 
        alert.setContentText("Please select again to ensure that \n" + 
                             "the 'From' price is lower than the 'To' price.");
        alert.showAndWait();
    }
    
    /**
     * Create an alert error dialog if the user doesn't select the price range.
     */
    private void selectPriceAlert()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Select the price: Error");
        alert.setHeaderText("The price range is empty."); 
        alert.setContentText("Please select the price range you wanted.");
        alert.showAndWait();
    }
    
    /**
     * Create an alert information dialog to give a 
     * confirmation information to the user when they 
     * submit the property listing form.
     */
    private void confirmationInfo()
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Booking confirmation");
        alert.setHeaderText(""); 
        alert.setContentText("Thank you for your booking!\n" + 
                             "Your booking information has been submitted successfully.\n" + 
                             "You will receive an email when we confirm your booking.");
        alert.showAndWait();
    }
    
    /**
     * Create an alert error dialog if the user submit their 
     * form with invalid information.
     */
    private void submitErrorAlert()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Submit Information: Error");
        alert.setHeaderText("Your information is not completed."); 
        alert.setContentText("Please ensure that you have filled in all the fields\n" + 
                             "and your information is valid.");
        alert.showAndWait();
    }
}
