/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore.Products;

/**
 *
 * @author Cj Naylor
 */
public abstract class Product implements Comparable<Product> {
    //initializes variables
    public double price;
    public String title;
    public int year;
    public int id;
    public int stock;
    public String type;
    
    //constructor to create product object
    public Product(String type,double price, String title, int year, int id, int stock) {
        this.price = price;
        this.title = title;
        this.year = year;
        this.id = id;
        this.stock = stock;
        this.type = type;
    }
    //display method for products
    public String toString(){
        return "-------------------------------------------------------------------------\nType: " + type + "    Title: " + title + "    ID: " + id + "    Price: " + price + " \n   Year: " + year + "    Amount in stock: " + stock;
    }
    //csv toString method
    public String csvToString(){
        return type + "," + price + "," + title + "," + year + "," + id + "," + stock;
    }
    //compare to method, compares prices of two products
    public int compareTo(Product other){
        if(this.price > other.price){
            return 1;
        }else if(this.price < other.price){
            return -1;
        }else{
            return 0;
        }
    }
    //decrement method to subtract stock by 1
    public void decrement(){
        stock--;
    }   
    //getters and setters
    public double getPrice() {
        return price;
    }
    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setPrice(double price) {
        this.price = price;
        
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        if (year >= 0){
        this.year = year;}
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
}
