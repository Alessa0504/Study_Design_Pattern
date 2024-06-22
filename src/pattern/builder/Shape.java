package pattern.builder;

/**
 * 桥接模式
 */
public abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public abstract void setShape();
}

class Circle extends Shape {

    public Circle(Color color) {
        super(color);
        color.showColor();
    }

    @Override
    public void setShape() {
        System.out.println("设置为圆形");
    }
}

class Rectangle extends Shape {

    public Rectangle(Color color) {
        super(color);
        color.showColor();
    }

    @Override
    public void setShape() {
        System.out.println("设置为矩形");
    }
}

interface Color {
    void showColor();
}

class Red implements Color {

    @Override
    public void showColor() {
        System.out.println("我是红色");
    }
}

class Blue implements Color {

    @Override
    public void showColor() {
        System.out.println("我是蓝色");
    }
}

class DemoTest {
    public static void main(String[] args) {
        Circle redCircle = new Circle(new Red());
        redCircle.setShape();
        Rectangle blueRectangle = new Rectangle(new Blue());
        blueRectangle.setShape();
    }
}
