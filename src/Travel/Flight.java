package Travel;

public class Flight extends Transportation {
    private String airlineName; 
    private double luggageAllowanceKg;
    //default constructor
    public Flight() {
        
        this.airlineName = "Unknown Airline";
        this.luggageAllowanceKg = 20.0; // Default luggage allowance
    }
    //parameterized constructor
    public Flight(String airlineName, double luggageAllowanceKg,String companyName, String departureCity, String arrivalCity) {
        super(companyName, departureCity,arrivalCity);
        this.airlineName = airlineName;
        this.luggageAllowanceKg = luggageAllowanceKg;
    }
    @Override
    public double calculateCost(int numberOfDays){
        return 200.0 * numberOfDays; // Example cost calculation
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
        Flight other = (Flight) obj;
        return this.airlineName.equals(other.airlineName) &&
               this.luggageAllowanceKg == other.luggageAllowanceKg &&
               super.equals(other); //compare inherited fields
    }
    //toString method
    @Override
    public String toString() {
        return super.toString() + ", Airline: " + airlineName + ", Luggage Allowance: " + luggageAllowanceKg + " kg";
    }
    //copy method
    @Override
    public Transportation copy() {
        return new Flight(this.airlineName, this.luggageAllowanceKg, this.companyName, this.departureCity, this.arrivalCity);
    }
    
}
