package littleLibrary;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private Scene previousScene;
    private Scene currentScene;

    //map for storing scenes by name
    private Map<String, Scene> scenes;

    //Stage to display the scenes
    private Stage stage;
    public SceneManager(Stage stage) {
        this.stage = stage;
        this.scenes = new HashMap<>();
    }

    public void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    //change to particular scene
    public void  goToScene(String name) {
        stage.setScene(scenes.get(name));
    }

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

    public void backButton() {
        stage.setScene(currentScene);

    }
}

