package com.example.expensetrackerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.expensetrackerapplication.logic.ExpenseList;
import com.example.expensetrackerapplication.logic.Expense;

import java.util.ArrayList;

public class ViewExpensesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_view_expenses);

        ListView listView = findViewById(R.id.expense_listView);
        ArrayList<Expense> expenses = ExpenseList.getExpenses();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                convertExpensesToStrings(expenses)
        );
        listView.setAdapter(adapter);

        Button HomeMenu1 = findViewById(R.id.HomeMenu1);
        HomeMenu1.setOnClickListener(v -> {
            Intent intent = new Intent(ViewExpensesActivity.this, MainActivity.class);
            startActivity(intent);startActivity(intent);
        });
    }

    private ArrayList<String> convertExpensesToStrings(ArrayList<Expense> expenses) {
        ArrayList<String> list = new ArrayList<>();
        for (Expense e : expenses) {
            list.add(" - " + e.getDescription() + ", " + e.getAmount() + " (" + e.getCategory() + ")");
        }
        return list;
    };


}