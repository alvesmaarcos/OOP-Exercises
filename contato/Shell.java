import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.Collections;

public class Shell{
    public static void main(String[] Args) {
        Contact contact = new Contact("");
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] args = line.split(" ");
            
            if (args[0].equals("end")) {
                break;
            }
            else if (args[0].equals("init")) {
                contact = new Contact(args[1]);
                // var name = args[1];
            }
            else if (args[0].equals("show")) {
                System.out.println(contact.toString());
            }
            else if (args[0].equals("add")) {
                contact.addFone(args[1], args[2]);
                // var id = args[1];
                // var number = args[2];
            }
            else if (args[0].equals("rm")) {
                contact.rmFone(Integer.parseInt(args[1]));
                // var index = Integer.parseInt(args[1]);
            }
            else if (args[0].equals("tfav")) {
                contact.toggleFavorited();
            }
            else {
                System.out.println("fail: invalid command");
            }
        }
    }
    static Scanner scanner = new Scanner(System.in);
}
