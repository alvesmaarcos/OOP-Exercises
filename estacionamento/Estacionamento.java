import java.util.*;
class Estacionamento {
    private ArrayList<Veiculo> veiculos;
    private int horaAtual;

    public Estacionamento() {
        horaAtual = 0;
        veiculos = new ArrayList<>();
    }

    private int procurarVeiculo(String id) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void estacionar(Veiculo veiculo) {
        veiculo.setEntrada(horaAtual);
        veiculos.add(veiculo);
    }

    public void pagar(String id) {
        int index = procurarVeiculo(id);
        if (index == -1) {
            System.out.println("fail: veículo não encontrado");
            return;
        }
        Veiculo veiculo = veiculos.get(index);
        veiculo.calculaValor(horaAtual);
        System.out.println(veiculo.getPagamentoInfo());
    }

    public void sair(String id) {
        int index = procurarVeiculo(id);
        if (index == -1) {
            System.out.println("fail: veículo não encontrado");
            return;
        }
        veiculos.remove(index);
    }

    public void passarTempo(int tempo) {
        horaAtual += tempo;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Veiculo vei : veiculos) {
            sb.append(vei.toString()).append("\n");
        }
        sb.append("Hora atual: ").append(horaAtual);
        return sb.toString();
    }
}