package Session13.Btth;

import Session13.utils.DataConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {
    public static void main(String[] args) {
        Connection conn = DataConnect.openConnection();
        try {
            conn.setAutoCommit(false);
            String sqlWithdraw = "update accounts set balance = balance - ? where id = ?";
            String sqlTransfer = "insert into transfer (sender_id,receive_id,amount,message,transfer_date) values (?,?,?,?,?)";
            String sqlDeposit = "update accounts set balance = balance + ? where id = ?";
            double amount = 9000000.0;
            int senderId = 1;
            int receiverId = 2;
            PreparedStatement preparedWithdraw = conn.prepareStatement(sqlWithdraw);
            preparedWithdraw.setDouble(1,amount);
            preparedWithdraw.setInt(2,senderId);
            PreparedStatement preparedTransfer = conn.prepareStatement(sqlTransfer);
            preparedTransfer.setInt (1, senderId);
            preparedTransfer.setInt (2, receiverId);
            preparedTransfer.setDouble(3,amount);
            preparedTransfer.setString(4,"heheboi");
            preparedTransfer.setTimestamp(5,new Timestamp(System.currentTimeMillis()));
            PreparedStatement preparedDeposit = conn.prepareStatement(sqlDeposit);
            preparedDeposit.setDouble(1,amount);
            preparedDeposit.setInt(2,receiverId);

            preparedWithdraw.executeUpdate();
            preparedTransfer.executeUpdate();
            preparedDeposit.executeUpdate();

            conn.commit();
        }catch (SQLException e){
            try {
                conn.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            System.err.println(e.getMessage());
        }finally {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
