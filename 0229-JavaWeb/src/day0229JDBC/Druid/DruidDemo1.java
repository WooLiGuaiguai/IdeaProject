package day0229JDBC.Druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        //导入jar包
        //定义配置文件
        //加载配置文件
        Properties properties=new Properties();
        //需要注意的是文件名称需要有根目录
        InputStream inputStream= DruidDemo1.class.getClassLoader().getResourceAsStream("day0229JDBC/Druid/druid.properties");
        properties.load(inputStream);
        //获取连接对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        //获取连接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }
}
