//----------------------------------------------
// Assignment 1
// Question: Package : Travel, Class: Flight
// Written by: Benjamin Senay || 40341705 
//----------------------------------------------

package Travel;

public class Flight extends Transportation {
    private String airlineName; 
    private double luggageAllowanceKg;
    private double ticketPrice; 
    //default constructor
    public Flight() {
        super(); //call the default constructor of the superclass
        this.airlineName = "Unknown Airline";
        this.luggageAllowanceKg = 20.0; // Default luggage allowance
        this.ticketPrice = 200.0; // Default ticket price
    }
    //parameterized constructor
    public Flight(String airlineName, double luggageAllowanceKg,String companyName, String departureCity, String arrivalCity, double TicketPrice) {
        super(companyName, departureCity,arrivalCity);
        this.airlineName = airlineName;
        this.luggageAllowanceKg = luggageAllowanceKg;
        this.ticketPrice = TicketPrice; // Base ticket price, can be modified as needed
    }

    //copy constructor
    public Flight(Flight other) {
        super(other); // Call the copy constructor of the superclass
        this.airlineName = other.airlineName;
        this.luggageAllowanceKg = other.luggageAllowanceKg;
        this.ticketPrice = other.ticketPrice;
    }
    //getter and setter for airlineName and luggageAllowanceKg
    public String getAirlineName() {return airlineName;}
    public void setAirlineName(String airlineName) {this.airlineName = airlineName;}
    public double getLuggageAllowanceKg() {return luggageAllowanceKg;}
    public void setLuggageAllowanceKg(double luggageAllowanceKg) {this.luggageAllowanceKg = luggageAllowanceKg;}
    public double getTicketPrice() {return ticketPrice;}
    public void setTicketPrice(double ticketPrice) {this.ticketPrice = ticketPrice;}
    

    @Override
    public double calculateCost(int numberOfDays) {
        double baggageFee = (luggageAllowanceKg > 23) ? 40.0 : 0.0;
        return ticketPrice + baggageFee;
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
        return new Flight(this.airlineName, this.luggageAllowanceKg, this.companyName, this.departureCity, this.arrivalCity, this.ticketPrice);
    }

}
