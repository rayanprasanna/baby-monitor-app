package ammaibabai.universl.com.ammaibabai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import ammaibabai.universl.com.ammaibabai.adapter.ButtonListAdapter;
import ammaibabai.universl.com.ammaibabai.utils.CommonUtils;

public class ButtonListActivity extends AppCompatActivity {

    private ListView listView;
    private static String[] titles;
    private static String[] contents;
    private TextView naviText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_list);

        listView = (ListView) findViewById(R.id.listView);
        naviText = (TextView) findViewById(R.id.txtClose);
        setData();
        actionMethods();
    }

    private void actionMethods() {
        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ButtonListActivity.this,Header6Activity.class);
                intent.putExtra("contents",contents);
                intent.putExtra("pos",i);
                startActivity(intent);
            }
        });
    }

    private void setData() {
        if(contents == null){
            contents = getIntent().getExtras().getStringArray("contents");
        }
        if(titles == null){
            titles = CommonUtils.getTitlesFromContents(contents);
        }
        listView.setAdapter( new ButtonListAdapter(this,contents,titles));

    }
}
