import java.util.*;
import java.util.stream.Collectors;

public class Shell {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] input = line.split(" ");
            String command = input[0];

            switch (command) {
                case "end":
                    return;
                case "add": {
                    String name = input[1];
                    List<Fone> fones = new ArrayList<>();
                    for (int i = 2; i < input.length; i++) {
                        String[] parts = input[i].split(":");
                        fones.add(new Fone(parts[0], parts[1]));
                    }
                    agenda.addContact(name, fones);
                    break;
                }
                case "show":
                    System.out.println(agenda);
                    break;
                case "rm":
                    agenda.rmContact(input[1]);
                    break;
                case "rmFone":
                    agenda.rmFone(input[1], Integer.parseInt(input[2]));
                    break;
                case "tfav":
                    agenda.toggleFavorite(input[1]);
                    break;
                case "favs":
                    System.out.println(agenda.getFavorites().stream().map(Contact::toString).collect(Collectors.joining("\n")));
                    break;
                case "search":
                    System.out.println(agenda.search(input[1]).stream().map(Contact::toString).collect(Collectors.joining("\n")));
                    break;
                default:
                    System.out.println("fail: invalid command");
            }
        }
    }
}
