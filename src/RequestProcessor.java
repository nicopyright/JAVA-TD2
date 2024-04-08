import java.io.File;
import java.net.Socket;

class RequestProcessor implements Runnable{
    private HttpContext context;
    @Override
    public void run(){
        process();
    }
    private void process(){
        System.out.println(context.getRequest().getMethod());
        System.out.println(context.getRequest().getUrl());
        File f = new File((context.getRequest().getUrl().substring(1)));
            if(f.getPath().equals("")){
                context.getResponse().ok("OK");
                //context.getResponse().sendContent("text/html", "<body><strong> Hello World !</strong></body>");
                context.getResponse().sendFile("text/html", "src/public/index.html");
            }
        else if(f.isFile()){
            String[] path = f.getPath().split("\\.");
            String ext = path[path.length-1];
            //System.out.println(ext);

            context.getResponse().ok("OK");
            switch (ext){
                case "html":
                    context.getResponse().sendFile("text/html", f.getPath());
                    break;
                case "css":
                    context.getResponse().sendFile("text/css", f.getPath());
                    break;
                case "png":
                    context.getResponse().sendFile("image/png", f.getPath());
                    break;
                case "jpg":
                    context.getResponse().sendFile("image/jpg", f.getPath());
                    break;
                case "jpeg":
                    context.getResponse().sendFile("image/jpeg", f.getPath());
                    break;
                case "svg":
                    context.getResponse().sendFile("image/svg+xml", f.getPath());
                    break;
                case "webp":
                    context.getResponse().sendFile("image/webp", f.getPath());
                    break;
                case "mp4":
                    context.getResponse().sendFile("video/mp4", f.getPath());
                    break;
                default:
                    context.getResponse().sendContent("text/plain", "File type not supported");
                    break;
            }
        }

        else{
            context.getResponse().notFound("Not Found");
        }
        context.close();


    }
    public RequestProcessor(Socket socket) {
        context = new HttpContext(socket);
    }
}
