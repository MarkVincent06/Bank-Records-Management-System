import java.util.ArrayList;
import java.util.List;

public class Client {
    // instance variables
    private int id;
    private String name;
    private String address;
    private String phone;
    private List<Account> accounts;
  
    // constructor
    public Client(int id, String name, String address, String phone) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.phone = phone;
      this.accounts = new ArrayList<>();
    }
  
    // getter and setter methods
    public int getId() {
      return id;
    }
  
    public void setId(int id) {
      this.id = id;
    }
  
    public String getName() {
      return name;
    }
  
    public void setName(String name) {
      this.name = name;
    }
  
    public String getAddress() {
      return address;
    }
  
    public void setAddress(String address) {
      this.address = address;
    }
  
    public String getPhone() {
      return phone;
    }
  
    public void setPhone(String phone) {
      this.phone = phone;
    }
  
    public List<Account> getAccounts() {
      return accounts;
    }
  
    // other methods
    public void addAccount(Account account) {
      accounts.add(account);
    }
  
    public void removeAccount(Account account) {
      accounts.remove(account);
    }
  }