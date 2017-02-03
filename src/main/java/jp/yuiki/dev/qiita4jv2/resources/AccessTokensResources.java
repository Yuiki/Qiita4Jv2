package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.AccessToken;

/**
 * @see <a href="https://qiita.com/api/v2/docs#アクセストークン-1">https://qiita.com/api/v2/docs#アクセストークン-1</a>
 */
public interface AccessTokensResources {
    /**
     * Returns the new access token.
     * Can be used even with unauthenticated.
     *
     * @param code the code for exchanging with the access token attached to the redirect URL
     * @return the new created access token
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<AccessToken> getAccessToken(String code) throws QiitaException;

    /**
     * Expires and unset the access token.
     * Need to set the access token.
     *
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void expireAndUnsetAccessToken() throws QiitaException;
}
