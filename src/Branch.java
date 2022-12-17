import java.util.ArrayList;
import java.util.List;

public class Branch {
    // instance variables
    private int id;
    private String name;
    private String address;
    private String phone;
    private List<Client> clients;
    private List<Loan> loans;
  
    // constructor
    public Branch(int id, String name, String address, String phone) {
      this.id = id;
      this.name = name;
      this.address = address;
      this.phone = phone;
      this.clients = new ArrayList<>();
      this.loans = new ArrayList<>();
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
  
    public List<Client> getClients() {
      return clients;
    }
  
    public List<Loan> getLoans() {
      return loans;
    }
  
    // other methods
    public void addClient(Client client) {
      clients.add(client);
    }
  
    public void removeClient(Client client) {
      clients.remove(client);
    }
  
    public void addLoan(Loan loan) {
      loans.add(loan);
    }
  
    public void removeLoan(Loan loan) {
      loans.remove(loan);
    }
  }
