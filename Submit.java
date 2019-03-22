import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;

/**
 * 在这里给出对类 Submit 的描述。
 * 
 * @作者（你的名字）
 * @版本（一个版本号或者一个日期）
 */
public class Submit
{
    // 实例变量 - 用你自己的变量替换下面的例子
    

    /**
     * 类 Submit 的对象的构造函数
     */
    public Submit()
    {
        // 初始化实例变量
        
    }

    /**
     * 一个方法的例子 - 使用你自己的说明替代它
     * 
     * @参数 y，方法的一个样本参数
     * @返回 x，y的和 
     */
    public void success()
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Success");
        alert.setContentText("You have submited successfully!Our stuff will contact you soon for further information.");
        alert.showAndWait();
    }
}
