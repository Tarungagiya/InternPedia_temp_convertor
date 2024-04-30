package com.example.tempconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextTemperatureInput;
    TextView textViewTemperatureResultValue;
    Spinner spinnerTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTemperatureInput = findViewById(R.id.editTextTemperatureInput);
        textViewTemperatureResultValue = findViewById(R.id.textViewTemperatureResultValue);
        spinnerTemperature = findViewById(R.id.spinnerTemperature);

        // Populate spinner with unit options
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.temperature_units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTemperature.setAdapter(adapter);
    }

    public void convertTemperature(View view) {
        String temperatureInputText = editTextTemperatureInput.getText().toString();
        if (!temperatureInputText.isEmpty()) {
            double temperatureInput = Double.parseDouble(temperatureInputText);
            String selectedUnit = spinnerTemperature.getSelectedItem().toString();
            double temperatureResult;

            if (selectedUnit.equals("Celsius")) {
                temperatureResult = (temperatureInput * 9/5) + 32; // Convert Celsius to Fahrenheit
            } else {
                temperatureResult = (temperatureInput - 32) * 5/9; // Convert Fahrenheit to Celsius
            }

            textViewTemperatureResultValue.setText(String.format("%.2f %s", temperatureResult, selectedUnit));
        } else {
            textViewTemperatureResultValue.setText("Please enter a value.");
        }
    }
}
