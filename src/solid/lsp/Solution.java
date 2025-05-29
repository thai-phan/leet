package solid.lsp;

abstract class BankAccountS {
    public long Balance;


    public void Deposit(long amount) {
        if (amount > 0) {
            Balance += amount;
        }
    }

    public abstract boolean CanWithdraw(long amount);

    public void Withdraw(long amount) throws Exception {
        if (CanWithdraw(amount)) {
            Balance -= amount;
        } else {
            throw new Exception("Withdrawal not allowed");
        }
    }
}

class SavingsAccountS extends BankAccountS {
    public boolean CanWithdraw(long amount) {
        return amount > 0 && Balance >= amount && amount <= 1000;
    }
}

class CheckingAccountS extends BankAccountS {
    public long OverdraftLimit = 100;

    public boolean CanWithdraw(long amount) {
        return amount > 0 && (Balance + OverdraftLimit) >= amount;
    }
}

public class Solution {
    public static void main(String[] args) {


    }
}
