package pattern.decorator;

/**
 * 装饰器模式：不改变原来的类，动态地增加功能
 */
public interface Shape {
    void draw();
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("矩形的draw方法被调用");
    }
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("圆形的draw方法被调用");
    }
}

class RedColorDecorator extends ShapeDecorator {

    public RedColorDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setColor("红色");   //不改变原来的类，动态地增加功能
    }

    private void setColor(String color) {
        System.out.println("设置颜色为" + color);
    }
}

class BlueColorDecorator extends ShapeDecorator {
    public BlueColorDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        setColor("蓝色");
    }

    private void setColor(String color) {
        System.out.println("设置颜色为" + color);
    }
}

class Demo {
    public static void main(String[] args) {
        RedColorDecorator redColorDecorator = new RedColorDecorator(new Circle());
        redColorDecorator.draw();
    }
}