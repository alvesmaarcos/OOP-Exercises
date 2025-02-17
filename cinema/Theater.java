import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Theater {
    private List<Client> seats;

    public Theater(int numSeats) {
        seats = new ArrayList<>(numSeats);
        for (int i = 0; i < numSeats; i++) {
            seats.add(null); // Inicializa as cadeiras como vazias
        }
    }

    public boolean reserve(String id, String phone, int index) {
        if (!verifyIndex(index)) {
            System.out.println("fail: cadeira nao existe");
            return false;
        }
        if (search(id) != -1) {
            System.out.println("fail: cliente ja esta no cinema");
            return false;
        }
        if (seats.get(index) != null) {
            System.out.println("fail: cadeira ja esta ocupada");
            return false;
        }
        seats.set(index, new Client(id, phone));
        return true;
    }

    public boolean cancel(String id) {
        int index = search(id);
        if (index == -1) {
            System.out.println("fail: cliente nao esta no cinema");
            return false;
        }
        seats.set(index, null);
        return true;
    }

    public List<Client> getSeats() {
        return seats;
    }

    public String toString() {
        return "[" + seats.stream()
                .map(c -> c == null ? "-" : c.toString())
                .collect(Collectors.joining(" ")) + "]";
    }

    private int search(String id) {
        for (int i = 0; i < seats.size(); i++) {
            if (seats.get(i) != null && seats.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private boolean verifyIndex(int index) {
        return index >= 0 && index < seats.size();
    }
}
