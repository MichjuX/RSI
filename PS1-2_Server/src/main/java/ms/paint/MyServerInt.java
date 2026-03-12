package ms.paint;
import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyServerInt extends Remote{
    Double add(Double a, Double b) throws RemoteException;
    Double subtract(Double a, Double b) throws RemoteException;
    Double multiply(Double a, Double b) throws RemoteException;
    Double divide(Double a, Double b) throws RemoteException;
}