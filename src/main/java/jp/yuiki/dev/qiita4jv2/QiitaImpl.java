package jp.yuiki.dev.qiita4jv2;

import jp.yuiki.dev.qiita4jv2.enitity.*;
import jp.yuiki.dev.qiita4jv2.request.*;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QiitaImpl implements Qiita {
    private QiitaHttpClient httpClient;

    private String clientId;
    private String clientSecret;

    QiitaImpl() {
        initHttpClient("https://qiita.com/api/v2");
    }

    QiitaImpl(String teamId) {
        initHttpClient("https://" + teamId + ".qiita.com/api/v2");
    }

    private void initHttpClient(String path) {
        httpClient = new QiitaHttpClient(path);
    }

    public void setAccessToken(String accessToken) {
        httpClient.setAccessToken(accessToken);
    }

    public void setClientInformation(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public URI getAuthorizeUrl(String scope, String state) throws QiitaException {
        if (clientId == null) {
            throw new QiitaException("You need to call Qiita#setClientInformation", "need_client_id");
        }
        return httpClient.getTarget()
                .path("/oauth/authorize")
                .queryParam("client_id", clientId)
                .queryParam("scope", scope)
                .queryParam("state", state)
                .getUri();
    }

    public QiitaResponse<AccessToken> getAccessToken(String code) throws QiitaException {
        AccessTokenRequest request = new AccessTokenRequest(clientId, clientSecret, code);
        return httpClient.post("/access_tokens", request, AccessToken.class);
    }

    public void expireAndUnsetAccessToken() throws QiitaException {
        httpClient.delete("/access_tokens/" + httpClient.getAccessToken());
    }

    public QiitaResponse<List<Like>> getLikes(String itemId) throws QiitaException {
        return httpClient.get("/items/" + itemId + "/likes", new GenericType<List<Like>>() {});
    }

    public void deleteComment(String commentId) throws QiitaException {
        httpClient.delete("/comments/" + commentId);
    }

    public QiitaResponse<Comment> getComment(String commentId) throws QiitaException {
        return httpClient.get("/comments/" + commentId, Comment.class);
    }

    public QiitaResponse<Comment> updateComment(String commentId, String body) throws QiitaException {
        CommentRequest request = new CommentRequest(body);
        return httpClient.patch("/comments/" + commentId, request, Comment.class);
    }

    public QiitaResponse<List<Comment>> getComments(String itemId) throws QiitaException {
        return httpClient.get("/items/" + itemId + "/comments", new GenericType<List<Comment>>() {});
    }

    public QiitaResponse<Comment> postComment(String itemId, String body) throws QiitaException {
        CommentRequest request = new CommentRequest(body);
        return httpClient.post("/items/" + itemId + "/comments", request, Comment.class);
    }

    public QiitaResponse<Tagging> addTag(String itemId, String name, List<String> versions) throws QiitaException {
        Tagging tag = new Tagging(name, versions);
        return httpClient.post("/items/" + itemId + "/taggings", tag, Tagging.class);
    }

    public void deleteTag(String itemId, String taggingId) throws QiitaException {
        httpClient.delete("/items/" + itemId + "/taggings/" + taggingId);
    }

    public QiitaPageResponse<List<Tag>> getTags(int page, int perPage, String sort) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        params.put("sort", sort);
        return httpClient.getPage("/tags", params, new GenericType<List<Tag>>() {});
    }

    public QiitaResponse<Tag> getTag(String tagId) throws QiitaException {
        return httpClient.get("/tags/" + tagId, new GenericType<Tag>() {});
    }

    public QiitaPageResponse<List<Tag>> getUserFollowingTags(String userId, int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/users/" + userId + "/following_tags", params, new GenericType<List<Tag>>() {});
    }

    public void unfollowTag(String tagId) throws QiitaException {
        httpClient.delete("/tags/" + tagId + "/following");
    }

    public boolean isFollowingTag(String tagId) {
        Response response = httpClient.constructResponse("/tags/" + tagId + "/following").get();
        return response.getStatus() == 204;
    }

    public void followTag(String tagId) throws QiitaException {
        httpClient.put("/tags/" + tagId + "/following");
    }

    public QiitaResponse<List<Team>> getAuthenticatedUserTeams() throws QiitaException {
        return httpClient.get("/teams", new GenericType<List<Team>>() {});
    }

    public QiitaPageResponse<List<Template>> getTemplates(int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/templates", params, new GenericType<List<Template>>() {});
    }

    public void deleteTemplate(int templateId) throws QiitaException {
        httpClient.delete("/templates/" + templateId);
    }

    public QiitaResponse<Template> getTemplate(int templateId) throws QiitaException {
        return httpClient.get("/templates/" + templateId, Template.class);
    }

    public QiitaResponse<Template> postTemplate(String body, String name, List<Tagging> tags, String title) throws QiitaException {
        TemplateRequest request = new TemplateRequest(body, name, tags, title);
        return httpClient.post("/templates", request, Template.class);
    }

    public QiitaResponse<Template> updateTemplate(int templateId, String body, String name, List<Tagging> tags, String title) throws QiitaException {
        TemplateRequest request = new TemplateRequest(body, name, tags, title);
        return httpClient.patch("/templates/" + templateId, request, Template.class);
    }

    public QiitaPageResponse<List<Project>> getProjects(int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/projects", params, new GenericType<List<Project>>() {});
    }

    public QiitaResponse<Project> postProject(boolean archived, String body, String name, List<Tagging> tags) throws QiitaException {
        ProjectPostRequest request = new ProjectPostRequest(archived, body, name, tags);
        return httpClient.post("/projects", request, Project.class);
    }

    public void deleteProject(int projectId) throws QiitaException {
        httpClient.delete("/projects/" + projectId);
    }

    public QiitaResponse<Project> getProject(int projectId) throws QiitaException {
        return httpClient.get("/projects/" + projectId, Project.class);
    }

    public QiitaResponse<Project> updateProject(int projectId, boolean archived, String body, String name, List<Tagging> tags) throws QiitaException {
        ProjectPostRequest request = new ProjectPostRequest(archived, body, name, tags);
        return httpClient.patch("/projects/" + projectId, request, Project.class);
    }

    public QiitaPageResponse<List<User>> getStockingUsers(String itemId, int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/items/" + itemId + "/stockers", params, new GenericType<List<User>>() {});
    }

    public QiitaPageResponse<List<User>> getUsers(int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/users", params, new GenericType<List<User>>() {});
    }

    public QiitaResponse<User> getUser(String userId) throws QiitaException {
        return httpClient.get("/users/" + userId, User.class);
    }

    public QiitaPageResponse<List<User>> getUserFollowingUsers(String userId, int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/users/" + userId + "/followees", params, new GenericType<List<User>>() {});
    }

    public QiitaPageResponse<List<User>> getUserFollowerUsers(String userId, int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/users/" + userId + "/followers", params, new GenericType<List<User>>() {});
    }

    public void unfollowUser(String userId) throws QiitaException {
        httpClient.delete("/users/" + userId + "/following");
    }

    public boolean isFollowingUser(String userId) {
        Response response = httpClient.constructResponse("/users/" + userId + "/following").get();
        return response.getStatus() == 204;
    }

    public void followUser(String userId) throws QiitaException {
        httpClient.put("/users/" + userId + "/following");
    }

    public QiitaResponse<ExpandedTemplate> expandTemplateVariable(String body, List<Tagging> tags, String title) throws QiitaException {
        ExpandedTemplateRequest request = new ExpandedTemplateRequest(body, tags, title);
        return httpClient.post("/expanded_templates", request, ExpandedTemplate.class);
    }

    public QiitaPageResponse<List<Item>> getAuthenticatedUserItems(int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/authenticated_user/items", params, new GenericType<List<Item>>() {});
    }

    public QiitaPageResponse<List<Item>> getItemsByQuery(int page, int perPage, String query) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        params.put("query", query);
        return httpClient.getPage("/items", params, new GenericType<List<Item>>() {});
    }

    public QiitaResponse<Item> postItem(String body, boolean coediting, boolean gist, boolean isPrivate, List<Tagging> tags, String title, boolean tweet) throws QiitaException {
        ItemPostRequest request = new ItemPostRequest(body, coediting, gist, isPrivate, tags, title, tweet);
        return httpClient.post("/items", request, Item.class);
    }

    public void deleteItem(String itemId) throws QiitaException {
        httpClient.delete("/items/" + itemId);
    }

    public QiitaResponse<Item> getItem(String itemId) throws QiitaException {
        return httpClient.get("/items/" + itemId, Item.class);
    }

    public QiitaResponse<Item> updateItem(String itemId, String body, boolean coediting, boolean isPrivate, List<Tagging> tags, String title) throws QiitaException {
        ItemPatchRequest request = new ItemPatchRequest(body, coediting, isPrivate, tags, title);
        return httpClient.patch("/items/" + itemId, request, Item.class);
    }

    public void deleteLike(String itemId) throws QiitaException {
        httpClient.delete("/items/" + itemId + "/like");
    }

    public void addLike(String itemId) throws QiitaException {
        httpClient.put("/items/" + itemId + "/like");
    }

    public void stock(String itemId) throws QiitaException {
        httpClient.put("/items/" + itemId + "/stock");
    }

    public void unstock(String itemId) throws QiitaException {
        httpClient.delete("/items/" + itemId + "/stock");
    }

    public boolean isStocked(String itemId) {
        Response response = httpClient.constructResponse("/items" + itemId + "/stock").get();
        return response.getStatus() == 204;
    }

    public boolean isLiked(String itemId) {
        Response response = httpClient.constructResponse("/items" + itemId + "/like").get();
        return response.getStatus() == 204;
    }

    public QiitaPageResponse<List<Item>> getItemsByTag(String tagId, int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/tags/" + tagId + "/items", params, new GenericType<List<Item>>() {});
    }

    public QiitaPageResponse<List<Item>> getUserItems(String userId, int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/users/" + userId + "/items", params, new GenericType<List<Item>>() {});
    }

    public QiitaPageResponse<List<Item>> getUserStocks(String userId, int page, int perPage) throws QiitaException {
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(page));
        params.put("per_page", String.valueOf(perPage));
        return httpClient.getPage("/users/" + userId + "/stocks", params, new GenericType<List<Item>>() {});
    }

    public QiitaResponse<Reaction> postCommentReaction(String commentId, String reactionName) throws QiitaException {
        ReactionPostRequest request = new ReactionPostRequest(reactionName);
        return httpClient.post("/comments/" + commentId + "/reactions", request, Reaction.class);
    }

    public QiitaResponse<Reaction> postItemReaction(String itemId, String reactionName) throws QiitaException {
        ReactionPostRequest request = new ReactionPostRequest(reactionName);
        return httpClient.post("/items/" + itemId + "/reactions", request, Reaction.class);
    }

    public QiitaResponse<Reaction> postProjectReaction(int projectId, String reactionName) throws QiitaException {
        ReactionPostRequest request = new ReactionPostRequest(reactionName);
        return httpClient.post("/projects/" + projectId + "/reactions", request, Reaction.class);
    }

    public void deleteCommentReaction(String commentId, String reactionName) throws QiitaException {
        httpClient.delete("/comments/" + commentId + "/reactions/" + reactionName);
    }

    public void deleteItemReaction(String itemId, String reactionName) throws QiitaException {
        httpClient.delete("/items/" + itemId + "/reactions/" + reactionName);
    }

    public void deleteProjectReaction(int projectId, String reactionName) throws QiitaException {
        httpClient.delete("/projects/" + projectId + "/reactions/" + reactionName);
    }

    public QiitaResponse<List<Reaction>> getCommentReactions(String commentId) throws QiitaException {
        return httpClient.get("/comments/" + commentId + "/" + "reactions", new GenericType<List<Reaction>>() {});
    }

    public QiitaResponse<List<Reaction>> getItemReactions(String itemId) throws QiitaException {
        return httpClient.get("/items/" + itemId + "/" + "reactions", new GenericType<List<Reaction>>() {});
    }

    public QiitaResponse<List<Reaction>> getProjectReactions(int projectId) throws QiitaException {
        return httpClient.get("/projects/" + projectId + "/" + "reactions", new GenericType<List<Reaction>>() {});
    }

    public QiitaResponse<AuthenticatedUser> getAuthenticatedUser() throws QiitaException {
        return httpClient.get("/authenticated_user", AuthenticatedUser.class);
    }
}