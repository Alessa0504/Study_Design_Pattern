package pattern.visitor;

/**
 * 访问者模式
 */

//抽象访问者
public interface Visitor {
    double visitKeyBoard(KeyBoard keyBoard);
    double visitMouse(Mouse mouse);
}

//具体访问者-vip客户
class VIPVisitor implements Visitor {
    @Override
    public double visitKeyBoard(KeyBoard keyBoard) {   //不同的访问者调用不同的实现的访问方法
        return keyBoard.price * 0.8;
    }

    @Override
    public double visitMouse(Mouse mouse) {
        return mouse.price * 0.8;
    }
}

//具体访问者-普通客户
class NormalVisitor implements Visitor {
    @Override
    public double visitKeyBoard(KeyBoard keyBoard) {
        return keyBoard.price * 0.9;
    }

    @Override
    public double visitMouse(Mouse mouse) {
        return mouse.price * 0.9;
    }
}

//电脑组件抽象父类，也就是被访问者，提供接收访问者方法
abstract class ComputerPart {
    protected String name;
    protected double price;

    public ComputerPart(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract double accept(Visitor visitor);  //传入访问者
}

//电脑组件实现类
class Mouse extends ComputerPart {

    public Mouse(String name, double price) {
        super(name, price);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitMouse(this);
    }
}

class KeyBoard extends ComputerPart {

    public KeyBoard(String name, double price) {
        super(name, price);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visitKeyBoard(this);
    }
}

class Computer {
    private KeyBoard keyBoard;
    private Mouse mouse;

    public Computer(KeyBoard keyBoard, Mouse mouse) {
        this.keyBoard = keyBoard;
        this.mouse = mouse;
    }

    public double getPrice(Visitor visitor) {
        return visitor.visitKeyBoard(keyBoard) + visitor.visitMouse(mouse);
    }
}

class Demo {
    public static void main(String[] args) {
        KeyBoard keyboard = new KeyBoard("keyboard", 100.0);
        Mouse mouse = new Mouse("mouse", 300.0);
        Computer computer = new Computer(keyboard, mouse);
        System.out.println(computer.getPrice(new VIPVisitor()));
        System.out.println(computer.getPrice(new NormalVisitor()));
    }
}

