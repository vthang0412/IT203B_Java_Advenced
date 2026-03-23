package Session12.Btth;

import Session12.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class MainHandleDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào mã bác sĩ muốn xóa:");
        String idDelete = sc.nextLine();
        try (Connection con = DatabaseConnection.openConnection()) {
            CallableStatement callStmt = con.prepareCall("{call proc_delete_doctor_by_id(?)}");
            callStmt.setString(1, idDelete);

            int row = callStmt.executeUpdate();
            System.out.println(row);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
