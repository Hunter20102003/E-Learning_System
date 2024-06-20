package Model;

public class CourseType2DBO {
    private int id;
    private String name;
    private String description;
    private String img;

    public CourseType2DBO() {
    }

    public CourseType2DBO(int id, String name, String description, String img) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "CourseType2DBO{" + "id=" + id + ", name=" + name + ", description=" + description + ", img=" + img + '}';
    }
    
    
    
}
