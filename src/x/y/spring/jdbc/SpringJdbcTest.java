package x.y.spring.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import x.y.spring.domain.Account;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = "classpath:applicationContext.xml")
public class SpringJdbcTest {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate template;

    //Jdbc模板的使用类似于DBUtils
    @Test
    public void test1(){
        //默认连接池
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        JdbcTemplate template=new JdbcTemplate(dataSource);
        template.update("insert into account values(null,?,?)","abc",1000.0);
    }

    //将连接词和模板交给spring管理
    @Test
    public void test2(){
        template.update("insert into account values(null,?,?)","bbb",1000.0);
    }

    @Test
    public void test3(){
        template.update("update account set name =?,money=? where id=?","ghi",2000,5);
    }

    @Test
    public void test4(){
        template.update("delete from account where id=?",5);
    }

    @Test
    public void test5(){
        String name=template.queryForObject("select name from account where id=?",String.class,3);
        System.out.println(name);
    }

    @Test
    public void test6(){
        Long count=template.queryForObject("select count(*) from account",Long.class);
        System.out.println(count);
    }

    @Test
    public void test7(){
        Account account=template.queryForObject("select * from account where id =?", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account acc=new Account();
                acc.setId(resultSet.getInt("id"));
                acc.setName(resultSet.getString("name"));
                acc.setMoney(resultSet.getDouble("money"));
                return acc;
            }
        },3);
        System.out.println(account);
    }

    @Test
    public void test8(){
        List<Account> list=template.query("select * from account", new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account acc=new Account();
                acc.setId(resultSet.getInt("id"));
                acc.setName(resultSet.getString("name"));
                acc.setMoney(resultSet.getDouble("money"));
                return acc;
            }
        });
        for (Account account:list){
            System.out.println(account);
        }
    }

    @Test
    public void test9(){

    }
}
