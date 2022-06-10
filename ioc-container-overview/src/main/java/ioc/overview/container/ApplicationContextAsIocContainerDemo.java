package ioc.overview.container;

import ioc.overview.domian.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * ApplicationContext作为IoC容器示例
 */
public class ApplicationContextAsIocContainerDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //将当前类ApplicationContextAsIocContainerDemo作为配置类（Configuration Class）
        applicationContext.register(ApplicationContextAsIocContainerDemo.class);
        //启动应用上下文
        applicationContext.refresh();
        //依赖查找集合对象
        lookupCollectionByType(applicationContext);
    }

    /**
     * 通过Java注解的方式，定义了一个Bean
     */
    @Bean
    public User user() {
        User user = new User();
        user.setId(2L);
        user.setName("顾敏");
        return user;
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory) {
            ListableBeanFactory listableBeanFactory = (ListableBeanFactory) beanFactory;
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("查找到的所有的User集合对象：" + users);
        }
    }
}
