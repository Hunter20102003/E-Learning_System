package Dal;

import Model.CourseDBO;
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
<<<<<<< Updated upstream
import Model.WishlistItem;
=======
import Model.UserCourseProgressDBO;
>>>>>>> Stashed changes
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
                        false// Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
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
                        false // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
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
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(1), r.getString(2));
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
<<<<<<< Updated upstream
                        false // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
=======
                        r.getBoolean("is_deleted") // Không cần lấy is_deleted vì chỉ lấy các khóa học chưa bị xóa
                );
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public ArrayList<CourseDBO> searchCourseBelongMentor(String search, int mentorId) {
        String sql = "select * from course as c "
                + "join coursetype as ct on ct.course_type_id=c.course_type_id "
                + "where c.name like ? and teacher_id =?";
        ArrayList<CourseDBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, "%" + search + "%");
            p.setInt(2, mentorId);
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
>>>>>>> Stashed changes
                );
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public CourseDBO getCourseByID(int id) {
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, "
                + "c.course_img, c.created_by, c.teacher_id, c.is_locked, c.created_at, "
                + "ct.course_type_id, ct.course_type_name "
                + "FROM course AS c "
                + "JOIN coursetype AS ct ON ct.course_type_id = c.course_type_id "
                + "WHERE c.course_id = ? AND c.is_deleted = 0"; // chỉ lấy khóa học chưa bị xóa

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
        String sql = "select * from lesson as l "
                + "join SubLesson as sl on l.lesson_id=sl.lesson_id "
                + "where l.lesson_id=?";
        ArrayList<SubLessonDBO> listSubLesson = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                listSubLesson.add(new SubLessonDBO(r.getInt(5), r.getString(6), r.getString(7), r.getString(8), r.getDate(10), r.getString(11), r.getBoolean(12), r.getLong(
                        13)));

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
                subLesson = new SubLessonDBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getDate(6), r.getString(7), r.getBoolean(8), r.getLong(9));

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

    public List<CourseDBO> searchAndFilterData(String search, String[] typeOfCourse, String[] prices, String[] durations, String rating, String sort) {
        List<CourseDBO> datas = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select c.course_id,c.name,c.title,c.description,c.course_type_id,c.price,c.course_img,\n"
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,ct.course_type_id,ct.course_type_name\n"
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
                + "c.created_by,c.teacher_id,c.is_locked,c.created_at,ct.course_type_id,ct.course_type_name ");

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
                        false // Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                );
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
    public List<CourseDBO> getCoursesByRating() {
        String query = "SELECT c.course_id, c.name, c.price, c.course_img, AVG(r.rating) AS average_rating\n"
                + "FROM Course AS c\n"
                + "LEFT JOIN Review AS r ON r.course_id = c.course_id\n"
                + "GROUP BY c.course_id, c.name, c.price, c.course_img\n"
                + "HAVING AVG(r.rating) IS NOT NULL\n" // Filter out courses without ratings
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
                );
                list.add(course);
            }
        } catch (SQLException e) {
            // Log the exception or handle it accordingly

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
    // CourseDAO.java

    public boolean removeTeacherFromCourse(int courseId, int userId) {
        String updateCourseSQL = "UPDATE Course SET teacher_id = null WHERE course_id = ?";
<<<<<<< Updated upstream
        String deleteLinkSQL = "DELETE FROM ManagerMentor WHERE course_id = ? AND user_id = ?";
=======
//        String deleteLinkSQL = "DELETE FROM ManagerMentor WHERE course_id = ? AND user_id = ?";
        String deleteLinkSQL = "DELETE FROM ManagerMentor WHERE id = ("
                + "SELECT TOP  1 m.id FROM ManagerMentor m"
                + "  JOIN Course c ON m.created_by = c.created_by"
                + " WHERE c.course_id = ? AND m.user_id = ?)";
>>>>>>> Stashed changes

        try (
                PreparedStatement psUpdateCourse = connection.prepareStatement(updateCourseSQL); PreparedStatement psDeleteLink = connection.prepareStatement(deleteLinkSQL)) {
            connection.setAutoCommit(false);

            // Cập nhật teacher_id thành null trong bảng Course
            psUpdateCourse.setInt(1, courseId);
            psUpdateCourse.executeUpdate();

            // Xóa giáo viên khỏi bảng ManagerMentor cho khóa học cụ thể
            psDeleteLink.setInt(1, courseId);
            psDeleteLink.setInt(2, userId);
            psDeleteLink.executeUpdate();

            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }

<<<<<<< Updated upstream
    public boolean updateCourseTeacher(int courseId, int teacherId, int userId) {
        String deleteOldTeacherSQL = "DELETE FROM ManagerMentor WHERE course_id = ?";
        String updateCourseSQL = "UPDATE Course SET teacher_id = ? WHERE course_id = ?";
        String insertLinkSQL = "INSERT INTO ManagerMentor (course_id, user_id, created_by) VALUES (?, ?, ?)";

        try (
                PreparedStatement psDeleteOldTeacher = connection.prepareStatement(deleteOldTeacherSQL); PreparedStatement psUpdateCourse = connection.prepareStatement(updateCourseSQL); PreparedStatement psInsertLink = connection.prepareStatement(insertLinkSQL)) {
            connection.setAutoCommit(false);

            // Xóa giáo viên cũ khỏi khóa học trong bảng ManagerMentor
            psDeleteOldTeacher.setInt(1, courseId);
            psDeleteOldTeacher.executeUpdate();

            // Cập nhật teacher_id trong bảng Course
            psUpdateCourse.setInt(1, teacherId);
            psUpdateCourse.setInt(2, courseId);
            psUpdateCourse.executeUpdate();

            // Thêm giáo viên mới vào bảng ManagerMentor
            psInsertLink.setInt(1, courseId);
            psInsertLink.setInt(2, teacherId);
            psInsertLink.setInt(3, userId);
            psInsertLink.executeUpdate();

            connection.commit();
            return true;
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            }
            return false;
        }
    }
=======
   public boolean updateCourseTeacher(int courseId, int teacherId, int userId) {
    String deleteOldTeacherSQL = "DELETE FROM ManagerMentor WHERE user_id = ? AND created_by = ("
            + "SELECT TOP 1 m.created_by FROM ManagerMentor m "
            + "JOIN Course c ON m.created_by = c.created_by "
            + "WHERE c.course_id = ?)";
    
    String updateCourseSQL = "UPDATE Course SET teacher_id = ? WHERE course_id = ?";
    
    String insertLinkSQL = "INSERT INTO ManagerMentor (user_id, created_by) "
            + "VALUES (?, (SELECT created_by FROM Course WHERE course_id = ?))";

    try (
        PreparedStatement psDeleteOldTeacher = connection.prepareStatement(deleteOldTeacherSQL);
        PreparedStatement psUpdateCourse = connection.prepareStatement(updateCourseSQL);
        PreparedStatement psInsertLink = connection.prepareStatement(insertLinkSQL)) {
        
        connection.setAutoCommit(false);

        // Xóa giáo viên cũ khỏi bảng ManagerMentor
        psDeleteOldTeacher.setInt(1, teacherId);
        psDeleteOldTeacher.setInt(2, courseId);
        psDeleteOldTeacher.executeUpdate();

        // Cập nhật teacher_id trong bảng Course
        psUpdateCourse.setInt(1, teacherId);
        psUpdateCourse.setInt(2, courseId);
        psUpdateCourse.executeUpdate();

        // Thêm giáo viên mới vào bảng ManagerMentor
        psInsertLink.setInt(1, teacherId);
        psInsertLink.setInt(2, courseId);
        psInsertLink.executeUpdate();

        connection.commit();
        return true;
    } catch (SQLException e) {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

>>>>>>> Stashed changes

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

<<<<<<< Updated upstream
    public List<CourseDBO> searchAndFilterData1(String txtSearch, int userId) {
        List<CourseDBO> courses = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM [Course] AS c JOIN [CourseType] AS ct ON ct.[course_type_id] = c.course_type_id WHERE c.is_deleted = 0 AND c.created_by = ?");
=======
    public boolean isCourseNameExists(String courseName) {
        List<CourseDBO> courses = getAllCourses();
        for (CourseDBO course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    public List<LessonDBO> getLessonsByCourseId1(int courseId) {
        String sql = "SELECT lesson_id, title, course_id, is_locked "
                + "FROM Lesson "
                + "WHERE course_id = ?";

        List<LessonDBO> lessons = new ArrayList<>();

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, courseId);
            try (ResultSet r = p.executeQuery()) {
                while (r.next()) {
                    LessonDBO lesson = new LessonDBO(
                            r.getInt("lesson_id"),
                            r.getString("title"),
                            r.getInt("course_id"),
                            r.getBoolean("is_locked"),
                            new ArrayList<>()
                    );
                    lessons.add(lesson);
                }
            }
        } catch (SQLException e) {
        }

        return lessons;
    }

    public List<SubLessonDBO> getSubLessonsByLessonId1(int lessonId) {
        String sql = "SELECT sub_lesson_id, title, content, description, lesson_id, creation_date, video_link, is_locked, video_duration "
                + "FROM SubLesson "
                + "WHERE lesson_id = ?";

        List<SubLessonDBO> subLessons = new ArrayList<>();

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, lessonId);
            try (ResultSet r = p.executeQuery()) {
                while (r.next()) {
                    SubLessonDBO subLesson = new SubLessonDBO(
                            r.getInt("sub_lesson_id"),
                            r.getString("title"),
                            r.getString("content"),
                            r.getString("description"),
                            r.getDate("creation_date"),
                            r.getString("video_link"),
                            r.getBoolean("is_locked"),
                            r.getLong("video_duration")
                    );
                    subLessons.add(subLesson);
                }
            }
        } catch (SQLException e) {
        }

        return subLessons;
    }

    public boolean isCourseInWishlist(int userId, int courseId) {
        String sql = "SELECT COUNT(*) FROM wish_list WHERE user_id = ? AND course_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
        }
        return false;
    }

    public String toggleWishlist(int userId, int courseId) {
        if (isCourseInWishlist(userId, courseId)) {
            String deleteSql = "DELETE FROM wish_list WHERE user_id = ? AND course_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
                ps.setInt(1, userId);
                ps.setInt(2, courseId);
                ps.executeUpdate();
                return "removed";
            } catch (SQLException e) {
            }
        } else {
            String insertSql = "INSERT INTO wish_list (user_id, course_id) VALUES (?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, userId);
                ps.setInt(2, courseId);
                ps.executeUpdate();
                return "added";
            } catch (SQLException e) {
            }
        }
        return "error";
    }

    public List<CourseDBO> getWishlistCourses(int userId) {
        List<CourseDBO> courses = new ArrayList<>();
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, c.course_img "
                + "FROM wish_list w "
                + "JOIN Course c ON w.course_id = c.course_id "
                + "WHERE w.user_id = ? AND c.is_deleted = 0";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CourseDBO course = new CourseDBO();
                course.setId(rs.getInt("course_id"));
                course.setName(rs.getString("name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));
                course.setPrice(rs.getDouble("price"));
                course.setImg(rs.getString("course_img"));
                courses.add(course);
            }
        } catch (SQLException e) {
        }

        return courses;
    }

    public boolean removeCourseFromWishlist(int userId, int courseId) {
        String sql = "DELETE FROM wish_list WHERE user_id = ? AND course_id = ?";
        try (
                PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    public List<CourseDBO> searchWishlistCourses(int userId, String search) {
        List<CourseDBO> courses = new ArrayList<>();
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, c.course_img "
                + "FROM wish_list w "
                + "JOIN Course c ON w.course_id = c.course_id "
                + "WHERE w.user_id = ? AND c.is_deleted = 0 AND c.name LIKE ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, "%" + search + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CourseDBO course = new CourseDBO();
                course.setId(rs.getInt("course_id"));
                course.setName(rs.getString("name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));
                course.setPrice(rs.getDouble("price"));
                course.setImg(rs.getString("course_img"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

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
            // Log the exception or handle it accordingly

        }
        return course;
    }

    public List<CourseDBO> searchAndFilterData1(String txtSearch, int userId) {
        List<CourseDBO> courses = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM [Course] AS c JOIN [CourseType] AS ct ON ct.[course_type_id] = c.course_type_id WHERE c.is_deleted = 0 AND c.created_by = ?");

        if (txtSearch != null && !txtSearch.isEmpty()) {
            query.append(" AND c.name LIKE ?");
        }

        try (PreparedStatement ps = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;
            ps.setInt(paramIndex++, userId);
            if (txtSearch != null && !txtSearch.isEmpty()) {
                ps.setString(paramIndex++, "%" + txtSearch + "%");
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CourseTypeDBO type = new CourseTypeDBO(rs.getInt("course_type_id"), rs.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        rs.getInt("course_id"),
                        rs.getString("name"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("course_img"),
                        rs.getInt("created_by"),
                        rs.getInt("teacher_id"),
                        rs.getBoolean("is_locked"),
                        rs.getDate("created_at"),
                        type,
                        false // Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                );
                courses.add(course);
            }
        } catch (SQLException e) {
        }

        return courses;
    }

    public List<CourseDBO> getAllCourseByTeacherID(String id) {
        String sql = " SELECT * FROM Course c \n"
                + "  join CourseType ct on c.course_type_id = ct.course_type_id\n"
                + "  where c.teacher_id = ?";
        ArrayList<CourseDBO> courses = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
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
                courses.add(course);
            }
        } catch (SQLException e) {

        }
        return courses;
    }

    public List<CourseDBO> getCoursesByRating() {
        String query = "SELECT TOP 6 c.course_id, c.name, c.price, c.course_img, AVG(r.rating) AS total\n"
                + "FROM Course AS c\n"
                + "LEFT JOIN Review AS r ON r.course_id = c.course_id\n"
                + "GROUP BY c.course_id, c.name, c.price, c.course_img\n"
                + "ORDER BY total DESC;"; // Adjust this line if using SQL Server: "TOP 3"

        List<CourseDBO> list = new ArrayList<>();

        try (PreparedStatement p = connection.prepareStatement(query); ResultSet r = p.executeQuery()) {

            while (r.next()) {
                CourseDBO course = new CourseDBO(
                        r.getInt("course_id"),
                        r.getString("name"),
                        null,
                        null,
                        r.getDouble("price"),
                        r.getString("course_img"),
                        0,
                        0,
                        false,
                        null,
                        null,
                        false);
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception or handle it accordingly
        }
        return list;
    }
    //khoa hoc dang hoc co progress < 100

    public List<UserCourseProgressDBO> getInProgressCourses(int userId) {
        List<UserCourseProgressDBO> listCourseProgress = new ArrayList<>();
        String sql = "SELECT up.user_id, up.course_id, up.completion_date, up.progress, "
                + "c.course_img, c.name, c.description, c.title, c.price, c.created_by, c.teacher_id, "
                + "c.is_locked, c.created_at, c.is_deleted, "
                + "ct.course_type_id, ct.course_type_name, up.progress "
                + "FROM UserCourseProgress up "
                + "JOIN Course c ON c.course_id = up.course_id "
                + "JOIN CourseType ct ON c.course_type_id = ct.course_type_id "
                + "WHERE up.progress < 100 AND up.user_id = ?";

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, userId);
            try (ResultSet r = p.executeQuery()) {
                while (r.next()) {
                    CourseTypeDBO type = new CourseTypeDBO(
                            r.getInt("course_type_id"),
                            r.getString("course_type_name")
                    );
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
                    UserCourseProgressDBO courseProgress = new UserCourseProgressDBO(
                            r.getInt("user_id"),
                            r.getInt("course_id"),
                            r.getDate("completion_date"),
                            r.getInt("progress"),
                            course);
                    listCourseProgress.add(courseProgress);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCourseProgress;
    }

    public List<CourseTypeDBO> getAllCourseTypeNamesAndID() {
        String sql = "Select course_type_id, course_type_name from CourseType";
        List<CourseTypeDBO> courseType = new ArrayList<>();

        try (PreparedStatement p = connection.prepareStatement(sql); ResultSet r = p.executeQuery()) {
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt("course_type_id"), r.getString("course_type_name"));

                courseType.add(type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courseType;
    }
    //khoa hoc hoan thanh co progress = 100

    public List<CourseDBO> getCompletedCourses(int userId) {
        List<CourseDBO> listCompletedCourses = new ArrayList<>();
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, c.course_img, c.created_by, c.teacher_id, "
                + "c.is_locked, c.created_at, c.is_deleted, "
                + "ct.course_type_id, ct.course_type_name "
                + "FROM UserCourseProgress up "
                + "JOIN Course c ON c.course_id = up.course_id "
                + "JOIN CourseType ct ON c.course_type_id = ct.course_type_id "
                + "WHERE up.progress = 100 AND up.user_id = ?";

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, userId);
            try (ResultSet r = p.executeQuery()) {
                while (r.next()) {
                    CourseTypeDBO type = new CourseTypeDBO(
                            r.getInt("course_type_id"),
                            r.getString("course_type_name")
                    );
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
                    listCompletedCourses.add(course);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listCompletedCourses;
    }
    //kiem tra xem feedback của user co ton tai chua

    public boolean checkFeedBackExisted(int user_id, int course_id) {
        String sql = "select * from Review where user_id= ? and course_id= ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, user_id);
            p.setInt(2, course_id);

            ResultSet r = p.executeQuery();
            if (r.next()) {
                return true;
            }
        } catch (SQLException e) {

        }
        return false;
    }

    //insert review
    public void insertReview(int user_id, int course_id, double rating, String review_text) {
        String query = "INSERT INTO [dbo].[Review]\n"
                + "           ([user_id]\n"
                + "           ,[course_id]\n"
                + "           ,[rating]\n"
                + "           ,[review_text])\n"
                + "     VALUES (?, ?, ?, ?);";

        try {
            PreparedStatement p = connection.prepareStatement(query);
            p.setInt(1, user_id);
            p.setInt(2, course_id);
            p.setDouble(3, rating);
            p.setString(4, review_text);
            p.executeUpdate();
        } catch (Exception e) {
        }

    }

    public String getCourseTypeImgByIDType(int id) {
        String sql = "SELECT course_type_img FROM coursetype WHERE course_type_id = ?";
        String s = "";
        try (
                PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, id);
            try (ResultSet rs = p.executeQuery()) {
                if (rs.next()) {
                    s = rs.getString("course_type_img");
                }
            }
        } catch (SQLException e) {
            // Log the exception (or handle it appropriately)
            // System.out.println("Error retrieving course type img: " + e.getMessage());
        }
        return s;
    }

    public ArrayList<CourseDBO> getAllPurchaseCourseByUserId(int id) {
        ArrayList<CourseDBO> listCourse = new ArrayList<>();
        String sql = "select c.course_id,c.name,c.title,c.description,c.price,c.course_img, c.created_by,c.teacher_id\n"
                + " ,c.is_locked,c.created_at,c.is_deleted,e.user_id, e.course_id,e.enrollment_date \n"
                + " from Course c join Enrollment e on c.course_id = e.course_id where e.user_id = ?";
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setInt(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                EnrollmentDBO enroll = new EnrollmentDBO(r.getInt(12), r.getInt(13), r.getDate(14));
                listCourse.add(new CourseDBO(r.getInt(1), r.getString(2),
                        r.getString(3), r.getString(4), r.getDouble(5),
                        r.getString(6), r.getInt(7), r.getInt(8),
                        r.getBoolean(9), r.getDate(10), r.getBoolean(11), enroll));
            }
        } catch (SQLException e) {
        }
        return listCourse;
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
        //  System.out.println(dao.addSubLesson("a", "a", "a", 2, "22", 0));
        //System.out.println(dao.searchCourseBelongMentor("c", 28));
         System.out.println(dao.updateCourseTeacher(1,29,42));
>>>>>>> Stashed changes

        if (txtSearch != null && !txtSearch.isEmpty()) {
            query.append(" AND c.name LIKE ?");
        }

        try (PreparedStatement ps = connection.prepareStatement(query.toString())) {
            int paramIndex = 1;
            ps.setInt(paramIndex++, userId);
            if (txtSearch != null && !txtSearch.isEmpty()) {
                ps.setString(paramIndex++, "%" + txtSearch + "%");
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CourseTypeDBO type = new CourseTypeDBO(rs.getInt("course_type_id"), rs.getString("course_type_name"));
                CourseDBO course = new CourseDBO(
                        rs.getInt("course_id"),
                        rs.getString("name"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getDouble("price"),
                        rs.getString("course_img"),
                        rs.getInt("created_by"),
                        rs.getInt("teacher_id"),
                        rs.getBoolean("is_locked"),
                        rs.getDate("created_at"),
                        type,
                        false // Không cần lấy is_deleted vì chỉ lấy khóa học chưa bị xóa
                );
                courses.add(course);
            }
        } catch (SQLException e) {
        }

        return courses;
    }

    public List<LessonDBO> getLessonsByCourseId(int courseId) {
        List<LessonDBO> lessons = new ArrayList<>();
        try {
            String sql = "SELECT lesson_id, title, course_id, is_locked FROM Lesson WHERE course_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, courseId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LessonDBO lesson = new LessonDBO();
                lesson.setId(rs.getInt("lesson_id"));
                lesson.setTitle(rs.getString("title"));
                lesson.setCourse_id(rs.getInt("course_id"));
                lesson.setIs_locked(rs.getBoolean("is_locked"));
                lessons.add(lesson);
            }
        } catch (SQLException e) {
        }
        return lessons;
    }

//    public List<SubLessonDBO> getSubLessonsByLessonId(int lessonId) {
//        List<SubLessonDBO> subLessons = new ArrayList<>();
//        try  {
//            String sql = "SELECT sub_lesson_id, title, lesson_id FROM SubLesson WHERE lesson_id = ?";
//            PreparedStatement ps = connection.prepareStatement(sql);
//            ps.setInt(1, lessonId);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                SubLessonDBO subLesson = new SubLessonDBO();
//                subLesson.setId(rs.getInt("sub_lesson_id"));
//                subLesson.setTitle(rs.getString("title"));
//                subLesson.set(rs.getInt("lesson_id"));
//                subLessons.add(subLesson);
//            }
//        } catch (SQLException e) {
//       }
//        return subLessons;
//    }
    public boolean isCourseNameExists(String courseName) {
        List<CourseDBO> courses = getAllCourses();
        for (CourseDBO course : courses) {
            if (course.getName().equalsIgnoreCase(courseName)) {
                return true;
            }
        }
        return false;
    }

    public List<LessonDBO> getLessonsByCourseId1(int courseId) {
        String sql = "SELECT lesson_id, title, course_id, is_locked "
                + "FROM Lesson "
                + "WHERE course_id = ?";

        List<LessonDBO> lessons = new ArrayList<>();

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, courseId);
            try (ResultSet r = p.executeQuery()) {
                while (r.next()) {
                    LessonDBO lesson = new LessonDBO(
                            r.getInt("lesson_id"),
                            r.getString("title"),
                            r.getInt("course_id"),
                            r.getBoolean("is_locked"),
                            new ArrayList<>()
                    );
                    lessons.add(lesson);
                }
            }
        } catch (SQLException e) {
        }

        return lessons;
    }

    public List<SubLessonDBO> getSubLessonsByLessonId1(int lessonId) {
        String sql = "SELECT sub_lesson_id, title, content, description, lesson_id, creation_date, video_link, is_locked, video_duration "
                + "FROM SubLesson "
                + "WHERE lesson_id = ?";

        List<SubLessonDBO> subLessons = new ArrayList<>();

        try (PreparedStatement p = connection.prepareStatement(sql)) {
            p.setInt(1, lessonId);
            try (ResultSet r = p.executeQuery()) {
                while (r.next()) {
                    SubLessonDBO subLesson = new SubLessonDBO(
                            r.getInt("sub_lesson_id"),
                            r.getString("title"),
                            r.getString("content"),
                            r.getString("description"),
                            r.getDate("creation_date"),
                            r.getString("video_link"),
                            r.getBoolean("is_locked"),
                            r.getLong("video_duration")
                    );
                    subLessons.add(subLesson);
                }
            }
        } catch (SQLException e) {
        }

        return subLessons;
    }

    public boolean isCourseInWishlist(int userId, int courseId) {
        String sql = "SELECT COUNT(*) FROM wish_list WHERE user_id = ? AND course_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String toggleWishlist(int userId, int courseId) {
        if (isCourseInWishlist(userId, courseId)) {
            String deleteSql = "DELETE FROM wish_list WHERE user_id = ? AND course_id = ?";
            try (PreparedStatement ps = connection.prepareStatement(deleteSql)) {
                ps.setInt(1, userId);
                ps.setInt(2, courseId);
                ps.executeUpdate();
                return "removed";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            String insertSql = "INSERT INTO wish_list (user_id, course_id) VALUES (?, ?)";
            try (PreparedStatement ps = connection.prepareStatement(insertSql)) {
                ps.setInt(1, userId);
                ps.setInt(2, courseId);
                ps.executeUpdate();
                return "added";
            } catch (SQLException e) {
            }
        }
        return "error";
    }

    public List<CourseDBO> getWishlistCourses(int userId) {
        List<CourseDBO> courses = new ArrayList<>();
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, c.course_img "
                + "FROM wish_list w "
                + "JOIN Course c ON w.course_id = c.course_id "
                + "WHERE w.user_id = ? AND c.is_deleted = 0";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CourseDBO course = new CourseDBO();
                course.setId(rs.getInt("course_id"));
                course.setName(rs.getString("name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));
                course.setPrice(rs.getDouble("price"));
                course.setImg(rs.getString("course_img"));
                courses.add(course);
            }
        } catch (SQLException e) {
        }

        return courses;
    }


    public boolean removeCourseFromWishlist(int userId, int courseId) {
        String sql = "DELETE FROM wish_list WHERE user_id = ? AND course_id = ?";
        try (
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setInt(2, courseId);
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
        }
        return false;
    }

    public List<CourseDBO> searchWishlistCourses(int userId, String search) {
        List<CourseDBO> courses = new ArrayList<>();
        String sql = "SELECT c.course_id, c.name, c.title, c.description, c.price, c.course_img "
                   + "FROM wish_list w "
                   + "JOIN Course c ON w.course_id = c.course_id "
                   + "WHERE w.user_id = ? AND c.is_deleted = 0 AND c.name LIKE ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setString(2, "%" + search + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CourseDBO course = new CourseDBO();
                course.setId(rs.getInt("course_id"));
                course.setName(rs.getString("name"));
                course.setTitle(rs.getString("title"));
                course.setDescription(rs.getString("description"));
                course.setPrice(rs.getDouble("price"));
                course.setImg(rs.getString("course_img"));
                courses.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public static void main(String[] args) throws SQLException {

        CourseDAO courseDAO = new CourseDAO();
        System.out.print(courseDAO.getWishlistCourses(24));
    }

}
