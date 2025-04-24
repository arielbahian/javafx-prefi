package aclcbukidnon.com.javafxactivity.controllers;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

public class TodoController {

    @FXML
    private ListView<String> todoList;

    ObservableList<String> initialItems = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        initialItems.add("Remove Me");

        todoList.setItems(initialItems);
        todoList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoList.setOnMouseClicked((MouseEvent event) -> {
            if (event.getClickCount() == 2) {
                String selectedItem = todoList.getSelectionModel().getSelectedItem();
                if (selectedItem != null) {
                    onTodoListItemClick(selectedItem);
                }
            }
        });
    }


    private void onTodoListItemClick(String value){

        var dialog = new TextInputDialog(value);
        dialog.setTitle("Update Todo");

        var result = dialog.showAndWait();
        result.ifPresent(text -> {
            int index = initialItems.indexOf(value);
            if (index != -1) {
                initialItems.set(index, text);
            }
        });
//        result.ifPresent(text -> System.out.println(text));
    }



    @FXML
    protected void onCreateClick(){
        var dialog = new TextInputDialog("");
        dialog.setTitle("Create New Todo");

        var result = dialog.showAndWait();
        result.ifPresent(text -> initialItems.add(text));

//        result.ifPresent(text -> System.out.println(text));
    }

    @FXML
    protected void onDeleteClick(){

        var confirm = new Alert(Alert.AlertType.CONFIRMATION);
        confirm.setTitle("Confirmation Dialog");
        confirm.setHeaderText("Are you sure you want to delete this todo?");
        confirm.setContentText("This action cannot be undone.");

        var result = confirm.showAndWait();

        if (result.isPresent()) {
            initialItems.clear();
        }
    }

    @FXML
    protected void onListEdit(){

    }
}
