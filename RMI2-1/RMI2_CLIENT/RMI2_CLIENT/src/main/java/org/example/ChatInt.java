package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatInt extends Remote {
    void send(String msg) throws RemoteException;
    void setClient(ChatInt c) throws RemoteException;
    ChatInt getClient() throws RemoteException;
    String getName() throws RemoteException;
}