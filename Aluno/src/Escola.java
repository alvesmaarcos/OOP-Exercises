class Aluno {
    private String nome;
    private int matricula;
    private float notas[];

    Aluno(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
        this.notas = new float[2];
    }

    String getNome(){
        return this.nome;
    }

    void setNome(String nome){
       this.nome = nome;
    }

    int getMatricula(){
        return this.matricula;
    }

    void setMatricula(int matricula){
        this.matricula = matricula;
    }

    void setNotas(int index, float nota){
        if(index > notas.length){
            System.out.println("indice invalido");
            return;
        }
        this.notas[index] = nota;
    }

    float media(){
        float media = 0;
        for (Float e: notas){
            media += e;
        }
        return media/notas.length;
    }

    public String toString(){
        return String.format("nome: %s, matricula: %d, media: %.2f", getNome(), getMatricula(), media());
    }

}