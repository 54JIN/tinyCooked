public class Food{
    Food head;
    String foodName;
    double price;
    int calories;
    Food previous;

    public Food(){
        this.head = null;
        this.previous = null;
    }
    public Food(String foodName, double price){
        this.previous = null;
        this.foodName = foodName;
        this.price = price;
    }
    public void add(){
        
    }

    //why u need main
    public static void main(String[] args){
        System.out.println("Hi");
    }
}
