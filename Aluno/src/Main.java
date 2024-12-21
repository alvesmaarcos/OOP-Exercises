import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Fulano", 90);
        System.out.println(aluno);
        aluno.setNotas(0, 8);
        aluno.setNotas(1, 6);
        System.out.println(aluno);
    }
}
