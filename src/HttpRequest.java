import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class HttpRequest {
    private String method;
    private String url;
    private void readClientRequest(Socket socket){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = "";
            String response = "";
            do {
                line = input.readLine();
                response += line;
                //System.out.println(response);
            }while (!line.isEmpty());
            String[] request = response.split(" ");
            //System.out.println(request[0]);
            //System.out.println(request[1]);
            this.method = request[0];
            this.url = request[1];


        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    public HttpRequest(Socket socket){
        readClientRequest(socket);
    }
    public String getMethod(){
        return method;
    }
    public String getUrl(){
        return url;
    }
}
