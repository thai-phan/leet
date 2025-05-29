package solid.lsp;

class BankAccount {
    public long balance;

    public void Deposit(long amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public void Withdraw(long amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
        }
    }
}

class SavingsAccount extends BankAccount {
    @Override
    public void Withdraw(long amount) {
        // Savings accounts have a withdrawal limit of $1000
        if (amount > 0 && balance >= amount && amount <= 1000) {
            balance -= amount;
        }
    }
}

class CheckingAccount extends BankAccount {
    public long overdraftLimit = 100;

    @Override
    public void Withdraw(long amount) {
        if (amount > 0 && (balance + overdraftLimit) >= amount) {
            balance -= amount;
        }
    }
}

// Liskov Substitution Principle
public class Problem {

    public class TransactionProcessor {
        public void ProcessWithdrawal(BankAccount account, long amount) {
            account.Withdraw(amount);
            // Additional logic like logging, notifications, etc.
        }
    }


    public static void main(String[] args) {

        BankAccount account = new SavingsAccount();
        account.Deposit(2000);
        account.Withdraw(1500);



    }

    void transferFund(BankAccount from, BankAccount to, long amount) {
        from.Withdraw(amount);
        to.Deposit(amount);
    }
}