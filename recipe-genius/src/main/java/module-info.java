module com.example.recipegenius {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;


    opens com.example.recipegenius to javafx.fxml;
    exports com.example.recipegenius;
    exports com.example.recipegenius.controller;
    opens com.example.recipegenius.controller to javafx.fxml;
}