package crawler;

import crawler.util.WebCrawler;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
A simple web crawling robot using Jsoup which grabs all headlines from the BBC homepage
 */
public class BBCSpider extends WebCrawler {

    private static final String baseURL = "https://www.bbc.co.uk";

    public BBCSpider() {
        super(baseURL);
    }

    private Elements getTopStoryElements() throws IOException {
        // Query the document for the headlines
        Elements elms = super.getBaseUrlDocument().select("span.top-story__title");
        return elms;
    }

    public List<String> getHeadlines() throws IOException {
        // Append headlines to a ArrayList and return
        List<String> headlines = new ArrayList<String>();
        for (Element elem : this.getTopStoryElements()) {
            headlines.add(elem.text());
        }
        return headlines;
    }

}
