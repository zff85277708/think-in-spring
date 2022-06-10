package ioc.overview.dependency.injection;

import ioc.overview.annotation.Super;
import ioc.overview.domian.User;
import ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.Environment;

import java.util.Map;

/**
 * 依赖注入示例
 */
public class DenpendencyInjectionDemo {
    public static void main(String[] args) {
        //配置XML配置文件
        //启动Spring应用上下文
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
//                "classpath:/META-INF/denpendency-injection-context.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/denpendency-injection-context.xml");

        //依赖来源一：自定义的Bean
        UserRepository users = applicationContext.getBean("userRepository", UserRepository.class);
//        System.out.println(users.getUsers());

        //依赖来源二：依赖注入（内建依赖）
        System.out.println(users.getBeanFactory());

        //依赖查找(错误)
//        System.out.println(beanFactory.getBean(BeanFactory.class));

        ObjectFactory userFactory = users.getUserObjectFactory();
        System.out.println(userFactory.getObject() == applicationContext);

        //依赖来源三：容器内建Bean
        Environment environment = applicationContext.getBean(Environment.class);
        System.out.println("获取Environment类型的Bean: " + environment);

        whoIsIocContainer(users, applicationContext);
    }

    private static void whoIsIocContainer(UserRepository users, ApplicationContext applicationContext) {
        //ConfigurableApplicationContext <- ApplicationContext <- BeanFactory
        //ConfigurableApplicationContext#getBeanFactory()

        System.out.println(applicationContext);
        System.out.println(users.getBeanFactory());
        //这个表达式为什么不成立
        System.out.println(users.getBeanFactory() == applicationContext);

        //ApplicationContext is BeanFactory
    }
}
