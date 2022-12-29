
package littleLibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class mainLibraryPage  extends Application {

    private static Stage primaryStage;

    public static void main(String[] args) {
        Application.launch(mainLibraryPage.class);
    }
    @Override
    public void start(Stage primaryStage) throws IOException {
        mainLibraryPage.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\littleLibrary\\Main Page.fxml"));
        AnchorPane mainPane = loader.load();
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static Stage getPrimaryStage() {
        return primaryStage;
}

}




























//    FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\GUI\\Main Page.fxml"));
//        AnchorPane mainPane = loader.load();
//
//        Scene mainScene = new Scene(mainPane);
//        primaryStage.setScene(mainScene);
//        primaryStage.setTitle("Little Library");
//        primaryStage.show();


