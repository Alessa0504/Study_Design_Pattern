package pattern.singleton;

/**
 * 单例模式：饿汉式，直接new instance
 */
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton() {  //私有化构造函数

    }
    public static Singleton getInStance() {
        return instance;
    }
}