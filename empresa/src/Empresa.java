import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Empresa{
    ArrayList<Empregado> empregados;

    Empresa(){
        empregados = new ArrayList<Empregado>();
    }

    public void adicionaEmpregado(Empregado e){
        empregados.add(e);
    }

    public void mostraEmpregado(){
        System.out.println("Empresa: ");
        for(Empregado empregado : empregados){
            System.out.println(empregado);
        }
        
    }

    public double calculaFolha(){
        double folha = 0.0;
        for(Empregado empregado : empregados){
            folha += empregado.pagamento();
        }
        return folha;
    }



}