package ammaibabai.universl.com.ammaibabai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import ammaibabai.universl.com.ammaibabai.R;
import ammaibabai.universl.com.ammaibabai.ViewPostActivity;
import ammaibabai.universl.com.ammaibabai.adapter.PostListAdapter;
import ammaibabai.universl.com.ammaibabai.common.Constants;
import ammaibabai.universl.com.ammaibabai.common.DataHolder;
import ammaibabai.universl.com.ammaibabai.model.Post;
import ammaibabai.universl.com.ammaibabai.model.Result;
import ammaibabai.universl.com.ammaibabai.webservice.APIClient;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Tharindu on 4/22/2018.
 */

public class FeedTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_feed_tab, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        imageListView = (ListView) view.findViewById(R.id.postImageList);
        progressViewLayout = (LinearLayout) view.findViewById(R.id.progressViewLayout);

        actionMethods();
        loadData();
    }


    private LinearLayout progressViewLayout;
    private List<Post> postMainList;

    private ListView imageListView;


    private void actionMethods() {


        imageListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataHolder.getInstance().putData("post", postMainList.get(position));
                Intent intent = new Intent(getActivity(), ViewPostActivity.class);
                startActivity(intent);
            }

        });

    }

    private void loadData() {
        Call<Result> searchCall = APIClient.createService("").getPosts(Constants.SLUGS[4]);
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
                    imageListView.setAdapter(new PostListAdapter(getActivity(), postList, -1));
                } else if (statusCode == Constants.ERR_CODE_404) {
                    Toast.makeText(getActivity(), "Posts not found!", Toast.LENGTH_LONG).show();
                } else if (statusCode == Constants.ERR_CODE_500) {
                    Toast.makeText(getActivity(), getResources().getString(R.string.err500), Toast.LENGTH_LONG).show();
                } else if (statusCode == Constants.ERR_CODE_401) {
                    Toast.makeText(getActivity(), getResources().getString(R.string.err401), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getActivity(), getResources().getString(R.string.err_other), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {
                progressViewLayout.setVisibility(View.GONE);
                Toast.makeText(getActivity(), getResources().getString(R.string.err_other), Toast.LENGTH_LONG).show();
            }
        });
    }

}
