package littleLibrary;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class AddBookController {

    @FXML
    TextField titleField = new TextField();
    @FXML
    TextField authorField = new TextField();
    @FXML
    DatePicker finishField = new DatePicker();
    @FXML
    TextField pagesField = new TextField();
    @FXML
    TextField ratingField = new TextField();
    @FXML
    FileChooser coverField = new FileChooser();



    @FXML public void addNewEntry(ActionEvent actionEvent) throws IOException, InterruptedException {
        Integer id = null;
        String title = titleField.getText();
        String author = authorField.getText();
        String finish = String.valueOf(finishField.getValue());
        Integer pages = Integer.valueOf(pagesField.getText());
        Integer rating = Integer.valueOf(ratingField.getText());

        byte[] cover = chooseCoverPhoto();

        //create new book object and set parameters using the constructor
        Book book = new Book(null, title, author, finish, pages, rating);

        book.insertBook(cover);

        titleField.setText("");
        authorField.setText("");
        finishField.setValue(null);
        pagesField.setText("");
        ratingField.setText("");

    }

    public byte[] chooseCoverPhoto() throws IOException {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Cover Photo");
            File selectedFile = fileChooser.showOpenDialog(null);

            // Check that a file was selected
            if (selectedFile == null) {
                return null;
            }

            // Check that the file is a valid image
            BufferedImage image = ImageIO.read(selectedFile);
            if (image == null) {
                System.out.println("Invalid image file");
                return null;
            }

            // Convert the image to a byte array
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            baos.flush();
            byte[] photoBytes = baos.toByteArray();
            baos.close();

            return photoBytes;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
//        FileChooser fileChooser = new FileChooser();
//        fileChooser.setTitle("Select Cover Photo");
//        File selectedFile = fileChooser.showOpenDialog(null);
//        Image image = new Image(selectedFile.getPath());
//        System.out.println(image);
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        System.out.println(Arrays.toString(new ByteArrayOutputStream[]{baos}));
//        WritableImage writableImage = new WritableImage((int) image.getWidth(), (int) image.getHeight());
//        System.out.println(Arrays.toString(new ByteArrayOutputStream[]{baos}));
//        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
//        System.out.println(Arrays.toString(new ByteArrayOutputStream[]{baos}));
//        ImageIO.write(bufferedImage, "jpg", baos);
//        System.out.println(Arrays.toString(new ByteArrayOutputStream[]{baos}));
//        baos.flush();
//        System.out.println(Arrays.toString(new ByteArrayOutputStream[]{baos}));
//        byte[] photoBytes = baos.toByteArray();
//        System.out.println(Arrays.toString(new ByteArrayOutputStream[]{baos}));
//        baos.close();
//        System.out.println(Arrays.toString(new ByteArrayOutputStream[]{baos}));
//        return photoBytes;
//    }
}