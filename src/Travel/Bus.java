package Travel;

public class Bus extends Transportation {
    private String busCompany;
    private int numberOfStops;
    //default constructor
    public Bus() {
        super();
        this.busCompany = "Unknown";
        this.numberOfStops = 0;
    }
    //parameterized constructor
    public Bus(String busCompany, int numberOfStops, String companyName, String departureCity, String arrivalCity) {
        super(companyName, departureCity, arrivalCity);
        this.busCompany = busCompany;
        this.numberOfStops = numberOfStops;
    }
    @Override
    public double calculateCost(int numberOfDays) {
        return 30.0 * numberOfDays; // Example cost calculation
    }
    //equals method; compares all fields except transportationId,
    // returns false if:
    // The passed object is null
    // The passed object is of a different class
    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Bus other = (Bus) obj;
        return this.busCompany.equals(other.busCompany) &&
               this.numberOfStops == other.numberOfStops &&
               super.equals(other); //compare inherited fields
    }
    //toString method
    @Override
    public String toString() {
        return super.toString() + ", Bus Company: " + busCompany + ", Number of Stops: " + numberOfStops;
    }

}
