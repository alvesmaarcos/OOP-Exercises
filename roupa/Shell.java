import java.util.*;

class Roupa{
    private String tamanho;

    Roupa(){
        this.tamanho = "";
    }

    public String getTamanho(){
        return this.tamanho;
    }

    public void setTamanho(String tamanho){
        String[] listaTamanhos = {"PP", "P", "M", "G", "GG", "XG"};
        for(String t : listaTamanhos){
            if(t.equals(tamanho)){
                this.tamanho = t;
                return;
            }
        }

        System.out.println("fail: Valor inválido, tente PP, P, M, G, GG ou XG");
    }

    public String toString(){
        return String.format("size: (%s)", getTamanho());
    }
}

public class Shell {    
    public static void main(String[] args) {
        // CRIE SEU OBJETO AQUI
        Roupa roupa = new Roupa();
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);
            
            var par = line.split(" ");
            var cmd = par[0];
            
            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("size")) { 
                roupa.setTamanho(par[1]);// TENTE ATRIBUIR UM TAMANHO A ROUPA
                // String size = par[1];
            }
            else if (cmd.equals("show")) {
                System.out.println(roupa.toString()); // MOSTRE A ROUPA
            }
            else {
                System.out.println("fail: Comando inválido");
            }
        }
    }
    private static Scanner scanner = new Scanner(System.in);
}
