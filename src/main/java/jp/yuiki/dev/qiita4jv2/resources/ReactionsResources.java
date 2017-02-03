package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Reaction;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#絵文字リアクション">https://qiita.com/api/v2/docs#絵文字リアクション</a>
 */
public interface ReactionsResources {
    /**
     * Posts the reaction to the comment and returns the posted reaction.
     * Needs access token.
     *
     * @param commentId    identifier of the target comment
     * @param reactionName identical name of the posting reaction
     * @return the posted reaction
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Reaction> postCommentReaction(String commentId, String reactionName) throws QiitaException;

    /**
     * Posts the reaction to the item and returns the posted reaction.
     * Needs access token.
     *
     * @param itemId       identifier of the target item
     * @param reactionName identical name of the posting reaction
     * @return the posted reaction
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Reaction> postItemReaction(String itemId, String reactionName) throws QiitaException;

    /**
     * Posts the reaction to the project and returns the posted reaction.
     * Needs access token for Qiita:Team.
     *
     * @param projectId    identifier of the target project
     * @param reactionName identical name of the posting reaction
     * @return the posted reaction
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Reaction> postProjectReaction(int projectId, String reactionName) throws QiitaException;

    /**
     * Deletes the reaction attached to the comment.
     * Needs access token.
     *
     * @param commentId    identifier of the target comment
     * @param reactionName identical name of the deleting reaction
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteCommentReaction(String commentId, String reactionName) throws QiitaException;

    /**
     * Deletes the reaction attached to the item.
     * Needs access token.
     *
     * @param itemId       identifier of the target item
     * @param reactionName identical name of the deleting reaction
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteItemReaction(String itemId, String reactionName) throws QiitaException;

    /**
     * Deletes the reaction attached to the project.
     * Needs access token for Qiita:Team.
     *
     * @param projectId    identifier of the target project
     * @param reactionName identical name of the deleting reaction
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteProjectReaction(int projectId, String reactionName) throws QiitaException;

    /**
     * Returns the reactions attached to the comment.
     * Can be used even with unauthenticated.
     *
     * @param commentId identifier of the target comment
     * @return the got reactions
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<List<Reaction>> getCommentReactions(String commentId) throws QiitaException;

    /**
     * Returns the reactions attached to the item.
     * Can be used even with unauthenticated.
     *
     * @param itemId identifier of the target item
     * @return the got reactions
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<List<Reaction>> getItemReactions(String itemId) throws QiitaException;

    /**
     * Returns the reactions attached to the project.
     * Needs access token for Qiita:Team.
     *
     * @param projectId identifier of the target project
     * @return the got reactions
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<List<Reaction>> getProjectReactions(int projectId) throws QiitaException;
}