package org.example;

import java.rmi.Naming;
import java.util.Scanner;

public class TickTockClientMain {
    public static void main(String[] args) {
        try {
            TickTockInt game = (TickTockInt) Naming.lookup("//172.20.10.8/ABC");
            Scanner sc = new Scanner(System.in);
            System.out.println("Połączono! Grasz jako O.");

            while (true) {
                printBoard(game.getBoard());
                System.out.println("[KLIENT - O] Twój ruch (wiersz kolumna): ");
                int r = sc.nextInt();
                int c = sc.nextInt();

                if (game.makeMove(r, c, 'O')) {
                    if (game.checkWinner() != ' ') {
                        printBoard(game.getBoard());
                        System.out.println("WYGRAŁEŚ!"); break;
                    }
                } else {
                    System.out.println("Nie Twoja tura lub błędne pole!");
                }
            }
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void printBoard(char[][] b) {
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) System.out.print((b[i][j]==' ' ? '.' : b[i][j]) + " ");
            System.out.println();
        }
    }
}
