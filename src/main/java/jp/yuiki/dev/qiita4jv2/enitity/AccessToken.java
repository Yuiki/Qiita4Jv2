package jp.yuiki.dev.qiita4jv2.enitity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#アクセストークン-1">https://qiita.com/api/v2/docs#アクセストークン-1</a>
 */
public class AccessToken {
    /**
     * API client identifier
     */
    @JsonProperty("client_id")
    private String clientId;

    /**
     * The operations permitted for this access token
     */
    @JsonProperty("scopes")
    private List<String> scopes;

    /**
     * The access token
     */
    @JsonProperty("token")
    private String token;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public List<String> getScopes() {
        return scopes;
    }

    public void setScopes(List<String> scopes) {
        this.scopes = scopes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccessToken that = (AccessToken) o;

        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        if (scopes != null ? !scopes.equals(that.scopes) : that.scopes != null) return false;
        return token != null ? token.equals(that.token) : that.token == null;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (scopes != null ? scopes.hashCode() : 0);
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }
}
