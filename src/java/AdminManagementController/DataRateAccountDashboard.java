/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package AdminManagementController;

import Dal.DashboardDAO;
import Model.DashBoardPaymentDBO;
import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 *
 * @author buiqu
 */
public class DataRateAccountDashboard extends HttpServlet {
   
    private static final long serialVersionUID = 1L;

    public Double TotalPrice(String year, String month) {
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Lấy tham số year từ request
        String yearParam = request.getParameter("year");
        String year = (yearParam != null) ? yearParam : "2024"; // Sử dụng giá trị mặc định nếu không có tham số year

        // Fetch data for all months
        double[] monthlyIncome = new double[12];
        for (int i = 0; i < 12; i++) {
            monthlyIncome[i] = TotalPrice(year, String.valueOf(i + 1))/1000000;
        }

        // Dữ liệu mẫu cho biểu đồ
        Map<String, Object> data = new HashMap<>();
        data.put("totalStudents", 422);
        data.put("newStudents", 357);
        data.put("totalCourse", 547);
        data.put("feesCollection", 3280);
        data.put("sparkBarData", new int[]{33, 22, 68, 54, 8, 30, 74, 7, 36, 5, 41, 19, 43, 29, 38}); // Dữ liệu cho Spark Bar Chart
        data.put("sparkLineChart", new int[]{24, 61, 51}); // Dữ liệu cho Sparkline Chart
        data.put("barChart", monthlyIncome); // Dữ liệu cho Bar Chart
        data.put("areaChart", monthlyIncome); // Dữ liệu cho Area Chart

        String json = new Gson().toJson(data);

        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }
    
    //       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
//       public Double TotalPrice1(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//                       public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }          public Double TotalPrice2(String year, String month) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
//             public Double TotalPrice3(String year) {
//        DashboardDAO db = new DashboardDAO();
//        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear(year, month);
//        double total = 0.0;
//        for (DashBoardPaymentDBO payment : pay_list) {
//            total += payment.getAmount();
//        }
//        return total;
//    }
             
}