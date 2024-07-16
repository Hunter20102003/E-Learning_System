package Model;

public class WishlistItem {
    private int courseId;
    private int userId;

    public WishlistItem() {
    }

    public WishlistItem(int courseId, int userId) {
        this.courseId = courseId;
        this.userId = userId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
