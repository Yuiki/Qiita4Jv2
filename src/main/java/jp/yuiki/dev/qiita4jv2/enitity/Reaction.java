package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The entity that represents a emoji reaction.
 *
 * @see <a href="https://qiita.com/api/v2/docs#絵文字リアクション">https://qiita.com/api/v2/docs#絵文字リアクション</a>
 */
public class Reaction {
    /**
     * The date and the time this reaction was created(ISO_8601)
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * The emoji image URL
     */
    @JsonProperty("image_url")
    private String imageUrl;

    /**
     * The name of emoji
     */
    @JsonProperty("name")
    private String name;

    /**
     * The user who post this reaction
     */
    @JsonProperty("user")
    private User user;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Reaction reaction = (Reaction) o;

        if (createdAt != null ? !createdAt.equals(reaction.createdAt) : reaction.createdAt != null) return false;
        if (imageUrl != null ? !imageUrl.equals(reaction.imageUrl) : reaction.imageUrl != null) return false;
        if (name != null ? !name.equals(reaction.name) : reaction.name != null) return false;
        return user != null ? user.equals(reaction.user) : reaction.user == null;
    }

    @Override
    public int hashCode() {
        int result = createdAt != null ? createdAt.hashCode() : 0;
        result = 31 * result + (imageUrl != null ? imageUrl.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        return result;
    }
}
