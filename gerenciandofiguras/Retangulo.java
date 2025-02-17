public class Retangulo extends Shape {
    private Ponto2D p1;
    private Ponto2D p2;

    public Retangulo(Ponto2D a, Ponto2D b) {
        this.p1 = a;
        this.p2 = b;
    }

    public Ponto2D infEsq() {
        return p1;
    }

    public Ponto2D supDir() {
        return p2;
    }

    @Override
    public double area() {
        double base = Math.abs(p2.x - p1.x);
        double altura = Math.abs(p2.y - p1.y);
        return base * altura;
    }

    @Override
    public double getPerimeter() {
        double base = Math.abs(p2.x - p1.x);
        double altura = Math.abs(p2.y - p1.y);
        return 2 * (base + altura);
    }

    @Override
    public boolean inside(Ponto2D point) {
        return (point.x >= p1.x && point.x <= p2.x) &&
               (point.y >= p1.y && point.y <= p2.y);
    }

    @Override
    public String toString() {
        return "Retângulo com cantos (" + p1.x + "," + p1.y + ") e (" + p2.x + "," + p2.y + ")";
    }
}
