package littleLibrary;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
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
    public HBox hBox;
    public ScrollPane scrollPane;

    public Slideshow(StackPane stackPane) {
        this.stackPane = stackPane;
        hBox = new HBox();
        scrollPane = new ScrollPane(hBox);
        stackPane.getChildren().add(scrollPane);
        stackPane.setPrefSize(300, 156);
    }
    public void addSlide(Node slide) {
        slides.add(slide);
        hBox.getChildren().add(slide);
    }
    public void showCovers() {
        List<byte[]> covers = getCovers();

        for (byte[] cover : covers) {
            Image image = new Image(new ByteArrayInputStream(cover));
            ImageView imageView = new ImageView();
            imageView.setImage(image);
            imageView.setFitWidth(100);
            imageView.setFitHeight(156);
            addSlide(imageView);
        }
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(90), e -> nextSlide()));
        timeline.setCycleCount(20);
        timeline.setAutoReverse(false);
        timeline.play();
    }
    private void nextSlide() {
        stackPane.getChildren().clear();
        for (Node slide : slides) {
            slide.setVisible(false);
        }
        int index = (int) timeline.getCurrentTime().toSeconds() / 5 % slides.size();
        slides.get(index).setVisible(true);

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

