package com.example.littlelibrary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;


public class HelloController {

    @FXML Button addBtn;
    @FXML Button trackBtn;
    @FXML Button summaryBtn;
    @FXML Button browseBtn;


    @FXML public void addBtn (ActionEvent event) throws Exception {
        try {
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\com\\example\\littlelibrary\\AddBookPage.fxml"));
            Parent root2 = (Parent) loader2.load();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2));
            stage2.show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @FXML public void trackBtn(ActionEvent event) throws Exception {

    }

    @FXML public void summary (ActionEvent event) throws Exception {

    }

    @FXML public void browseBtn (ActionEvent event) throws Exception {
        try {
            FXMLLoader loader1 = new FXMLLoader();
            loader1.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\com\\example\\littlelibrary\\BrowsePage.fxml"));
            Parent root1 = (Parent) loader1.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root1));
            stage1.show();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }




    }

