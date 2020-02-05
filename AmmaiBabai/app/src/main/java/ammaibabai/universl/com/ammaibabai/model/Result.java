package ammaibabai.universl.com.ammaibabai.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Tharindu on 4/13/2018.
 */

public class Result {
    @SerializedName("posts")
    @Expose
    private List<Post> posts;

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }
}
