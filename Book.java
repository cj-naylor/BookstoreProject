/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore.Products;

/**
 *
 * @author Cj Naylor
 */

public class Book extends Product{
    //creates variable that is necessary to create book object
    private String author;
    
    //getters and setters
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    
    //constructor that creates book object, including all of the product variables as well as the new book variable
    public Book(String type,double price, String title, int year,String author,int id, int stock) {
        super(type,price,title,year,id,stock);
        this.author = author;
    }
    //display method for book object
    public String toString(){
        return "(Book) \n" + super.toString() + "  Author: " + this.author + "\n-------------------------------------------------------------------------\n";
        
    }
    //csv print method
    public String csvToString(){
        return super.csvToString() + "," + author;
    }

    
    
    
    
}
