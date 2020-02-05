package ammaibabai.universl.com.ammaibabai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.header_3.Header3_10Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_11Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_12Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_13Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_14Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_15Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_1Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_2Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_3Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_4Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_5Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_6Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_7Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_8Activity;
import ammaibabai.universl.com.ammaibabai.header_3.Header3_9Activity;

public class Header3Activity extends AppCompatActivity {
    Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9,bt10,bt11,bt12,bt13,bt14,bt15,bt16,bt17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header3);

        bt1= (Button) findViewById(R.id.btn1);
        bt2= (Button) findViewById(R.id.btn2);
        bt3= (Button) findViewById(R.id.btn3);
        bt4= (Button) findViewById(R.id.btn4);
        bt5= (Button) findViewById(R.id.btn5);
        bt6= (Button) findViewById(R.id.btn6);
        bt7= (Button) findViewById(R.id.btn7);

        bt8= (Button) findViewById(R.id.btn8);
        bt9= (Button) findViewById(R.id.btn9);
        bt10= (Button) findViewById(R.id.btn10);
        bt11= (Button) findViewById(R.id.btn11);
        bt12= (Button) findViewById(R.id.btn12);
        bt13= (Button) findViewById(R.id.btn13);
        bt14= (Button) findViewById(R.id.btn14);
        bt15= (Button) findViewById(R.id.btn15);
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
                Intent intent=new Intent(Header3Activity.this, Header3_1Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_2Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_3Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_4Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_5Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_6Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_7Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_8Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_9Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_10Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_11Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_12Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_13Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_14Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header3Activity.this, Header3_15Activity.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
