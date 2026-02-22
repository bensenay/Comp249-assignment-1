//----------------------------------------------
// Assignment 1
// Question: Package : Travel, Class: Train
// Written by: Benjamin Senay || 40341705 
//----------------------------------------------

package Travel;

public class Train extends Transportation {
    private String trainType;
    private String seatClass;
    private double fare;
    //default
    public Train() {
        this.trainType = "Unknown";
        this.seatClass = "Unknown";
        this.fare = 0.0;
    }
    //parameterized
    public Train(String trainType, String seatClass, String companyName, String departureCity, String arrivalCity, double Fare) {
        super(companyName, departureCity, arrivalCity);
        this.trainType = trainType;
        this.seatClass = seatClass;
        this.fare = Fare;
    }
    //copy constructor
    public Train(Train other) {
        super(other);
        this.trainType = other.trainType;
        this.seatClass = other.seatClass;
        this.fare = other.fare;
    }
    //getter and setter for trainType, seatClass, and fare
    public String getTrainType() {return trainType;}
    public void setTrainType(String trainType) {this.trainType = trainType;}
    public String getSeatClass() {return seatClass;}
    public void setSeatClass(String seatClass) {this.seatClass = seatClass;}
    public double getFare() {return fare;}
    public void setFare(double fare) {this.fare = fare;}
    
    @Override
    public double calculateCost(int numberOfDays) {
        double multiplier = seatClass.equalsIgnoreCase("Business") ? 1.25 : 1.0;
        return fare * multiplier;
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
        Train other = (Train) obj;
        return this.trainType.equals(other.trainType) &&
               this.seatClass.equals(other.seatClass) &&
               super.equals(other); //compare inherited fields
    }
    //toString method
    @Override
    public String toString() {
        return super.toString() + ", Train Type: " + trainType + ", Seat Class: " + seatClass;
    }

    //copy method
    @Override
    public Transportation copy() {
        return new Train(this.trainType, this.seatClass, this.companyName, this.departureCity, this.arrivalCity, this.fare);
    }

}
