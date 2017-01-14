package webcrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
    private Queue<String> queue = new LinkedList<>();
    private List<String> discoveredWebsites = new ArrayList<>();

    public void discoverWeb(String root) {
        this.queue.add(root);
        this.discoveredWebsites.add(root);

        while(!this.queue.isEmpty()) {
            String currentUrl = this.queue.remove();

            String rawHtml = this.extractHtmlFrom(currentUrl);
            Matcher matcher = this.getMatcherFor("http://(\\w+\\.)*(\\w+)", rawHtml);

            while(matcher.find()) {
                String url = matcher.group();

                if(!this.discoveredWebsites.contains(url)) {
                    this.queue.add(url);
                    this.discoveredWebsites.add(url);

                    System.out.println("Website has been found with URL: " + url);
                }
            }
        }
    }

    private String extractHtmlFrom(String url) {
        StringBuilder rawHtml = new StringBuilder();

        try {
            URL site = new URL(url);

            try(BufferedReader bf = new BufferedReader(new InputStreamReader(site.openStream()))) {
                String input = "";

                while((input = bf.readLine()) != null) {
                    rawHtml.append(input);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rawHtml.toString();
    }

    private Matcher getMatcherFor(String regex, String content) {
        return Pattern.compile(regex).matcher(content);
    }
}
