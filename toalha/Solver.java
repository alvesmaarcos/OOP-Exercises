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
        if(getWetness() == getMaxWetness()){
            System.out.println("fail: toalha encharcada");
            return;
        }   
        setWetness(getWetness() + dry);
    }

    public void wringOut(){
        setWetness(0);
    }

    public boolean isDry(){
        if(getWetness() == 0)
            return true;

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
        return String.format("%s %s %d", this.color, this.size, this.wetness);
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Towel towel = new Towel(null, null);
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("show")) {
                System.out.println(towel.toString());
            } else if(ui[0].equals("init")) {
                towel = new Towel(ui[1], ui[2]);
            } else if(ui[0].equals("dry")) {
                towel.dry(Integer.parseInt(ui[1]));
            } else if(ui[0].equals("wringOut")) {
                towel.wringOut();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
