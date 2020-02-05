package ammaibabai.universl.com.ammaibabai;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

import ammaibabai.universl.com.ammaibabai.common.Constants;
import ammaibabai.universl.com.ammaibabai.common.DataHolder;
import ammaibabai.universl.com.ammaibabai.model.Post;

public class ViewPostActivity extends AppCompatActivity {

    private TextView titleText;
    private TextView contentText;
    private ImageView imageView;
    //private ShareButton shareButton;
    //private ImageButton likeButton;
   // private ImageButton twitterButton;
    private Post post;
    private TextView likesTextView;

    private LinearLayout opImgContentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_post);


        opImgContentLayout = (LinearLayout) findViewById(R.id.opImgContentLayout);
        titleText = (TextView) findViewById(R.id.titleTextView);
        contentText = (TextView) findViewById(R.id.contentTextView);
        imageView = (ImageView) findViewById(R.id.contentImageView);

        likesTextView = (TextView) findViewById(R.id.likesTextView);
        //shareButton = (ShareButton) findViewById(R.id.shareButton);
        //twitterButton = (ImageButton) findViewById(R.id.twitterButton);
        //likeButton = (ImageButton) findViewById(R.id.likeButton);
        setPostContent();
        setTitle(getResources().getString(R.string.app_name1));
        //actionMethods();
        TextView naviText= (TextView) findViewById(R.id.txtClose);

        naviText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent=new Intent(getBaseContext(),MenuActivity.class);
                //startActivity(intent);
                finish();
            }
        });
    }

   /* private void actionMethods() {
        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Common.shareTwiterPosts(ViewPostActivity.this, post));
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = PostAction.likeAction(new String[]{URLStrings.URL_LIKE_ACT + post.getId()});

                if (b) {
                    post.setLikes((post.getLikes() + 1));
                    likesTextView.setText(post.getLikes() + " Likes");
                    Common.setImageButtonEnabled(getApplicationContext(), false, likeButton, R.drawable.ic_like);
                    post.setLiked(true);
                }
            }
        });
    }*/


    private void setPostContent() {

        post = (Post) DataHolder.getInstance().getData("post");
        titleText.setText(post.getTitle());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            contentText.setText(Html.fromHtml(post.getContent(), Html.FROM_HTML_MODE_LEGACY));
        }else{
            contentText.setText(Html.fromHtml(post.getContent()));
        }

        likesTextView.setText(post.getLikes() + " Likes");
        if (!post.getAttachments().isEmpty()) {
            try {
                URL newurl = new URL(post.getAttachments().get(0).getUrl());
                Picasso.with(this).load(newurl.toString()).into(imageView);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        //set Share contents
        //shareButton.setShareContent(Common.getFbShareContent(post));
        /*if (post.isLiked()) {
            Common.setImageButtonEnabled(getApplicationContext(), false, likeButton, R.drawable.ic_like);
        }
        if (post.getLikes() > 0) {
            likesTextView.setText(String.valueOf(post.getLikes()) + " Likes");
        }*/


    }

}
