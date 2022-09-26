package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Timer;
import java.util.TimerTask;

public class Bullet extends Circle {

    private static final double bulletRadius = GameSetup.getBulletRadius();
    private double bulletSpeed = GameSetup.getBulletSpeed();
    private double currentBulletRadius;
    private double bulletAcceleration = GameSetup.getBulletAcceleration();
    private double bulletRadiusDowngrade = GameSetup.getBulletRadiusChange();
    private final Timer timer;
    public boolean isDestroyed;
    public boolean leftPlayersBullet;

    public Bullet(double x, double y, boolean left) {
        super(x, y, bulletRadius, Color.GRAY);
        this.currentBulletRadius = bulletRadius;
        leftPlayersBullet = left;
        this.setStrokeWidth(4);
        if (leftPlayersBullet)
            this.setStroke(Color.RED);
        else
            this.setStroke(Color.GREEN);

        if (this.bulletSpeed < 1)
            this.bulletSpeed = 1;
        else if (this.bulletSpeed > 50)
            this.bulletSpeed = 50;

        if (this.bulletAcceleration < 0)
            this.bulletAcceleration = 0;
        else if (this.bulletAcceleration > 10)
            this.bulletAcceleration = 10;

        if (this.bulletRadiusDowngrade < 0)
            this.bulletRadiusDowngrade = 0;
        else if (this.bulletRadiusDowngrade > 2)
            this.bulletRadiusDowngrade = 2;


        timer = new Timer();
        TimerTask task = new TimerTask() {

            public void run() {

                try {

                    if (!isDestroyed) {
                        changeBulletSpeed();
                        changeRadius();
                    } else {
                        timer.cancel();
                    }

                } catch (Exception e) {
                    timer.cancel();
                    System.out.println("TIMER PROBLEM");
                }


            }
        };

        double timeUnit = GameSetup.getTimeUnit();
        int period = (int) (timeUnit * 1000);

        timer.scheduleAtFixedRate(task, period, period);

    }

    public void leftBulletMovement() {
        if (!isDestroyed)
            this.setCenterX(this.getCenterX() + bulletSpeed);
    }

    public void rightBulletMovement() {
        if (!isDestroyed)
            this.setCenterX(this.getCenterX() - bulletSpeed);
    }

    public void changeBulletSpeed() {

        this.bulletSpeed += bulletAcceleration;
    }

    public void changeRadius() {


        if (this.currentBulletRadius > 0 + bulletRadiusDowngrade) {
            this.currentBulletRadius -= bulletRadiusDowngrade;
            try {
                this.setRadius(this.getRadius() - bulletRadiusDowngrade);
            } catch (Exception e) {
                System.out.println("CHANGE RADIUS ERROR");
            }
        }


    }

}
