class Bateria(){
    private int carga = 0;
    private int cargaMax;

    public Bateria(int carga) {
        this.cargaMax = carga;
        this.carga = carga;
    }

    setCarga(int carga) {
        if(this.carga > this.cargaMax) {
            this.carga = cargaMax;
        }
        else
            this.carga = carga;
    }

    getCarga() {
        return this.carga;
    }
    
    String toString(){
        return String.format("(%d/%d)", this.carga, this.cargaMax);
    }
}

class Notebook() {
    private boolean ligado;
    private int bateria = null;
    
    public Notebook(boolean ligado, int carga) {
        this.ligado = false;
        this.bateria = new Bateria(carga);
    }

    public ligar() {
        if(getLigado())
            System.out.println("Notebook já está ligado");
        
        else
        setLigado(true);
    }

    public desligar() {
        if(getLigado()) {
            setLigado(false);
        }
        else
            System.out.println("notebook já está desligado");
    }

    public void tempo(int tempo){
        if(getLigado() && tempo < bateria.getCarga()) {
            System.out.println(String.format("Usando por %d minutos", tempo));
            bateria.setCarga(bateria.getCarga() - tempo);
        }

        else if(getLigado() && tempo > bateria.getCarga()) {
            System.out.println("Usado por %d minutos, notebook descarregou", bateria.getCarga());
            bateria.setCarga(0);
        }
        else
            System.out.println("erro: ligue o notebook");
    }
    public boolean rmBateria(){
       if(this.bateria != null){
        Bateria aux = this.bateria;
        this.bateria = null;
        System.out.println(String.format("Bateria removida: %s", aux.toString()));
        return true;
       }

        System.out.println("erro: notebook não possui bateria");
        return false;
    }
    public getBateria() {
        return bateria.getCarga();
    }

    setBateria(int carga) {
        bateria.setCarga(carga);
    }

    public boolean getLigado() {
        return ligado;
    }

    public void setLigado(boolean status) {
        this.ligado = status;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Status: ");
        if(getLigado()){
            s.append("Ligado");
        }
        else
            s.append("Desligado");

        return s;
    }
}

class draft{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notebook n = new Notebook(False);

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("init")) {
                n = new Notebook();
            } else if(ui[0].equals("ligar")) {
                n.ligar();
            } else if(ui[0].equals("desligar")) {
                n.desligar();
            } else if(ui[0].equals("setBateria")) {
                n.setBateria(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("usar")) {
                n.usar(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("show")) {
                System.out.println(n.toString(););
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}

