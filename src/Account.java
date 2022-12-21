import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String accountType;
    private double balance;
    private Client owner;
    private ArrayList<Transaction> transactions;
  
    public Account(String accountNumber, String accountType, double balance, Client owner) {
      this.accountNumber = accountNumber;
      this.accountType = accountType;
      this.balance = balance;
      this.owner = owner;
      this.transactions = new ArrayList<>();
    }
  
    // getters and setters for each instance variable
    public String getAccountNumber() {
      return accountNumber;
    }
  
    public void setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
    }
  
    public String getAccountType() {
      return accountType;
    }
  
    public void setAccountType(String accountType) {
      this.accountType = accountType;
    }
  
    public double getBalance() {
      return balance;
    }
  
    public void setBalance(double balance) {
      this.balance = balance;
    }
  
    public Client getOwner() {
      return owner;
    }
  
    public void setOwner(Client owner) {
      this.owner = owner;
    }

    public ArrayList<Transaction> getTransactions() {
      return transactions;
    }
  
    public void setTransactions(ArrayList<Transaction> transactions) {
      this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
      this.transactions.add(transaction);
    }

    public void deposit(double amount) {
      balance += amount;
    }
  
    public void withdraw(double amount) {
      balance -= amount;
    }
  }
  