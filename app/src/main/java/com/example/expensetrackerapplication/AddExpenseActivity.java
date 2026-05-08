package com.example.expensetrackerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.example.expensetrackerapplication.logic.ExpenseList;

public class AddExpenseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_expense);

        EditText descriptionInput = findViewById(R.id.description_input);
        EditText amountInput = findViewById(R.id.amount_input);
        EditText categoryInput = findViewById(R.id.category_input);
        Button submitButton = findViewById(R.id.buttonSubmit);

        ExpenseList expenseList = new ExpenseList();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = descriptionInput.getText().toString().trim();
                String amountText = amountInput.getText().toString().trim();
                String category = categoryInput.getText().toString().trim();

                Double amount = Double.parseDouble(amountText);

                if (amount > 0) {
                    expenseList.addExpense(description, amount, category);
                    Toast.makeText(getApplicationContext(), "Expense added!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid amount. Expense not added.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button HomeMenu = findViewById(R.id.HomeMenu);
        HomeMenu.setOnClickListener(v -> {
            Intent intent = new Intent(AddExpenseActivity.this, MainActivity.class);
            startActivity(intent);
        });


    }
}