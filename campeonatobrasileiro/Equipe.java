import java.lang.Comparable;

class Equipe implements Comparable<Equipe> {
    String nome;
    int totalPontos;
    int totalVitorias;
    int saldoGols;
    int golsPro;
    
    public Equipe(String nome, int totalPontos, int totalVitorias, int saldoGols, int golsPro){
        this.nome = nome;
        this.totalPontos = totalPontos;
        this.totalVitorias = totalVitorias;
        this.saldoGols = saldoGols;
        this.golsPro = golsPro;
    }

    public int compareTo(Equipe t){
        if(this.totalPontos != t.totalPontos){
            return Integer.compare(t.totalPontos, this.totalPontos);
        }
        if(this.totalVitorias != t.totalVitorias){
            return Integer.compare(t.totalVitorias, this.totalVitorias);
        }
        if(this.saldoGols != t.saldoGols){
            return Integer.compare(t.saldoGols, this.saldoGols);
        }
        if(this.golsPro != t.golsPro){
            return Integer.compare(t.golsPro, this.golsPro);
        }
        return 0;
    }

    public String toString(){
        return "Equipe [nome=" + nome + ", totalPontos=" + totalPontos +
        ", totalVitorias=" + totalVitorias + ", saldoGols=" + saldoGols +
        ", golsPro=" + golsPro + "]";
    }
}
