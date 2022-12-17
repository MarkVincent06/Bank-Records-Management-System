import java.util.Date;

public class Transaction {
    // instance variables
    private int id;
    private Date date;
    private Account account;
    private double amount;
    private String description;
  
    // constructor
    public Transaction(int id, Account account, double amount, String description) {
      this.id = id;
      this.date = new Date();
      this.account = account;
      this.amount = amount;
      this.description = description;
    }
  
    // getter and setter methods
    public int getId() {
      return id;
    }
  
    public void setId(int id) {
      this.id = id;
    }
  
    public Date getDate() {
      return date;
    }
  
    public Account getAccount() {
      return account;
    }
  
    public void setAccount(Account account) {
      this.account = account;
    }
  
    public double getAmount() {
      return amount;
    }
  
    public void setAmount(double amount) {
      this.amount = amount;
    }
  
    public String getDescription() {
      return description;
    }
  
    public void setDescription(String description) {
      this.description = description;
    }
  }