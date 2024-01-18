/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package bookstore.Products;

/**
 *
 * @author Cj Naylor
 */
public interface BookStoreSpecification {
    
  //method to restock an item
    public int restockProduct(int productId, int amount);  
   
  //method to find total value of store inventory
    public double inventoryValue();   
}
