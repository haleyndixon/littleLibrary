
package com.example.littlelibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
        loader.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\com\\example\\littlelibrary\\Main Page.fxml"));
        AnchorPane mainPane = loader.<AnchorPane>load();

        Scene mainScene = new Scene(mainPane);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Little Library");
        primaryStage.show();

    }


}


































//import java.io.File;
//        import java.time.LocalDateTime;
//        import java.time.format.DateTimeFormatter;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class MoveOldFiles {
//    public static void main(String[] args) {
//        // Set the threshold date for determining which files are "old"
//        String thresholdDateString = "2022-12-01 00:00:00";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        LocalDateTime thresholdDate = LocalDateTime.parse(thresholdDateString, formatter);
//
//        // Set the directory that contains the files to be moved
//        File sourceDirectory = new File("/path/to/source/directory");
//
//        // Set the directory to move the old files to
//        File destinationDirectory = new File("/path/to/destination/directory");
//
//        // Get a list of all files in the source directory
//        File[] files = sourceDirectory.listFiles();
//
//        // Move old files to the destination directory
//        List<File> oldFiles = new ArrayList<>();
//        for (File file : files) {
//            LocalDateTime lastModifiedDate = LocalDateTime.ofInstant(file.toPath().toAbsolutePath().toFile().lastModified(), formatter);
//            if (lastModifiedDate.isBefore(thresholdDate)) {
//                oldFiles.add(file);
//            }
//        }
//        for (File oldFile : oldFiles) {
//            oldFile.renameTo(new File(destinationDirectory, oldFile.getName()));
//        }
//    }
//}
