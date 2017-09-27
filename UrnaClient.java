package urna;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author italo
 */
public class UrnaClient {
    
    public static void main(String[] args){
        
        try{
            //Context nameContext = new InitialContext();
           // Registry reg = LocateRegistry.getRegistry("rmi://127.0.0.1:/urna");
            //Urna urna = (Urna) Naming.lookup("rmi://150.165.201.117:1099/urna");
            Scanner entrada = new Scanner(System.in);
            String candidato;
            String confirma;
            
            
            System.setProperty("java.security.policy", "/home/italo/NetBeansProjects/Urna/src/urna/client.policy");
            System.setSecurityManager(new RMISecurityManager());
            Urna urna = (Urna) Naming.lookup("rmi://127.0.0.1/UrnaService");
        
        while (true) {
                System.out.print("Informe o numero do seu Candidato (or 0 for blank vote, -1 for null vote): ");
                System.out.print("Voto Branco[0] ou Voto Nulo[-1]");
                candidato = entrada.nextLine();

                //if (Integer.parseInt(candidato) > urna.totalCandidatos()) {
                   // System.out.print("Candidato Inválido");
                   // continue;
                //}
                // Show candidate info, ask to confirm vote
                System.out.println(urna.Confirma(Integer.parseInt(candidato)));
                System.out.println("Confirm vote? (y/n)");
                confirma = entrada.nextLine();
                

                if (confirma.equals("y")) {
                    //
                    urna.ComputaVoto(Integer.parseInt(candidato));
                    System.out.print("CONFIRMADO ");
                    break;
                } else {
                    System.out.print("Voto Cancelado");
                }
        }   
        
        } catch (Exception e) {
            System.out.println("Failed to connect: " + e.toString());
        }
    }
    
}
