# tinyCooked

public class Drinks{
    //instance variable
    //pointers
    Drinks head;
    Drinks previous;//think of what is added previouslly in a stack strcuture

    //other common variables
    String name;
    double price;
    int quantity;
    int calorie;
    boolean diet;//assume to be flase until decalred
    

    //constructors
    //creating empty Drinks class
    public Drinks(){
        this.head=null;
        this.previous=null;
    }

    //create Drinks class without diet option
    public Drinks(String name, double price,int quantity){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        //assuming no diet picked
        this.diet=false;
    }

    //create Drinks class with diet option
    public Drinks(String name, double price, int quantity, boolean diet){
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        this.diet=diet;
    }

    //create class without diet option without quantity
    public Drinks(String name, double price){
        this.name=name;
        this.price=price;
        //assuming only 1 drink is left
        this.quantity=1;
        //assuming no diet picked
        this.diet=false;
    }

    //create class with diet option without quantity
    public Drinks(String name, double price, boolean diet){
        this.name=name;
        this.price=price;
        this.diet=diet;
        //assuming only 1 drink is left
        this.quantity=1;
    }

    //functions section:
    //add drink at the beginning of the linked list
    public void addDrinks(String name,double price, int quantity, boolean diet ){
        Drinks tempDrinks= new Drinks(name,price,quantity,diet);
        if (head == null){
            head=tempDrinks;
        }
        else{
            tempDrinks.previous = head;
            head= tempDrinks;
        }
    }

    //removing drinks
    public boolean removeDrinks(String name){
        //if nothing/no drink is in linked list, throw an exception
        if (head == null){
            throw new RuntimeException("No Drink In data base at all");
        }
        else{
            //the cursor copies current address, the memory location, of the head Drink Class
            Drinks cursor = head;
            //Search through the entire list untill drink name is macthed or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.name.equals(name)){
                    cursor=cursor.previous;//check
                    return true;
                }
                else{
                    cursor=cursor.previous;
                }
            }
            //this is to check the last drink within the list
            if(cursor.name.equals(name)){
                Drinks temp = new Drinks();
                cursor = temp;
                return true;
            }
            //if the drink item is not within the list return false
            else{
                return false;
            }
        }
    }

    //getters:

    //get the price of the food
    public double getPrice(String name){
        //use getDrink function to get the class and access its attribute
        //if there are no drink found then return -1
        return getDrinks(name) == null ? -1:getDrinks(name).price;
    }

    //get the calorie of the food
    public int getCalorie(String name){
        //use getDrink function to get the class and access its attribute
        //if there are no drink found then return -1
        return getDrinks(name) == null ? -1:getDrinks(name).calorie;
    }

    //setters:

    //set the price of the food
    public boolean setPrice(String name,double price){
        //check if there is an drink with the requested name
        if (getDrinks(name) != null){
            getDrinks(name).price=price;
            return true;
        }
        else{
            //alert there are no drink
            return false;
        }
    }

    //set the calorie of the drink
    public boolean setCalorie(String name, int calorie){
        //check if there is an drink with the requested name
        if(getDrinks(name) != null){
            getDrinks(name).calorie=calorie;
            return true;
        }
        else{
            //alert there are no drink
            return false;
        }
    }

    //set the quantitry of the drink
    public boolean setDrinks(String name, int quantity){
        if(getDrinks(name) != null){
            getDrinks(name).quantity=quantity;
            return true;
        }
        else{
            //alert no such drink
            return false;
        }

    }


    //get the drink with requested name
    public Drinks getDrinks(String name){
        if (head == null){
            throw new RuntimeException("No Drink In data base at all");
            //return false;
        }
        else{
            Drinks cursor=head;
            //searching until no next drink
            while(cursor.previous != null){
                if(cursor.name.equals(name)){
                    return cursor;
                }
                else{
                    cursor=cursor.previous;
                }
            }
            return null; 
        }
    }


    public static void main(String[] args){
        //Drinks head=new Drinks();
        //head.addDrinks("cola", 2.8, 5, false);
        //head.addDrinks("sprite", 3.0, 2, true);
        //head.getPrice("cola");

    }
    
}
