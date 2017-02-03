package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#グループ">https://qiita.com/api/v2/docs#グループ</a>
 */
public class Group {
    /**
     * The date and time thid group created(ISO_8601)
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * The group identifier
     */
    @JsonProperty("id")
    private int id;

    /**
     * THe group display name
     */
    @JsonProperty("name")
    private String name;

    /**
     * Whether this group is private
     */
    @JsonProperty("private")
    private boolean isPrivate;

    /**
     * The date and time this group last updated(ISO_8601)
     */
    @JsonProperty("updated_at")
    private String updatedAt;

    /**
     * This group identical name
     */
    @JsonProperty("url_name")
    private String urlName;

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (id != group.id) return false;
        if (isPrivate != group.isPrivate) return false;
        if (createdAt != null ? !createdAt.equals(group.createdAt) : group.createdAt != null) return false;
        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (updatedAt != null ? !updatedAt.equals(group.updatedAt) : group.updatedAt != null) return false;
        return urlName != null ? urlName.equals(group.urlName) : group.urlName == null;
    }

    @Override
    public int hashCode() {
        int result = createdAt != null ? createdAt.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isPrivate ? 1 : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + (urlName != null ? urlName.hashCode() : 0);
        return result;
    }
}
