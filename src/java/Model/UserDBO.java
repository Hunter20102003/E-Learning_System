

package Model;

import java.util.Date;


public class UserDBO {
private int id;
private String username;
private String password;
private String email;   
private String firstName;
private String lastName;
private String avatar;
private Date created_at;
private int is_looked;
<<<<<<< HEAD
private int is_Deleted;
=======
>>>>>>> origin/front-end
private RoleDBO role;

    public UserDBO() {
    }

<<<<<<< HEAD
<<<<<<< HEAD:src/java/Model/UserDBO.java
    public UserDBO(int id, String username, String password, String email, String firstName, String lastName, String avatar, Date created_at, int is_looked,int is_Deleted, RoleDBO role) {
=======
    public UserDBO(int id, String username, String password, String email, String firstName, String lastName, String avatar, Date created_at, int is_looked, RoleDBO role) {
>>>>>>> origin/Authentication:src/java/model/UserDBO.java
=======
    public UserDBO(int id, String username, String password, String email, String firstName, String lastName, String avatar, Date created_at, int is_looked, RoleDBO role) {
>>>>>>> origin/front-end
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.avatar = avatar;
        this.created_at = created_at;
        this.is_looked = is_looked;
<<<<<<< HEAD
        this.is_Deleted = is_Deleted;
        this.role = role;
        
    }

    public UserDBO(int is_Deleted) {
        this.is_Deleted = is_Deleted;
=======
        this.role = role;
>>>>>>> origin/front-end
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public int getIs_looked() {
        return is_looked;
    }

    public void setIs_looked(int is_looked) {
        this.is_looked = is_looked;
    }

<<<<<<< HEAD
    public int getIs_Deleted() {
        return is_Deleted;
    }

    public void setIs_Deleted(int is_Deleted) {
        this.is_Deleted = is_Deleted;
    }
    

=======
>>>>>>> origin/front-end
    public RoleDBO getRole() {
        return role;
    }

    public void setRole(RoleDBO role) {
        this.role = role;
    }

    @Override
    public String toString() {
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Model/UserDBO.java
        return "UserDBO{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", avatar=" + avatar + ", created_at=" + created_at + ", is_looked=" + is_looked + ", is_Deleted=" + is_Deleted + ", role=" + role + '}';
    }


=======
        return "UserDBO{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", avatar=" + avatar + ", created_at=" + created_at + ", is_looked=" + is_looked + ", role=" + role + '}';
    }

>>>>>>> origin/Authentication:src/java/model/UserDBO.java
=======
        return "UserDBO{" + "id=" + id + ", username=" + username + ", password=" + password + ", email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", avatar=" + avatar + ", created_at=" + created_at + ", is_looked=" + is_looked + ", role=" + role + '}';
    }

>>>>>>> origin/front-end
   
    
        
}
