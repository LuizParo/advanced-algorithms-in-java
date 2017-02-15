package webcrawler.forkjoin;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;

public final class WebLink {
    private static final Collection<WebLink> VISITED_LINKS = Collections.synchronizedSet(new HashSet<>());
    private final String url;
    private ForkJoinPool forkJoinPool;
    
    public WebLink(String url) {
        this.url = url;
        this.forkJoinPool = new ForkJoinPool();
    }
    
    public void startCrawling() {
        this.forkJoinPool.invoke(new LinkVisitor(this));
    }
    
    public String getUrl() {
        return url;
    }
    
    public boolean isVisited() {
        return VISITED_LINKS.contains(this);
    }
    
    public void markVisited() {
        VISITED_LINKS.add(this);
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof WebLink))
            return false;
        WebLink other = (WebLink) obj;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return this.url;
    }
}