import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SpinnerModel;
import javax.swing.JComboBox;

public class MainApp {

  public static final int NAVI_BAR_HEIGHT = 40;
  public static final int BOARD_HEIGHT = 2*366;
  public static final int BOARD_WIDTH = 2*500;
  
  private JFrame frame;
  List<JPanel> panel_list_ = null;
  int n_current_panel_ = 0;
  Integer price_low_ = 0;
  Integer price_top_ = 0;
  String clicked_borough_name_ = null;

  enum BtnEvent {
    E_INVALID,
    E_FORWARD,
    E_BACKWARD,
    E_MAPRANGE,
    E_DETAIL,
  };
  
  BtnEvent btn_event_ = BtnEvent.E_INVALID;
  
  JButton btn_backward_ = null;
  JButton btn_forward_ = null;
  JButton btn_refresh_ = null;
  ActionListener btn_listener = new ActionListener() {
    public void actionPerformed(ActionEvent event) {
      if (event.getSource().equals(btn_forward_)) {
        btn_event_ = BtnEvent.E_FORWARD;
      } else if (event.getSource().equals(btn_backward_)) {
        btn_event_ = BtnEvent.E_BACKWARD;
      } else if (event.getSource().equals(btn_refresh_)) {
        btn_event_ = BtnEvent.E_MAPRANGE;
      } else {
        btn_event_ = BtnEvent.E_DETAIL; // Nothing to do here
        JButton btn = (JButton)event.getSource();
        clicked_borough_name_ = database_.cvtNonAbbre(btn.getText());
      }
      update_gui();
    }
  };
  
  ChangeListener sp_listener = new ChangeListener() {
    @Override
    public void stateChanged(ChangeEvent arg0) {
      update_button();
    }
  };
  
  
  JSpinner sp_from_ = null;
  JSpinner sp_to_ = null;
  JComboBox<String> combo_box_ = null;
  
