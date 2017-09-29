package crawler.util;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public abstract class WebCrawler {

    private String baseUrl;

    private WebCrawler() {}

    public WebCrawler(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    private Connection.Response connect() throws IOException {
        Connection.Response response = Jsoup.connect(this.baseUrl)
                .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                .timeout(10000)
                .execute();
        return response;
    }

    protected Document getBaseUrlDocument() throws IOException {
        // Connects to the base URL and performs a GET request
        Connection.Response response = this.connect();
        return response.parse();
    }
}
