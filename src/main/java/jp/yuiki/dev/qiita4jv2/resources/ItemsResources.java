package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.enitity.Item;
import jp.yuiki.dev.qiita4jv2.QiitaPageResponse;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#投稿">https://qiita.com/api/v2/docs#投稿</a>
 */
public interface ItemsResources {
    /**
     * Returns the items which the authenticated user posted in descending order of creation time.
     * Need saccess token.
     *
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of users included per page({@code perPage > 0 && perPage <= 100})
     * @return the items which the authenticated user posted
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Item>> getAuthenticatedUserItems(int page, int perPage) throws QiitaException;

    /**
     * Returns the items which matched the query in descending order of creation time.
     * Can be used even with unauthenticated.
     *
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of users included per page({@code perPage > 0 && perPage <= 100})
     * @param query   the search query
     * @return the items which matched the query
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Item>> getItemsByQuery(int page, int perPage, String query) throws QiitaException;

    /**
     * Creates and returns new item.
     * Needs access token.
     *
     * @param body      the markdown format body
     * @param coediting whether this item is coediting(only in Qiita:Team)
     * @param gist      whether to post code in the text to Gist(only when GitHub linkage is enabled)
     * @param isPrivate whether this item is private(invalid in Qiita:Team)
     * @param tags      the item tags
     * @param title     the item title
     * @param tweet     whether to post to twitter(only when Twitter linkage is enabled)
     * @return the new created item
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Item> postItem(String body, boolean coediting, boolean gist, boolean isPrivate, List<Tagging> tags, String title, boolean tweet) throws QiitaException;

    /**
     * Deletes the item.
     * Needs access token.
     *
     * @param itemId the target item identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteItem(String itemId) throws QiitaException;

    /**
     * Returns the item.
     * Can be used even with unauthenticated.
     *
     * @param itemId the target item identifier
     * @return the got item
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Item> getItem(String itemId) throws QiitaException;

    /**
     * Updates and returns the item.
     * Needs access token.
     *
     * @param itemId    the target item identifier
     * @param body      the updated markdown format body
     * @param coediting whether this item is coediting(only in Qiita:Team)
     * @param isPrivate whether this item is private(invalid in Qiita:Team)
     * @param tags      the updated item tags
     * @param title     the updated item title
     * @return the updated item
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Item> updateItem(String itemId, String body, boolean coediting, boolean isPrivate, List<Tagging> tags, String title) throws QiitaException;

    /**
     * Deletes like from the item.
     * Needs access token for Qiita:Team.
     *
     * @param itemId the target item identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteLike(String itemId) throws QiitaException;

    /**
     * Add like to the item.
     * Needs access token for Qiita:Team.
     *
     * @param itemId the target item identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void addLike(String itemId) throws QiitaException;

    /**
     * Stocks the item.
     * Needs access token.
     *
     * @param itemId the target item identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void stock(String itemId) throws QiitaException;

    /**
     * Unstocks the item.
     * Needs access token.
     *
     * @param itemId the target item identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void unstock(String itemId) throws QiitaException;

    /**
     * Returns whether the authenticated user is stocking the item.
     * Needs access token.
     *
     * @param itemId the target item identifier
     * @return returns the authenticated user is stocking the item
     */
    boolean isStocked(String itemId);

    /**
     * Returns whether the authenticated user likes the item.
     * Needs access token for Qiita:Team.
     *
     * @param itemId the target item identifier
     * @return returns the authenticated user likes the item
     */
    boolean isLiked(String itemId);

    /**
     * Returns the items attached the tag in descending order of tagged date.
     * Can be used even with unauthenticated.
     *
     * @param tagId   the target tag identifier
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of items included per page({@code perPage > 0 && perPage <= 100})
     * @return the items attached the tag in descending order of tagged date
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Item>> getItemsByTag(String tagId, int page, int perPage) throws QiitaException;

    /**
     * Returns the items which the user posted in descending order of creation date.
     * Can be used even with unauthenticated.
     *
     * @param userId  the target user identifier
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of items included per page({@code perPage > 0 && perPage <= 100})
     * @return the item which the user posted
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Item>> getUserItems(String userId, int page, int perPage) throws QiitaException;

    /**
     * Returns the items which the user stocked in descending order of stocked date.
     * Can be used even with unauthenticated.
     *
     * @param userId  the target user identifier
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of items included per page({@code perPage > 0 && perPage <= 100})
     * @return the items which the user stocked
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Item>> getUserStocks(String userId, int page, int perPage) throws QiitaException;
}
