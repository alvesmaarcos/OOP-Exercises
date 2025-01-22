import java.util.Scanner;

class Roupa{
    private String tamanho;
    private String listaTamanhos[] = {"PP", "P", "M", "G", "GG", "XG"};

    Roupa(String tamanho){
        this.tamanho = tamanho;
    }
    
    public String getTamanho(){
        return this.tamanho;
    }

    public void setTamanho(String tamanho){
        for(String t : listaTamanhos){
            if (t.equals(tamanho)){
                this.tamanho = t;
                break;
            }
        }
    }
}

public class draft {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        Roupa roupa = new Roupa("");

        while(roupa.getTamanho().isEmpty()){
            System.out.println("Digite seu tamanho de roupa: ");
            String tamanho = scanner.nextLine();
            roupa.setTamanho(tamanho);   
            if(tamanho == "end") break;
        }
        System.out.println("Parabens, você comprou uma roupa tamanho " + roupa.getTamanho());
    }
}

