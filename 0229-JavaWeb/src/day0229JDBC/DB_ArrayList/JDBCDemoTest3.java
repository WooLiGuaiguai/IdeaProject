package day0229JDBC.DB_ArrayList;

import day0229JDBC.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemoTest3 {
    public static void main(String[] args) {
        System.out.println(new JDBCDemoTest3().findAll());
    }
    public List<Emp> findAll(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<Emp> list=new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/db1?" +
                    "useSSL=false&serverTimezone=CTT","root","732cui");
            statement= connection.createStatement();
            String sqlone="SELECT * FROM emp";
            resultSet= statement.executeQuery(sqlone);
            Emp emp=null;
            while(resultSet.next()){
                emp=new Emp();
                emp.setId(resultSet.getInt(1));
                emp.setEname(resultSet.getString(2));
                emp.setJob_id(resultSet.getInt("job_id"));
                emp.setMgr(resultSet.getInt("mgr"));
                emp.setJoindate(resultSet.getDate(5));
                emp.setSalary(resultSet.getDouble(6));
                emp.setBonus(resultSet.getDouble("bonus"));
                emp.setDept_id(resultSet.getInt(8));
                list.add(emp);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
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
        return list;
    }
}
