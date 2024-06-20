package pattern.factory.normal;

/**
 * 工厂模式
 */

//1.接口
interface Shape {
    void draw();  //定义每个图形的绘制方法
}

//2.具体形状
class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("矩形的 draw方法被调用");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("圆形的 draw方法被调用");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("方形的 draw方法被调用");
    }
}

//3.工厂
class ShapeFactory {
    public static Shape getShape(String type) {
        if (type.equals("矩形")) {
            return new Rectangle();
        } else if (type.equals("圆形")) {
            return new Circle();
        } else if (type.equals("方形")) {
            return new Square();
        } else {
            return null;
        }
    }
}

//客户端测试
 class Demo {
    public static void main(String[] args) {
        Shape shape = ShapeFactory.getShape("矩形");
        shape.draw();
    }
}
