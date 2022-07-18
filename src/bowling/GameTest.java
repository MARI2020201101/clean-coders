package bowling;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTest {
    private Game game;
    private void rollMany(int pins, int frames) {
        for (int i = 0; i < frames; i++) game.roll(pins);
    }
    private void rollSpare() {
        game.roll(5);
        game.roll(5);
    }
    private void rollStrike() {
        game.roll(10);
    }
    @BeforeEach
    public void canCreate(){
        game = new Game();
    }
    @Test
    public void canRoll(){
        game.roll(0);
    }
    @Test
    public void gutterGame(){
        rollMany(0, 20);
        assertEquals(game.getScore(), 0);
    }
    @Test
    public void allOnes(){
        rollMany(1, 20);
        assertEquals(game.getScore(), 20);
    }

    @Test
    public void oneSpare(){
        rollSpare(); //13점
        game.roll(3);
        rollMany(17,0);
        assertEquals(game.getScore(), 16);
    }

    @Test
    public void oneStrike(){
        rollStrike();
        game.roll(5);
        game.roll(3);
        rollMany(16,0);
        assertEquals(game.getScore(), 26);
    }

    @Test
    public void perfectGame(){
        rollMany(10,12);
        assertEquals(game.getScore(), 300);
    }

}
