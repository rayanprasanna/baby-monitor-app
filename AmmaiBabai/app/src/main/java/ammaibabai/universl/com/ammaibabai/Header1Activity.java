package ammaibabai.universl.com.ammaibabai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.header_1.Header1_1Activity;
import ammaibabai.universl.com.ammaibabai.header_1.Header1_2Activity;
import ammaibabai.universl.com.ammaibabai.header_1.Header1_3Activity;
import ammaibabai.universl.com.ammaibabai.header_1.Header1_4Activity;
import ammaibabai.universl.com.ammaibabai.header_1.Header1_5Activity;
import ammaibabai.universl.com.ammaibabai.header_1.Header1_6Activity;
import ammaibabai.universl.com.ammaibabai.header_1.Header1_7Activity;
import ammaibabai.universl.com.ammaibabai.header_1.Header1_8Activity;

public class Header1Activity extends AppCompatActivity {

    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_header1);
        bt1= (Button) findViewById(R.id.btn1);
        bt2= (Button) findViewById(R.id.btn2);
        bt3= (Button) findViewById(R.id.btn3);
        bt4= (Button) findViewById(R.id.btn4);
        bt5= (Button) findViewById(R.id.btn5);
        bt6= (Button) findViewById(R.id.btn6);
        bt7= (Button) findViewById(R.id.btn7);
        bt8= (Button) findViewById(R.id.btn8);
        TextView naviText= (TextView) findViewById(R.id.txtClose);

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(Header1Activity.this,MenuActivity.class);
                //startActivity(intent);
                finish();

            }
        });


        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_1Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_2Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_3Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_4Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_5Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_6Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_7Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header1Activity.this, Header1_8Activity.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
