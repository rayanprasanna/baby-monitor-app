package ammaibabai.universl.com.ammaibabai.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ammaibabai.universl.com.ammaibabai.ButtonListActivity;
import ammaibabai.universl.com.ammaibabai.FeedActivity;
import ammaibabai.universl.com.ammaibabai.Header1Activity;
import ammaibabai.universl.com.ammaibabai.Header2Activity;
import ammaibabai.universl.com.ammaibabai.Header3Activity;
import ammaibabai.universl.com.ammaibabai.Header4Activity;
import ammaibabai.universl.com.ammaibabai.Header5Activity;
import ammaibabai.universl.com.ammaibabai.R;

/**
 * Created by Tharindu on 4/22/2018.
 */

public class FirstTabFragment extends Fragment {

    Button bt1,bt2,bt3,bt4,bt5,bt6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first_tab, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        bt1= (Button) view.findViewById(R.id.btn1);
        bt2= (Button) view.findViewById(R.id.btn2);
        bt3= (Button) view.findViewById(R.id.btn3);
        bt4= (Button) view.findViewById(R.id.btn4);
        bt5= (Button) view.findViewById(R.id.btn5);
        bt6= (Button) view.findViewById(R.id.btn6);



        actionMethods();
    }

    private void actionMethods() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(),Header1Activity.class);
                startActivity(intent);

                //finish();

            }
        });


        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(),Header2Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(),Header3Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(),Header4Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(getActivity(),Header5Activity.class);
                startActivity(intent);
                //finish();
            }
        });

        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),ButtonListActivity.class);
                intent.putExtra("contents",getResources().getStringArray(R.array.nalavili));
                startActivity(intent);
                //finish();
            }
        });
    }
}
