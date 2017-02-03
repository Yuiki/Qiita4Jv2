package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.QiitaPageResponse;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Tag;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#タグ">https://qiita.com/api/v2/docs#タグ</a>
 */
public interface TagsResources {
    /**
     * Returns the all tags in descending order of creation date and time.
     * Can be used even with unauthenticated.
     *
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of tags included per page({@code perPage > 0 && perPage <= 100})
     * @param sort    the tag order
     * @return the all tags
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Tag>> getTags(int page, int perPage, String sort) throws QiitaException;

    /**
     * Returns the tag.
     * Can be used even with unauthenticated.
     *
     * @param tagId the target tag identifier
     * @return the got tag
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Tag> getTag(String tagId) throws QiitaException;

    /**
     * Returns the tags which the authenticated user follows in descending order of followed date and time.
     * Can be used even with unauthenticated.
     *
     * @param userId  the target user identifier
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of tags included per page({@code perPage > 0 && perPage <= 100})
     * @return the tags which the authenticated user follows
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Tag>> getUserFollowingTags(String userId, int page, int perPage) throws QiitaException;

    /**
     * Unfollows the tag.
     * Needs access token.
     *
     * @param tagId the target tag identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void unfollowTag(String tagId) throws QiitaException;

    /**
     * Whether the authenticated user follows the tag.
     * Needs access token.
     *
     * @param tagId the target tag identifier
     * @return whether the authenticated user follows the tag
     */
    boolean isFollowingTag(String tagId);

    /**
     * Follows the tag.
     * Needs access token.
     *
     * @param tagId the target tag identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void followTag(String tagId) throws QiitaException;
}