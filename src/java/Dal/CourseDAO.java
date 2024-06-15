package Dal;

import Model.CourseDBO;
import Model.CourseType2DBO;
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
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
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
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
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
    
    public List<CourseType2DBO> getAllCourseType2() {
        String sql = "select * from coursetype ";
        List<CourseType2DBO> list = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseType2DBO type = new CourseType2DBO(r.getInt(1), r.getString(2), r.getString(3), r.getString(4));
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
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
                list.add(course);
            }
        } catch (SQLException e) {

        }
        return list;
    }

    public CourseDBO getCourseByID(String id) {
        String sql = "select * from course as c join coursetype "
                + "as ct on ct.course_type_id=c.course_type_id where course_id=?";
        CourseDBO course = null;
        try {
            PreparedStatement p = connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r = p.executeQuery();
            while (r.next()) {
                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);

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

                CourseTypeDBO type = new CourseTypeDBO(r.getInt(12), r.getString(13));
                CourseDBO course = new CourseDBO(r.getInt(1), r.getString(2), r.getString(3),
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10), r.getDate(11), type);
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
                        null, // title
                        null, // description
                        r.getDouble("price"),
                        r.getString("course_img"),
                        0, // created_by
                        0, // teacher_id
                        false, // is_locked
                        null, // created_at
                        null // course_type
                );
                list.add(course);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the exception or handle it accordingly
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


    public static void main(String[] args) {
<<<<<<< HEAD
        CourseDAO dao = new CourseDAO();
//         System.out.println(dao.getAllCourseType());
//        System.out.println(dao.getCourseByCourseType("2"));
//        System.out.println(dao.searchAndFilterData("c++", new String[]{"1", "2", "3"}, new String[]{""}));
//        System.out.println(dao.getListSubLessonByLessonID(1));
//System.out.println(dao.getDurationOfCourse(1));
//        System.out.println(dao.getCourseByCourseType("1"));
//          System.out.println(dao.getAllCourse());
//            System.out.println(dao.getCoursesByRating());
        System.out.println(dao.getAllCourseType2());
=======
        CourseDAO courseDAO = new CourseDAO();

        // Các thông tin để tạo khóa học
        String name = "Java Programming";
        String title = "Learn Java Programming";
        String description = "A comprehensive course on Java programming language.";
        double price = 0;
        String img = "img\\course_img.jpg";
        boolean isLocked = false; // Nếu true thì khóa, false thì mở
        int ID = 29; // Thay đổi username và password phù hợp
     
        String courseTypeName = "Hi"; // Tên của loại khóa học

        // Gọi hàm createCourse
        int result = courseDAO.createCourse(name, title, description, price, img, isLocked, ID, courseTypeName);

        // Kiểm tra kết quả
        if (result > 0) {
            System.out.println("Course created successfully.");
        } else {
            System.out.println("Failed to create course.");
        }
>>>>>>> 5e01b0469b6cacf33373904f84953cd3ffe75bc3
    }
}
