import java.util.Scanner;
class Animal{
    private String species;
    private String sound;
    private int age;

    public Animal(String species, String sound){
        this.species = species;
        this.sound = sound;
        this.age = 0;
    }
    public void ageBy(int increment){
        if(getAge() + increment >= 4){
            System.out.format("warning: %s morreu\n", getSpecies());
            setAge(4);
            return;
        }
        setAge(getAge() + increment);

    }
    public String makeSound(){{
        if(getAge() == 0)
            return String.format("---");
        if(getAge() == 4)
            return String.format("RIP");
        return String.format("%s", getSound());
    }

    }

    int getAge(){
        return this.age;
    }

    String getSound(){
        return this.sound;
    }

    String getSpecies(){
        return this.species;
    }

    void setAge(int value){
        this.age = value;
    }

    public String toString(){
        String s = "";
        s += String.format("%s:%d:%s", species, age, sound);
        return s;
    }

}
public class Shell {

    public static void main(String[] _args) {
        Animal animal = new Animal("", "");

        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")  ) { 
                break;
            }
            else if (cmd.equals("init") ) {
                animal = new Animal(par[1], par[2]);
                // INICIE O ANIMAL UTILIZANDO O CONSTRUTOR
                // var species = par[1];
                // var noise = par[2];
            } 
            else if (cmd.equals("show")) {
                System.out.println(animal.toString());
                // MOSTRE O ANIMAL
            } 
            else if (cmd.equals("noise")) {
                System.out.println(animal.makeSound());
                // OBTER O BARULHO DO ANIMAL E IMPRIMA
            } 
            else if (cmd.equals("grow") ) {
                animal.ageBy(Integer.parseInt(par[1]));
                // AUMENTE A IDADE DO ANIMAL
                // var increment = Integer.parseInt(par[1]);
            }  
            else {
                System.out.println("fail: comando invalido\n");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
