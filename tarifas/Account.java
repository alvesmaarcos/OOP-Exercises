class Account{
    private BalanceManager balanceManager;
    private int id;

    Account(int id){
        this.id = id;
        this.balanceManager = new BalanceManager();
        balanceManager.addOperation(Label.OPENING, 0);
    }

    public void deposit(int value){
        balanceManager.addOperation(Label.DEPOSIT, value);
    }

    public void fee(int value){
        balanceManager.addOperation(Label.FEE, value);
    }

    public void reverse(int index){
        Operation op = balanceManager.getOperation(index);
        if(index < 0 || index >= balanceManager.getExtract(0).size()){
            System.out.println(String.format("fail: index %d invalid", index));
            return;
        }
        if(op != null && (op.getLabel() == Label.FEE)){
            balanceManager.addOperation(Label.REVERSE, -op.getValue());
        }else{
            System.out.println(String.format("fail: index %d is not a fee", index));
        }// EXPLAIN
    }

    public void withdraw(int value){
        balanceManager.addOperation(Label.WITHDRAW, value);
    }

    public BalanceManager getBalanceManager(){
        return this.balanceManager;
    }

    @Override
    public String toString(){
        return "account:" + this.id + " balance:" + balanceManager.getBalance();
    }
}