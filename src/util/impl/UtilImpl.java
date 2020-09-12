package util.impl;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.Util;
import java.io.IOException;
import java.net.URL;

public class UtilImpl implements Util {
    @Override
    public void LoadForm(String location) throws IOException {
        URL resource = this.getClass().getResource("/view/" + location);
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        //stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

}
