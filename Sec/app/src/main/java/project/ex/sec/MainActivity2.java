package project.ex.sec;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {
ImageView Tv_image;
Button bt,next,back;
final static int CA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bt = findViewById(R.id.capture);
        next = findViewById(R.id.next);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class ));
            }
        });
        Tv_image = findViewById(R.id.img);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent capture = new Intent();
                capture.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(capture, CA);

            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==CA && resultCode == RESULT_OK){
            Bitmap b = (Bitmap) data.getExtras().get("data");
            Tv_image.setImageBitmap(b);
        }

    }
}