package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.enitity.Like;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#いいね">https://qiita.com/api/v2/docs#いいね</a>
 */
public interface LikesResources {
    /**
     * Returns the likes which are attached to the item in descending order of attached time.
     * Needs access token for Qiita:Team.
     *
     * @param itemId the target item identifier
     * @return the likes which are attached to the item
     */
    QiitaResponse<List<Like>> getLikes(String itemId) throws QiitaException;
}
