package project.ex.musically;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    LinearLayout layout;
    Button btnPlay, btnStop, btnFastForward, btnFastBackWard;
    TextView txtSongStart, txtSongEnd,song,artist,album ;
    SeekBar seekMusicBar;
    androidx.appcompat.widget.AppCompatButton back;

    ImageView imageView;


    String songName;
    public static final String EXTRA_NAME = "song_name";
    static MediaPlayer mediaPlayer;
    Media media;


    Thread updateSeekBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        int turn = MainActivity.turn;
        this.getWindow().getDecorView().setSystemUiVisibility(

                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        //Assigning the address of the andorid Materials
        btnPlay = (Button) findViewById(R.id.BtnPlay);
        btnFastForward = (Button) findViewById(R.id.BtnFastForward);
        btnFastBackWard = (Button) findViewById(R.id.BtnFastRewind);
        btnStop = findViewById(R.id.BtnStop);
        txtSongStart = (TextView) findViewById(R.id.TxtSongStart);
        txtSongEnd = (TextView) findViewById(R.id.TxtSongEnd);
        seekMusicBar = (SeekBar) findViewById(R.id.SeekBar);
        imageView = (ImageView) findViewById(R.id.MusicImage);
        song = findViewById(R.id.Song);
        album =findViewById(R.id.album);
        artist = findViewById(R.id.artist);
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setBackgroundResource(R.drawable.play_song_icon);

                //Pausing the current media
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                songEndTime();
                startActivity(new Intent(ThirdActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.anim_from_left, R.anim.anim_to_right);
            }
        });

        //Checking if any song playing or not
        if (mediaPlayer != null) {

            //we will start mediaPlayer if currently there is no songs in it
            mediaPlayer.start();
            mediaPlayer.release();
        }
        switch(turn){
            case 1: {
                media = new Media(R.drawable.tayloralb,R.raw.tolerateit,"Taylor Swift","Tolerate it","Evermore");
                break;}
            case 2:{
                media = new Media(R.drawable.fleuriealb,R.raw.hurricane,"Fleurie","Hurricane","Hurricane");
                break;
            }
            case 3:{
                media = new Media(R.drawable.sleepalb,R.raw.three,"Sleeping At Last","Three","Ghosts");
                break;
            }
            case 4:{
                media = new Media(R.drawable.isakalb,R.raw.power,"Isak Danielson","Power","Run To You");
                break;
            }}
        mediaPlayer =MediaPlayer.create(this,media.getSong());
        imageView.setImageResource(media.getImage());
        song.setText(media.getSong_name());
        album.setText(media.getAlbum());
        artist.setText(media.getArtist());

        btnPlay.setBackgroundResource(R.drawable.pause_song_icon);
        songEndTime();
        mediaPlayer.start();

        //Getting the Required Details from the past Intent
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();



        //Thread to update the seekBar while playing song

        updateSeekBar = new Thread() {
            @Override
            public void run() {

                int TotalDuration = mediaPlayer.getDuration();
                int Current = 0;

                while (Current < TotalDuration) {
                    try {

                        sleep(500);
                        Current = mediaPlayer.getCurrentPosition();
                        seekMusicBar.setProgress(Current);

                    } catch (InterruptedException | IllegalStateException e) {

                        e.printStackTrace();
                    }
                }

            }
        };


        //Setting the seekbar's max progress to the maximum duration of the media file
        seekMusicBar.setMax(mediaPlayer.getDuration());
        updateSeekBar.start();


        //Setting the Music player from the position of the seekbar
        seekMusicBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                //getting the progress of the seek bar and setting it to Media Player
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });


        //Creating the Handler to update the current duration
        final Handler handler = new Handler();
        final int delay = 1000;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                //Getting the current duration from the media player
                String currentTime = createDuration(mediaPlayer.getCurrentPosition());
                String remainder = createDuration(mediaPlayer.getDuration()-mediaPlayer.getCurrentPosition());
                //Setting the current duration in textView
                txtSongStart.setText(currentTime);
                txtSongEnd.setText(remainder);
                handler.postDelayed(this, delay);

            }
        }, delay);


        //Implementing OnClickListener for Play and Pause Button
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Checking playing any songs or not
                if (mediaPlayer.isPlaying()) {

                    //setting the play icon
                    btnPlay.setBackgroundResource(R.drawable.play_song_icon);

                    //Pausing the current media
                    mediaPlayer.pause();

                } else {

                    //Setting the pause icon
                    btnPlay.setBackgroundResource(R.drawable.pause_song_icon);

                    //Starting the media player
                    mediaPlayer.start();

                    //Creating the Animation


                    //Calling the BarVisualizer

                }
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnPlay.setBackgroundResource(R.drawable.play_song_icon);

                //Pausing the current media
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
                songEndTime();
            }
        });
        //Implementing the fastForward
        btnFastForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {

                    //Getting the current position and adding 10sec to it
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() + 10000);

                }
            }
        });


        //Implementing the FastBackWard
        btnFastBackWard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {

                    //Getting the curent Position of the song and decrease 10sec from it
                    mediaPlayer.seekTo(mediaPlayer.getCurrentPosition() - 10000);

                }
            }
        });

    }



    //Preparing the Time format for setting to textView
    public String createDuration(int duration) {

        String time = "";
        int min = duration / 1000 / 60;
        int sec = duration / 1000 % 60;

        time = time + min + ":";

        if (sec < 10) {

            time += "0";

        }
        time += sec;
        return time;

    }




    //Method To extract the duration of the current media and setting it to TextView
    public void songEndTime() {
        String endTime = createDuration(mediaPlayer.getDuration());
        txtSongEnd.setText(endTime);
    }


    //Releasing the BarVisualizer on Closing the Activity
    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}