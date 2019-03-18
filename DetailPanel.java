import javax.swing.JPanel;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

//import airbnb.AirbnbListing;
import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class DetailPanel extends JPanel {
  JList<String> list_ = null;
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
    JScrollPane scrollBar = new JScrollPane(list_);
    add(scrollBar);
  }
  
}
