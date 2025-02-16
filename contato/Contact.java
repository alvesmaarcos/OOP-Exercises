import java.util.ArrayList;
import java.util.List;

class Contact{
    boolean favorited;
    ArrayList<Fone> fones = new ArrayList<Fone>();
    String name;

    Contact(String name){
        this.name = name;
        this.favorited = false;
    }

    public void addFone(String id, String number){
        Fone fone = new Fone(id, number);
        if(fone.isValid()){
            fones.add(new Fone(id, number));
        }else{
            System.out.println("fail: invalid number");
        }
    }

    public void rmFone(int index){
        fones.remove(index);
    }

    public void toggleFavorited(){
        this.favorited = !this.favorited;
    }

    public boolean isFavorited(){
        return this.favorited;
    }

    /*public Fone getFones(){
        String s = "";
        s += "[";
        for(Fone fone : fones){
            s += (fone.toString());
        }
        s += "]";
        return s;
    }*/

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String toString(){
        String s = "";
        if(isFavorited()){
            s+=("@ ");
        }else{
            s+=("- ");
        }

        s+=(this.name + " ");
        s+=(fones.toString());
        return s;
    }
}

class Fone{
    String id;
    String number;

    Fone(String id, String number){
        this.id = id;
        this.number = number;
    }

    public boolean isValid() {
        return number.matches("[\\d().]+");
    }

    public String getNumber(){
        return this.number;
    }

    public String toString(){
        String s = "";
        s += (this.id + ":" + this.number);
        return s;
    }
}