/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author buiqu
 */
public class AccountManagerExcelDBO {
    private String name;
    private String password;
    private String email;
    private String first_name;
    private String last_name;

    public AccountManagerExcelDBO() {
    }

    public AccountManagerExcelDBO(String name, String password, String email, String first_name, String last_name) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "AccountManagerExcelDBO{" + "name=" + name + ", password=" + password + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name + '}';
    }
    
    
}
