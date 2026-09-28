package com.mycompany.lab05;

import java.util.Map;
import java.util.TreeMap;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        //task 01
        BorderPane root = new BorderPane();
        var scene1 = new Scene(root, 500, 500);
        root.setPadding(new Insets(10));
        GridPane gp = new GridPane();
        gp.setPadding(new Insets(20));
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
        
        small.setUserData("Small");
        medium.setUserData("Medium");
        large.setUserData("Large");
        
        VBox vb = new VBox();
        VBox col2 = new VBox();
        
        sizes.getToggles().addAll(small, medium, large);
        vb.getChildren().addAll(small, medium, large);
        
        Button orderButton = new Button("Order");
        Button clearButton = new Button("Clear");
        HBox buttons = new HBox();
        buttons.getChildren().addAll(orderButton, clearButton);
        buttons.setPadding(new Insets(10));
        
        col2.getChildren().addAll(vb, numbers);
        col2.setPadding(new Insets(10));
        
        gp.add(bags, 0, 0);
        gp.add(col2, 1, 0);
        gp.add(buttons, 0, 2);
        
        orderButton.setOnAction(e -> {
            String number = String.valueOf(numbers.getSelectionModel().getSelectedItem());
            String size = sizes.getSelectedToggle().getUserData().toString();
            String bagType = String.valueOf(bags.getSelectionModel().getSelectedItem());
            
            // number, size, type of bag
            // "You ordered: " + number + size + bagType + "Bags"
           
            orderMessage.setText("You ordered: " + " " + number + " " + size + " " 
                    + bagType + " " + "Bags");
            
            gp.add(orderMessage, 1, 1);
        });
        
        clearButton.setOnAction(e -> {
            orderMessage.setText("");
            bags.getSelectionModel().clearSelection();
            numbers.getSelectionModel().clearSelection();
            sizes.selectToggle(null);
        });
        
        root.setCenter(gp);
        
        
        //task 02
        BorderPane root2 = new BorderPane();
        GridPane gp2 = new GridPane();
        
        ComboBox<String> beveragesCB = new ComboBox();
        Map<String, Double> beverages = new TreeMap<>();
        beverages.put("Coffee", 2.50);
        beverages.put("Tea", 2.00);
        beverages.put("Water", 2.95);
        beveragesCB.setPromptText("Beverages");
        beveragesCB.getItems().addAll("Coffee", "Tea", "Water");
        
        
        ComboBox<String> appetizerCB = new ComboBox();
        Map<String, Double> appetizer = new TreeMap<>();
        appetizer.put("Soup", 4.50);
        appetizer.put("Salad", 3.75);
        appetizer.put("Garlic Bread", 3.00);
        appetizerCB.setPromptText("Appetizers");
        appetizerCB.getItems().addAll("Soup", "Salad", "Garlic Bread");
        
        ComboBox<String> mainCoursesCB = new ComboBox();
        Map<String, Double> mainCourses = new TreeMap<>();
        mainCourses.put("Steak", 15.00);
        mainCourses.put("Chicken Alfredo", 13.95);
        mainCourses.put("Fish and Chips", 12.25);
        mainCoursesCB.setPromptText("Main Courses");
        mainCoursesCB.getItems().addAll("Steak", "Chicken Alfredo", "Fish and Chips");
        
        ComboBox<String> dessertCB = new ComboBox();
        Map<String, Double> dessert = new TreeMap<>();
        dessert.put("Carrot Cake", 4.50);
        dessert.put("Apple Pie", 5.95);
        dessert.put("Mud Pie", 4.75);
        dessertCB.setPromptText("Dessert");
        dessertCB.getItems().addAll("Cheesecake", "Apple Pie", "Tiramisu");

        Button changeScene = new Button("Change Scene");
        gp.add(changeScene, 2, 1);

        var scene2 = new Scene(root2, 500, 500);

        changeScene.setOnAction(e -> {
            stage.setScene(scene2);
        });
        
        stage.setScene(scene1);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}