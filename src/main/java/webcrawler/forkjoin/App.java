package webcrawler.forkjoin;

public class App {

    public static void main(String[] args) {
        WebLink webLink = new WebLink("http://www.google.com");
        webLink.startCrawling();
    }
}