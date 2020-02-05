package ammaibabai.universl.com.ammaibabai.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import ammaibabai.universl.com.ammaibabai.R;
import ammaibabai.universl.com.ammaibabai.model.Post;

public class PostListAdapter extends BaseAdapter {

    private Activity context;
    private List<Post> postList;
    private int currentPos;
    private int tabNo;
    //private ShareDialog shareDialog;
    public static int selectedPos;

    public PostListAdapter(Activity context, List<Post> postList, int tabNo/*, ShareDialog shareDialog*/) {
        super();
        this.context = context;
        this.postList = postList;
        this.tabNo = tabNo;
        //this.shareDialog = shareDialog;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public int getCount() {
        if (postList != null) {
            return postList.size();
        }
        return 0;
    }

    public Object getItem(int position) {
        return postList.get(position);
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        // if (convertView == null) {
        View convertView = inflater.inflate(R.layout.list_item_post, null);
        // }
        TextView titleTextView = (TextView) convertView.findViewById(R.id.titleTextView);
        ImageView postImageView = (ImageView) convertView.findViewById(R.id.postImageView);
        //final ShareButton shareButton = (ShareButton) convertView.findViewById(R.id.shareButton);
        //final ImageButton twitterButton = (ImageButton) convertView.findViewById(R.id.twitterButton);
        //final ImageButton likeButton = (ImageButton) convertView.findViewById(R.id.likeButton);
        //final TextView likesTextView = (TextView) convertView.findViewById(R.id.likesTextView);
        // final LikeView likeView = (LikeView) convertView.findViewById(R.id.likeView);
        final Post post = (Post) getItem(position);
        final int curPos = position;
        titleTextView.setText(post.getTitle());


        if (!post.getAttachments().isEmpty()) {
            try {
                URL newurl = new URL(post.getAttachments().get(0).getUrl());
                Picasso.with(context).load(newurl.toString()).into(postImageView);
                //postImageView.setImageBitmap(BitmapFactory.decodeStream(newurl.openConnection().getInputStream()));
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*shareButton.setShareContent(Common.getFbShareContent(post));

        //likeView.setObjectIdAndType(post.getLink(),null);

        if (post.getLikes() > 0) {
            likesTextView.setText(String.valueOf(post.getLikes()) + " Likes");
        }
        if (post.isLiked()) {
            Common.setImageButtonEnabled(context, false, likeButton, R.drawable.ic_like);
        }

        twitterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(Common.shareTwiterPosts(context, post));
            }
        });

        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = PostAction.likeAction(new String[]{URLStrings.URL_LIKE_ACT + post.getId()});

                if (b) {
                    post.setLikes((post.getLikes() + 1));
                    post.setLiked(true);
                    postList.set(position, post);
                    likesTextView.setText(post.getLikes() + " Likes");
                    Common.setImageButtonEnabled(context, false, likeButton, R.drawable.ic_like);

                }
            }
        });

*/
        return convertView;
    }


}