import java.net.Socket;

public class HttpContext {
    private Socket socket;

    public HttpContext(Socket socket) {
        this.socket = socket;
    }

    public HttpRequest getRequest() {
        return null;
    }

    public HttpResponse getResponse() {
        return null;
    }

    public void close() {

    }
}
