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
 * @author Li Peiyao, Chen Yuhan
 * @version (a version number or a date)
 */
public class Host
{
    private ArrayList<TextField> textFields = new ArrayList<TextField>();
    

    /**
     * 
     */
    public Host()
    {
        
    }
 
    /**
     * 
     */
    public GridPane start()
    {
        GridPane grid = new GridPane();
        grid.setHgap (10);
        grid.setVgap (20);
        
        HBox tool = new HBox();
        tool.setSpacing(100.0);
        
        Button submit = new Button("Submit");
        submit.setOnAction(this::success);
        
        Label hostName = new Label("Your name:");
        TextField thName = new TextField();
        Label hostBirth = new Label("Your birth:");
        TextField thBirth = new TextField();
        thBirth.setPromptText("DD/MM/YYYY");
        Label hostPhone = new Label("Your phone number:");
        TextField thPhone = new TextField();
        Label hostEmail = new Label("Your email address:");
        TextField thEmail = new TextField();
        Label Address = new Label("The address of the property:");
        TextField tAddress = new TextField();
        Label postcode = new Label("Postcode of the property:");
        TextField tPostcode = new TextField();
        Label information = new Label("More information of the property(eg.room type,neighbourhood):");
        TextField tInformation = new TextField();
        Label startDate = new Label("The earliest available date:");
        TextField tDate = new TextField();
        Label period = new Label("How long is the property available:");
        TextField tPeriod = new TextField();
        Label idealPrice = new Label("Your ideal price(pw/pm):");
        TextField tiPrice = new TextField();
        Label minPrice = new Label("The lowest price you could accept(pw/pm):");
        TextField tmPrice = new TextField();
        Label offer = new Label("would you like to give tenants some convenience(eg.internrt/student-friendly):");
        TextField tOffer = new TextField();
        Label hostRequest = new Label("Do you have some requests to tenants or agencies:");
        TextField thRequest = new TextField();
        
        grid.add(hostName,1,0);
        grid.add(thName,2,0);
        grid.add(hostBirth,1,1);
        grid.add(thBirth,2,1);
        grid.add(hostPhone,1,2);
        grid.add(thPhone,2,2);
        grid.add(hostEmail,1,3);
        grid.add(thEmail,2,3);
        grid.add(Address,1,4);
        grid.add(tAddress,2,4);
        grid.add(postcode,1,5);
        grid.add(tPostcode,2,5);
        grid.add(information,1,6);
        grid.add(tInformation,2,6);
        grid.add(startDate,1,7);
        grid.add(tDate,2,7);
        grid.add(period,1,8);
        grid.add(tPeriod,2,8);
        grid.add(idealPrice,1,9);
        grid.add(tiPrice,2,9);
        grid.add(minPrice,1,10);
        grid.add(tmPrice,2,10);
        grid.add(offer,1,11);
        grid.add(tOffer,2,11);
        grid.add(hostRequest,1,12);
        grid.add(thRequest,2,12);
        grid.add(submit,3,14);
        
        textFields.add(thName);
        textFields.add(thBirth);
        textFields.add(thPhone);
        textFields.add(thEmail);
        textFields.add(tAddress);
        textFields.add(tPostcode);
        textFields.add(tInformation);
        textFields.add(tDate);
        textFields.add(tPeriod);
        textFields.add(tiPrice);
        textFields.add(tmPrice);
        textFields.add(tOffer);
        textFields.add(thName);
        textFields.add(thRequest);
       
        return grid;
    }   
    
    private boolean canSubmit()
    {
        for(TextField textField : textFields){
            if(textField.getText().isEmpty()){
                return false;
            }
        }
        return true;
    }
    
    private void success(ActionEvent event)
    {
        if(canSubmit()){
            submitConfirmation();
        }
        else{
            submitAlert();
        }
    }
    
    public void submitConfirmation()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("You have submited successfully!Our stuff will contact you soon for further information.");
        alert.showAndWait();
    }
    
    private void submitAlert()
    {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Submit Information: Error");
        alert.setHeaderText("Your information is not completed."); 
        alert.setContentText("Please ensure that you have filled in all the fields\n");       
        alert.showAndWait();
    }
}
