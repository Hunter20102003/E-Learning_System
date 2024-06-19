package Dal;

import Model.CourseDBO;
<<<<<<< HEAD
=======
import Model.CourseType2DBO;
>>>>>>> origin/front-end
import Model.CourseTypeDBO;
import Model.EnrollmentDBO;
import Model.LessonDBO;
import Model.ReviewDBO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.UserDBO;
import Model.RoleDBO;
import Model.SubLessonDBO;
import java.util.List;

public class CourseDAO extends DBContext {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
    public List<CourseDBO> getAllCourses() {
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, "
                + "c.course_img, c.created_by, c.teacher_id, c.is_locked, c.created_at, "
                + "ct.course_type_id, ct.course_type_name "
                + "FROM course AS c "
                + "JOIN coursetype AS ct ON ct.course_type_id = c.course_type_id "
                + "WHERE c.is_deleted = 0"; // chỉ lấy các khóa học chưa bị xóa
=======
 public List<CourseDBO> getAllCourses() {
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, "
                   + "c.course_img, c.created_by, c.teacher_id, c.is_locked, c.created_at, "
                   + "ct.course_type_id, ct.course_type_name "
                   + "FROM course AS c "
                   + "JOIN coursetype AS ct ON ct.course_type_id = c.course_type_id "
                   + "WHERE c.is_deleted = 0"; // chỉ lấy các khóa học chưa bị xóa
>>>>>>> origin/create-course1

        List<CourseDBO> courses = new ArrayList<>();

        try (PreparedStatement p = connection.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getDouble("price"),
                        r.getString("course_img"),
                        r.getInt("created_by"),
                        r.getInt("teacher_id"),
                        r.getBoolean("is_locked"),
                        r.getDate("created_at"),
                        type,
<<<<<<< HEAD
                        r.getBoolean("is_deleted")
=======
                        false// Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
>>>>>>> origin/create-course1
                );
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }


    public List<CourseDBO> getCourseByCourseType(String typeCourse) {
        String sql = "select * from course as c "
                + "join coursetype as ct on ct.course_type_id=c.course_type_id "
                + "where c.course_type_id=?";
        ArrayList<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, typeCourse);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getDouble("price"),
                        r.getString("course_img"),
                        r.getInt("created_by"),
                        r.getInt("teacher_id"),
                        r.getBoolean("is_locked"),
                        r.getDate("created_at"),
                        type,
<<<<<<< HEAD
                        r.getBoolean("is_deleted")
                );
=======
=======
>>>>>>> origin/front-end
    public List<CourseDBO> getAllCourse() {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id";
        List<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
<<<<<<< HEAD
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
>>>>>>> origin/front-end
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
    public ArrayList<CourseDBO> getCourseByMentorId(int idMentor) {
        String sql = "select * from course as c "
                + "join coursetype as ct on ct.course_type_id=c.course_type_id "
                + "where teacher_id=?";
        ArrayList<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idMentor);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getDouble("price"),
                        r.getString("course_img"),
                        r.getInt("created_by"),
                        r.getInt("teacher_id"),
                        r.getBoolean("is_locked"),
                        r.getDate("created_at"),
                        type,
                        r.getBoolean("is_deleted")
                );
=======
=======
>>>>>>> origin/front-end
    public List<CourseDBO> getCourseByCourseType(String typeCourse) {
        String sql = "select * from course as c "
                + "join coursetype as ct on ct.course_type_id=c.course_type_id "
                + "where c.course_type_id=?";
<<<<<<< HEAD
        List<CourseDBO> list = new ArrayList<>();
=======
        ArrayList<CourseDBO> list = new ArrayList<>();
>>>>>>> origin/front-end
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, typeCourse);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
<<<<<<< HEAD
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
>>>>>>> origin/front-end
=======
                        false // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
                );
>>>>>>> origin/create-course1
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public List<CourseTypeDBO> getAllCourseType() {
        String sql = "select * from coursetype ";
        List<CourseTypeDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(1), r.getString(2));
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(1), r.getString(2));
                list.add(type);
            }
        } catch (SQLException e) {

        }
        return list;
    }
    
    public List<CourseType2DBO> getAllCourseType2() {
        String sql = "select * from coursetype ";
        List<CourseType2DBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseType2DBO type = new CourseType2DBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4));
>>>>>>> origin/front-end
                list.add(type);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public List<CourseDBO> searchCourse(String search) {
        String sql = "select * from course as c "
                + "join coursetype as ct on ct.course_type_id=c.course_type_id "
                + "where c.name like ?";
        List<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, "%" + search + "%");
            ResultSet r = p.executeQuery();
            while (r.next()) {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
=======
>>>>>>> origin/create-course1
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getDouble("price"),
                        r.getString("course_img"),
                        r.getInt("created_by"),
                        r.getInt("teacher_id"),
                        r.getBoolean("is_locked"),
                        r.getDate("created_at"),
                        type,
<<<<<<< HEAD
                        r.getBoolean("is_deleted") // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
                );
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
>>>>>>> origin/front-end
=======
                        false // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
                );
