package ammaibabai.universl.com.ammaibabai.header_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.Header2Activity;
import ammaibabai.universl.com.ammaibabai.R;
import ammaibabai.universl.com.ammaibabai.header_2.header_2_6.Header_2_6_1Activity;
import ammaibabai.universl.com.ammaibabai.header_2.header_2_6.Header_2_6_2Activity;
import ammaibabai.universl.com.ammaibabai.header_2.header_2_6.Header_2_6_3Activity;
import ammaibabai.universl.com.ammaibabai.header_2.header_2_6.Header_2_6_4Activity;

public class Header2_6Activity extends AppCompatActivity {
    Button butn1,butn2,butn3,butn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header2_6);
        butn1= (Button) findViewById(R.id.btn1);
        butn2= (Button) findViewById(R.id.btn2);
        butn3= (Button) findViewById(R.id.btn3);
        butn4= (Button) findViewById(R.id.btn4);

        TextView naviText= (TextView) findViewById(R.id.txtClose);

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(getBaseContext(),Header2Activity.class);
                //startActivity(intent);
                finish();
            }
        });

        butn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header2_6Activity.this, Header_2_6_1Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        butn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header2_6Activity.this, Header_2_6_2Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        butn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header2_6Activity.this, Header_2_6_3Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        butn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Header2_6Activity.this, Header_2_6_4Activity.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
