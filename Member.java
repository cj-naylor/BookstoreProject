/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NaylorCJProject1;

import bookstore.Membership.Membership;

/**
 *
 * @author Cj Naylor
 */
public class Member {

    //initializes variables
    private int memberID;
    private int age;
    private String firstName;
    private String lastName;
    private Membership membership;
    private double moneySpent;
    private boolean paidFee;
    private String paymentMethod;
    private String type;
           

    //constructor for member, including all of the needed information
    public Member(int memberID, int age, String type, String firstName, String lastName, Membership membership, double moneySpent, boolean paidFee, String paymentMethod) {
        this.memberID = memberID;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.membership = membership;
        this.moneySpent = moneySpent;
        this.paidFee = paidFee;
        this.paymentMethod = paymentMethod;
        this.type = type;
    }

    //all of the getters and setters for variables
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getMoneySpent() {
        return this.moneySpent;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isPaidFee() {
        return paidFee;
    }

    public void setMoneySpent(double moneySpent) {
        this.moneySpent = moneySpent;
    }

    public void addMoneySpent(double am) {
        this.moneySpent += am;
    }

    public void setPaidFee(boolean paidFee) {
        this.paidFee = paidFee;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public int getMemberID() {
        return memberID;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //display method for members
    public void display() {
        System.out.println("Membership type: " + this.type);
        System.out.println("Name: " + this.firstName + " " + this.lastName);
        System.out.println("MemberID: " + this.memberID + "     Age: " + this.age + "     Paid fee: " + this.paidFee);
        System.out.println("Money spent: $" + this.moneySpent + "     Payment method: " + this.paymentMethod);

    }

    //method to purchase membership
    public void purchaseMembership(String type) {
        if (type.equals("regular")) {
            Membership membership = new Membership("Regular", 0);
        } else if (type.equals("premium")) {
            Membership membership = new Membership("Premium", 100);
        }
    }

}
