import java.io.BufferedWriter;
import java.net.Socket;
import java.nio.Buffer;

public class HttpResponse {
    private BufferedWriter output;
    public HttpResponse(Socket socket) {

    }
    public void ok(String message) {
    }

    public void notFound(String message) {
    }
}
