/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore.Products;

/**
 *
 * @author Cj Naylor
 */
public class DVD extends Product{
    //creates variable for DVD object
    private String director;
    
    //getter
    public String getDirector() {
        return director;
    }
    //constructor that creates DVD object
    public DVD(String type,double price, String title, int year,String director,int id, int stock) {
        super(type,price,title,year,id,stock);
        this.director = director;
    }
    //display method for dvd object
    public String toString(){
       return "(DVD) \n" + super.toString() + "  Director: " + this.director + "\n-------------------------------------------------------------------------\n";
        
    }
    //csv print method
     public String csvToString(){
        return super.csvToString() + "," + director;
    }
    //setter
    public void setDirector(String director) {
        this.director = director;
    }

    
    
 
}
