package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#投稿">https://qiita.com/api/v2/docs#投稿</a>
 */
public class Item {
    /**
     * HTML format body
     */
    @JsonProperty("rendered_body")
    private String renderedBody;

    /**
     * Markdown format body
     */
    @JsonProperty("body")
    private String body;

    /**
     * Whether this item is coediting(only in Qiita:Team)
     */
    @JsonProperty("coediting")
    private boolean coediting;

    /**
     * The date and time this item created(ISO_8601)
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * Represents Qiita:Team group
     */
    @JsonProperty("group")
    private Group group;

    /**
     * The item identifier
     */
    @JsonProperty("id")
    private String id;

    /**
     * Whether this item is private(invalid in Qiita:Team)
     */
    @JsonProperty("private")
    private boolean isPrivate;

    /**
     * The item tags
     */
    @JsonProperty("tags")
    private List<Tagging> taggings;

    /**
     * The item title
     */
    @JsonProperty("title")
    private String title;

    /**
     * The date and time this item last updated(ISO_8601)
     */
    @JsonProperty("updated_at")
    private String updatedAt;

    /**
     * The item url
     */
    @JsonProperty("url")
    private String url;

    /**
     * The user who posted this item
     */
    @JsonProperty("user")
    private User user;

    public String getRenderedBody() {
        return renderedBody;
    }

    public void setRenderedBody(String renderedBody) {
        this.renderedBody = renderedBody;
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public List<Tagging> getTaggings() {
        return taggings;
    }

    public void setTaggings(List<Tagging> taggings) {
        this.taggings = taggings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

        Item item = (Item) o;

        if (coediting != item.coediting) return false;
        if (isPrivate != item.isPrivate) return false;
        if (renderedBody != null ? !renderedBody.equals(item.renderedBody) : item.renderedBody != null) return false;
        if (body != null ? !body.equals(item.body) : item.body != null) return false;
        if (createdAt != null ? !createdAt.equals(item.createdAt) : item.createdAt != null) return false;
        if (group != null ? !group.equals(item.group) : item.group != null) return false;
        if (id != null ? !id.equals(item.id) : item.id != null) return false;
        if (taggings != null ? !taggings.equals(item.taggings) : item.taggings != null) return false;
        if (title != null ? !title.equals(item.title) : item.title != null) return false;
        if (updatedAt != null ? !updatedAt.equals(item.updatedAt) : item.updatedAt != null) return false;
        if (url != null ? !url.equals(item.url) : item.url != null) return false;
        return user != null ? user.equals(item.user) : item.user == null;
    }

    @Override
    public int hashCode() {
        int result = renderedBody != null ? renderedBody.hashCode() : 0;
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (coediting ? 1 : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (isPrivate ? 1 : 0);
        result = 31 * result + (taggings != null ? taggings.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
