import java.util.Scanner;

class Chinela{
    private int tamanho;

    Chinela(int tamanho){
        this.tamanho = tamanho;
    }

    public boolean Serve(int size){
        if(getTamanho() % 2 == 0 && (getTamanho() >= 20 && getTamanho() <= 50)){
            setTamanho(size);
            return true;
        }
    }
    
    private void setTamanho(int value){
        this.tamanho = value;
    }

    public int getTamanho(){
        return this.tamanho;
    }
}

public class Solver {
    Chinela chinela = new Chinela(0);
    Scanner s = new Scanner(System.input);
    public static void main(String args[]) {
        chinela = new Chinela(0);
        while(chinela.getSize == 0){
            System.out.println("Digite seu tamanho de chinela");
            int tamanho = s.next();
            if(tamanho.Serve()){
                System.out.println("Parabens, você comprou uma chinela tamanho " + chinela.getTamanho());
            }
        }
    }
}

