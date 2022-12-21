public class Transaction {
    private String transactionId;
    private String transactionDate;
    private double amount;
    private String description;
      
    public Transaction(String transactionId, String transactionDate, double amount, String description) {
      this.transactionId = transactionId;
      this.transactionDate = transactionDate;
      this.amount = amount;
      this.description = description;
    }
  
    // getters and setters for each instance variable
    public String getTransactionId() {
      return transactionId;
    }
  
    public void setTransactionId(String transactionId) {
      this.transactionId = transactionId;
    }
  
    public String getTransactionDate() {
      return transactionDate;
    }
  
    public void setTransactionDate(String transactionDate) {
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
  }
  