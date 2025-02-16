class Coin{
    private double value;
    private int volume;
    private String label;

    public Coin(double value, int volume, String label){
        this.value = value;
        this.volume = volume;
        this.label = label;
    }
    public static Coin C10 = new Coin(0.1, 1, "C10");
    public static Coin C25 = new Coin(0.25, 2, "C25");
    public static Coin C50 = new Coin(0.5, 3, "C50");
    public static Coin C100 = new Coin(1.0, 4, "C100");

    public double getValue() {
        return this.value;
    }

    public int getVolume() {
        return this.volume;
    }

    public String getLabel() {
        return this.label;
    }

    public String toString(){
        String s = "";
        s += String.format("%.2f:%d", getValue(), getVolume());
        return s;
    }
}