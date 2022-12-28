package littleLibrary;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigationManager {
    private Scene previousScene;
    private Scene currentScene;

    public void switchScene (String fxmlFile) {
        // Update the value of the previousScene variable
        previousScene = currentScene;

        // Load the FXML file and create the new scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            currentScene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the stage to show the new scene
        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(currentScene);
    }

    public void backButton(String fxmlFile) {
        // Load the FXML file and create the previous scene
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            previousScene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Update the stage to show the previous scene
        Stage stage = (Stage) currentScene.getWindow();
        stage.setScene(previousScene);
    }
}

