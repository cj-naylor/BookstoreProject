/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore.Products;

/**
 *
 * @author Cj Naylor
 */
public class CD extends Product {
    //Creates variable to describe CD object
    private String artist;
    //getter
    public String getArtist() {
        return artist;
    }
    //constructor that creates CD object
    public CD(String type,double price, String title, int year,String artist,int id, int stock) {
        super(type,price,title,year,id,stock);
        this.artist = artist;
    }
    //display method for cd object
    public String toString(){
        return "(CD) \n " + super.toString() + "  Artist: " + this.artist + "\n-------------------------------------------------------------------------\n";
        
    }
    //csv print method
     public String csvToString(){
        return super.csvToString() + "," + artist;
    }

    //setter
    public void setArtist(String artist) {
        this.artist = artist;
    }

    
    
}
