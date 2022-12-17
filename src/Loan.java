public class Loan {
    private String loanId;
    private double loanAmount;
    private double interestRate;
    private int term; //in months
    private Client borrower;
    private Account account;
  
    public Loan(String loanId, double loanAmount, double interestRate, int term, Client borrower, Account account) {
      this.loanId = loanId;
      this.loanAmount = loanAmount;
      this.interestRate = interestRate;
      this.term = term;
      this.borrower = borrower;
      this.account = account;
    }
  
    // getters and setters for each instance variable
    public String getLoanId() {
      return loanId;
    }
  
    public void setLoanId(String loanId) {
      this.loanId = loanId;
    }
  
    public double getLoanAmount() {
      return loanAmount;
    }
  
    public void setLoanAmount(double loanAmount) {
      this.loanAmount = loanAmount;
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
  
    public Client getBorrower() {
      return borrower;
    }
  
    public void setBorrower(Client borrower) {
      this.borrower = borrower;
    }
  
    public Account getAccount() {
      return account;
    }
  
    public void setAccount(Account account) {
      this.account = account;
    }
  }
  