package project.ex.musically;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    CardView taylor,fleurie,sleep,isaac;

    SearchView searchView;
    Animation anim_from_button, anim_from_left;
    static int turn =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        taylor = findViewById(R.id.taylorcard);
        fleurie =findViewById(R.id.fleuriecard);
        sleep = findViewById(R.id.sleepcard);
        isaac = findViewById(R.id.isaaccard);
        searchView = findViewById(R.id.search);
        //Load Animations
        anim_from_button = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        anim_from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);

        //Set Animations
        taylor.setAnimation(anim_from_button);
        fleurie.setAnimation(anim_from_button);
        sleep.setAnimation(anim_from_button);


        searchView.setAnimation(anim_from_left);
        taylor.setOnClickListener(this);
        fleurie.setOnClickListener(this);
        sleep.setOnClickListener(this);
        isaac.setOnClickListener(this);





        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        this.getWindow().getDecorView().setSystemUiVisibility(

                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.taylorcard):
                turn = 1;
                break;
            case(R.id.fleuriecard):
                turn = 2;
                break;
            case(R.id.sleepcard):
                turn = 3;
                break;
            case(R.id.isaaccard):
                turn = 4;
                break;
        }
        startActivity(new Intent(this,SecondActivity.class));
        overridePendingTransition(R.anim.appear, R.anim.disappear);
    }
}