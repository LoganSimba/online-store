package com.pluralsight;

import java.util.ArrayList;

public class OnlineStore {
    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<>();



    }
    //create a method that prints all available products
    public static void viewAllProducts(ArrayList<Product> products){
        for(Product product : products){
            System.out.println(product.toString());
        }

    }
}
