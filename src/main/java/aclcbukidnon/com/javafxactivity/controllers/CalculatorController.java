package aclcbukidnon.com.javafxactivity.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    @FXML
    private Label displayLabel;

    @FXML
    private Label displayWithArithmetic;

    boolean clickedArithmetic = false;
    boolean clickedEqual = false;

    String previousNumber = "";
    String preNum = "";

    private StringBuilder input = new StringBuilder();

    @FXML
    private void onNum0Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("0");

    }

    @FXML
    private void onNum1Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }

        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("1");

    }

    @FXML
    private void onNum2Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }

        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("2");

    }

    @FXML
    private void onNum3Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("3");

    }

    @FXML
    private void onNum4Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("4");

    }

    @FXML
    private void onNum5Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("5");

    }

    @FXML
    private void onNum6Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("6");

    }

    @FXML
    private void onNum7Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("7");

    }

    @FXML
    private void onNum8Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("8");

    }

    @FXML
    private void onNum9Clicked() {
        if (clickedArithmetic) {
            input.setLength(0);
            updateDisplay(previousNumber);
            clickedArithmetic = false;
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText("9");

    }

    @FXML
    private void onAddClicked() {
//        appendText("+");
        appendTextWithArithmetic("+");
        clickedArithmetic = true;
    }

    @FXML
    private void onSubtractClicked() {
//        appendText("-");
        appendTextWithArithmetic("-");
        clickedArithmetic = true;
    }

    @FXML
    private void onMultiplyClicked() {
//        appendText("*");
        appendTextWithArithmetic("*");
        clickedArithmetic = true;
    }

    @FXML
    private void onDivideClicked() {
//        appendText("/");
        appendTextWithArithmetic("/");
        clickedArithmetic = true;
    }

    @FXML
    private void onDotClicked() {
        if (clickedArithmetic) {
            clickedArithmetic = false;
            input.setLength(0);
            updateDisplay(previousNumber);
        }
        if(clickedEqual) {
            input.setLength(0);
            displayWithArithmetic.setText("");
            clickedEqual = false;
        }
        appendText(".");

    }

    @FXML
    private void onClearClicked() {
        input.setLength(0);
        updateDisplay("0");
        updateDisplayWithArithmetic("0");
    }

    @FXML
    private void onBackspaceClicked() {
        if (input.length() > 0) {
            input.deleteCharAt(input.length() - 1);
        }
        updateDisplay(input.length() > 0 ? input.toString() : "0");
    }

    @FXML
    private void onEqualsClicked() {
        try {
            String currentNumber = input.toString();
            String previousNumberWithArithmetic = displayWithArithmetic.getText();

            Matcher getNum = Pattern.compile("\\d+(\\.\\d+)?").matcher(previousNumberWithArithmetic);
            String preNum = "";

            if (getNum.find()) {
                preNum = getNum.group();
            }

            String arithmetic = previousNumberWithArithmetic.replaceAll("[^+\\-*/]", "");

            String expression = preNum + arithmetic + currentNumber;

            double result = evaluate(preNum, arithmetic, currentNumber);

            updateDisplay(String.valueOf(result));
            updateDisplayWithArithmetic(expression);

            input.setLength(0);
            input.append(result);

            clickedEqual = true;
        } catch (Exception e) {
            updateDisplay("Error");
        }
    }

    private double evaluate(String preNum, String arithmetic, String currentNumber) {
        double num1 = Double.parseDouble(preNum);
        double num2 = Double.parseDouble(currentNumber);

        switch (arithmetic) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num2 == 0 ? 0 : num1 / num2;
            default: throw new IllegalArgumentException("Unknown operation: " + arithmetic);
        }
    }

    private void appendText(String text) {
        input.append(text);
        updateDisplay(input.toString());
    }

    private void updateDisplay(String text){
        displayLabel.setText(text);
        previousNumber = text.toString();
    }

    private void appendTextWithArithmetic(String text) {
        input.append(text);
        updateDisplayWithArithmetic(input.toString());
    }

    private void updateDisplayWithArithmetic(String text) {
        displayWithArithmetic.setText(text);
    }


}
