import Dal.DashboardDAO;
import Model.DashBoardPaymentDBO;
import java.text.DecimalFormat;
import java.util.List;

public class TEST {
    public static void main(String[] args) {
        DashboardDAO db = new DashboardDAO();
        
        List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByYear("2024");
        // List<DashBoardPaymentDBO> pay_list = db.getAllpaymentByMonthAndYear("2024", "01");

        double total = 0.0123232323213;
        for (DashBoardPaymentDBO payment : pay_list) {
            total += payment.getAmount();
        }
        
        // Định dạng số tiền VND với tối đa 2 chữ số thập phân
        DecimalFormat formatter = new DecimalFormat("####.## VND");
        String formattedTotal = formatter.format(total);
        
        System.out.println("Total amount in VND: " + formattedTotal);
    }
}
