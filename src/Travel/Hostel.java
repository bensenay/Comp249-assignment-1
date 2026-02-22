//----------------------------------------------
// Assignment 1
// Question: Package : Travel, Class: Hostel
// Written by: Benjamin Senay || 40341705 
//----------------------------------------------

package Travel;

public class Hostel extends Accommodation {
    private int numberOfBedsPerRoom;
    //default
    public Hostel() {
        super();
        this.numberOfBedsPerRoom = 0;
    }
    //parameterized
    public Hostel(String name, String location, double pricePerNight, int numberOfBedsPerRoom) {
        super(name, location, pricePerNight);
        this.numberOfBedsPerRoom = numberOfBedsPerRoom;
    }
    //copy constructor
    public Hostel(Hostel other) {
        super(other);
        this.numberOfBedsPerRoom = other.numberOfBedsPerRoom;
    }
    //calculate cost method
    @Override
    public double calculateCost(int numberOfDays) {
        double base = pricePerNight * numberOfDays;
        return base * 0.85; //15 discount
    }
    //getter and setter for numberOfBedsPerRoom
    public int getNumberOfBedsPerRoom() {return numberOfBedsPerRoom;}
    public void setNumberOfBedsPerRoom(int numberOfBedsPerRoom) {this.numberOfBedsPerRoom = numberOfBedsPerRoom;}
    //toString method
    @Override
    public String toString() {
        return "Hostel{" + super.toString() +
                ", numberOfBedsPerRoom=" + numberOfBedsPerRoom +
                ", cost=" + calculateCost(1) + // optional: remove if you don't like this
                "}";
    }
     //equals method:
    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        Hostel other = (Hostel) obj;
        return this.numberOfBedsPerRoom == other.numberOfBedsPerRoom;
    }
    //copy method
    @Override
    public Accommodation copy() {
        return new Hostel(this);
    }


}
