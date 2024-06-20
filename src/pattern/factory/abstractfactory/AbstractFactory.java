package pattern.factory.abstractfactory;

/**
 * 抽象工厂模式：可以生产2种即以上产品的产品族
 */
public interface AbstractFactory {
    Phone newPhone();
    Pad newPad();
}

//具体工厂 -苹果工厂，可以生产苹果手机、苹果耳机
class AppleFactory implements AbstractFactory {

    @Override
    public Phone newPhone() {
        return new ApplePhone();
    }

    @Override
    public Pad newPad() {
        return new ApplePad();
    }
}

//具体工厂 -华为工厂，可以生产华为手机、华为耳机
class HuaWeiFactory implements AbstractFactory {

    @Override
    public Phone newPhone() {
        return new HuaWeiPhone();
    }

    @Override
    public Pad newPad() {
        return new HuaWeiPad();
    }
}

interface Phone {
    void show();
}

class ApplePhone implements Phone {

    @Override
    public void show() {
        System.out.println("我是苹果手机");
    }
}

class HuaWeiPhone implements Phone {

    @Override
    public void show() {
        System.out.println("我是华为手机");
    }
}

interface Pad {
    void show();
}

class ApplePad implements Pad {

    @Override
    public void show() {
        System.out.println("我是苹果平板");
    }
}

class HuaWeiPad implements Pad {

    @Override
    public void show() {
        System.out.println("我是华为平板");
    }
}


//客户端测试
class Demo {
    public static void main(String[] args) {
        //生产苹果手机
        AppleFactory appleFactory = new AppleFactory();
        Phone phone = appleFactory.newPhone();
        phone.show();

        //生产华为平板
        HuaWeiFactory huaWeiFactory = new HuaWeiFactory();
        Pad pad = huaWeiFactory.newPad();
        pad.show();
    }
}


