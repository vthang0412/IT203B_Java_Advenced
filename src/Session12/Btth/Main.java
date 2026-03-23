package Session12.Btth;

import Session12.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try (Connection con = DatabaseConnection.openConnection()) {
            String sql = "insert into doctors value (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
           for (int i = 1; i < 2; i++) {
               System.out.println("Nhập mã bác sĩ:");
               ps.setString(1, sc.nextLine());
               System.out.println("Nhập tên bác sĩ:");
               ps.setString(2, sc.nextLine());
               System.out.println("Nhập giới tính bác sĩ:");
               ps.setString(3, sc.nextLine());
               System.out.println("Nhập tuổi:");
               ps.setInt(4, Integer.parseInt(sc.nextLine()));
               System.out.println("Nhập khoa:");
               ps.setString(5, sc.nextLine());
               int row = ps.executeUpdate();
               ps.clearParameters();
               System.out.println(row);
           }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
