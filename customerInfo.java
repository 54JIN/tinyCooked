public class customerInfo{
    //LinkedList based on a stack list
    String customerName;
    String address;
    String city;
    String state;
    int zipCode;
    int phoneNumber;
    Food food;
    Drinks drinks;

    customerInfo head;
    customerInfo previous;

    public customerInfo(){
        this.head = null;
        this.previous = null;
    }
    public customerInfo(String customerName, String address, String city, String state, int zipCode, int phoneNumber){
        this.customerName = customerName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.previous = null;
    }
    public void add(String customerName, String address, String city, String state, int zipCode, int phoneNumber){
        customerInfo tempCustomer = new customerInfo(customerName,address,city,state,zipCode,phoneNumber);
        if(head == null){
            head = tempCustomer;
        }
        else{
            tempCustomer.previous = head;
            head = tempCustomer;
        }
    }
    public static void main(String[] args){
        System.out.println("hi");
    }
}
