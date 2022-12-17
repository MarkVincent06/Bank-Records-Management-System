import java.util.ArrayList;

public class Branch {
    private String branchId;
    private String address;
    private ArrayList<Client> clients;
  
    public Branch(String branchId, String address) {
      this.branchId = branchId;
      this.address = address;
      this.clients = new ArrayList<>();
    }
  
    // getters and setters for each instance variable
    public String getBranchId() {
      return branchId;
    }
  
    public void setBranchId(String branchId) {
      this.branchId = branchId;
    }
  
    public String getAddress() {
      return address;
    }
  
    public void setAddress(String address) {
      this.address = address;
    }
  
    public ArrayList<Client> getClients() {
      return clients;
    }
  
    public void setClients(ArrayList<Client> clients) {
      this.clients = clients;
    }
  
    // method to add a new client to the branch
    public void addClient(Client client) {
      clients.add(client);
    }
  
    // method to remove a client from the branch
    public void removeClient(Client client) {
      clients.remove(client);
    }
  }
  