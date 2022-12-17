public class Loan {
    // instance variables
    private int id;
    private Account account;
    private double amount;
    private double interestRate;
    private int term; // in months
    private double monthlyPayment;
  
    // constructor
    public Loan(int id, Account account, double amount, double interestRate, int term) {
      this.id = id;
      this.account = account;
      this.amount = amount;
      this.interestRate = interestRate;
      this.term = term;
      this.monthlyPayment = calculateMonthlyPayment();
    }
  
    // getter and setter methods
    public int getId() {
      return id;
    }
  
    public void setId(int id) {
      this.id = id;
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
  
    public double getInterestRate() {
      return interestRate;
    }
  
    public void setInterestRate(double interestRate) {
      this.interestRate = interestRate;
    }
  
    public int getTerm() {
      return term;
    }
  
    public void setTerm(int term) {
      this.term = term;
    }
  
    public double getMonthlyPayment() {
      return monthlyPayment;
    }
  
    // other methods
    private double calculateMonthlyPayment() {
      double monthlyInterestRate = interestRate / 12;
      double monthlyPayment = amount * monthlyInterestRate / (1 - Math.pow(1 + monthlyInterestRate, -term));
      return monthlyPayment;
    }
  }
