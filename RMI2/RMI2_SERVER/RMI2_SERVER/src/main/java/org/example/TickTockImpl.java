package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class TickTockImpl extends UnicastRemoteObject implements TickTockInt {
    private char[][] board = new char[3][3];
    private char currentTurn = 'X';

    protected TickTockImpl() throws RemoteException {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) board[i][j] = ' ';
    }

    @Override
    public synchronized boolean makeMove(int row, int col, char player) throws RemoteException {
        if (player != currentTurn) return false;
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != ' ') return false;

        board[row][col] = player;
        currentTurn = (currentTurn == 'X') ? 'O' : 'X'; // Zmiana tury
        return true;
    }

    @Override
    public char[][] getBoard() throws RemoteException {
        return board;
    }

    @Override
    public char checkWinner() throws RemoteException {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) return board[i][0];
            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) return board[0][i];
        }
        if (board[1][1] != ' ') {
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) return board[1][1];
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) return board[1][1];
        }
        return ' ';
    }

    @Override
    public char getCurrentTurn() throws RemoteException {
        return currentTurn;
    }
}
