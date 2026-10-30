package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        //initialize method and pass it a csv file as the parameter
        loadProductInInventory("products.csv",products);

        System.out.println("--------");
        // call the search product by name
      //  searchProductName(products,scanner);
        //addProduct(scanner,products);
        //call the method to view all products
        //viewAllProducts(products);
       // searchByDepartment(products, scanner);
        searchByPriceRange(products, scanner);


    }
    // load product from csv file and add it to the arraylist
    public static void loadProductInInventory(String file, ArrayList<Product> products){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line;
            reader.readLine();
            while((line = reader.readLine()) != null){
                String[] parts = line.split("\\|");
                String productCode = parts[0];
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                String department = parts[3];

                products.add(new Product(productCode, productName, price, department));
            }
            reader.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }



    }



    //create a method that prints all available products
    public static void viewAllProducts(ArrayList<Product> products){
        //iterate through the products and print them
        for(Product product : products){
            System.out.println(product.toString());
        }

    }
    //add a method to search through the product and filter by name
    public static void searchProductName(ArrayList<Product> products, Scanner scanner){
        //ask user for the name they want to search and store it in a scanner variable
        System.out.print("Search product(Name): ");
        String productName = scanner.nextLine().trim();
        boolean found = false;
        //iterate thrugh the list and check if there is a similar name
        for(Product product : products){
            if(product.getProductName().equalsIgnoreCase(productName)){
                System.out.println(product.toString());
                found = true;
            }

            }
        if(!found){
            System.out.println("No match found for: " + productName);
        }
        }


    //added a method to search by department name
    public static void searchByDepartment(ArrayList<Product> products, Scanner scanner) {
        //prompt user for the department name and store it in a variable
        System.out.print("Search department: ");
        String department = scanner.nextLine().trim();

        //boolean to keep track of if we found a match in the department or no
        boolean found = false;
        for (Product product : products) {
            //if statement to check if the user input matches the departments
            if (product.getDepartment().equalsIgnoreCase(department)) {
                System.out.println(product);
                found = true;
            }
        }//print a message if no match found
        if (!found) {
            System.out.println("No products found in: " + department);
        }
    }
    // add a method to seach the price range
    public static void searchByPriceRange(ArrayList<Product> products, Scanner scanner) {
        //prompt user for the minimun price
        System.out.print("Minimum price: ");
        double min = scanner.nextDouble();

        //prompt user for the maximum price
        System.out.print("Maximum price: ");
        double max = scanner.nextDouble();
        scanner.nextLine(); // clears the leftover newline
        //boolean to keep track of weather we found a match in the price range
        boolean found = false;
        for (Product product : products) {
            //if statement to compare the users price range with the product price
            if (product.getPrice() >= min && product.getPrice() <= max) {
                System.out.println(product);
                found = true;
            }
        }//if not found print a message
        if (!found) {
            System.out.println("No products between $" + min + " and $" + max);
        }
    }




        // add method to add product a product
        public static void addProduct(Scanner scanner, ArrayList<Product> products){
            //promot user for the code and store it
            System.out.print("Product code: ");
            String productCode = scanner.nextLine().trim();

            //promot user for the name and store it
            System.out.print("Product Name: ");
            String productName = scanner.nextLine().trim();

            //promot user for the price and store it then eat a line in the buffer
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            // prompt user for the department and store it
            System.out.print("Department: ");
            String department = scanner.nextLine().trim();

            products.add(new Product(productCode, productName, price, department));
            System.out.println("product added successfully");

        }
}

