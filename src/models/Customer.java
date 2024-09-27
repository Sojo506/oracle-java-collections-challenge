package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
    List<Product> products;
    private double balance;

    public Customer(double balance) {
        this.balance = balance;
        this.products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public double getBalance() {
        return balance;
    }

    private void setBalance(double balance) {
        this.balance -= balance;
    }

    public boolean addProduct(Product product) {
        if (product.getPrice() > this.getBalance()) {
            return false;
        } else {
            setBalance(product.getPrice());
            this.products.add(product);
            return true;
        }
    }

    public void showProducts() {
        System.out.println("********************************");
        System.out.println("COMPRAS REALIZADAS:\n");
        Collections.sort(products);
        products.forEach(product -> {
            System.out.println(product.getName() + " - " + product.getPrice());
        });
        System.out.println("\n********************************");
    }


}
