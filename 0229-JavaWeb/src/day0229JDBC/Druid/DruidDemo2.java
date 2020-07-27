package day0229JDBC.Druid;

import day0229JDBC.utilTest.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        /*添加一条记录*/
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try {
            //获取连接
            connection=JDBCUtils.getConn();
            //定义sql
            String sql="insert into user values(null,?,?)";
            //获取pstmt对象
            preparedStatement= connection.prepareStatement(sql);
            //设置具体的值
            preparedStatement.setString(1,"迪丽热巴");
            preparedStatement.setString(2,"xxxooo");
            //运行sql语句
            int count =preparedStatement.executeUpdate();
            System.out.println(count);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            JDBCUtils.close(preparedStatement,connection);
        }
    }
}
