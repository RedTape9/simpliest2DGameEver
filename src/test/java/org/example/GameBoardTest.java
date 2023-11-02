package org.example;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

class GameBoardTests {
    @Test
    void testMoveUpAgainstWall() {
        GameBoard game = new GameBoard(5, 5);
        int[] initialPosition = Arrays.copyOf(game.playerPos, 2);
        game.move('W');
        assert Arrays.equals(game.playerPos, initialPosition) : "Failed: testMoveUpAgainstWall";
    }
    @Test
    void testMoveRightToEdge() {
        GameBoard game = new GameBoard(5, 5);
        for (int i = 0; i < game.width - 2; i++) {
            game.move('D');
        }
        int[] expectedPos = {1, game.width - 2};
        assert Arrays.equals(game.playerPos, expectedPos) : "Failed: testMoveRightToEdge";
    }

    @Test
    void testMoveDownToEdge() {
        GameBoard game = new GameBoard(5, 5);
        for (int i = 0; i < game.height - 2; i++) {
            game.move('S');
        }
        int[] expectedPos = {game.height - 2, 1};
        assert Arrays.equals(game.playerPos, expectedPos) : "Failed: testMoveDownToEdge";
    }

    @Test
    void testMoveLeftAgainstWall() {
        GameBoard game = new GameBoard(5, 5);
        int[] initialPosition = Arrays.copyOf(game.playerPos, 2);
        game.move('A');
        assert Arrays.equals(game.playerPos, initialPosition) : "Failed: testMoveLeftAgainstWall";
    }


}