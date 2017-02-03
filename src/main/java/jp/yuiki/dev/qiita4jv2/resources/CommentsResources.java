package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.enitity.Comment;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#コメント">https://qiita.com/api/v2/docs#コメント</a>
 */
public interface CommentsResources {
    /**
     * Deletes the comment.
     * Needs access token.
     *
     * @param commentId the target comment identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteComment(String commentId) throws QiitaException;

    /**
     * Returns the comment.
     * Can be used even with unauthenticated.
     *
     * @param commentId the target comment identifier
     * @return the got comment
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Comment> getComment(String commentId) throws QiitaException;

    /**
     * Updates and returns the comment.
     * Need access token.
     *
     * @param body the updated comment body(Markdown format)
     * @return the updated comment
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Comment> updateComment(String commentId, String body) throws QiitaException;

    /**
     * Returns the comments which are attached to the item in descending order of creation time.
     * Can be used even with unauthenticated.
     *
     * @param itemId the target item identifier
     * @return the comments which are attached to the item
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<List<Comment>> getComments(String itemId) throws QiitaException;

    /**
     * Posts and returns the new comment.
     * Needs access token.
     *
     * @param itemId the target item identifier
     * @param body   the comment body(Markdown format)
     * @return the posted comment
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Comment> postComment(String itemId, String body) throws QiitaException;
}
