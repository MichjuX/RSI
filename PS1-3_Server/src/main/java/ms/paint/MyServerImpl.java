package ms.paint;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    int i = 0;

    protected MyServerImpl() throws RemoteException {
        super();
    }

    @Override
    public Double add(Double a, Double b) throws RemoteException {
        return a + b;
    }
//    @Override
//    public Double subtract(Double a, Double b) throws RemoteException {
//        return a - b;
//    }
//    @Override
//    public Double multiply(Double a, Double b) throws RemoteException {
//        return a * b;
//    }
//    @Override
//    public Double divide(Double a, Double b) throws RemoteException {
//        if (b!=0) return 0.0;
//        else return a/b;
//    }

}
