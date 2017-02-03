package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;

import java.net.URI;

/**
 * @see <a href="https://qiita.com/api/v2/docs#認証認可">https://qiita.com/api/v2/docs#認証認可</a>
 */
public interface AuthorizeResources {
    /**
     * Returns the authorize url.
     * Needs no access token.
     *
     * @param scope the access scope used by this application(space delimiter)
     * @param state the CSRF token
     * @throws QiitaException if you didn't call Qiita#setClientInformation
     * @return the authorize url
     */
    URI getAuthorizeUrl(String scope, String state) throws QiitaException;
}
