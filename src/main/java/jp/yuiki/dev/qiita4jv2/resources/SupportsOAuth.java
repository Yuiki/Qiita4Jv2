package jp.yuiki.dev.qiita4jv2.resources;

public interface SupportsOAuth {
    /**
     * Sets the access token.
     *
     * @param accessToken the access token
     */
    void setAccessToken(String accessToken);

    /**
     * Sets the client id and client secret.
     *
     * @param clientId     the client identifier
     * @param clientSecret the client secret
     */
    void setClientInformation(String clientId, String clientSecret);
}