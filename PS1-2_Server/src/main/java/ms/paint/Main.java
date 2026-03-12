package ms.paint;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Main {
    public static void main(String[] args) {
        try {
//            System.setProperty("java.security.policy", "security.policy");
//            if (System.getSecurityManager() == null) {
//                System.setSecurityManager(new SecurityManager());
//            }
//System.setProperty("java.rmi.server.codebase","file:/C:/Users/Jacek/workspace/
//            RMIServer/bin/");
            System.setProperty("java.rmi.server.codebase","file:/C:/Users/mks20/Desktop/Studia/RMI/PS1/target/classes");
            System.out.println("Codebase: " + System.getProperty("java.rmi.server.codebase"));
            LocateRegistry.createRegistry(1099);
            MyServerImpl obj1 = new MyServerImpl();
            Naming.rebind("//localhost/ABC", obj1);
            System.out.println("Serwer oczekuje ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}