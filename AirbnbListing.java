
/**
 * Represents one listing of a property for rental on Airbnb.
 * This is essentially one row in the data table. Each column
 * has a corresponding field.
 */ 

public class AirbnbListing {
    /**
     * The id and name of the individual property
     */
    private String id;
    private String name;
    /**
     * The id and name of the host for this listing.
     * Each listing has only one host, but one host may
     * list many properties.
     */
    private String host_id;
    private String host_name;

    /**
     * The grouped location to where the listed property is situated.
     * For this data set, it is a london borough.
     */
    private String neighbourhood;

    /**
     * The location on a map where the property is situated.
     */
    private double latitude;
    private double longitude;

    /**
     * The type of property, either "Private room" or "Entire Home/apt".
     */
    private String room_type;

    /**
     * The price per night's stay
     */
    private static int price;

    /**
     * The minimum number of nights the listed property must be booked for.
     */
    private static int minimumNights;
    private int numberOfReviews;

    /**
     * The date of the last review, but as a String
     */
    private String lastReview;
    private double reviewsPerMonth;

    /**
     * The total number of listings the host holds across AirBnB
     */
    private int calculatedHostListingsCount;
    /**
     * The total number of days in the year that the property is available for
     */
    private int availability365;
    private int numberEntireHomes;
    private int size;
    private int overseas;
    private boolean isFavourite;
    private int numberFavourites;
    private boolean outdoor;
    private int numberOutdoor;
    public AirbnbListing(String id, String name, String host_id,
                         String host_name, String neighbourhood, double latitude,
                         double longitude, String room_type, int price,
                         int minimumNights, int numberOfReviews, String lastReview,
                         double reviewsPerMonth, int calculatedHostListingsCount, int availability365
                         ) {
        this.id = id;
        this.name = name;
        this.host_id = host_id;
        this.host_name = host_name;
        this.neighbourhood = neighbourhood;
        this.latitude = latitude;
        this.longitude = longitude;
        this.room_type = room_type;
        this.price = price;
        this.minimumNights = minimumNights;
        this.numberOfReviews = numberOfReviews;
        this.lastReview = lastReview;
        this.reviewsPerMonth = reviewsPerMonth;
        this.calculatedHostListingsCount = calculatedHostListingsCount;
        this.availability365 = availability365;
        setSize(size);
       
    }
    public boolean entireHomes()
    {   if(name.contains("room") || name.contains("share")) {return false;}
        return true;}
    //independent homes rather than room in shared space
    public int numberEntireHomes()
    { if(entireHomes()) {numberEntireHomes++;}
    return numberEntireHomes;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHost_id() {
        return host_id;
    }

    public String getHost_name() {
        return host_name;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getRoom_type() {
        return room_type;
    }
    public void setSize(int size)
    {size=0;}
    
    public int getSize()
    { 
        return size;
    }
    public boolean overseas()
    {return false;}
    //number of bookings from overseas
    public int numberOverseas()
    {if(overseas()) {overseas++;}
    return overseas;
    }
    public static int getPrice() {
        return price;
    }
    
    public static int getMinimumNights() {
        return minimumNights;
    }
    
    public int getNumberOfReviews() {
        return numberOfReviews;
    }
    //minimum cost of a booking is price multiplied by minimum nights
    public static int minimumCost()
    {int minimumCost = getPrice()*getMinimumNights();
        return minimumCost;
    }
   public int numberOfReviews()
    {
        return numberOfReviews;
    }
   public void toggleFavourite()
   {  isFavourite=!isFavourite;
    }
    //number favourite clicks as chosen by user
    public int numberFavourites()
    { if(isFavourite) {numberFavourites++;}
    return numberFavourites;
    }
    public String getLastReview() {
        return lastReview;
    }

    public double getReviewsPerMonth() {
        return reviewsPerMonth;
    }
    public void outdoorSpace()
    { outdoor =!outdoor;
    }
    public int numberOutdoor()
    {if(outdoor) {numberOutdoor++;}
    return numberOutdoor;
    }
    public int getCalculatedHostListingsCount() {
        return calculatedHostListingsCount;
    }

    public int getAvailability365() {
        return availability365;
    }

    @Override
    public String toString() {
        return "AirbnbListing{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", host_id='" + host_id + '\'' +
                ", host_name='" + host_name + '\'' +
                ", neighbourhood='" + neighbourhood + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", room_type='" + room_type + '\'' +
                ", price=" + price +
                ", minimumNights=" + minimumNights +
                ", numberOfReviews=" + numberOfReviews +
                ", lastReview='" + lastReview + '\'' +
                ", reviewsPerMonth=" + reviewsPerMonth +
                ", calculatedHostListingsCount=" + calculatedHostListingsCount +
                ", availability365=" + availability365 +
                '}';
    }

    
}
