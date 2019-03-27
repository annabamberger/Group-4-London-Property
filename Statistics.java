
import java.util.ArrayList;

/**
 * Cauculate some statistics of all the properties
 * int the data loader.
 *
 * @author Li Peiyao, Anna Bamberger
 * @version (a version number or a date)
 */
public class Statistics
{
    private ArrayList<AirbnbListing> properties;

    /**
     * Load a list of properties from the data loader.
     */
    public Statistics()
    { 
        properties = new AirbnbDataLoader().load();
    }

    /**
     * Cauculate the average number of reviews 
     * of all properties.
     * @return the average number of reviews
     */
    public int avgReviews()
    {
        int totalReviews = 0;
        for(AirbnbListing property : properties){
            totalReviews += property.getNumberOfReviews();
        }
        return totalReviews / properties.size();
    }
    
    /**
     * Cauculate the average number of month
     * reviews of all properties.
     * @return the average number of month reviews
     */
    public double avgMonthReviews()
    {
        double totalReviews = 0;
        for(AirbnbListing property : properties){
            totalReviews += property.getReviewsPerMonth();
        }
        double avg = totalReviews / properties.size();
        avg = avg * 100;
        avg = Math.round(avg);
        avg = avg / 100;
        return avg;
    }
    
    /**
     * Get the number of available properties.
     * @return the number of available properties
     */
    public int avaiProperties()
    {
        return properties.size();
    }
    
    /**
     * Cauculate the number of entire home/apartment
     * room type in these properties.
     * @return the number of entire home/apartment 
     */
    public int noOfEntireHome()
    {
        int number = 0;
        for(AirbnbListing property : properties){
            if(property.getRoom_type().equals("Entire home/apt")){
                number++;
            }
        }
        return number;
    }
    
    /**
     * Cauculate the number of private
     * room type in these properties.
     * @return the number of private room
     */
    public int noOfPrivateRooms()
    {
        int number = 0;
        for(AirbnbListing property : properties){
            if(property.getRoom_type().equals("Private room")){
                number++;
            }
        }
        return number;
    }
    
    /**
     * Get the name of the most expensive property borough.
     * @return the name of the most expensive property borough
     */
    public String mostExpensive()
    {
        String name = null;
        int highestPrice = 0;
        for(AirbnbListing property : properties){
            int current = property.getPrice() * property.getMinimumNights();
            if(current > highestPrice){
                name = property.getName();
                highestPrice = current;
            }
        }
        return name;
    }
    
    /**
     * Get the name of the cheapest property borough.
     * @return the name of the cheapest property borough
     */
    public String cheapest()
    {
        String name = properties.get(0).getName();
        int lowestPrice = properties.get(0).getPrice() * properties.get(0).getMinimumNights();
        for(AirbnbListing property : properties){
            int current = property.getPrice() * property.getMinimumNights();
            if(current < lowestPrice){
                name = property.getName();
                lowestPrice = current;
            }
        }
        return name;
    }
    
    /**
     * Get the name of the property with
     * the most number of reviews.
     * @return the name of the property with 
     *         the most number of reviews
     */
    public String mostReviews()
    {
        String name = null;
        int review = 0;
        for(AirbnbListing property : properties){
            int current = property.getNumberOfReviews();
            if(current > review){
                name = property.getName();
                review = current;
            }
        }
        return name;
    }
}
