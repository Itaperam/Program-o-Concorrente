import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;

import java.net.Socket;

class ProtocolServerThread implements Runnable{

    Socket s;

    public ProtocolServerThread(Socket ns){
        s = ns;
    }

    public void run(){
        try {
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

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
            s.close();
        }catch (Exception e) {

        }
    }

}
