package com.example.recipegenius;

import com.example.recipegenius.controller.HomePageController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private StackPane root;

    @Override
    public void start(Stage primaryStage) {
        // Initialize the root StackPane
        root = new StackPane();

        // Load the initial page
        loadPage("/com/example/recipegenius/view/home-page.fxml");

        // Set up the primary stage
        primaryStage.setTitle("Recipe Genius");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void loadPage(String resource) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
            Parent page = loader.load();

            // Set the reference to the Main application in the controller
            if (loader.getController() instanceof HomePageController) {
                ((HomePageController) loader.getController()).setMainApp(this);
            }

            root.getChildren().clear();
            root.getChildren().add(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Example methods to switch between pages
    public void switchToIngredientsPage() {
        loadPage("/com/example/recipegenius/view/ingredients-page.fxml");
    }
}