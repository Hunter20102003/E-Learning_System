
package Model;

import java.util.ArrayList;


public class LessonDBO {
private int id;
private String title;
private int course_id;
private boolean is_locked;
private ArrayList<SubLessonDBO> sub_lesson_list;
<<<<<<< HEAD
=======
private ArrayList<QuizDBO>      quiz_lesson_list;
>>>>>>> origin/profile

    public LessonDBO(int id, String title, int course_id, boolean is_locked, ArrayList<SubLessonDBO> sub_lesson_list) {
        this.id = id;
        this.title = title;
        this.course_id = course_id;
        this.is_locked = is_locked;
        this.sub_lesson_list = sub_lesson_list;
    }

<<<<<<< HEAD
=======
    public LessonDBO(int id, String title, int course_id, boolean is_locked, ArrayList<SubLessonDBO> sub_lesson_list, ArrayList<QuizDBO> quiz_lesson_list) {
        this.id = id;
        this.title = title;
        this.course_id = course_id;
        this.is_locked = is_locked;
        this.sub_lesson_list = sub_lesson_list;
        this.quiz_lesson_list = quiz_lesson_list;
    }

  
>>>>>>> origin/profile
    public LessonDBO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public boolean isIs_locked() {
        return is_locked;
    }

    public void setIs_locked(boolean is_locked) {
        this.is_locked = is_locked;
    }

    public ArrayList<SubLessonDBO> getSub_lesson_list() {
        return sub_lesson_list;
    }

    public void setSub_lesson_list(ArrayList<SubLessonDBO> sub_lesson_list) {
        this.sub_lesson_list = sub_lesson_list;
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return "LessonDBO{" + "id=" + id + ", title=" + title + ", course_id=" + course_id + ", is_locked=" + is_locked + ", sub_lesson_list=" + sub_lesson_list + '}';
    }

=======
    public ArrayList<QuizDBO> getQuiz_lesson_list() {
        return quiz_lesson_list;
    }

    public void setQuiz_lesson_list(ArrayList<QuizDBO> quiz_lesson_list) {
        this.quiz_lesson_list = quiz_lesson_list;
    }

    @Override
    public String toString() {
        return "LessonDBO{" + "id=" + id + ", title=" + title + ", course_id=" + course_id + ", is_locked=" + is_locked + ", sub_lesson_list=" + sub_lesson_list + ", quiz_lesson_list=" + quiz_lesson_list + '}';
    }
    
>>>>>>> origin/profile

}