>>>>>>> origin/create-course1
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
    public CourseDBO getCourseByID(int id) {
        String sql = "SELECT \n"
                + "    c.course_id, \n"
                + "    c.name, \n"
                + "    c.title, \n"
                + "    c.description, \n"
                + "    c.price, \n"
                + "    c.course_img, \n"
                + "    c.created_by, \n"
                + "    c.teacher_id, \n"
                + "    c.is_locked, \n"
                + "    c.created_at, \n"
                + "    c.is_deleted,\n"
                + "    ct.course_type_id, \n"
                + "    ct.course_type_name \n"
                + "FROM \n"
                + "    course AS c \n"
                + "JOIN \n"
                + "    coursetype AS ct \n"
                + "ON \n"
                + "    ct.course_type_id = c.course_type_id \n"
                + "WHERE \n"
                + "    c.course_id = ? \n"
                + "    AND c.is_deleted = 0;"; // chỉ lấy khóa học chưa bị xóa

        CourseDBO course = null;

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, id);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                    course = new CourseDBO(
                            r.getInt("course_id"),
                            r.getString("name"),
                            r.getString("title"),
                            r.getString("description"),
                            r.getDouble("price"),
                            r.getString("course_img"),
                            r.getInt("created_by"),
                            r.getInt("teacher_id"),
                            r.getBoolean("is_locked"),
                            r.getDate("created_at"),
                            type,
                            r.getBoolean("is_deleted") // Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }

    public CourseDBO getCourseByLessonID(String id) {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id JOIN Lesson as l on l.course_id =c.course_id where l.lesson_id=?";
=======
    public CourseDBO getCourseByID(String id) {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id where course_id=?";
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
    public CourseDBO getCourseByID(String id) {
        String sql = "select * from course as c join coursetype "
                + "as ct on ct.course_type_id=c.course_type_id where course_id=?";
>>>>>>> origin/front-end
        CourseDBO course = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getDouble("price"),
                        r.getString("course_img"),
                        r.getInt("created_by"),
                        r.getInt("teacher_id"),
                        r.getBoolean("is_locked"),
                        r.getDate("created_at"),
                        type,
                        r.getBoolean("is_deleted") // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
                );
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
>>>>>>> origin/front-end
=======
    public CourseDBO getCourseByID(int id) {
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, "
                   + "c.course_img, c.created_by, c.teacher_id, c.is_locked, c.created_at, "
                   + "ct.course_type_id, ct.course_type_name "
                   + "FROM course AS c "
                   + "JOIN coursetype AS ct ON ct.course_type_id = c.course_type_id "
                   + "WHERE c.course_id = ? AND c.is_deleted = 0"; // chỉ lấy khóa học chưa bị xóa
>>>>>>> origin/create-course1

        CourseDBO course = null;

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, id);
            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                    course = new CourseDBO(
                            r.getInt("course_id"),
                            r.getString("name"),
                            r.getString("title"),
                            r.getString("description"),
                            r.getDouble("price"),
                            r.getString("course_img"),
                            r.getInt("created_by"),
                            r.getInt("teacher_id"),
                            r.getBoolean("is_locked"),
                            r.getDate("created_at"),
                            type,
                            false // Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return course;
    }
    // Trong lớp CourseDAO
public CourseDBO getCourseByID(String courseID) {
    CourseDBO course = null;
    String query = "SELECT * FROM Course WHERE course_id = ?";
    try (PreparedStatement p = connection.prepareStatement(query)) {
        p.setString(1, courseID);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            course = new CourseDBO(
                    r.getInt("course_id"),
                    r.getString("name"),
                    r.getString("title"),
                    r.getString("description"),
                    r.getDouble("price"),
                    r.getString("course_img"),
                    r.getInt("created_by"),
                    r.getInt("teacher_id"),
                    r.getBoolean("is_locked"),
                    r.getDate("created_at"),
                    null, // course_type (you might want to fetch this as well)
                    false
            );
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log the exception or handle it accordingly
    }
    return course;
}


    public ArrayList<SubLessonDBO> getListSubLessonByLessonID(int id) {
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
        String sql = "select"
                + " l.lesson_id,"
                + "l.title,"
                + "l.is_locked,"
                + "sl.sub_lesson_id ,"
                + "sl.title as slTitle,"
                + "sl.content,"
                + "sl.description,"
                + "sl.lesson_id,"
                + "sl.creation_date,"
                + "sl.video_link,"
                + "sl.is_locked as slIsLocked,"
                + "sl.video_duration "
                + "from lesson as l "
                + "join SubLesson as sl "
                + "on l.lesson_id=sl.lesson_id "
=======
        String sql = "select * from lesson as l "
                + "join SubLesson as sl on l.lesson_id=sl.lesson_id "
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
        String sql = "select * from lesson as l "
                + "join SubLesson as sl on l.lesson_id=sl.lesson_id "
>>>>>>> origin/front-end
                + "where l.lesson_id=?";
        ArrayList<SubLessonDBO> listSubLesson = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
                listSubLesson.add(
                        new SubLessonDBO(
                                r.getInt("sub_lesson_id"),
                                r.getString("slTitle"),
                                r.getString("content"),
                                r.getString("description"),
                                r.getDate("creation_date"),
                                r.getString("video_link"),
                                r.getBoolean("slIsLocked"),
                                r.getLong("video_duration")));
=======
                listSubLesson.add(new SubLessonDBO(r.getInt(5), r.getString(6), r.getString(7), r.getString(8), r.getDate(10), r.getString(11), r.getBoolean(12)));
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                listSubLesson.add(new SubLessonDBO(r.getInt(5), r.getString(6), r.getString(7), r.getString(8), r.getDate(10), r.getString(11), r.getBoolean(12), r.getLong(
                        13)));
>>>>>>> origin/front-end

            }

        } catch (SQLException e) {
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
            e.printStackTrace();
=======

>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======

>>>>>>> origin/front-end
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
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
                subLesson = new SubLessonDBO(r.getInt("sub_lesson_id"), r.getString("title"), r.getString("content"), r.getString("description"), r.getDate("creation_date"), r.getString("video_link"), r.getBoolean("is_locked"), r.getLong("video_duration"));
=======
                subLesson = new SubLessonDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getDate(6), r.getString(7), r.getBoolean(8));
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                subLesson = new SubLessonDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getDate(6), r.getString(7), r.getBoolean(8), r.getLong(9));
>>>>>>> origin/front-end

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
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
                ArrayList<SubLessonDBO> listSubLesson = getListSubLessonByLessonID(r.getInt("lesson_id"));
                listLesson.add(new LessonDBO(r.getInt("lesson_id"), r.getString("title"), r.getInt("course_id"), r.getBoolean("is_locked"), listSubLesson));
=======
                ArrayList<SubLessonDBO> listSubLesson = getListSubLessonByLessonID(r.getInt(1));
                listLesson.add(new LessonDBO(r.getInt(1), r.getString(2), r.getInt(3), r.getBoolean(4), listSubLesson));
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                ArrayList<SubLessonDBO> listSubLesson = getListSubLessonByLessonID(r.getInt(1));
                listLesson.add(new LessonDBO(r.getInt(1), r.getString(2), r.getInt(3), r.getBoolean(4), listSubLesson));
>>>>>>> origin/front-end

            }

        } catch (SQLException e) {

        }
        return listLesson;
    }

