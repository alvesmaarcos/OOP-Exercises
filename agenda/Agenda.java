import java.util.*;
import java.util.stream.Collectors;

class Agenda {
    private Map<String, Contact> contacts;

    Agenda() {
        this.contacts = new TreeMap<>();
    }

    public void addContact(String name, List<Fone> fones) {
        contacts.putIfAbsent(name, new Contact(name));
        Contact contact = contacts.get(name);
        for (Fone f : fones) {
            contact.addFone(f.id, f.number);
        }
    }

    public void rmContact(String name) {
        contacts.remove(name);
    }

    public void rmFone(String name, int index) {
        if (contacts.containsKey(name)) {
            contacts.get(name).rmFone(index);
        } else {
            System.out.println("fail: contact not found");
        }
    }

    public void toggleFavorite(String name) {
        if (contacts.containsKey(name)) {
            contacts.get(name).toggleFavorited();
        } else {
            System.out.println("fail: contact not found");
        }
    }

    public List<Contact> search(String pattern) {
        return contacts.values().stream().filter(c -> c.matches(pattern)).collect(Collectors.toList());
    }

    public List<Contact> getFavorites() {
        return contacts.values().stream().filter(Contact::isFavorited).collect(Collectors.toList());
    }

    public String toString() {
        return contacts.values().stream().map(Contact::toString).collect(Collectors.joining("\n"));
    }
}