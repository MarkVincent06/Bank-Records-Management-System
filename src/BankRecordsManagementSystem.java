import java.util.ArrayList;
import java.util.Scanner;

public class BankRecordsManagementSystem {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Branch> branches = new ArrayList<>();

    // clears screen
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    // go back if the "Enter" key is pressed
    public static void pressEnterKey() {
        System.out.println("Press Enter key to go back...");
        try
        {
            System.in.read();
            input.nextLine();
        }  
        catch(Exception e)
        {}  
    }

    // DISPLAYS MAIN MENU
    public static void displayMainMenu() {
        clearScreen();
    
        System.out.println("$$$ Welcome to `Runtime Terror's` Bank Records Management System $$$");
        System.out.println("\nMain Menu:");
		System.out.println("[1] Branch");
		System.out.println("[2] Client");
		System.out.println("[3] Account");
		System.out.println("[0] Exit");
		System.out.print("Enter your choice [0-3]: ");
    }

    // DISPLAYS BRANCH MENU
    public static void displayBranchMenu() {
        clearScreen();

        System.out.println("$$$ Welcome to `Runtime Terror's` Bank Records Management System $$$");
        System.out.println("\nBranch:");
		System.out.println("[1] Add Branch");
		System.out.println("[2] View All Branches");
		System.out.println("[3] Edit Branch");
		System.out.println("[4] Delete Branch");
		System.out.println("[0] Main Menu");
		System.out.print("Enter your choice [0-4]: ");
    }

    // DISPLAYS CLIENT MENU
    public static void displayClientMenu() {
        clearScreen();

        System.out.println("$$$ Welcome to `Runtime Terror's` Bank Records Management System $$$");
        System.out.println("\nClient:");
		System.out.println("[1] Add Client");
		System.out.println("[2] View All Clients");
		System.out.println("[3] Edit Client");
		System.out.println("[4] Delete Client");
		System.out.println("[0] Main Menu");
		System.out.print("Enter your choice [0-4]: ");
    }

    // DISPLAYS ACCOUNT MENU
    public static void displayAccountMenu() {
        clearScreen();

        System.out.println("$$$ Welcome to `Runtime Terror's` Bank Records Management System $$$");
        System.out.println("\nClient:");
		System.out.println("[1] Add Client");
		System.out.println("[2] View All Clients");
		System.out.println("[3] Edit Client");
		System.out.println("[4] Delete Client");
		System.out.println("[0] Main Menu");
		System.out.print("Enter your choice [0-4]: ");
    }

    // BRANCH
    public static void branch() {
        while(true) {
            displayBranchMenu();

            String choice = input.next();
            if(choice.equals("0")) {
                break;
            }

            switch(choice) {
                case "1": // Adds new branch
                    clearScreen();
                    System.out.println(">>> Adding Branch <<<\n");
                    System.out.println("Enter branch Id: ");
                    String branchId = input.next();
                    System.out.println("Enter branch name: ");
                    input.nextLine();
                    String branchName = input.nextLine();
                    System.out.println("Enter branch address: ");
                    String branchAddress = input.nextLine();

                    Branch newBranch = new Branch(branchId, branchName, branchAddress);
                    if(branches.add(newBranch)) {
                        System.out.println("\nBranch added successfully!");
                        pressEnterKey();
                    }
                    break;
                
                case "2": // Views all branches
                    clearScreen();
                    System.out.println(">>> Viewing All Branches <<<\n");
                    System.out.println("+---------------+------------------------------------+------------------------------------+-----------------+");
                    System.out.println("| Branch Id     | Branch Name                        | Branch Address                     | No. of Client/s |");
                    System.out.println("+---------------+------------------------------------+------------------------------------+-----------------+");
                    for (Branch branch : branches) {
                        System.out.printf("| %-13s | %-34s | %-34s | %-15s |%n", branch.getBranchId(), branch.getName(), branch.getAddress(), branch.getClients().size());
                        System.out.println("+---------------+------------------------------------+------------------------------------+-----------------+");
                    }
                    pressEnterKey();
                    break;
                
                case "3": // Edits an existing branch
                    clearScreen();
                    System.out.println(">>> Editing a Branch <<<\n");
                    System.out.println("Enter Branch Id:");
                    input.nextLine();
                    String findBranchId = input.nextLine();
                    boolean isBranchFound = false;
                    for(Branch branch : branches) {
                        if(branch.getBranchId().equals(findBranchId)) {
                            isBranchFound = true;
                            System.out.println("Enter new branch name (Old branch name: `" + branch.getName() + "`):");
                            String newBranchName = input.nextLine();
                            branch.setName(newBranchName);

                            System.out.println("Enter new branch address (Old branch address: `" + branch.getAddress() + "`):");
                            String newBranchAddress = input.nextLine();
                            branch.setAddress(newBranchAddress);

                            System.out.println("\nBranch updated successfully!");
                        } 
                    }
                    if(!isBranchFound) { System.out.println("\nBranch does not exist!"); } 
                    pressEnterKey();
                    break;
                
                case "4": // deletes an existing branch
                    clearScreen();
                    System.out.println(">>> Deleting a Branch <<<\n");
                    System.out.println("Enter Branch Id:");
                    input.nextLine();
                    findBranchId = input.nextLine();
                    isBranchFound = false;
                    for(int i = 0; i < branches.size(); i++) {
                        Branch branch = branches.get(i);
                        if(branch.getBranchId().equals(findBranchId)) {
                            isBranchFound = true;
                            System.out.println("`" + branch.getName() + "` Branch is successfully deleted!");
                            branches.remove(i);
                            break;
                        } 
                    }
                    if(!isBranchFound) { System.out.println("\nBranch does not exist!"); } 
                    pressEnterKey();
                    break;
                default:
                    clearScreen();
                    System.out.println("Error! Invalid choice.");
                    pressEnterKey();
                    break;
            }
        }
    }

