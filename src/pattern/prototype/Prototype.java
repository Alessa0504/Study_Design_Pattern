package pattern.prototype;

import java.io.*;

/**
 * 原型模式
 */
public class Prototype {
}

//1.浅克隆：数据类型为普通数据类型，多个拷贝指向同一个内存地址，改变一个会改变所有
class Wife implements Cloneable {
    private int age = 20;
    private int height = 165;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Wife{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }

    @Override
    protected Wife clone() throws CloneNotSupportedException {
        return (Wife)super.clone();   //super.clone()默认是浅克隆
    }
}

//2.深克隆：当数据类型为引用类型时，需要拷贝出不同的对象存在不同的内存地址，改变一个不影响其他
class Param implements Serializable {   //注意实现Serializable
    private int age = 20;
    private int height = 165;

    public Param(int age, int height) {
        this.age = age;
        this.height = height;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Param{" +
                "age=" + age +
                ", height=" + height +
                '}';
    }
}

class WifeTwo implements Serializable, Cloneable { //注意实现Serializable
    private Param param;

    public WifeTwo(Param param) {
        this.param = param;
    }

    public Param getParam() {
        return param;
    }

    @Override
    public String toString() {
        return "WifeTwo{" +
                "param=" + param +
                '}';
    }

    @Override
    protected WifeTwo clone() throws CloneNotSupportedException {
        //===浅拷贝
//        return (WifeTwo)super.clone();
        //===深拷贝
        //用流的方式写深克隆
        WifeTwo clone = (WifeTwo)super.clone();
        try {
            //1.把对象写入到字节流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
            objectOutputStream.writeObject(clone);
            //2.从流里面读取出对象
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream objectInputStream = new ObjectInputStream(bais);
            WifeTwo o = (WifeTwo)objectInputStream.readObject();
            //3.返回对象
            return o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Demo {
    public static void main(String[] args) throws CloneNotSupportedException {
        //测试浅克隆
        Wife wife = new Wife();
        Wife wife1 = wife.clone();
        Wife wife2 = wife.clone();
        Wife wife3 = wife.clone();
        Wife wife4 = wife.clone();
        System.out.println(wife1);
        System.out.println(wife2);
        System.out.println(wife3);
        System.out.println(wife4);

        //测试深克隆
        WifeTwo wifeTwo = new WifeTwo(new Param(18, 160));
        WifeTwo wifeTwo1 = wifeTwo.clone();
        WifeTwo wifeTwo2 = wifeTwo.clone();
        WifeTwo wifeTwo3 = wifeTwo.clone();
        WifeTwo wifeTwo4 = wifeTwo.clone();
        wifeTwo2.getParam().setAge(30);   //浅拷贝改变一个(wifeTwo2)会改变其他(wifeTwo1, wifeTwo2, wifeTwo3, wifeTwo4)；深拷贝则只有wifeTwo2的age会 改变为30
        System.out.println(wifeTwo1);
        System.out.println(wifeTwo2);
        System.out.println(wifeTwo3);
        System.out.println(wifeTwo4);
    }
}
