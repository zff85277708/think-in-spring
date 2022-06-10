package bean.definition;

import ioc.overview.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean别名示例
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        //配置XML配置文件
        //启动Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/bean-definiations-context.xml");

        //通过别名Jack-user获取user的Bean
        User user = beanFactory.getBean("user", User.class);
        User jack = beanFactory.getBean("Jack-user", User.class);
        System.out.println(user == jack);
    }
}
