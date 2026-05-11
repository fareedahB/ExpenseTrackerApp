package com.example.expensetrackerapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


import com.example.expensetrackerapplication.logic.ExpenseList;


public class AddExpenseActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String selected ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_expense);

        getSupportActionBar().setTitle("ADD EXPENSE");
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        EditText descriptionInput = findViewById(R.id.description_input);
        EditText amountInput = findViewById(R.id.amount_input);
        Button submitButton = findViewById(R.id.buttonSubmit);

        Spinner categorySpinner = findViewById(R.id.category_spinner);
        String[] categories = getResources().getStringArray(R.array.category_array);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
        categorySpinner.setOnItemSelectedListener(this);

        ExpenseList expenseList = new ExpenseList();

        submitButton.setOnClickListener(v -> {
            String description = descriptionInput.getText().toString().trim();
            String amountText = amountInput.getText().toString().trim();
            String category = selected.trim();

            if (!description.isEmpty() && !amountText.isEmpty() && !category.isEmpty()) {
                try {
                    double amount = Double.parseDouble(amountText);
                    if (amount > 0) {
                        expenseList.addExpense(description, amount, category);
                        Toast.makeText(getApplicationContext(), "Expense added!", Toast.LENGTH_SHORT).show();
                        descriptionInput.setText("");
                        amountInput.setText("");
                    } else {
                        Toast.makeText(getApplicationContext(), "Amount must be greater than 0", Toast.LENGTH_SHORT).show();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Enter a valid number", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "All input fields are required.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selected = parent.getItemAtPosition(position).toString();
    }
    public void onNothingSelected(AdapterView<?> parent) {
        selected = ""; // fallback
    }

}