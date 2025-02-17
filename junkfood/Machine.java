import java.util.ArrayList;

public class Machine {
    private ArrayList<Espiral> espirais;
    private double saldo;

    public Machine(int nespirais) {
        this.espirais = new ArrayList<>();
        for (int i = 0; i < nespirais; i++) {
            espirais.add(new Espiral("empty", 0, 0.0));
        }
        this.saldo = 0.0;
    }

    public Espiral getSlot(int index) {
        if (index >= 0 && index < espirais.size()) {
            return espirais.get(index);
        } else {
            System.out.println("fail: indice nao existe");
            return null;
        }
    }

    public void setSlot(int index, String name, int qtd, double price) {
        if (index >= 0 && index < espirais.size()) {
            espirais.set(index, new Espiral(name, qtd, price));
        } else {
            System.out.println("fail: indice nao existe");
        }
    }

    public void limpar(int index) {
        if (index >= 0 && index < espirais.size()) {
            espirais.set(index, new Espiral("empty", 0, 0.0));
        } else {
            System.out.println("fail: indice nao existe");
        }
    }

    public void inserirDinheiro(double value) {
        saldo += value;
    }

    public double pedirTroco() {
        double troco = saldo;
        saldo = 0.0;
        return troco;
    }

    public void comprar(int index) {
        if (index >= 0 && index < espirais.size()) {
            Espiral slot = espirais.get(index);
            if (slot.getQtd() > 0) {
                if (saldo >= slot.getPreco()) {
                    saldo -= slot.getPreco();
                    slot.setQtd(slot.getQtd() - 1);
                    System.out.println(String.format("voce comprou um %s", slot.getName()));
                } else {
                    System.out.println("fail: saldo insuficiente");
                }
            } else {
                System.out.println("fail: espiral sem produtos");
            }
        } else {
            System.out.println("fail: indice nao existe");
        }
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("saldo: %.2f\n", saldo));
        for (int i = 0; i < espirais.size(); i++) {
            sb.append(i).append(" ").append(espirais.get(i).toString());
            if(i < espirais.size() - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
