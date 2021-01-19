public class Food{
    
    Food head;
    String foodName;
    double price;
    int calories;
    Food previous;

    //For creating an empty Food class
    public Food(){
        this.head = null;
        this.previous = null;
    }
    //Declares a food class without calories already declared.
    public Food(String foodName, double price){
        this.previous = null;
        this.foodName = foodName;
        this.price = price;
    }
    //Declares a Food class with calories already declared.
    public Food(String foodName, double price, int calories){
        this.previous = null;
        this.foodName = foodName;
        this.price = price;
        this.calories = calories;
    }
    //add a food item without calories being declared
    public void add(String foodName, double price){
        Food tempFood = new Food(foodName, price);
        if(head == null){
            head = tempFood;
        }
        else{
            tempFood.previous = head;
            head = tempFood;
        }
    }
    //add a food item with calories attached 
    public void add(String foodName, double price, int calories){
        Food tempFood = new Food(foodName, price, calories);
        if(head == null){
            head = tempFood;
        }
        else{
            tempFood.previous = head;
            head = tempFood;
        }
    }
    //get the price of the food item if it exists other wise return -1;
    public double getPrice(String foodName){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return -1 rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Food In data base");
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            Food cursor = head;
            //Search through the entire list untill either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.foodName == foodName){
                    return cursor.price;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.foodName == foodName){
                return cursor.price;
            }
            //if the food item is not within the list return -1
            else{
                return -1;
            }
        }
    }

    public static void main(String[] args){
        System.out.println("Hi");
        Food temp = new Food();
        temp.add("hamburger", 4.00);
        temp.add("pizza slice", 1.00);
        System.out.println(temp.getPrice("hamburger"));
        System.out.println(temp.getPrice("pizza slice"));
    }
}
