import java.text.DecimalFormat;
import java.util.Random;

public class statement {
    //We set variables to help us with the getter and setter methods described below
    String account;
    double balance;
    double rate;
    int depcount;
    int withcount;
    Random rand = new Random();

    //Each getter or setter method helps set up the basic fundamentals of the ATM

    public void setRate() {
        rate = rand.nextDouble();
    }

    public void setBalance(double stBalance) {
        balance = stBalance;
    }

    public void setAccount(String stAccount) {
        if (stAccount.equalsIgnoreCase("Checking") || stAccount.equalsIgnoreCase("Savings")) {
            account = stAccount;
        } else {
            System.out.println("Error, please enter a valid account type");
            return;
        }
    }

    public void deposit(double money) {
        balance += money;
        ++depcount;
    }

    public void withdraw(double takeout) {
        if (balance < takeout) {
            System.out.println("Account has been overdrawn.");
            return;
        }
        balance -= takeout;
        ++withcount;

    }

    public String getBalance() {
        return "Account currently has $" + new DecimalFormat("#.##").format(balance) + ".";
    }

    public double getRate() {
        return rate;
    }

    public String getHistory() {
        String bal = getBalance();
        double ra = getRate();
        return "You have a balance of " + bal + " after " + depcount + " deposits and "
            + withcount + " withdrawals." +
            " As a reminder your current interest rate is " + new DecimalFormat(
            "#.##").format(ra) + ".";
    }

    public String getAccount() {
        return account;
    }

}
