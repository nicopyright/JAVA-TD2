import java.net.Socket;

public class RequestProcessor {
    private HttpContext context;
    private void process(){
        if(context.getRequest().getUrl().equals("/")){
            context.getResponse().ok("OK");
            context.getResponse().sendContent("text/html", "<body><strong> Hello World !</strong></body>");
        }
        else{
            context.getResponse().notFound("Not Found");
        }
        context.close();


    }
    public RequestProcessor(Socket socket) {
        context = new HttpContext(socket);
        process();
    }
}
