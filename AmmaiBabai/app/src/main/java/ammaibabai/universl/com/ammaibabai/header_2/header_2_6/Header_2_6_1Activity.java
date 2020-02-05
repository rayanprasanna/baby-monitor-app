package ammaibabai.universl.com.ammaibabai.header_2.header_2_6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.Header2Activity;
import ammaibabai.universl.com.ammaibabai.R;
import ammaibabai.universl.com.ammaibabai.header_2.Header2_2Activity;
import ammaibabai.universl.com.ammaibabai.header_2.Header2_4Activity;
import ammaibabai.universl.com.ammaibabai.header_2.Header2_6Activity;

public class Header_2_6_1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_header_2_6_1);

        TextView naviText= (TextView) findViewById(R.id.txtClose);

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getBaseContext(),Header2_6Activity.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton nextImgeBtn= (ImageButton) findViewById(R.id.nextButton);
        ImageButton previousImgBtn=(ImageButton) findViewById(R.id.previousButton);

        nextImgeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(getBaseContext(), Header_2_6_2Activity.class);
                //startActivity(intent);
                finish();
            }
        });
        previousImgBtn.setEnabled(true);
    }
}
