package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.QiitaPageResponse;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;
import jp.yuiki.dev.qiita4jv2.enitity.Template;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#テンプレート">https://qiita.com/api/v2/docs#テンプレート</a>
 */
public interface TemplatesResources {
    /**
     * Returns the templates in the team.
     * Needs access token for Qiita:Team.
     *
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of templates included per page({@code perPage > 0 && perPage <= 100})
     * @return the templates in the team
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Template>> getTemplates(int page, int perPage) throws QiitaException;

    /**
     * Deletes the template.
     * Needs access token for Qiita:Team.
     *
     * @param templateId the template identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteTemplate(int templateId) throws QiitaException;

    /**
     * Returns the template.
     * Needs access token for Qiita:Team.
     *
     * @param templateId the target template identifier
     * @return the got template
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Template> getTemplate(int templateId) throws QiitaException;

    /**
     * Posts and returns the new template.
     * Needs access token for Qiita:Team.
     *
     * @param body  the template body
     * @param name  the template name
     * @param tags  the template tags
     * @param title the template title
     * @return the new created template
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Template> postTemplate(String body, String name, List<Tagging> tags, String title) throws QiitaException;

    /**
     * Updates and returns the template.
     * Needs access token for Qiita:Team.
     *
     * @param templateId the template identifier
     * @param body       the updated template body
     * @param name       the updated template name
     * @param tags       the updated template tags
     * @param title      The updated template title
     * @return the new updated template
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Template> updateTemplate(int templateId, String body, String name, List<Tagging> tags, String title) throws QiitaException;
}
