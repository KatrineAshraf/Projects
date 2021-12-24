package project.ex.musically;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    ImageView second_back_arrow, second_arrow_up;
    TextView second_title, second_subtitle, second_songtitle,  more_details;
    Animation from_left, from_right, from_bottom;
    layouts layer;
    String lyrics;
    View image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        image = findViewById(R.id.wallpaper);
        second_back_arrow = findViewById(R.id.second_back_arrow);
        second_songtitle = findViewById(R.id.second_songtitle);
        second_arrow_up = findViewById(R.id.seconf_arrow_up);
        second_title = findViewById(R.id.second_title);
        second_subtitle = findViewById(R.id.second_subtitle);
        more_details = findViewById(R.id.more_details);
        //to change layers
        int turn = MainActivity.turn;
        switch(turn){
            case 1: {
                lyrics = "I sit and watch you reading with your\n" +
                        "Head low\nI wake and watch you breathing with your\nEyes closed\nI sit and watch you" +
                        "\nAnd notice everything you do or don't do\n" +
                        "You're so much older and wiser and I\nI wait by the door like I'm just a kid" +
                        "\nUse my best colors for your portrait\nLay the table with the fancy shit" +
                        "\nAnd watch you tolerate it\n" +
                        "If it's all in my head tell me now\nTell me I've got it wrong somehow" +
                        "\nI know my love should be celebrated\nBut you tolerate it\n....";
                layer = new layouts(R.drawable.taylorwp,lyrics,"Taylor Swift","Tolerate it");
                break;}
            case 2:{
                lyrics =
                        "I can feel your heart hanging in the air\n" +
                                "I'm counting every step as you climb the stairs\n" +
                                "It's buried in your bones, I see it in your closed eyes\n" +
                                "Turning in, this is harder than we know\n" +
                                "We hold it in the most when we're wearing thin\n" +
                                "Comin' like a hurricane, I take it in real slow\n" +
                                "The world is spinning like a weathervane\n" +
                                "Fragile and composed\n" +
                                "Though I am breaking down again\n" +
                                "I am aching now to let you in\n.....";
                layer = new layouts(R.drawable.fleuriewp,lyrics,"Fleurie","Hurricane");
                break;
            }
            case 3:{
                lyrics = "Maybe I've done enough\n" +
                        "And your golden child grew up\n" +
                        "Maybe this trophy isn't real love\n" +
                        "And with or without it I'm good enough\n" +
                        "Maybe I've done enough\n" +
                        "Finally catching up\n" +
                        "For the first time I see an image of my brokenness\n" +
                        "Utterly worthy of love\n" +
                        "Maybe I've done enough\n" +
                        "And I finally see myself\n" +
                        "Through the eyes of no one else\n" +
                        "It's so exhausting on this silver screen\n" +
                        "Where I play the role of anyone but me\n......";
                layer = new layouts(R.drawable.sleepwp,lyrics,"Sleeping At Last","Three");
                break;
            }
            case 4:{
                lyrics = "I still look at you with eyes that want you\n" +
                        "When you move, you make my oceans move too\n" +
                        "If I hear my name, I will run your way\n" +
                        "Can we say that we love each other\n" +
                        "Can we play like there ain't no other\n" +
                        "if I hear my name, I will run your way\n" +
                        "It's my desire that you feed\n" +
                        "You know just what I need\n" +
                        "You got power, you got power\n" +
                        "You got power over me\n" +
                        "I give my all now, can't you see\n" +
                        "Why won't you set me free?\n" +
                        "You got power, you got power\n" +
                        "You got power over me\n......";
                layer = new layouts(R.drawable.isaacwp,lyrics,"Isak Danielson","Power");
                break;
            }
        }



        second_title.setText(layer.getArtist());
        second_songtitle.setText(layer.getSong());
        second_subtitle.setText(layer.getLyrics());
        image.setBackgroundResource(layer.getImage());





        second_back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.anim_from_left, R.anim.anim_to_right);
            }
        });
        this.getWindow().getDecorView().setSystemUiVisibility(

                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        );
        from_left = AnimationUtils.loadAnimation(this, R.anim.anim_from_left);
        from_right = AnimationUtils.loadAnimation(this, R.anim.anim_from_right);
        from_bottom = AnimationUtils.loadAnimation(this, R.anim.anim_from_bottom);



        //Set Animations
        second_back_arrow.setAnimation(from_left);
        second_title.setAnimation(from_right);
        second_songtitle.setAnimation(from_right);
        second_subtitle.setAnimation(from_bottom);
        second_arrow_up.setAnimation(from_bottom);
        more_details.setAnimation(from_bottom);
        more_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
                overridePendingTransition(R.anim.anim_from_bottom, R.anim.anim_to_top);
            }
        });
        second_arrow_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SecondActivity.this, ThirdActivity.class));
                overridePendingTransition(R.anim.anim_from_bottom, R.anim.anim_to_top);
            }
        });
    }
}