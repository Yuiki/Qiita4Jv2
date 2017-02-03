package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#認証中のユーザ">https://qiita.com/api/v2/docs#認証中のユーザ</a>
 */
public class AuthenticatedUser {
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

    /**
     * The total capacity of images that can be uploaded to Qiita per month
     */
    @JsonProperty("image_monthly_upload_limit")
    private int imageMonthlyUploadLimit;

    /**
     * The remaining capacity of images that can be uploaded to Qiita in this month
     */
    @JsonProperty("image_monthly_upload_remaining")
    private int imageMonthlyUploadRemaining;

    /**
     * Whether the user is set to Qiita:Team only mode
     */
    @JsonProperty("team_only")
    private boolean teamOnly;

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

    public int getImageMonthlyUploadLimit() {
        return imageMonthlyUploadLimit;
    }

    public void setImageMonthlyUploadLimit(int imageMonthlyUploadLimit) {
        this.imageMonthlyUploadLimit = imageMonthlyUploadLimit;
    }

    public int getImageMonthlyUploadRemaining() {
        return imageMonthlyUploadRemaining;
    }

    public void setImageMonthlyUploadRemaining(int imageMonthlyUploadRemaining) {
        this.imageMonthlyUploadRemaining = imageMonthlyUploadRemaining;
    }

    public boolean isTeamOnly() {
        return teamOnly;
    }

    public void setTeamOnly(boolean teamOnly) {
        this.teamOnly = teamOnly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthenticatedUser that = (AuthenticatedUser) o;

        if (followeesCount != that.followeesCount) return false;
        if (followersCount != that.followersCount) return false;
        if (itemsCount != that.itemsCount) return false;
        if (permanentId != that.permanentId) return false;
        if (imageMonthlyUploadLimit != that.imageMonthlyUploadLimit) return false;
        if (imageMonthlyUploadRemaining != that.imageMonthlyUploadRemaining) return false;
        if (teamOnly != that.teamOnly) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (facebookId != null ? !facebookId.equals(that.facebookId) : that.facebookId != null) return false;
        if (githubLoginName != null ? !githubLoginName.equals(that.githubLoginName) : that.githubLoginName != null)
            return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (linkedinId != null ? !linkedinId.equals(that.linkedinId) : that.linkedinId != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (organization != null ? !organization.equals(that.organization) : that.organization != null) return false;
        if (profileImageUrl != null ? !profileImageUrl.equals(that.profileImageUrl) : that.profileImageUrl != null)
            return false;
        if (twitterScreenName != null ? !twitterScreenName.equals(that.twitterScreenName) : that.twitterScreenName != null)
            return false;
        return websiteUrl != null ? websiteUrl.equals(that.websiteUrl) : that.websiteUrl == null;
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
        result = 31 * result + imageMonthlyUploadLimit;
        result = 31 * result + imageMonthlyUploadRemaining;
        result = 31 * result + (teamOnly ? 1 : 0);
        return result;
    }
}
