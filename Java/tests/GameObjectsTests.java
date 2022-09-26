import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import sample.Barrel;
import sample.Bomb;
import sample.Tank;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameObjectsTests {

    @Test
    public void bombExplosion_correctBehaviour() {

        //given
        Bomb bomb = new Bomb(true);
        int hits = 20;
        boolean check = false;

        //when
        for (int i = 0; i < hits; i++) {
            if (bomb.getHit()) {
                check = true;
            }
        }

        //then
        assertEquals(true, check);

    }

    @Test
    public void bombDoesNotExplode_correctBehaviour() {

        //given
        Bomb bomb = new Bomb(true);
        int hits = 19;
        boolean check = false;

        //when
        for (int i = 0; i < hits; i++) {
            if (bomb.getHit()) {
                check = true;
            }
        }

        //then
        assertEquals(false, check);

    }

    @Test
    public void leftBarrelRotate_correctBehaviour() {

        //given
        Barrel barrel = new Barrel(50, 300, 100, 100, true);
        double angle1 = 10;
        double angle2 = -20;
        double angle3 = 100;
        double currentAngle = barrel.currentAngle;

        //when
        barrel.leftRotate(angle1);
        barrel.leftRotate(angle2);
        barrel.leftRotate(angle3);
        double expectedAngle = currentAngle + 90;

        //then
        assertEquals(expectedAngle, barrel.currentAngle);

    }

    @Test
    public void rightBarrelRotate_correctBehaviour() {

        //given
        Barrel barrel = new Barrel(50, 300, 100, 100, false);
        double angle1 = 10;
        double angle2 = -20;
        double angle3 = 100;
        double currentAngle = barrel.currentAngle;

        //when
        barrel.rightRotate(angle1);
        barrel.rightRotate(angle2);
        barrel.rightRotate(angle3);
        double expectedAngle = currentAngle + 90;

        //then
        assertEquals(expectedAngle, barrel.currentAngle);

    }

    @Test
    public void tankPositionReset_correctBehaviour() {

        //given
        Tank tank = new Tank(50, 300, 100, 100, Color.RED, false);

        //when
        tank.setStartingPosition();
        double startingPosition = tank.getStartingPosition();

        //then
        assertEquals(300, startingPosition);

    }

}
