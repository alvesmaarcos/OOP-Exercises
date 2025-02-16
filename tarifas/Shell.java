import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Shell{
    public static void main(String[] _args) {
        Account a = new Account(0);
        while (true) {
            var line = scanner.nextLine();
            var args = line.split(" ");
            var cmd = args[0];
            System.out.println("$" + line);

            if (cmd.equals("end")) {
                break;
            } else if (cmd.equals("show")) {
                System.out.println(a.toString());
            } else if (cmd.equals("init")) {
                a = new Account(Integer.parseInt(args[1]));
                // var id = Integer.parseInt(args[1]);
            } else if (cmd.equals("withdraw")) {
                a.withdraw(Integer.parseInt(args[1]));
                // var value = Integer.parseInt(args[1]);
            } else if (cmd.equals("fee")) {
                a.fee(Integer.parseInt(args[1]));
                // var value = Integer.parseInt(args[1]);
            } else if (cmd.equals("deposit")) {
                a.deposit(Integer.parseInt(args[1]));
                // var value = Integer.parseInt(args[1]);
            } else if (cmd.equals("reverse")) {
                for(int i=1; i<args.length; i++){
                    a.reverse(Integer.parseInt(args[i]));
                }
                // for (int i = 1; i < args.length; i++) {
                //     var index = Integer.parseInt(args[i]);
                // }
            } else if (cmd.equals("extract")) {
                 int qtdOp = Integer.parseInt(args[1]);
                List<Operation> extract = a.getBalanceManager().getExtract(qtdOp);
                for (Operation op : extract) {
                    System.out.println(op.toString().toLowerCase());
                }
                // var qtdOp = Integer.parseInt(args[1]);
            }
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}