<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
    public LessonDBO getLessonByID(String id) {
        String sql = "select * from lesson as l "
                + "join course as c on c.course_id=l.course_id "
                + "where lesson_id=?";
        LessonDBO Lesson = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<SubLessonDBO> listSubLesson = getListSubLessonByLessonID(r.getInt("lesson_id"));
                Lesson = new LessonDBO(r.getInt("lesson_id"), r.getString("title"), r.getInt("course_id"), r.getBoolean("is_locked"), listSubLesson);

            }

        } catch (SQLException e) {

        }
        return Lesson;
    }

    public List<CourseDBO> searchAndFilterData(String search, String[] typeOfCourse, String[] prices, String[] durations, String rating, String sort) {
        List<CourseDBO> datas = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select c.course_id,c.name,c.title,c.description,c.course_type_id,c.price,c.course_img,\n"
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,c.is_deleted,ct.course_type_id,ct.course_type_name\n"
                + "from course as c \n"
                + "left JOIN CourseDuration as cd on cd.course_id =c.course_id\n"
=======
    public List<CourseDBO> searchAndFilterData(String search, String[] typeOfCourse, String[] prices,String rating, String sort) {
        List<CourseDBO> datas = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select c.course_id,c.name,c.title,c.description,c.course_type_id,c.price,c.course_img,\n"
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,ct.course_type_id,ct.course_type_name\n"
                + "from course as c \n"
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
    public List<CourseDBO> searchAndFilterData(String search, String[] typeOfCourse, String[] prices, String[] durations, String rating, String sort) {
        List<CourseDBO> datas = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select c.course_id,c.name,c.title,c.description,c.course_type_id,c.price,c.course_img,\n"
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,ct.course_type_id,ct.course_type_name\n"
                + "from course as c \n"
                + "left JOIN CourseDuration as cd on cd.course_id =c.course_id\n"
>>>>>>> origin/front-end
                + "join coursetype as ct on ct.course_type_id=c.course_type_id\n"
                + "left join Review as r on r.course_id=c.course_id\n"
                + "where 1=1 ");
        if (search != null && !search.isBlank()) {
            sql.append(" and c.name like ? ");
        }
        if (typeOfCourse != null && typeOfCourse.length > 0) {
            sql.append(" and ( ");
            for (int i = 0; i < typeOfCourse.length; i++) {
                if (i > 0) {
                    sql.append(" or ");
                }
                sql.append("c.course_type_id = ?");

            }
            sql.append(" ) ");

        }
        if (prices != null && prices.length > 0) {
            sql.append(" and (");
            for (int i = 0; i < prices.length; i++) {
                if (i > 0) {
                    sql.append(" or ");
                }
                if (prices[i].equalsIgnoreCase("free")) {
                    sql.append("c.price is null");
                } else {
                    sql.append("c.price is not null");
                }
            }
            sql.append(" ) ");
        }
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
=======
>>>>>>> origin/front-end
        if (durations != null && durations.length > 0) {
            sql.append(" and (");
            for (int i = 0; i < durations.length; i++) {
                if (i > 0) {
                    sql.append(" or ");
                }
                switch (durations[i]) {
                    case "1":
                        sql.append(" cd.course_id between 0 and 3600");

                        break;
                    case "2":
<<<<<<< HEAD

                        sql.append(" cd.course_id between 3601 and 10800");
=======
                        
                        sql.append(" cd.course_id between 3601 and 10800" );
>>>>>>> origin/front-end
                        break;
                    case "3":
                        sql.append(" cd.course_id between 10801 and 21600");
                        break;
                    case "4":
                        sql.append(" cd.course_id between 21601 and 61200");
                        break;
                    default:
                        sql.append(" cd.course_id > 61200");
                }

            }
            sql.append(" ) ");
        }

        sql.append(" group by c.course_id,c.name,c.title,c.description,c.course_type_id,c.price,c.course_img,\n"
<<<<<<< HEAD
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,c.is_deleted,ct.course_type_id,ct.course_type_name ");

        if (rating != null && !rating.isBlank()) {
=======
        
        sql.append(" group by c.course_id,c.name,c.title,c.description,c.course_type_id,c.price,c.course_img,\n"
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,ct.course_type_id,ct.course_type_name ");
        
        if (rating!=null && !rating.isBlank()){
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,ct.course_type_id,ct.course_type_name ");

        if (rating != null && !rating.isBlank()) {
>>>>>>> origin/front-end
            sql.append(" having Round(AVG(rating*1.0),1) >=? ");
        }
        if (!sort.equalsIgnoreCase("mostRelevant")) {
            sql.append(" order by ");
            switch (sort) {
                case "newest" ->
                    sql.append(" created_at desc ");
                case "highestRate" ->
                    sql.append(" Round(AVG(rating*1.0),1) desc ");
                case "highestPrice" ->
                    sql.append(" price desc ");

                default ->
                    sql.append(" price asc ");
            }
        }
        try {
            int count = 1;
            PreparedStatement p = connection.prepareStatement(sql.toString());
            if (search != null && !search.isBlank()) {
                p.setString(count++, '%' + search + '%');

            }
            if (typeOfCourse != null && typeOfCourse.length > 0) {

                for (String s : typeOfCourse) {
                    p.setString(count++, s);
                }
            }
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
            if (rating != null && !rating.isBlank()) {
=======
            if (rating!=null && !rating.isBlank()){
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
            if (rating != null && !rating.isBlank()) {
>>>>>>> origin/front-end
                p.setString(count, rating);
            }
            ResultSet r = p.executeQuery();
            while (r.next()) {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        r.getString("title"),
                        r.getString("description"),
                        r.getDouble("price"),
                        r.getString("course_img"),
                        r.getInt("created_by"),
                        r.getInt("teacher_id"),
                        r.getBoolean("is_locked"),
                        r.getDate("created_at"),
                        type,
                        r.getBoolean("is_deleted"));
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
>>>>>>> origin/front-end
=======
                                    CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO    course = new CourseDBO(
                            r.getInt("course_id"),
                            r.getString("name"),
                            r.getString("title"),
                            r.getString("description"),
                            r.getDouble("price"),
                            r.getString("course_img"),
                            r.getInt("created_by"),
                            r.getInt("teacher_id"),
                            r.getBoolean("is_locked"),
                            r.getDate("created_at"),
                            type,
                            false // Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                    );
>>>>>>> origin/create-course1
                datas.add(course);
            }

            r.close();
            p.close();

        } catch (SQLException e) {
            System.out.println("Error");
        }

        return datas;

    }

    public List<ReviewDBO> getAllReview() {
        ArrayList<ReviewDBO> list = new ArrayList<>();
        String sql = "select * from review";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ReviewDBO review = new ReviewDBO();
                review.setUser_id(r.getInt(1));
                review.setCourse_id(r.getInt(2));
                review.setRating(r.getDouble(3));
                review.setReview_text(r.getString(4));
                review.setReview_date(r.getDate(5));
                list.add(review);

            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return list;
    }

    public List<ReviewDBO> getAllReviewByCourseID(int id) {
        ArrayList<ReviewDBO> list = new ArrayList<>();
        String sql = "select * from review where course_id =?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ReviewDBO review = new ReviewDBO();
                review.setUser_id(r.getInt(1));
                review.setCourse_id(r.getInt(2));
                review.setRating(r.getDouble(3));
                review.setReview_text(r.getString(4));
                review.setReview_date(r.getDate(5));
                list.add(review);

            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return list;
    }

    public List<EnrollmentDBO> getAllEnrollment() {
        ArrayList<EnrollmentDBO> list = new ArrayList<>();
        String sql = "select * from enrollment";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                EnrollmentDBO enroll = new EnrollmentDBO();
                enroll.setUser_id(r.getInt(1));
                enroll.setCourse_id(r.getInt(2));
                enroll.setEnrollment_date(r.getDate(3));
                list.add(enroll);

            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return list;
    }

<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
    public boolean userEnrolledCheck(int idUser, int idCourse) {
        String sql = "select * from Enrollment where user_id=? and course_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idUser);
            p.setInt(2, idCourse);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    public int enrollCourse(int idUser, int idCourse) {
        int cnt = 0;
        String sql = "INSERT INTO Enrollment (user_id, course_id) VALUES (?,?)";

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, idUser);
            p.setInt(2, idCourse);
            cnt = p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // or use a logging framework to log the exception
        }

        return cnt;
    }

=======
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
>>>>>>> origin/front-end
    public List<EnrollmentDBO> getAllEnrollmentByCourseID(int id) {
        ArrayList<EnrollmentDBO> list = new ArrayList<>();
        String sql = "select * from enrollment where course_id =?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                EnrollmentDBO enroll = new EnrollmentDBO();
                enroll.setUser_id(r.getInt(1));
                enroll.setCourse_id(r.getInt(2));
                enroll.setEnrollment_date(r.getDate(3));
                list.add(enroll);

            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return list;
    }

<<<<<<< HEAD
<<<<<<< HEAD:src/java/Dal/CourseDAO.java
=======
>>>>>>> origin/front-end
    public long getDurationOfCourse(int idCourse) {
        long duration = 0;

        String sql = "select course_id,sum(video_duration) as sum_video_duration from Lesson as l \n"
                + " join SubLesson as sl on l.lesson_id=sl.lesson_id\n"
                + " where course_id=? \n"
                + " group by l.course_id";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, idCourse);
            ResultSet r = p.executeQuery();
            if (r.next()) {
                duration = r.getLong(2);

            }
        } catch (SQLException e) {
            e.getErrorCode();
        }
        return duration;
    }
<<<<<<< HEAD

    public int addLesson(String title, int idCourse, int is_locked) {
        int cnt = 0;
        String sql = "insert into Lesson (title,course_id,is_locked)\n"
                + "  values (?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, title);
            p.setInt(2, idCourse);
            p.setInt(3, is_locked);
            cnt = p.executeUpdate();
        } catch (SQLException e) {

        }
        return cnt;
    }

    public int editLesson(int lessonId, String title, int is_locked) {
        int cnt = 0;
        String sql = "update Lesson "
                + "set title=?,is_locked=?\n"
                + "  where lesson_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, title);
            p.setInt(2, is_locked);
            p.setInt(3, lessonId);
            cnt = p.executeUpdate();
        } catch (SQLException e) {

        }
        return cnt;
    }

    public int removeLesson(int lessonId) {
        int cnt = 0;
        String sql = "delete from Lesson "
                + "  where lesson_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, lessonId);
            cnt = p.executeUpdate();
        } catch (SQLException e) {

        }
        return cnt;
    }

    public int addSubLesson(String title, String content, String description, int lesson_id, String video_link, long video_duration) {
        int cnt = 0;
        String sql = "insert into SubLesson (title,content,description,lesson_id,video_link,video_duration)\n"
                + "  values(?,?,?,?,?,?)";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, title);
            p.setString(2, content);
            p.setString(3, description);
            p.setInt(4, lesson_id);
            p.setString(5, video_link);
            p.setLong(6, video_duration);

            cnt = p.executeUpdate();
        } catch (SQLException e) {

        }
        return cnt;
    }

    public int editSubLesson(String title, String content, String description, String video_link, long video_duration, int sub_lesson_id) {
        int cnt = 0;
        String sql = "UPDATE SubLesson "
                + "SET title=?, content=?, description=?, video_link=?, video_duration=? "
                + "WHERE sub_lesson_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, title);
            p.setString(2, content);
            p.setString(3, description);
            p.setString(4, video_link);
            p.setLong(5, video_duration);
            p.setInt(6, sub_lesson_id);

            cnt = p.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return cnt;
    }

    public int removeSubLesson(int subLessonId) {
        int cnt = 0;
        String sql = "delete from SubLesson "
                + "  where sub_lesson_id=?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, subLessonId);
            cnt = p.executeUpdate();
        } catch (SQLException e) {

        }
        return cnt;
    }

    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        //     System.out.println(dao.addLesson("haylam", 1, 0));
        // System.out.println(dao.editLesson(3, "k hay", 0));
