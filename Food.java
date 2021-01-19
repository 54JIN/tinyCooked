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
        //the calories is set to -1 due to the calories not being established, yet. This is done for the purpose of getCalories Method.
        this.calories = -1;
    }
    //Declares a Food class with calories already declared.
    public Food(String foodName, double price, int calories){
        this.previous = null;
        this.foodName = foodName;
        this.price = price;
        this.calories = calories;
    }
    //add a food item without calories being declared
    public void addFood(String foodName, double price){
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
    public void addFood(String foodName, double price, int calories){
        Food tempFood = new Food(foodName, price, calories);
        if(head == null){
            head = tempFood;
        }
        else{
            tempFood.previous = head;
            head = tempFood;
        }
    }
    public boolean removeFood(String foodName){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return false rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Food In data base");
            //return false;
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            Food cursor = head;
            //Search through the entire list untill either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.foodName.equals(head.foodName)){
                    head = cursor.previous;
                    return true;
                }
                else if(cursor.foodName.equals(foodName)){
                    cursor = cursor.previous;
                    return true;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.foodName.equals(head.foodName) && cursor.previous == null){
                //Food tempFood = new Food();
                head = null;
                return true;
            }
            else if(cursor.foodName.equals(foodName)){
                Food temp = new Food();
                cursor = temp;
                return true;
            }
            //if the food item is not within the list return false
            else{
                return false;
            }
        }
    }
    //get the price of the food item if it exists other wise return -1
    public double getPrice(String foodName){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return -1 rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Food In data base");
            //return -1;
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            Food cursor = head;
            //Search through the entire list untill either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.foodName.equals(foodName)){
                    return cursor.price;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.foodName.equals(foodName)){
                return cursor.price;
            }
            //if the food item is not within the list return -1
            else{
                return -1;
            }
        }
    }
    public int getCalories(String foodName){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return -1 rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Food In data base");
            //return -1;
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            Food cursor = head;
            //Search through the entire list untill either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.foodName.equals(foodName)){
                    return cursor.calories;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.foodName.equals(foodName)){
                return cursor.calories;
            }
            //if the food item is not within the list return -1
            else{
                return -1;
            }
        }
    }
    //set calories to an item without calories initialized already or change the calories of an food item already containg a calorie value
    //After setting the calories return true as a singal that the calorie data within the food has been changed other wise return false as a signal to state that it has not been changed
    public boolean setCalories(String foodName, int calories){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return false rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Food In data base");
            //return false;
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            Food cursor = head;
            //Search through the entire list untill either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.foodName.equals(foodName)){
                    cursor.calories = calories;
                    return true;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.foodName.equals(foodName)){
                cursor.calories = calories;
                return true;
            }
            //if the food item is not within the list return false
            else{
                return false;
            }
        }
    }
    //change the price of an food item already containg a price value
    //After setting the price return true as a singal that the price data within the food has been changed other wise return false as a signal to state that it has not been changed
    public boolean setPrice(String foodName, int price){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return false rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Food In data base");
            //return false;
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            Food cursor = head;
            //Search through the entire list untill either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.foodName.equals(foodName)){
                    cursor.price = price;
                    return true;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.foodName.equals(foodName)){
                cursor.price = price;
                return true;
            }
            //if the food item is not within the list return false
            else{
                return false;
            }
        }
    }
    //Check if the food item exists within the list already or exists at all within the list
    public boolean foodExist(String foodName){
        //If the food list is empty then throw an error message stopping the entire terminal (Later Fix to System.out.println or just return false rather than stopping the terminal)
        if(head == null){
            throw new RuntimeException("No Food In data base");
            //return false;
        }
        else{
            //the cursor copies the address, the memory location, of the head Food Class
            Food cursor = head;
            //Search through the entire list until either the foodName matches the given foodName or if the nodes previous is empty.
            while(cursor.previous != null){
                if(cursor.foodName.equals(foodName)){
                    return true;
                }
                else{
                    cursor = cursor.previous;
                }
            }
            //this is to check the last food within the list
            if(cursor.foodName.equals(foodName)){
                return true;
            }
            //if the food item is not within the list return false
            else{
                return false;
            }
        }
    }
    public static void main(String[] args){
        System.out.println("Hi");
        Food temp = new Food();
        temp.addFood("hamburger", 4.00);
        temp.addFood("pizza slice", 1.00);
        System.out.println(temp.getPrice("hamburger"));
        System.out.println(temp.getPrice("pizza slice"));
        System.out.println(temp.getCalories("pizza slice"));
        System.out.println(temp.foodExist("pizza slice"));
        System.out.println(temp.setCalories("pizza slice",140));
        System.out.println(temp.getCalories("pizza slice"));
        System.out.println(temp.setPrice("pizza slice", 2));
        System.out.println(temp.getPrice("pizza slice"));
        System.out.println(temp.removeFood("pizza slice"));
        System.out.println(temp.foodExist("pizza slice"));
        System.out.println(temp.removeFood("hamburger"));
        System.out.println(temp.foodExist("hamburger"));
    }
}
