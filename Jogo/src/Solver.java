import java.util.ArrayList;
import java.util.Scanner;
import java.util.Locale;


class Jogo{

    private int numJogadores;
    private int [] armadilha;
    private int [] posicao;
    private boolean [] podeJogar;
    private int numArmadilha = 0;
    private int numCasas;
    private int prox;
    private boolean fimDoJogo = false;

    public Jogo(int numJogadores, int numCasas){
        this.numJogadores = numJogadores;
        this.numCasas = numCasas;
        this.armadilha = new int[3];
        this.posicao = new int[numJogadores];
        this.podeJogar = new boolean[numJogadores];
        for(int i = 0; i < numJogadores; i++){
            podeJogar[i] = true;
        }
        this.prox = 0;
    }

    public void addArmadilha(int t){ //t é a posicao que a armadilha estara
        if(this.numArmadilha < 3){
            this.armadilha[this.numArmadilha] = t; // a armadilha[0] esta na posicao t
            this.numArmadilha++;
        }
    }

    public void addMove(int d1, int d2) {
        if (fimDoJogo){
            System.out.println("O jogo acabou");
            return;
        }

        int somaDados= d1 + d2;
        if(!podeJogar[prox]){ //ve se o jogador proximo esta bloqueado
            System.out.format("O jogador %d passa a vez\n", prox + 1); //se estiver, mensagem anunciando
            podeJogar[prox] = true; // libera o jogador que estava bloqueado
            prox = (prox + 1)%numJogadores; // impede que apareca um valor, atribuido a prox, maior que a quantidade de jogadores
        }

        posicao[prox] += somaDados;
        System.out.format("O jogador %d vai para a casa %d\n", prox+1, posicao[prox]);
        //por que prox+1? Por que o array jogadores comeca com 0
        // o +1 serve pra que nao haja jogador #0;
        for (int i = 0; i < 3; i++) {
            if(posicao[prox] == armadilha[i]){
                System.out.format("O jogador %d caiu em um armadilha\n", prox+1);
                podeJogar[prox] = false;
            }

            if(posicao[prox] > numCasas){
                System.out.format("O jogador %d venceu o jogo\n", prox+1);
                fimDoJogo = true;
                return; // encerra
            }
            prox = (prox + 1)%numJogadores; // quando passa por todos os casos e o jogo nao acaba, pula pro prox jogador
        }

    }
    public String toString(){
        String s = "";
        for(int i = 0; i < numJogadores; i++){
            s += String.format("PosJogador[%d] = %d\n", i+1, posicao[i]);
        }

        return s;
    }

}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault ( Locale.US ) ;
        Jogo jogo = new Jogo(0,0);

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("init")) {
                jogo = new Jogo( Integer.parseInt( ui[1]),  Integer.parseInt( ui[2]) );
            } else if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("addArmadilha")) {
                jogo.addArmadilha( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("addMove")) {
                int d1 = Integer.parseInt( ui[1]);
                int d2 = Integer.parseInt( ui[2]);
                jogo.addMove(d1, d2);
            } else if(ui[0].equals("show")) {
                System.out.println(jogo);
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}