import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;

class Pessoa {
    
    private String nome;

    public Pessoa(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String toString(){
        return String.format(this.nome);
    }

}






class Market {
    private ArrayList<Pessoa> caixas;
    private LinkedList<Pessoa> fila;

    Market(int qtdCaixas){
        this.caixas = new ArrayList<Pessoa>();
        this.fila = new LinkedList<Pessoa>();
        for(int i = 0; i < qtdCaixas; i++){
            this.caixas.add(null);
        }
    }

    public void arrive(Pessoa p){
        fila.addLast(p);
    }

    public boolean chamarNoCaixa(int indice){
        if(fila.size() == 0){
            System.out.println("fail: sem clientes");
            return false;
        }
        if(caixas.get(indice) != null){
            System.out.println("fail: caixa ocupado");
            return false;
        }
        caixas.set(indice, fila.removeFirst());
        return true;
    
        
    }

    public Pessoa finalizarAtendimento(int indice){
        if(indice >= caixas.size()){
            System.out.println("fail: caixa inexistente");
            return null;
        }
        if(caixas.get(indice) == null){
            System.out.println("fail: caixa vazio");
            return null;
        }

        Pessoa p = caixas.get(indice);
        caixas.set(indice, null);
        return p;
    }

    public String toString(){
        String s ="Caixas: [";
        for(int i = 0; i < caixas.size(); i++){
            if(caixas.get(i) == null){
                s += "-----";
            } else {
                s += caixas.get(i).toString();
            }
            if(i < caixas.size()-1) 
                    s += ", ";
        }
        s += "]\n";
        s += "Espera: " + fila.toString();
        return s;
    }
}




public class Shell {
    public static void main(String[] _args) {
        Market market = new Market(0);
        while(true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) { 
                market = new Market(Integer.parseInt(par[1]));
                // var qtd_caixas = Integer.parseInt(par[1]);
            }
            else if (cmd.equals("show")) { 
                System.out.println(market.toString());
            }
            else if (cmd.equals("arrive")) { 
                market.arrive( new Pessoa (par[1]));
                // var nome = par[1];
            }
            else if (cmd.equals("call")) { 
                market.chamarNoCaixa(Integer.parseInt(par[1]));
                // var indice = Integer.parseInt(par[1]);
            }
            else if (cmd.equals("finish")) { 
                market.finalizarAtendimento(Integer.parseInt(par[1]));
                // var indice = Integer.parseInt(par[1]);
            }
            else {
                System.out.println("fail: comando invalido");

            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
