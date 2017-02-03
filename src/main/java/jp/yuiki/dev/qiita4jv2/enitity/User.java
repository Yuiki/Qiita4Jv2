package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#ユーザ">https://qiita.com/api/v2/docs#ユーザ</a>
 */
public class User {
    /**
     * Self-introduction text
     */
    @JsonProperty("description")
    private String description;

    /**
     * Facebook ID
     */
    @JsonProperty("facebook_id")
    private String facebookId;

    /**
     * The amount of following users
     */
    @JsonProperty("followees_count")
    private int followeesCount;

    /**
     * The amount of follower users
     */
    @JsonProperty("followers_count")
    private int followersCount;

    /**
     * Github ID
     */
    @JsonProperty("github_login_name")
    private String githubLoginName;

    /**
     * User identifier
     */
    @JsonProperty("id")
    private String id;

    /**
     * The amount of posts published on qiita.com excluding Qiita:Team
     */
    @JsonProperty("items_count")
    private int itemsCount;

    /**
     * Linkedin ID
     */
    @JsonProperty("linkedin_id")
    private String linkedinId;

    /**
     * User location
     */
    @JsonProperty("location")
    private String location;

    /**
     * User name
     */
    @JsonProperty("name")
    private String name;

    /**
     * The Organization to which the user belongs
     */
    @JsonProperty("organization")
    private String organization;

    /**
     * User integer identifier
     */
    @JsonProperty("permanent_id")
    private int permanentId;

    /**
     * The profile image URL
     */
    @JsonProperty("profile_image_url")
    private String profileImageUrl;

    /**
     * Screen name in Twitter
     */
    @JsonProperty("twitter_screen_name")
    private String twitterScreenName;

    /**
     * User website URL
     */
    @JsonProperty("website_url")
    private String websiteUrl;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public int getFolloweesCount() {
        return followeesCount;
    }

    public void setFolloweesCount(int followeesCount) {
        this.followeesCount = followeesCount;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public String getGithubLoginName() {
        return githubLoginName;
    }

    public void setGithubLoginName(String githubLoginName) {
        this.githubLoginName = githubLoginName;
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

    public String getLinkedinId() {
        return linkedinId;
    }

    public void setLinkedinId(String linkedinId) {
        this.linkedinId = linkedinId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getPermanentId() {
        return permanentId;
    }

    public void setPermanentId(int permanentId) {
        this.permanentId = permanentId;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public String getTwitterScreenName() {
        return twitterScreenName;
    }

    public void setTwitterScreenName(String twitterScreenName) {
        this.twitterScreenName = twitterScreenName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (followeesCount != user.followeesCount) return false;
        if (followersCount != user.followersCount) return false;
        if (itemsCount != user.itemsCount) return false;
        if (permanentId != user.permanentId) return false;
        if (description != null ? !description.equals(user.description) : user.description != null) return false;
        if (facebookId != null ? !facebookId.equals(user.facebookId) : user.facebookId != null) return false;
        if (githubLoginName != null ? !githubLoginName.equals(user.githubLoginName) : user.githubLoginName != null)
            return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (linkedinId != null ? !linkedinId.equals(user.linkedinId) : user.linkedinId != null) return false;
        if (location != null ? !location.equals(user.location) : user.location != null) return false;
        if (name != null ? !name.equals(user.name) : user.name != null) return false;
        if (organization != null ? !organization.equals(user.organization) : user.organization != null) return false;
        if (profileImageUrl != null ? !profileImageUrl.equals(user.profileImageUrl) : user.profileImageUrl != null)
            return false;
        if (twitterScreenName != null ? !twitterScreenName.equals(user.twitterScreenName) : user.twitterScreenName != null)
            return false;
        return websiteUrl != null ? websiteUrl.equals(user.websiteUrl) : user.websiteUrl == null;
    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (facebookId != null ? facebookId.hashCode() : 0);
        result = 31 * result + followeesCount;
        result = 31 * result + followersCount;
        result = 31 * result + (githubLoginName != null ? githubLoginName.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + itemsCount;
        result = 31 * result + (linkedinId != null ? linkedinId.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (organization != null ? organization.hashCode() : 0);
        result = 31 * result + permanentId;
        result = 31 * result + (profileImageUrl != null ? profileImageUrl.hashCode() : 0);
        result = 31 * result + (twitterScreenName != null ? twitterScreenName.hashCode() : 0);
        result = 31 * result + (websiteUrl != null ? websiteUrl.hashCode() : 0);
        return result;
    }
}
