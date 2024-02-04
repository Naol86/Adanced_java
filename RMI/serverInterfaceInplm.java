package RMI;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class serverInterfaceInplm  extends UnicastRemoteObject implements serverInterface{
    serverInterfaceInplm() throws RemoteException{
        super();
    }

    public int sum(int a, int b) throws RemoteException {
        return a + b;
    }

    public static void main(String[] args) {
        try {
            System.setSecurityManager(new RMISecurityManager());
            serverInterfaceInplm server = new serverInterfaceInplm();
            Naming.rebind("test-server", server);
    
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}
