package tech.echoing.bigdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrestoJdbcTest {

    public static final String URL = "jdbc:presto://10.20.221.242:9090/hive/hudi_ods";
    public static final String USER = "datadqc";
    public static final String PASSWORD = null;

    public static void main(String[] args) throws Exception {

        Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery("SELECT * FROM ods_category LIMIT 100");

        while (rs.next()) {
            System.out.println("id:" + rs.getLong("id"));
        }
    }

}
