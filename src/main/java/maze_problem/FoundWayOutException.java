package maze_problem;

public class FoundWayOutException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public FoundWayOutException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}