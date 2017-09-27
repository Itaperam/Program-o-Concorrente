package urna;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author italo
 */
public interface Urna extends Remote{
    
    public int totalCandidatos() throws RemoteException;
    public  void ComputaVoto(int n) throws RemoteException;
    public String Confirma(int n) throws RemoteException; 
    
}
