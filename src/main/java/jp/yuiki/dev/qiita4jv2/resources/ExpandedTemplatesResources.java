package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;
import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.enitity.ExpandedTemplate;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#展開済みテンプレート">https://qiita.com/api/v2/docs#展開済みテンプレート</a>
 */
public interface ExpandedTemplatesResources {
    /**
     * Returns the template expanded variable.
     * Needs access token for Qiita:Team.
     *
     * @param body  the template body
     * @param tags  the template tags
     * @param title the template title
     * @return the template expanded variable
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<ExpandedTemplate> expandTemplateVariable(String body, List<Tagging> tags, String title) throws QiitaException;
}