package project.ex.sec;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etNumber; Button bt,next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNumber = findViewById(R.id.edit);
        bt = findViewById( R.id.btn);
        next = findViewById( R.id.next);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //implicit intents
                String number = etNumber.getText().toString();
                Intent dial = new Intent();
                //new
                {  dial.setAction(Intent.ACTION_DIAL);
                Uri u = Uri.parse("tel:\t" + number);
                dial.setData(u); }

                startActivity(dial);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });

    }
}