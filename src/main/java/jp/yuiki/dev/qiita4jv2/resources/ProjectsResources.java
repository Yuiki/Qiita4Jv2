package jp.yuiki.dev.qiita4jv2.resources;

import jp.yuiki.dev.qiita4jv2.QiitaException;
import jp.yuiki.dev.qiita4jv2.enitity.Project;
import jp.yuiki.dev.qiita4jv2.QiitaPageResponse;
import jp.yuiki.dev.qiita4jv2.QiitaResponse;
import jp.yuiki.dev.qiita4jv2.enitity.Tagging;

import java.util.List;

/**
 * @see <a href="https://qiita.com/api/v2/docs#プロジェクト">https://qiita.com/api/v2/docs#プロジェクト</a>
 */
public interface ProjectsResources {
    /**
     * Returns the projects existing in the team in descending order of the project creation date and time.
     * Needs access token for Qiita:Team.
     *
     * @param page    the page number({@code perPage > 0 && perPage <= 100})
     * @param perPage the amount of projects included per page({@code perPage > 0 && perPage <= 100})
     * @return the projects existing in the team in descending order of the project creation date and time
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaPageResponse<List<Project>> getProjects(int page, int perPage) throws QiitaException;

    /**
     * Posts and returns the new project.
     * Needs access token for Qiita:Team.
     *
     * @param archived whether this project is archived
     * @param body     the markdown format body
     * @param name     the project name
     * @param tags     the attached tags
     * @return the new created project
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Project> postProject(boolean archived, String body, String name, List<Tagging> tags) throws QiitaException;

    /**
     * Deletes the project.
     * Needs access token for Qiita:Team.
     *
     * @param projectId the target project identifier
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    void deleteProject(int projectId) throws QiitaException;

    /**
     * Returns the project.
     * Needs access token for Qiita:Team.
     *
     * @param projectId the target project identifier
     * @return the got project
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Project> getProject(int projectId) throws QiitaException;

    /**
     * Returns and updates the project.
     * Needs access token for Qiita:Team.
     *
     * @param projectId the project identifier
     * @param archived  whether this project is archived
     * @param body      the updated markdown format body
     * @param name      the updated project name
     * @param tags      the updated attached tags
     * @return the updated project
     * @throws QiitaException if arguments are incorrect or Qiita API is unavailable
     */
    QiitaResponse<Project> updateProject(int projectId, boolean archived, String body, String name, List<Tagging> tags) throws QiitaException;
}