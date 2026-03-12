package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TickTockInt extends Remote {
    boolean makeMove(int row, int col, char player) throws RemoteException;
    char[][] getBoard() throws RemoteException;
    char checkWinner() throws RemoteException;
    char getCurrentTurn() throws RemoteException;
}
