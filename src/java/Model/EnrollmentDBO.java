

package Model;

import java.util.Date;


public class EnrollmentDBO {
    private int user_id;
    private int course_id;
    private Date enrollment_date;

    public EnrollmentDBO() {
    }

    public EnrollmentDBO(int user_id, int course_id, Date enrollment_date) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.enrollment_date = enrollment_date;
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

    public Date getEnrollment_date() {
        return enrollment_date;
    }

    public void setEnrollment_date(Date enrollment_date) {
        this.enrollment_date = enrollment_date;
    }

    @Override
    public String toString() {
        return "EnrollmentDBO{" + "user_id=" + user_id + ", course_id=" + course_id + ", enrollment_date=" + enrollment_date + '}';
    }
    

}
