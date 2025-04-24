package aclcbukidnon.com.javafxactivity.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CounterController {

    @FXML
    private Label labelCount;


    @FXML
    protected void onPlusClick() {
        int count = Integer.parseInt(labelCount.getText());
        count++;
        labelCount.setText(String.valueOf(count));
    }

    @FXML
    protected void onMinusClick() {
        int count = Integer.parseInt(labelCount.getText());
        count--;
        labelCount.setText(String.valueOf(count));
    }


}
