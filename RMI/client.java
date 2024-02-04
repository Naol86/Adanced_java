package RMI;

import java.rmi.Naming;
import java.rmi.RMISecurityManager;

public class client {
    public static void main(String[] args) {
        System.setSecurityManager(new RMISecurityManager());
        try {
            String url = "rmi://localhost/test-server";
            serverInterface remoteObject = (serverInterface)Naming.lookup(url);
            System.out.println("got remote object");
            System.out.println("1 + 2 is " + remoteObject.sum(1, 2));
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
