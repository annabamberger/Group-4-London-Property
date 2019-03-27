import javax.swing.JPanel;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import airbnb.AirbnbListing;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class DetailPanel extends JPanel {
  JList<String> list_ = null;
  String borough = "";
  /**
   * Create the panel.
   */
  public DetailPanel(String borough, List<AirbnbListing> bnbs) {
    init(borough, bnbs);
  }

  public DetailPanel(String borough, List<AirbnbListing> bnbs, Comparator<AirbnbListing> cmp) {
    bnbs.sort(cmp);
    init(borough, bnbs);
  }
  
  private void init(String borough, List<AirbnbListing> bnbs) {
    setBounds(10, 32, 774, 396);
    setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    
    JLabel lblNewLabel = new JLabel(borough);
    lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
    add(lblNewLabel);

    String[] listdata = new String[bnbs.size()];
    for (int idx = 0; idx < bnbs.size(); ++idx) {
      AirbnbListing bnb = bnbs.get(idx);
      listdata[idx] = String.format("%-32s %-4d %-4d %-2d", bnb.getHost_name(),
          bnb.getPrice(), bnb.getNumberOfReviews(), bnb.getMinimumNights());
    }
    
    list_ = new JList<String>(listdata);
    list_.addMouseListener(new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
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
			if (e.getClickCount() == 2)
			{
				try {
					String hostName = ((String) ((JList)(e.getSource())).getSelectedValue()).split("\\s+")[0];
					String ret = MainApp.database_.get_line_by_borough_name(borough, hostName);
					if (!ret.isEmpty())
					JOptionPane.showMessageDialog(null, ret,"details", JOptionPane.NO_OPTION);
					//System.out.println(MainApp.database_.get_line_by_borough_name(borough, hostName));
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		}
	});
    JScrollPane scrollBar = new JScrollPane(list_);
    add(scrollBar);
  }
  
}
