package maze_problem;

public class NoSoutionFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NoSoutionFoundException(String message) {
        super(message);
    }
    
    @Override
    public synchronized Throwable fillInStackTrace() {
        return null;
    }
}