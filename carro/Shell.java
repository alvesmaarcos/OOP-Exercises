import java.util.Scanner;

class Car{
    public int pass; // Passageiros
    public int passMax; // limite de Passageiros
    public int gas; // tanque
    public int gasMax; // limite do tanque
    public int km; // quantidade de quilometragem
    public Car(){
        this.pass = 0;
        this.passMax = 2;
        this.gas = 0;
        this.gasMax = 100;
        this.km = 0;
    }
    public String toString(){
        return String.format("pass: %d, gas: %d, km: %d", pass, gas, km);
    }
    public void enter(){
        if(getPass() + 1> getPassMax()){
            System.out.println("fail: limite de pessoas atingido");
        } else {
            setPass(getPass() + 1);
        }
    }
    public void leave(){
        if(getPass() == 0){
            System.out.println("fail: nao ha ninguem no carro");
        } else {
            setPass(getPass() - 1);
        }
    }
    public void fuel(int gas){
        if(getGas() + gas > getGasMax()){
            setGas(getGasMax());
        } else {
            setGas(getGas() + gas);
        }
    }
    public void drive (int km){
        if(getPass() > 0){
            if(getGas() > 0){
                if(getGas() >= km){
                    setKm(getKm() + km);
                    setGas(getGas() - km);
                }
                else{
                    System.out.println("fail: tanque vazio apos andar " + getGas() +" km");
                    setKm(getKm() + getGas());
                    setGas(0);
                }
            } else {
                System.out.println("fail: tanque vazio");
            }
        } else {
            System.out.println("fail: nao ha ninguem no carro");
        }
    }

    void setPass(int value){
        this.pass = value;
    }
    void setGas(int value){
        this.gas = value;
    }
    void setKm(int value){
        this.km = value;
    }
    int getPass(){
        return this.pass;
    }
    int getPassMax(){
        return this.passMax;
    }
    int getGas(){
        return this.gas;
    }
    int getGasMax(){
        return this.gasMax;
    }
    int getKm(){
        return this.km;
    }
}
class Shell{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Car car = new Car();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("enter")) {
                car.enter();
            } else if(ui[0].equals("leave")) {
                car.leave();
            } else if(ui[0].equals("show")) {
                System.out.println(car.toString());
            } else if (ui[0].equals("drive")) {//km
                car.drive(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("fuel")) {//gas
                car.fuel(Integer.parseInt(ui[1]));
            } else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}