package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#タギング">https://qiita.com/api/v2/docs#タギング</a>
 */
public class Tagging {
    /**
     * The tag identical name
     */
    @JsonProperty("name")
    private String id;

    /**
     * The target versions
     */
    @JsonProperty("versions")
    private List<String> versions;

    public Tagging() {
    }

    public Tagging(String id, List<String> versions) {
        this.id = id;
        this.versions = versions;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getVersions() {
        return versions;
    }

    public void setVersions(List<String> versions) {
        this.versions = versions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tagging that = (Tagging) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return versions != null ? versions.equals(that.versions) : that.versions == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (versions != null ? versions.hashCode() : 0);
        return result;
    }
}
