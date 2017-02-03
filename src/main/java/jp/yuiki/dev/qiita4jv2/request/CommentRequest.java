package jp.yuiki.dev.qiita4jv2.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentRequest {
    @JsonProperty("body")
    private String body;

    public CommentRequest(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
