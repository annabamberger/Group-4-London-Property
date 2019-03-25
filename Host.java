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
 * 在这里给出对类 Host 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Host extends Application
{
    // 实例变量 - 用你自己的变量替换下面的例子
    

    /**
     * 类 Host 的对象的构造函数
     */
    public Host()
    {
        
    }

    /**
     * 一个方法的例子 - 使用你自己的说明替代它
     * 
     * @参数 y，方法的一个样本参数
     * @返回 x，y的和 
     */
    public void start(Stage stage)
    {
        GridPane grid = new GridPane();
        grid.setHgap (10);
        grid.setVgap (20);
        
        HBox tool = new HBox();
        tool.setSpacing(100.0);
        
        Button submit = new Button("Submit");
        submit.setOnAction(e -> new Submit().success());
        
        Label hostName = new Label("Your name:");
        TextField thName = new TextField();
        Label hostBirth = new Label("Your birth(DD/MM/YYYY):");
        TextField thBirth = new TextField();
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
        TextField tsDate = new TextField();
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
        grid.add(tsDate,2,7);
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
        
         // JavaFX must have a Scene (window content) inside a Stage (window)
        Scene scene = new Scene(grid, 900,700);
        stage.setTitle("Property Lease Form");
        stage.setScene(scene);

        // Show the Stage (window)
        stage.show();
    }   
    
    
}
