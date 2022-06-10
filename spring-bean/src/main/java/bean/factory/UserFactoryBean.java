package bean.factory;

import ioc.overview.domian.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * User Bean的FactoryBean的实现
 */
public class UserFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
