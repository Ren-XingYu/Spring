package x.y.spring.demo2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component(value = "userDao")
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    //使用注解设置属性值，可以没有set方法，如果提供set方法，注解要加在set方法上，如果不提供，注解加在属性上
    @Value("xyz")
    private String name;
    @Override
    public void save() {
        System.out.println("UserDaoImpl执行了..."+name);
    }
}
