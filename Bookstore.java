/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package NaylorCJProject1;
//import statements to read off of other classes

import bookstore.Membership.Membership;
import bookstore.Products.Book;
import bookstore.Products.CD;
import bookstore.Products.DVD;
import bookstore.Products.Product;
import bookstore.Products.PurchasedProducts;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Cj Naylor
 */
public class Bookstore {

    // intializes arraylists
    public ArrayList<Product> products;
    public ArrayList<Member> members;
    public ArrayList<PurchasedProducts> purchasedProducts;


    public Bookstore() {

//sets up arrayLists for product inventory and members
        products = new ArrayList<Product>();
        members = new ArrayList<Member>();
        purchasedProducts = new ArrayList();

    }

    //method to complete a purchase 
    public boolean completePurchase(Product product, int am, Member member) {
        if (!products.contains(product)) {
            return false;
        } else {
            double total = member.getMoneySpent();
            total += product.getPrice();
            member.setMoneySpent(total);

            products.remove(product);
            return true;
        }

    }

    //adds products from csv file into array
    public void addProducts() throws FileNotFoundException{
        try{
            
        Scanner fileScanner = new Scanner(new File("data.csv"));
        String line;
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                String [] info = line.split(",");
                if (info[0].equals("book")||info[0].equals("Book")) {
                    String[] p = line.split(",");
                    Book book = new Book("book", Double.parseDouble(p[1]), p[2],Integer.parseInt(p[3]),p[6], Integer.parseInt(p[4]),Integer.parseInt(p[5]));
                    products.add(book);
                }
                else if (info[0].equals("CD")||info[0].equals("cd")) {
                    String[] p = line.split(",");
                    CD book = new CD("CD", Double.parseDouble(p[1]), p[2],Integer.parseInt(p[3]), p[6], Integer.parseInt(p[4]),Integer.parseInt(p[5]));
                    products.add(book);
                }
                else if (info[0].equals("DVD")|| info[0].equals("dvd")) {
                    String[] p = line.split(",");
                    DVD book = new DVD("DVD", Double.parseDouble(p[1]), p[2],Integer.parseInt(p[3]), p[6], Integer.parseInt(p[4]),Integer.parseInt(p[5]));
                    products.add(book);
                }               
            }
        }catch (FileNotFoundException exc){
            System.out.println("File not found, please make sure pathname was inputted correctly");
        }
    }

    //method to restock a product
    public void restockProduct(int amount, int id) {
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                int am = products.get(i).getStock();
                products.get(i).setStock(amount + am);
            }
        }
    }

    //method to return the total value of all products
    public double inventoryValue() {
        int value = 0;
        for (int i = 0; i < products.size(); i++) {
            double p = products.get(i).getPrice() * products.get(i).getStock();
            value += p;
        }
        return value;
    }

    //method to organize products in order from cheapest to most expensive
    public String organizeProducts() {
        String organizedProducts = "";

        for (int i = 0; i < products.size(); i++) {
            for (int j = 0; j < products.size(); j++) {
                if (products.get(j).compareTo(products.get(i)) == 1) {
                    Product jo = products.get(i);
                    products.set(i, products.get(j));
                    products.set(j, jo);
                } else;
            }
        }
        for (int n = 0; n < products.size(); n++) {
            organizedProducts += ((n + 1) + ": " + products.get(n).toString() + "\n \n");
        }
        return organizedProducts;
    }

    // Methods to add a book, cd, or dvd to the inventory
    public void addBook(String type,double price, String title, int year, String author, int id, int stock) {
        Book book = new Book(type,price, title, year, author, id, stock);
        products.add(book);
    }

    public void addCD(String type,double price, String title, int year, String artist, int id, int stock) {
        CD cd = new CD(type,price, title, year, artist, id, stock);
        products.add(cd);
    }

    public void addDVD(String type,double price, String title, int year, String director, int id, int stock) {
        DVD dvd = new DVD(type,price, title, year, director, id, stock);
        products.add(dvd);
    }

    // method for customer to purchaseMembership
    private void purchaseMembership(String type) {
        if (type.equals("regular") || type.equals("Regular")) {
            Membership membership = new Membership("Regular", 0);
        } else if (type.equals("premium") || type.equals("Premium")) {
            Membership membership = new Membership("Premium", 50);
        }
    }


    /**
     * @param args the command line arguments
     */
}
