/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author buiqu
 */
public class IncomeManagerDBO {

    private String user_id;
    private String name;
    private String mail;
    private List<Double> sparklineData;
    private String total;

    public IncomeManagerDBO() {
    }

    public IncomeManagerDBO(String user_id, String name, String mail, List<Double> sparklineData, String total) {
        this.user_id = user_id;
        this.name = name;
        this.mail = mail;
        this.sparklineData = sparklineData;
        this.total = total;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Double> getSparklineData() {
        return sparklineData;
    }

    public void setSparklineData(List<Double> sparklineData) {
        this.sparklineData = sparklineData;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "IncomeManagerDBO{" + "user_id=" + user_id + ", name=" + name + ", mail=" + mail + ", sparklineData=" + sparklineData + ", total=" + total + '}';
    }

    

  
}
