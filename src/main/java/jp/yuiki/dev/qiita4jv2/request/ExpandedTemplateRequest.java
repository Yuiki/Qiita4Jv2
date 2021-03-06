package jp.yuiki.dev.qiita4jv2.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;

import java.util.List;

public class ExpandedTemplateRequest {
    @JsonProperty("body")
    private String body;

    @JsonProperty("tags")
    private List<Tagging> tags;

    @JsonProperty("title")
    private String title;

    public ExpandedTemplateRequest(String body, List<Tagging> tags, String title) {
        this.body = body;
        this.tags = tags;
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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
}
