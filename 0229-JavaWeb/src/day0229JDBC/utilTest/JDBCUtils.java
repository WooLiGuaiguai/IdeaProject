package day0229JDBC.utilTest;
/*适用于 Druid 连接池的 工具类*/
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;
    static {
        try {
            Properties p=new Properties();
            p.load(JDBCUtils.class.getClassLoader().getResourceAsStream("day0229JDBC/Druid/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConn() throws SQLException {
        return ds.getConnection();
    }
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);
    }
    public static void close(ResultSet rs, Statement stmt,Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //获取连接池的方法
    public static DataSource getDataS(){
        return ds;
    }
}
