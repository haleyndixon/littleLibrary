
package com.example.littlelibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;


public class mainLibraryPage  extends Application{
    public static void main(String[] args) {
        CheckConnection();
        launch(args);
    }

    public static void CheckConnection() {
        Connection conn = SqliteConnectionClass.getConnection();
        if (conn == null){
            System.out.println("connection is not successful");
            System.exit(1);
        } else {
            System.out.println("connection successful");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\com\\example\\littlelibrary\\Main Menu.fxml"));
        AnchorPane mainPane = loader.<AnchorPane>load();

        Scene mainScene = new Scene(mainPane);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Little Library");
        primaryStage.show();

    }


}