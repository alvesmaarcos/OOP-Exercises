enum Label{
    DEPOSIT("deposit"),
    FEE("fee"),
    OPENING("opening"),
    REVERSE("reverse"),
    WITHDRAW("withdraw"),
    ERROR("error");
    
    private final String label;
    Label(String label){
        this.label = label;
    }
    public String getLabel(){
        return label;
    }
}

class Operation{
    private int index;
    private Label label;
    private int value;
    private int balance;

    Operation(int index, Label label, int value, int balance){
        this.index = index;
        this.label = label;
        this.value = value;
        this.balance = balance;
    }
    public String toString(){
        return String.format("%2d: %8s: %4d: %4d", 
        this.index, this.label.getLabel(), this.value, this.balance);
        }
    
    public int getBalance(){
        return this.balance;
    }
    public int getIndex(){
        return this.index;
    }
    public Label getLabel(){
        return this.label;
    }
    public int getValue(){
        return this.value;
    }

}