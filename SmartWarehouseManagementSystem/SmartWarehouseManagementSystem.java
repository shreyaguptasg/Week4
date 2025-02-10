package Day1.SmartWarehouseManagementSystem;
import java.util.ArrayList;
import java.util.List;

//Create an abstract class WarehouseItem that all items
// extend (Electronics, Groceries, Furniture).
abstract  class WarehouseItem{
    private String name;

    public WarehouseItem(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + ": " + name;
    }
}
//Different item types extending WarehouseItem
class Electronics extends WarehouseItem{
    public Electronics(String name){
        super(name);
    }
}
class Groceries extends  WarehouseItem{
    public Groceries(String name){
        super(name);
    }
}
class Furniture extends WarehouseItem{
    public Furniture(String name){
        super(name);
    }
}

//Generic Storage class with bounded type parameter
class Storage<T extends WarehouseItem>{
    private List<T> items = new ArrayList<>();

    public void addItem(T item){
        items.add(item);
    }

    public List<T> getItems(){
        return items;
    }
}

//Utility class to display all items using wildcards
class WarehouseUtil{
    public static void displayItems(List<? extends WarehouseItem> items){
        for(WarehouseItem item : items){
            System.out.println(item);
        }
    }
}
public class SmartWarehouseManagementSystem {
    public static void main(String[] args) {
        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Television"));
        electronicsStorage.addItem(new Electronics("Air Conditioner"));

        Storage<Groceries> groceriesStorage = new Storage<>();
        groceriesStorage.addItem(new Groceries("Vegetables"));
        groceriesStorage.addItem(new Groceries("Fruits"));

        Storage<Furniture> furnitureStorage= new Storage<>();
        furnitureStorage.addItem(new Furniture("Sofa"));
        furnitureStorage.addItem(new Furniture("Table"));

        System.out.println("Electronics in Storage");
        WarehouseUtil.displayItems(electronicsStorage.getItems());

        System.out.println("Groceries in Storage");
        WarehouseUtil.displayItems(groceriesStorage.getItems());

        System.out.println("Furniture in Storage");
        WarehouseUtil.displayItems(furnitureStorage.getItems());


    }
}
