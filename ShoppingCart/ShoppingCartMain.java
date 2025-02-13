package Day2.ShoppingCart;
import java.util.*;

class ShoppingCart {
    private final Map<String, Double> productPrices; // Stores product prices
    private final LinkedHashMap<String, Integer> cartItems; // Maintains order of items added
    private final TreeMap<String, Double> sortedItemsByPrice; // Displays items sorted by price

    public ShoppingCart() {
        productPrices = new HashMap<>();
        cartItems = new LinkedHashMap<>();
        sortedItemsByPrice = new TreeMap<>(Comparator.comparing(productPrices::get));
    }

    // Add product with its price
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
        sortedItemsByPrice.put(product, price);
    }

    // Add an item to the cart
    public void addItemToCart(String product, int quantity) {
        if (!productPrices.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
    }

    // Display items in the order they were added
    public void displayCartItemsInOrder() {
        System.out.println("\nCart Items (Order Added):");
        cartItems.forEach((product, quantity) ->
                System.out.println(product + " -> " + quantity + " units"));
    }

    // Display items sorted by price
    public void displayItemsSortedByPrice() {
        System.out.println("\nItems Sorted by Price:");
        sortedItemsByPrice.forEach((product, price) ->
                System.out.println(product + " -> " + price));
    }

    // Display the total cost of the cart
    public void displayTotalCost() {
        double total = cartItems.entrySet().stream()
                .mapToDouble(entry -> productPrices.get(entry.getKey()) * entry.getValue())
                .sum();
        System.out.println("\nTotal Cart Cost: " + total);
    }
}

public class ShoppingCartMain {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products with their prices
        cart.addProduct("Laptop", 1200.0);
        cart.addProduct("Phone", 800.0);
        cart.addProduct("Headphones", 150.0);
        cart.addProduct("Mouse", 50.0);
        cart.addProduct("Keyboard", 100.0);

        // Adding items to the cart
        cart.addItemToCart("Laptop", 1);
        cart.addItemToCart("Phone", 2);
        cart.addItemToCart("Mouse", 3);
        cart.addItemToCart("Keyboard", 1);
        cart.addItemToCart("Headphones", 2);

        // Display items in order added
        cart.displayCartItemsInOrder();

        // Display items sorted by price
        cart.displayItemsSortedByPrice();

        // Display total cost
        cart.displayTotalCost();
    }
}
