package x.y.spring.demo3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Spring整合JUnit单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SprintTest {

    @Resource(name = "productDao")
    private ProductDao productDao;

    @Resource(name = "orderDao")
    private OrderDao orderDao;

    //xml方式
    @Test
    public void test1(){
        productDao.save();
        productDao.update();
        productDao.delete();
        productDao.find();
    }
    //注解方式
    @Test
    public void test2(){
        orderDao.save();
        orderDao.update();
        orderDao.delete();
        orderDao.find();
    }
}
