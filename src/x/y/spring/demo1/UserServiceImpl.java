package x.y.spring.demo1;

public class UserServiceImpl implements UserService {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setup(){
        System.out.println("init");
    }

    public void destroy(){
        System.out.println("destroy");
    }

    @Override
    public void save() {
        System.out.println("UserServiceImpl执行了..."+name);
    }
}
