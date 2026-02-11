package Travel;

public abstract class Transportation {
    protected String transportationId;//auto
    protected String companyName, departureCity, arrivalCity;
    protected static int nextId = 3001;

    //constructors; default, parameterized and copy
    public Transportation() {
        this.transportationId = "T" + nextId++;
        this.companyName = "";
        this.departureCity = "";
        this.arrivalCity = "";
    }
    //parameterized constructor
    public Transportation(String companyName, String departureCity, String arrivalCity) {
        this.transportationId = "T" + nextId++;
        this.companyName = companyName;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
    }
    //copy constructor (new id generated)
    public Transportation(Transportation other) {
        this.transportationId = "TR" + nextId++;
        this.companyName = other.companyName;
        this.departureCity = other.departureCity;
        this.arrivalCity = other.arrivalCity;
    }
    //getters
    public String getTransportationId() {return transportationId;}
    public String getCompanyName() {return companyName;}
    public String getDepartureCity() {return departureCity;}
    public String getArrivalCity() {return arrivalCity;}
    //setters
    public void setCompanyName(String companyName) {this.companyName = companyName;}
    public void setDepartureCity(String departureCity) {this.departureCity = departureCity;}
    public void setArrivalCity(String arrivalCity) {this.arrivalCity = arrivalCity;}
    //toString method
    @Override
    public String toString() {
        return "Transportation ID: " + transportationId + ", Company: " + companyName +
               ", Departure: " + departureCity + ", Arrival: " + arrivalCity;
    }
    //equals method; compares all fields except transportationId
    ////Returns false if:
    // The passed object is null
    // The passed object is of a different class
    // The companyName, departureCity, or arrivalCity fields do not match
    public boolean equals(Transportation other) {
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        return this.companyName.equals(other.companyName) &&
               this.departureCity.equals(other.departureCity) &&
               this.arrivalCity.equals(other.arrivalCity);
    }
    //public abstract double calculateCost(int numberOfDays); (polymorphic method requirement)
    public abstract double calculateCost(int numberOfDays);
    


}
