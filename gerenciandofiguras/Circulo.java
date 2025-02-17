public class Circulo extends Shape {
    private Ponto2D centro;
    private double raio;

    public Circulo(Ponto2D centro, double raio) {
        this.centro = centro;
        this.raio = raio;
    }

    public Ponto2D centro() {
        return centro;
    }

    public double raio() {
        return raio;
    }

    @Override
    public double area() {
        return Math.PI * raio * raio;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * raio;
    }

    @Override
    public boolean inside(Ponto2D point) {
        double dx = point.x - centro.x;
        double dy = point.y - centro.y;
        return Math.sqrt(dx * dx + dy * dy) <= raio;
    }

    @Override
    public String toString() {
        return "Círculo com centro em (" + centro.x + "," + centro.y + ") e raio " + raio;
    }
}
