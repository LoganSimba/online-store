package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();



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
