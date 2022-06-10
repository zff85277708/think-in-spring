package bean.definition;

import ioc.overview.domian.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * BeanDefinition构建示例
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        //1.通过BeanDefinitionBuilder
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        //通过属性设置
        builder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "Jack");
        //获取BeanDefinition实例
        BeanDefinition beanDefinition = builder.getBeanDefinition();
        //BeanDefinition并非Bean的终态，可以自定义修改

        //2.通过AbstractBeanDefinition以及派生类
        GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
        //设置Bean类型
        genericBeanDefinition.setBeanClass(User.class);
        //通过MutablePropertyValues批量操作属性
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues
                .add("id", 1L)
                .add("name", "Jack");
        //通过 set MutablePropertyValues批量操作属性
        genericBeanDefinition.setPropertyValues(propertyValues);
    }
}
