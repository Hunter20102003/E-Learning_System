
import Dal.DashboardDAO;
import Model.DashBoardPaymentDBO;
import Model.IncomeManagerDBO;
import Model.UserDBO;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author buiqu
 */
public class NewClass {
     public Double TotalPriceYear(String year, String userid) {
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllIncomeManager(year, userid);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }
       public Double TotalPriceMonthYear(String year,String month ,String userid) {
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllIncomeManager(year,month, userid);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }

    public Double TotalPrice(String year) {
        DashboardDAO db = new DashboardDAO();
        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByYear(year);
        double total = 0.0;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        return total;
    }
    public static void main(String[] args) {
        Dal.DashboardDAO db = new DashboardDAO();
        String year = "2024";
       
        if (year == null) {
            year = "2024";
        }
NewClass nc = new NewClass();
     
        double total = nc.TotalPrice(year);
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        DecimalFormat df = new DecimalFormat("#,###", symbols); // Định dạng số với phân tách nhóm là dấu chấm
        String formattedNumber = df.format(total);
        
       String Manager_total ;
        List<UserDBO> Manager = db.getAllUser();
        double[] amount = new double[12];
        List<IncomeManagerDBO> Manager_payment = new ArrayList<>();
for (UserDBO manager : Manager) {
    List<Double> amountList = new ArrayList<>();
    for (int i = 0; i < 12; i++) {
        amountList.add(nc.TotalPriceMonthYear(year, String.valueOf(i + 1), manager.getId() + "")/1000000); // Chia cho 1000 nếu cần
    }
    String managerTotal = df.format(nc.TotalPriceYear(year, manager.getId() + ""));
    Manager_payment.add(new IncomeManagerDBO(manager.getId() + "", manager.getUsername(), manager.getEmail(), amountList, managerTotal));
}

        System.err.println(Manager_payment);
               LocalDate currentDate = LocalDate.now();

        // Lấy năm hiện tại
        int currentYear = currentDate.getYear();

        // Lấy tháng hiện tại
        int currentMonth = currentDate.getMonthValue();

        // Lấy ngày hiện tại
        int currentDay = currentDate.getDayOfMonth();

        // Hiển thị ngày, tháng, năm hiện tại
        System.out.println("Ngày hiện tại: " + currentDay);
        System.out.println("Tháng hiện tại: " + currentMonth);
        System.out.println("Năm hiện tại: " + currentYear);
    }
    
    
    
}
