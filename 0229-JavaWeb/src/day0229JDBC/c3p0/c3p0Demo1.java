package day0229JDBC.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class c3p0Demo1 {
    public static void main(String[] args) throws SQLException {
        //判断是否最多有是个连接对象
        //不传参数  使用默认配置，否则使用指定名称配置的连接池
        DataSource ds=new ComboPooledDataSource();
        for (int i = 0; i < 10; i++) {
            Connection connection=ds.getConnection();
            System.out.println(i+"  "+connection);//验证最大连接数生效
            if(i==5)
                connection.close();//归还连接到连接池  验证生效
        }
    }
}
