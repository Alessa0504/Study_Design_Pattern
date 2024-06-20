package pattern.singleton;

/**
 * 单例模式：懒汉式，在声明时不赋值
 */
public class LazySingleton {
    private static volatile LazySingleton lazySingleton;  //volatile防止指令重排序后返回lazySingleton空指针的问题

    private LazySingleton() {

    }

    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {   //双重锁检查
                    lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }
}
