package x.y.spring.demo2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring IoC注解开发
 */
public class SpringTest {

    @Test
    public void test1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) context.getBean("userDao");
        userDao.save();
    }

    @Test
    public void test2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService= (UserService) context.getBean("newUserService");
        userService.save();
    }

    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerService service= (CustomerService) context.getBean("customerService");
        service.save();
    }
}
