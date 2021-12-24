package project.ex.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedpreferences;
    TextView name, pass;
    Button login, clear, retrieve;
    BroadcastReceiver Air = new MyReceiver();
    IntentFilter f = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(Air,f);
        name = (TextView) findViewById(R.id.name);
        pass = (TextView) findViewById(R.id.pass);
        login = findViewById(R.id.login);
        sharedpreferences = getSharedPreferences("mypreference", MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                if(name.getText().toString().equals(""))  editor.putString("name","Please, Enter a name");
                else
                editor.putString("name",name.getText().toString());
                if(pass.getText().toString().equals("")) editor.putString("pass","Please, Enter a pass");
                else editor.putString("pass",pass.getText().toString());
                editor.apply();
                name.setText(""); pass.setText("");
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }
}