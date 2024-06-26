import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class Dataservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Dữ liệu mẫu cho biểu đồ
        Map<String, Object> data = new HashMap<>();
        data.put("totalStudents", 422);
        data.put("newStudents", 357);
        data.put("totalCourse", 547);
        data.put("feesCollection", 3280);
        data.put("sparkBarData", new int[]{33, 22, 68, 54, 8, 30, 74, 7, 36, 5, 41, 19, 43, 29, 38}); // Dữ liệu cho Spark Bar Chart
        data.put("sparkLineChart", new int[]{24, 61, 51}); // Dữ liệu cho Sparkline Chart
        data.put("barChart", new float[]{65, 59, 80, 81, 56,  18329997.01f/1000000, 40}); // Dữ liệu cho Bar Chart
        data.put("areaChart", new float[]{65, 59, 80, 81, 56,  18329997.01f/1000000, 40}); // Dữ liệu cho Area Chart

        String json = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
}
