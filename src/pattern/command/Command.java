package pattern.command;

/**
 * 命令模式
 */
//抽象命令类
public abstract class Command {
    protected Receiver receiver;   //接收者

    public Command(Receiver receiver) {   //通过构造方法传入Receiver
        this.receiver = receiver;
    }

    public abstract void exec();   //执行方法
}

//具体命令类
class BuySmokeCommand extends Command {

    public BuySmokeCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void exec() {
        System.out.println("发出命令：带包香烟");
        receiver.receive();
    }
}

//接收者
class Receiver {
    public void receive() {
        System.out.println("好的，收到");
    }
}

//调用者
class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }
    public void exec() {
        command.exec();
    }
}

class Demo {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        invoker.setCommand(new BuySmokeCommand(new Receiver()));   //调用者给接收者发消息是通过设置命令
        invoker.exec();
    }
}
