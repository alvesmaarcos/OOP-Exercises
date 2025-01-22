import java.util.Scanner;

class Chinela{
    private int tamanho;

    Chinela(int tamanho){
        this.tamanho = tamanho;
    }

    public boolean serve(int tamanho){
        if(tamanho % 2 == 0 && (tamanho >= 20 && tamanho <= 50)){
            setTamanho(tamanho);
            return true;
        }
        return false;
    }

    private void setTamanho(int value){
        this.tamanho = value;
    }

    public int getTamanho(){
        return this.tamanho;
    }
}



public class Shell {

    public static void main(String[] _args) {
        Chinela chinela = new Chinela(0);
        while(chinela.getTamanho() == 0){
            System.out.println("Digite seu tamanho de chinela: ");
            int tamanho = input();
            if(chinela.serve(tamanho)){
                System.out.println("Parabens, você comprou uma chinela tamanho " + chinela.getTamanho());
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static int input(){
        return Integer.parseInt(scanner.next());
    }
}
