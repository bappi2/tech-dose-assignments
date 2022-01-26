package LoadTestClient;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EventAnalyzerClient extends BaseJerseyClient {

    private final static ObjectMapper objectMapper = new ObjectMapper();


    private static int ThreadCount = 40;
    private static long SecondsTimeout = 120;




    public EventAnalyzerClient(Client client,
                               EventAnalyzerClientConfiguration eventAnalyzerClientConfiguration) {
        super(eventAnalyzerClientConfiguration, client);

        initializeMetrics();
    }

    public Map<String, Object> getDefaultHeaders() {
        Map<String, Object> headers = new HashMap<>();
        return headers;
    }

    public  ArrayList<HashMap<String, Long>> getIntegrationTestEvent(Boolean showAll, Integer count) throws IOException {
        UriBuilder hostUri = UriBuilder.fromPath(clientConfiguration.getBaseUrl());
        String url = hostUri.path("eventanalyzerservice/v1/operations/integrationTestEvent")
                .queryParam("showAll", showAll)
                .queryParam("count", count)
                .build()
                .toString();

        ArrayList<HashMap<String, Long>> list = new ArrayList<>();
        String json = get(url, String.class);
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        HashMap testEvents = objectMapper.readValue( json, HashMap.class);
        ArrayList events = (ArrayList) testEvents.get("events");
        return events;
    }


    private static final String HEADER_AUTHORIZATION = "Authorization";
    private static final String HEADER_USERID = "x-catalog-userid";
    private static final String HEADER_CONTENTTYPE = "content-type";
    private static final String HEADER_CACHECONTROL = "cache-control";

    private Map<String, Object> getDefaultHeadersA() {
        return Maps.newHashMap();
    }

    private Map<String, Object> setDefaultHeaders() {
        Map<String, Object> defaultHeaders = getDefaultHeadersA();

        if (!defaultHeaders.containsKey(HEADER_CONTENTTYPE)) {
            defaultHeaders.put(HEADER_CONTENTTYPE, "application/json");
        }

        return defaultHeaders;
    }

    private void initializeMetrics() {

    }
}


