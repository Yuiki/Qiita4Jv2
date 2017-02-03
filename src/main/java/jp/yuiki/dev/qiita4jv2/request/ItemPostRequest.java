package jp.yuiki.dev.qiita4jv2.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;

import java.util.List;

public class ItemPostRequest {
    @JsonProperty("body")
    private String body;

    @JsonProperty("coediting")
    private boolean coediting;

    @JsonProperty("gist")
    private boolean gist;

    @JsonProperty("private")
    private boolean isPrivate;

    @JsonProperty("tags")
    private List<Tagging> tags;

    @JsonProperty("title")
    private String title;

    @JsonProperty("tweet")
    private boolean tweet;

    public ItemPostRequest(String body, boolean coediting, boolean gist, boolean isPrivate, List<Tagging> tags, String title, boolean tweet) {
        this.body = body;
        this.coediting = coediting;
        this.gist = gist;
        this.isPrivate = isPrivate;
        this.tags = tags;
        this.title = title;
        this.tweet = tweet;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isCoediting() {
        return coediting;
    }

    public void setCoediting(boolean coediting) {
        this.coediting = coediting;
    }

    public boolean isGist() {
        return gist;
    }

    public void setGist(boolean gist) {
        this.gist = gist;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public List<Tagging> getTags() {
        return tags;
    }

    public void setTags(List<Tagging> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isTweet() {
        return tweet;
    }

    public void setTweet(boolean tweet) {
        this.tweet = tweet;
    }
}
