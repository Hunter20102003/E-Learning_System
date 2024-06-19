package Model;

import java.util.Date;


public class CourseDBO {

    private int id;
    private String name;
    private String title;
    private String description;
    private double price;
    private String img;
    private int created_by;
    private int teacher_id;
    private boolean is_locked;
    private Date created_at;
    private CourseTypeDBO course_type;
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Model/CourseDBO.java
    private boolean is_deleted;
=======
>>>>>>> origin/Authentication:src/java/model/CourseDBO.java
=======
>>>>>>> origin/front-end
    
   

    public CourseDBO() {
    }

<<<<<<< HEAD
<<<<<<< HEAD:src/java/Model/CourseDBO.java
    public CourseDBO(int id, String name, String title, String description, double price, String img, int created_by, int teacher_id, boolean is_locked, Date created_at, CourseTypeDBO course_type, boolean is_deleted) {
=======
    public CourseDBO(int id, String name, String title, String description, double price, String img, int created_by, int teacher_id, boolean is_locked, Date created_at, CourseTypeDBO course_type) {
>>>>>>> origin/Authentication:src/java/model/CourseDBO.java
=======
    public CourseDBO(int id, String name, String title, String description, double price, String img, int created_by, int teacher_id, boolean is_locked, Date created_at, CourseTypeDBO course_type) {
>>>>>>> origin/front-end
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.price = price;
        this.img = img;
        this.created_by = created_by;
        this.teacher_id = teacher_id;
        this.is_locked = is_locked;
        this.created_at = created_at;
        this.course_type = course_type;
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Model/CourseDBO.java
        this.is_deleted = is_deleted;
=======
>>>>>>> origin/Authentication:src/java/model/CourseDBO.java
=======
>>>>>>> origin/front-end
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public CourseTypeDBO getCourse_type() {
        return course_type;
    }

    public void setCourse_type(CourseTypeDBO course_type) {
        this.course_type = course_type;
    }

<<<<<<< HEAD
<<<<<<< HEAD:src/java/Model/CourseDBO.java
    public boolean isIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(boolean is_deleted) {
        this.is_deleted = is_deleted;
    }

    @Override
    public String toString() {
        return "CourseDBO{" + "id=" + id + ", name=" + name + ", title=" + title + ", description=" + description + ", price=" + price + ", img=" + img + ", created_by=" + created_by + ", teacher_id=" + teacher_id + ", is_locked=" + is_locked + ", created_at=" + created_at + ", course_type=" + course_type + ", is_deleted=" + is_deleted + '}';
    }

    
=======
=======
>>>>>>> origin/front-end
    @Override
    public String toString() {
        return "CourseDBO{" + "id=" + id + ", name=" + name + ", title=" + title + ", description=" + description + ", price=" + price + ", img=" + img + ", created_by=" + created_by + ", teacher_id=" + teacher_id + ", is_locked=" + is_locked + ", created_at=" + created_at + ", course_type=" + course_type + '}';
    }

   

<<<<<<< HEAD
>>>>>>> origin/Authentication:src/java/model/CourseDBO.java
=======
>>>>>>> origin/front-end
  

    
    
}
