public class Account {
    private String accountNumber;
    private String accountType;
    private double balance;
    private Client owner;
  
    public Account(String accountNumber, String accountType, double balance, Client owner) {
      this.accountNumber = accountNumber;
      this.accountType = accountType;
      this.balance = balance;
      this.owner = owner;
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
  }
  