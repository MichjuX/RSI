package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Chat extends UnicastRemoteObject implements ChatInt {

    private String name;
    private ChatInt client;

    public Chat(String name) throws RemoteException {
        super();
        this.name = name;
    }

    @Override
    public void send(String msg) throws RemoteException {
        System.out.println(msg);
    }

    @Override
    public void setClient(ChatInt c) throws RemoteException {
        this.client = c;
    }

    @Override
    public ChatInt getClient() throws RemoteException {
        return client;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }
}