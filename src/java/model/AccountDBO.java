

package model;


import java.sql.Timestamp;


public class AccountDBO {
private int id;
private String usename;
private String password;
private String email;
 private Timestamp created_at;
 private int status;

    public AccountDBO() {
    }

    public AccountDBO(int id, String usename, String password, String email, Timestamp created_at, int status) {
        this.id = id;
        this.usename = usename;
        this.password = password;
        this.email = email;
        this.created_at = created_at;
        this.status = status;
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AccountDBO{" + "id=" + id + ", usename=" + usename + ", password=" + password + ", email=" + email + ", created_at=" + created_at + ", status=" + status + '}';
    }
 

}
