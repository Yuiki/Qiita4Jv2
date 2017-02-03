package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Team;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#チーム">https://qiita.com/api/v2/docs#チーム</a>
 */
public interface TeamsResources {
    /**
     * Returns the all teams which the authenticated user belongs in descending order of creation time.
     * Needs access token for Qiita:Team.
     *
     * @return the all teams which the authenticated user belongs
     * @throws QiitaException if Qiita API is unavailable
     */
    QiitaResponse<List<Team>> getAuthenticatedUserTeams() throws QiitaException;
}
