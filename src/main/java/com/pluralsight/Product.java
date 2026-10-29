package com.pluralsight;

public class Product {
    private String productCode;
    private String productName;
    private double price;
    private String department;

    public Product(String productCode, String productName, double price, String department) {
        this.productCode = productCode;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return productCode + " | " + productName + " | $" + price + " | " + department;
    }
}
