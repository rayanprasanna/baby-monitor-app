package ammaibabai.universl.com.ammaibabai;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.TelephonyManager;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import ammaibabai.universl.com.ammaibabai.common.Constants;
import ammaibabai.universl.com.ammaibabai.common.StringUtils;
import ammaibabai.universl.com.ammaibabai.fragment.FeedTabFragment;
import ammaibabai.universl.com.ammaibabai.fragment.FirstTabFragment;

public class MenuActivity extends AppCompatActivity {

    private AdView adView;
    private InterstitialAd interstitial;
    protected static final int PERMISSIONS_SEND_SMS = 100;
    private ViewPager mViewPager;

    private Toolbar toolbar;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        adView = (AdView) this.findViewById(R.id.adView);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(Constants.APP_COLOR)));
        getSupportActionBar().setStackedBackgroundDrawable(new ColorDrawable(Color.parseColor(Constants.APP_COLOR)));

        TextView cls= (TextView) findViewById(R.id.txtCloseBtn);

        cls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
		System.exit(0);
                finish();
            }
        });

        toolbar.setTitleTextAppearance(this, R.style.AppTitleTextApperance);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        adView = (AdView) this.findViewById(R.id.adView);
        interstitial = new InterstitialAd(MenuActivity.this);
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                /*if (interstitial.isLoaded()) {
                    interstitial.show();
                }*/
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        smsNotify();
        initAds();
    }/*
if(interstitial.isLoaded()){
        interstitial.show();
    }*/
    //SMS
    private void smsNotify() {
        String msgContent = "ඔබගේ දරුවාගේ කායික මානසික සෞඛ්\u200Dය යහපත් කර ගැනීමට උපදෙස් හා බිලින්දාට කෑම වට්ටෝරු SMS මගින් ලබා ගැනීමට කැමතිද? 5 LKR +Tax P/D";
        String s = this.getServiceProvider();
        if(StringUtils.isNullOrEmpty(s)){
            return;
        }
        String msg = null;
        String no = null;
        if (s.equalsIgnoreCase("DIALOG") || s.equalsIgnoreCase("SRI DIALOG") || s.equalsIgnoreCase("413002") || s.equalsIgnoreCase("Hutch") || s.equalsIgnoreCase("Airtel")) {
            msg = "REG BABA";
            no = "77177";
        } else if (s.equalsIgnoreCase("Mobitel")) {
            msg = "REG BABAAPP";
            no = "2244";
        }
        if (msg != null) {
            if(s.equalsIgnoreCase("413002")) s = "DIALOG";
            alert("SMS on "+s+" mobile", msgContent, no, msg);
        }
    }


    public String getServiceProvider() {
        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        String carrierName = manager.getSimOperatorName();
        return carrierName;
    }

    private void alert(String title, String msg, final String number, final String regMsg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(this,R.style.AlertDialogCustom));
        builder.setTitle(title);
        builder.setMessage(msg);

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                // Do nothing but close the dialog
                sendSmsByManager(number, regMsg);
                dialog.dismiss();
            }

        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
                dialog.dismiss();
            }
        });

        final AlertDialog alert = builder.create();
        alert.setOnShowListener(new DialogInterface.OnShowListener() {

            @Override
            public void onShow(DialogInterface d) {
                Button posButton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                Button negButton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
                LinearLayout linearLayout = (LinearLayout) posButton.getParent();
                linearLayout.setGravity(Gravity.CENTER_HORIZONTAL);
                linearLayout.setWeightSum(2);

                int btnwidth = (linearLayout.getWidth() / 2) - (linearLayout.getWidth()/ 20);
                posButton.setWidth(btnwidth);
                negButton.setWidth(btnwidth);

            }
        });

        alert.show();
    }

    public void sendSmsByManager(String number, String regMsg) {
       /* try {
            // Get the default instance of the SmsManager
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, regMsg, null, null);
            Toast.makeText(getApplicationContext(), "Your sms has been sent.", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Sms sending failed..." + ex, Toast.LENGTH_LONG).show();
            ex.printStackTrace();
        }*/
        Uri uri = Uri.parse("smsto:" + number);
        Intent intent = new Intent("android.intent.action.SENDTO", uri);
        intent.putExtra("sms_body", regMsg);
        startActivity(intent);
    }

    //Ads
    private void initAds() {
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);
        /*interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getResources().getString(R.string.ads_inst_id));
        AdRequest adInsRequest = new AdRequest.Builder().build();
        interstitial.loadAd(adInsRequest);*/
    }


//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//        switch (id) {
//            case android.R.id.home:
//                this.finish();
//                return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        return true;
//    }

/*
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {

            case PERMISSIONS_SEND_SMS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    smsNotify();
                }
                return;
            }
        }
    }*/


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {

                case 1:
                    return new FeedTabFragment();
                case 0:
                    return new FirstTabFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Resources resources = getResources();
            switch (position) {
                case 0:
                    return resources.getString(R.string.app_name1);
                case 1:
                    return resources.getString(R.string.aluth);

            }
            return null;
        }
    }
}
