package jp.yuiki.dev.qiita4jv2.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReactionPostRequest {
    @JsonProperty("name")
    private String name;

    public ReactionPostRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
