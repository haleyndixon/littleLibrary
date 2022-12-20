package littleLibrary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;


public class HelloController {
            
    @FXML Button addBtn;

    @FXML Button trackBtn;
    @FXML Button summaryBtn;
    @FXML Button browseBtn;


    @FXML public void addBtn (ActionEvent event) throws Exception {

        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();

        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\GUI\\AddBookPage.fxml"));
            Parent root2 = loader2.load();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2));
            stage2.show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @FXML public void trackBtn(ActionEvent event) throws Exception {

    }

    @FXML public void summary (ActionEvent event) {

    }

    @FXML public void browseBtn (ActionEvent event) {

        Stage stage = (Stage) addBtn.getScene().getWindow();
        stage.close();

        try {
            
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\GUI\\BrowsePage.fxml"));
            Parent root1 = loader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }




    }

