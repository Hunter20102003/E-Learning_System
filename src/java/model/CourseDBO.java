package Model;

import java.math.BigDecimal;

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
    private CourseTypeDBO course_type;
   

    public CourseDBO() {
    }

    public CourseDBO(int id, String name, String title, String description, double price, String img, int created_by, int teacher_id, boolean is_locked, CourseTypeDBO course_type) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.description = description;
        this.price = price;
        this.img = img;
        this.created_by = created_by;
        this.teacher_id = teacher_id;
        this.is_locked = is_locked;
        this.course_type = course_type;
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

    public CourseTypeDBO getCourse_type() {
        return course_type;
    }

    public void setCourse_type(CourseTypeDBO course_type) {
        this.course_type = course_type;
    }

    @Override
    public String toString() {
        return "CourseDBO{" + "id=" + id + ", name=" + name + ", title=" + title + ", description=" + description + ", price=" + price + ", img=" + img + ", created_by=" + created_by + ", teacher_id=" + teacher_id + ", is_locked=" + is_locked + ", course_type=" + course_type + '}';
    }

  

    
    
}
