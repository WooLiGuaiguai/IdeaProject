package day0229JDBC.JDBCTemplate;

import day0229JDBC.Emp;
import day0229JDBC.utilTest.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class JDBCTemplateDemo2 {
    //进行操作前调整数据库为db1 所以将配置文件druid.properties进行修改了
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataS());
    /*          1. 修改1号数据的 salary 为 10000
				2. 添加一条记录
				3. 删除刚才添加的记录
				4. 查询id为1的记录，将其封装为Map集合
				5. 查询所有记录，将其封装为List
				6. 查询所有记录，将其封装为Emp对象的List集合
				7. 查询总记录数*/
    @Test
    public void test1(){
        String sql="update emp set salary = ? where id=?";
        template.update(sql,10000,1001);
    }
    @Test
    public void test2(){
        String sql="INSERT into emp (id,ename,dept_id)VALUES (?,?,?)";
        template.update(sql,1015,"诸葛大力",20);
    }
    @Test
    public void test3(){
        String sql="DELETE  FROM emp where id=?";
        template.update(sql,1015);
    }
    @Test
    public void test4(){
        String sql="select * from emp where id=?";
        Map<String, Object> stringObjectMap = template.queryForMap(sql, 1001);
        System.out.println(stringObjectMap);
    }
    @Test
    public void test5(){
        String sql="select * from emp ";
        List<Map<String, Object>> maps = template.queryForList(sql);
        for(Map<String, Object> map:maps){
            System.out.println(map);
        }
    }
    @Test
    public void test6(){
        String sql="select * from emp ";
        List<Emp> list=template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
                Emp emp=new Emp();
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int job_id = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int dept_id = resultSet.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);
                return emp;
            }
        });
        for(Emp emp:list){
            System.out.println(emp);
        }
    }
    @Test
    public void test6_2(){
        String sql="select * from emp ";
        List<Emp> query = template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for(Emp emp:query){
            System.out.println(emp);
        }
    }
    @Test
    public void test7(){
        String sql="select count(id) from emp ";
        long cou=template.queryForObject(sql,Long.class);
        System.out.println(cou);
    }
}
