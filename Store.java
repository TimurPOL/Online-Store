package com.example.click.Model.onlineStore;



import com.example.click.Model.onlineStore.exceptions.Messege;
import com.example.click.Model.onlineStore.exceptions.ProductNotFoundException;

import java.util.*;

/**
 *
 *
 * a = {"Laptop", "Phone", "Headphones"}
 * b = {10, 3, 0.5}
 *
 *
 * store = {
 *      {0.5, "Headphones"},
 *      {3, "Phone"},
 *      {10, "Laptop"}
 *      }
 *
 *
 *      Map<String, List<Product>> products:
 *
 *      "техніка" : ["computer", "phone"]
 *
 *      "Їжа" : ["apple", "banana"]
 *
 *      "одяг" : ["Hat", "T-shirt"]
 *
 *      "будівельний" : []
 *
 */

public class Store{
    private  List<Product> productList = new ArrayList<>();
    private Map<String, List<Product>> products;
    private  String storeName;
    private CashRegister cashRegister;

    public Store(String storeName) {
        this.storeName = storeName;
        this.products = new TreeMap<>();
        this.cashRegister = new CashRegister();
    }

    public String getStoreName(){
        return storeName;
    }
    public void addSection(String name){
        if(!products.containsKey(name)) {
            products.put(name, new ArrayList<>());
        }
    }

    public Store() {
    }

    public void addProduct(String type, String name, double price){
        Product newProduct = new Product(name, price);
        products.get(type).add(newProduct);
    }

    public void addProduct(String type, String name, double price, int count){
        Product newProduct = new Product(name, price, count);
        products.get(type).add(newProduct);
    }
        public void skedka(int skedka,String type,String Name) throws ProductNotFoundException {
        Product item = findProductByName(type,Name);
            if(skedka > 0 && skedka < 100){
           double price = item.getPrice();
            item.setPrice(price / ( 1- (double)skedka / 100) );
            }
        }
    public void buyProductToCart(String type, String name, int count,boolean payToCart ) throws ProductNotFoundException, Messege {
        CashRegister cashRegister1 = new CashRegister();
        Product item = findProductByName(type, name);
        if (cashRegister1.ifCart(payToCart)) {
            if (count <= item.getCount()) {
                System.out.println("Товар куплено за " + item.getPrice() * count + " грн оплата:Картка");
                cashRegister.addCashToCart(item.getPrice() * count);
                item.minusCount(count);
            } else {
                throw new Messege();
            }
        }
    }

    public void buyProduct(String type, String name, int count ) throws ProductNotFoundException, Messege {
        Product item = findProductByName(type, name);
        if (count <= item.getCount()) {
            System.out.println("Товар куплено за " + item.getPrice() * count + " грн");
            cashRegister.addMoney(item.getPrice() * count);
            item.minusCount(count);
        }else {
            throw new Messege();
        }
    }


    public void addCountToProduct(String type, String name, int count )throws ProductNotFoundException{
        findProductByName(type, name).addCount(count);
    }


    public void showAllProductsBySection(String type){
        System.out.println(type);
        System.out.println("name\tprice\tcount");
        List<Product> itemProducts = products.get(type);
        for (int i = 0; i < itemProducts.size(); i++) {
            Product item = itemProducts.get(i);
            System.out.println(item.getName() + "\t" + item.getPrice() + "\t" + item.getCount());
        }
        System.out.println();
    }


    public Product findProductByName(String type, String name) throws ProductNotFoundException{
        List<Product> productList = products.get(type);

        for (int i = 0; i < productList.size() ; i++) {
            Product item = productList.get(i);
            if(item.getName().equals(name)){
                return item;
            }
        }
        throw new ProductNotFoundException("Продукт " + name + " не знайдено");
    }

    public void getBalance(){
        cashRegister.showBalance();
    }
    public void sortDownByPrice(String type) {

        products.get(type).sort((a, b) -> Double.compare(b.getPrice(), a.getPrice()));
    }

    public void sortProductsByPrice(String type){
        products.get(type).sort((a, b) -> Double.compare(a.getPrice(), b.getPrice()));

    }
    public void sortProductsBuCount(String type){
        products.get(type).sort((a,b) -> Integer.compare(a.getCount(),b.getCount()));
    }

    public void sortDownByCount(String type){
        products.get(type).sort((a,b) -> Integer.compare(b.getCount(),a.getCount()));
    }

    public void sortByName(String type){
        products.get(type).sort((a,b) -> a.getName().compareTo(b.getName()));
    }

    public void sortDownByName(String type){
        Collections.sort(products.get(type), new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });
    }

    public void test() {

        products.put("devices",new ArrayList<>(List.of(
                new Product("computer", 15000, 15),
                new Product("phone", 10000, 11)
        )));

        products.put("clothes",new ArrayList<>( List.of(
                new Product("suit", 25000, 3),
                new Product("Cap", 79999, 8),
                new Product("T-short", 999999, 2)
        )));
        products.put("Feed",new ArrayList<>( List.of(
                new Product("Burger", 34, 9),
                new Product("pizza", 899, 8),
                new Product("chocolate", 80, 88)
        )));
        products.put("online Store",new ArrayList<>( List.of(
                new Product("New Site", 334, 9),
                new Product("New game", 899, 8)
        )));
    }

    public Map<String, List<Product>> getProducts () {
        return products;
    }
    @Override
    public String toString(){
        String print = String.format("%s[]",products);
        return  print;
    }
}