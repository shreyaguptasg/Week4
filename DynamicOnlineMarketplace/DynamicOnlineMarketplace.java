package Day1.DynamicOnlineMarketplace;

import java.util.ArrayList;
import java.util.List;

abstract  class Category{
    private String name;
    private double price;

    public Category(String name, double price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
         this.price=price;
    }
    @Override
    public String toString(){
        return getClass().getSimpleName() + ": " + name;
    }
}
//Define a generic class Product<T> where T is restricted to a category
// (BookCategory, ClothingCategory, etc.).
class Product<T>{
   private String name;
   private double price;
   private T category;

   public Product(String name, double price, T category){
       this.name=name;
       this.price=price;
       this.category=category;
   }

    public String getName(){
       return name;
    }

    public double getPrice(){
        return price;
    }

    public T getCategory(){
       return  category;
    }

    public void applyDiscount(double percentage){
       this.price -= this.price*(percentage/100);
    }

    @Override
    public String toString(){
       return name + " (" + category + ") - $" + price;
    }
}

enum BookCategory{
    FICITION, NON_FICITION,SCIENCE, HISTROY;
}

enum ClothingCategory{
   MENS,WOMENS,KIDS;
}

enum GadegetCategory{
   MOBILE, LAPTOP, ACCESSORY;
}
//Implement a generic method to apply
// discounts dynamically (<T extends Product> void applyDiscount(T product, double percentage)).
class DiscountUtil{
    public static <T extends  Product<?>> void applyDiscount(T product, double percentage){
        product.applyDiscount(percentage);
        System.out.println("Discount applied to " + product.getName() + ". New price: $" + product.getPrice());
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book = new Product<>("JavaProgramming", 50,BookCategory.SCIENCE);
        Product<ClothingCategory> clothes = new Product<>("Cotton Shirt", 25, ClothingCategory.KIDS);
        Product<GadegetCategory> gadget = new Product<>("smarphone", 580, GadegetCategory.MOBILE);

        System.out.println("Product Catalog:");
        System.out.println(book);
        System.out.println(clothes);
        System.out.println(gadget);

        DiscountUtil.applyDiscount(book, 10);
        DiscountUtil.applyDiscount(clothes,15);
        DiscountUtil.applyDiscount(gadget,8);

    }
}