import java.util.Scanner;

class Animal {
    public String species;
    public String sound;
    public int age;

    public Animal(String species, String noise) {
        this.species = species;
        this.sound = noise;
        this.age = 0;
    }

    public String makeNoise() {
        if(getAge() == 0)
            return ("---");
        if(getAge() == 4)
            return ("RIP");
        return String.format("%s", getSound());
    }

    public void ageBy(int increment) {
        if(getAge() + increment >= 4){
            System.out.format("warning: %s morreu\n", getSpecies());
            setAge(4);
            return;
        }
        setAge(getAge() + increment);
    }

    public String toString() {
        return String.format("%s:%d:%s", getSpecies(), getAge(), getSound());
    }

    public String getSound() {
        return this.sound;
    }

    public int getAge() {
        return this.age;
    }

    public String getSpecies() {
        return this.species;
    }

    public void setAge(int age) {
        this.age = age;
    }
}// fim da classe animal


// não mexer nessa classe
public class Shell {

    public static void main(String[] _args) {
        Animal animal = new Animal("", "");

        while (true) {
            write("$");
            var line = input();
            var args = line.split(" ");
            write(line + "\n");

            if (args[0].equals("end")) {
                break;
            } else if (args[0].equals("init")) {
                animal = new Animal(args[1], args[2]);
            } else if (args[0].equals("show")) {
                System.out.println(animal);
            } else if (args[0].equals("noise")) {
                System.out.println(animal.makeNoise());
            } else if (args[0].equals("grow")) {
                animal.ageBy((int) number(args[1]));
            } else {
                write("fail: comando invalido\n");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);

    public static String input() {
        return scanner.nextLine();
    }

    public static void write(String value) {
        System.out.print(value);
    }

    public static double number(String str) {
        return Double.parseDouble(str);
    }
}
