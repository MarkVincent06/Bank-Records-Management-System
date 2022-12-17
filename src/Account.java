public class Account {
    // instance variables
    private int accountNumber;
    private String accountType;
    private double balance;
  
    // constructor
    public Account(int accountNumber, String accountType, double balance) {
      this.accountNumber = accountNumber;
      this.accountType = accountType;
      this.balance = balance;
    }
  
    // getter and setter methods
    public int getAccountNumber() {
      return accountNumber;
    }
  
    public void setAccountNumber(int accountNumber) {
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
  
    // other methods
    public void deposit(double amount) {
      balance += amount;
    }
  
    public void withdraw(double amount) {
      balance -= amount;
    }
  
    public void transfer(double amount, Account other) {
      balance -= amount;
      other.balance += amount;
    }
  }