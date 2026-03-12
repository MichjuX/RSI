package ms.paint;

import java.rmi.Naming;
public class Main {
    public static void main(String[] args) {
        System.setProperty("java.security.policy", "security.policy");
//        System.setSecurityManager(new SecurityManager());
        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//localhost/ABC");
            String text = "Hallo :-)";

            System.out.println(myRemoteObject.add(2.0,2.0));
            System.out.println(myRemoteObject.subtract(2.0,2.0));
            System.out.println(myRemoteObject.multiply(2.0,2.0));
            System.out.println(myRemoteObject.divide(2.0,2.0));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}