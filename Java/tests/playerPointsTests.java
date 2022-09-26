import javafx.beans.property.IntegerProperty;
import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import sample.Main;
import sample.Tank;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class playerPointsTests {

    @Test
    public void shotLeftBulletsTest_correctResult() {

        //given
        IntegerProperty intEx = Main.getShotBulletsP1();
        intEx.set(intEx.get() + 2);

        //when
        Main.setShotBulletsP1();
        Main.setShotBulletsP1();

        //then
        assertEquals(intEx, Main.getShotBulletsP1());

    }

    @Test
    public void shotRightBulletsTest_correctResult() {

        //given
        IntegerProperty intEx = Main.getShotBulletsP2();
        intEx.set(intEx.get() + 5);

        //when
        Main.setShotBulletsP2();
        Main.setShotBulletsP2();
        Main.setShotBulletsP2();
        Main.setShotBulletsP2();
        Main.setShotBulletsP2();

        //then
        assertEquals(intEx, Main.getShotBulletsP2());


    }

    @Test
    public void setLeftPlayerPoints_correctResult() {

        //given
        Tank tank = new Tank(50, 300, 100, 100, Color.RED, true);
        int currPoints = tank.getPlayerPoints();
        int exPoints = currPoints + 15;

        //when
        for (int i = 0; i < 15; i++) tank.setPlayerPoints(tank.getPlayerPoints() + 1);

        //then
        assertEquals(exPoints, tank.getPlayerPoints());

    }

    @Test
    public void setRightPlayerPoints_correctResult() {

        //given
        Tank tank = new Tank(50, 300, 100, 100, Color.RED, false);
        int currPoints = tank.getPlayerPoints();
        int exPoints = currPoints + 246;

        //when
        for (int i = 0; i < 123; i++) tank.setPlayerPoints(tank.getPlayerPoints() + 2);

        //then
        assertEquals(exPoints, tank.getPlayerPoints());

    }

}
