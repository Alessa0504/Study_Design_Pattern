package pattern.builder;

//指挥者，指挥构建
public class Director {
    public void build(Builder builder) {   //设计原则：使用接口作为参数
        builder.buildA();
        builder.buildB();
    }
}

//测试类
class Demo {
    public static void main(String[] args) {
        Director director = new Director();
        ConcreteBuilder1 concreteBuilder1 = new ConcreteBuilder1();
        director.build(concreteBuilder1);
        Product product = concreteBuilder1.getProduct();
        product.show();
    }
}

interface Builder {
    void buildA();

    void buildB();

    Product getProduct();
}

//具体构建者1
class ConcreteBuilder1 implements Builder {

    private Product product = new Product();

    @Override
    public void buildA() {
        product.setPartA("碳纤维做的A");
    }

    @Override
    public void buildB() {
        product.setPartB("碳纤维做的B");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}


//具体构建者2
class ConcreteBuilder2 implements Builder {

    private Product product = new Product();

    @Override
    public void buildA() {
        product.setPartA("金子做的A");
    }

    @Override
    public void buildB() {
        product.setPartB("金子做的B");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}


class Product {
    private String partA;
    private String partB;

    public String getPartA() {
        return partA;
    }

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public String getPartB() {
        return partB;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void show() {
        System.out.println("我的组成部件：partA =" + partA + ", partB =" + partB);
    }
}
