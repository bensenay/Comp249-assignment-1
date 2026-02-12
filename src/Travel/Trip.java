package Travel;
import Client.Client;


public class Trip {
    
    //static int 
    private static int nextID = 2001; //trip ids start at  2001
    //instance variables:
    private String tripID;
    private String destination;
    private int durationInDays; 
    private double basePrice;
    
    private Client Client;
    private Transportation transportation;
    private Accommodation accommodation;

    //helper to generate ids
    public String generatetripID() {
        return "T" +nextID++;
    }
    //default constructor:
    public Trip() {
        this.tripID = generatetripID();
        this.destination = "Unknown";
        this.durationInDays = 0;
        this.basePrice = 0.0;
        this.Client = null;
        this.transportation = null;
        this.accommodation = null;
    }
    //parameterized constructor:
    public Trip(String destination, int durationInDays, double basePrice, Client Client, Transportation transportation, Accommodation accommodation) {
        this.tripID = generatetripID();
        this.destination = destination;
        this.durationInDays = durationInDays;
        this.basePrice = basePrice;
        this.Client = Client;
        this.transportation = transportation;
        this.accommodation = accommodation;
    }
    //copy constructor: 
    public Trip(Trip other) {
        this.tripID = other.tripID;
        this.destination = other.destination;
        this.durationInDays = other.durationInDays;
        this.basePrice = other.basePrice;
        
        this.Client = other.Client;
        this.transportation = other.transportation;
        this.accommodation = other.accommodation;
    }
    //getters
    public String getTripId() {return tripID;}
    public String getDestination() {return destination;}
    public int getDurationInDays() {return durationInDays;}
    public double getBasePrice() {return basePrice;}
    public Client getClient() {return Client;}
    public Transportation getTransportation() {return transportation;}
    public Accommodation getAccomodation() {return accommodation; }
    
    //setters
    public void setDestination(String destination) {this.destination = destination;}
    public void setDurationInDays(int durationInDays) {this.durationInDays = durationInDays;}
    public void setBasePrice(double basePrice) {this.basePrice = basePrice;}
    public void setClient(Client Client) { this.Client = Client;}
    public void setTransportation(Transportation transportation) {this.transportation = transportation;}
    public void setAccomodation(Accommodation accommodation) {this.accommodation = accommodation;}
    
    //Trip total cost uses polymorphism via calculateCost() in transport/accommodation
    public double calculateTotalCost() {
        double transportationCost = (transportation != null)? transportation.calculateCost(durationInDays): 0.0;

        double accommodationCost = (accommodation != null)? accommodation.calculateCost(durationInDays): 0.0;
    
        return basePrice + transportationCost + accommodationCost;
    }
    
    //toString
    @Override
    public String toString() {
        return "Trip{" +
                "tripId='" + tripID + '\'' +
                ", destination='" + destination + '\'' +
                ", durationInDays=" + durationInDays +
                ", basePrice=" + basePrice +
                ", client=" + (Client == null ? "null" : Client.toString()) +
                ", transportation=" + (transportation == null ? "null" : transportation.toString()) +
                ", accommodation=" + (accommodation == null ? "null" : accommodation.toString()) +
                ", totalCost=" + calculateTotalCost() +
                '}';
    }

    //equals method : (compare everything except automatically generated id
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Trip other = (Trip) obj;

        // Compare all attributes except tripId
        if (durationInDays != other.durationInDays) return false;
        if (Double.compare(basePrice, other.basePrice) != 0) return false;

        if (destination == null) {
            if (other.destination != null) return false;
        } else if (!destination.equals(other.destination)) return false;

        if (Client == null) {
            if (other.Client != null) return false;
        } else if (!Client.equals(other.Client)) return false;

        if (transportation == null) {
            if (other.transportation != null) return false;
        } else if (!transportation.equals(other.transportation)) return false;

        if (accommodation == null) {
            if (other.accommodation != null) return false;
        } else if (!accommodation.equals(other.accommodation)) return false;

        return true;
    }
}



