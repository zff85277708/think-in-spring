package bean.definition;

import ioc.overview.domian.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注解BeanDefinition示例
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) //3.通过@Import来进行导入
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration Class（配置类）
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        //通过BeanDefinition注册API实现
        //1.命名Bean的注册方式
        registerUserBeanDefinition(applicationContext, "Jack-user");
        //2.非命名Bean的注册方式
        registerUserBeanDefinition(applicationContext);

        //启动Spring应用上下文
        applicationContext.refresh();
        //按照类型依赖查找
        System.out.println("Config类型的所有Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User类型的所有Beans" + applicationContext.getBeansOfType(User.class));
        //显式的关闭Spring应用上下文
        applicationContext.close();
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("id", 2L)
                .addPropertyValue("name", "Jack");

        //判断如果beanName参数存在时
        if (StringUtils.hasText(beanName)) {
            //注册BeanDefinition
            registry.registerBeanDefinition(beanName, builder.getBeanDefinition());
        } else {
            //非命名Bean的注册方式
            BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    //2.通过@Component方式
    @Component
    public static class Config{
        //1.通过@Bean方式
        /**
         * 通过Java注解的方式，定义了一个Bean
         */
        @Bean(name = {"user", "Tom-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("Tom");
            return user;
        }
    }
}
