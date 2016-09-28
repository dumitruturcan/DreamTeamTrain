package dturcan;
import java.sql.*;

/**
 * Created by dturcan on 9/28/2016.
 */
public class main {


    public static void main(String[] args) {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlserver://MDCH-QA-TRAIN2;user=sa;password=MDCH-TRAIN2SA;database=Sales");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("test");
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sql = "select * from Categories";
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                try {
                    System.out.println(resultSet.getString("Description"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
