package yash;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Transaction {
    private float Amount;
    private LocalDateTime date;
    private String notes;

    public Transaction(float amount, LocalDateTime date, String notes) {
        Amount = amount;
        this.date = date;
        this.notes = notes;
    }

    public float getAmount() {
        return Amount;
    }

    public void setAmount(float amount) {
        Amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}

class BankAccount {

    /**
     * These are class properties
     */

    /**
     * HDFC
     */

    public String Number;
    public String Owner;
    private float Balance;

    private List<Transaction> transactions = new ArrayList<>();

    private static int s_accountNumberSeed = 0;

    public BankAccount(String name, float initialBalance)
    {
        this.Owner = name;
        this.Balance = initialBalance;
        s_accountNumberSeed++;
        Number = String.valueOf(s_accountNumberSeed);

    }

    public float getBalance() {
        return Balance;
    }

    public void setBalance(float balance) {
        Balance = balance;
    }

    public String getS_accountNumberSeed() {
        return "Acc "+Number;
    }

    public void addTransaction(Transaction t) throws Exception {
        if (t.getAmount() < this.Balance) {
            this.transactions.add(t);
            this.Balance-=t.getAmount();
        } else {
            throw new YashBankException("Insufficient Balance");
        }
    }

    public void getAccountHistory() {
        for (Transaction t : transactions) {
            System.out.println("---------------------------------------------------");
            System.out.println(t.getAmount());
            System.out.println(t.getNotes());
            System.out.println(t.getDate());
            System.out.println("---------------------------------------------------");
        }
    }

}

public class YashLearn {

    public static void main(String[] args) throws Exception {
        BankAccount account1 = new BankAccount("Yash", 1000);
        Transaction transaction = new Transaction(100,LocalDateTime.now(),"ATM withdraw");
        account1.addTransaction(transaction);
        transaction = new Transaction(200,LocalDateTime.now(),"Petrol charges");
        account1.addTransaction(transaction);
        transaction = new Transaction(300,LocalDateTime.now(),"Food");
        account1.addTransaction(transaction);
        account1.getAccountHistory();
    }

}

class YashBankException extends Exception {
    public YashBankException(String message) {
        super(message);
    }
}