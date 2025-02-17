import java.util.*;
import java.util.stream.Collectors;

class Fone {
    String id;
    String number;

    Fone(String id, String number) {
        this.id = id;
        this.number = number;
    }

    public boolean isValid() {
        return number.matches("[\\d().-]+");
    }

    public String toString() {
        return id + ":" + number;
    }
}

class Contact {
    private String name;
    private List<Fone> fones;
    private boolean favorited;

    Contact(String name) {
        this.name = name;
        this.fones = new ArrayList<>();
        this.favorited = false;
    }

    public void addFone(String id, String number) {
        Fone fone = new Fone(id, number);
        if (fone.isValid()) {
            fones.add(fone);
        } else {
            System.out.println("fail: invalid number");
        }
    }

    public void rmFone(int index) {
        if (index >= 0 && index < fones.size()) {
            fones.remove(index);
        } else {
            System.out.println("fail: invalid index");
        }
    }

    public void toggleFavorited() {
        this.favorited = !this.favorited;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public boolean matches(String pattern) {
        return name.contains(pattern) || fones.stream().anyMatch(f -> f.toString().contains(pattern));
    }

    public String toString() {
        String prefix = favorited ? "@ " : "- ";
        return prefix + name + " " + fones.stream().map(Fone::toString).collect(Collectors.joining(", ", "[", "]"));
    }

    public String getName() {
        return name;
    }
}