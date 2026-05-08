package com.example.expensetrackerapplication.logic;

import java.util.ArrayList;
import com.example.expensetrackerapplication.logic.Expense;
public class ExpenseList {
    private static ArrayList<Expense> expenses = new ArrayList<>();


    public void addExpense(String description, double amount, String category){
        expenses.add(new Expense(description, amount, category));
    }

    public static ArrayList<Expense> getExpenses() {
        return expenses;
    }

    public static Double getTotalSpent(){
        double total = 0;

        for (Expense e : ExpenseList.getExpenses()) {
            total += e.getAmount();
        }
        return total;
    }
}