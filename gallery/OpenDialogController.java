package sample;

import com.sun.istack.internal.Nullable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * Created by juancgalan on 10/19/16.
 */
public class OpenDialogController implements Initializable {
    @FXML
    private TextField path;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        path.setText(getCurrentDirectory());
    }


    private String getCurrentDirectory() {
        Properties p = new Properties();
        try {
            p.load(new FileInputStream("config.properties"));
            return p.getProperty("directory");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void openDirectory() {
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Choose Gallery Folder...");
        File directory = dc.showDialog(path.getScene().getWindow());
        if (directory != null) {
            path.setText(directory.getAbsolutePath());
            Properties p = new Properties();
            try {
                p.load(new FileInputStream("config.properties"));
                p.setProperty("directory", directory.getCanonicalPath());
                p.store(new FileOutputStream("config.properties"), "Gallery Config File");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        path.getScene().getWindow().hide();
    }
}
