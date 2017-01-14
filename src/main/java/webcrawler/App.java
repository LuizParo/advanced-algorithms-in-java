package webcrawler;

public class App {
    public static void main(String[] args) {
        WebCrawler crawler = new WebCrawler();
        crawler.discoverWeb("http://www.bbc.com");
    }
}