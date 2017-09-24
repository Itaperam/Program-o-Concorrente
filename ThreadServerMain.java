import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

class ThreadServerMain {
    public static void main(String[] args) throws IOException {

        ServerSocket s = new ServerSocket(4444);

        while(true){
            Socket ns = s.accept();
            new Thread(new ProtocolServerThread(ns)).start();
        }
        //s.close();
    }
}
