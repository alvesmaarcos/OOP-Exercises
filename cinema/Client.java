public class Client {
    private String id;
    private String phone;

    public Client(String id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return id + ":" + phone;
    }
}
