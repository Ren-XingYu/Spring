# Spring框架架构

![](https://cos-1257663582.cos.ap-chengdu.myqcloud.com/Notes/Spring/spring-overview.png)

# SpringIoC

将对象的创建权反转给(交给)Spring

# SpringIoC底层实现

工厂+反射+配置文件

# Spring DI

前提：必须要有IoC环境  
Spring在管理这个类的时候可以将类依赖的属性注入(设置)进来

# 给Bean中的属性设置值

    构造方法(spring支持)
    set方法(spring支持)
    接口注入(spring不支持)
    
# Spring的IoC注解详解

@Component

    修饰一个类，将这个类交给Spring管理
    这个注解有三个衍生注解（功能类似），修饰类
        @Controller：web层
        @Service：service层
        @Repository：dao层
        
属性注入的注解：

    普通属性：@Value
    对象类型：@Autoware 按照类型来完成属性注入,如果要强制按照名称来完成属性注入，需要再加一个@Qualifier()注解
    对象类型：@Resource，按照名称来完成属性注入，可以替代 @Autoware+@Qualifier
    
其它注解：

    @PostConstruct: 相当于init-method
    @PreDestroy：相当于destroy-method
    @Scope：bean的作用范围  singleton  prototype request session globalSession
        
# AOP

AOP采用横向抽取（动态代理实现）的机制取代传统的纵向继承的机制

    JDK动态代理：只能对实现接口类做代理
    Cglib动态代理：可以对没有实现接口的类产生代理，产生子类对象来实现

AOP可以用来：权限校验、日志记录、性能监控、事务控制

# Spring的AOP的开发（使用AspectJ的XML的方式）

AspectJ：AOP框架

AspectJ术语:

![](https://cos-1257663582.cos.ap-chengdu.myqcloud.com/Notes/Spring/aspectj.jpg)

AspectJ通知

    前置通知
    后置通知：可以获得方法返回值
    环绕通知：可以阻止目标方法的执行
    异常抛出通知
    最终通知：相当于try catch 中的 finally
    
# Spring持久层的模板

    JdbcTemplate
    HibernateTempalte
    SqlMapClientTemplate
    JpdTemplate
 
 # Spring事务管理
 
    编程式事务
    声明式事务(AOP实现)
    
    PlatformTransactionManager：接口，Spring管理事务的真正的对象
        DataSourceTransactionManager：底层事务jdbc管理事务
        HibernateTransactionManager：底层事务hibernate管理事务
    TransactionDefinition：用于定义事务相关信息，隔离级别，超时信息，传播行为
    TransactionStatus:事务状态，用于记录在事务管理过程中，事务的状态的对象
    平台事务管理器通过事务定义来进行事务管理，在进行事务管理过程中产生各种状体，将这些状态保存在事务状态中

事务的传播行为用来解决业务层相互调用的情形(每个业务层都是一个事务)

七种事务传播行为

    两个业务A和B，并B中要调用A
    保证多个操作在同一个事务中
    	PROPAGATION_REQUIRED        ：默认值，如果A中有事务，使用A中的事务，如果A没有，创建一个新的事务，将操作包含进来
    	PROPAGATION_SUPPORTS	    ：支持事务，如果A中有事务，使用A中的事务。如果A没有事务，不使用事务。
    	PROPAGATION_MANDATORY	    ：如果A中有事务，使用A中的事务。如果A没有事务，抛出异常。
    保证多个操作不在同一个事务中
        PROPAGATION_REQUIRES_NEW	：如果A中有事务，将A的事务挂起（暂停），创建新事务，只包含自身操作。如果A中没有事务，创建一个新事务，包含自身操作。
        PROPAGATION_NOT_SUPPORTED	：如果A中有事务，将A的事务挂起。不使用事务管理。
        PROPAGATION_NEVER			：如果A中有事务，报异常。
    嵌套式事务
        PROPAGATION_NESTED			：嵌套事务，如果A中有事务，按照A的事务执行，执行完成后，设置一个保存点，执行B中的操作，如果没有异常，执行通过，如果有异常，可以选择回滚到最初始位置，也可以回滚到保存点。


