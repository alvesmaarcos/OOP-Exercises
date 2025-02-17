import java.util.Comparator;

class ComparaEquipe implements Comparator<Equipe> {
    public int compare(Equipe t1, Equipe t2) {
        if (t1.getTotalPontos() != t2.getTotalPontos()) {
            return t2.getTotalPontos() - t1.getTotalPontos();
        }
        
        if(t1.getTotalVitorias() != t2.getTotalVitorias()){
            return t2.getTotalVitorias() - t1.getTotalVitorias();
        }
        
        if(t1.getSaldoGols() != t2.getSaldoGols()){
            return t2.getSaldoGols() - t1.getSaldoGols();
        }
        
        if(t1.getGolsPro() != t2.getGolsPro()){
            return t2.getGolsPro() - t1.getGolsPro();
        }

        
        return 0;
    }
}
