public class Food{
    Food head;
    String foodName;
    double price;
    int calories;
    Food next;
    //For creating an empty Food class
    public Food(){
        this.next = null;
    }
    //Declares a food class without calories already declared.
    public Food(String foodName, double price){
        this.foodName = foodName;
        this.price = price;
        this.next = null;
    }
    //Declares a Food class with calories already declared.
    public Food(String foodName, double price, int calories){
        this.foodName = foodName;
        this.price = price;
        this.calories = calories;
        this.next = null;
    }
    //add a food item without calories being declared
    public void add(String foodName, double price){
        Food tempFood = new Food(foodName,price);
        if(head == null){
            head = tempFood;
        }
        else{
            Food cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = tempFood;
        }
    }
    //add a food item with calories attached 
    public void add(String foodName, double price, int calories){
        Food tempFood = new Food(foodName,price,calories);
        if(head == null){
            head = tempFood;
        }
        else{
            Food cursor = head;
            while(cursor.next != null){
                cursor = cursor.next;
            }
            cursor.next = tempFood;
        }
    }

    //why u need main
    public static void main(String[] args){
        System.out.println("Hi");
    }
}
