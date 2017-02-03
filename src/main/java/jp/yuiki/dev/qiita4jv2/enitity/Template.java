package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#テンプレート">https://qiita.com/api/v2/docs#テンプレート</a>
 */
public class Template {
    /**
     * The template body
     */
    @JsonProperty("body")
    private String body;

    /**
     * The template identifier
     */
    @JsonProperty("id")
    private int id;

    /**
     * The template name
     */
    @JsonProperty("name")
    private String name;

    /**
     * The template body expanded variables
     */
    @JsonProperty("expanded_body")
    private String expandedBody;

    /**
     * The tags attached template and expanded variables
     */
    @JsonProperty("expanded_tags")
    private List<Tagging> expandedTaggings;

    /**
     * The template title expanded variables
     */
    @JsonProperty("expanded_title")
    private String expandedTitle;

    /**
     * The template tags
     */
    @JsonProperty("tags")
    private List<Tagging> tags;

    /**
     * The template title
     */
    @JsonProperty("title")
    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
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

    public String getExpandedBody() {
        return expandedBody;
    }

    public void setExpandedBody(String expandedBody) {
        this.expandedBody = expandedBody;
    }

    public List<Tagging> getExpandedTaggings() {
        return expandedTaggings;
    }

    public void setExpandedTaggings(List<Tagging> expandedTaggings) {
        this.expandedTaggings = expandedTaggings;
    }

    public String getExpandedTitle() {
        return expandedTitle;
    }

    public void setExpandedTitle(String expandedTitle) {
        this.expandedTitle = expandedTitle;
    }

    public List<Tagging> getTags() {
        return tags;
    }

    public void setTags(List<Tagging> tags) {
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Template template = (Template) o;

        if (id != template.id) return false;
        if (body != null ? !body.equals(template.body) : template.body != null) return false;
        if (name != null ? !name.equals(template.name) : template.name != null) return false;
        if (expandedBody != null ? !expandedBody.equals(template.expandedBody) : template.expandedBody != null)
            return false;
        if (expandedTaggings != null ? !expandedTaggings.equals(template.expandedTaggings) : template.expandedTaggings != null)
            return false;
        if (expandedTitle != null ? !expandedTitle.equals(template.expandedTitle) : template.expandedTitle != null)
            return false;
        if (tags != null ? !tags.equals(template.tags) : template.tags != null) return false;
        return title != null ? title.equals(template.title) : template.title == null;
    }

    @Override
    public int hashCode() {
        int result = body != null ? body.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (expandedBody != null ? expandedBody.hashCode() : 0);
        result = 31 * result + (expandedTaggings != null ? expandedTaggings.hashCode() : 0);
        result = 31 * result + (expandedTitle != null ? expandedTitle.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
