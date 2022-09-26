import org.junit.jupiter.api.Test;
import sample.GameSetup;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameSetUpTests {

    @Test
    public void bulletRadius_correctValue() {

        //given
        double check = GameSetup.getBulletRadius();

        //when
        boolean correct = false;
        if (check >= 5 && check <= 30) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void bulletSpeed_correctValue() {

        //given
        double check = GameSetup.getBulletSpeed();

        //when
        boolean correct = false;
        if (check >= 1 && check <= 50) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void bulletAcceleration_correctValue() {

        //given
        double check = GameSetup.getBulletAcceleration();

        //when
        boolean correct = false;
        if (check >= 0 && check <= 10) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void bulletRadiusChange_correctValue() {

        //given
        double check = GameSetup.getBulletRadiusChange();

        //when
        boolean correct = false;
        if (check >= 0 && check <= 2) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void timeUnit_correctValue() {

        //given
        double check = GameSetup.getTimeUnit();

        //when
        boolean correct = false;
        if (check >= 0.05 && check <= 1) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void gameTime_correctValue() {

        //given
        double check = GameSetup.getGameTime();

        //when
        boolean correct = false;
        if (check >= 10 && check <= 180) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void maxShotBullets_correctValue() {

        //given
        double check = GameSetup.getMaxShotBullets();

        //when
        boolean correct = false;
        if (check >= 1 && check <= 20) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void cellSize_correctValue() {

        //given
        double check = GameSetup.getCellSize();

        //when
        boolean correct = false;
        if (check >= 30 && check <= 60) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void cellSizeChange_correctValue() {

        //given
        double check = GameSetup.getCellSizeChange();

        //when
        boolean correct = false;
        if (check >= 0 && check <= 3) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void cellAcceleration_correctValue() {

        //given
        double check = GameSetup.getCellAcceleration();

        //when
        boolean correct = false;
        if (check >= 0 && check <= 10) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void cellFallingSpeed_correctValue() {

        //given
        double check = GameSetup.getCellFallingSpeed();

        //when
        boolean correct = false;
        if (check >= 0 && check <= 10) correct = true;

        //then
        assertEquals(true, correct);

    }

    @Test
    public void durabilityIncreaseTimeUnit_correctValue() {

        //given
        double check = GameSetup.getDurabilityIncreaseTimeUnit();

        //when
        boolean correct = false;
        if (check >= 0 && check <= 10) correct = true;

        //then
        assertEquals(true, correct);

    }

}
