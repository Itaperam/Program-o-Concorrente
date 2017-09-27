package urna;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author italo
 */
public class UrnaImpl extends UnicastRemoteObject implements Urna {
    
    

    protected UrnaImpl() throws RemoteException {
        super();
    }
    
    int totalLula = 0;
    int totalBolsonaro = 0;
    
    int brancos = 0;
    int nulos = 0;
    int totalCandidatos = 4;

    private int[] candidato = {13, 40, 27, 90};

    @Override
    public int totalCandidatos() throws RemoteException {
        return totalCandidatos;

    }

    @Override
    public void ComputaVoto(int num) throws RemoteException {
        if (num == 0) {
            brancos++;
        } else if (num == -1) {
            nulos++;
        } else {
            //candidato[num] += 1;
            
            switch(num){
                case 13:
                    totalLula++;
                    break;
                case 666:
                    totalBolsonaro++;
                    break;                   
            }
        }
    }

    @Override
    public String Confirma(int num) throws RemoteException {
        String info;

        switch (num) {
            case -1:
                info = "Voto Nulo";
                break;
            case 0:
                info = "Voto Branco";
                break;
            case 13:
                info = "Votou Lula";
                break;
            case 666:
                info = "Votou Bolsonaro";
                break;    
            default:
                info = "Candidato: " + num;
                break;
        }

        return info;
    }

}
