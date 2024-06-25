package pattern.state;

/**
 * 状态模式：类似于策略模式，只是实现方法有所不同
 */
public interface State {
    void doAction(Context context);   //Context注入
    void show();
}

class StartState implements State {

    @Override
    public void doAction(Context context) {
        context.setState(this);   //设置为当前context
    }

    @Override
    public void show() {
        System.out.println("当前为开始状态");
    }
}

class EndState implements State {

    @Override
    public void doAction(Context context) {
        context.setState(this);   //设置为当前context
    }

    @Override
    public void show() {
        System.out.println("当前为结束状态");
    }
}

class Context {
    private State state;  //与策略模式不同的是，策略模式new Context时需要传具体的策略类; 而状态模式通过setState方法设置具体状态(策略)

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

class Demo {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        startState.doAction(context);   //里面调用setState
        context.getState().show();

        //修改当前状态为结束状态
        EndState endState = new EndState();
        endState.doAction(context);
        context.getState().show();
    }
}
