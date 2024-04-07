import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HttpResponse {
    private OutputStream output;
    public HttpResponse(Socket socket) {
        try {
            output = socket.getOutputStream();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void ok(String message){
        try {
            output.write(("HTTP/1.0 200 " + message + " \n ").getBytes());
            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void notFound(String message){
        try {
            output.write(("HTTP/1.0 404 " + message + " \n ").getBytes());

            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void sendContent(String contentType, String content){
        try {
            output.write(("Content-Type: " + contentType + "\n").getBytes());
            output.write(("Content-Length: " + content.length() + "\n").getBytes());
            output.write(("\n" + content).getBytes());
            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void sendFile(String contentType, String filename){

        try {
            File file = new File(filename);
            FileInputStream input = new FileInputStream(filename);
            byte[] bytes = new byte[4096];
            int bytesRead = 0;
            output.write(("Content-Type: " + contentType + "\n").getBytes());
            output.write(("Content-Length: " + file.length() + "\n").getBytes());
            output.write(("\n").getBytes());
            do {
                bytesRead = input.read(bytes);
                if (bytesRead > 0) {
                    output.write(bytes, 0, bytesRead);
                }
            } while (bytesRead == 4096);
            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
