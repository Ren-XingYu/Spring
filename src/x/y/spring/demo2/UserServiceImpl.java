package x.y.spring.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "newUserService")
public class UserServiceImpl implements UserService {
    //@Autowired
    //@Qualifier("userDao")   //Autowired默认按照类型注入，如果加上@Qualifier("userDao")就强制按照名称来注入了
    @Resource(name = "userDao") //按照名称完成属性注入，可以替代@Autowired+@Qualifier
    private UserDao userDao;

    @Override
    public void save() {
        userDao.save();
    }
}
