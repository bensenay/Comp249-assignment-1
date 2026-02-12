package Driver;
import java.util.Scanner;
import Client.Client;
import Travel.Accommodation;
import Travel.Hotel;
import Travel.Hostel;
import Travel.Train;
import Travel.Transportation;
import Travel.Bus;
import Travel.Train;
import Travel.Flight;
import Travel.Trip;

public class Driver {
    //capacity constants:
    private static final int MAX_CLIENTS = 100;
    private static final int MAX_TRIPS = 100;
    private static final int MAX_TRANSPORTATIONS = 100;
    private static final int MAX_ACCOMMODATIONS = 100;

    public static void main(String[] args) {
        //arrays ; must be partially filled
        Client[] clients = new Client[MAX_CLIENTS];
        Accommodation[] accommodations = new Accommodation[MAX_ACCOMMODATIONS];
        Transportation[] transportations = new Transportation[MAX_TRANSPORTATIONS];
        Trip[] trips = new Trip[MAX_TRIPS];

        //set variables with default values
        int clientCount = 0;
        int accommodationCount = 0;
        int transportationCount = 0;
        int tripCount = 0;

        //scanner for user input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Smart Travel Planner!");
        //user must choose between a predefined scenario or menu driven interface
        System.out.println("Please choose an option:");
        System.out.println("1. Run predefined scenario");
        System.out.println("2. Use menu-driven interface");
        int choice = scanner.nextInt();

        if (choice == 2) {
            runPredefinedScenario(clients, trips, transportations, accommodations,
                                  clientCount, tripCount, transportationCount, accommodationCount);
        } else {
            runMenu(scanner, clients, trips, transportations, accommodations);
        }

        System.out.println("Program terminated. Goodbye!");
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

        //----------------------------------------------
        //run menu
        public static void runMenu(Scanner s, Client[] clients, Trip[] trips, Transportation[] transports, Accommodation[] accommodations) {
            Scanner scanner = new Scanner(System.in);
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
                                    System.out.println("Added client: " + clients[clientCount]);

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
                                    }else {
                                        System.out.println("Client ID not found. Please try again.");// if client id not found, user can retry
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
                        
                    






            }



        }

    }







}
