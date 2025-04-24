package aclcbukidnon.com.javafxactivity.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.Parent;
import javafx.util.Duration;

public class TrafficLightController {

    private enum TrafficLightColor {
        STOP,
        HOLD,
        GO,
    }

    private TrafficLightColor currentColor = TrafficLightColor.STOP;
    private Timeline timeline;

    @FXML
    private Parent root;

    @FXML
    private Circle redLight;

    @FXML
    private Circle yellowLight;

    @FXML
    private Circle greenLight;

    @FXML
    public void initialize() {
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(3), e -> onTimerChange())
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    // What happens if the time is up
    public void onTimerChange() {
        if (currentColor == TrafficLightColor.STOP) {
            redLight.setFill(Color.RED);
            yellowLight.setFill(Color.web("#575757"));
            greenLight.setFill(Color.web("#575757"));
            currentColor = TrafficLightColor.HOLD;
        } else if (currentColor == TrafficLightColor.HOLD) {
            redLight.setFill(Color.web("#575757"));
            yellowLight.setFill(Color.YELLOW);
            greenLight.setFill(Color.web("#575757"));
            currentColor = TrafficLightColor.GO;
        } else if (currentColor == TrafficLightColor.GO) {
            redLight.setFill(Color.web("#575757"));
            yellowLight.setFill(Color.web("#575757"));
            greenLight.setFill(Color.GREEN);
            currentColor = TrafficLightColor.STOP;
        }
    }
}
