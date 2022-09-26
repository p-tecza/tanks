package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import static sample.PanePreparer.*;

public class Main extends Application {

    private static BorderPane mainPane;
    private static Pane leftPlayerPane;
    private static Pane rightPlayerPane;
    private static Pane gamePane;
    private static GridPane scoresPane;
    private static Pane bottomPane;
    private static BorderPane p1PointsPane;
    private static BorderPane p1BulletPane;
    private static BorderPane p2PointsPane;
    private static BorderPane p2BulletPane;
    private static BorderPane timePane;
    private static Integer TIME;
    private static IntegerProperty timeInSeconds;
    private static final IntegerProperty p1PointsInt = new SimpleIntegerProperty(0);
    private static final IntegerProperty p1ShotBulletsInt = new SimpleIntegerProperty(0);
    private static final IntegerProperty p2PointsInt = new SimpleIntegerProperty(0);
    private static final IntegerProperty p2ShotBulletsInt = new SimpleIntegerProperty(0);
    private static Label timeLabel;
    private static Label p1PointsLabel;
    private static Label p1ShotBulletsLabel;
    private static Label p2PointsLabel;
    private static Label p2ShotBulletsLabel;
    public static Group root;
    private static Group menuRoot;
    private static Group optionsRoot;
    private static Timeline timeline;
    public static Tank leftTank;
    public static Tank rightTank;
    public static Circle circle;
    private Bomb bombCell;
    private static ArrayList<Circle> circleCol;
    private static ArrayList<Cell> cellCol;
    private double t;
    private static Label notificationsLabel;
    private final StringProperty notifications = new SimpleStringProperty();
    private final double cellSpeed = GameSetup.getCellFallingSpeed();
    private Rectangle leftWallBomb;
    private Rectangle rightWallBomb;
    private Rectangle upWallBomb;
    private Bomb bombGraphic;
    private Rectangle rightWallBombGraphic;
    private Rectangle leftWallBombGraphic;
    private Rectangle upWallBombGraphic;
    private static BorderPane mainMenuPane;
    private static Pane mainButtonPane;
    private static Button startButton;
    private static Button optionsButton;
    private static Pane optionsMainPane;
    private static Pane optionsPane;
    public boolean doesGameStart=false;
    public AnimationTimer timer;
    private static Pane firstPane;
    private static Pane secondPane;
    private static Pane thirdPane;
    private static Pane fourthPane;
    private static Pane fifthPane;
    private static Pane sixthPane;
    private static Pane seventhPane;
    private static Pane eighthPane;
    private static Pane ninthPane;
    private static Pane tenthPane;
    private static Pane eleventhPane;
    private static Pane twelfthPane;
    private static Label p1PointsTextLabel;
    private static Label p2PointsTextLabel;
    private static Label p1ShotBulletsTextLabel;
    private static Label p2ShotBulletsTextLabel;
    private static Label timerTextLabel;
    private static TextArea bulletSpeedTextArea;
    private static TextArea maxActiveBulletsTextArea;
    private static TextArea cellTextAreaSpeed;
    private static TextArea cellTextAreaSize;
    private static TextArea bulletAccTextArea;
    private static TextArea cellAccTextArea;
    private static TextArea radiusChangeTextArea;
    private static TextArea cellSizeChangeTextArea;
    private static TextArea timeUnitTextArea;
    private static TextArea cellUpgradeTextArea;
    private static TextArea gameTimeTextArea;
    private static TextArea bulletRadiusTextArea;
    private Stage passStage;
    private Scene passScene;

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setOnCloseRequest(t -> {
            Platform.exit();
            System.exit(0);
        });


        Image icon=new Image("tank.png");

        primaryStage.getIcons().add(icon);

        circleCol = new ArrayList<Circle>();
        cellCol = new ArrayList<Cell>();


        root = new Group();
        menuRoot= new Group();
        optionsRoot= new Group();

        Scene scene = new Scene(root);
        Scene mainMenuScene=new Scene(menuRoot);
        Scene optionsScene= new Scene(optionsRoot);

        passScene=mainMenuScene;
        passStage=primaryStage;

        GameSetup.setSettingsUp();

        TIME = GameSetup.getGameTime();
        timeInSeconds = new SimpleIntegerProperty(TIME);

        leftTank = new Tank(50, 300, 100, 100, Color.RED, true);
        rightTank = new Tank(50, 300, 100, 100, Color.GREEN, false);
        bombCell=new Bomb();
        leftWallBomb=Bomb.addLeftBombWall();
        rightWallBomb=Bomb.addRightBombWall();
        upWallBomb=Bomb.addUpBombWall();


        /*MAIN MENU*/

        VBox menuVBox =new VBox();
        mainMenuPane=prepareBorderPane(1200, 900);
        Text text = new Text();
        text.setStyle("-fx-font-size: 100; -fx-fill: white;-fx-font-family: \"Serif\";");
        text.setText("Main Menu");
        menuVBox.getChildren().add(text);
        menuVBox.setAlignment(Pos.CENTER);
        menuVBox.setLayoutX(600);
        menuVBox.setLayoutY(100);
        menuVBox.setPrefWidth(200);
        menuVBox.setPrefHeight(100);

        mainMenuPane.setStyle("-fx-background-color:#444444;-fx-border-color: gray ;-fx-border-width: 1 ;");
        mainMenuPane.getChildren().add(menuVBox);


        mainButtonPane=preparePane(800,400);
        mainButtonPane.setStyle("-fx-background-color:#111111;-fx-border-color: white ;-fx-border-width: 1 ;");
        mainButtonPane.setMaxSize(800,400);

