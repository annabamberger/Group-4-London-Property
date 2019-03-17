import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 在这里给出对类 AlertBox 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class AlertBox
{
    
    /**
     * 类 AlertBox 的对象的构造函数
     */
    public AlertBox()
    {
        
    }

    /**
     * 一个方法的例子 - 使用你自己的说明替代它
     * 
     * @参数 y，方法的一个样本参数
     * @返回 x，y的和 
     */
    public void display(String title,String statistics)
    {
        Stage window = new Stage();
        window.setTitle("Statistics");
        window.initModality(Modality.APPLICATION_MODAL);
        window.setMinWidth(400);
        window.setMinHeight(400);
        
        Button button = new Button("Close");
        button.setOnAction(e -> window.close());

        Label label = new Label(statistics);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label , button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    
    }
}
