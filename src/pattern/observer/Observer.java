package pattern.observer;

import java.util.ArrayList;
import java.util.List;

public interface Observer {
    void response();
}

//具体观察者1
class ConcreteObserver1 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者1作出反应！");
    }
}

//具体观察者2
class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("具体观察者2作出反应！");
    }
}

class Subject {
    private List<Observer> list = new ArrayList<>();

    public void add(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : list) {
            observer.response();
        }
    }
}

class ConcreteSubject extends Subject {
    public void change() {
        super.notifyObservers();
    }
}

class Demo {
    public static void main(String[] args) {
        ConcreteObserver1 concreteObserver1 = new ConcreteObserver1();
        ConcreteObserver2 concreteObserver2 = new ConcreteObserver2();
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.add(concreteObserver1);
        concreteSubject.add(concreteObserver2);
        concreteSubject.change();
    }
}
