package RMI;

import java.rmi.*;

public interface serverInterface extends Remote {
    public int sum(int a, int b) throws RemoteException;
}
