package Dal;

import Model.CourseDBO;
import Model.CourseTypeDBO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.UserDBO;
import Model.RoleDBO;
import java.util.List;

public class CourseDAO extends DBContext {

    public List<CourseDBO> getAllCourse() {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id";
        List<CourseDBO> list=new ArrayList<>();
        try{
            PreparedStatement p=connection.prepareStatement(sql);
            ResultSet r=p.executeQuery();
            while (r.next()){
                CourseTypeDBO type=new CourseTypeDBO(r.getInt(11),r.getString(12));
                CourseDBO course=new CourseDBO(r.getInt(1), r.getString(2), r.getString(3), 
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10),type);
                list.add(course);
            }
        }catch (SQLException e){
            
        }
        return list;
    }
      public CourseDBO getCourseByID(String id) {
        String sql = "select * from course as c join coursetype as ct on ct.course_type_id=c.course_type_id where course_id=?";
        CourseDBO course=null;
        try{
            PreparedStatement p=connection.prepareStatement(sql);
            p.setString(1, id);
            ResultSet r=p.executeQuery();
            while (r.next()){
                CourseTypeDBO type=new CourseTypeDBO(r.getInt(11),r.getString(12));
                 course=new CourseDBO(r.getInt(1), r.getString(2), r.getString(3), 
                        r.getString(4), r.getDouble(6), r.getString(7), r.getInt(8), r.getInt(9), r.getBoolean(10),type);
             
            }
        }catch (SQLException e){
            
        }
        return course;
    }
      
    public static void main(String[] args) {
        CourseDAO dao=new CourseDAO();
        System.out.println(dao.getAllCourse());    }
}
