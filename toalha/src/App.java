class Towel{
    private String color;
    private String size;
    private int wetness;

    public Towel(String color, String size){
        this.color = color;
        this.size = size;
        this.wetness = 0;
    }

    public void Dry(int dry){
        if(getWetness() == getMaxWetness()){
            System.out.println("fail: toalha encharcada");
            return;
        }   
        setWetness(getWetness() + dry);
    }

    public void wringOut(){
        setWetness(0);
    }

    public boolean isDry(){
        if(getWetness() == 0)
            return true;

        return false;
    }

    public int getMaxWetness(){
        if(getSize().equals("P"))
            return 10;
        if(getSize().equals("M"))
            return 20;
        return 30;
    }
    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public int getWetness() {
        return wetness;
    }

    public void setWetness(int wetness) {
        this.wetness = wetness;
    }
    
    @Override
    public String toString() {
        return String.format("%s %s %d", this.color, this.size, this.wetness);
    }
    
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
