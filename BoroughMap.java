import javax.swing.JPanel;
import javax.swing.JButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.Color;
/**
 * This class is the basic panel appears as the first page/panel of map
 * 
 * @author Ziling Xu
 * @version 2.1
 */

public class BoroughMap extends JPanel {

  private List<JButton> boroughs_ = null;
  
  /**
   * Create the panel.
   */
  public BoroughMap(Map<String, Integer> data) {
    setBounds(10, 32, 774, 396);
    setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
    Double max = Double.MIN_VALUE;
    Double min = Double.MAX_VALUE;
    for (Integer val : data.values()) {
      if (max < val) max = val.doubleValue();
      if (min > val) min = val.doubleValue();
    }
    
    boroughs_ = new ArrayList<JButton>();
    for (Map.Entry<String, Integer> entry : data.entrySet()) {
      JButton btn = new JButton(entry.getKey().substring(0, 4).toUpperCase());
      // btn.setForeground(new Color(0, 255, 0));
      Double alpha = (entry.getValue() - min) / (max - min);
      btn.setBackground(new Color(0, (int) (255*alpha), 0));
      
      add(btn);
      boroughs_.add(btn);
    }
  }
  
  /**
   * if the borough button clicked
   */
  public void addListener(ActionListener listener) {
    for (JButton btn : boroughs_) {
      btn.addActionListener(listener);
    }
  }

}