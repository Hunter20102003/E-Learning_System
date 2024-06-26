package Dal;

import Model.CourseDBO;
import Model.CourseTypeDBO;
import Model.EnrollmentDBO;
import Model.LessonDBO;
import Model.QuizDBO;
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

    public List<CourseDBO> getAllCourses() {
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, "
                + "c.course_img, c.created_by, c.teacher_id, c.is_locked, c.created_at, "
                + "ct.course_type_id, ct.course_type_name "
                + "FROM course AS c "
                + "JOIN coursetype AS ct ON ct.course_type_id = c.course_type_id "
                + "WHERE c.is_deleted = 0"; // chỉ lấy các khóa học chưa bị xóa

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
                        r.getBoolean("is_deleted")
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
                        r.getBoolean("is_deleted")
                );
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

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
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));
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
                        r.getBoolean("is_deleted") // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
                );
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

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
        CourseDBO course = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
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

            }
        } catch (SQLException e) {

        }
        return course;
    }

    public ArrayList<SubLessonDBO> getListSubLessonByLessonID(int id) {
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
                + "where l.lesson_id=?";
        ArrayList<SubLessonDBO> listSubLesson = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
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

            }

        } catch (SQLException e) {
            e.printStackTrace();
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
                subLesson = new SubLessonDBO(r.getInt("sub_lesson_id"), r.getString("title"), r.getString("content"), r.getString("description"), r.getDate("creation_date"), r.getString("video_link"), r.getBoolean("is_locked"), r.getLong("video_duration"));

            }

        } catch (SQLException e) {

        }
        return subLesson;
    }

    public ArrayList<LessonDBO> getListLessonByCourseID(String id) {
        QuizDAO dao = new QuizDAO();
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
                ArrayList<QuizDBO> listQuiz = dao.getListQuizByLessonID(r.getInt(1));
                listLesson.add(new LessonDBO(r.getInt(1), r.getString(2), r.getInt(3), r.getBoolean(4), listSubLesson, listQuiz));
            }

        } catch (SQLException e) {

        }
        return listLesson;
    }

    public LessonDBO getLessonByID(String id) {
        QuizDAO dao = new QuizDAO();

        String sql = "select * from lesson as l "
                + "join course as c on c.course_id=l.course_id "
                + "where lesson_id=?";
        LessonDBO Lesson = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                ArrayList<SubLessonDBO> listSubLesson = getListSubLessonByLessonID(r.getInt(1));
                ArrayList<QuizDBO> listQuiz = dao.getListQuizByLessonID(r.getInt(1));
                Lesson = new LessonDBO(r.getInt(1), r.getString(2), r.getInt(3), r.getBoolean(4), listSubLesson, listQuiz);
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

                        sql.append(" cd.course_id between 3601 and 10800");
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
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,c.is_deleted,ct.course_type_id,ct.course_type_name ");

        if (rating != null && !rating.isBlank()) {
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
            if (rating != null && !rating.isBlank()) {
                p.setString(count, rating);
            }
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
                        r.getBoolean("is_deleted"));
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

    public boolean deleteCourse(int courseId) throws SQLException {
        PreparedStatement pstmt = null;

     
            // Get database connection
            String sql = "UPDATE [Course] SET is_deleted = 1, is_locked = 1 WHERE [course_id] = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, courseId);

            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        
    }


    public boolean updateCourseTeacher(int courseId, int teacherId, int userId) {
        String updateCourseSQL = "UPDATE Course SET teacher_id = ? WHERE course_id = ?";
        String insertLinkSQL = "INSERT INTO CourseUserLink (course_id, user_id, created_by) VALUES (?, ?, ?)";

        try (
                PreparedStatement psUpdateCourse = connection.prepareStatement(updateCourseSQL); PreparedStatement psInsertLink = connection.prepareStatement(insertLinkSQL)) {
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
    }

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

    public List<CourseDBO> getAllCourseByUserId(int id) {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id where  [is_deleted] = 0 AND created_by = " + id;
        List<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
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
                        false// Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                );
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

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
    }
}
