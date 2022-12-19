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

    // BRANCH
    public static void branch() {
        while(true) {
            displayBranchMenu();

            String choice = input.next();
            if(choice.equals("0")) {
                break;
            }

            switch(choice) {
                // Adds new branch
                case "1": 
                    clearScreen();
                    System.out.println(">>> Adding Branch <<<\n");
                    System.out.println("Enter branch ID: ");
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
                // Views all branches
                case "2":
                    clearScreen();
                    System.out.println(">>> Viewing All Branches <<<\n");
                    System.out.println("+---------------+------------------------------------+------------------------------------+");
                    System.out.println("| Branch ID     | Branch Name                        | Branch Address                     |");
                    System.out.println("+---------------+------------------------------------+------------------------------------+");
                    for (Branch branch : branches) {
                        System.out.printf("| %-13s | %-34s | %-34s |%n", branch.getBranchId(), branch.getName(), branch.getAddress());
                        System.out.println("+---------------+------------------------------------+------------------------------------+");
                    }
                    pressEnterKey();
                    break;
                // Edits an existing branch
                case "3": 
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
                // deletes an existing branch
                case "4":
                    clearScreen();
                    System.out.println(">>> Deleting a Branch <<<\n");
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
                default:
                    clearScreen();
                    System.out.println("Error! Invalid choice.");
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
                    // client();
                    break;
                case "3": 
                    // account();
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