    // CLIENT
    public static void client() {
        while(true) {
            displayClientMenu();

            String choice = input.next();
            if(choice.equals("0")) {
                break;
            }

            switch(choice) {
                case "1": // Adds new client
                clearScreen();
                System.out.println(">>> Adding Client <<<\n");
                System.out.println("Enter client Id: ");
                String clientId = input.next();
                System.out.println("Enter firstname: ");
                input.nextLine();
                String firstname = input.nextLine();
                System.out.println("Enter lastname: ");
                String lastname = input.nextLine();
                System.out.println("Enter phone number: ");
                String phoneNum = input.nextLine();
                System.out.println("Enter email: ");
                String email = input.nextLine();
                System.out.println("Enter branch Id: ");
                String findBranchId = input.nextLine();
                boolean isBranchFound = false;

                for(Branch branch : branches) {
                    if(branch.getBranchId().equals(findBranchId)) {
                        isBranchFound = true;

                        Client newClient = new Client(clientId, firstname, lastname, phoneNum, email);
                        branch.addClient(newClient);
                        System.out.println("\nClient added successfully in `" + branch.getName() + "` Branch!");
                        break;
                    }
                }
                if(!isBranchFound) { System.out.println("\nBranch does not exist!"); } 
                pressEnterKey();
                break;
                
                case "2": // views all clients
                clearScreen();
                System.out.println(">>> Viewing All Clients <<<\n");
                System.out.println("+---------------+---------------------+---------------------+---------------------+-----------------------------+---------------------+-----------------+");
                System.out.println("| Client Id     | Firstname           | Lastname            | Phone No.           | Email                       | Branch              | No. of Accounts |");
                System.out.println("+---------------+---------------------+---------------------+---------------------+-----------------------------+---------------------+-----------------+");
                for (Branch branch : branches) {
                    ArrayList<Client> clients = branch.getClients();
                    for(Client client : clients) {
                        System.out.printf("| %-13s | %-19s | %-19s | %-19s | %-27s | %-20s| %-15s |%n", client.getClientId(), client.getFirstName(), client.getLastName(), client.getPhoneNumber(), client.getEmail(), branch.getName(), client.getAccounts().size());
                        System.out.println("+---------------+---------------------+---------------------+---------------------+-----------------------------+---------------------+-----------------+");
                    }
                }
                pressEnterKey();
                break;
                
                case "3": // Edits an existing client
                    clearScreen();
                    System.out.println(">>> Editing a Client <<<\n");
                    System.out.println("Enter Client Id:");
                    input.nextLine();
                    String findClientId = input.nextLine();
                    boolean isClientFound = false;
                    for(Branch branch : branches) {
                        ArrayList<Client> clients = branch.getClients();
                        for(Client client : clients) {
                            if(client.getClientId().equals(findClientId)) {
                               isClientFound = true;

                               System.out.println("Enter new firstname (Old firstname: `" + client.getFirstName() + "`):");
                               String newFirstName = input.nextLine();
                               client.setFirstName(newFirstName);
   
                               System.out.println("Enter new lastname (Old lastname: `" + client.getLastName() + "`):");
                               String newLastName = input.nextLine();
                               client.setLastName(newLastName);

                               System.out.println("Enter new phone number (Old phone number: `" + client.getPhoneNumber() + "`):");
                               String newPhoneNum = input.nextLine();
                               client.setPhoneNumber(newPhoneNum);

                               System.out.println("Enter new lastname (Old email: `" + client.getEmail() + "`):");
                               String newEmail= input.nextLine();
                               client.setEmail(newEmail);
   
                               System.out.println("\nClient updated successfully!");
                            }
                            break;
                        }
                        if(isClientFound) { break; }
                    }
                    if(!isClientFound) { System.out.println("\nClient does not exist!"); } 
                    pressEnterKey();
                    break;
                case "4": // deletes an existing client
                clearScreen();
                System.out.println(">>> Deleting a Client <<<\n");
                System.out.println("Enter Client Id:");
                input.nextLine();
                findClientId = input.nextLine();
                isClientFound = false;
                for(Branch branch : branches) {
                    ArrayList<Client> clients = branch.getClients();
                    for(int i = 0; i < clients.size(); i++) {
                        Client client = clients.get(i);
                        if(client.getClientId().equals(findClientId)) {
                            isClientFound = true;
                            System.out.println("`" + client.getFirstName() + " " + client.getLastName() + "` Client is successfully deleted!");
                            clients.remove(i);
                            break;
                        } 
                    }
                    if(isClientFound) { break; }
                }
                if(!isClientFound) { System.out.println("\nClient does not exist!"); } 
                pressEnterKey();
                break;
            }
        }
    }

    public static void main(String[] args) {
        while(true) {
            displayMainMenu();

            String choice = input.next();
            if(choice.equals("0")) {
                break;
            }

            switch(choice) {
                case "1": 
                    branch();
                    break;
                case "2":
                    client();
                    break;
                case "3": 
                    account();
                    break;
                default:
                    clearScreen();
                    System.out.println("Error! Invalid choice.");
                    pressEnterKey();
                    break;
            }
        }
    
    }
}

