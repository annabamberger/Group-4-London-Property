import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
/**
 * a class represent porperty database
 * 
 * @author Ziling Xu
 * @version 2.1
 */

public class PropertyDB {
  
  ArrayList<AirbnbListing> properties_ = null;
  Map<String, List<AirbnbListing>> bnb_by_borough_ = null;
  Map<String, String> borough_abbre_ = null;
  int min_price_ = Integer.MAX_VALUE;
  int max_price_ = Integer.MIN_VALUE;
  
  public PropertyDB() {
    properties_ = new AirbnbDataLoader().load();
    bnb_by_borough_ = new HashMap<String, List<AirbnbListing>>();
    borough_abbre_ = new HashMap<String, String>();
    for (AirbnbListing bnb : properties_) {
      String borough = bnb.getNeighbourhood();
      
      List<AirbnbListing> list = bnb_by_borough_.getOrDefault(borough, new ArrayList<AirbnbListing>());
      list.add(bnb);
      bnb_by_borough_.put(borough, list);
      if (min_price_ > bnb.getPrice()) min_price_ = bnb.getPrice();
      if (max_price_ < bnb.getPrice()) max_price_ = bnb.getPrice();
    }
    
    for (String key : bnb_by_borough_.keySet()) {
      borough_abbre_.put(key.substring(0, 4).toUpperCase(), key);
    }
    
    System.out.println("N: " + bnb_by_borough_.size());
  }
  
  public List<AirbnbListing> getAirbnbList(String key) {
    return bnb_by_borough_.getOrDefault(key, null);
  }
  
  public List<AirbnbListing> getAirbnbList(String key, Function<Integer, Boolean> comp) {
    List<AirbnbListing> bnbs = bnb_by_borough_.getOrDefault(key, null);
    bnbs.removeIf(bnb -> {
      return !comp.apply(bnb.getPrice());
    });
    System.out.println(bnbs.size());
    return bnbs;
  }
  
  public String cvtNonAbbre(String abbre) {
    return borough_abbre_.getOrDefault(abbre, null);
  }
  
  public int get_min_price() {
    return min_price_;
  }
  
  public int get_max_price() {
    return max_price_;
  }
  
  public Map<String, Integer> rangeBorough(Function<Integer, Boolean> comp) {
    Map<String, Integer> rg_bors = new HashMap<String, Integer>();
    for (Map.Entry<String, List<AirbnbListing>> entry : bnb_by_borough_.entrySet()) {
      Integer num = 0;
      for (AirbnbListing bnb : entry.getValue()) {
        if (comp.apply(bnb.getPrice())) ++num;
      }
      
      if (num != 0)
        rg_bors.put(entry.getKey(), num);
    }

    return rg_bors;
  }
  
  public int get_num_of_borough(String borough) {
    return bnb_by_borough_.getOrDefault(borough, new ArrayList<AirbnbListing>()).size();
  }

  public String get_line_by_borough_name(String borough, String hostName) {
	     List<AirbnbListing> arraylist = bnb_by_borough_.getOrDefault(borough, new ArrayList<AirbnbListing>());
	     for(AirbnbListing tmp:arraylist){
	            if (tmp.getHost_name().equals(hostName))
	            {
	            	return  "ID("+tmp.getId()+"),NAME(" + tmp.getName()+"),HOST_NAME(" + tmp.getHost_name() + "),Latitude(" +
	            			tmp.getLatitude() +"),Longitude("+ tmp.getLongitude() + "),Price("  + tmp.getPrice() + "),MinimumNights(" + tmp.getMinimumNights()
	            			+ "),NumberOfReviews(" + tmp.getNumberOfReviews() +")";
	            }
	        }
	     return "";
	  }
  
  public int get_num_of_borough(String borough, Function<Integer, Boolean> comp) {
    List<AirbnbListing> bnbs = bnb_by_borough_.getOrDefault(borough, new ArrayList<AirbnbListing>());

    int n_property = 0;
    for (AirbnbListing bnb : bnbs) {
      if (bnb.getNeighbourhood().contains(borough) && comp.apply(bnb.getPrice()))
        ++n_property;
    }
    
    return n_property;
  }
  
  public int get_num_of_borough(String borough, int btm, int top) {
    return get_num_of_borough(borough, (Integer price) -> {
      return (price >= btm && price <= top);
    });
  }
  
}
