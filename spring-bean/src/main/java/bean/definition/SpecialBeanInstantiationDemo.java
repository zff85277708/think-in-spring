package bean.definition;

import bean.factory.DefaultUserFactory;
import bean.factory.UserFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ServiceLoader;

public class SpecialBeanInstantiationDemo {
    public static void main(String[] args) {
        //配置XML配置文件
        //启动Spring应用上下文
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                "classpath:/META-INF/special-bean-instantiation-context.xml");
        //通过ApplicationContext获取AutowireCapableBeanFactory
        AutowireCapableBeanFactory beanFactory = applicationContext.getAutowireCapableBeanFactory();
//        demoServiceLoader();

        ServiceLoader<UserFactory> serviceLoader =
                beanFactory.getBean("userFactorServiceLoader", ServiceLoader.class);
        displayServiceLoader(serviceLoader);

        //创建UserFactory对象，通过AutowireCapableBeanFactory
        UserFactory userFactory = beanFactory.createBean(DefaultUserFactory.class);
        System.out.println(userFactory.createUser());
    }

//    private static void demoServiceLoader() {
//        ServiceLoader<UserFactory> serviceLoader = ServiceLoader.load(UserFactory.class,
//                Thread.currentThread().getContextClassLoader());
//        displayServiceLoader(serviceLoader);
//    }

    private static void displayServiceLoader(ServiceLoader<UserFactory> serviceLoader) {
        for (UserFactory userFactory : serviceLoader) {
            System.out.println(userFactory.createUser());
        }
    }
}
