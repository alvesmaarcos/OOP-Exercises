import java.util.List;
import java.util.ArrayList;

public class BalanceManager{
    private int balance;
    private List<Operation> extract;
    private int nextId;

    BalanceManager(){
        this.balance = 0;
        this.extract = new ArrayList<>();
        this.nextId = 0;
    }

    public void addOperation(Label label, int value){
        if (label == Label.DEPOSIT && value < 0) {
            System.out.println("fail: invalid value");
            return;
        }

        if(label == Label.WITHDRAW && getBalance() < value){
            System.out.println("fail: insufficient balance");
            return;
        }
        if(
            label == Label.WITHDRAW && value > this.balance){
            label = Label.ERROR;
        } else {
            if(label == Label.WITHDRAW || label == Label.FEE){
                this.balance -= value;
                value = -value;
            } else {
                this.balance += value;
            }
        }
        extract.add(new Operation(this.nextId++, label, value, getBalance()));   
    }

    public Operation getOperation(int index){
        return (index >= 0 && index < extract.size()) ? extract.get(index) : null;
    }

    public int getBalance(){
        return this.balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }

    public List<Operation> getExtract(int qtdOp){
        if (qtdOp == 0) {
            // Return the complete operations history
            return new ArrayList<>(extract);
        } else {
            // Return the most recent `qtdOp` operations
            return extract.subList(Math.max(0, extract.size() - qtdOp), extract.size());
        }
    }

    @Override
    public String toString(){
        return "balance:" + this.balance;
    }
}