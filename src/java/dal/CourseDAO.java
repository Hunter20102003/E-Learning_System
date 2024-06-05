package Dal;

import Model.CourseDBO;
import Model.CourseTypeDBO;
import Model.LessonDBO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.UserDBO;
import Model.RoleDBO;
import Model.SubLessonDBO;
import java.util.List;

public class CourseDAO extends DBContext {

    public List<CourseDBO> getAllCourse() {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id";
        List<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(11), r.getString(12));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), type);
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public CourseDBO getCourseByID(String id) {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id where course_id=?";
        CourseDBO course = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(11), r.getString(12));
                course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), type);

            }
        } catch (SQLException e) {

        }
        return course;
    }

    public ArrayList<SubLessonDBO> getListSubLessonByLessonID(int id) {
        String sql = "select * from lesson as l "
                + "join SubLesson as sl on l.lesson_id=sl.lesson_id "
                + "where l.lesson_id=?";
        ArrayList<SubLessonDBO> listSubLesson = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                listSubLesson.add(new SubLessonDBO(r.getInt(5), r.getString(6), r.getString(7), r.getString(8), r.getDate(10), r.getString(11), r.getBoolean(12)));

            }

        } catch (SQLException e) {

        }
        return listSubLesson;
    }

    public SubLessonDBO getSubLessonByID(int id) {
        String sql = "select * from sublesson where sub_lesson_id =?";
        SubLessonDBO subLesson = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                subLesson = new SubLessonDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getDate(6), r.getString(7), r.getBoolean(8));
            
        

            }

        } catch (SQLException e) {

        }
        return subLesson;
    }

    public ArrayList<LessonDBO> getListLessonByCourseID(String id) {
        String sql = "select * from lesson as l "
                + "join course as c on c.course_id=l.course_id "
                + "where c.course_id=?";
        ArrayList<LessonDBO> listLesson = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<SubLessonDBO> listSubLesson = getListSubLessonByLessonID(r.getInt(1));
                listLesson.add(new LessonDBO(r.getInt(1), r.getString(2), r.getInt(3), r.getBoolean(4), listSubLesson));

            }

        } catch (SQLException e) {

        }
        return listLesson;
    }

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        System.out.println(dao.getListLessonByCourseID("1"));
    }
}
