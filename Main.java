import java.util.Scanner;

abstract class Transaction {
    private double amount;

    Transaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    abstract void displayDetails();
}

class Income extends Transaction {
    Income(double amount) {
        super(amount);
    }

    @Override
    void displayDetails() {
        System.out.println("Income Amount: " + getAmount());
    }
}

class Expense extends Transaction {
    Expense(double amount) {
        super(amount);
    }

    @Override
    void displayDetails() {
        System.out.println("Expense Amount: " + getAmount());
    }
}

class FinanceManager {
    private double totalIncome;
    private double totalExpense;

    void addIncome(Income income) {
        totalIncome += income.getAmount();
    }

    void addExpense(Expense expense) {
        totalExpense += expense.getAmount();
    }

    void displaySummary() {
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expense: " + totalExpense);
        System.out.println("Remaining Balance: " + (totalIncome - totalExpense));
    }

    void displayTransaction(Transaction transaction) {
        transaction.displayDetails();
    }
}

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        FinanceManager manager = new FinanceManager();

        System.out.println("Personal Finance Manager");

        System.out.print("Enter Total Income: ");
        double incomeAmount = input.nextDouble();

        System.out.print("Enter Total Expense: ");
        double expenseAmount = input.nextDouble();

        Income income = new Income(incomeAmount);
        Expense expense = new Expense(expenseAmount);

        manager.addIncome(income);
        manager.addExpense(expense);

        System.out.println("\nIncome Details:");
        manager.displayTransaction(income);

        System.out.println("\nExpense Details:");
        manager.displayTransaction(expense);

        System.out.println("\nFinal Summary:");
        manager.displaySummary();

        input.close();
    }
}
