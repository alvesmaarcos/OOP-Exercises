public class Espiral {
    private String name;
    private int qtd;
    private double preco;

    // Construtor
    public Espiral(String name, int qtd, double preco) {
        this.name = name;
        this.qtd = qtd;
        this.preco = preco;
    }

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("[%8s : %d U : %.2f RS]", name, qtd, preco);
    }
}
