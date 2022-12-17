import java.util.Date;

public class Transaction {
    private String transactionId;
    private Date transactionDate;
    private double amount;
    private String description;
    private Account account;
  
    public Transaction(String transactionId, Date transactionDate, double amount, String description, Account account) {
      this.transactionId = transactionId;
      this.transactionDate = transactionDate;
      this.amount = amount;
      this.description = description;
      this.account = account;
    }
  
    // getters and setters for each instance variable
    public String getTransactionId() {
      return transactionId;
    }
  
    public void setTransactionId(String transactionId) {
      this.transactionId = transactionId;
    }
  
    public Date getTransactionDate() {
      return transactionDate;
    }
  
    public void setTransactionDate(Date transactionDate) {
      this.transactionDate = transactionDate;
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
  
    public Account getAccount() {
      return account;
    }
  
    public void setAccount(Account account) {
      this.account = account;
    }
  }
  