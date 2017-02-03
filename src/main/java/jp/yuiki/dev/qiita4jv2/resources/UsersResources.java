package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.QiitaPageResponse;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.User;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#ユーザ">https://qiita.com/api/v2/docs#ユーザ</a>
 */
public interface UsersResources {
    /**
     * Returns the users who are stocking the item in descending order of stocked time.
     * Can be used even with unauthenticated.
     *
     * @param itemId  the target item identifier
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of users included per page({@code perPage > 0 && perPage <= 100})
     * @return the users who is stocking the item in the page
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<User>> getStockingUsers(String itemId, int page, int perPage) throws QiitaException;

    /**
     * Returns all users in descending order of creation time.
     * Can be used even with unauthenticated.
     *
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of users included per page({@code perPage > 0 && perPage <= 100})
     * @return the all users in the page
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<User>> getUsers(int page, int perPage) throws QiitaException;

    /**
     * Returns the user.
     * Can be used even with unauthenticated.
     *
     * @param userId the user identifier
     * @return the user
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<User> getUser(String userId) throws QiitaException;

    /**
     * Returns the users who the user is following.
     * Can be used even with unauthenticated.
     *
     * @param userId  the target user identifier
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of users included per page({@code perPage > 0 && perPage <= 100})
     * @return the users who the user is following.
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<User>> getUserFollowingUsers(String userId, int page, int perPage) throws QiitaException;

    /**
     * Returns the users who follow the user.
     * Can be used even with unauthenticated.
     *
     * @param userId  the target user identifier
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of users included per page({@code perPage > 0 && perPage <= 100})
     * @return the users who follow the user.
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<User>> getUserFollowerUsers(String userId, int page, int perPage) throws QiitaException;

    /**
     * Unfollows the target user.
     * Need access token.
     *
     * @param userId the target user
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void unfollowUser(String userId) throws QiitaException;

    /**
     * Returns whether the authenticated user follows the target user.
     * Need access token.
     *
     * @param userId the target user
     * @return whether the authenticated user follows the target user
     */
    boolean isFollowingUser(String userId);

    /**
     * Follows the target user.
     * Need access token.
     *
     * @param userId the target user
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void followUser(String userId) throws QiitaException;
}