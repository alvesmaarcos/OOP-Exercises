import java.util.Scanner;

public class Shell {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Machine machine = null;

        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            String[] argsSplit = line.split(" ");
            String cmd = argsSplit[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                if (machine != null) {
                    System.out.println(machine.toString());
                } else {
                    System.out.println("fail: maquina nao inicializada");
                }
            } else if (cmd.equals("init")) {
                int qtdEspirais = Integer.parseInt(argsSplit[1]);
                machine = new Machine(qtdEspirais);
            } else if (cmd.equals("limpar")) {
                int indice = Integer.parseInt(argsSplit[1]);
                if (machine != null) {
                    machine.limpar(indice);
                }
            } else if (cmd.equals("dinheiro")) {
                double value = Double.parseDouble(argsSplit[1]);
                if (machine != null) {
                    machine.inserirDinheiro(value);
                }
            } else if (cmd.equals("comprar")) {
                int ind = Integer.parseInt(argsSplit[1]);
                if (machine != null) {
                    machine.comprar(ind);
                }
            } else if (cmd.equals("set")) {
                int indice = Integer.parseInt(argsSplit[1]);
                String nome = argsSplit[2];
                int qtd = Integer.parseInt(argsSplit[3]);
                double preco = Double.parseDouble(argsSplit[4]);
                if (machine != null) {
                    machine.setSlot(indice, nome, qtd, preco);
                }
            } else if (cmd.equals("troco")) {
                if (machine != null) {
                    double troco = machine.pedirTroco();
                    System.out.printf("voce recebeu %.2f RS\n", troco);
                }
            } else {
                System.out.println("comando invalido");
            }
        }
    }
}
