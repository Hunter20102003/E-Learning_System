package Model;

/**
 *
 * @author _aquyndz
 */

public class QuestionTypeDBO {
    private int typeId;
    private String typeName;

    public QuestionTypeDBO() {
    }

    public QuestionTypeDBO(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "QuestionTypeDBO{" + "typeId=" + typeId + ", typeName=" + typeName + '}';
    }
    
    
}
