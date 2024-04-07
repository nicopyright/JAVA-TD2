import java.net.Socket;

public class HttpContext {
    private Socket socket;
    private HttpRequest request;
    private HttpResponse response;
    public HttpContext(Socket socket) {
        this.socket = socket;
        request = new HttpRequest(socket);
        response = new HttpResponse(socket);
    }

    public HttpRequest getRequest() {
        return request;
    }

    public HttpResponse getResponse() {
        return response;
    }

    public void close() {
        try {
            socket.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
