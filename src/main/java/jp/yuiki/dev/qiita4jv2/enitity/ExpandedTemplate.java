package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#展開済みテンプレート">https://qiita.com/api/v2/docs#展開済みテンプレート</a>
 */
public class ExpandedTemplate {
    /**
     * The body of its inside variables expanded
     */
    @JsonProperty("expanded_body")
    private String expandedBody;

    /**
     * The tags of their inside variables expanded
     */
    @JsonProperty("expanded_tags")
    private List<Tagging> expandedTaggings;

    /**
     * The title of its inside variables expanded
     */
    @JsonProperty("expanded_title")
    private String expandedTitle;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ExpandedTemplate that = (ExpandedTemplate) o;

        if (expandedBody != null ? !expandedBody.equals(that.expandedBody) : that.expandedBody != null) return false;
        if (expandedTaggings != null ? !expandedTaggings.equals(that.expandedTaggings) : that.expandedTaggings != null)
            return false;
        return expandedTitle != null ? expandedTitle.equals(that.expandedTitle) : that.expandedTitle == null;
    }

    @Override
    public int hashCode() {
        int result = expandedBody != null ? expandedBody.hashCode() : 0;
        result = 31 * result + (expandedTaggings != null ? expandedTaggings.hashCode() : 0);
        result = 31 * result + (expandedTitle != null ? expandedTitle.hashCode() : 0);
        return result;
    }
}
