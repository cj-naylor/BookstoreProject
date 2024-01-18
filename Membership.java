/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bookstore.Membership;

/**
 *
 * @author Cj Naylor
 */
public class Membership {
    //
    //initializes variables
       public int fee; 
       public String type;

    //getter
    public int getFee() {
        return fee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    //constructor
    public Membership(String type,int fee) {
        this.type = type;
        this.fee = fee;
    }

 
    //setter
    public void setFee(int fee) {
        this.fee = fee;
    }
    
    
}
