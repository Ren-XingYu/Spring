package x.y.spring.demo1;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    //传统方式
    @Test
    public void test1(){
        UserService userService=new UserServiceImpl();
        userService.save();
    }

    //Spring方式
    @Test
    public void test2(){
        //创建工厂
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service= (UserService) context.getBean("userService");
        service.save();
    }
    //构造方法注入属性
    @Test
    public void test3(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Car car= (Car) context.getBean("car");
        System.out.println(car);
    }

    //set方法属性注入
    @Test
    public void test4(){
        //可变参数,可以传入多个配置文件
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee= (Employee) context.getBean("employee");
        System.out.println(employee);
    }

    //数组类型注入
    @Test
    public void test5(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        CollectionBean collectionBean= (CollectionBean) context.getBean("collectionBean");
        System.out.println(collectionBean);
    }
}