        startButton=new Button("GRAJ");
        startButton.setPrefSize(400,80);
        startButton.setStyle("-fx-fill: white;-fx-font-family: \"Serif\";-fx-font-size: 35;");
        startButton.setLayoutX(200);
        startButton.setLayoutY(80);
        mainButtonPane.getChildren().add(startButton);

        optionsButton=new Button("OPCJE");
        optionsButton.setPrefSize(400,80);
        optionsButton.setStyle("-fx-fill: white;-fx-font-family: \"Serif\";-fx-font-size: 35;");
        optionsButton.setLayoutX(200);
        optionsButton.setLayoutY(240);
        mainButtonPane.getChildren().add(optionsButton);


        mainMenuPane.setCenter(mainButtonPane);

        menuRoot.getChildren().add(mainMenuPane);



        startButton.setOnAction(e->{

            doesGameStart=true;

           primaryStage.setScene(scene);

            timer = new AnimationTimer() {

                @Override
                public void handle(long l) {
                    try {
                        update();
                    } catch (Exception e) {
                        System.out.println("UPDATE PROBLEM");
                    }
                }

            };

        timer.start();

            TIME = GameSetup.getGameTime();
            timeInSeconds = new SimpleIntegerProperty(TIME);
            timeLabel = prepareLabel(timeInSeconds);

            timeline = new Timeline();
            timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(TIME + 1), new KeyValue(timeInSeconds, 0)));
            timeline.setOnFinished((event) -> {

               popUp(passStage,passScene);

            });
            timeline.playFromStart();
            timePane.setCenter(timeLabel);


        });


        Button acceptButton=new Button("Zatwierdź");
        Button backToMenuButton=new Button("Powrót");

        acceptButton.setMinSize(100,50);
        acceptButton.setLayoutX(800);
        acceptButton.setLayoutY(50);
        acceptButton.setStyle("-fx-background-color:#000000;-fx-text-fill:white;-fx-font-weight:bold;");

        backToMenuButton.setMinSize(100,50);
        backToMenuButton.setLayoutX(400);
        backToMenuButton.setLayoutY(50);
        backToMenuButton.setStyle("-fx-background-color:#000000;-fx-text-fill:white;-fx-font-weight:bold;");

        VBox optionsVBox =new VBox();
        HBox buttonHBox=new HBox();
        optionsMainPane=prepareBorderPane(1200, 900);
        Text textOptions = new Text();
        textOptions.setStyle("-fx-font-size: 100; -fx-fill: white;-fx-font-family: \"Serif\";");
        textOptions.setText("Opcje");
        optionsVBox.getChildren().add(textOptions);
        optionsVBox.setSpacing(10);
        buttonHBox.getChildren().add(backToMenuButton);
        buttonHBox.getChildren().add(acceptButton);
        buttonHBox.setSpacing(200);
        optionsVBox.getChildren().add(buttonHBox);
        optionsVBox.setAlignment(Pos.CENTER);
        optionsVBox.setLayoutX(600);
        optionsVBox.setLayoutY(100);
        optionsVBox.setPrefWidth(1200);
        optionsVBox.setPrefHeight(100);

        optionsMainPane.getChildren().add(optionsVBox);
        optionsMainPane.setStyle("-fx-background-color:#444444;-fx-border-color: white ;-fx-border-width: 1 ;");

        optionsPane=preparePane(1000,700);
        optionsPane.setStyle("-fx-background-color:#222222;-fx-border-color: white ;-fx-border-width: 1 ;");
        optionsPane.setLayoutY(200);
        optionsPane.setLayoutX(100);
        optionsPane.setMinHeight(700);
        optionsPane.setMinWidth(1000);

        Text bulletSpeedText=new Text();
        bulletSpeedText.setText("Predkosc pocisku (1-50) ["+GameSetup.getBulletSpeed()+"]:");
        bulletSpeedText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        bulletSpeedText.setX(10);
        bulletSpeedText.setY(34);


        bulletSpeedTextArea=new TextArea();
        bulletSpeedTextArea.setPrefRowCount(1);
        bulletSpeedTextArea.setPrefColumnCount(5);
        bulletSpeedTextArea.setLayoutX(800);
        bulletSpeedTextArea.setLayoutY(10);

        firstPane=new Pane();
        firstPane.setPrefSize(1000,58);
        firstPane.setStyle("-fx-background-color:#000000;");
        firstPane.setLayoutY(0);
        firstPane.setLayoutX(0);
        firstPane.getChildren().add(bulletSpeedText);
        firstPane.getChildren().add(bulletSpeedTextArea);

        Text maxActiveBullets=new Text();
        maxActiveBullets.setText("Maksymalna ilość aktywnych pocisków (1-20) ["+GameSetup.getMaxShotBullets()+"]:");
        maxActiveBullets.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        maxActiveBullets.setX(10);
        maxActiveBullets.setY(34);

        maxActiveBulletsTextArea=new TextArea();
        maxActiveBulletsTextArea.setPrefRowCount(1);
        maxActiveBulletsTextArea.setPrefColumnCount(5);
        maxActiveBulletsTextArea.setLayoutX(800);
        maxActiveBulletsTextArea.setLayoutY(10);

        secondPane=new Pane();
        secondPane.setPrefSize(1000,58);
        secondPane.setStyle("-fx-background-color:#111111;");
        secondPane.setLayoutY(58);
        secondPane.setLayoutX(0);
        secondPane.getChildren().add(maxActiveBullets);
        secondPane.getChildren().add(maxActiveBulletsTextArea);

        Text bulletRadius=new Text();
        bulletRadius.setText("Średnica pocisku (5-30) ["+GameSetup.getBulletRadius()+"]:");
        bulletRadius.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        bulletRadius.setX(10);
        bulletRadius.setY(34);

        bulletRadiusTextArea=new TextArea();
        bulletRadiusTextArea.setPrefRowCount(1);
        bulletRadiusTextArea.setPrefColumnCount(5);
        bulletRadiusTextArea.setLayoutX(800);
        bulletRadiusTextArea.setLayoutY(10);

        thirdPane=new Pane();
        thirdPane.setPrefSize(1000,58);
        thirdPane.setStyle("-fx-background-color:#222222;");
        thirdPane.setLayoutY(116);
        thirdPane.setLayoutX(0);
        thirdPane.getChildren().add(bulletRadius);
        thirdPane.getChildren().add(bulletRadiusTextArea);

        Text cellTextSpeed=new Text();
        cellTextSpeed.setText("Prędkość spadania komórki (0-10) ["+GameSetup.getCellFallingSpeed()+"]:");
        cellTextSpeed.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        cellTextSpeed.setX(10);
        cellTextSpeed.setY(34);

        cellTextAreaSpeed=new TextArea();
        cellTextAreaSpeed.setPrefRowCount(1);
        cellTextAreaSpeed.setPrefColumnCount(5);
        cellTextAreaSpeed.setLayoutX(800);
        cellTextAreaSpeed.setLayoutY(10);

        fourthPane=new Pane();
        fourthPane.setPrefSize(1000,58);
        fourthPane.setStyle("-fx-background-color:#333333;");
        fourthPane.setLayoutY(174);
        fourthPane.setLayoutX(0);
        fourthPane.getChildren().add(cellTextSpeed);
        fourthPane.getChildren().add(cellTextAreaSpeed);

        Text cellTextSize=new Text();
        cellTextSize.setText("Wielkość komórki (30-60) ["+GameSetup.getCellSize()+"]:");
        cellTextSize.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        cellTextSize.setX(10);
        cellTextSize.setY(34);

        cellTextAreaSize=new TextArea();
        cellTextAreaSize.setPrefRowCount(1);
        cellTextAreaSize.setPrefColumnCount(5);
        cellTextAreaSize.setLayoutX(800);
        cellTextAreaSize.setLayoutY(10);

        fifthPane=new Pane();
        fifthPane.setPrefSize(1000,58);
        fifthPane.setStyle("-fx-background-color:#444444;");
        fifthPane.setLayoutY(232);
        fifthPane.setLayoutX(0);
        fifthPane.getChildren().add(cellTextSize);
        fifthPane.getChildren().add(cellTextAreaSize);

        Text bulletAccText=new Text();
        bulletAccText.setText("Przyspieszenie pocisku (0-10) ["+GameSetup.getBulletAcceleration()+"]:");
        bulletAccText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        bulletAccText.setX(10);
        bulletAccText.setY(34);

        bulletAccTextArea=new TextArea();
        bulletAccTextArea.setPrefRowCount(1);
        bulletAccTextArea.setPrefColumnCount(5);
        bulletAccTextArea.setLayoutX(800);
        bulletAccTextArea.setLayoutY(10);

        sixthPane=new Pane();
        sixthPane.setPrefSize(1000,58);
        sixthPane.setStyle("-fx-background-color:#555555;");
        sixthPane.setLayoutY(290);
        sixthPane.setLayoutX(0);
        sixthPane.getChildren().add(bulletAccText);
        sixthPane.getChildren().add(bulletAccTextArea);

        Text cellAccText=new Text();
        cellAccText.setText("Przyspieszenie komórki (0-10) ["+GameSetup.getCellAcceleration()+"]:");
        cellAccText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        cellAccText.setX(10);
        cellAccText.setY(34);

        cellAccTextArea=new TextArea();
        cellAccTextArea.setPrefRowCount(1);
        cellAccTextArea.setPrefColumnCount(5);
        cellAccTextArea.setLayoutX(800);
        cellAccTextArea.setLayoutY(10);

        seventhPane=new Pane();
        seventhPane.setPrefSize(1000,58);
        seventhPane.setStyle("-fx-background-color:#666666;");
        seventhPane.setLayoutY(348);
        seventhPane.setLayoutX(0);
        seventhPane.getChildren().add(cellAccText);
        seventhPane.getChildren().add(cellAccTextArea);

        Text radiusChangeText=new Text();
        radiusChangeText.setText("Zmiana promienia pocisku (0-2) ["+GameSetup.getBulletRadiusChange()+"]:");
        radiusChangeText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        radiusChangeText.setX(10);
        radiusChangeText.setY(34);

        radiusChangeTextArea=new TextArea();
        radiusChangeTextArea.setPrefRowCount(1);
        radiusChangeTextArea.setPrefColumnCount(5);
        radiusChangeTextArea.setLayoutX(800);
        radiusChangeTextArea.setLayoutY(10);

        eighthPane=new Pane();
        eighthPane.setPrefSize(1000,58);
        eighthPane.setStyle("-fx-background-color:#777777;");
        eighthPane.setLayoutY(406);
        eighthPane.setLayoutX(0);
        eighthPane.getChildren().add(radiusChangeText);
        eighthPane.getChildren().add(radiusChangeTextArea);

        Text cellSizeChangeText=new Text();
        cellSizeChangeText.setText("Zmiana wielkości komórki (0-3) ["+GameSetup.getCellSizeChange()+"]:");
        cellSizeChangeText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        cellSizeChangeText.setX(10);
        cellSizeChangeText.setY(34);

        cellSizeChangeTextArea=new TextArea();
        cellSizeChangeTextArea.setPrefRowCount(1);
        cellSizeChangeTextArea.setPrefColumnCount(5);
        cellSizeChangeTextArea.setLayoutX(800);
        cellSizeChangeTextArea.setLayoutY(10);

        ninthPane=new Pane();
        ninthPane.setPrefSize(1000,58);
        ninthPane.setStyle("-fx-background-color:#888888;");
        ninthPane.setLayoutY(464);
        ninthPane.setLayoutX(0);
        ninthPane.getChildren().add(cellSizeChangeText);
        ninthPane.getChildren().add(cellSizeChangeTextArea);

        Text timeUnitText=new Text();
        timeUnitText.setText("Jednostka czasu (0.05-1) ["+GameSetup.getTimeUnit()+"]:");
        timeUnitText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        timeUnitText.setX(10);
        timeUnitText.setY(34);

        timeUnitTextArea=new TextArea();
        timeUnitTextArea.setPrefRowCount(1);
        timeUnitTextArea.setPrefColumnCount(5);
        timeUnitTextArea.setLayoutX(800);
        timeUnitTextArea.setLayoutY(10);

        tenthPane=new Pane();
        tenthPane.setPrefSize(1000,58);
        tenthPane.setStyle("-fx-background-color:#999999;");
        tenthPane.setLayoutY(522);
        tenthPane.setLayoutX(0);
        tenthPane.getChildren().add(timeUnitText);
        tenthPane.getChildren().add(timeUnitTextArea);

        Text cellUpgradeText=new Text();
        cellUpgradeText.setText("Czas ulepszenia komórki (0-10) ["+GameSetup.getDurabilityIncreaseTimeUnit()+"]:");
        cellUpgradeText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        cellUpgradeText.setX(10);
        cellUpgradeText.setY(34);

        cellUpgradeTextArea=new TextArea();
        cellUpgradeTextArea.setPrefRowCount(1);
        cellUpgradeTextArea.setPrefColumnCount(5);
        cellUpgradeTextArea.setLayoutX(800);
        cellUpgradeTextArea.setLayoutY(10);

        eleventhPane=new Pane();
        eleventhPane.setPrefSize(1000,58);
        eleventhPane.setStyle("-fx-background-color:#AAAAAA;");
        eleventhPane.setLayoutY(580);
        eleventhPane.setLayoutX(0);
        eleventhPane.getChildren().add(cellUpgradeText);
        eleventhPane.getChildren().add(cellUpgradeTextArea);

        Text gameTimeText=new Text();
        gameTimeText.setText("Czas rozgrywki (10-300) ["+GameSetup.getGameTime()+"]:");
        gameTimeText.setStyle("-fx-font-size: 20; -fx-fill: white;-fx-font-family: \"Serif\";");
        gameTimeText.setX(10);
        gameTimeText.setY(34);

        gameTimeTextArea=new TextArea();
        gameTimeTextArea.setPrefRowCount(1);
        gameTimeTextArea.setPrefColumnCount(5);
        gameTimeTextArea.setLayoutX(800);
        gameTimeTextArea.setLayoutY(10);

        twelfthPane=new Pane();
        twelfthPane.setPrefSize(1000,58);
        twelfthPane.setStyle("-fx-background-color:#BBBBBB;");
        twelfthPane.setLayoutY(638);
        twelfthPane.setLayoutX(0);
        twelfthPane.getChildren().add(gameTimeText);
        twelfthPane.getChildren().add(gameTimeTextArea);

        optionsPane.getChildren().add(firstPane);
        optionsPane.getChildren().add(secondPane);
        optionsPane.getChildren().add(thirdPane);
        optionsPane.getChildren().add(fourthPane);
        optionsPane.getChildren().add(fifthPane);
        optionsPane.getChildren().add(sixthPane);
        optionsPane.getChildren().add(seventhPane);
        optionsPane.getChildren().add(eighthPane);
        optionsPane.getChildren().add(ninthPane);
        optionsPane.getChildren().add(tenthPane);
        optionsPane.getChildren().add(eleventhPane);
        optionsPane.getChildren().add(twelfthPane);

        optionsRoot.getChildren().add(optionsMainPane);
        optionsRoot.getChildren().add(optionsPane);

        backToMenuButton.setOnAction(e->{

            primaryStage.setScene(mainMenuScene);

        });

        acceptButton.setOnAction(e->{


            try {
                FileWriter fw= new FileWriter(System.getProperty("user.dir") + "\\Java\\gameSetup.txt");

                BufferedWriter bw = new BufferedWriter(fw);

                String line1=bulletSpeedTextArea.getText()==""?String.valueOf(GameSetup.getBulletSpeed()):bulletSpeedTextArea.getText();
                String line2=maxActiveBulletsTextArea.getText()==""?String.valueOf(GameSetup.getMaxShotBullets()):maxActiveBulletsTextArea.getText();
                String line3=bulletRadiusTextArea.getText()==""?String.valueOf(GameSetup.getBulletRadius()):bulletRadiusTextArea.getText();
                String line4=cellTextAreaSpeed.getText()==""?String.valueOf(GameSetup.getCellFallingSpeed()):cellTextAreaSpeed.getText();
                String line5=cellTextAreaSize.getText()==""?String.valueOf(GameSetup.getCellSize()):cellTextAreaSize.getText();
                String line6=bulletAccTextArea.getText()==""?String.valueOf(GameSetup.getBulletAcceleration()):bulletAccTextArea.getText();
                String line7=cellAccTextArea.getText()==""?String.valueOf(GameSetup.getCellAcceleration()):cellAccTextArea.getText();
                String line8=radiusChangeTextArea.getText()==""?String.valueOf(GameSetup.getBulletRadiusChange()):radiusChangeTextArea.getText();
                String line9=cellSizeChangeTextArea.getText()==""?String.valueOf(GameSetup.getCellSizeChange()):cellSizeChangeTextArea.getText();
                String line10=timeUnitTextArea.getText()==""?String.valueOf(GameSetup.getTimeUnit()):timeUnitTextArea.getText();
                String line11=cellUpgradeTextArea.getText()==""?String.valueOf(GameSetup.getDurabilityIncreaseTimeUnit()):cellUpgradeTextArea.getText();
                String line12=gameTimeTextArea.getText()==""?String.valueOf(GameSetup.getGameTime()):gameTimeTextArea.getText();


                bw.write(line1); bw.newLine();
                bw.write(line2); bw.newLine();
                bw.write(line3); bw.newLine();
                bw.write(line4); bw.newLine();
                bw.write(line5); bw.newLine();
                bw.write(line6); bw.newLine();
                bw.write(line7); bw.newLine();
                bw.write(line8); bw.newLine();
                bw.write(line9); bw.newLine();
                bw.write(line10); bw.newLine();
                bw.write(line11); bw.newLine();
                bw.write(line12);


                bw.close();

            } catch (IOException ioException) {
                ioException.printStackTrace();
            }


            GameSetup.setSettingsUp();

            primaryStage.setScene(mainMenuScene);
        });


        optionsButton.setOnAction(e->{

            bulletSpeedText.setText("Predkosc pocisku (1-50) ["+GameSetup.getBulletSpeed()+"]:");
            maxActiveBullets.setText("Maksymalna ilość aktywnych pocisków (1-20) ["+GameSetup.getMaxShotBullets()+"]:");
            bulletRadius.setText("Średnica pocisku (5-30) ["+GameSetup.getBulletRadius()+"]:");
            cellTextSpeed.setText("Prędkość spadania komórki (0-10) ["+GameSetup.getCellFallingSpeed()+"]:");
            cellTextSize.setText("Wielkość komórki (30-60) ["+GameSetup.getCellSize()+"]:");
            bulletAccText.setText("Przyspieszenie pocisku (0-10) ["+GameSetup.getBulletAcceleration()+"]:");
            cellAccText.setText("Przyspieszenie komórki (0-10) ["+GameSetup.getCellAcceleration()+"]:");
            radiusChangeText.setText("Zmiana promienia pocisku (0-2) ["+GameSetup.getBulletRadiusChange()+"]:");
            cellSizeChangeText.setText("Zmiana wielkości komórki (0-3) ["+GameSetup.getCellSizeChange()+"]:");
            timeUnitText.setText("Jednostka czasu (0.05-1) ["+GameSetup.getTimeUnit()+"]:");
            cellUpgradeText.setText("Czas ulepszenia komórki (0-10) ["+GameSetup.getDurabilityIncreaseTimeUnit()+"]:");
            gameTimeText.setText("Czas rozgrywki (10-300) ["+GameSetup.getGameTime()+"]:");

            primaryStage.setScene(optionsScene);

        });

    /*MAIN MENU ENDS*/




        mainPane = prepareBorderPane(1200, 900);
        gamePane = preparePane(1000, 700);
        leftPlayerPane = preparePane(200, 700);
        rightPlayerPane = preparePane(200, 700);
        scoresPane = prepareGridPane(1200, 100);
        bottomPane = preparePane(1200, 100);

        mainMenuScene.setCursor(Cursor.CROSSHAIR);
        scene.setCursor(Cursor.CROSSHAIR);
        optionsScene.setCursor(Cursor.CROSSHAIR);

        leftPlayerPane.getChildren().add(leftTank);
        leftPlayerPane.getChildren().add(leftTank.barrel);
        rightPlayerPane.getChildren().add(rightTank);
        rightPlayerPane.getChildren().add(rightTank.barrel);

        leftWallBombGraphic=Bomb.addLeftBombWall();
        rightWallBombGraphic=Bomb.addRightBombWall();
        upWallBombGraphic=Bomb.addUpBombWall();
        leftWallBombGraphic.setX(375);
        leftWallBombGraphic.setY(659);
        rightWallBombGraphic.setX(420);
        rightWallBombGraphic.setY(659);
        upWallBombGraphic.setX(380);
        upWallBombGraphic.setY(647);

        gamePane.getChildren().add(bombCell.bombPane);
        gamePane.getChildren().add(leftWallBombGraphic);
        gamePane.getChildren().add(rightWallBombGraphic);


        try {
            scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {

                switch (key.getCode()) {
                    case W:
                        leftTank.moveUp(true);
                        break;
                    case S:
                        leftTank.moveDown(true);
                        break;
                    case D:
                        leftTank.barrel.leftRotate(5);
                        break;
                    case A:
                        leftTank.barrel.leftRotate(-5);
                        break;
                    case SPACE:
                        leftTank.barrel.shoot(true);
                        root.getChildren().removeAll(circleCol);
                        circleCol.clear();
                        break;
                    case UP:
                        rightTank.moveUp(false);
                        break;
                    case DOWN:
                        rightTank.moveDown(false);
                        break;
                    case LEFT:
                        rightTank.barrel.rightRotate(-5);
                        break;
                    case RIGHT:
                        rightTank.barrel.rightRotate(5);
                        break;
                    case ENTER:
                        rightTank.barrel.shoot(false);
                        root.getChildren().removeAll(circleCol);
                        circleCol.clear();
                        break;
                    case ESCAPE:

                        primaryStage.setScene(mainMenuScene);
                        resetGame();

                        break;
                }

            });
        } catch (Exception e) {
            System.out.println("KEY LISTENER PROBLEM");

        }


        gamePane.setStyle("-fx-background-color:lightblue;-fx-border-color: black ;-fx-border-width: 1 ;");
        leftPlayerPane.setStyle("-fx-background-color:#fce3e1;-fx-border-color: black ;-fx-border-width: 1 ;");
        rightPlayerPane.setStyle("-fx-background-color:#e7fce1;-fx-border-color: black ;-fx-border-width: 1 ;");
        scoresPane.setStyle("-fx-background-color:black;-fx-border-color: black ;-fx-border-width: 1 ;");
        bottomPane.setStyle("-fx-background-color:black;-fx-border-color: black ;-fx-border-width: 1 ;");
        p1PointsPane = prepareBorderPane(250, 100);
        p1BulletPane = prepareBorderPane(250, 100);
        p2PointsPane = prepareBorderPane(250, 100);
        p2BulletPane = prepareBorderPane(250, 100);
        timePane = new BorderPane();

        timeLabel = prepareLabel(timeInSeconds);
        p1PointsLabel = prepareLabel(p1PointsInt);
        p1ShotBulletsLabel = prepareLabel(p1ShotBulletsInt);
        p2PointsLabel = prepareLabel(p2PointsInt);
        p2ShotBulletsLabel = prepareLabel(p2ShotBulletsInt);

        timerTextLabel = new Label("Czas:");
        timerTextLabel.setStyle("-fx-font-size: 1.8em;");
        p1PointsTextLabel = new Label("Punkty czerwonego:");
        p1PointsTextLabel.setStyle("-fx-font-size: 1.8em;");
        p2PointsTextLabel = new Label("Punkty zielonego:");
        p2PointsTextLabel.setStyle("-fx-font-size: 1.8em;");
        p1ShotBulletsTextLabel = new Label("Wystrzały czerwonego:");
        p1ShotBulletsTextLabel.setStyle("-fx-font-size: 1.8em;");
        p2ShotBulletsTextLabel = new Label("Wystrzały zielonego:");
        p2ShotBulletsTextLabel.setStyle("-fx-font-size: 1.8em;");


        p1PointsPane.setCenter(p1PointsLabel);
        p1BulletPane.setCenter(p1ShotBulletsLabel);
        p2PointsPane.setCenter(p2PointsLabel);
        p2BulletPane.setCenter(p2ShotBulletsLabel);

        timeline = new Timeline();
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(TIME + 1), new KeyValue(timeInSeconds, 0)));
        timeline.playFromStart();
        timePane.setCenter(timeLabel);

        ColumnConstraints p1PointsColumn = prepareColumnConstraints(20);
        ColumnConstraints timeColumn = prepareColumnConstraints(20);
        ColumnConstraints p2PointsColumn = prepareColumnConstraints(20);
        ColumnConstraints p1BulletColumn = prepareColumnConstraints(20);
        ColumnConstraints p2BulletColumn = prepareColumnConstraints(20);
        p1PointsPane.setStyle("-fx-background-color:red;-fx-border-color: black ;-fx-border-width: 1 ;");
        timePane.setStyle("-fx-background-color:#8ab5f2;-fx-border-color: black ;-fx-border-width: 1 ;");
        p1BulletPane.setStyle("-fx-background-color:#f28a8a;-fx-border-color: black ;-fx-border-width: 1 ;");
        p2PointsPane.setStyle("-fx-background-color:green;-fx-border-color: black ;-fx-border-width: 1 ;");
        p2BulletPane.setStyle("-fx-background-color:lightgreen;-fx-border-color: black ;-fx-border-width: 1 ;");
        GridPane.setConstraints(p1PointsPane, 0, 0);

        GridPane.setConstraints(p1BulletPane, 1, 0);
        GridPane.setConstraints(timePane, 2, 0);
        GridPane.setConstraints(p2PointsPane, 4, 0);
        GridPane.setConstraints(p2BulletPane, 3, 0);
        GridPane.setConstraints(timerTextLabel,2,0);
        GridPane.setMargin(timerTextLabel,new Insets(-5,0,0,0));
        GridPane.setHalignment(timerTextLabel, HPos.CENTER);
        GridPane.setValignment(timerTextLabel, VPos.TOP);
        GridPane.setConstraints(p1PointsTextLabel,0,0);
        GridPane.setMargin(p1PointsTextLabel,new Insets(-5,0,0,0));
        GridPane.setHalignment(p1PointsTextLabel, HPos.CENTER);
        GridPane.setValignment(p1PointsTextLabel, VPos.TOP);
        GridPane.setConstraints(p1ShotBulletsTextLabel,1,0);
        GridPane.setMargin(p1ShotBulletsTextLabel,new Insets(-5,0,0,0));
        GridPane.setHalignment(p1ShotBulletsTextLabel, HPos.CENTER);
        GridPane.setValignment(p1ShotBulletsTextLabel, VPos.TOP);
        GridPane.setConstraints(p2PointsTextLabel,4,0);
        GridPane.setMargin(p2PointsTextLabel,new Insets(-5,0,0,0));
        GridPane.setHalignment(p2PointsTextLabel, HPos.CENTER);
        GridPane.setValignment(p2PointsTextLabel, VPos.TOP);
        GridPane.setConstraints(p2ShotBulletsTextLabel,3,0);
        GridPane.setMargin(p2ShotBulletsTextLabel,new Insets(-5,0,0,0));
        GridPane.setHalignment(p2ShotBulletsTextLabel, HPos.CENTER);
        GridPane.setValignment(p2ShotBulletsTextLabel, VPos.TOP);
        scoresPane.getColumnConstraints().addAll(p1PointsColumn, p1BulletColumn, timeColumn,
                p2PointsColumn, p2BulletColumn);
        scoresPane.getChildren().addAll(p1PointsPane, p1BulletPane, timePane, p2BulletPane, p2PointsPane,timerTextLabel
                ,p1PointsTextLabel,p1ShotBulletsTextLabel,p2PointsTextLabel,p2ShotBulletsTextLabel);
        notificationsLabel = new Label();
        notificationsLabel.setLayoutY(0);
        notificationsLabel.setLayoutX(200);
        notificationsLabel.setPrefSize(800, 100);
        notificationsLabel.textProperty().bind(notifications);
        notificationsLabel.setAlignment(Pos.CENTER);
        notificationsLabel.setStyle("-fx-font-size: 3em; -fx-background-color: #db8af2;-fx-border-color: black ;-fx-border-width: 1 ;");
        notifications.set("Naciśnij ESC aby wyjść do MENU");

        bottomPane.getChildren().add(notificationsLabel);


        mainPane.setLeft(leftPlayerPane);
        mainPane.setRight(rightPlayerPane);
        mainPane.setCenter(gamePane);
        mainPane.setTop(scoresPane);
        mainPane.setBottom(bottomPane);


        root.getChildren().add(mainPane);

        primaryStage.setScene(mainMenuScene);
        primaryStage.show();
        primaryStage.setResizable(false);
        primaryStage.setTitle("Game of Tanks");

    }


    public static void main(String[] args) {
        launch(args);
    }


    private ArrayList<Bullet> bullets() {

        try {
            ArrayList<Bullet> nodes = new ArrayList<Bullet>();
            addAllDescendents(root, nodes);
            return nodes;
        } catch (Exception e) {
            System.out.println("bullet");
        }

        return new ArrayList<Bullet>();
    }

    private static void addAllDescendents(Parent parent, ArrayList<Bullet> nodes) {

        try {
            for (Node node : parent.getChildrenUnmodifiable()) {
                if (node instanceof Bullet)
                    nodes.add((Bullet) node);
            }
        } catch (Exception e) {

            System.out.println("ADDALLDESCENDENTS");

        }

    }


    private void update() {

        t += 0.032;

        if(!doesGameStart)
        {
            return;
        }

        try {
            bullets().forEach(s -> {

                Circle fakeBullet;
                fakeBullet = new Circle(0, 0, 0);
                circle = fakeBullet;

                for (Cell cell : cellCol) {
                    if (s.getBoundsInParent().intersects(cell.stack.getBoundsInParent())) {
                        cell.getHit();

                        s.setOpacity(0);
                        s.isDestroyed = true;
                        root.getChildren().remove(s);

                        if (s.leftPlayersBullet) {
                            leftTank.setActiveBullets(leftTank.getActiveBullets() - 1);

                            if (cell.getCellDurability() == 0) {
                                leftTank.setPlayerPoints(leftTank.getPlayerPoints() + cell.getCellValue());
                                notifications.set("Lewy gracz zdobywa +" + cell.getCellValue() + " pkt");
                                cell.stack.setOpacity(0);
                                cell.timeline.jumpTo(Duration.seconds(15 - cellSpeed));
                                p1PointsInt.setValue(leftTank.getPlayerPoints());
                                cell.isDestroyed = true;

                            }
                        } else {
                            rightTank.setActiveBullets(rightTank.getActiveBullets() - 1);

                            if (cell.getCellDurability() == 0) {
                                rightTank.setPlayerPoints(rightTank.getPlayerPoints() + cell.getCellValue());
                                notifications.set("Prawy gracz zdobywa +" + cell.getCellValue() + " pkt");
                                cell.stack.setOpacity(0);
                                cell.timeline.jumpTo(Duration.seconds(15 - cellSpeed));
                                p2PointsInt.setValue(rightTank.getPlayerPoints());
                                cell.isDestroyed = true;

                            }

                        }


                    }

                }

                if (s.leftPlayersBullet) {

                    s.leftBulletMovement();

                    if (s.getBoundsInParent().intersects(scoresPane.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            leftTank.setActiveBullets(leftTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);
                        }
                    } else if (s.getBoundsInParent().intersects(bottomPane.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            leftTank.setActiveBullets(leftTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);
                        }
                    } else if (s.getBoundsInParent().intersects(rightPlayerPane.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            leftTank.setActiveBullets(leftTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);
                        }


                    } else if(s.getBoundsInParent().intersects(leftWallBomb.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            leftTank.setActiveBullets(leftTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);

                        }

                    }
                    else if(s.getBoundsInParent().intersects(rightWallBomb.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            leftTank.setActiveBullets(leftTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);

                        }

                    }else if(s.getBoundsInParent().intersects(upWallBomb.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            leftTank.setActiveBullets(leftTank.getActiveBullets() - 1);

                            if(bombCell.getHit())
                                popUp(passStage,passScene);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);

                        }

                    }


                } else {

                    s.rightBulletMovement();

                    if (s.getBoundsInParent().intersects(scoresPane.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            rightTank.setActiveBullets(rightTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);
                        }

                    } else if (s.getBoundsInParent().intersects(bottomPane.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            rightTank.setActiveBullets(rightTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);
                        }

                    } else if (s.getBoundsInParent().intersects(leftPlayerPane.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            rightTank.setActiveBullets(rightTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);
                        }

                    }else if(s.getBoundsInParent().intersects(leftWallBomb.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            rightTank.setActiveBullets(rightTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);

                        }

                    }else if(s.getBoundsInParent().intersects(rightWallBomb.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            rightTank.setActiveBullets(rightTank.getActiveBullets() - 1);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);

                        }

                    }else if(s.getBoundsInParent().intersects(upWallBomb.getBoundsInParent())) {

                        s.setOpacity(0);
                        if (s.isDestroyed == false) {
                            rightTank.setActiveBullets(rightTank.getActiveBullets() - 1);
                            if(bombCell.getHit())
                                popUp(passStage,passScene);
                            s.isDestroyed = true;
                            root.getChildren().remove(s);
                            root.getChildren().add(fakeBullet);
                            circleCol.add(fakeBullet);

                        }

                    }

                }

            });

        } catch (Exception e) {
            System.out.println("UPDATE PROBLEM");

        }


        if (t > 2) {
            if (Math.random() < 0.5) {
                createNewCell();
                t = 0;
            }
        }

    }


    public static void setShotBulletsP1() {
        p1ShotBulletsInt.set(p1ShotBulletsInt.get() + 1);
    }

    public static IntegerProperty getShotBulletsP1() { return p1ShotBulletsInt; }

    public static void setShotBulletsP2() {
        p2ShotBulletsInt.set(p2ShotBulletsInt.get() + 1);
    }

    public static IntegerProperty getShotBulletsP2() { return p2ShotBulletsInt; }

    public static void createNewCell() {
        Cell cell = new Cell();
        cellCol.add(cell);
        root.getChildren().add(cell.stack);
    }


    public void resetGame(){

        for (Cell cell : cellCol) {
            cell.stack.setOpacity(0);
            cell.timeline.jumpTo(Duration.seconds(15 - cellSpeed));
        }

        root.getChildren().removeAll(cellCol);
        doesGameStart=false;
        timer.stop();
        timeline.stop();

        leftTank.setStartingPosition();
        leftTank.barrel.setStartingPosition(true);
        rightTank.setStartingPosition();
        rightTank.barrel.setStartingPosition(false);
        p1PointsInt.setValue(0);
        p2PointsInt.setValue(0);
        leftTank.setActiveBullets(0);
        leftTank.setPlayerPoints(0);
        rightTank.setActiveBullets(0);
        rightTank.setPlayerPoints(0);
        p1ShotBulletsInt.set(0);
        p2ShotBulletsInt.set(0);
        bombCell.setBombDurability(new SimpleIntegerProperty(20));
        bombCell.bombDurabilityLabel.textProperty().bind(bombCell.bombDurability.asString());
        notifications.set("Naciśnij ESC aby wyjść do MENU");

    }


    public void popUp(Stage primaryStage, Scene mainMenuScene)
    {


        primaryStage.setScene(mainMenuScene);

        Image icon=new Image("tank.png");

        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(primaryStage);
        dialog.setResizable(false);
        dialog.setY(250);
        dialog.setX(650);
        dialog.getIcons().add(icon);
        dialog.setTitle("Rezultat");

        Pane dialogPane = new Pane();
        dialogPane.setPrefSize(300,200);
        dialogPane.setStyle("-fx-background-color:#000000;-fx-text-fill:white;-fx-font-weight:bold;");
        Text dialogText=new Text();
        Text scoreText=new Text();

        scoreText.setText(leftTank.getPlayerPoints()+":"+rightTank.getPlayerPoints());
        scoreText.setStyle("-fx-font-size: 25; -fx-fill: white;-fx-font-family: \"Serif\";");

        VBox score=new VBox();
        score.setAlignment(Pos.CENTER);
        score.getChildren().add(scoreText);
        score.setLayoutY(100);
        score.setLayoutX(100);
        score.setMinSize(400,400);

        if(leftTank.getPlayerPoints()> rightTank.getPlayerPoints())
        {
            dialogText.setStyle("-fx-font-size: 25; -fx-fill: red;-fx-font-family: \"Serif\";");
            dialogText.setText("Wygrał lewy gracz!");
            dialogText.setY(225);
            dialogText.setX(200);
        }
        else if(leftTank.getPlayerPoints()==rightTank.getPlayerPoints())
        {
            dialogText.setStyle("-fx-font-size: 25; -fx-fill: white;-fx-font-family: \"Serif\";");
            dialogText.setText("Remis!");
            dialogText.setY(225);
            dialogText.setX(262);
        }
        else
        {
            dialogText.setStyle("-fx-font-size: 25; -fx-fill: green;-fx-font-family: \"Serif\";");
            dialogText.setText("Wygrał prawy gracz!");
            dialogText.setY(225);
            dialogText.setX(190);
        }

        dialogPane.getChildren().add(dialogText);
        dialogPane.getChildren().add(score);

        Scene dialogScene = new Scene(dialogPane, 600, 500);
        dialog.setScene(dialogScene);
        dialog.show();

        resetGame();


    }



}
