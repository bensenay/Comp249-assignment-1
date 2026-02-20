package Driver;
import java.util.Scanner;

import Client.Client;
import Travel.Accommodation;
import Travel.Hotel;
import Travel.Hostel;
import Travel.Train;
import Travel.Transportation;
import Travel.Bus;
import Travel.Flight;
import Travel.Trip;
import visualization.TripChartGenerator;

public class Driver {
    //capacity constants:
    private static final int MAX_CLIENTS = 100;
    private static final int MAX_TRIPS = 100;
    private static final int MAX_TRANSPORTATIONS = 100;
    private static final int MAX_ACCOMMODATIONS = 100;
    
    //set variables with default values
    static int ClientCount = 0;
    static int AccommodationCount = 0;
    static int TransportationCount = 0;
    static int TripCount = 0;
    
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        //arrays ; must be partially filled
        Client[] clients = new Client[MAX_CLIENTS];
        Accommodation[] accommodations = new Accommodation[MAX_ACCOMMODATIONS];
        Transportation[] transportations = new Transportation[MAX_TRANSPORTATIONS];
        Trip[] trips = new Trip[MAX_TRIPS];

        //scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Smart Travel Planner!");
        //user must choose between a predefined scenario or menu driven interface
        System.out.println("Please choose an option:");
        System.out.println("1. Run predefined scenario");
        System.out.println("2. Use menu-driven interface");
        int choice = scanner.nextInt();
        
