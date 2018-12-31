package x.y.spring.demo3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class MyAspectAnno {
    @Before(value = "execution(* x.y.spring.demo3.OrderDao.save())")
    public void before(){
        System.out.println("前置通知...");
    }

    @AfterReturning(value = "execution(* x.y.spring.demo3.OrderDao.delete())",returning = "result")
    public void afterReturning(Object result){
        System.out.println("后置通知..."+result);
    }

    @Around(value = "execution(* x.y.spring.demo3.OrderDao.update())")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知增强前...");
        Object obj=joinPoint.proceed();
        System.out.println("环绕通知增强后...");
        return obj;
    }
    @AfterThrowing(value ="execution(* x.y.spring.demo3.OrderDao.find())",throwing = "ex")
    public void afterThrowing(Throwable ex){
        System.out.println("异常抛出通知..."+ex.getMessage());
    }

    //@After(value ="execution(* x.y.spring.demo3.OrderDao.find())")
    @After(value = "MyAspectAnno.pointcut1()") //等同于上面那行
    public void after(){
        System.out.println("最终通知");
    }

    //切入点注解，维护方便
    @Pointcut(value = "execution(* x.y.spring.demo3.OrderDao.find())")
    private void pointcut1(){}
}
