package com.artyushin.hw091;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button buttonLanguage;
    private Button buttonTheme;
    private Spinner languageSpinner;
    private Spinner themeSpinner;
    String selectedLanguage;
    String selectedTheme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Utils.onActivityCreateSetTheme(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchLanguage();
        switchTheme();
    }

    private void switchLanguage() {
        buttonLanguage = findViewById(R.id.buttonLanguage);
        languageSpinner = findViewById(R.id.languageSpinner);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.languageSpinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        languageSpinner.setAdapter(adapter);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                selectedLanguage = languageSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, selectedLanguage,Toast.LENGTH_LONG).show();
                switch (selectedLanguage) {
                    case "Russian":
                        russian();
                        break;
                    case "English":
                        english();
                        break;
                    case "Английский":
                        english();
                        break;
                    case "Русский":
                        russian();
                        break;
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void russian() {
        Locale locale = new Locale("ru");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void english() {
        Locale locale = new Locale("en");
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }

    private void switchTheme() {
        buttonTheme = findViewById(R.id.buttonTheme);
        themeSpinner = findViewById(R.id.themeSpinner);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.themeSpinner,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        themeSpinner.setAdapter(adapter);

        themeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView parent, View view, int position, long id) {
                selectedTheme = themeSpinner.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView parent) {
            }
        });

        buttonTheme.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, selectedTheme,Toast.LENGTH_LONG).show();
                switch (selectedTheme) {
                    case "Черный":
                        Utils.changeToTheme(MainActivity.this, R.style.BlackTheme);
                        break;
                    case "Зеленый":
                        Utils.changeToTheme(MainActivity.this, R.style.GreenTheme);
                        break;
                    case "Синий":
                        Utils.changeToTheme(MainActivity.this, R.style.BlueTheme);
                        break;
                    case "Black":
                        Utils.changeToTheme(MainActivity.this, R.style.BlackTheme);
                        break;
                    case "Green":
                        Utils.changeToTheme(MainActivity.this, R.style.GreenTheme);
                        break;
                    case "Blue":
                        Utils.changeToTheme(MainActivity.this, R.style.BlueTheme);
                        break;
                }
            }
        });
    }
}