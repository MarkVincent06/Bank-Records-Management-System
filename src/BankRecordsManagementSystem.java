import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BankRecordsManagementSystem {
    static Scanner input = new Scanner(System.in);
    static ArrayList<Branch> branches = new ArrayList<>();

    // clears screen (only for windows)
    public static void clearScreen() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
        pb.inheritIO().start().waitFor();
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
    public static void displayMainMenu() throws IOException, InterruptedException {
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
    public static void displayBranchMenu() throws IOException, InterruptedException {
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
    public static void displayClientMenu() throws IOException, InterruptedException {
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
    public static void displayAccountMenu(String clientName) throws IOException, InterruptedException {
        clearScreen();

        System.out.println("$$$ Welcome to `Runtime Terror's` Bank Records Management System $$$");
        System.out.println("\nCurrent client [" + clientName + "]:");
		System.out.println("[1] Create a new account");
		System.out.println("[2] Add a new transaction");
		System.out.println("[3] Add a new loan");
		System.out.println("[4] Balance inquiry");
		System.out.println("[5] View all accounts");
		System.out.println("[6] View all transactions");
		System.out.println("[7] View loan");
		System.out.println("[8] Delete account");
		System.out.println("[0] Main menu");
		System.out.print("Enter your choice [0-8]: ");
    }

    // BRANCH
    public static void branch() throws IOException, InterruptedException {
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
    public static void client() throws IOException, InterruptedException {
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
                               break;
                            }
                            if(isClientFound) { break; }
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
                default:
                    clearScreen();
                    System.out.println("Error! Invalid choice.");
                    pressEnterKey();
                    break;
            }
        }
    }

    // generates random id
    public static String generateId() {
        // this will generate random number based on current time
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        long timeInMilliseconds = date.getTime();
        Random random = new Random(timeInMilliseconds);
        Integer randomNumber = Math.abs(random.nextInt());
        String id = "TID-" + Integer.toString(randomNumber);
    
        return id;
    }

    // gets current date in this format(yyyy-mm-dd)
    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();

        return formatter.format(currentDate);
    }

    // ACCOUNT
    public static void account(Client activeClient) throws IOException, InterruptedException {
        Client client = activeClient;
        ArrayList<Account> accounts = client.getAccounts();
        String clientName = client.getFirstName() + " " + client.getLastName();

        while(true) {
            displayAccountMenu(clientName);
            
            String choice = input.next();
            if(choice.equals("0")) {
                break;
            }

            switch(choice) {
                case "1": // Adds new account
                    clearScreen();
                    System.out.println(">>> Creating Account <<<");
                    System.out.println("Enter account number: ");
                    String accountNumber = input.next();
                    System.out.println("Enter account type (`savings` or `checking`): ");
                    String accountType = input.next();
                    System.out.println("Enter starting balance (P): ");
                    double balance = input.nextDouble();

                    Account newAccount = new Account(accountNumber, accountType, balance, client);
                    accounts.add(newAccount);
                    client.setAccounts(accounts);

                    System.out.println("\nAccount created successfully!");
                    pressEnterKey();
                    break;
                case "2": // Adds a new transaction
                    while(true) {  
                        clearScreen();
                        System.out.println(">>> Choosing Transaction <<<");
                        System.out.println("[1] Deposit Money");
                        System.out.println("[2] Withdraw Money");
                        System.out.println("[3] Pay Loan");
                        System.out.println("[0] Cancel");
                        System.out.print("Enter your choice [0-3]: " );

                        choice = "";
                        choice = input.next();
                        if(choice.equals("0")) {
                            break;
                        }

                        switch(choice) {
                            case "1": // deposits money from the chosen account
                                clearScreen();
                                System.out.println(">>> Depositing Money <<<");
                                System.out.println("Enter account number: ");
                                String findAccountNumber = input.next();
                                boolean isAccountNumberFound = false;
                                for(Account account : accounts) {
                                    if(account.getAccountNumber().equals(findAccountNumber)) {
                                        isAccountNumberFound = true;
                                        System.out.println("\nAccount owner name: `" + account.getOwner().getFirstName() + " " + account.getOwner().getLastName() + "`");
                                        System.out.println("Account type: `" + account.getAccountType() + "`");
                                        System.out.printf("Remaining balance: P%,.2f\n", account.getBalance());
                                        System.out.println("\nEnter amount to deposit: ");
                                        double amount = input.nextDouble();
                                    
                                        account.deposit(amount);
                                        System.out.println("\nBalance updated!");
                                        
                                        Transaction transaction = new Transaction(generateId(), getCurrentDate(), amount, "deposit");
                                        account.addTransaction(transaction);
                                        System.out.println("Transaction complete! You deposited P" + amount + " into this account number `" + account.getAccountNumber() + "`.");

                                        break;
                                    }
                                }
                                if(!isAccountNumberFound) { System.out.println("\nAccount does not exist!"); } 
                                pressEnterKey();
                                break;
                            case "2": // withdraws money from the chosen account
                                clearScreen();
                                System.out.println(">>> Withdrawing Money <<<");
                                System.out.println("Enter account number: ");
                                findAccountNumber = input.next();
                                isAccountNumberFound = false;
                                for(Account account : accounts) {
                                    if(account.getAccountNumber().equals(findAccountNumber)) {
                                        isAccountNumberFound = true;
                                        System.out.println("\nAccount owner name: `" + account.getOwner().getFirstName() + " " + account.getOwner().getLastName() + "`");
                                        System.out.println("Account type: `" + account.getAccountType() + "`");
                                        System.out.printf("Remaining balance: P%,.2f\n", account.getBalance());
                                        System.out.println("\nEnter amount to withdraw: ");
                                        double amount = input.nextDouble();
                                        
                                        if(amount > account.getBalance()) {
                                            System.out.println("\nOops! Not enough balance to withdraw that amount. Transaction failed.");
                                        } else {
                                            account.withdraw(amount);
                                            System.out.println("\nBalance updated!");
                                            
                                            Transaction transaction = new Transaction(generateId(), getCurrentDate(), amount, "withdraw");
                                            account.addTransaction(transaction);
                                            System.out.println("Transaction complete! You withdrew P" + amount + " into this account number `" + account.getAccountNumber() + "`.");
                                        }
                                        break;
                                    }
                                }
                                if(!isAccountNumberFound) { System.out.println("\nAccount does not exist!"); } 
                                pressEnterKey();
                                break;  
                            case "3": // pays current loan  
                                clearScreen();
                                System.out.println("Coming soon... (sorry sir we don't have the time to implement this)");
                                pressEnterKey();
                                break;
                            default:
                                clearScreen();
                                System.out.println("Error! Invalid choice.");
                                pressEnterKey();
                                break;
                        }
                    }
                    break;
                case "3": // adds a new loan
                    clearScreen();
                    System.out.println("Coming soon... (sorry sir we don't have the time to implement this)");
                    pressEnterKey();
                    break;
                case "4": // checks balance inquiry
                    clearScreen();
                    System.out.println(">>> Checking Balance Inquiry <<<");
                    System.out.println("Enter account number: ");
                    String findAccountNumber = input.next();
                    boolean isAccountNumberFound = false;
                    for(Account account : accounts) {
                        if(account.getAccountNumber().equals(findAccountNumber)) {
                            isAccountNumberFound = true;

                            System.out.println("\nAccount owner name: `" + account.getOwner().getFirstName() + " " + account.getOwner().getLastName() + "`");
                            System.out.println("Account type: `" + account.getAccountType() + "`");
                            System.out.printf("Remaining balance: P%,.2f\n\n", account.getBalance());
                            break;
                        }
                    }
                    if(!isAccountNumberFound) { System.out.println("\nAccount does not exist!"); } 
                    pressEnterKey();
                    break;
                case "5": // views all accounts
                    clearScreen();
                    System.out.println(">>> Viewing All Accounts <<<");
                    System.out.println("+---------------+--------------------------+------------------------------------+-----------------------+");
                    System.out.println("| Account No.   | Account Type             | Balance                            | No. of Transactions   |");
                    System.out.println("+---------------+--------------------------+------------------------------------+-----------------------+");
                    for (Account account : accounts) {
                        String convertBalToString = Double.toString(account.getBalance());
                        System.out.printf("| %-13s | %-24s | %-34s | %-21s | %n", account.getAccountNumber(), account.getAccountType(), convertBalToString, account.getTransactions().size());
                        System.out.println("+---------------+--------------------------+------------------------------------+-----------------------+");
                    }
                    pressEnterKey();
                    break;
                case "6": // views all transactions
                    clearScreen();
                    System.out.println(">>> Viewing All Transactions <<<");
                    System.out.println("Enter account number: ");
                    findAccountNumber = input.next();
                    isAccountNumberFound = false;
                    for(Account account : accounts) {
                        if(account.getAccountNumber().equals(findAccountNumber)) {
                            isAccountNumberFound = true;
                            if(account.getTransactions().size() > 0) {
                                System.out.println();
                                ArrayList<Transaction> transactions = account.getTransactions();
                                System.out.println("+-----------------------+------------------+------------------------------------+------------------+");
                                System.out.println("| Transaction Id        | Date             | Amount                             | Description      |");
                                System.out.println("+-----------------------+------------------+------------------------------------+------------------+");
                                for(Transaction transaction : transactions) {
                                    String convertAmountToString = Double.toString(transaction.getAmount());
                                    System.out.printf("| %-21s | %-16s | %-34s | %-16s | %n", transaction.getTransactionId(), transaction.getTransactionDate(), convertAmountToString, transaction.getDescription());
                                    System.out.println("+-----------------------+------------------+------------------------------------+------------------+");
                                }
                                break;
                            } else {
                                System.out.println("\nYou have no transactions in this account yet!");
                            }
                            break;
                        }
                    }
                    if(!isAccountNumberFound) { System.out.println("\nAccount does not exist!"); } 
                    pressEnterKey();
                    break;  
                case "7": // view current loan
                    clearScreen();
                    System.out.println("Coming soon... (sorry sir we don't have the time to implement this)");
                    pressEnterKey();
                    break;
                case "8": // delete an account
                    clearScreen();
                    System.out.println(">>> Deleting Account <<<");
                    System.out.println("Enter account number: ");
                    findAccountNumber = input.next();
                    isAccountNumberFound = false;
                    for(int i = 0; i < accounts.size(); i++) {
                        Account account = accounts.get(i);
                        if(account.getAccountNumber().equals(findAccountNumber)) {
                            isAccountNumberFound = true;
                            System.out.println("`" + account.getAccountNumber() + "` Account is successfully deleted!");
                            accounts.remove(i);
                            break;
                        } 
                    }
                    if(!isAccountNumberFound) { System.out.println("\nAccount does not exist!"); } 
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

    // gets active client
    public static Client getActiveClient() throws IOException, InterruptedException {
        clearScreen();

        System.out.println(">>> Getting Client <<<");
        System.out.println("\nEnter client Id:");
        input.nextLine();
        String findClientId = input.nextLine();
        boolean isClientFound = false;

        for(Branch branch : branches) {
            ArrayList<Client> clients = branch.getClients();
            for(Client client : clients) {
                if(client.getClientId().equals(findClientId)) {
                    isClientFound = true;

                    return client;
                }
            }
            if(isClientFound) { break; }
        }

        return null;
    }   

    public static void main(String[] args) throws IOException, InterruptedException {
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
                    Client activeClient = getActiveClient();
                    if(activeClient == null) {
                        System.out.println("\nClient does not exist.");
                        pressEnterKey();
                    } else {
                        account(activeClient);
                    }
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

