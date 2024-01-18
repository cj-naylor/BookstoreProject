/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NaylorCJProject1;

import java.util.*;
import bookstore.Membership.Membership;
import bookstore.Products.PurchasedProducts;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Cj Naylor
 */
public class TestHarness extends Bookstore {

    //initializes members list
    private static ArrayList<Member> members = new ArrayList();
    private static ArrayList<PurchasedProducts> pi = new ArrayList();

    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Creating scanner for user input, declaring boolean for while loop, and initializing total 
        Scanner scan = new Scanner(System.in);
        boolean continuee = true;
        double total = 0;
        //Creating new bookstore and adding products from file
        Bookstore bookstore = new Bookstore();
        bookstore.addProducts();

        //Declaring variables for first while loop
        boolean cont = false;
        String first = null;
        String last = null;
        boolean completed = false;
        int numArray = 0;
        int numMembersRegistered = 0;
        int am = 0;
        //while loop to ensure customers sign up to be a member 
        try {
            while (!cont) {
                System.out.println("Are you a member? Type 1 for yes, 2 for no.");
                int yn = scan.nextInt();
                if (yn == 1) {
                    System.out.println("What is your first name?");
                    first = scan.next();
                    System.out.println("What is your last name?");
                    last = scan.next();
                    cont = false;
                    continuee = true;
                    //loop to find member in members arraylist and save their position
                    for (int i = 0; i < members.size(); i++) {
                        if (members.get(i).getFirstName().equals(first)) {
                            if (members.get(i).getLastName().equals(last)) {
                                numArray = i;
                                completed = true;
                                cont = true;
                                continuee = true;
                            }

                        }
                    }
                    //If statement to tell customer their name could not be found
                    if (!completed) {
                        System.out.println("Sorry! We could not find your name in the system. Please register as a new member to continue");
                        continuee = true;
                    }
                } else if (yn == 2) {
                    System.out.println("Please select option 3 to register as a member to continue.");
                } else {
                    System.out.println("Invalid input, please try again.");
                    continuee = false;
                }
                //Print statements to guide customer through menu options
                while (continuee) {
                    System.out.println("Please select from one of the following options");
                    System.out.println("1: Make a purchase");
                    System.out.println("2. See products organized by price (Lowest to highest)");
                    System.out.println("3. Register yourself as a new member");
                    System.out.println("4. Register someone else as a new member");
                    System.out.println("5. Upgrade from regular membership to premium");
                    System.out.println("6. Check purchase total");
                    System.out.println("7. Restock a product");
                    System.out.println("8. Check inventory total");
                    System.out.println("9. Quit");
                    //switch cases for menu options
                    int num = scan.nextInt();
                    switch (num) {
                        //Switch case for purchasing an item
                        case 1:
                            double price;
                            System.out.println("Items:");
                            //if statement to make sure there are items available in stock
                            if (bookstore.products.size() <= 0) {
                                System.out.println("Sorry we are currently have no items in stock.");
                                break;
                            } //Available items display loop
                            else {
                                int itemNum = 1;
                                int i;
                                System.out.println("These are the items that we have in stock:");
                                for (i = 0; i < bookstore.products.size(); i++) {
                                    System.out.println("Number " + itemNum + " : ");
                                    System.out.println(bookstore.products.get(i).toString());
                                    itemNum++;
                                }
                                //Choice of item to purchase code
                                System.out.println("Which number item would you like?");
                                int n = scan.nextInt() - 1;
                                price = bookstore.products.get(n).getPrice();
                                System.out.println("Good choice! That item will be $" + price);
                                double price2 = bookstore.products.get(n).getPrice();
                                String title2 = bookstore.products.get(n).getTitle();
                                int id2 = bookstore.products.get(n).getId();
                                String type2 = bookstore.products.get(n).getType();

                                //code to remove item
                                if (bookstore.products.get(n).getStock() > 1) {
                                    bookstore.products.get(n).decrement();
                                } else {
                                    bookstore.products.remove(n);
                                }
                                total += price;
                                //creating new PurchasedProduct item and adding it to arrayList
                                PurchasedProducts p = new PurchasedProducts(price2, title2, id2, am, type2);
                                boolean inList = false;
                                //editing amountBought based on if the item was already in arrayList or not
                                for (int o = 0; o < pi.size(); o++) {
                                    if (pi.get(o).getId() == p.getId()) {
                                        pi.get(o).incrementAm();
                                        inList = true;
                                    }
                                }
                                if (!inList) {
                                    p.incrementAm();
                                    pi.add(p);
                                }
                            }
                            break;

                        //switch case to organize products in products list from cheapest to most expensive
                        case 2:
                            System.out.println(bookstore.organizeProducts());
                            break;

                        //Switch case to create a new member
                        case 3:
                            //variable declaration
                            boolean c = true;
                            Membership mem = null;
                            String membership = null;
                            boolean paidFee = false;
                            String type = null;
                            int i = -1;
                            //While loop for user input on what type of membership they would like
                            while (c == true) {
                                System.out.println("Which type of membership would you like, Premium or Regular?");
                                membership = scan.next();
                                if (membership.equals("Premium") || membership.equals("premium")) {
                                    mem = new Membership("Premium", 50);
                                    c = false;
                                    type = "Premium";
                                } else if (membership.equals("Regular") || membership.equals("regular")) {
                                    mem = new Membership("Regular", 0);
                                    c = false;
                                    type = "Regular";
                                } else {
                                    System.out.println("Invalid membership type. Please try again.");
                                }
                            }
                            //New member questions 
                            System.out.println("What number would you like for your member ID?");
                            int memberID = scan.nextInt();

                            System.out.println("What is your age?");
                            int age = scan.nextInt();

                            System.out.println("What is your first name?");
                            String firstName = scan.next();

                            System.out.println("What is your last name?");
                            String lastName = scan.next();

                            System.out.println("How much money have you spent?");
                            double moneySpent = scan.nextDouble();

                            System.out.println("What will be you using for your payment method?");
                            String paymentMethod = scan.next();
                            //If statement to check if user would like to pay monthly fee now
                            if (membership.equals("Premium") || membership.equals("premium")) {
                                System.out.println("Would you like to pay the monthly fee of $50 now? ");
                                String yesOrNo = scan.next();
                                if (yesOrNo.equals("Yes") || yesOrNo.equals("yes")) {
                                    paidFee = true;
                                    moneySpent += 50;
                                } else {
                                    paidFee = false;
                                }
                            }
                            //Setting member information and displaying information back to them
                            Member member1 = new Member(memberID, age, type, firstName, lastName, mem, moneySpent, paidFee, paymentMethod);
                            members.add(member1);
                            i++;
                            members.get(i).display();
                            continuee = false;
                            total += moneySpent;
                            numMembersRegistered++;
                            break;
                        case 4:
                            //variable declaration
                            boolean mems = true;
                            Membership member = null;
                            String membership1 = null;
                            boolean paidFee1 = false;
                            int ii = 0;
                            //boolean paidFee = false;
                            String type1 = null;
                            //While loop for user input on what type of membership they would like
                            while (mems == true) {
                                System.out.println("Which type of membership would they like, Premium or Regular?");
                                membership1 = scan.next();
                                if (membership1.equals("Premium") || membership1.equals("premium")) {
                                    member = new Membership("Premium", 50);
                                    mems = false;
                                    type1 = "Premium";
                                } else if (membership1.equals("Regular") || membership1.equals("regular")) {
                                    member = new Membership("Regular", 0);
                                    mems = false;
                                    type1 = "Regular";
                                } else {
                                    System.out.println("Invalid membership type. Please try again.");
                                }
                            }
                            //New member questions 
                            System.out.println("What number would they like for their member ID?");
                            int memberID1 = scan.nextInt();

                            System.out.println("What is their age?");
                            int age1 = scan.nextInt();

                            System.out.println("What is their first name?");
                            String firstName1 = scan.next();

                            System.out.println("What is their last name?");
                            String lastName1 = scan.next();

                            System.out.println("How much money have they spent?");
                            double moneySpent1 = scan.nextDouble();

                            System.out.println("What will be they using for their payment method?");
                            String paymentMethod1 = scan.next();

                            //Setting member information and displaying information back to them
                            Member member2 = new Member(memberID1, age1, type1, firstName1, lastName1, member, moneySpent1, paidFee1, paymentMethod1);
                            members.add(member2);
                            ii++;
                            members.get(ii).display();
                            //continuee = false;
                            numMembersRegistered++;
                            break;

                        //Switch case to upgrade member from regular to premium, uses name input from first while loop                   
                        case 5:
                            //Statement to show you have chosen to upgrade
                            System.out.println("Thank you for choosing to upgrade to premium, you wont be dissapointed!");
                            //if statement to check if member is already signed up for premium
                            if (members.get(numArray).getType().equals("Premium") || members.get(numArray).getType().equals("premium")) {
                                System.out.println("Lucky you, you are already a premium member! No need to purchase membership.\n");
                                break;
                            } //else statement to make member premium if not already, and then relay new member information back to them
                            else {
                                members.get(numArray).setType("Premium");
                                total += 50;
                                members.get(numArray).setPaidFee(true);
                                members.get(numArray).setMoneySpent(total);
                                members.get(numArray).display();
                                break;
                            }

                        //Switch case to return money spent
                        case 6:
                            members.get(numArray).setMoneySpent(total);
                            System.out.println("You have spent: $" + members.get(numArray).getMoneySpent());
                            break;

                        //switch case to restock a product
                        case 7:
                            //scanner to take in user input for item and amount to restock
                            System.out.println("Please input the product id for the item you would like to restock.");
                            int pID = scan.nextInt();
                            System.out.println("Please input the amount of this item you are adding to the inventory");
                            int amou = scan.nextInt();
                            bookstore.restockProduct(amou, pID);
                            System.out.println("The product has been successfully restocked!");
                            break;
                        //switch case to return total store value
                        case 8:
                            System.out.println("The total cash value of all products is $" + bookstore.inventoryValue());
                            break;
                        //Switch case to allow user to quit loop and exit the program
                        case 9:
                            System.out.println("Would you like to quit? Type one for yes, or two for no");
                            int answer = scan.nextInt();
                            if (answer == 1) {
                                System.out.println("Thank you for shopping with us!");
                                continuee = false;
                                cont = true;
                            } else {
                                continuee = true;
                            }
                            break;

                    }

                }
            }
        } catch (InputMismatchException exc) {
            System.out.println("Inproper input, InputMismatchException found.");
        } catch (Exception exc) {
            System.out.println("General Exception found");
        }
        //code to create end of day report
        try {
            FileOutputStream fs;
            fs = new FileOutputStream("C:\\Users\\Cj Naylor\\Documents\\NetBeansProjects\\NaylorCJProject3\\EndOfDayReport.txt");
            PrintWriter outFS = new PrintWriter(fs);
            outFS.println("Number of members registered today: " + numMembersRegistered + "\n");
            outFS.println("---------------------------------------------------------------------");
            outFS.println("Products purchased today: \n");
            int totalDayAm = 0;
            //for loop to print out products purchased and calculate daily total
            for (int z = 0; z < pi.size(); z++) {
                outFS.println(pi.get(z).toString());
                outFS.println("----------------------------------------------");
                totalDayAm += (pi.get(z).getPrice() * pi.get(z).getAmBought());
            }
            //code to print am spent for the day
            outFS.println("---------------------------------------------------------------------");
            outFS.println("\nTotal amount spent today: $" + totalDayAm);
            outFS.close();
            fs.close();
        } catch (FileNotFoundException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("IOException");
        }
        //code to create csv file for new updated inventory
        try {
            FileOutputStream fs;
            fs = new FileOutputStream("C:\\Users\\Cj Naylor\\Documents\\NetBeansProjects\\NaylorCJProject3\\BookInventoryDay2.csv");
            PrintWriter outFS = new PrintWriter(fs);
            for (int y = 0; y < bookstore.products.size(); y++) {
                outFS.println(bookstore.products.get(y).csvToString());
            }
            outFS.close();
            fs.close();
        } catch (FileNotFoundException exc) {
            System.out.println("File not found");
        } catch (IOException exc) {
            System.out.println("IOException");
        }
    }

}
