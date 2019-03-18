import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
  ImageIcon backgroud_;
  Image img_;
  
  public MainPanel() {
    backgroud_ = new ImageIcon(getClass().getResource("welcome.jpg"));
    img_ = backgroud_.getImage();
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img_, 0, 0, getWidth(), getHeight(), this);
  }
}
