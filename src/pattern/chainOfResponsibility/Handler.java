package pattern.chainOfResponsibility;

/**
 * 责任链模式
 */
//抽象处理器类
public abstract class Handler {

    private Handler next;   //链式：next指针

    public Handler getNext() {
        return next;
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    public abstract void handleRequest(String request);
}

//具体处理器类1
class ConcreteHandlerOne extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("one")) {
            System.out.println("请求1可以被处理！");
        } else {
            Handler next = getNext();
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("链条走到尽头了，也没找到可以处理的处理器");
            }
        }
    }
}

//具体处理器类2
class ConcreteHandlerTwo extends Handler {
    @Override
    public void handleRequest(String request) {
        if (request.equals("two")) {
            System.out.println("请求2可以被处理！");
        } else {
            Handler next = getNext();
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("链条走到尽头了，也没找到可以处理的处理器");
            }
        }
    }
}

class Demo {
    public static void main(String[] args) {
        ConcreteHandlerOne concreteHandlerOne = new ConcreteHandlerOne();
        ConcreteHandlerTwo concreteHandlerTwo = new ConcreteHandlerTwo();
        concreteHandlerOne.setNext(concreteHandlerTwo);
        concreteHandlerOne.handleRequest("two");   //用处理器1处理"two"，但得到的是：请求2可以被处理！
        concreteHandlerOne.handleRequest("three");  //链条走到尽头了，也没找到可以处理的处理器
    }
}





