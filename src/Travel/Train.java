package Travel;

public class Train extends Transportation {
    private String trainType;
    private String seatClass;
    //default
    public Train() {
        this.trainType = "Unknown";
        this.seatClass = "Unknown";
    }
    //parameterized
    public Train(String trainType, String seatClass, String companyName, String departureCity, String arrivalCity) {
        super(companyName, departureCity, arrivalCity);
        this.trainType = trainType;
        this.seatClass = seatClass;
    }
    @Override
    public double calculateCost(int numberOfDays) {
        return 50.0 * numberOfDays; // Example cost calculation
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
        return new Train(this.trainType, this.seatClass, this.companyName, this.departureCity, this.arrivalCity);
    }
    
}
