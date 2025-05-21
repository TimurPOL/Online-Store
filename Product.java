package com.example.click.Model.onlineStore;

import java.util.Objects;

public class Product implements Comparable<Product> {
    private String name;
    private double price;
    private int count;


    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.count = 0;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product(String name, double price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }



    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void addCount(int count){
        this.count += count;
    }

    public void minusCount(int count){
        this.count -= count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && count == product.count && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, count);
    }

    @Override
    public int compareTo(Product o) {
        return this.getName().compareTo(o.getName());
        }
}
