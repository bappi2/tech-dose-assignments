package recentInterview.inductiveHealth;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URL;

public class JsonParsingExample {
    private static final String API_BASE_URL = "https://jsonmock.hackerrank.com/api/articles?page=";

    public static void main(String[] args) {
        String url = "https://jsonmock.hackerrank.com/api/articles?page=";
        int pageNumber = 1;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String apiUrl = API_BASE_URL + pageNumber;
            HttpClient httpClient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet(apiUrl);
            HttpResponse response = httpClient.execute(httpGet);

            String responseBody = EntityUtils.toString(response.getEntity());

            ArticleApiResponse articleApiResponse = objectMapper.readValue(responseBody, ArticleApiResponse.class);
            int totalPages = articleApiResponse.getTotalPages();
            System.out.println("Total Pages: " + totalPages);
            for (Article article : articleApiResponse.getArticles()) {
                String title = article.getTitle();
                String author = article.getAuthor();
                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
