package day0229JDBC.utilTest;

import day0229JDBC.Emp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDEMOTEST {
    public static void main(String[] args) {
        List<Emp> list=new JDBCDEMOTEST().findAll();
        System.out.println(list);
    }
    public List<Emp> findAll(){
        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        List<Emp> list=new ArrayList<>();
        try {
            connection = JDBCUtil.getConnection();
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
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,statement,connection);
        }
        return list;
    }
}
