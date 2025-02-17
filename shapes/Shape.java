public interface Shape {
    boolean inside(Point2D point);
    double getArea();
    double getPerimeter();
    String getName();
}