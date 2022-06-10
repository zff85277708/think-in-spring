package bean.definition;

import ioc.overview.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean实例化示例
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        //配置XML配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/bean-instantiation-context.xml");
        User user = beanFactory.getBean("user-by-static-method", User.class);
        User user1 = beanFactory.getBean("user-by-instance-method", User.class);
        User user2 = beanFactory.getBean("user-by-factory-method", User.class);
        System.out.println(user + "," + user1 + "," + user2);
        System.out.println(user == user1);
        System.out.println(user2 == user1);
    }
}
