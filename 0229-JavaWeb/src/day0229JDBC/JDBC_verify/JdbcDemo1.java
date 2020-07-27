package day0229JDBC.JDBC_verify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
                "useSSL=false&serverTimezone=CTT","root","732cui");
        String sql="update account set balance = 1500 ";
        Statement statement = connection.createStatement();
        int count=statement.executeUpdate(sql);
        System.out.println(count);



        statement.close();
        connection.close();

    }
}
