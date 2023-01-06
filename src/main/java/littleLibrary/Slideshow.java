package littleLibrary;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Slideshow {
    public final List<Node> slides = new ArrayList<>();
    public Timeline timeline;
    public StackPane stackPane;

    public Slideshow(StackPane stackPane) {
        this.stackPane = stackPane;
        stackPane.setPrefSize(200, 200);
    }

    public void addSlide(Node slide) {
        slides.add(slide);
        stackPane.getChildren().add(slide);
    }

    public void showCovers() {
        List<byte[]> covers = getCovers();

        for (byte[] cover : covers) {
            Image image = new Image(new ByteArrayInputStream(cover), 200, 200, true, true);
            ImageView imageView = new ImageView();
            imageView.setFitHeight(200);
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);
            imageView.setImage(image);
            addSlide(imageView);
        }

        timeline = new Timeline(
                new KeyFrame(Duration.seconds(5), e -> nextSlide()));
        timeline.setCycleCount(20);
        timeline.setAutoReverse(false);
        timeline.play();
    }

    private void nextSlide() {
        int index = (int) timeline.getCurrentTime().toSeconds() / 5 % slides.size();
        slides.get(index).setVisible(false);
        int nextIndex = (index + 1) % slides.size();
        slides.get(nextIndex).setVisible(true);

    }

    public List<byte[]> getCovers() {
        List<byte[]> covers = new ArrayList<>();
        try {
            Connection connection = DatabaseTings.getConnection();
            String sql = "SELECT Cover from Entries";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                byte[] cover = resultSet.getBytes("Cover");
                covers.add(cover);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return covers;
    }
}

