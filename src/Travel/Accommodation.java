package Travel;

public abstract class Accommodation {
    
    //id
    private static int nextId = 4001;

    //instance vars
    protected String accommodationId;
    protected String name;
    protected String location;
    protected double pricePerNight;

    //helper to generate unique accommodation IDs
    protected static String generateAccommodationId() {
        return "A" + (nextId++);
    }

    //default constructor
    public Accommodation() {
        this.accommodationId = generateAccommodationId();
        this.name = "Unknown";
        this.location = "Unknown";
        this.pricePerNight = 0.0;
    }
    //parameterized constructor
    public Accommodation(String name, String location, double pricePerNight) {
        this.accommodationId = generateAccommodationId();
        this.name = name;
        this.location = location;
        this.pricePerNight = pricePerNight;
    }
    //copy constructor  -> new id
    public Accommodation(Accommodation other) {
        this.accommodationId = generateAccommodationId();
        this.name = other.name;
        this.location = other.location;
        this.pricePerNight = other.pricePerNight;
    }
    //required abstract method to calculate cost
    public abstract double calculateCost(int numberOfDays);
    //getters
    public String getAccommodationId() {return accommodationId;}
    public String getName() {return name;}
    public String getLocation() {return location;}
    public double getPricePerNight() {return pricePerNight;}
    //setters
    public void setName(String name) {this.name = name;}
    public void setLocation(String location) {this.location = location;}
    public void setPricePerNight(double pricePerNight) {this.pricePerNight = pricePerNight;}
    //toString method
    @Override
    public String toString() {
        return "Accomodation{" +
                "accommodationId='" + accommodationId + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", pricePerNight=" + pricePerNight +
                '}';
    }
    //equals method - based on name and location (not id)
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Accommodation other = (Accommodation) obj;

        // compare everything except accommodationId
        if (Double.compare(pricePerNight, other.pricePerNight) != 0) return false;

        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;

        if (location == null) {
            if (other.location != null) return false;
        } else if (!location.equals(other.location)) return false;

        return true;
    }
    




}
