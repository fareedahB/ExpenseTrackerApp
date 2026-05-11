package com.example.expensetrackerapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.content.Intent;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.expensetrackerapplication.logic.Expense;
import com.example.expensetrackerapplication.logic.ExpenseList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ExpenseList expenseList = new ExpenseList();

        getSupportActionBar().setTitle("EXPENSE TRACKER APP");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Button AddExpenseMenu = findViewById(R.id.AddExpenseMenu);
        AddExpenseMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
            startActivity(intent);
        });


        TextView totalSpent = findViewById(R.id.total_spent);
        Double total = ExpenseList.getTotalSpent();
        String totalText = "Total Spent: $" + total.toString();
        totalSpent.setText(totalText);

        TextView totalSpent2 = findViewById(R.id.total_spent2);
        totalSpent2.setText(totalText);

        ListView listView = findViewById(R.id.expense_listView);
        ArrayList<Expense> expenses = ExpenseList.getExpenses();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                convertExpensesToStrings(expenses)
        );
        listView.setAdapter(adapter);


    }
    private ArrayList<String> convertExpensesToStrings(ArrayList<Expense> expenses) {
        ArrayList<String> list = new ArrayList<>();
        for (Expense e : expenses) {
            list.add(" - " + e.getDescription() + ", " + e.getAmount() + " (" + e.getCategory() + ")");
        }
        return list;
    }
}