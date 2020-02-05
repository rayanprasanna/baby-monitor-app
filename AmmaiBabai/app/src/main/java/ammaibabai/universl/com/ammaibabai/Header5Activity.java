package ammaibabai.universl.com.ammaibabai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.header_4.Header4_1Activity;
import ammaibabai.universl.com.ammaibabai.header_5.Header5_1Activity;
import ammaibabai.universl.com.ammaibabai.header_5.Header5_2Activity;
import ammaibabai.universl.com.ammaibabai.header_5.Header5_3Activity;
import ammaibabai.universl.com.ammaibabai.header_5.Header5_4Activity;
import ammaibabai.universl.com.ammaibabai.header_5.Header5_5Activity;

public class Header5Activity extends AppCompatActivity {
    Button bt1,bt2,bt3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header5);

        bt1= (Button) findViewById(R.id.btn1);
        bt2= (Button) findViewById(R.id.btn2);
        bt3= (Button) findViewById(R.id.btn3);
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
                Intent intent=new Intent(getBaseContext(), Header5_1Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(), Header5_2Activity.class);
                startActivity(intent);
                //finish();
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(), Header5_3Activity.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
