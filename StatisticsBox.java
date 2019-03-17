import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * 在这里给出对类 StatisticsBox 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class StatisticsBox
{
    public Statistics statistics;

    /**
     * 类 StatisticsBox 的对象的构造函数
     */
    public StatisticsBox()
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
        Button openButton = new Button("statistics");
        openButton.setText("Open the statistics box.");
        openButton.setOnAction(e -> new AlertBox().display("title", "statistics"));

        AnchorPane layout = new AnchorPane();
        layout.getChildren().add(openButton);

        Scene scene=new Scene(layout,200,200);

        stage.setScene(scene);
        stage.show();

    }


}