        while (true) {
            if (choice == 1) {
                runPredefinedScenario(clients, trips, transportations, accommodations);
                break;
            } else if (choice == 2) {
                runMenu(scanner, clients, trips, transportations, accommodations);
                break;
            } else {
                System.out.println("Invalid choice. Please enter 1 or 2.");
                choice = scanner.nextInt();
            }
    }  
}
    
        //main menu display
        private static void printMainMenu() {
            System.out.println("\n====== MAIN MENU ======");
            System.out.println("1) Client Management");
            System.out.println("2) Trip Management");
            System.out.println("3) Transportation Management");
            System.out.println("4) Accommodation Management");
            System.out.println("5) Additional Operations");
            System.out.println("0) Exit");
        }
        //run predefined scenario
        private static void runPredefinedScenario(Client[] clients, Trip[] trips,
            Transportation[] transportations,
            Accommodation[] accommodations) {
            System.out.println("\n=== Running Predefined Scenario ===");

            // Requirement sizes
            final int clientsNeeded = 3;
            final int tripsNeeded = 3;
            final int transportNeeded = 6; // 2 flight + 2 train + 2 bus
            final int accomNeeded = 4;     // 2 hotel + 2 hostel

            // Capacity check
            if (ClientCount + clientsNeeded > MAX_CLIENTS ||
            TripCount + tripsNeeded > MAX_TRIPS ||
            TransportationCount + transportNeeded > MAX_TRANSPORTATIONS ||
            AccommodationCount + accomNeeded > MAX_ACCOMMODATIONS) {
            System.out.println("Not enough space in arrays to run predefined scenario.");
            return;
            }

            // =========================
            // 1) CREATE CLIENTS (3)
            // =========================
            Client c1 = new Client("Benjamin", "Senay", "benjamin@example.com");
            Client c2 = new Client("Alex", "Martin", "alex@example.com");
            Client c3 = new Client("Sara", "Lopez", "sara@example.com");

            clients[ClientCount++] = c1;
            clients[ClientCount++] = c2;
            clients[ClientCount++] = c3;

            // ==========================================
            // 2) CREATE TRANSPORTATION (2 of each type)
            // ==========================================
            // Flights (2)
            Transportation f1 = new Flight("Air Canada", 35.0, "Air Canada", "Montreal", "Paris",1200);
            Transportation f2 = new Flight("Air France", 40.0, "Air France", "Paris", "Rome",1500);

             // Trains (2)
            Transportation tr1 = new Train("TGV", "Economy", "SNCF", "Paris", "Lyon",150);
            Transportation tr2 = new Train("Frecciarossa", "Business", "Trenitalia", "Rome", "Milan",100);

            // Buses (2)
            Transportation b1 = new Bus("Orleans Express", 2, "Orleans Express", "Montreal", "Quebec",100);
            Transportation b2 = new Bus("FlixBus", 1, "FlixBus", "Lyon", "Geneva",300);

            transportations[TransportationCount++] = f1;
            transportations[TransportationCount++] = f2;
            transportations[TransportationCount++] = tr1;
            transportations[TransportationCount++] = tr2;
            transportations[TransportationCount++] = b1;
            transportations[TransportationCount++] = b2;

            // ==========================================
            // 3) CREATE ACCOMMODATIONS (2 of each type)
            // ==========================================
            // Hotels (2)
            Accommodation h1 = new Hotel("Hilton Paris", "Paris", 220.0, 4);
            Accommodation h2 = new Hotel("Rome Grand Hotel", "Rome", 260.0, 5);

            // Hostels (2)
            Accommodation hs1 = new Hostel("Youth Hostel Lyon", "Lyon", 55.0, 6);
            Accommodation hs2 = new Hostel("Backpackers Milan", "Milan", 65.0, 8);

            accommodations[AccommodationCount++] = h1;
            accommodations[AccommodationCount++] = h2;
            accommodations[AccommodationCount++] = hs1;
            accommodations[AccommodationCount++] = hs2;

            // =========================
            // 4) CREATE TRIPS (3)
            // =========================
            // Mix different clients, transportation, and accommodations
            Trip t1 = new Trip("Paris", 5, 500.0, c1, f1, h1);   // flight + hotel
            Trip t2 = new Trip("Lyon", 3, 250.0, c2, tr1, hs1);  // train + hostel
            Trip t3 = new Trip("Rome", 6, 650.0, c3, f2, h2);    // flight + hotel

            trips[TripCount++] = t1;
            trips[TripCount++] = t2;
            trips[TripCount++] = t3;

            // =========================
            // 5) PRINT EVERYTHING
            // =========================
            System.out.println("\n--- Clients Created ---");
            for (int i = 0; i < ClientCount; i++) {
                if (clients[i] != null) {
                    System.out.println(clients[i]);
                }
            }

            System.out.println("\n--- Transportation Created ---");
                for (int i = 0; i < TransportationCount; i++) {
                    if (transportations[i] != null) {
                        System.out.println(transportations[i]);
                }
            }

            System.out.println("\n--- Accommodations Created ---");
                for (int i = 0; i < AccommodationCount; i++) {
                    if (accommodations[i] != null) {
                        System.out.println(accommodations[i]);
                }
            }

            System.out.println("\n--- Trips Created ---");
                for (int i = 0; i < TripCount; i++) {
                    if (trips[i] != null) {
                        System.out.println(trips[i]);
                        System.out.println("Total cost: $" + trips[i].calculateTotalCost());
                }
            }   

// =========================
// 6) Most expensive trip
// =========================
if (TripCount > 0) {
Trip mostExpensive = trips[0];
for (int i = 1; i < TripCount; i++) {
if (trips[i] != null &&
trips[i].calculateTotalCost() > mostExpensive.calculateTotalCost()) {
mostExpensive = trips[i];
}
}

System.out.println("\nMost expensive trip:");
System.out.println(mostExpensive);
System.out.println("Total cost: $" + mostExpensive.calculateTotalCost());
}

// =========================
// 7) Generate charts (optional)
// =========================
try {
java.io.File outDir = new java.io.File("output");
if (!outDir.exists()) {
outDir.mkdirs();
}

TripChartGenerator.generateCostBarChart(trips, TripCount);
TripChartGenerator.generateDestinationPieChart(trips, TripCount);
TripChartGenerator.generateDurationLineChart(trips, TripCount);

System.out.println("\nCharts generated in /output folder.");
} catch (Exception e) {
System.out.println("\nCharts not generated (library/path issue): " + e.getMessage());
}

System.out.println("\n=== Predefined Scenario Complete ===\n");
}

        //The program must also include a method that creates and returns a deep copy of an array of transportation objects:
        //use the copy method in subclasses
        public static Transportation[] deepCopyTransportationArray(Transportation[] original, int count) {     
            Transportation[] copy = new Transportation[original.length];
            for (int i = 0; i < count; i++) {
                if (original[i] != null) {
                    copy[i] = original[i].copy(); //use the copy method defined in transportation and its subclasses
                }
            }
            return copy;
        }       
        

        //----------------------------------------------
        //run menu
        public static void runMenu(Scanner s, Client[] clients, Trip[] trips, Transportation[] transports, Accommodation[] accommodations) {
            Scanner scanner = s;
            //reset our vars
            int clientCount = 0;
            int tripCount = 0;
            int transportCount = 0;
            int accomCount = 0;
            //set the menu loop to true
            boolean menuloop = true;

            while (menuloop) {
                printMainMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                //begin switch statement for menu options
                switch (choice) {
                    //first case: client management:
                        //add a client
                        //edit a clien
                        //delete a client
                        //list all clients
                //----------------------------------case 1-----------------------------
                    case 1:
                        System.out.println("\n--- Client Management ---");
                        System.out.println("1) Add Client");
                        System.out.println("2) Edit Client");
                        System.out.println("3) Delete Client");
                        System.out.println("4) List All Clients");
                        System.out.print("Enter your choice: ");
                        int clientChoice = scanner.nextInt();
                        switch (clientChoice) {
                            case 1:
                                //add client; using package client, using setters to set attributes
                                //first ; check if client list is full:
                                if (clientCount >= MAX_CLIENTS) {
                                    System.out.println("Client list is full. Cannot add more clients.");
                                    break;
                                }else {
                                //ask user for first name, last name, email, and create a new client object with those attributes, then add to clients array and increment clientCount
                                    System.out.println("Enter client's first name: ");
                                    String firstName = scanner.next();
                                    System.out.println("Enter client's last name: ");
                                    String lastName = scanner.next();
                                    System.out.println("Enter client's email: ");
                                    String email = scanner.next();
                                    Client newClient = new Client(firstName, lastName, email);
                                
                                    clients[clientCount++] = newClient;
                                    //check to see if it worked
                                    System.out.println("Added client: " + clients[clientCount-1]);
                                    //exit out of case1
                                    break;

                                }
                            case 2:
                                //edit client
                                //ask user for client ID, 
                                // search for client in clients array
                                //if found ask user which attribute to edit 
                                // (first name, last name, email), then use setters to update the attribute
                                System.out.println("Enter client ID to edit: ");
                                String clientID_edit = scanner.next();
                                //check if the client id is in the client database
                                boolean found = false;  //set bool value to false to say it isnt found
                                for (int i = 0; i < clientCount; i++) { //set a for loop to iterate through each client id
                                    if (clients[i].getClientID().equals(clientID_edit)) { //if it is found
                                        found = true; //change bool value to true
                                        System.out.println("Client found: " + clients[i]);
                                        //give user the option of wich attribute to edit
                                        System.out.println("Client found: " + clients[i]);
                                        System.out.println("Which attribute would you like to edit?");
                                        System.out.println("1) First Name");
                                        System.out.println("2) Last Name");
                                        System.out.println("3) Email");
                                        int editChoice = scanner.nextInt();
                                        switch (editChoice) {
                                            case 1:
                                                System.out.println("Enter new first name: ");
                                                String newFirstName = scanner.next();
                                                clients[i].setFirstname(newFirstName);
                                                System.out.println("Client updated: " + clients[i]);
                                                break;
                                            case 2:
                                                System.out.println("Enter new last name: ");
                                                String newLastName = scanner.next();
                                                clients[i].setLastname(newLastName);
                                                System.out.println("Client updated: " + clients[i]);
                                                break;
                                            case 3:
                                                System.out.println("Enter new email: ");
                                                String newEmail = scanner.next();
                                                clients[i].setEmail(newEmail);
                                                System.out.println("Client updated: " + clients[i]);
                                                break;
                                            default:
                                                System.out.println("Invalid choice. No changes made.");
                                        }
                                        break; // exit loop after finding client
                                    }
                                }
                                
                            case 3:
                                //delete client
                                //in this case, we will delete client by setting the client object to null 
                                //shifting all clients after it one position to the left 
                                // then decrementing clientCount
                                System.out.println("Enter client ID to delete: ");
                                String clientID_delete = scanner.next();
                                boolean found_delete = false;  //set bool value to false to say it isnt found
                                for (int i = 0; i < clientCount; i++) { //set a for loop to iterate through each client id
                                    if (clients[i].getClientID().equals(clientID_delete)) { //if it is found
                                        found_delete = true; //change bool value to true
                                        //delete client by shifting all clients after it one position to the left and decrementing clientCount
                                        for (int j = i; j < clientCount - 1; j++) {
                                            clients[j] = clients[j + 1];
                                        }
                                        clients[--clientCount] = null; //set last client to null and decrement count
                                        System.out.println("Client deleted successfully.");
                                        break; // exit loop after deleting client
                                    }else {
                                        System.out.println("Client ID not found. Please try again.");// if client id not found, user can retry
                                    }
                                }
                                //delete explanation:
                                //we first ask the user for the client ID they wish to delete. 
                                // We then search through the clients array to find a client with a matching ID. 
                                // If we find a match, we set a boolean variable found_delete to true 
                                // to indicate that we found the client. We then delete the client by shifting
                                //  all clients that come after it one position to the left in the array, 
                                // effectively overwriting the client we want to delete. Finally, we set 
                                // the last client in the array (which is now a duplicate after the shift)
                                //  to null and decrement the clientCount variable to reflect that we have one less client in our list. 
                                // If we do not find a matching client ID, we inform the user and allow them to try again. 
                                //we have to shift the clients after the deleted client to maintain a contiguous list of clients in the array,
                                //if not, we would have an empty slot in the middle of the array which could cause issues when we try to list clients or add new clients.
                                //so we take after to the right of the client we deleted, increment to the left

                                //take index of client wished to delete: every client after that index is 'copied' one position to the left, 
                                // essentially overwriting the client we want to delete. Then we set the last client in the array 
                                // (which is now a duplicate after the shift) to null 
                                // and decrement the clientCount variable to reflect that we have one less client in our list.
                            case 4:
                                //list all clients
                                //for this case, we will list all the clients by simply iterating 
                                // through the clients array and printing each client object until 
                                // we reach a null value (indicating the end of the list)
                                System.out.println("Listing all clients:");
                                int cNBR = 1;
                                for (int i = 0; i < clientCount; i++) {
                                    //run until it is null:
                                    if (clients[i] == null) {
                                        break;
                                    }else {
                                        System.out.println("Client #" + cNBR + clients[i]);
                                        cNBR++; //increment client number for display 
                                    }
                                }
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        break;
                        
        //---------------------------case 2: trip management----------------------------
                    case 2:
                        System.out.println("\n--- Trip Management ---");
                        System.out.println("1) Add Trip");
                        System.out.println("2) Edit Trip");
                        System.out.println("3) Delete Trip");
                        System.out.println("4) List All Trips");
                        System.out.print("Enter your choice: ");
                        int tripChoice = scanner.nextInt();
                        switch (tripChoice) {
                            case 1:
                                //add trip; using package trip, using setters to set attributes
                                //first check if trip list is full:
                                if (tripCount >= MAX_TRIPS) {
                                    System.out.println("Trip list is full. Cannot add more trips.");
                                    break;
                                }else {
                                //ask user for destination, duration in days, base price, and create a new trip object with those attributes, then add to trips array and increment tripCount
                                    System.out.println("Enter trip destination: ");
                                    String destination = scanner.next();
                                    System.out.println("Enter trip duration in days: ");
                                    int durationInDays = scanner.nextInt();
                                    System.out.println("Enter trip base price: ");
                                    double basePrice = scanner.nextDouble();
                                    Trip newTrip = new Trip(destination, durationInDays, basePrice, null, null, null);
                                
                                    trips[tripCount++] = newTrip;
                                    //check to see if it worked
                                    System.out.println("Added trip: " + trips[tripCount]);
                                }
                                break;
                            case 2:
                                //edit trip; (same method used for client editing, 
                                // but with trip attributes: destination, duration in days, base price)
                                //search for trip id
                                //if found ask user which attribute to edit and use setters to update the attribute
                                 System.out.println("Enter trip ID to edit: ");
                                String tripID_edit = scanner.next();
                                //check if the trip id is in the trip database
                                boolean found_trip = false;  //set bool value to false to say it isnt found
                                for (int i = 0; i < tripCount; i++) { //set a for loop to iterate through each trip id
                                    if (trips[i].getTripId().equals(tripID_edit)) { //if it is found
                                        found_trip = true; //change bool value to true
                                        //give user the option of wich attribute to edit
                                        System.out.println("Trip found: " + trips[i]);
                                        System.out.println("Which attribute would you like to edit?");
                                        System.out.println("1) Destination");
                                        System.out.println("2) Duration in Days");
                                        System.out.println("3) Base Price");
                                        int editChoice = scanner.nextInt();
                                        switch (editChoice) {
                                            case 1:
                                                System.out.println("Enter new destination: ");
                                                String newDestination = scanner.next();
                                                trips[i].setDestination(newDestination);
                                                System.out.println("Trip updated: " + trips[i]);
                                                break;
                                            case 2:
                                                System.out.println("Enter new duration in days: ");
                                                int newDuration = scanner.nextInt();
                                                trips[i].setDurationInDays(newDuration);
                                                System.out.println("Trip updated: " + trips[i]);
                                                break;
                                            case 3:
                                                System.out.println("Enter new base price: ");
                                                double newBasePrice = scanner.nextDouble();
                                                trips[i].setBasePrice(newBasePrice);
                                                System.out.println("Trip updated: " + trips[i]);
                                                break;
                                            default:
                                                System.out.println("Invalid choice. No changes made.");
                                        }
                                        break; //exit loop after finding trip
                                    }else {
                                        System.out.println("Trip ID not found. Please try again.");// if trip id not found, user can retry
                                    }
                                }
                                break;
                            case 3:
                                //delete trip; same method as client deletion, but with trips array and tripCount
                                System.out.println("Enter trip ID to delete: ");
                                String tripID_delete = scanner.next();
                                boolean found_delete_trip = false;  //set bool value to false to say it isnt found
                                for (int i = 0; i < tripCount; i++) { //set a for loop to iterate through each trip id
                                    if (trips[i].getTripId().equals(tripID_delete)) { //if it is found
                                        found_delete_trip = true; //change bool value to true
                                        //delete trip by shifting all trips after it one position to the left and decrementing tripCount
                                        for (int j = i; j < tripCount - 1; j++) {
                                            trips[j] = trips[j + 1];
                                        }
                                        trips[--tripCount] = null; //set last trip to null and decrement count
                                        System.out.println("Trip deleted successfully.");
                                        break; //exit loop after deleting trip
                                    }else {
                                        System.out.println("Trip ID not found. Please try again.");// if trip id not found, user can retry
                                    }
                                }
                                //delete explanation:
                                //this is the same method used as for client deletion, but with trips array and tripCount. 

                                break;
                            case 4:
                                //list all trips
                                System.out.println("Listing all trips:");
                                int tNBR = 1;
                                for (int i = 0; i < tripCount; i++) {
                                    //run until it is null:
                                    if (trips[i] == null) {
                                        break;
                                    }else {
                                        System.out.println("Trip #" + tNBR + trips[i]);
                                        tNBR++; //increment trip number for display 
                                    }
                                }
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        break;

        //-------------------------------case 3: transportation management-------------------------------
                    case 3:
                        System.out.println("\n--- Transportation Management ---");
                        System.out.println("1) Add Transportation");
                        System.out.println("2) Edit Transportation");
                        System.out.println("3) Delete Transportation");
                        System.out.println("4) List All Transportations");
                        System.out.print("Enter your choice: ");
                        int transportChoice = scanner.nextInt();
                        switch (transportChoice) {
                            case 1:
                                //add transportation; using package transportation, using setters to set attributes
                                //first check if transportation list is full:
                                if (transportCount >= MAX_TRANSPORTATIONS) {
                                    System.out.println("Transportation list is full. Cannot add more transportations.");
                                    break;
                                }else {
                                //ask user for type (flight, train, bus), cost per day, and create a new transportation object with those attributes, then add to transportations array and increment transportCount
                                    System.out.println("Enter transportation type (flight, train, bus): ");
                                    String type = scanner.next();
                                    Transportation newTransport = null;
                                    switch (type.toLowerCase()) {
                                        case "flight":
                                            newTransport = new Flight("Unknown Airline", 20.0, "Unknown Company", "Unknown Departure City", "Unknown Arrival City", 500.0);
                                            break;
                                        case "train":
                                            newTransport = new Train("Unknown Train Type", "Unknown Seat Class", "Unknown Company", "Unknown Departure City", "Unknown Arrival City", 100.0);
                                            break;
                                        case "bus":
                                            newTransport = new Bus("Unknown Bus Company", 10, "Unknown Company", "Unknown Departure City", "Unknown Arrival City", 50.0);
                                            break;
                                        default:
                                            System.out.println("Invalid transportation type. Please try again.");
                                            break;
                                    }
                                    if (newTransport != null) {
                                        transports[transportCount++] = newTransport;
                                        System.out.println("Added transportation: " + transports[transportCount - 1]);
                                    }
                                }
                                break;
                    case 4:
                        //accomodation management
                        //for accomodation : there is -Add an accommodation
                                                      //-Remove an accommodation
                                                        //- List accommodations by type (Hotel, Hostel)
                        System.out.println("\n--------------- Accommodation Management ---------------");
                        System.out.println("1) Add Accommodation");
                        System.out.println("2) Remove Accommodation");
                        System.out.println("3) List Accommodations by Type");
                        System.out.print("Enter your choice: ");
                        int accomChoice = scanner.nextInt();
                        switch (accomChoice) {
                            case 1:
                                //add accommodation; using package accommodation, using setters to set attributes
                                //first check if accommodation list is full:
                                if (accomCount >= MAX_ACCOMMODATIONS) {
                                    System.out.println("Accommodation list is full. Cannot add more accommodations.");
                                    break;
                                }else {
                                //ask user for type (hotel, hostel), cost per day, and create a new accommodation object with those attributes, then add to accommodations array and increment accomCount
                                    System.out.println("Enter accommodation type (hotel, hostel): ");
                                    String type = scanner.next();
                                    System.out.println("Enter accommodation cost per day: ");
                                    double costPerDay = scanner.nextDouble();
                                    Accommodation newAccom = null;
                                    switch (type.toLowerCase()) {
                                        case "hotel":
                                            newAccom = new Hotel("Unknown Hotel Name", "Unknown Location", 150.5, 10);
                                            break;
                                        case "hostel":
                                            newAccom = new Hostel("Unknown Hostel Name", "Unknown Location", 50.0, 4);
                                            break;
                                        default:
                                            System.out.println("Invalid accommodation type. Please try again.");
                                            break;
                                    }
                                    if (newAccom != null) {
                                        accommodations[accomCount++] = newAccom;
                                        System.out.println("Added accommodation: " + accommodations[accomCount - 1]);
                                    }
                                    break;
                                }
                            case 2:
                                //remove accommodation; same method as client deletion, but with accommodations array and accomCount
                                System.out.println("Enter accommodation ID to delete: ");  
                                String accomID_delete = scanner.next();
                                boolean found_delete_accom = false;  //set bool value to false to say it isnt found
                                for (int i = 0; i < accomCount; i++) { //set a for loop to iterate through each accommodation id
                                    if (accommodations[i].getAccommodationId().equals(accomID_delete)) { //if it is found
                                        found_delete_accom = true; //change bool value to true
                                        //delete accommodation by shifting all accommodations after it one position to the left and decrementing accomCount
                                        for (int j = i; j < accomCount - 1; j++) {
                                            accommodations[j] = accommodations[j + 1];
                                        }
                                        accommodations[--accomCount] = null; //set last accommodation to null and decrement count
                                        System.out.println("Accommodation deleted successfully.");
                                        break; //exit loop after deleting accommodation
                                    }else {
                                        System.out.println("Accommodation ID not found. Please try again.");// if accommodation id not found, user can retry
                            }
                        }
                            break;
                            case 3:
                                //list accommodations by type (hotel, hostel)
                                System.out.println("Enter accommodation type to list (hotel, hostel): ");
                                String accomType = scanner.next();
                                System.out.println("Listing all " + accomType + "s:");
                                int aNBR = 1;
                                for (int i = 0; i < accomCount; i++) {
                                    if (accommodations[i] == null) {
                                        break;
                                    }else {
                                        if (accomType.equalsIgnoreCase("hotel") && accommodations[i] instanceof Hotel) {
                                            System.out.println("Accommodation #" + aNBR + accommodations[i]);
                                            aNBR++;
                                        } else if (accomType.equalsIgnoreCase("hostel") && accommodations[i] instanceof Hostel) {
                                            System.out.println("Accommodation #" + aNBR + accommodations[i]);
                                            aNBR++;
                                        }
                                    }
                                }
                            }
                            break;
                    case 5:
                                // 5. Additional Operations
                                //-Display the most expensive trip
                                //-Calculate and display the total cost of a trip (polymorphic behavior)  Create a deep copy of the transportation array
                                //-Create a deep copy of the accommodation array
                                System.out.println("\n----------- Additional Operations ------------");
                                System.out.println("1) Display the most expensive trip");
                                System.out.println("2) Calculate and display the total cost of a trip");
                                System.out.println("3) Create a deep copy of the transportation array");
                                System.out.println("4) Create a deep copy of the accommodation array");
                                System.out.print("Enter your choice: ");
                                int additionalChoice = scanner.nextInt();
                                switch (additionalChoice) {
                                    case 1:
                                        //display the most expensive trip
                                        if (tripCount == 0) {
                                            System.out.println("No trips available.");
                                        } else {
                                            Trip mostExpensiveTrip = trips[0];
                                            for (int i = 1; i < tripCount; i++) {
                                                if (trips[i].calculateTotalCost() > mostExpensiveTrip.calculateTotalCost()) {
                                                    mostExpensiveTrip = trips[i];
                                                }
                                            }
                                            System.out.println("Most expensive trip: " + mostExpensiveTrip);
                                        }
                                        break;
                                    case 2:
                                        //calculate and display the total cost of a trip
                                        System.out.println("Enter trip ID to calculate total cost: ");
                                        String tripID_cost = scanner.next();
                                        boolean found_trip_cost = false;  //set bool value to false to say it isnt found
                                        for (int i = 0; i < tripCount; i++) { //set a for loop to iterate through each trip id
                                            if (trips[i].getTripId().equals(tripID_cost)) { //if it is found
                                                found_trip_cost = true; //change bool value to true
                                                double totalCost = trips[i].calculateTotalCost();
                                                System.out.println("Total cost of trip " + trips[i].getTripId() + ": $" + totalCost);
                                                break; //exit loop after finding trip
                                            }else {
                                                System.out.println("Trip ID not found. Please try again.");// if trip id not found, user can retry
                                            }
                                        }
                                        break;
                                    case 3:
                                        //create a deep copy of the transportation array
                                        //use the deepCopyTransportationArray method defined earlier, passing in the transports array and transportCount
                                        Transportation[] transportCopy = deepCopyTransportationArray(transports, transportCount);

                                        System.out.println("Deep copy of transportation array created successfully.");
                                        break;
                                    case 4:
                                        //create a deep copy of the accommodation array
                                        //we will create a similar method to deepCopyTransportationArray, but for accommodations, using the copy method defined in accommodation and its subclasses
                                        Accommodation[] accomCopy = new Accommodation[accommodations.length];
                                        break;
                                    }
                                    break;
                                    //Generate Visualization (Optional but recommended)
                                        //-bar chart (Trip Cost)
                                        //-pie chart (Trips per destination)  Line chart (Duration over time)
                    case 6:
                                        //visualization
                                        //for visualization, we will use the JFreeChart library to generate charts based on the trips data. 
                                        // We will create a bar chart to show the total cost of each trip, a pie chart to show the distribution of trips per destination, and a line chart to show the duration of trips over time. 
                                        // We will save these charts as PNG files in an output directory. 
                                        
                        //bar chart (trip costs) : use the generateCostBarChart method in TripChartGenerator class, passing in the trips array and tripCount
                                        //pie chart (trips per destination) : use the generateDestinationPieChart method in TripChartGenerator class, passing in the trips array and tripCount
                                        //line chart (duration over time) : use the generateDurationLineChart method in TripChartGenerator class, passing in the trips array and tripCount
                                        //bar chart:
                                        try {
                                            TripChartGenerator.generateCostBarChart(trips, tripCount);
                                            System.out.println("Bar chart (Trip Costs) generated successfully.");
                                        } catch (Exception e) {
                                            System.out.println("Error generating bar chart: " + e.getMessage());
                                        }
                                        //pie chart:
                                        try {
                                            TripChartGenerator.generateDestinationPieChart(trips, tripCount);
                                            System.out.println("Pie chart (Trips per Destination) generated successfully.");
                                        } catch (Exception e) {
                                            System.out.println("Error generating pie chart: " + e.getMessage());
                                        }
                                        //line chart:
                                        try {
                                            TripChartGenerator.generateDurationLineChart(trips, tripCount);
                                            System.out.println("Line chart (Duration over Time) generated successfully.");
                                        } catch (Exception e) {
                                            System.out.println("Error generating line chart: " + e.getMessage());
                                        }
                                        break;
                    default:    
                        System.out.println("Invalid choice. Please try again.");                                


        
    
}

        }
    }
}
}
