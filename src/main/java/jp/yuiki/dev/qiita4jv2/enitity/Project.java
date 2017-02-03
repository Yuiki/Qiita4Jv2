package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#プロジェクト">https://qiita.com/api/v2/docs#プロジェクト</a>
 */
public class Project {
    /**
     * HTML format body
     */
    @JsonProperty("rendered_body")
    private String renderedBody;

    /**
     * Whether this project is archived
     */
    @JsonProperty("archived")
    private boolean archived;

    /**
     * Markdown format body
     */
    @JsonProperty("body")
    private String body;

    /**
     * The date and time this project was created(ISO_8601)
     */
    @JsonProperty("created_at")
    private String createdAt;

    /**
     * The project identifier
     */
    @JsonProperty("id")
    private int id;

    /**
     * The project name
     */
    @JsonProperty("name")
    private String name;

    /**
     * The date and time this project was last updated(ISO_8601)
     */
    @JsonProperty("updated_at")
    private String updatedAt;

    public String getRenderedBody() {
        return renderedBody;
    }

    public void setRenderedBody(String renderedBody) {
        this.renderedBody = renderedBody;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

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

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (archived != project.archived) return false;
        if (id != project.id) return false;
        if (renderedBody != null ? !renderedBody.equals(project.renderedBody) : project.renderedBody != null)
            return false;
        if (body != null ? !body.equals(project.body) : project.body != null) return false;
        if (createdAt != null ? !createdAt.equals(project.createdAt) : project.createdAt != null) return false;
        if (name != null ? !name.equals(project.name) : project.name != null) return false;
        return updatedAt != null ? updatedAt.equals(project.updatedAt) : project.updatedAt == null;
    }

    @Override
    public int hashCode() {
        int result = renderedBody != null ? renderedBody.hashCode() : 0;
        result = 31 * result + (archived ? 1 : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        return result;
    }
}
