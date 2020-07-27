package day0229JDBC.JDBC_verify;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;

public class JDBCDemoTest2 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        ResultSet resultset=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
                    "useSSL=false&serverTimezone=CTT","root","732cui");
            statement= connection.createStatement();
            String sqlone="select * FROM account";
            resultset = statement.executeQuery(sqlone);
            while(resultset.next()){
                System.out.println(resultset.getInt("id")+"     "+resultset.getString("name")+"     "
                        +resultset.getDouble(3));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultset!=null){
                try {
                    resultset.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
