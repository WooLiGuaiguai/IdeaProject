package day0229JDBC.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Demo {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        DataSource ds=new ComboPooledDataSource();
        //获取一个连接对象
        Connection connection=ds.getConnection();
        System.out.println(connection);
    }
}
