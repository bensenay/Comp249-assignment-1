package Travel;

public class Hotel extends Accommodation{
    //this is optional
    private int starRating;

    //default constructor
    public Hotel() {
        super();
        this.starRating = 0;
    }

    //parameterized constructor
    public Hotel(String name, String location, double pricePerNight, int starRating) {
        super(name, location, pricePerNight);
        this.starRating = starRating;
    }
    //copy constructor
    public Hotel(Hotel other) {
        super(other);
        this.starRating = other.starRating;
    }
    //calculate cost method
    @Override
    public double calculateCost(int numberOfDays) {
        return pricePerNight * numberOfDays;
    }
    //getter and setter for starRating
    public int getStarRating() {return starRating;}
    public void setStarRating(int starRating) {this.starRating = starRating;}
    //toString method
    @Override
    public String toString() {
        return "Hotel{" + super.toString() +
                ", starRating=" + starRating +
                ", cost=" + calculateCost(1) + // optional: remove if you don't like this
                "}";
    }
    //equals method:
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Hotel other = (Hotel) obj;
        return this.starRating == other.starRating;
    }
        //copy method
    @Override
    public Accommodation copy() {
        return new Hotel(this);
    }
    

}