//        System.out.println(dao.removeLesson(4));
        //      System.out.println(dao.getAllReview());
        //   System.out.println(dao.getLessonByID("6"));
        //    System.out.println(dao.getAllCourseType());
        //String search, String[] typeOfCourse, String[] prices, String[] durations, String rating, String sort
        // System.out.println(dao.getListSubLessonByLessonID(1));
        System.out.println(dao.addSubLesson("a", "a", "a", 2, "22", 0));
=======
    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
        // System.out.println(dao.getAllCourseType());
//        System.out.println(dao.getCourseByCourseType("2"));
//        System.out.println(dao.searchAndFilterData("c++", new String[]{"1", "2", "3"}, new String[]{""}));
        System.out.println(dao.getAllCourse());
>>>>>>> origin/Authentication:src/java/dal/CourseDAO.java
=======
    
//    public List<CourseDBO> getCourseByRating(String rating) {
//        String sql = "SELECT c.course_id, c.name, c.price, c.course_img, AVG(r.rating) AS totals\n" +
//                    "FROM Course AS c\n" +
//                    "LEFT JOIN Review AS r ON r.course_id = c.course_id\n" +
//                    "GROUP BY c.course_id, c.name, c.price, c.course_img\n" +
//                    "HAVING AVG(r.rating) >= ?\n" +
//                    "order by totals desc;";
//        ArrayList<CourseDBO> list = new ArrayList<>();
//        try {
//            PreparedStatement p = connection.prepareStatement(sql);
//            p.setString(1, rating);
//            ResultSet r = p.executeQuery();
//            while (r.next()) {
//                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
//                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
//                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
//                list.add(course);
//            }
//        } catch (SQLException e) {
//
//        }
//        return list;
//    }
    
