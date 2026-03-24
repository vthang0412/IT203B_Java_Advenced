package Session13.Btth;

import Session13.utils.DataConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class DemoBtth {
    public static void main(String[] args) {
        Connection conn = DataConnect.openConnection();
        try {
            conn.setAutoCommit(false);

            int patientId = 101;
            double amount = 5000000;

            String sqlInvoice = "insert into invoices(patient_id, amount, created_date) values (?,?,?)";
            String sqlPatients = "update patients set status = ? where id = ?";
            String sqlBeds = "update beds set status = ? where patient_id = ?";

            PreparedStatement psInvoice = conn.prepareStatement(sqlInvoice);
            psInvoice.setInt(1, patientId);
            psInvoice.setDouble(2, amount);
            psInvoice.setTimestamp(3, new Timestamp(System.currentTimeMillis()));

            PreparedStatement psPatients = conn.prepareStatement(sqlPatients);
            psPatients.setString(1, "ĐÃ XUẤT VIỆN");
            psPatients.setInt(2, patientId);

            PreparedStatement psBeds = conn.prepareStatement(sqlBeds);
            psBeds.setString(1, "TRỐNG");
            psBeds.setInt(2, patientId);

            psInvoice.executeUpdate();
            psPatients.executeUpdate();
            psBeds.executeUpdate();

            conn.commit();
            System.out.println("Xuất viện thành công");

        } catch (SQLException e) {
            try {
                conn.rollback();
                System.out.println("Rollback do lỗi");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.err.println(e.getMessage());
        } finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}