package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#タギング">https://qiita.com/api/v2/docs#タギング</a>
 */
public interface TaggingsResources {
    /**
     * Adds and returns the tag to the item.
     * Needs access token for Qiita:Team.
     *
     * @param itemId   the target item identifier
     * @param name     the tag identical name
     * @param versions the target versions
     * @return the added tag
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Tagging> addTag(String itemId, String name, List<String> versions) throws QiitaException;

    /**
     * Deletes the tag from the item.
     * Needs access token for Qiita:Team.
     *
     * @param itemId    the target item identifier
     * @param taggingId the target tagging identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteTag(String itemId, String taggingId) throws QiitaException;
}
