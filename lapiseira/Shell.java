import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

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
    private LinkedList<Lead> tambor;
    private double thickness;
    Lead tip = null;

    public Pencil(double thickness) {
        this.thickness = thickness;
        this.tambor = new LinkedList<Lead>();
    }

    public double getThickness() {
        return this.thickness;
    }

    public void setThickness(double value) {
        this.thickness = value;
    }

    public boolean hasLead() {
        if(this.tip != null)
            return true;

        return false;
    }

    public boolean insert(Lead grafite) {
        if(grafite.getThickness() != getThickness()) {
            System.out.println("fail: calibre incompatível");
            return false;
        }
        //if(!hasLead()){
        this.tambor.addLast(grafite);
        //tip = grafite;
        return true;
        //}
        //System.out.println("fail: ja existe grafite");
        //return false;

    }
    public boolean pull() {
        if(hasLead()){
            System.out.println("fail: ja existe grafite no bico");
            return false;
        }
        if(this.tambor.size() > 0){
            Lead aux = tambor.get(0);
            this.tip = aux;
            this.tambor.removeFirst();
            return true;
        }

        System.out.println("fail: tambor vazio");
        return false;

    }
    public Lead remove() {
        if(this.tip == null){
            System.out.println("fail: nao existe grafite");
            return null;
        }
        Lead aux = this.tip;
        this.tip = null;
        return aux;
    }

    public void writePage() {
        if(!hasLead()){
            System.out.println("fail: nao existe grafite no bico");
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
        String bico;
        if(tip != null){
            bico = "" + tip.toString() + "";
        } else {
            bico = "";
        }

        String barrel;
        if(this.tambor != null && this.tambor.size() > 0){
            barrel = "";
            for(int i=0; i<this.tambor.size(); i++){
            barrel += "[" + tambor.get(i).toString() + "]";
            }

        }else{
            barrel = "";
        }
        
        return String.format("calibre: %.1f, bico: [%s], tambor: <%s>", this.thickness, bico, barrel);
    }
}// Fim da classe Pencil


public class Shell {
    public static void main(String[] _args) {
        Pencil pencil = new Pencil(0);
        while(true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("show")) { 
                System.out.println(pencil.toString());
            } 
            else if (cmd.equals("init")) { 
                pencil = new Pencil(Double.parseDouble(par[1]));
                // var thickness = Double.parseDouble(par[1]);
            } 
            else if (cmd.equals("insert")) { 
                pencil.insert(new Lead(Double.parseDouble(par[1]), par[2], Integer.parseInt(par[3])));
                // var thickness = Double.parseDouble(par[1]);
                // var hardness = par[2];
                // var size = Integer.parseInt(par[3]);
            } 
            else if (cmd.equals("remove")) { 
                pencil.remove();
            } 
            else if (cmd.equals("write")) { 
                pencil.writePage();
            } 
            else if (cmd.equals("pull")) { 
                pencil.pull();
            } 
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