//    public List<CourseDBO> getCourseByRating(double rating) {
//    String query = "SELECT c.course_id, c.name, c.title, c.description, c.price, c.course_img, "
//                 + "c.created_by, c.teacher_id, c.is_locked, c.created_at, "
//                 + "ct.course_type_id, ct.course_type_name AS course_type_name, AVG(r.rating) AS totals "
//                 + "FROM Course AS c "
//                 + "LEFT JOIN Review AS r ON r.course_id = c.course_id "
//                 + "JOIN CourseType AS ct ON ct.course_type_id = c.course_type_id "
//                 + "GROUP BY c.course_id, c.name, c.title, c.description, c.price, c.course_img, "
//                 + "c.created_by, c.teacher_id, c.is_locked, c.created_at, ct.course_type_id, ct.course_type_name "
//                 + "HAVING AVG(r.rating) >= ? "
//                 + "ORDER BY totals DESC";
//    
//    List<CourseDBO> list = new ArrayList<>();
//    
//    try (PreparedStatement p = connection.prepareStatement(query)) {
//        p.setDouble(1, rating);
//        try (ResultSet r = p.executeQuery()) {
//            while (r.next()) {
//                CourseTypeDBO type = new CourseTypeDBO(r.getInt(11), r.getString(12));
//                CourseDBO course = new CourseDBO(
//                    r.getInt(1), 
//                    r.getString(2), 
//                    r.getString(3), 
//                    r.getString(4), 
//                    r.getDouble(5), 
//                    r.getString(6), 
//                    r.getInt(7), 
//                    r.getInt(8), 
//                    r.getBoolean(9), 
//                    r.getDate(10), 
//                    type
//                );
//                list.add(course);
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace(); // Log the exception or handle it accordingly
//    }
//    
//    return list;
//}
<<<<<<< HEAD

    public List<CourseDBO> getCoursesByRating() {
    String query = "SELECT TOP 6 c.course_id, c.name, c.price, c.course_img, AVG(r.rating) AS total\n" +
"FROM Course AS c\n" +
"LEFT JOIN Review AS r ON r.course_id = c.course_id\n" +
"GROUP BY c.course_id, c.name, c.price, c.course_img\n" +
"ORDER BY total DESC;"; // Adjust this line if using SQL Server: "TOP 3"

    List<CourseDBO> list = new ArrayList<>();
    
    try (PreparedStatement p = connection.prepareStatement(query);
         ResultSet r = p.executeQuery()) {
        
        while (r.next()) {
            CourseDBO course = new CourseDBO(
                r.getInt("course_id"), 
                r.getString("name"), 
                null, // title
                null, // description
                r.getDouble("price"), 
                r.getString("course_img"), 
                0, // created_by
                0, // teacher_id
                false, // is_locked
                null, // created_at
                null // course_type
=======
 public List<CourseDBO> getCoursesByRating() {
    String query = "SELECT c.course_id, c.name, c.price, c.course_img, AVG(r.rating) AS average_rating\n"
            + "FROM Course AS c\n"
            + "LEFT JOIN Review AS r ON r.course_id = c.course_id\n"
            + "GROUP BY c.course_id, c.name, c.price, c.course_img\n"
            + "HAVING AVG(r.rating) IS NOT NULL\n"  // Filter out courses without ratings
            + "ORDER BY average_rating DESC\n"
            + "LIMIT 6";  // Adjust this line based on your SQL database (LIMIT for MySQL, TOP for SQL Server)

    List<CourseDBO> list = new ArrayList<>();

    try (PreparedStatement p = connection.prepareStatement(query); ResultSet r = p.executeQuery()) {

        while (r.next()) {
            CourseDBO course = new CourseDBO(
                    r.getInt("course_id"),
                    r.getString("name"),
                    null, // title
                    null, // description
                    r.getDouble("price"),
                    r.getString("course_img"),
                    0, // created_by
                    0, // teacher_id
                    false, // is_locked
                    null, // created_at
                    null, // course_type
                    false
>>>>>>> origin/create-course1
            );
            list.add(course);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Log the exception or handle it accordingly
<<<<<<< HEAD
    }    
    return list;
}
    
    public List<CourseDBO> getAllCourseByTeacherID(String id) {
        String sql = " SELECT * FROM Course c \n" +
                    "  join CourseType ct on c.course_type_id = ct.course_type_id\n" +
                    "  where c.teacher_id = ?";
        ArrayList<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }
    
    public static void main(String[] args) {
        CourseDAO dao = new CourseDAO();
//         System.out.println(dao.getAllCourseType());
//        System.out.println(dao.getCourseByCourseType("2"));
//        System.out.println(dao.searchAndFilterData("c++", new String[]{"1", "2", "3"}, new String[]{""}));
//        System.out.println(dao.getListSubLessonByLessonID(1));
//System.out.println(dao.getDurationOfCourse(1));
//        System.out.println(dao.getCourseByCourseType("1"));
//          System.out.println(dao.getAllCourse());
//            System.out.println(dao.getCoursesByRating());
//        System.out.println(dao.getAllCourseType2());
        System.out.println(dao.getAllCourseByTeacherID("28"));
>>>>>>> origin/front-end
=======
    }

    return list;
}

    // Phương thức để lấy danh sách tên loại khóa học từ bảng coursetype

    public List<String> getAllCourseTypeNames() {
        String sql = "SELECT course_type_name FROM coursetype";
        List<String> courseTypeNames = new ArrayList<>();

        try (
                PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                String typeName = rs.getString("course_type_name");
                courseTypeNames.add(typeName);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving course type names: " + e.getMessage());
        }

        return courseTypeNames;
    }

    public int getCourseTypeIdByName(String typeName) {
        String sql = "SELECT course_type_id FROM coursetype WHERE LOWER(TRIM(course_type_name)) = ?";
        int courseTypeId = -1; // Default to -1 if course type name is not found

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, typeName.trim().toLowerCase()); // Normalize and trim to lowercase
            System.out.println("Executing SQL: " + stmt.toString()); // Debugging output

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    courseTypeId = rs.getInt("course_type_id");
                    System.out.println("Found course type ID for " + typeName + ": " + courseTypeId);
                } else {
                    System.out.println("Course type ID not found for " + typeName);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving course type ID: " + e.getMessage());
        }

        return courseTypeId;
    }

   public int createCourse(String name, String title, String description, double price, String img, boolean isLocked, int userId, String courseTypeName) {
    int courseId = -1;

    // Get course type id
    int courseTypeId = getCourseTypeIdByName(courseTypeName);
    if (courseTypeId == -1) {
        System.out.println("Course type not found: " + courseTypeName);
        return courseId;
    }

    // Prepare to insert course into database
    String sql = "INSERT INTO Course (name, title, description, course_type_id, price, course_img, created_by, is_locked, created_at, is_deleted) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), 0)";
    try {
        PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, name);
        stmt.setString(2, title);
        stmt.setString(3, description);
        stmt.setInt(4, courseTypeId);
        stmt.setDouble(5, price);
        stmt.setString(6, img);
        stmt.setInt(7, userId);
        stmt.setInt(8, isLocked ? 1 : 0);

        int affectedRows = stmt.executeUpdate();
        if (affectedRows > 0) {
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                courseId = rs.getInt(1);
                System.out.println("Course created successfully with ID: " + courseId);
            }
        } else {
            System.out.println("Failed to create course.");
        }
    } catch (SQLException e) {
        System.out.println("Error creating course: " + e.getMessage());
    }

    return courseId;
}
        public List<CourseDBO> getAllCourseByUserId(int id) {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id where  [is_deleted] = 0 AND created_by = "+id;
        List<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                              CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
                CourseDBO    course = new CourseDBO(
                            r.getInt("course_id"),
                            r.getString("name"),
                            r.getString("title"),
                            r.getString("description"),
                            r.getDouble("price"),
                            r.getString("course_img"),
                            r.getInt("created_by"),
                            r.getInt("teacher_id"),
                            r.getBoolean("is_locked"),
                            r.getDate("created_at"),
                            type,
                            false// Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                    );
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }
        // CourseDAO.java
public boolean deleteTeacherById(int teacherId) {
    // Xóa giáo viên từ bảng CourseUserLink
    String deleteLinkSQL = "DELETE FROM CourseUserLink WHERE user_id = ?";
    try (PreparedStatement psDeleteLink = connection.prepareStatement(deleteLinkSQL)) {
        psDeleteLink.setInt(1, teacherId);
        psDeleteLink.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }

    // Cập nhật teacher_id thành null trong bảng Course
    String updateCourseSQL = "UPDATE Course SET teacher_id = null WHERE teacher_id = ?";
    try (PreparedStatement psUpdateCourse = connection.prepareStatement(updateCourseSQL)) {
        psUpdateCourse.setInt(1, teacherId);
        psUpdateCourse.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }

    return true;
}
    public boolean updateCourseTeacher(int courseId, int teacherId, int userId) {
        String updateCourseSQL = "UPDATE Course SET teacher_id = ? WHERE course_id = ?";
        String insertLinkSQL = "INSERT INTO CourseUserLink (course_id, user_id, created_by) VALUES (?, ?, ?)";
        
        try (
            PreparedStatement psUpdateCourse = connection.prepareStatement(updateCourseSQL);
            PreparedStatement psInsertLink = connection.prepareStatement(insertLinkSQL)
        ) {
            connection.setAutoCommit(false);

            // Update teacher_id in Course table
            psUpdateCourse.setInt(1, teacherId);
            psUpdateCourse.setInt(2, courseId);
            psUpdateCourse.executeUpdate();

            // Insert into CourseUserLink table
            psInsertLink.setInt(1, courseId);
            psInsertLink.setInt(2, teacherId);
            psInsertLink.setInt(3, userId);
            psInsertLink.executeUpdate();

            connection.commit();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
>>>>>>> origin/create-course1
    }
      public int getTeacherIdByCourseId(int courseId) {
        int teacherId = -1; // Default value if not found

        String sql = "SELECT teacher_id FROM Course WHERE course_id = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                teacherId = rs.getInt("teacher_id");
            } else {
                System.out.println("No teacher found for course with ID: " + courseId);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving teacher ID: " + e.getMessage());
        }

        return teacherId;
    }
      public boolean deleteCourse(int courseId) throws SQLException {
        PreparedStatement pstmt = null;

     
            // Get database connection
            String sql = "UPDATE [Course] SET is_deleted = 1, is_locked = 1 WHERE [course_id] = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, courseId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        
    }
public boolean updateCourse(int courseId, String name, String title, String description, double price, String img, boolean isLocked, String courseTypeName) {
    PreparedStatement stmt = null;
    boolean success = false;

    try {
        // Get course type id
        int courseTypeId = getCourseTypeIdByName(courseTypeName);
        if (courseTypeId == -1) {
            System.out.println("Course type not found: " + courseTypeName);
            return success;
        }

        String sql = "UPDATE Course SET name=?, title=?, description=?, course_type_id=?, price=?, course_img=?, is_locked=? WHERE course_id=?";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, title);
        stmt.setString(3, description);
        stmt.setInt(4, courseTypeId);
        stmt.setDouble(5, price);
        stmt.setString(6, img);
        stmt.setInt(7, isLocked ? 1 : 0);
        stmt.setInt(8, courseId);

        int rowsAffected = stmt.executeUpdate();
        if (rowsAffected > 0) {
            success = true;
            System.out.println("Course updated successfully with ID: " + courseId);
        } else {
            System.out.println("Failed to update course.");
        }
    } catch (SQLException e) {
        System.out.println("Error updating course: " + e.getMessage());
    } finally {
        // Close PreparedStatement in finally block
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                System.out.println("Error closing PreparedStatement: " + e.getMessage());
            }
        }
    }

    return success;
}



public static void main(String[] args) throws SQLException {
   
        CourseDAO courseDAO = new CourseDAO();
System.out.print(courseDAO.deleteCourse(1015));
    }


}
