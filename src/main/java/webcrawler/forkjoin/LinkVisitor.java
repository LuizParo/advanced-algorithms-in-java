package webcrawler.forkjoin;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkVisitor extends RecursiveAction {
    private static final long serialVersionUID = 1L;
    private WebLink webLink;
    
    public LinkVisitor(WebLink webLink) {
        this.webLink = webLink;
    }

    @Override
    public void compute() {
        if(!this.webLink.isVisited()) {
            List<WebLink> cacheForLinks = new ArrayList<>();
            List<LinkVisitor> newLinkVisitors = new ArrayList<>();
            
            String currentUrl = this.webLink.getUrl();
            
            String rawHtml = this.extractHtmlFrom(currentUrl);
            Matcher matcher = this.getMatcherFor("http://(\\w+\\.)*(\\w+)", rawHtml);
            
            while(matcher.find()) {
                String url = matcher.group();
                WebLink newLink = new WebLink(url.trim());
                
                if(!newLink.isVisited() && !cacheForLinks.contains(newLink)) {
                    newLinkVisitors.add(new LinkVisitor(newLink));
                    cacheForLinks.add(newLink);
                    System.out.println("Website has been found with URL: " + url);
                }
            }
            
            this.webLink.markVisited();
            invokeAll(newLinkVisitors);
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
            System.err.println(e.getMessage()); // NEVER do this in real life!!!!!
        }

        return rawHtml.toString();
    }

    private Matcher getMatcherFor(String regex, String content) {
        return Pattern.compile(regex).matcher(content);
    }
}