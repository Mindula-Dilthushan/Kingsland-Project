package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnClose;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateDateTime();
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage exit_stage = (Stage) btnClose.getScene().getWindow();
        exit_stage.close();
    }

    public void generateDateTime(){
        lblDate.setText(LocalDate.now().toString());

        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e->{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblTime.setText(LocalDateTime.now().format(formatter));
        }),new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }



}
