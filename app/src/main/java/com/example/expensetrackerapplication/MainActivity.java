package com.example.expensetrackerapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.expensetrackerapplication.logic.Expense;
import com.example.expensetrackerapplication.logic.ExpenseList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ExpenseList expenseList = new ExpenseList();

        Button AddExpenseMenu = findViewById(R.id.AddExpenseMenu);
        AddExpenseMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddExpenseActivity.class);
            startActivity(intent);
        });

        Button ViewExpenseMenu = findViewById(R.id.ViewExpenseMenu);
        ViewExpenseMenu.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewExpensesActivity.class);
            startActivity(intent);
        });

        TextView totalSpent = findViewById(R.id.total_spent);

        Button ViewTotalMenu = findViewById(R.id.ViewTotalMenu);
        ViewTotalMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double total = ExpenseList.getTotalSpent();
                String totalText = total.toString();
                totalSpent.setText(totalText);
            }
        });

        Button ExitMenu = findViewById(R.id.ExitMenu);
        ExitMenu.setOnClickListener(v -> {
            finish();
        });



    }

}