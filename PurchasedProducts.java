/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore.Products;
import java.util.*;
import java.util.ArrayList;
/**
 *
 * @author Cj Naylor
 */
public class PurchasedProducts{
    public double price;
    public String title;  
    public int id;
    public String type;
    public int amBought;
    
    //constructor to create product object
    public PurchasedProducts(double price, String title,int id,int amBought,String type){
        this.price = price;
        this.title = title;
        this.id = id;
        this.type = type;
        this.amBought = amBought;
    }
    public String toString(){
        return "Type: " + type + ": " + "\nTitle:" + title + "    ID: " + id + "\nPrice: "+ price + "    Amount Bought: " +amBought;
    }
    public void incrementAm(){
        amBought++;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmBought() {
        return amBought;
    }

    public void setAmBought(int amBought) {
        this.amBought = amBought;
    }
    
}
