package org.example;

import java.util.Scanner;

public class GameBoard {
    public int width;
    public int height;
    public char[][] board;
    public int[] playerPos = new int[2];

    public GameBoard(int width, int height) {
        this.width = width;
        this.height = height;
        board = new char[height][width];

        // Set the walls
        for (int i = 0; i < width; i++) {
            board[0][i] = '#';
            board[height - 1][i] = '#';
        }

        for (int i = 0; i < height; i++) {
            board[i][0] = '#';
            board[i][width - 1] = '#';
        }

        // Set the initial position of the player
        playerPos[0] = 1;
        playerPos[1] = 1;
        board[1][1] = 'X';
    }

    public void move(char direction) {
        int x = playerPos[0];
        int y = playerPos[1];
        switch (direction) {
            case 'W':
                if (board[x-1][y] != '#') x--;
                break;
            case 'S':
                if (board[x+1][y] != '#') x++;
                break;
            case 'A':
                if (board[x][y-1] != '#') y--;
                break;
            case 'D':
                if (board[x][y+1] != '#') y++;
                break;
        }

        // Update the board and player position
        board[playerPos[0]][playerPos[1]] = ' ';
        board[x][y] = 'X';
        playerPos[0] = x;
        playerPos[1] = y;
    }

    public void display() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        GameBoard game = new GameBoard(5, 5);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            game.display();
            System.out.println("Move (W/A/S/D) or 'exit' to quit: ");
            String input = scanner.nextLine().toUpperCase();

            if ("EXIT".equals(input)) {
                break;
            } else if ("WASD".contains(input) && input.length() == 1) {
                game.move(input.charAt(0));
            } else {
                System.out.println("Invalid input. Please enter W, A, S, D or 'exit'.");
            }
        }
        scanner.close();
    }
}
