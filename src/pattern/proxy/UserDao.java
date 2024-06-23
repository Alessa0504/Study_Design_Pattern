package pattern.proxy;

public interface UserDao {
    void show();
}

class UserDaoImpl implements UserDao {
    @Override
    public void show() {
        System.out.println("我要租房");
    }
}

class UserProxy implements UserDao {
    UserDaoImpl userDao;

    public UserProxy(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    @Override
    public void show() {
        //代理类做前后增强
        preHandle();
        userDao.show();
        postHandle();
    }

    private void preHandle() {
        System.out.println("前增强，看房");
    }

    private void postHandle() {
        System.out.println("后增强，收中介费");
    }
}

class Demo {
    public static void main(String[] args) {
        UserProxy userProxy = new UserProxy(new UserDaoImpl());   //代理对象
        userProxy.show();
    }
}


