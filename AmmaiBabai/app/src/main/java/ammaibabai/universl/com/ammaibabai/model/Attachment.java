package ammaibabai.universl.com.ammaibabai.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Tharindu on 4/13/2018.
 */

public class Attachment {
    @SerializedName("url")
    @Expose
    private String url ;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
