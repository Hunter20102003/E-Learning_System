/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import com.google.api.client.util.DateTime;
import java.util.Date;

/**
 *
 * @author quyendz03
 */
public class UserCourseProgressDBO {

    private int user_id;
    private int course_id;
    private Date complete_date;
    private int progress;
    private CourseDBO courseDBO;

    public UserCourseProgressDBO(int user_id, int course_id, Date complete_date) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.complete_date = complete_date;
    }

    public UserCourseProgressDBO(int user_id, int course_id, Date complete_date, int progress) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.complete_date = complete_date;
        this.progress = progress;
    }
      public UserCourseProgressDBO(int user_id, int course_id, Date completion_date, int progress, CourseDBO courseDBO) {
        this.user_id = user_id;
        this.course_id = course_id;
        this.complete_date=completion_date;
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

    public Date getComplete_date() {
        return complete_date;
    }

    public void setComplete_date(Date complete_date) {
        this.complete_date = complete_date;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    @Override
    public String toString() {
        return "UserCourseProgressDBO{" + "user_id=" + user_id + ", course_id=" + course_id + ", complete_date=" + complete_date + ", progress=" + progress + '}';
    }

}
