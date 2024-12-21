import java.util.Scanner;
import java.util.Locale;

class Lead {
    private double thickness;
    private String hardness;
    private int size;

    public Lead(double thickness, String hardness, int size) {
        this.thickness = thickness;
        this.hardness = hardness;
        this.size = size;
    }

    public double getThickness() {
        return this.thickness;
    }

    public String getHardness() {
        return String.format("%s", this.hardness);
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this. size = size;
    }

    public int usagePerSheet() {
        if(getHardness().equals("HB"))
            return 1;
        if(getHardness().equals("2B"))
            return 2;
        if(getHardness().equals("4B"))
            return 4;
        if(getHardness().equals("6B"))
            return 6;
        return 0;
    }

    public String toString() {
        return String.format("%.1f:%s:%d", getThickness(), getHardness(), getSize());
    }

}// Fim da classe Lead



class Pencil {
    private double thickness;
    Lead tip = null;

    public Pencil(double thickness) {
        this.thickness = thickness;
    }

    public double getThickness() {
        return this.thickness;
    }

    public void setThickness(double value) {
        this.thickness = value;
    }

    public boolean hasLead() {
        if(tip != null)
            return true;

        return false;
    }

    public boolean insert(Lead grafite) {
        if(grafite.getThickness() != getThickness()) {
            System.out.println("fail: calibre incompativel");
            return false;
        }
        if(!hasLead()){
            tip = grafite;
            return true;
        }
        System.out.println("fail: ja existe grafite");
        return false;
    }

    public Lead remove() {
        if(this.tip == null){
            System.out.println("fail: nao existe grafite");
            return null;
        }
        Lead aux = tip;
        tip = null;
        return aux;
    }

    public void writePage() {
        if(!hasLead()){
            System.out.println("fail: nao existe grafite");
            return;
        }

        if(tip.getSize() == 10){
            System.out.println("fail: tamanho insuficiente");
            return;
        }

        if(tip.getSize() - tip.usagePerSheet() < 10) {
            System.out.println("fail: folha incompleta");
            tip.setSize(10);
            return;
        }

        tip.setSize(tip.getSize() - tip.usagePerSheet());

    }

    public String toString() {
        String grafite;
        if(tip != null){
            grafite = "[" + tip.toString() + "]";
        } else {
            grafite = "null";
        }
        return String.format("calibre: %.1f, grafite: %s", this.thickness, grafite);
    }
}// Fim da classe Pencil



//Não mexer nessa classe
public class Shell {
    public static void main(String[] _args) {
        Locale.setDefault(Locale.US);

        Pencil pencil = new Pencil(0.5f);

        while (true) {
            String line = input();
            String[] args = line.split(" ");
            write('$' + line);

            if ("end".equals(args[0])) {
                break;
            } else if ("init".equals(args[0])) {
                pencil = new Pencil(number(args[1]));
            } else if ("insert".equals(args[0])) {
                pencil.insert(new Lead(number(args[1]), args[2], (int) number(args[3])));
            } else if ("remove".equals(args[0])) {
                pencil.remove();
            } else if ("write".equals(args[0])) {
                pencil.writePage();
            } else if ("show".equals(args[0])) {
                write(pencil.toString());
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void write(String value) {
        System.out.println(value);
    }

    public static double number(String str) {
        return Double.parseDouble(str);
    }
}