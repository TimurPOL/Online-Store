package com.example.click.Model.onlineStore;

public class CashRegister   {
    private double cash;
    private double balanceCart;
    private String nameCart;

    public String getNameCart() {
        return nameCart;
    }

    public double getCash() {
        return cash;
    }

    public double getBalanceCart() {
        return balanceCart;
    }
    public boolean ifCart(boolean retur){
        return retur;
    }
    public void setNameCart(String nameCart) {
        this.nameCart = nameCart;
    }
    public void addCashToCart(double price){
        this.balanceCart += price;
    }
    public void setBalanceCart(int balanceCart) {
        this.balanceCart = balanceCart;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    public void payOnCart(double amountCart){
        this.balanceCart += amountCart;

    }
    public void addMoney(double amount){
        cash += amount;
    }
    public void showBalance(){
        System.out.println(cash);
    }
    public void buyList(){
        Store store = new Store();

    }
}
