package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();

        loadProductInInventory("products.csv",products);
        System.out.println(products.toString());



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
        //iterate thrugh the list and check if there is a similar name
        for(Product product : products){
            if(product.getProductName().equalsIgnoreCase(productName)){
                System.out.println(product.toString());
            }
            else{
                System.out.println("No march founf for: " + productName);
            }
        }

    }
}
