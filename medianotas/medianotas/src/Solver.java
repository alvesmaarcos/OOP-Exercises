import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Collections;

class MediaNotas{

    private ArrayList<Double> notas = new ArrayList<Double>();

    public void addNota(double nota){
        notas.add(nota);
    }

    public void removeNota(int index){
        notas.remove(index);
    }

    public void mudaNota(int index, double valor){
        notas.set(index, valor);
    }

    public double maiorNota() {
        if (notas.isEmpty()){
            System.out.println("Falha: quantidade de notas insuficiente");
            return -1;
        }
        return Collections.max(notas);
    }

    public double menorNota(){
        if (notas.isEmpty()){
            System.out.println("Falha: quantidade de notas insuficiente");
            return -1;
        }
        return Collections.min(notas);
    }

    double media(){
        double soma = 0;
        for (int i = 0; i < notas.size(); i++){
            soma += notas.get(i);
        }
        return soma/notas.size();
    }

    void parametriza(){
        double y = Collections.max(notas);
        for (int i = 0; i < notas.size(); i++) {
            mudaNota(i, (notas.get(i)/y)*10);
        }
    }

    public String toString(){
        StringBuilder s = new StringBuilder("[");
        for (int i = 0; i < notas.size(); i++){
            s.append(String.format("%.2f", notas.get(i)));

            if(i < notas.size()-1)
                s.append(", ");
        }
        return s + "]";
    }
}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas m = new MediaNotas();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("addNota")) {
                m.addNota( Double.parseDouble( ui[1]) );
            } else if(ui[0].equals("removeNota")) {
                m.removeNota( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("maiorNota")) {
                System.out.println( m.maiorNota() );
            } else if(ui[0].equals("menorNota")) {
                System.out.println( m.menorNota() );
            } else if(ui[0].equals("media")) {
                System.out.printf( Locale.US, "%.2f\n",  m.media() );
            }else if(ui[0].equals("parametriza")) {
                m.parametriza();
            }else if(ui[0].equals("show")) {
                System.out.println( m );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}