package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Util;
import util.impl.UtilImpl;

import java.io.IOException;

public class AddCourseFormController {
    public AnchorPane MainAnchor;
    public JFXButton btnBack;
    public JFXButton btnAddCourse;
    public JFXButton btnClear1;
    public JFXTextField txtCode;
    public JFXTextField txtCName;
    public JFXTextField txtCIntake;
    public JFXTextField txtCRupees;
    public JFXTextField txtCDuration;

    Util util = new UtilImpl();



    public void btnAddCourseOnAction(ActionEvent actionEvent) {
    }



    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage exit_stage = (Stage) btnBack.getScene().getWindow();
        exit_stage.close();
        util.LoadForm("MainForm.fxml");
    }
    public void btnClearOnAction(ActionEvent actionEvent) {
        txtClear();
    }
    public void SetUI(String location) throws IOException {
        MainAnchor.getChildren().clear();
        AnchorPane load = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/view/" + location));
        MainAnchor.getChildren().addAll(load.getChildren());
    }
    public void txtClear(){
        txtCode.setText("");
        txtCName.setText("");
        txtCIntake.setText("");
        txtCRupees.setText("");
        txtCDuration.setText("");
    }
}
