package bean.factory;

import ioc.overview.domian.User;

/**
 * {@link ioc.overview.domian.User} 工厂类
 */
public interface UserFactory {
    default User createUser() {
        return User.createUser();
    }

    void initUserFactory();
    void doDestroy();
}
