package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;

public class Barrel extends Rectangle {

    private final double width;
    private final double height;
    public double currentAngle;
    private final double resetParam;

    public Barrel(double x, double y, double width, double height, boolean left) {
        super(x + width / 2, y + height / 2 - height / 12, width, height / 6);

        if (!left) {
            this.setX(x - width / 2);
            this.setStroke(Color.ORANGE);
        } else this.setStroke(Color.YELLOW);


        this.setFill(Color.BLACK);


        this.width = width;
        this.height = height / 6;
        this.currentAngle = 0;
        this.resetParam = y + height / 2 - height / 12;

    }

    public void leftRotate(double angle) {

        if (currentAngle < 60 && currentAngle > -60 || currentAngle == 60 && angle < 0 || currentAngle == -60 && angle > 0) {
            double xRotate = this.getX();
            double yRotate = this.getY() + this.height / 2;

            Rotate rotate = new Rotate();
            rotate.setAngle(angle);
            rotate.setPivotX(xRotate);
            rotate.setPivotY(yRotate);

            this.getTransforms().add(rotate);
            this.currentAngle = this.currentAngle + angle;
        }

    }

    public void rightRotate(double angle) {

        if (currentAngle < 60 && currentAngle > -60 || currentAngle == 60 && angle < 0 || currentAngle == -60 && angle > 0) {

            double xRotate = this.getX() + this.width;
            double yRotate = this.getY() + this.height / 2;

            Rotate rotate = new Rotate();
            rotate.setAngle(angle);
            rotate.setPivotX(xRotate);
            rotate.setPivotY(yRotate);

            this.getTransforms().add(rotate);
            this.currentAngle = this.currentAngle + angle;
        }

    }

    public void fakeRotate(double angle) {
        double xRotate = this.getX();
        double yRotate = this.getY() + this.height / 2;

        Rotate rotate = new Rotate();
        rotate.setAngle(angle);
        rotate.setPivotX(xRotate);
        rotate.setPivotY(yRotate);
        this.getTransforms().add(rotate);

    }

    public void leftBulletRotate(double angle, Bullet bullet) {
        double xRotate = this.getX();
        double yRotate = this.getY() + 108;

        Rotate rotate = new Rotate();
        rotate.setAngle(angle);
        rotate.setPivotX(xRotate);
        rotate.setPivotY(yRotate);

        bullet.getTransforms().add(rotate);

    }

    public void rightBulletRotate(double angle, Bullet bullet) {
        double xRotate = 1100;
        double yRotate = this.getY() + 108;

        Rotate rotate = new Rotate();
        rotate.setAngle(angle);
        rotate.setPivotX(xRotate);
        rotate.setPivotY(yRotate);

        bullet.getTransforms().add(rotate);

    }

    public void shoot(boolean left) {
        if (left) {
            if (Main.leftTank.getActiveBullets() < Tank.maxActiveBullets) {
                double barrelPositionX = this.getX() + this.width;
                double barrelPositionY = this.getY() + 108;

                Main.setShotBulletsP1();

                Bullet bullet = new Bullet(barrelPositionX, barrelPositionY, true);
                leftBulletRotate(currentAngle, bullet);

                Main.leftTank.setActiveBullets(Main.leftTank.getActiveBullets() + 1);

                Main.root.getChildren().add(bullet);
            }
        } else {
            if (Main.rightTank.getActiveBullets() < Tank.maxActiveBullets) {
                double barrelPositionX = 1000;
                double barrelPositionY = this.getY() + 108;

                Main.setShotBulletsP2();

                Bullet bullet = new Bullet(barrelPositionX, barrelPositionY, false);
                rightBulletRotate(currentAngle, bullet);

                Main.rightTank.setActiveBullets(Main.rightTank.getActiveBullets() + 1);

                Main.root.getChildren().add(bullet);
            }
        }

    }

    public void setStartingPosition(boolean left) {

        double xRotate;
        double yRotate;

        Rotate rotate = new Rotate();

        if (left) {

            xRotate = this.getX();
            yRotate = this.getY() + this.height / 2;
            rotate.setAngle(-this.currentAngle);
        } else {

            xRotate = this.getX() + this.width;
            yRotate = this.getY() + this.height / 2;
            rotate.setAngle(-this.currentAngle);

        }
        this.currentAngle = 0;
        rotate.setPivotX(xRotate);
        rotate.setPivotY(yRotate);
        this.getTransforms().add(rotate);
        this.setY(resetParam);

    }


}
