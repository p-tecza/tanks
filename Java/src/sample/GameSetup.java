package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class GameSetup {

    private static double defaultBulletSpeed;
    private static double maxShotBullets;
    private static double bulletRadius;
    private static double cellFallingSpeed;
    private static double cellSize;
    private static double bulletAcceleration;
    private static double cellAcceleration;
    private static double radiusChange;
    private static double cellSizeChange;
    private static double timeUnit;
    private static double durabilityIncreaseTimeUnit;
    private static double gameTime;

    public static void setSettingsUp() {

        File file = new File(System.getProperty("user.dir") + "\\Java\\gameSetup.txt");

        try (Scanner scanner = new Scanner(file).useLocale(Locale.US)) {


            if (scanner.hasNextDouble()) {
                defaultBulletSpeed = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                maxShotBullets = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                bulletRadius = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                cellFallingSpeed = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                cellSize = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                bulletAcceleration = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                cellAcceleration = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                radiusChange = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                cellSizeChange = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                timeUnit = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                durabilityIncreaseTimeUnit = scanner.nextDouble();
            }
            if (scanner.hasNextDouble()) {
                gameTime = scanner.nextDouble();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static double getBulletRadius() {

        if (bulletRadius < 5)
            bulletRadius = 5;
        else if (bulletRadius > 30)
            bulletRadius = 30;

        return bulletRadius;
    }

    public static double getBulletSpeed() {

        if (defaultBulletSpeed < 1) defaultBulletSpeed = 1;
        else if (defaultBulletSpeed > 50) defaultBulletSpeed = 50;

        return defaultBulletSpeed;

    }

    public static double getBulletAcceleration() {

        if (bulletAcceleration < 0) bulletAcceleration = 0;
        else if (bulletAcceleration > 10) bulletAcceleration = 10;

        return bulletAcceleration;

    }

    public static double getBulletRadiusChange() {

        if (radiusChange < 0) radiusChange = 0;
        else if (radiusChange > 2) radiusChange = 2;

        return radiusChange;

    }

    public static double getTimeUnit() {

        if (timeUnit < 0.05) timeUnit = 0.05;
        else if (timeUnit > 1) timeUnit = 1;

        return timeUnit;


    }

    public static int getGameTime() {

        if (gameTime < 10) gameTime = 10;
        else if (gameTime > 300) gameTime = 300;


        return (int) gameTime;
    }

    public static int getMaxShotBullets() {

        if (maxShotBullets < 1) maxShotBullets = 1;
        else if (maxShotBullets > 20) maxShotBullets = 20;

        return (int) maxShotBullets;

    }

    public static double getCellSize() {

        if (cellSize < 30) cellSize = 30;
        else if (cellSize > 60) cellSize = 60;

        return cellSize;

    }

    public static double getCellSizeChange() {

        if (cellSizeChange < 0) cellSizeChange = 0;
        else if (cellSizeChange > 3) cellSizeChange = 3;

        return cellSizeChange;

    }

    public static double getCellAcceleration() {

        if (cellAcceleration < 0) cellAcceleration = 0;
        else if (cellAcceleration > 10) cellAcceleration = 10;

        return cellAcceleration;

    }

    public static double getCellFallingSpeed() {

        if (cellFallingSpeed < 0) cellFallingSpeed = 0;
        else if (cellFallingSpeed > 10) cellFallingSpeed = 10;

        return cellFallingSpeed;

    }

    public static double getDurabilityIncreaseTimeUnit() {

        if (durabilityIncreaseTimeUnit < 0) durabilityIncreaseTimeUnit = 0;
        else if (durabilityIncreaseTimeUnit > 10) durabilityIncreaseTimeUnit = 10;

        return durabilityIncreaseTimeUnit;

    }

}
