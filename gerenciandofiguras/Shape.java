import java.text.DecimalFormat;

public abstract class Shape {
    public abstract double area();
    
    public abstract boolean inside(Ponto2D point);
    
    public abstract double getPerimeter();
    
    public abstract String toString();
}
