package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#いいね">https://qiita.com/api/v2/docs#いいね</a>
 */
public class Like {
    /**
     * The date and time this like is created(ISO_8601)
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * The user who post this like
     */
    @JsonProperty("user")
    private User user;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
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

        Like like = (Like) o;

        if (createdAt != null ? !createdAt.equals(like.createdAt) : like.createdAt != null) return false;
        return user != null ? user.equals(like.user) : like.user == null;
    }

    @Override
    public int hashCode() {
        int result = createdAt != null ? createdAt.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
