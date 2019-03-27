import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


/**
 *  (414,33)
  (258,89)
  (361,91)
  (467,88)
  (100,141)
  (205,144)
  (311,144)
  (412,141)
  (524,142)
  (625,143)
  (722,137)
  (50,192)
  (155,200)
  (257,196)
  (363,200)
  (467,196)
  (572,196)
  (674,195)
  (99,250)
  (205,248)
  (310,251)
  (417,256)
  (521,258)
  (618,253)
  (155,310)
  (251,305)
  (356,305)
  (465,310)
  (565,306)
  (209,363)
  (297,359)
  (414,360)
  (512,355)
 */
public class MainPanel extends JPanel {
  ImageIcon backgroud_;
  Image img_;
  PropertyDB database_ = new PropertyDB();
  
  int[] px = {414,258,361,467,100,205,311,412,524,625,722,50,155,257,363,467,572,674,99,205,310,417,521,618,155,
		  251,356,465,565,209,297,414,512};
  int [] py = {33,89,91,88,141,144,144,141,142,143,137,192,200,196,200,196,196,195,250,248,251,256,258,253,
		  310,305,305,310,306,363,359,360,355};
  
  String[] name = {"ENFI","BARN","HRGY","WALT","HRRW","BREN","CAMD","ISLI","HACK","REDB","HAVE","HILL","EALI","KENS","WSTM","TOWH","NEWH","BARK","HOUN",
		  "HAMM","WAND","CITY","GWCH","BEXL","RICH","MERT","LAMB","STHW","LEWS","KING","SUTT","CROY","BROM"};
  
  public MainPanel() {
    backgroud_ = new ImageIcon(getClass().getResource("boroughs.png"));
    img_ = backgroud_.getImage();
    this.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			String nameString = "";
			// TODO Auto-generated method stub
			System.out.println("("+e.getX()+","+e.getY()+")");
			int x = e.getX();
			int y = e.getY();
			for (int i = 0; i < name.length; i++) {
				if ((Math.abs(px[i]-x)<=30) && (Math.abs(py[i]-y)<=30))
				{
					nameString = name[i];
					System.out.println(name[i]);
					break;
				}
			}
	        
	      MainApp.update_gui_intf(nameString);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	});
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(img_, 0, 0, getWidth(), getHeight(), this);
	for (int i = 0; i < name.length; i++) {
		String trueNameString = database_.cvtNonAbbre(name[i]);
		int count = database_.get_num_of_borough(trueNameString,MainApp.price_low_,MainApp.price_top_);
		g.drawString(count+"", px[i], py[i]-10);
	}
  }
}
