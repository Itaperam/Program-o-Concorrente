// Servidor Iterativo - Atende inúmeros clientes e continua ativo um por vez
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;
class ProtocolServerItrv {
    public static void main(String[] args) throws IOException{

        // Socket servidor
        ServerSocket s = new ServerSocket(4444);

        while(true){
            // Canais de entrada e saída
            Socket ns = s.accept();
            DataInputStream in = new DataInputStream(ns.getInputStream());
            DataOutputStream out = new DataOutputStream(ns.getOutputStream());

            while(true){
                String fromClient = in.readUTF();
                out.writeUTF(Protocol.processLine(fromClient));

                System.out.println("From Cliente: " + fromClient);

                if(fromClient.equals("bye")){
                    break;
                }

            }
            in.close();
            out.close();
            ns.close();
      }
       //s.close();
   }

}
