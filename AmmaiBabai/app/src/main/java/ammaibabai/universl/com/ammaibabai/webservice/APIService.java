package ammaibabai.universl.com.ammaibabai.webservice;

import ammaibabai.universl.com.ammaibabai.model.Result;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Tharindu on 12/23/2017.
 */

public interface APIService {
//?json=get_category_posts&slug={category}
    @GET("get_category_posts")
    Call<Result> getPosts(@Query("slug") String category);

    @GET("get_recent_posts")
    Call<Result> getRecentPosts();
}
