class Equipe {
    private String nome;
    private int totalPontos;
    private int totalVitorias;
    private int saldoGols;
    private int golsPro;

    public Equipe(String nome, int totalPontos, int totalVitorias, int saldoGols, int golsPro){
        this.nome = nome;
        this.totalPontos = totalPontos;
        this.totalVitorias = totalVitorias;
        this.saldoGols = saldoGols;
        this.golsPro = golsPro;
    }

    public String getNome(){
        return nome;
    }

    public int getTotalPontos(){
        return totalPontos;
    }

    public int getSaldoGols(){
        return saldoGols;
    }

    public int getTotalVitorias(){
        return totalVitorias;
    }

    public int getGolsPro(){
        return golsPro;
    }
    
    public String toString(){
         return "Equipe [nome=" + nome + ", totalPontos=" + totalPontos +
        ", totalVitorias=" + totalVitorias + ", saldoGols=" + saldoGols +
        ", golsPro=" + golsPro + "]";
    }
}
