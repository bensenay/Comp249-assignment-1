//----------------------------------------------
// Assignment 1
// Question: Package : Client, Class: Client
// Written by: Benjamin Senay || 40341705 
//----------------------------------------------


package Client;

public class Client {
    private String clientID; //Unique client ID, its auto generated
    private String firstname, lastname, email; //Client attributes
    private static int nextID = 1001; // static variable to keep track of the next ID to assign
//client id generator so constructors can call it all in one place
private static String generateClientID() {return "C" + String.format("%03d", nextID++);} // Generate client ID and increment nextID
 
//default constructor
public Client() {
    clientID = generateClientID();
    firstname = "";
    lastname = "";
    email = "";
}
//parameterized constructor
public Client(String firstname, String lastname, String email) {

    this.clientID =  generateClientID();
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
}
//copy consctrutor (new id generated)
public Client(Client other) {
    this.clientID = generateClientID();
    this.firstname = other.firstname;
    this.lastname = other.lastname;
    this.email = other.email;
}
//--getters--
public String getClientID() {return clientID;}
public String getFirstname() {return firstname;}
public String getLastname() {return lastname;}
public String getEmail() {return email;}
//--setters--
public void setFirstname(String firstname) {this.firstname = firstname;}
public void setLastname(String lastname) {this.lastname = lastname;}
public void setEmail(String email) {this.email = email;}
//toString method
@Override
public String toString() {
    return "Client ID: " + clientID + ", Name: " + firstname + " " + lastname + ", Email: " + email;
}
//equals method ; compares all fiedls except clientID
//equals method; compares all fields except transportationId
    ////Returns false if:
// The passed object is null
// The passed object is of a different class
@Override
public boolean equals(Object obj) {
    if (this == obj) return true; // Check if  they are the same object
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Client other = (Client) obj;
    return this.firstname.equals(other.firstname) &&
           this.lastname.equals(other.lastname) &&
           this.email.equals(other.email);
    }
}