package x.y.spring.transaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransactionTest {

    @Resource(name = "accountService1")
    private AccountService service1;

    @Test
    public void test1(){
        service1.transfer("abc","xyz",500.0);
    }
}
