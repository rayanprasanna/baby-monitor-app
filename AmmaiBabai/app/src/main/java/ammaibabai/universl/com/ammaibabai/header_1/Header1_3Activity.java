package ammaibabai.universl.com.ammaibabai.header_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.Header1Activity;
import ammaibabai.universl.com.ammaibabai.R;

public class Header1_3Activity extends AppCompatActivity {

    ImageButton nextImgeBtn,previousImgBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header1_3);

        TextView naviText= (TextView) findViewById(R.id.txtClose);

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(Header1_3Activity.this,Header1Activity.class);
                //startActivity(intent);
                finish();
            }
        });

        nextImgeBtn= (ImageButton) findViewById(R.id.nextButton);
        previousImgBtn= (ImageButton) findViewById(R.id.previousButton);

        nextImgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1_3Activity.this,Header1_4Activity.class);
                startActivity(intent);
                finish();
            }
        });
        previousImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1_3Activity.this,Header1_2Activity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
