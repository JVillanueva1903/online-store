package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    private String sku;
    private boolean productName;

    public Product(String datum, String datum1, double v, String i) {

    }

    public Product(String av1051, String jblBluetoothSpeaker, double v, String audioVideo) {

    }

    public Product(String datum, String datum1, double v, String s) {

    }

    public Product(String datum, String datum1, double v, String s) {

    }

    public Product(String av1051, String jblBluetoothSpeaker, double v, String audioVideo) {

    }

    public Product(String datum, String datum1, double v, String s) {

    }

    public Product(String datum, String datum1, double v, String s) {

    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public boolean getProductName() {
        return productName;
    }

    public void setProductName(boolean productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return 0;
    }
}
import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String sku;
    private String productName;
    private double price;
    private String department;

    public Product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return sku + " | " + productName + " | $" + price + " | " + department;
    }
}

public class OnlineStore {

    public static void displayProducts(ArrayList<Product> products) {
        System.out.println("\nAvailable Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static Product searchProduct(ArrayList<Product> products, String sku) {
        for (Product product : products) {
            if (product.getSku().equalsIgnoreCase(sku)) {
                return product;
            }
        }
        return null;
    }

    public static void checkout(ArrayList<Product> cart) {
        double total = 0;

        System.out.println("\n----- Shopping Cart -----");

        for (Product product : cart) {
            System.out.println(product.getProductName() +
                    " - $" + product.getPrice());
            total += product.getPrice();
        }

        System.out.printf("\nTotal: $%.2f%n", total);
        System.out.println("Thank you for your purchase!");
    }

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        // Products from CSV
        products.add(new Product("AV1051", "JBL Bluetooth Speaker", 89.95, "Audio Video"));
        products.add(new Product("AV1312", "Mini 1000 Lumens Projector", 149.95, "Audio Video"));
        products.add(new Product("AV1412", "XLR Podcast Cardiod Mic", 44.99, "Audio Video"));

        products.add(new Product("CP2012", "Desktop PC Computer Intel Core i5", 139.00, "Computers"));
        products.add(new Product("CP2123", "Wired Backlit Keyboard", 21.99, "Computers"));
        products.add(new Product("CP2154", "RGB Wireless Gaming Mouse", 67.45, "Computers"));

        products.add(new Product("GM1032", "Telestrations Board Game", 17.99, "Games"));
        products.add(new Product("GM1075", "Battleship Board Game", 12.99, "Games"));
        products.add(new Product("GM1148", "Retro Handheld Arcade", 24.45, "Games"));

        products.add(new Product("PW1255", "USB C to A Cable", 13.95, "Electronics"));
        products.add(new Product("PW1341", "Solar Powered Battery Charger", 19.99, "Electronics"));
        products.add(new Product("PW1431", "Wireless Charger iPhone", 12.99, "Electronics"));

        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== ONLINE STORE ===");
            System.out.println("1. View All Products");
            System.out.println("2. Search Product by SKU");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    displayProducts(products);
                    break;

                case 2:
                    System.out.print("Enter SKU: ");
                    String searchSku = input.nextLine();

                    Product found = searchProduct(products, searchSku);

                    if (found != null) {
                        System.out.println("Product Found:");
                        System.out.println(found);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter SKU to add to cart: ");
                    String sku = input.nextLine();

                    Product product = searchProduct(products, sku);

                    if (product != null) {
                        cart.add(product);
                        System.out.println(product.getProductName()
                                + " added to cart.");
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 4:
                    checkout(cart);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);

        input.close();
    }
}
