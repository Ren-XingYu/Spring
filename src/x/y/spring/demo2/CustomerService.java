package x.y.spring.demo2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service("customerService")
@Scope("singleton") //作用范围
public class CustomerService {
    @PostConstruct  //相当于init-method
    public void init(){
        System.out.println("init");
    }

    public void save(){
        System.out.println("save");
    }
    @PreDestroy //相当于destroy-method
    public void destroy(){
        System.out.println("destroy");
    }
}
