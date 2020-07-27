package day0229JDBC.JDBCTemplate;

import day0229JDBC.utilTest.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDemo1 {
    public static void main(String[] args) {
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataS());
        String sql="update user set PASSWORD = ? where id=?";
        int count=template.update(sql,"JJBB",2);
        System.out.println(count);
    }
}
