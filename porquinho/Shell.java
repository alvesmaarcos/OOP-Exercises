
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Shell {
    public static void main(String[] _args) {
        Pig pig = new Pig(0);
        while (true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                pig = new Pig(Integer.parseInt(par[1]));
                // int maxVolume = Integer.parseInt(par[1]);
            }
            else if (cmd.equals("show")) {
                System.out.println(pig.toString());
                // Imprima o estado do porquinho
            }
            else if (cmd.equals("addCoin")) {
                switch(par[1]){
                    case "10":
                        pig.addCoin(Coin.C10);
                        break;
                    case "25":
                        pig.addCoin(Coin.C25);
                        break;
                    case "50":
                        pig.addCoin(Coin.C50);
                        break;
                    case "100":
                        pig.addCoin(Coin.C100);
                        break;
                    default:
                        System.out.println("fail: invalid coin");
                        break;
                }
                // var coin = par[1];
            }
            else if (cmd.equals("addItem")) {
                pig.addItem(new Item(par[1], Integer.parseInt(par[2])));
                // var item = par[1];
                // var volume = Integer.parseInt(par[2]);
            }
            else if (cmd.equals("break")) {
                pig.breakPig();
                // pig.breakPig();
            }
            else if (cmd.equals("extractCoins")) {
                pig.extractCoins();
                // Obtenha as moedas usando o método extractCoins
                // Imprima as moedas obtidas
            }
            else if (cmd.equals("extractItems")) {
                pig.extractItems();
                // Obtenha os itens usando o método extractItems
                // Imprima os itens obtidos
            }
            else {
                System.out.println("fail: invalid command");
            }
        }
    }

    public static Scanner scanner = new Scanner(System.in);
}
