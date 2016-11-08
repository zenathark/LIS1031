package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    private File currentDirectory;
    private Integer seek;

    @FXML
    private ImageView imagePanel;

    @FXML
    private void handleOpenAction(final ActionEvent event) {
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("opendialog.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Open...");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();
            resetSeek();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        resetSeek();
    }

    private void updateImage() {
        if (seek >= 0) {
            File imageFile = getImages()[seek];
            try {
                Image image = new Image(new FileInputStream(imageFile));
                imagePanel.setImage(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private void resetSeek() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("config.properties"));
            currentDirectory = new File(p.getProperty("directory"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (currentDirectory != null && getImages().length > 0) {
            seek = 0;
        } else {
            seek = -1;
        }
        updateImage();
    }

    @FXML
    private void next() {
        if (currentDirectory != null) {
            Integer nImages = getImages().length;
            if (seek + 1 < nImages) seek++;
            updateImage();
        }
    }

    @FXML
    private void previous() {
        if (currentDirectory != null && seek > 0) {
            seek--;
            updateImage();
        }
    }

    private File[] getImages() {
        return currentDirectory.listFiles((File dir, String name) ->
                        name.lastIndexOf(".jpg") > 0);
    }
}
