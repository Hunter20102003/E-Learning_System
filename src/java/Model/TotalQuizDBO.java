package Model;

/**
 *
 * @author _aquyndz
 */

public class TotalQuizDBO {
    private int courseId;
    private int quizId;

    public TotalQuizDBO() {
    }

    public TotalQuizDBO(int courseId, int quizId) {
        this.courseId = courseId;
        this.quizId = quizId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    @Override
    public String toString() {
        return "TotalQuizDBO{" + "courseId=" + courseId + ", quizId=" + quizId + '}';
    }
    
    
}
