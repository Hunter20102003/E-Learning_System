/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author buiqu
 */
public class Payment {
    private int id;
    private int user_id;
    private int course_id;
    private double amount;
    private String date;
    private String transaction_ID;
   
    

    public Payment() {
    }

    public Payment(int id, int user_id, int course_id, double amount, String date, String transaction_ID) {
        this.id = id;
        this.user_id = user_id;
        this.course_id = course_id;
        this.amount = amount;
        this.date = date;
        this.transaction_ID = transaction_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransaction_ID() {
        return transaction_ID;
    }

    public void setTransaction_ID(String transaction_ID) {
        this.transaction_ID = transaction_ID;
    }

    @Override
    public String toString() {
        return "Payment{" + "id=" + id + ", user_id=" + user_id + ", course_id=" + course_id + ", amount=" + amount + ", date=" + date + ", transaction_ID=" + transaction_ID + '}';
    }

   
    
}
