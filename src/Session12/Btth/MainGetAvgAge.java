package Session12.Btth;

import Session12.utils.DatabaseConnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class MainGetAvgAge {
    public static void main(String[] args) {
        try(Connection con = DatabaseConnection.openConnection()){
            CallableStatement callableStatement = con.prepareCall("{call proc_get_avg_age_doctor(?)}");
            callableStatement.registerOutParameter(1, Types.DOUBLE);

            callableStatement.executeQuery();
            Double result = callableStatement.getDouble(1);
            System.out.println(result);
        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
