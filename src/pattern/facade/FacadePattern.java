package pattern.facade;

/**
 * 外观模式
 */
public class FacadePattern {
    public void autoCooking() {   //利用外观模式封装4个做菜步骤
        new FirstProcessor().boilWater();
        new SecondProcessor().washing();
        new ThirdProcessor().cutting();
        new ForthProcessor().cooking();
        System.out.println("菜做好了");
    }
}

class FirstProcessor {
    public void boilWater() {
        System.out.println("第1步：煮水");
    }
}

class SecondProcessor {
    public void washing() {
        System.out.println("第2步：洗菜");
    }
}

class ThirdProcessor {
    public void cutting() {
        System.out.println("第3步：切菜");
    }
}

class ForthProcessor {
    public void cooking() {
        System.out.println("第4步：烹饪");
    }
}

class Demo {
    public static void main(String[] args) {
//        new FirstProcessor().boilWater();
//        new SecondProcessor().washing();
//        new ThirdProcessor().cutting();
//        new ForthProcessor().cooking();
//        System.out.println("菜做好了");
        new FacadePattern().autoCooking();
    }
}