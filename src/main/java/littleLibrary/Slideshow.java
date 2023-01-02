package littleLibrary;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import javafx.scene.Node;

import java.io.ByteArrayInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Slideshow {
        private List<Node> slides = new ArrayList<>();
        private int currentSlide = 0;
        private Timeline timeline;

        public void addSlide(Node slide) {
            slides.add(slide);
        }

        public void play() {
            if (slides.isEmpty()) {
                return;
            }

            currentSlide = 0;
            showSlide(currentSlide);

            timeline = new Timeline(new KeyFrame(Duration.seconds(5), e -> nextSlide()));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        }

        public void stop() {
            if (timeline != null) {
                timeline.stop();
            }
        }

        public void setCycleCount(int count) {
            if (timeline != null) {
                timeline.setCycleCount(count);
            }
        }

        public void setAutoAdvance(boolean autoAdvance) {
            if (timeline != null) {
                timeline.setAutoReverse(!autoAdvance);
            }
        }

        private void nextSlide() {
            currentSlide++;
            if (currentSlide >= slides.size()) {
                currentSlide = 0;
            }
            showSlide(currentSlide);
        }

        private void showSlide(int index) {
            for (Node slide : slides) {
                slide.setVisible(false);
            }
            slides.get(index).setVisible(true);
        }
        public void showCovers() {
        List<byte[]> covers = getCovers();

        Slideshow slideshow = new Slideshow();
        for (byte[] cover : covers) {
            Image image = new Image(new ByteArrayInputStream(cover));
            slideshow.addSlide(new ImageView(image));
        }
        slideshow.setCycleCount(20);
        slideshow.setAutoAdvance(true);
        slideshow.play();

    }

        private List<byte[]> getCovers() {
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
        } return covers;
    }
}

