import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private void readRequest(Socket socket) {

        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String response = "";
            do {
                response = input.readLine();
                System.out.println(response);
            }while (!(response).isEmpty());
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    private void sendResponse(Socket socket) {
        try {
            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            output.write("HTTP/1.0 200 OK \n\n ");

            output.flush();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    public void run(int portNumber) {
        try {
            ServerSocket serverSocket = new ServerSocket(portNumber);
            System.out.println("Starting server on port " + portNumber);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                readRequest(clientSocket);
                sendResponse(clientSocket);
                clientSocket.close();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
