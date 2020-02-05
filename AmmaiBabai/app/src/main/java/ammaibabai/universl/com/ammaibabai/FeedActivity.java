package ammaibabai.universl.com.ammaibabai;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.InterstitialAd;

import java.util.List;

import ammaibabai.universl.com.ammaibabai.adapter.PostListAdapter;
import ammaibabai.universl.com.ammaibabai.common.Constants;
import ammaibabai.universl.com.ammaibabai.common.DataHolder;
import ammaibabai.universl.com.ammaibabai.model.Post;
import ammaibabai.universl.com.ammaibabai.model.Result;
import ammaibabai.universl.com.ammaibabai.webservice.APIClient;
import retrofit2.Call;
import retrofit2.Callback;

public class FeedActivity extends AppCompatActivity {

    private LinearLayout progressViewLayout;
    private List<Post> postMainList;

    private ListView imageListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        //adView = (LinearLayout) findViewById(R.id.adsBar);

//        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(Constants.APP_COLOR)));
        setTitle(getResources().getString(R.string.app_name1));

        imageListView = (ListView) findViewById(R.id.postImageList);
        progressViewLayout = (LinearLayout) findViewById(R.id.progressViewLayout);


        TextView naviText= (TextView) findViewById(R.id.txtClose);

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(getBaseContext(),MenuActivity.class);
                //startActivity(intent);
                finish();
            }
        });
        actionMethods();
        loadData();
    }

    private void actionMethods() {


        imageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataHolder.getInstance().putData("post", postMainList.get(position));
                Intent intent = new Intent(FeedActivity.this, ViewPostActivity.class);
                startActivity(intent);
            }

        });

    }

    private void loadData(){
        Call<Result> searchCall =  APIClient.createService("").getPosts(Constants.SLUGS[4]);
        progressViewLayout.setVisibility(View.VISIBLE);
        searchCall.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, retrofit2.Response<Result> response) {
                progressViewLayout.setVisibility(View.GONE);
                int statusCode = response.code();

                if (statusCode == Constants.ERR_CODE_200) {
                    Result result = response.body();
                    List<Post> postList = result.getPosts();
                    postMainList = postList;
                    imageListView.setAdapter(new PostListAdapter(FeedActivity.this, postList, -1));
                } else if (statusCode == Constants.ERR_CODE_404) {
                    Toast.makeText(getApplicationContext(), "Posts not found!", Toast.LENGTH_LONG).show();
                } else if (statusCode == Constants.ERR_CODE_500) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.err500), Toast.LENGTH_LONG).show();
                } else if (statusCode == Constants.ERR_CODE_401) {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.err401), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), getResources().getString(R.string.err_other), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                progressViewLayout.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.err_other), Toast.LENGTH_LONG).show();
            }
        });
    }
}