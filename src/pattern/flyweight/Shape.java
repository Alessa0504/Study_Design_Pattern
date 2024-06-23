package pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 享元模式
 */
public interface Shape {
    void show();
}

class ConcreteShape implements Shape {
    String key;

    public ConcreteShape(String key) {
        this.key = key;
        System.out.println(key + "被创建了");
    }

    @Override
    public void show() {
        System.out.println("key:" + key + "的show方法被调用");
    }
}

class FlyWeightFactory {
    private Map<String, Shape> map = new HashMap<>();

    public Shape getObject(String key) {
        Shape shape = map.get(key);
        if (shape == null) {   //为空则创建对象,放入map
            Shape concreteShape = new ConcreteShape(key);
            map.put(key, concreteShape);
            return concreteShape;
        } else {
            System.out.println(key + "在工厂中找到了，不需要被创建");
        }
        return shape;   //上一次已经创建出来的对象
    }
}

class Demo {
    public static void main(String[] args) {
        FlyWeightFactory flyWeightFactory = new FlyWeightFactory();
        Shape circle1 = flyWeightFactory.getObject("circle");
        Shape circle2 = flyWeightFactory.getObject("circle");
        Shape square1 = flyWeightFactory.getObject("square");
        Shape square2 = flyWeightFactory.getObject("square");
    }
}
