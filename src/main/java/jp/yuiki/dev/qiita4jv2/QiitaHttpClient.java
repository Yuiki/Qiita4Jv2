package jp.yuiki.dev.qiita4jv2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.client.HttpUrlConnectorProvider;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class QiitaHttpClient {
    private final WebTarget target;

    private String accessToken;

    QiitaHttpClient(String path) {
        this.target = ClientBuilder.newClient().target(path);
    }

    WebTarget getTarget() {
        return target;
    }

    void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    <E> QiitaPageResponse<E> getPage(String path, Map<String, String> entity, GenericType<E> entityType) throws QiitaException {
        Response response = get(path, entity);
        return createQiitaPageResponse(response, response.readEntity(entityType));
    }

    <E> QiitaResponse<E> get(String path, GenericType<E> entityType) throws QiitaException {
        Response response = get(path, new HashMap<>());
        return createQiitaResponse(response, response.readEntity(entityType));
    }

    <E> QiitaResponse<E> get(String path, Class<E> entityType) throws QiitaException {
        Response response = get(path, new HashMap<>());
        return createQiitaResponse(response, response.readEntity(entityType));
    }

    private Response get(String path, Map<String, String> entity) throws QiitaException {
        Response response = constructResponse(path, entity).get();
        if (response.getStatus() == 200) {
            return response;
        } else {
            throw response.readEntity(QiitaException.class);
        }
    }

    <E> QiitaResponse<E> post(String path, Object value, Class<E> entityType) throws QiitaException {
        Entity entity = objectToEntity(value);
        Response response = constructResponse(path).post(entity);
        if (response.getStatus() == 201) {
            return createQiitaResponse(response, response.readEntity(entityType));
        } else {
            throw response.readEntity(QiitaException.class);
        }
    }

    <E> QiitaResponse<E> patch(String path, Object value, Class<E> entityType) throws QiitaException {
        Entity entity = objectToEntity(value);
        Response response = constructResponse(path).property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true).method("PATCH", entity);
        if (response.getStatus() == 200) {
            return createQiitaResponse(response, response.readEntity(entityType));
        } else {
            throw response.readEntity(QiitaException.class);
        }
    }

    void put(String path) throws QiitaException {
        Entity entity = Entity.entity("", MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        Response response = constructResponse(path).put(entity);
        if (response.getStatus() != 204) {
            throw response.readEntity(QiitaException.class);
        }
    }

    void delete(String path) throws QiitaException {
        Response response = constructResponse(path).delete();
        if (response.getStatus() != 204) {
            throw response.readEntity(QiitaException.class);
        }
    }

    private Invocation.Builder constructResponse(String path, Map<String, String> params) {
        WebTarget t = target.path(path);
        Set<Map.Entry<String, String>> entries = params.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            t = t.queryParam(entry.getKey(), entry.getValue());
        }
        Invocation.Builder builder = t.request();
        if (accessToken != null) {
            builder.header("Authorization", "Bearer " + accessToken);
        }
        return builder;
    }

    Invocation.Builder constructResponse(String path) {
        return constructResponse(path, new HashMap<>());
    }

    private Entity objectToEntity(Object value) throws QiitaException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonEntity;
        try {
            jsonEntity = mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new QiitaException(e, e.getMessage(), "json_processing_error");
        }
        return Entity.entity(jsonEntity, MediaType.APPLICATION_JSON_TYPE);
    }

    private <E> QiitaResponse<E> createQiitaResponse(Response response, E entity) {
        String rateResetString = response.getHeaderString("Rate-Reset");
        long rateReset = rateResetString == null ? -1L : Long.parseLong(rateResetString);
        String rateLimitString = response.getHeaderString("Rate-Limit");
        long rateLimit = rateResetString == null ? -1L : Long.parseLong(rateLimitString);
        String rateRemainingString = response.getHeaderString("Rate-Remaining");
        long rateRemaining = rateResetString == null ? -1L : Long.parseLong(rateRemainingString);
        return new QiitaResponse<>(entity, rateReset, rateLimit, rateRemaining);
    }

    private <E> QiitaPageResponse<E> createQiitaPageResponse(Response response, E entity) {
        long totalCount = Long.parseLong(response.getHeaderString("Total-Count"));
        long rateReset = Long.parseLong(response.getHeaderString("Rate-Reset"));
        long rateLimit = Long.parseLong(response.getHeaderString("Rate-Limit"));
        long rateRemaining = Long.parseLong(response.getHeaderString("Rate-Remaining"));
        return new QiitaPageResponse<>(entity, totalCount, rateReset, rateLimit, rateRemaining);
    }
}
