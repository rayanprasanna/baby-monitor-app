package ammaibabai.universl.com.ammaibabai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.R;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_1Activity;
import ammaibabai.universl.com.ammaibabai.header_4.Header4_1Activity;
import ammaibabai.universl.com.ammaibabai.header_4.Header4_2Activity;
import ammaibabai.universl.com.ammaibabai.header_4.Header4_3Activity;
import ammaibabai.universl.com.ammaibabai.header_4.Header4_4Activity;
import ammaibabai.universl.com.ammaibabai.header_4.Header4_5Activity;

public class Header4Activity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header4);

        bt1= (Button) findViewById(R.id.btn1);
        bt2= (Button) findViewById(R.id.btn2);
        bt3= (Button) findViewById(R.id.btn3);
        bt4= (Button) findViewById(R.id.btn4);
        bt5= (Button) findViewById(R.id.btn5);
        bt6= (Button) findViewById(R.id.btn6);
        bt7= (Button) findViewById(R.id.btn7);

        TextView naviText= (TextView) findViewById(R.id.txtClose);

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(getBaseContext(),MenuActivity.class);
                //startActivity(intent);
                finish();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header4Activity.this, Header4_1Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header4Activity.this, Header4_2Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header4Activity.this, Header4_3Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header4Activity.this, Header4_4Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header4Activity.this, Header4_5Activity.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
