

package Model;


public class RoleDBO {
private int id;
private String name;

    public RoleDBO() {
    }

    public RoleDBO(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "RoleDBO{" + "id=" + id + ", name=" + name + '}';
    }

}
