public class Rectangle implements Shape {
    private String name = "Rect";
    private Point2D p1;
    private Point2D p2;

    public Rectangle(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        double largura = Math.abs(p1.getX() - p2.getX());
        double altura = Math.abs(p1.getY() - p2.getY());
        return largura * altura;
    }

    public double getPerimeter() {
        double largura = Math.abs(p1.getX() - p2.getX());
        double altura = Math.abs(p1.getY() - p2.getY());
        return 2 * (largura + altura);
    }

    public boolean inside(Point2D point) {
        double minX = Math.min(p1.getX(), p2.getX());
        double maxX = Math.max(p1.getX(), p2.getX());
        double minY = Math.min(p1.getY(), p2.getY());
        double maxY = Math.max(p1.getY(), p2.getY());

        return point.getX() >= minX && point.getX() <= maxX &&
               point.getY() >= minY && point.getY() <= maxY;
    }

    public String toString() {
        return String.format("%s: P1=(%s) P2=(%s)", name, p1, p2);
    }
}
