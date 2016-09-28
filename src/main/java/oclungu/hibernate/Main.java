package oclungu.hibernate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection("jdbc:sqlserver://MDCH-QA-TRAIN2;user=sa;password=MDCH-TRAIN2SA;database=Sales");
        Statement statement = connection.createStatement();
        String sql = "select * from Categories";
        ResultSet resultSet = statement.executeQuery(sql);
        System.out.println(resultSet.toString());
        while (resultSet.next()) {
            System.out.println(resultSet.getString("CategoryID") + "\t" + resultSet.getString("Description"));
        }

    }

}
