package urna;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author italo
 */
public class UrnaServer {
    
    public UrnaServer(){
        try {
            //Urna urna = new UrnaImpl("Votem seus Mizera!");
            //Naming.rebind("rmi://150.165.201.117:1099/urna", urna);
            //System.out.println("Vai votar não!?");
            
            System.setProperty("java.rmi.server.hostname", "127.0.0.1");
            LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
            Registry registry = LocateRegistry.getRegistry();
            Urna urna = new UrnaImpl();
            Naming.bind("UrnaService", (Remote) urna);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new UrnaServer();
    }
}
