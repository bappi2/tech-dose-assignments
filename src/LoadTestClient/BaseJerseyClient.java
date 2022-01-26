package LoadTestClient;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections4.MapUtils;
import org.glassfish.jersey.client.ClientProperties;
import org.slf4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

//import com.google.common.collect.Maps;

public abstract class BaseJerseyClient {
    private final static Logger logger = LoggerFactoryExt.getLogger(BaseJerseyClient.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    public static final String HEADER_API_KEY = "api-key";
    public static final String HEADER_TRACEID = "x-trace-id";
    public static final String HEADER_AUTHORIZATION = "Authorization";
    public static final String HEADER_USERID = "x-catalog-userid";
    public static final String HEADER_CONTENTTYPE = "content-type";
    public static final String HEADER_CACHECONTROL = "cache-control";
    public static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    public static final String HEADER_SERVICE_NAME = "X-Auth-Service-Name";

    protected Client client;
    protected BaseClientConfiguration clientConfiguration;

    public BaseJerseyClient(BaseClientConfiguration configuration, Client client) {
        this.clientConfiguration = configuration;
        //this.client = client.property(ClientProperties.SUPPRESS_HTTP_COMPLIANCE_VALIDATION, true);
        if ( this.client != null ) {
            //this.client.property(HttpUrlConnectorProvider.SET_METHOD_WORKAROUND, true);

            int socketTimeout = 60000; // "600000ms"
            int timeout = 60000;
//            if (configuration != null ) {
//                socketTimeout = configuration.getSocketTimeout();
//                timeout = configuration.getTimeout();
//            }
            logger.info("baseclient properties: CONNECT_TIMEOUT=" + socketTimeout + " READ_TIMEOUT=" + timeout);
            this.client.property(ClientProperties.CONNECT_TIMEOUT, socketTimeout);
            this.client.property(ClientProperties.READ_TIMEOUT, timeout);
        }

    }

    public abstract Map<String, Object> getDefaultHeaders();

    public <T> T get(String url, Class<T> tClass) {
        logger.debug(String.format(String.format("GET %s", url)));
        String json = null;

        WebTarget target;
        target = client.target(url);
        Response response = get(target);
        try {
            json = response.readEntity(String.class);
            if (response.getStatus() == 200) {
                if (tClass.getName().equals("java.lang.String")) {
                    return tClass.cast(json);
                }
                return ObjectMapperUtil.deserialize(json, tClass);
            }
        } catch (Exception e) {
            logger.error("Cannot deserialize response: " + json);
        }

        return null;
    }


    public Response get(WebTarget webTarget) {
        logger.debug(String.format(String.format("GET %s", webTarget.getUri().toString())));
        Response response = null;

        int retries = 0;
        int maxRetries = clientConfiguration.getMaxRetries();
        boolean retry = true;
        int retryTimeout = clientConfiguration.getRetryTimeout();

        while (retry && retries < maxRetries) {
            response = createDefaultWebTargetBuilder(webTarget).get();
            retry = isRetryable(response.getStatus());
            if (retry) {
                try {
                    logger.debug(String.format("retrying (%d) uri %s; response: %d", retries, webTarget.getUri().toString(), response.getStatus()));
                    Thread.sleep(retryTimeout);
                } catch (InterruptedException e) {
                    // ignore interruptions
                    return null;
                }
                retryTimeout *= 2;
                retries++;
            }
        }
        if (retries >= maxRetries) {
            if (response != null) {
                logger.error("Get " + webTarget.getUri().toString() + " too many retries. Response: " + response.getStatus());
            }
            else {
                logger.error("Get " + webTarget.getUri().toString() + " too many retries. Response is null");
            }
        }
        return response;
    }

    private boolean isRetryable(int status) {
        if (status == Response.Status.GATEWAY_TIMEOUT.getStatusCode() ||
                status == Response.Status.SERVICE_UNAVAILABLE.getStatusCode() ||
                status == Response.Status.BAD_GATEWAY.getStatusCode()
                ) {
            return true;
        }
        return false;
    }


    Response delete(WebTarget webTarget) {
        logger.debug(String.format("DELETE %s", webTarget.getUri().toString()));
        return createDefaultWebTargetBuilder(webTarget).delete();
    }

    <T> Response delete(WebTarget webTarget, T requestEntity) {
        logger.debug(String.format("DELETE %s", webTarget.getUri().toString()));
        return createDefaultWebTargetBuilder(webTarget).method("DELETE", Entity.json(requestEntity));
    }


    public <T> T post(String url, Object entity, Class<T> tClass, Boolean retriesOK) {
        logger.debug(String.format("POST %s", url));
        String json = null;

        if (entity != null) {
            try {
                json = objectMapper.writeValueAsString(entity);
            } catch (Exception e) {
                logger.error(String.format("POST %s, Cannot convert payload to JSON", url));
                return null;
            }
        }
        WebTarget target;
        target = client.target(url);

        Response response = this.postOne(target, Entity.json(json), retriesOK);
        try {
            json = response.getEntity().toString();
            if (response.getStatus() == 200) {
                if (tClass.getName().equals("java.lang.String")) {
                    return tClass.cast(json);
                }
                return ObjectMapperUtil.deserialize(json, tClass);
            }
        } catch (Exception e) {
            logger.error("Cannot deserialize response: " + json);
        }

        return null;
    }


    public Response postOne(WebTarget webTarget, Entity<?> arg, Boolean retriesOK) {
        logger.debug(String.format("POST %s", webTarget.getUri().toString()));
        Response response = null;

        int retries = 0;
        boolean retry = true;
        int retryTimeout = clientConfiguration.getRetryTimeout();
        int maxRetries = clientConfiguration.getMaxRetries();

        while (retry && retries < maxRetries) {
            try {
                response = createDefaultWebTargetBuilder(webTarget).post(arg);
                retry = isRetryable(response.getStatus());
            } catch (Exception ex) {
                logger.info("Got exception when posting to " + webTarget.getUri().toString() + "; retries= " + retries + "; - " + ExceptionUtilsEx.getExceptionInformation(ex));
                retry = true; // java.net.ConnectException: Connection refused (Connection refused)
            }
            if (retry && retriesOK) {
                try {
                    logger.debug(String.format("retrying (%d) uri %s; response: %d", retries, webTarget.getUri().toString(), response == null ? 0 : response.getStatus()));
                    if (response != null) {
                        response.close();
                    }
                    Thread.sleep(retryTimeout);
                } catch (InterruptedException e) {
                    // ignore interruptions
                    retry = false;
                }
                retryTimeout *= 2;
                retries++;
            }
        }
        if (retries >= maxRetries) {
            logger.error("POST " + webTarget.getUri().toString() + " too many retries. Response: " + response.getStatus());
        }

        return response;
    }

    <T> Response put(WebTarget webTarget, T requestEntity) {
        logger.debug(String.format("PUT %s %s", webTarget.getUri().toString(), ObjectMapperUtil.toJSON(requestEntity, false)));
        return createDefaultWebTargetBuilder(webTarget).put(Entity.json(requestEntity));
    }

    Response put(WebTarget webTarget) {
        logger.debug(String.format("PUT %s", webTarget.getUri().toString()));
        return createDefaultWebTargetBuilder(webTarget).put(null);
    }


    protected <T> T patch(String url, Object entity, Class<T> tClass, Boolean retriesOK) {
        logger.debug(String.format("PATCH %s", url));
        Response response = null;
        logger.info(String.format("GET %s", url));
        int retries = 0;
        boolean retry = true;
        int timeout = 1000;

        return null;
    }

    Response patch(WebTarget webTarget, String requestEntityJson) {
        logger.debug(String.format("PATCH %s %s", webTarget.getUri().toString(), requestEntityJson));
        Response response = null;
        int maxRetries = clientConfiguration.getMaxRetries();

        int retries = 0;
        boolean retry = true;
        int timeout = 1000;
        while (retry && retries < maxRetries) {
            response = createDefaultWebTargetBuilder(webTarget).method("PATCH", Entity.json(requestEntityJson));
            retry = isRetryable(response.getStatus());
            if (retry) {
                try {
                    logger.info(String.format("retrying (%d) uri %s; response: %d", retries, webTarget.getUri().toString(), response.getStatus()));
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    // ignore interruptions
                }
                timeout *= 2;
                retries++;
            }
        }
        if (retries >= maxRetries) {
            logger.error("PATCH " + webTarget.getUri().toString() + " too many retries. Response: " + response.getStatus());
        }
        return response;
    }

    <T> Response patch(WebTarget webTarget, T requestEntity) {
        logger.debug(String.format("PATCH %s %s", webTarget.getUri().toString(), ObjectMapperUtil.toJSON(requestEntity, false)));
        return createDefaultWebTargetBuilder(webTarget).method("PATCH", Entity.json(requestEntity));
    }

    private Invocation.Builder createDefaultWebTargetBuilder(WebTarget webTarget) {
        Invocation.Builder builder = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .accept(MediaType.APPLICATION_JSON_TYPE);

        Map<String, Object> defaultHeaders = setDefaultHeaders();
        if (MapUtils.isNotEmpty(defaultHeaders)) {
            for (Map.Entry<String, Object> header : defaultHeaders.entrySet()) {
                builder.header(header.getKey(), header.getValue());
            }
        }

        return builder;
    }

    private Map<String, Object> setDefaultHeaders() {
        Map<String, Object> defaultHeaders = getDefaultHeaders();

        if (!defaultHeaders.containsKey(HEADER_USERID)) {
            defaultHeaders.put(HEADER_USERID, "123");
        }

        if (!defaultHeaders.containsKey(HEADER_CONTENTTYPE)) {
            defaultHeaders.put(HEADER_CONTENTTYPE, "application/json");
        }

        if (!defaultHeaders.containsKey(HEADER_CACHECONTROL)) {
            defaultHeaders.put(HEADER_CACHECONTROL, "no-cache");
        }
        return defaultHeaders;
    }
}

