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
    public boolean removeCustomer(String customerName, int phoneNumber){
        //If the customerInfo list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return false rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Customer In data base");
            //return false;
        }
        if(head.customerName.equals(customerName) && head.phoneNumber == phoneNumber && head.previous == null){
            head = null;
            return true;
        }
        else if(head.customerName.equals(customerName)){ //&& head.phoneNumber == phoneNumber){
            head = head.previous;
            return true;
        }
        else{
            //the cursor copies the address, the memory location, of the head customerInfo Class
            customerInfo cursor = head;
            //Search through the entire list untill either the customerName matches the given customerName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.previous.customerName.equals(customerName)){
                    cursor.previous = cursor.previous.previous;
                    return true;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last customerInfo within the list
            if(cursor.customerName.equals(customerName) && cursor.phoneNumber == phoneNumber){
                customerInfo temp = new customerInfo();
                cursor = temp;
                return true;
            }
            //if the customerInfo item is not within the list return false
            else{
                return false;
            }
        }
    }
    //Check if the customerInfo item exists within the list already or exists at all within the list
    public boolean customerExist(String customerName, int phoneNumber){
        //If the customerInfo list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return false rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Customer In data base");
            //return false;
        }
        else{
            //the cursor copies the address, the memory location, of the head customerInfo Class
            customerInfo cursor = head;
            //Search through the entire list until either the customerName matches the given customerName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.customerName.equals(customerName) && cursor.previous.phoneNumber == phoneNumber){
                    return true;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last customerInfo within the list
            if(cursor.customerName.equals(customerName) && cursor.previous.phoneNumber == phoneNumber){
                return true;
            }
            //if the customerInfo item is not within the list return false
            else{
                return false;
            }
        }
    }
    public static void main(String[] args){
        System.out.println("hi");
        customerInfo temp = new customerInfo();
        temp.add("peter", "48 beth ave", "bergenfield", "NJ", 07621, 2012489322);
        temp.add("chan", "48 beth ave", "bergenfield", "NJ", 07621, 2012489323);
        temp.add("ren", "48 beth ave", "bergenfield", "NJ", 07621, 2012489328);
        System.out.println(temp.removeCustomer("chan", 2012489322));
        //System.out.println(temp.customerExist("peter", 2012489322));
    }
}
