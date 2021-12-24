package project.ex.icinema;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class SigninActivity extends AppCompatActivity {
    Animation goup,appear,dissappear, godown;
    EditText user,pass;
    ImageView logo;
    androidx.appcompat.widget.AppCompatButton signin;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        logo = findViewById(R.id.logo);
        signin = findViewById(R.id.loginbtn);
        godown = AnimationUtils.loadAnimation(this, R.anim.anim_from_top);
        goup = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);
        appear = AnimationUtils.loadAnimation(this,R.anim.appear);
        dissappear = AnimationUtils.loadAnimation(this,R.anim.dissappear);
        logo.setAnimation(goup);
        signin.setAnimation(godown);
        user.setAnimation(appear);
        pass.setAnimation(appear);

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
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY );
    }
}