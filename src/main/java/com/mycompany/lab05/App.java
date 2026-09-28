package com.mycompany.lab05;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane root = new BorderPane();
        GridPane gp = new GridPane();
        Label orderMessage = new Label("You ordered: ");
        
        ListView<String> bags = new ListView();
        bags.getItems().addAll("Full Decorative", "Beaded", "Pirate Design",
                "Fringed", "Leather", "Plain");
        
        ComboBox<String> numbers = new ComboBox();
        numbers.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        
        RadioButton small = new RadioButton("Small");
        RadioButton medium = new RadioButton("Medium");
        RadioButton large = new RadioButton("Large");
        ToggleGroup sizes = new ToggleGroup();
        
        sizes.getToggles().addAll(small, medium, large);
        
        Button orderButton = new Button();
        Button clearButton = new Button();
        gp.add(bags, 0, 0);
        
//        orderButton.setOnAction(e -> );
        
        
        
        var scene = new Scene(root, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}