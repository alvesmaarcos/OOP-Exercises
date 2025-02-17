import java.util.Scanner;

public class Shell {
    private static Scanner scanner = new Scanner(System.in);
    private static Theater theater;

    public static void main(String[] args) {
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);

            String[] argsCommand = line.split(" ");
            String cmd = argsCommand[0];

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                if (theater != null) {
                    System.out.println(theater.toString());
                } else {
                    System.out.println("[]");
                }
            } else if (cmd.equals("init")) {
                int numSeats = Integer.parseInt(argsCommand[1]);
                theater = new Theater(numSeats);
            } else if (cmd.equals("reserve")) {
                String id = argsCommand[1];
                String phone = argsCommand[2];
                int index = Integer.parseInt(argsCommand[3]);
                theater.reserve(id, phone, index); // Chamada ao método reserve
            } else if (cmd.equals("cancel")) {
                String id = argsCommand[1];
                theater.cancel(id); // Chamada ao método cancel
            } else {
                System.out.println("fail: comando invalido");
            }
        }
    }
}
