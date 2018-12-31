package x.y.spring.transaction;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.annotation.Resource;

/**
 * 可以继承JdbcDaoSupport简化
 */
public class AccountDaoImpl /*extends JdbcDaoSupport*/ implements AccountDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate template;


    @Override
    public void outMoney(String from, Double money) {
        template.update("update account set money=money-money where name =?",from);
    }

    @Override
    public void inMoney(String to, Double money) {
        template.update("update account set money=money+money where name =?",to);
    }
}
