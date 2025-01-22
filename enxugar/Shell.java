import java.util.Scanner;
class Towel{
    private String color;
    private String size;
    private int wetness;

    public Towel(String color, String size){
        this.color = color;
        this.size = size;
        this.wetness = 0;
    }

    public void dry(int dry){
        if(getWetness() + dry >= getMaxWetness()){
            System.out.println("toalha encharcada");
            setWetness(getMaxWetness());
            return;
        }   
        setWetness(getWetness() + dry);
    }

    public void wringOut(){
        setWetness(0);
    }

    public boolean isDry(){
        if(getWetness() == 0){
            System.out.println("sim");
            return true;
        }
        System.out.println("nao");
        return false;
    }

    public int getMaxWetness(){
        if(getSize().equals("P"))
            return 10;
        if(getSize().equals("M"))
            return 20;
        return 30;
    }
    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public int getWetness() {
        return wetness;
    }

    public void setWetness(int wetness) {
        this.wetness = wetness;
    }
    
    @Override
    public String toString() {
        return String.format("Cor: %s, Tamanho: %s, Umidade: %d", this.color, this.size, this.wetness);
    }
}

public class Shell {
    
    public static void main(String[] a) {
        // CRIE SUA TOALHA AQUI
        Towel towel = new Towel(null, null);
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("criar")) { // ATUALIZE SUA TOALHA USANDO O CONSTRUTOR
                towel = new Towel(par[1], par[2]);
                // var cor = par[1];
                // var tamanho = par[2];
            }
            else if (cmd.equals("mostrar")) {
                System.out.println(towel.toString()); // MOSTRE SUA TOALHA
            }
            else if (cmd.equals("enxugar")) {
                towel.dry(Integer.parseInt(par[1])); // ENXUGUE
                // var quantidade = Integer.parseInt(par[1]);
            }
            else if (cmd.equals("seca")) {
                towel.isDry(); // OBTENHA SE ESTA SECA E IMPRIMA SIM OU NAO
            }
            else if (cmd.equals("torcer")) {
                towel.wringOut(); // CHAME O METODO TORCER
            }
            else {
                System.out.println("comando invalido");
            }
        }
    }
    private static Scanner scanner = new Scanner(System.in);
}
