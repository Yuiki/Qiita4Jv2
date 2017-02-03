package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#タグ">https://qiita.com/api/v2/docs#タグ</a>
 */
public class Tag {
    /**
     * The amount of users who follow this tag
     */
    @JsonProperty("followers_count")
    private int followersCount;

    /**
     * The tag icon url
     */
    @JsonProperty("icon_url")
    private String iconUrl;

    /**
     * The tag identifier
     */
    @JsonProperty("id")
    private String id;

    /**
     * The amount of items with this tag
     */
    @JsonProperty("items_count")
    private int itemsCount;

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void setItemsCount(int itemsCount) {
        this.itemsCount = itemsCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tag tag = (Tag) o;

        if (followersCount != tag.followersCount) return false;
        if (itemsCount != tag.itemsCount) return false;
        if (iconUrl != null ? !iconUrl.equals(tag.iconUrl) : tag.iconUrl != null) return false;
        return id != null ? id.equals(tag.id) : tag.id == null;
    }

    @Override
    public int hashCode() {
        int result = followersCount;
        result = 31 * result + (iconUrl != null ? iconUrl.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + itemsCount;
        return result;
    }
}
