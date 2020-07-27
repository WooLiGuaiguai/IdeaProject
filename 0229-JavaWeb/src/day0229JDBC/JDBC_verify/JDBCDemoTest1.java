package day0229JDBC.JDBC_verify;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemoTest1 {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
                    "useSSL=false&serverTimezone=CTT","root","732cui");
            statement= connection.createStatement();
            String sqlone="insert into account values(null,'迪迦',3000)";
            int i = statement.executeUpdate(sqlone);
            System.out.println(i);
            if(i>0){
                System.out.println("添加成功");}
                else{
                System.out.println("添加失败");}
            String sqltwo="update account set balance=5000 where id=3";
            int j = statement.executeUpdate(sqltwo);
            System.out.println(j);
            if(j>0){
                System.out.println("更新成功");}
            else{
                System.out.println("更新失败");}
            String sqlthree="delete from account where id=4";
            int k = statement.executeUpdate(sqlthree);
            System.out.println(k);
            if(k>0){
                System.out.println("删除成功");}
            else{
                System.out.println("删除失败");}
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
