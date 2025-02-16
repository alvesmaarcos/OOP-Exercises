import java.util.ArrayList;

class Pig{
    private boolean broken;
    private ArrayList<Coin> coins = new ArrayList<>();
    private ArrayList<Item> items =  new ArrayList<>();
    private int volumeMax;

    public Pig(int volumeMax){
        this.coins = new ArrayList<>();
        this.items = new ArrayList<>();
        this.broken = false;
        this.volumeMax = volumeMax;
    }

    public boolean addCoin(Coin coin){
        if(isBroken()){
            System.out.println("fail: the pig is broken");
            return false;
        }

        if(getVolume() + coin.getVolume() > this.volumeMax){
            System.out.println("fail: the pig is full");
            return false;
        }

        this.coins.add(coin);
        return true;
    }

    public boolean addItem(Item item){
        if(isBroken()){
            System.out.println("fail: the pig is broken");
            return false;
        }

        if(getVolume() + item.getVolume() > this.volumeMax){
            System.out.println("fail: the pig is full");
            return false;
        }

        this.items.add(item);
        return true;
    }

    public boolean breakPig(){
        if(isBroken()){
            System.out.println("fail: the pig is already broken");
            return false;
        }

        this.broken = true;
        return true;
    }


    public String getCoins(){
        String s = "";
        for(int i = 0; i < this.coins.size(); i++){
            Coin coin = this.coins.get(i);
            s += coin.toString();
            if(i < this.coins.size() - 1){
                s += ", ";
            }
        }
        return s;
    }

    public String getItems(){
        String s = "";
        for(int i = 0; i < this.items.size(); i++){
            Item item = this.items.get(i);
            s += item.toString();
            if(i < this.items.size() - 1){
                s += ", ";
            }
        }
        return s;
    }

    public int getVolume(){

        if(isBroken()){
            return 0;
        }

        int volume = 0;
        for (Item item : this.items){
            volume += item.getVolume();
        }
        for (Coin coin : this.coins){
            volume += coin.getVolume();
        }
        return volume;
    }

    public int getVolumeMax(){
        return this.volumeMax;
    }

    public double getValue(){
        double value = 0;
        for (Coin coin : this.coins){
            value += coin.getValue();
        }
        return value;
    }

    public boolean isBroken(){
        return this.broken;
    }

    public void extractCoins(){
        if(!isBroken()){
        System.out.println("fail: you must break the pig first\n[]");
        return;
        }

        System.out.println(String.format("[%s]", getCoins()));
        this.coins.clear();
    }

    public void extractItems(){
        if(!isBroken()){
        System.out.println("fail: you must break the pig first\n[]");
        return;
        }

        System.out.println(String.format("[%s]", getItems()));
        this.items.clear();
    }

    public String toString(){

        String state = "";
        if(isBroken()){
            state = "broken";
        }else{
            state = "intact";
        }
        String s = "";
        s += String.format("state=%s : coins=[%s] : items=[%s] : value=%.2f : volume=%d/%d",
                            state,
                            getCoins(),
                            getItems(),
                            getValue(),
                            getVolume(),
                            getVolumeMax());
        return s;
    }
}