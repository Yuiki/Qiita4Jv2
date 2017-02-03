package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @see <a href="https://qiita.com/api/v2/docs#チーム">https://qiita.com/api/v2/docs#チーム</a>
 */
public class Team {
    /**
     * Whether this team is active
     */
    @JsonProperty("active")
    private boolean active;

    /**
     * The team identifier
     */
    @JsonProperty("id")
    private String id;

    /**
     * The team name
     */
    @JsonProperty("name")
    private String name;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Team team = (Team) o;

        if (active != team.active) return false;
        if (id != null ? !id.equals(team.id) : team.id != null) return false;
        return name != null ? name.equals(team.name) : team.name == null;
    }

    @Override
    public int hashCode() {
        int result = (active ? 1 : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
