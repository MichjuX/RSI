package org.example;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.util.Scanner;

public class TickTockServerMain {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            TickTockImpl game = new TickTockImpl();
            Naming.rebind("//172.20.10.8/ABC", game);

            Scanner sc = new Scanner(System.in);
            System.out.println("Serwer ruszony. Grasz jako X.");

            while (game.checkWinner() == ' ') {
                printBoard(game.getBoard());

                // Pętla oczekiwania na swoją turę
                while (game.getCurrentTurn() != 'X' && game.checkWinner() == ' ') {
                    System.out.println("Czekam na ruch przeciwnika (O)...");
                    Thread.sleep(2000); // Sprawdzaj co 2 sekundy
                    printBoard(game.getBoard());
                }

                if (game.checkWinner() != ' ') break;

                System.out.println("[TWOJA TURA - X] Podaj wiersz i kolumnę (np. 1 1): ");
                int r = sc.nextInt();
                int c = sc.nextInt();

                if (!game.makeMove(r, c, 'X')) {
                    System.out.println("Błąd! Pole zajęte lub zły zakres.");
                }
            }
            System.out.println("KONIEC GRY! Wygrał: " + game.checkWinner());
        } catch (Exception e) { e.printStackTrace(); }
    }

    public static void printBoard(char[][] b) {
        System.out.print("\033[H\033[2J"); //
        System.out.flush();
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) System.out.print((b[i][j] == ' ' ? "." : b[i][j]) + " ");
            System.out.println();
        }
    }
}