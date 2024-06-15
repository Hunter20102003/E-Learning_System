/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author buiqu
 */
public class Enrollment {
    
    private String User_ID;
    private String Course_ID;
    private String Date;

    public Enrollment() {
    }

    public Enrollment(String User_ID, String Course_ID, String Date) {
        this.User_ID = User_ID;
        this.Course_ID = Course_ID;
        this.Date = Date;
    }

    public String getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(String User_ID) {
        this.User_ID = User_ID;
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public void setCourse_ID(String Course_ID) {
        this.Course_ID = Course_ID;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Enrollment{" + "User_ID=" + User_ID + ", Course_ID=" + Course_ID + ", Date=" + Date + '}';
    }
    
}
