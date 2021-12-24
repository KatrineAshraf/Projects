package project.ex.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
TextView name,pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        name = findViewById(R.id.name);
        pass = findViewById(R.id.pass);
        SharedPreferences sharedPref =getSharedPreferences("mypreference",MODE_PRIVATE);
        if (sharedPref.contains("name")) name.setText(sharedPref.getString("name",""));
        if (sharedPref.contains("pass")) pass.setText(sharedPref.getString("pass",""));

    }
}