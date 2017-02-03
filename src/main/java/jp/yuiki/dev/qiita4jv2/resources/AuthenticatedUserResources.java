package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.enitity.AuthenticatedUser;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;

/**
 * @see <a href="https://qiita.com/api/v2/docs#認証中のユーザ">https://qiita.com/api/v2/docs#認証中のユーザ</a>
 */
public interface AuthenticatedUserResources {
    /**
     * Returns the authenticated user.
     * Needs access token.
     *
     * @return the authenticated user
     * @throws QiitaException if Qiita API is unavailable
     */
    QiitaResponse<AuthenticatedUser> getAuthenticatedUser() throws QiitaException;
}