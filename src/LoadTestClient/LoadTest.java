package LoadTestClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.*;
import org.jboss.resteasy.client.jaxrs.*;
import org.jboss.resteasy.client.jaxrs.engines.ApacheHttpClient43Engine.*;

public class LoadTest {
/*
    eventAnalyzerClientConfiguration:
    baseUrl:  "http://eventanalyzerservice.vxp.bidw.aws.z8s.io:9050"
    maxRetries: 5
    retryTimeout: 1000 */

    public static void main(String[] args) {
        System.out.println("Starting load Test");
        EventAnalyzerClientConfiguration eacc = new EventAnalyzerClientConfiguration();
        eacc.baseUrl = "http://eventanalyzerservice.vxp.bidw.aws.z8s.io:9050";
        eacc.maxRetries = 5;
        eacc.retryTimeout = 1000;
        //Client client = ClientBuilder.newClient();

       ResteasyClient client = new ResteasyClientBuilder().build();

        //ResteasyClient client = new ResteasyClientBuilder().build();

        EventAnalyzerClient eac =  new EventAnalyzerClient(client, eacc);
        try {
            ArrayList<HashMap<String, Long>> integrationTestEvent = eac.getIntegrationTestEvent(false, 1);
            System.out.println(integrationTestEvent.size());
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
