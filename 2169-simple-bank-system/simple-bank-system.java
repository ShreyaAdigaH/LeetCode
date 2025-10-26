class Bank {

    long[] bankAccount;
    int len;
    public Bank(long[] balance) {
        bankAccount = balance;
        len = balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1 > len || account2 > len || bankAccount[account1 - 1] < money) 
            return false;
        bankAccount[account1 - 1] -= money;
        bankAccount[account2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account > len) 
            return false;
        bankAccount[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account > len || bankAccount[account - 1] < money) 
            return false;
        bankAccount[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */