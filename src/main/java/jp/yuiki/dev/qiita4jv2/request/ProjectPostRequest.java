package jp.yuiki.dev.qiita4jv2.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;

import java.util.List;

public class ProjectPostRequest {
    @JsonProperty("archived")
    private boolean archived;

    @JsonProperty("body")
    private String body;

    @JsonProperty("name")
    private String name;

    @JsonProperty("tags")
    private List<Tagging> tags;

    public ProjectPostRequest(boolean archived, String body, String name, List<Tagging> tags) {
        this.archived = archived;
        this.body = body;
        this.name = name;
        this.tags = tags;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tagging> getTags() {
        return tags;
    }

    public void setTags(List<Tagging> tags) {
        this.tags = tags;
    }
}
