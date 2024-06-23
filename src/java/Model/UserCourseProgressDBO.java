package Model;

public class UserCourseProgressDBO {
    private int user_id;
    private int course_id;
    private String completion_date;
    private double progress;
    private CourseDBO courseDBO;

    public UserCourseProgressDBO() {
    }

    public UserCourseProgressDBO(int user_id, int course_id, String completion_date, double progress, CourseDBO courseDBO) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.completion_date = completion_date;
        this.progress = progress;
        this.courseDBO = courseDBO;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCompletion_date() {
        return completion_date;
    }

    public void setCompletion_date(String completion_date) {
        this.completion_date = completion_date;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }

    public CourseDBO getCourseDBO() {
        return courseDBO;
    }

    public void setCourseDBO(CourseDBO courseDBO) {
        this.courseDBO = courseDBO;
    }

    @Override
    public String toString() {
        return "UserCourseProgressDBO{" + "user_id=" + user_id + ", course_id=" + course_id + ", completion_date=" + completion_date + ", progress=" + progress + ", courseDBO=" + courseDBO + '}';
    }

    
    
    
}
