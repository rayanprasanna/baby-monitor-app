package ammaibabai.universl.com.ammaibabai.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Post {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    private String imgUrl;
    @SerializedName("content")
    @Expose
    private String content;
    private String date;
    private String category;
    @SerializedName("url")
    @Expose
    private String link;
    private int likes;
    private boolean liked;
    @SerializedName("attachments")
    @Expose
    private List<Attachment> attachments;
    private List<String> optionalImgUrls;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Post() {
        // TODO Auto-generated constructor stub
    }

    public Post(Post post) {
        this.id = post.id;
        this.title = post.title;
        this.imgUrl = post.imgUrl;
        this.content = post.content;
        this.link = post.link;
        this.date = post.date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public List<String> getOptionalImgUrls() {
        return optionalImgUrls;
    }

    public void setOptionalImgUrls(List<String> optionalImgUrls) {
        this.optionalImgUrls = optionalImgUrls;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }

    public List<Attachment> getAttachments() {
        if(attachments == null){
            attachments = new ArrayList<>();
        }
        return attachments;
    }
}
