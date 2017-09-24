// Servidor atende um cliente e morre
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;

public class ProtocolServer {
   public static void main(String[] args) throws IOException{

       ServerSocket s = new ServerSocket(4444);
       Socket ns = s.accept();

       DataInputStream in = new DataInputStream(ns.getInputStream());
       DataOutputStream out = new DataOutputStream(ns.getOutputStream());
       String fromClient;

       while (true) {
          fromClient = in.readUTF();
          out.writeUTF(Protocol.processLine(fromClient));

          System.out.println("From Client: " + fromClient);

          if (fromClient.equals("bye")) {
              break;
          }
      }
      in.close();
      out.close();
      ns.close();
      s.close();
    }
}
