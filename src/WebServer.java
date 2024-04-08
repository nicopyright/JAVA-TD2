import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {

    public void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            while (true) {
                Socket socket = serverSocket.accept();
                RequestProcessor requestProcessor = new RequestProcessor(socket);
                Thread thread = new Thread(requestProcessor);
                thread.start();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
