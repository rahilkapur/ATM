/**
 * The following program demonstrates an ATM machine
 * The ATM can successfully deposit, withdraw, answer balance and interest inquiries
 *  Based off of https://gist.github.com/bitsoda/1411218/570b4557fa98fc07cd1b4834bc417219d69a8eb2
 * @authors Rahil Kapur, Sahas Dandapantula
 */

import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        statement basic = new statement();
        System.out.println("Please enter the type of your account(Checking/Savings): ");
        String type = scnr.next();
        basic.setAccount(type);
        System.out.println("Please enter the starting balance of your account: ");
        basic.setBalance(scnr.nextDouble());
        basic.setRate();

        boolean inUse = true;

        while (inUse) { //UI of the ATM
            System.out.print(
                "Welcome to Java Credit Union, please enter a number " + "based off the following menu: \n \n" + "1. Deposit \n" + "2. Withdraw \n" + "3. Check Account Balance \n" + "4. View Account History \n" + "5. End Session\n \n" + "Enter Selection: ");

            int select = scnr.nextInt();
            //switch statement handling each of the 5 selections.
            switch (select) {
                case 1:
                    System.out.println("Enter the amount you would like to deposit: ");
                    double deposit = scnr.nextDouble();

                    basic.deposit(deposit);
                    System.out.println("Your " + type + basic.getBalance());
                    break;


                case 2:
                    System.out.println("Enter the amount you would like to withdraw: ");
                    double withdraw = scnr.nextDouble();

                    basic.withdraw(withdraw);
                    System.out.println("Your " + type + basic.getBalance());
                    break;

                case 3:
                    System.out.println("Your " + type + basic.getBalance());
                    break;


                case 4:
                    System.out.println(basic.getHistory());
                    break;


                case 5:
                    inUse = false;
                    break;


            }
        }
        System.out.println("\n Thank you for banking with Java Credit Union, have a good day!");

    }
}
