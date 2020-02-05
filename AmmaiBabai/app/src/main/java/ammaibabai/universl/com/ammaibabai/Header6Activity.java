package ammaibabai.universl.com.ammaibabai;


import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;


public class Header6Activity extends AppCompatActivity {
    private Button b2;
    MediaPlayer mediaPlayer=new MediaPlayer();
    private Handler myHandler = new Handler();
    ImageView onImageView,offImageView;
    private TextView contentText;
    ImageButton nextButton,previousButton;

    public static int oneTimeOnly = 0;

    private double startTime = 0;
    private double finalTime = 0;
    private int curPosition = 0 ;
    private String[] listContents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header6);

        mediaPlayer = MediaPlayer.create(this, R.raw.song);

        TextView naviText = (TextView) findViewById(R.id.txtClose);
        contentText = (TextView) findViewById(R.id.contentText);

        onImageView= (ImageView) findViewById(R.id.onId);
        offImageView= (ImageView) findViewById(R.id.offId);

        nextButton = (ImageButton) findViewById(R.id.nextButton);
        previousButton= (ImageButton) findViewById(R.id.previousButton);

        setData();
        viewContent();
        actionMethods();

        playSound();

        offImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                offImageView.setVisibility(View.INVISIBLE);
                onImageView.setVisibility(View.VISIBLE);
            }

        });

        onImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            playSound();
            }
        });

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(Header6Activity.this, MenuActivity.class);
               // startActivity(intent);
                mediaPlayer.stop();
                finish();
            }
        });

    }

    private void actionMethods() {
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curPosition++;
                viewContent();
                if ((listContents.length - 1) >= curPosition) {
                    previousButton.setVisibility(View.VISIBLE);
                }
                if ((listContents.length - 1) <= curPosition) {
                    nextButton.setVisibility(View.INVISIBLE);
                }

            }
        });

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curPosition--;
                viewContent();
                if (curPosition >= 0) {
                    nextButton.setVisibility(View.VISIBLE);
                }
                if (curPosition <= 0) {
                    previousButton.setVisibility(View.INVISIBLE);
                }

            }
        });
    }

    private void viewContent() {
        contentText.setText(listContents[curPosition]);
    }

    private void setData() {
        Intent intent = getIntent();
        listContents = intent.getExtras().getStringArray("contents");
        curPosition = intent.getExtras().getInt("pos");

        if(curPosition == (listContents.length-1)){
            nextButton.setVisibility(View.INVISIBLE);
        }
        if(curPosition == 0){
            previousButton.setVisibility(View.INVISIBLE);
        }

    }

    private void playSound() {
        mediaPlayer.start();

        finalTime = mediaPlayer.getDuration();
        startTime = mediaPlayer.getCurrentPosition();
        myHandler.postDelayed(UpdateSongTime,100);
        onImageView.setVisibility(View.INVISIBLE);
        offImageView.setVisibility(View.VISIBLE);

    }

    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mediaPlayer.getCurrentPosition();
            myHandler.postDelayed(this, 100);
        }
    };


}
