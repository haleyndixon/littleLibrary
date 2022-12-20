
package littleLibrary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class mainLibraryPage  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(new URL("file:\\C:\\Users\\haley\\IdeaProjects\\littleLibrary\\src\\main\\java\\GUI\\Main Page.fxml"));
        AnchorPane mainPane = loader.load();

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
