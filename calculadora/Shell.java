import java.util.*;
import java.text.DecimalFormat;
import java.util.Scanner;

class Calculator{
    private int battery;
    private int batteryMax;
    private float display;

    Calculator(int batteryMax){
        this.batteryMax = batteryMax;
        this.battery = 0;
        this.display = 0.0f;
    }

    public void charge(int value){
        if(getBattery() + value >= getBatteryMax())
            setBattery(getBatteryMax());
        else
            setBattery(getBattery() + value);
    }

    public boolean hasCharge(){
        if(getBattery() > 0){
            setBattery(getBattery() - 1);
            return true;
        }
        System.out.println("fail: bateria insuficiente");
        return false;
    }
    public void sum(float a, float b){
        if(hasCharge()){
            setDisplay(a + b);
            return;
        }
    }

    public void division(float num, float den){
        if(hasCharge()){
            if(den != 0){
                setDisplay(num / den);
            } else System.out.println("fail: divisao por zero");
        }
    }

    private int getBattery(){
        return this.battery;
    }
    private int getBatteryMax(){
        return this.batteryMax;
    }
    private float getDisplay(){
        return this.display;
    }

    private void setBattery(int value){
        this.battery = value;
    }
    private void setDisplay(float value){
        this.display = value;
    }

    public String toString(){
        return String.format("display = %.2f, battery = %d", getDisplay(), getBattery());
    }


}

public class Shell {

    public static void main(String[] args) {
        Calculator calculator = new Calculator(0);
        
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                calculator = new Calculator(Integer.parseInt(par[1]));
                // CHAME O CONSTRUTOR
                // int batteryMax = Integer.parseInt(par[1]);
            } 
            else if (cmd.equals("show")) {
                System.out.println(calculator.toString());
                // MOSTRAR
            } 
            else if (cmd.equals("charge")) {
                calculator.charge(Integer.parseInt(par[1]));
                // RECARREGAR A BATERIA
                // int value = Integer.parseInt(par[1]);
            } 
            else if (cmd.equals("sum")) {
                calculator.sum(Integer.parseInt(par[1]), Integer.parseInt(par[2]));
                // SOMAR
                // int a = Integer.parseInt(par[1]);
                // int b = Integer.parseInt(par[2]);
            } 
            else if (cmd.equals("div")) {
                calculator.division(Integer.parseInt(par[1]), Integer.parseInt(par[2]));
                // DIVIDIR
                // int num = Integer.parseInt(par[1]);
                // int den = Integer.parseInt(par[2]);
            } 
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    private static Scanner scanner = new Scanner(System.in);
}
