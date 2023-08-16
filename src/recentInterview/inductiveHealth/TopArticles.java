package recentInterview.inductiveHealth;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TopArticles {

class Article {
    private String title;

    public Article(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}


    private static final String API_BASE_URL = "https://jsonmock.hackerrank.com/api/articles?page=";

    public List<Article> retrieveArticlesFromPage(int pageNumber) throws IOException {
        String apiUrl = API_BASE_URL + pageNumber;
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);
        HttpResponse response = httpClient.execute(httpGet);

        String responseBody = EntityUtils.toString(response.getEntity());
        JSONObject jsonResponse = new JSONObject(responseBody);
        JSONArray articlesArray = jsonResponse.getJSONArray("data");

        List<Article> articles = new ArrayList<>();
        for (int i = 0; i < articlesArray.length(); i++) {
            JSONObject articleObject = articlesArray.getJSONObject(i);
            String title = articleObject.isNull("title") ? null : articleObject.getString("title");
            Article article = new Article(title);
            articles.add(article);
        }

        return articles;
    }

    public static void main(String[] args) {
        TopArticles articleManager = new TopArticles();
        int pageNumber = 1; // Specify the desired page number
        try {
            List<Article> articles = articleManager.retrieveArticlesFromPage(pageNumber);
            System.out.println("Articles from page " + pageNumber + ":");
            for (Article article : articles) {
                System.out.println(article.getTitle());
            }
        } catch (IOException e) {
            System.out.println("Error retrieving articles: " + e.getMessage());
        }
    }
}
