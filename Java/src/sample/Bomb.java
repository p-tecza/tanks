package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Bomb extends Rectangle {

    public IntegerProperty bombDurability;
    private final int bombSize = 40;
    public StackPane bombPane;
    public Label bombDurabilityLabel;


    public Bomb() {
        super();
        this.bombDurability = new SimpleIntegerProperty(20);

        this.bombPane = new StackPane();
        this.bombDurabilityLabel = new Label();
        bombDurabilityLabel.textProperty().bind(bombDurability.asString());
        bombDurabilityLabel.setTextFill(Color.WHITE);
        bombDurabilityLabel.setStyle("-fx-font-size: 2.5em;");
        this.setWidth(this.bombSize);
        this.setHeight(this.bombSize);
        this.bombPane.setLayoutX(380);
        this.bombPane.setLayoutY(660);
        this.setFill(Color.BLACK);
        this.bombPane.getChildren().addAll(this, this.bombDurabilityLabel);

    }

    public Bomb(boolean testBehaviour) {

        this.bombDurability = new SimpleIntegerProperty(20);

    }

    public static Rectangle addLeftBombWall() {
        Rectangle leftWall = new Rectangle();
        leftWall.setHeight(40);
        leftWall.setWidth(5);
        leftWall.setX(575);
        leftWall.setY(759);
        leftWall.setFill(Color.WHITE);

        return leftWall;

    }

    public static Rectangle addRightBombWall() {
        Rectangle rightWall = new Rectangle();
        rightWall.setHeight(40);
        rightWall.setWidth(5);
        rightWall.setX(620);
        rightWall.setY(759);
        rightWall.setFill(Color.WHITE);

        return rightWall;
    }

    public static Rectangle addUpBombWall() {
        Rectangle upWall = new Rectangle();
        upWall.setHeight(6);
        upWall.setWidth(40);
        upWall.setX(580);
        upWall.setY(747);
        upWall.setFill(Color.YELLOW);

        return upWall;

    }

    public boolean getHit() {
        boolean gameOver = false;

        if (bombDurability.getValue() > 0) this.bombDurability.setValue(this.bombDurability.getValue() - 1);
        if (bombDurability.getValue() == 0) gameOver = true;

        return gameOver;
    }

    public void setBombDurability(IntegerProperty value) {
        this.bombDurability = value;
    }

}
