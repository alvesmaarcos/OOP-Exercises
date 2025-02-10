import java.util.*;
import java.text.DecimalFormat;

abstract class Veiculo {
    private String id;
    protected String tipo;
    protected int horaEntrada;
    protected int horaSaida;
    protected double calculoSaida;

    public Veiculo(String id, String tipo) {
        this.id = id;
        this.tipo = tipo;
        this.horaEntrada = 0;
        this.horaSaida = 0;
        this.calculoSaida = 0;
    }

    public void setEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getEntrada() {
        return horaEntrada;
    }

    public String getTipo() {
        return tipo;
    }

    public String getId() {
        return id;
    }

    public void calculaValor(int horaSaida) {
        this.horaSaida = horaSaida;
    }

    public String getPagamentoInfo() {
        DecimalFormat df = new DecimalFormat("0.00");
        return tipo.substring(0, 1).toUpperCase() + tipo.substring(1) +
               " chegou " + horaEntrada + " saiu " + horaSaida + ". Pagar R$ " + df.format(calculoSaida);
    }
}

class Moto extends Veiculo {
    public Moto(String id) {
        super(id, "moto");
    }

    @Override
    public void calculaValor(int horaSaida) {
        super.calculaValor(horaSaida);
        calculoSaida = Math.abs((getEntrada() - horaSaida) / 20);
    }

    public String toString() {
        return "______Moto : ___" + getId() + " : " + getEntrada();
    }
}

class Bike extends Veiculo {
    public Bike(String id) {
        super(id, "bike");
    }

    @Override
    public void calculaValor(int horaSaida) {
        super.calculaValor(horaSaida);
        calculoSaida = 3;
    }

    public String toString() {
        return "______Bike : _____" + getId() + " : " + getEntrada();
    }
}

class Carro extends Veiculo {
    public Carro(String id) {
        super(id, "carro");
    }

    @Override
    public void calculaValor(int horaSaida) {
        super.calculaValor(horaSaida);
        calculoSaida = Math.abs((getEntrada() - horaSaida) / 10);
        if(calculoSaida < 5){
            calculoSaida = 5;
        }
    }

    public String toString() {
        return "_____Carro : ___" + getId() + " : " + getEntrada();
    }
}