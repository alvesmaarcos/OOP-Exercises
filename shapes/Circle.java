import java.lang.Math;

public class Circle implements Shape{
    private String name = "Circ";
    Point2D center;
    double radius;

    Circle(Point2D center, double radius){
        this.center = center;
        this.radius = radius;
    }
    public boolean inside(Point2D point) {
        return Calc.distance(center, point) <= radius;  // Usando Calc.distance
    }
    public String getName(){
        return name;
    }
    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }
    public double getPerimeter(){
        return 2 * Math.PI * radius;
    }
    public String toString(){
        return String.format("%s: C=(%s), R=%.2f", getName(), center.toString(), radius);
    }

}