  PropertyDB database_ = null;
  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          MainApp window = new MainApp();
          window.frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }

  /**
   * Create the application.
   */
  public MainApp() {
    database_ = new PropertyDB();
    init_gui();
  }
  
  
  /**
   * update the panel
   */
  private void refresh_panel(int current, int next) {
    frame.getContentPane().remove(panel_list_.get(current));
    frame.getContentPane().repaint();
    
    panel_list_.get(next).setBounds(10, 32, 774, 396);
    frame.getContentPane().add(panel_list_.get(next));
    
    frame.getContentPane().repaint();
    frame.getContentPane().revalidate();
    
    combo_box_.setVisible((panel_list_.get(next) instanceof DetailPanel));
  }
  
  /**
   * Update the gui
   */
  private void update_gui() {
    switch (btn_event_) {
    case E_FORWARD:
    {
      refresh_panel(n_current_panel_, n_current_panel_ + 1);
      n_current_panel_++;
      break;
    }
    case E_BACKWARD:
    {
      refresh_panel(n_current_panel_, n_current_panel_ - 1);
      n_current_panel_--;
      break;
    }
    case E_MAPRANGE:
    {
      price_low_ = (Integer)sp_from_.getValue();
      price_top_ = (Integer)sp_to_.getValue();
      
      BoroughMap panel = new BoroughMap(database_.rangeBorough((Integer val) -> {
        return (val >= price_low_ && val <= price_top_);
      }));
      for (int idx = n_current_panel_ + 1; idx < panel_list_.size(); ++idx) {
        panel_list_.remove(idx);
      }
      
      panel.addListener(btn_listener);
      panel_list_.add(panel);
      refresh_panel(n_current_panel_, panel_list_.size() - 1);
      n_current_panel_++;
      break;
    }
    case E_DETAIL:
    {      
      DetailPanel panel = new DetailPanel(clicked_borough_name_,
          database_.getAirbnbList(clicked_borough_name_, (Integer val) -> {
            return (val >= price_low_ && val <= price_top_);
          }));
      for (int idx = n_current_panel_ + 1; idx < panel_list_.size(); ++idx) {
        panel_list_.remove(idx);
      }
      
      panel_list_.add(panel);
      refresh_panel(n_current_panel_, panel_list_.size() - 1);
      n_current_panel_++;
      break;
    }
    default:
      break;
    }

    update_button();
    btn_event_ = BtnEvent.E_INVALID;
  }
  
  /**
   * Update the button
   */
  private void update_button() {
    boolean has_next = ((n_current_panel_ + 1) < panel_list_.size());
    boolean has_prev = (n_current_panel_ > 0);
    
    btn_forward_.setEnabled(has_next);
    btn_backward_.setEnabled(has_prev);
    
    Integer from = (Integer)sp_from_.getValue();
    Integer to   = (Integer)sp_to_.getValue();
    btn_refresh_.setEnabled((from != price_low_) || (to != price_top_));
  }

  /**
   * Initialize the contents of the frame.
   */
  private void init_gui() {
    frame = new JFrame();
    frame.setTitle("London Property Marketplace");
    frame.setResizable(false);
    frame.setBounds(100, 100, 800, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);
    
    MainPanel startup_panel = new MainPanel();
    
    startup_panel.setBounds(10, 32, 774, 396);
    frame.getContentPane().add(startup_panel);
    
    panel_list_ = new ArrayList<JPanel>();
    panel_list_.add(startup_panel);
    n_current_panel_ = 0;
    
    sp_from_ = new JSpinner(new SpinnerNumberModel(
        database_.get_min_price(), database_.get_min_price(),
        database_.get_max_price(), 1));
    sp_from_.setBounds(574, 3, 82, 22);
    sp_from_.addChangeListener(sp_listener);
    frame.getContentPane().add(sp_from_);
    price_low_ = database_.get_min_price();
    
    sp_to_ = new JSpinner();
    sp_to_.setModel(new SpinnerNumberModel(
        database_.get_min_price(), database_.get_min_price(),
        database_.get_max_price(), 1));
    sp_to_.setBounds(702, 3, 82, 22);
    sp_to_.addChangeListener(sp_listener);
    frame.getContentPane().add(sp_to_);
    price_top_ = database_.get_min_price();
    
    JLabel from = new JLabel("from");
    from.setBounds(526, 6, 38, 15);
    frame.getContentPane().add(from);
    
    JLabel to = new JLabel("to");
    to.setBounds(680, 6, 12, 15);
    frame.getContentPane().add(to);
    
    btn_backward_ = new JButton("<--");
    btn_backward_.setBounds(10, 438, 93, 23);
    btn_backward_.addActionListener(btn_listener);
    frame.getContentPane().add(btn_backward_);
    
    btn_forward_ = new JButton("-->");
    btn_forward_.setBounds(691, 438, 93, 23);
    btn_forward_.addActionListener(btn_listener);
    frame.getContentPane().add(btn_forward_);
    
    btn_refresh_ = new JButton("Refresh");
    btn_refresh_.setBounds(10, 2, 93, 23);
    btn_refresh_.addActionListener(btn_listener);
    frame.getContentPane().add(btn_refresh_);
       
    combo_box_ = new JComboBox<String>();
    combo_box_.setBounds(113, 3, 174, 21);
    combo_box_.addItem("number of reviews");
    combo_box_.addItem("price");
    combo_box_.addItem("host name");
    combo_box_.addItemListener(new ItemListener() {
      @Override
      public void itemStateChanged(ItemEvent e) {
        if(e.getStateChange() == ItemEvent.SELECTED) {
          String item = (String) e.getItem();
          DetailPanel panel = null;
          Comparator<AirbnbListing> cmp = null;
          if (item == "number of reviews") {
            cmp = new Comparator<AirbnbListing>() {
              @Override
              public int compare(AirbnbListing o1, AirbnbListing o2) {
                return o1.getNumberOfReviews() - o2.getNumberOfReviews();
              }
            };
          } else if (item == "price") {
            cmp = new Comparator<AirbnbListing>() {
              @Override
              public int compare(AirbnbListing o1, AirbnbListing o2) {
                return o1.getPrice() - o2.getPrice();
              }
            };
          } else {
            cmp = new Comparator<AirbnbListing>() {
              @Override
              public int compare(AirbnbListing o1, AirbnbListing o2) {
                return o1.getHost_name().compareTo(o2.getHost_name());
              }
            };
          }
          panel = new DetailPanel(clicked_borough_name_,
              database_.getAirbnbList(clicked_borough_name_, (Integer val) -> {
                return (val >= price_low_ && val <= price_top_);
              }), cmp);
          
          for (int idx = n_current_panel_ + 1; idx < panel_list_.size(); ++idx) {
            panel_list_.remove(idx);
          }
          
          panel_list_.add(panel);
          refresh_panel(n_current_panel_, panel_list_.size() - 1);
          n_current_panel_++;
        }
      }
    });
    
    frame.getContentPane().add(combo_box_);
    combo_box_.setVisible(false);
    update_button();
  }
  
  class BtnActionListener implements ActionListener {
 
    @Override
    public void actionPerformed(ActionEvent event) {
      if (event.getSource().equals(btn_forward_)) {
        n_current_panel_++;
      } else if (event.getSource().equals(btn_backward_)) {
        n_current_panel_--;
      } else {
        ; // Nothing to do here
      }
      
      update_button();
    }
  }
}
