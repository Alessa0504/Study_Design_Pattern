package pattern.strategy;

public interface Strategy {
    int operation(int num1, int num2);
}

//具体策略
class AddStrategy implements Strategy {

    @Override
    public int operation(int num1, int num2) {
        return num1 + num2;
    }
}

class SubStrategy implements Strategy {
    @Override
    public int operation(int num1, int num2) {
        return num1 - num2;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {   //传入不同的策略
        this.strategy = strategy;
    }

    public int operation(int num1, int num2) {
        return strategy.operation(num1, num2);
    }
}

class Demo {
    public static void main(String[] args) {
        Context context = new Context(new AddStrategy());
        System.out.println(context.operation(1, 2));
        Context context1 = new Context(new SubStrategy());
        System.out.println(context1.operation(1, 2));
    }
}
