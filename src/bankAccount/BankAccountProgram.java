package bankAccount;

import java.io.*;
import java.util.*;

public class BankAccountProgram{
  public static void main(String[] args) {
    BankAccount nicksAcct = new BankAccount("Nick", 450, 550);
    BankAccount carolsAcct = new BankAccount("Carol", 600, 700);

    nicksAcct.printReport();
    carolsAcct.printReport();
    System.out.println("Total money in all accounts: $" + (nicksAcct.getCheckMoney() + nicksAcct.getSaveMoney() + carolsAcct.getCheckMoney() + carolsAcct.getSaveMoney()));

    System.out.println("Depositing $100");
    nicksAcct.makeCheckingDeposit(100);
    nicksAcct.printReport();

    System.out.println("Transferring funds...");

    carolsAcct.makeSavingsDeposit(nicksAcct.getSaveMoney());
    carolsAcct.makeCheckingDeposit(nicksAcct.getCheckMoney());

    nicksAcct.makeSavingsWithdrawal(nicksAcct.getSaveMoney());
    nicksAcct.makeCheckingWithdrawal(nicksAcct.getCheckMoney());

    System.out.println("Total money in all accounts: $" + (nicksAcct.getCheckMoney() + nicksAcct.getSaveMoney() + carolsAcct.getCheckMoney() + carolsAcct.getSaveMoney()));
  }
}
