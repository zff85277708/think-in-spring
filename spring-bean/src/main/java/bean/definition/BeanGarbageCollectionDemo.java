package bean.definition;

import bean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bean垃圾回收(GC)示例
 */
public class BeanGarbageCollectionDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        //注册Configuration Class（配置类）
        applicationContext.register(BeanInitializationDemo.class);
        //启动Spring应用上下文
        applicationContext.refresh();
        //显式的关闭Spring应用上下文
        applicationContext.close();
        Thread.sleep(5000);
        System.gc();
        Thread.sleep(5000);
    }
}
