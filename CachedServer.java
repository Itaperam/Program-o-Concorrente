import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

class CachedServer {
    public static void main(String[] args) throws IOException{
        Executor exec = Executors.newCachedThreadPool();

        ServerSocket s = new ServerSocket(4444);

        while(true){
            Socket ns = s.accept();
            exec.execute(new ProtocolServerThread(ns));
        }
        //s.close();
    }
}
