package pattern.decorator;

public abstract class ShapeDecorator {
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    public abstract void draw();
}
