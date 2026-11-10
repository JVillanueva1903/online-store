package com.pluralsight;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Starter code for the Online Store workshop.
 * Learners will complete the TODO sections to make the program work.
 * <p>
 * What is already done for you: the two lists, the Home Screen loop and
 * the method headers. Each TODO says what that method has to do.
 * Product.java is complete; products.csv sits at the project root.
 * You will need extra imports (for example java.io.BufferedReader,
 * java.io.FileReader, java.io.IOException) as you fill the TODOs in.
 */
public class Store<FilePurger> {

    public static void main(String[] args) {

        // Create lists for inventory and the shopping cart
        ArrayList<Product> inventory = new ArrayList<>();
        ArrayList<Product> cart = new ArrayList<>();

        // Load inventory from the data file (pipe-delimited: SKU|Product Name|Price|Department)
        loadInventory("products.csv", inventory);

        // Main menu loop
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 3) {
            System.out.println("\nWelcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter 1, 2, or 3.");
                scanner.nextLine();                 // discard bad input
                continue;
            }
            choice = scanner.nextInt();
            scanner.nextLine();                     // clear newline

            switch (choice) {
                case 1 -> displayProducts(inventory, cart, scanner);
                case 2 -> displayCart(cart, scanner);
                case 3 -> System.out.println("Thank you for shopping with us!");
                default -> System.out.println("Invalid choice!");
            }
        }
        scanner.close();
    }

    /**
     * Reads product data from a file and populates the inventory list.
     * File format (pipe-delimited), the first line is a header row:
     * SKU|Product Name|Price|Department
     * <p>
     * Example line:
     * AV1051|JBL Bluetooth Speaker|89.95|Audio Video
     */
    public static void loadInventory(String fileName, ArrayList<Product> inventory) {
        // TODO: skip the header line, then read each line, split on "|",
        //       create a Product object, and add it to the inventory list
    }
  try
    private String fileName;

    {
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }

        // Skip header line
        if (fileScanner.hasNextLine()) {
            fileScanner.nextLine();
        }

        // Read data lines
        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();

            String[] data = line.split("\\|");

            // Create Product object
            Product product = new Product(
                    data[0],                  // product id/name/etc.
                    data[1],
                    Double.parseDouble(data[2]),
                    String.valueOf(Integer.parseInt(data[3]))
            );

            // Add to inventory
            FilePurger inventory = null;
            inventory.add(product);
        }

        fileScanner.close();

    } catch (FileNotFoundException e) {
        System.out.println("Error: File not found.");
    }
}
    /**
     * Displays all products and lets the user add one to the cart.
     * Typing X returns to the main menu.
     */
    public static void displayProducts(ArrayList<Product> inventory,
                                       ArrayList<Product> cart,
                                       Scanner scanner) {
        // TODO: show each product (id, name, price),
        //       prompt for an id, find that product, add to cart
    }
      for (Product product : inventory) {
        System.out.

void println(product.getId() + " - "
        + product.

void getName() + " - $"
        + product.

void getPrice());
        }

        System.out.

void print("Enter product id: ") {

}

static int id = scanner.nextInt();

    for (Product product : inventory) {
        if (product.

void getId() == id) {
        cart.

add(product) {

}

System.out.

void println(product.getName() + " added to cart.");
        break;
        }
        }
        }

    /**
     * Shows the contents of the cart, calculates the total,
     * and offers the option to check out.
     */

    public static void displayCart(ArrayList<Product> cart, Scanner scanner) {
    // TODO:
    //   • list each product in the cart
    //   • compute the total cost
    //   • ask the user whether to check out (C) or return (X)
    //   • if C, call checkOut(cart, totalAmount, scanner)

    double totalAmount = 0.0;

    System.out.println("\n=== Shopping Cart ===");

    for (Product product : cart) {
        System.out.printf("%d - %s - $%.2f%n",
                product.getId(),
                product.getName(),
                product.getPrice());

        totalAmount += product.getPrice();
    }

    System.out.printf("%nTotal Cost: $%.2f%n", totalAmount);

    System.out.print("Enter C to check out or X to return: ");
    String choice = scanner.nextLine().trim().toUpperCase();

    if (choice.equals("C")) {
        checkOut(cart, totalAmount, scanner);
    }
}
    /**
     * Handles the checkout process:
     * 1. Confirm that the user wants to buy.
     * 2. Accept payment and calculate change.
     * 3. Display a simple receipt.
     * 4. Clear the cart.
     *
     * @return
     */
public static Product checkOut(ArrayList<Product> cart,
                               double totalAmount,
                               Scanner scanner) {
    // TODO: implement steps listed above

    if (cart.isEmpty()) {
        System.out.println("Your cart is empty.");
        return;
    }

    System.out.printf("Total Amount: $%.2f%n", totalAmount);

    double payment;
    do {
        System.out.print("Enter payment amount: $");
        payment = scanner.nextDouble();

        if (payment < totalAmount) {
            System.out.println("Insufficient payment. Please enter enough money.");
        }
    } while (payment < totalAmount);

    double change = payment - totalAmount;
    /**
     * Searches a list for a product by its id.
     *
     * @return the matching Product, or null if not found
     */
Product findProductById(String boolean inventory;
    id, ArrayList<Product> inventory) {
    // TODO: loop over the list and compare ids
    for (Product product : inventory) {
        if (product.getId().equals(id)) {
            return product;
        }
    }
    return null;
}
