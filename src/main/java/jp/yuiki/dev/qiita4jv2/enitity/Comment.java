package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#コメント">https://qiita.com/api/v2/docs#コメント</a>
 */
public class Comment {
    /**
     * Markdown format body
     */
    @JsonProperty("body")
    private String body;

    /**
     * The date and time this comment created(ISO_8601)
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * The comment identifier
     */
    @JsonProperty("id")
    private String id;

    /**
     * HTML format body
     */
    @JsonProperty("rendered_body")
    private String renderedBody;

    /**
     * The date and time this comment last updated(ISO_8601)
     */
    @JsonProperty("updated_at")
    private String updatedAt;

    /**
     * The user who posted this comment
     */
    @JsonProperty("user")
    private User user;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRenderedBody() {
        return renderedBody;
    }

    public void setRenderedBody(String renderedBody) {
        this.renderedBody = renderedBody;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (body != null ? !body.equals(comment.body) : comment.body != null) return false;
        if (createdAt != null ? !createdAt.equals(comment.createdAt) : comment.createdAt != null) return false;
        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (renderedBody != null ? !renderedBody.equals(comment.renderedBody) : comment.renderedBody != null)
            return false;
        if (updatedAt != null ? !updatedAt.equals(comment.updatedAt) : comment.updatedAt != null) return false;
        return user != null ? user.equals(comment.user) : comment.user == null;
    }

    @Override
    public int hashCode() {
        int result = body != null ? body.hashCode() : 0;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (renderedBody != null ? renderedBody.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
