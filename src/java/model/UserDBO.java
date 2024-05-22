

package model;

import java.util.Date;


public class UserDBO {
private int id;
private String usename;
private String password;
private String email;   
private String firstName;
private String lastName;
private int gender;
private Date DOB;
private String address;
private String phone_number;
private String avatar;
private int is_looked;
private RoleDBO role;

    public UserDBO() {
    }

    public UserDBO(int id, String usename, String password, String email, String firstName, String lastName, int gender, Date DOB, String address, String phone_number, String avatar, int is_looked, RoleDBO role) {
        this.id = id;
        this.usename = usename;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.DOB = DOB;
        this.address = address;
        this.phone_number = phone_number;
        this.avatar = avatar;
        this.is_looked = is_looked;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getIs_looked() {
        return is_looked;
    }

    public void setIs_looked(int is_looked) {
        this.is_looked = is_looked;
    }

    public RoleDBO getRole() {
        return role;
    }

    public void setRole(RoleDBO role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserDBO{" + "id=" + id + ", usename=" + usename + ", password=" + password + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", DOB=" + DOB + ", address=" + address + ", phone_number=" + phone_number + ", avatar=" + avatar + ", is_looked=" + is_looked + ", role=" + role + '}';
    }

        
}
