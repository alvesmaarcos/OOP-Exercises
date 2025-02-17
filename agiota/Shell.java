import java.util.*;

class Label {
    public static final String GIVE = "give";
    public static final String TAKE = "take";
    public static final String PLUS = "plus";
}

class Operation {
    private int id;
    private String name;
    private String label;
    private int value;

    public Operation(int id, String name, String label, int value) {
        this.id = id;
        this.name = name;
        this.label = label;
        this.value = value;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLabel() { return label; }
    public int getValue() { return value; }

    @Override
    public String toString() {
        return "id:" + id + " " + label + ":" + name + " " + value;
    }
}

class Client {
    private String name;
    private int limite;
    private List<Operation> operations;

    public Client(String name, int limite) {
        this.name = name;
        this.limite = limite;
        this.operations = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getLimite() { return limite; }
    public List<Operation> getOperations() { return operations; }

    public void addOperation(Operation op) {
        operations.add(op);
    }

    public int getBalance() {
        int balance = 0;
        for (Operation op : operations) {
            if (op.getLabel().equals(Label.GIVE)) balance += op.getValue();
            else balance -= op.getValue();
        }
        return balance;
    }

    @Override
    public String toString() {
        return ":) " + name + " " + getBalance() + "/" + limite;
    }
}

class Agiota {
    private Map<String, Client> clients = new TreeMap<>();
    private List<Operation> operations = new ArrayList<>();
    private Map<String, Client> deadClients = new TreeMap<>();
    private List<Operation> deadOperations = new ArrayList<>();
    private int nextOpId = 0;

    public void addClient(String name, int limite) {
        if (clients.containsKey(name)) {
            System.out.println("fail: cliente ja existe");
            return;
        }
        clients.put(name, new Client(name, limite));
    }

    public void give(String name, int value) {
        Client client = clients.get(name);
        if (client == null) {
            System.out.println("fail: cliente nao existe");
            return;
        }
        if (client.getBalance() + value > client.getLimite()) {
            System.out.println("fail: limite excedido");
            return;
        }
        Operation op = new Operation(nextOpId++, name, Label.GIVE, value);
        client.addOperation(op);
        operations.add(op);
    }

    public void take(String name, int value) {
        Client client = clients.get(name);
        if (client == null) {
            System.out.println("fail: cliente nao existe");
            return;
        }
        Operation op = new Operation(nextOpId++, name, Label.TAKE, value);
        client.addOperation(op);
        operations.add(op);
    }

    public void plus() {
    List<String> toKill = new ArrayList<>();
    List<Operation> newOperations = new ArrayList<>();

    for (Client client : clients.values()) {
        int balance = client.getBalance();

        if (balance < 0) { // Juros apenas para saldo negativo
            int interest = (int) Math.ceil(Math.abs(balance) * 0.1); // 10% da dívida
            Operation op = new Operation(nextOpId++, client.getName(), Label.PLUS, interest);
            newOperations.add(op);
        }
    }

    // Aplicando juros de forma mais segura
    for (Operation op : newOperations) {
        Client client = clients.get(op.getName());
        client.addOperation(op);
        operations.add(op);

        // Verificar se o cliente ultrapassou o limite
        if (client.getBalance() > client.getLimite()) {
            toKill.add(client.getName());
        }
    }

    // Remover clientes que estouraram o limite
    for (String name : toKill) {
        kill(name);
    }
}





    public void kill(String name) {
        Client client = clients.remove(name);
        if (client == null) return;
        deadClients.put(name, client);
        for (Operation op : client.getOperations()) {
            deadOperations.add(op);
            operations.remove(op);
        }
    }

    public void show() {
        for (Client client : clients.values())
            System.out.println(client);
        for (Operation op : operations)
            System.out.println("+ " + op);
        for (Client client : deadClients.values())
            System.out.println(client.toString().replace(":)", ":("));
        for (Operation op : deadOperations)
            System.out.println("- " + op);
    }

    public void showClient(String name) {
        Client client = clients.get(name);
        if (client == null) {
            client = deadClients.get(name);
            if (client == null) return;
        }
        System.out.println(client.getName() + " " + client.getBalance() + "/" + client.getLimite());
        for (Operation op : client.getOperations())
            System.out.println(op);
    }
}

public class Shell {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Agiota agiota = new Agiota();
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] parts = line.split(" ");
            String cmd = parts[0];
            if (cmd.equals("end")) break;
            else if (cmd.equals("addCli")) agiota.addClient(parts[1], Integer.parseInt(parts[2]));
            else if (cmd.equals("give")) agiota.give(parts[1], Integer.parseInt(parts[2]));
            else if (cmd.equals("take")) agiota.take(parts[1], Integer.parseInt(parts[2]));
            else if (cmd.equals("plus")) agiota.plus();
            else if (cmd.equals("kill")) agiota.kill(parts[1]);
            else if (cmd.equals("show")) agiota.show();
            else if (cmd.equals("showCli")) agiota.showClient(parts[1]);
            else System.out.println("fail: comando invalido");
        }
    }
}
