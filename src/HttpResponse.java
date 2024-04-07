import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpResponse {
    private BufferedWriter output;
    public HttpResponse(Socket socket) {
        try {
            output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void ok(String message){
        try {
            output.write("HTTP/1.0 200 " + message + " \n ");
            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void notFound(String message){
        try {
            output.write("HTTP/1.0 404 " + message + " \n ");

            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void sendContent(String contentType, String content){
        try {
            output.write("Content-Type: " + contentType + "\n");
            output.write("Content-Length: " + content.length() + "\n");
            output.write("\n" + content);
            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
