import java.util.ArrayList;

public class Client {
    private String clientId;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private ArrayList<Account> accounts;
  
    public Client(String clientId, String firstName, String lastName, String phoneNumber, String email) {
      this.clientId = clientId;
      this.firstName = firstName;
      this.lastName = lastName;
      this.phoneNumber = phoneNumber;
      this.email = email;
      this.accounts = new ArrayList<>();
    }
  
    // getters and setters for each instance variable
    public String getClientId() {
      return clientId;
    }
  
    public void setClientId(String clientId) {
      this.clientId = clientId;
    }
  
    public String getFirstName() {
      return firstName;
    }
  
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }
  
    public String getLastName() {
      return lastName;
    }
  
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }
  
    public String getPhoneNumber() {
      return phoneNumber;
    }
  
    public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
    }
  
    public String getEmail() {
      return email;
    }
  
    public void setEmail(String email) {
      this.email = email;
    }
  
    public ArrayList<Account> getAccounts() {
      return accounts;
    }
  
    public void setAccounts(ArrayList<Account> accounts) {
      this.accounts = accounts;
    }
  }
  