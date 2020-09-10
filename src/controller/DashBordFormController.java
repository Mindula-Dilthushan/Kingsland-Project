package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DashBordFormController {
    public JFXTextField txtStId;
    public JFXTextField txtStName;
    public JFXTextField txtStAddress;
    public JFXTextField txtStContact;
    public JFXTextField txtStDob;
    public JFXTextField txtStGender;
    public JFXTextField txtCode;
    public JFXTextField txtCName;
    public JFXTextField txtCIntake;
    public JFXTextField txtCRupees;
    public JFXTextField txtCDuration;
    public JFXButton btnRegister;
    public JFXButton btnClear;
    public JFXButton btnAddNewCourse;
    public JFXButton btnViewAllStudent;
    public JFXButton btnClose;
    public AnchorPane anchorDashBord;
    public JFXComboBox cmbStGender;
    public JFXComboBox cmbCName;
    public JFXComboBox cmbSt;

    public void cleartext(){
        txtStName.setText("");
        txtStAddress.setText("");
        txtStContact.setText("");
        txtStDob.setText("");
        txtStGender.setText("");

    }
    public void btnAddNewCourseOnAction(ActionEvent actionEvent) throws IOException {
        anchorDashBord.getChildren().clear();
        AnchorPane load = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/view/AddNewCourse.fxml"));
        anchorDashBord.getChildren().addAll(load.getChildren());
    }

    public void btnViewAllStudentOnAction(ActionEvent actionEvent) throws IOException {
        anchorDashBord.getChildren().clear();
        AnchorPane load = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/view/ViewAllStudentForm.fxml"));
        anchorDashBord.getChildren().addAll(load.getChildren());
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage exit_stage = (Stage) btnClose.getScene().getWindow();
        exit_stage.close();
    }

    public void btnRegisterOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        cleartext();
    }

    public void txtStId(KeyEvent keyEvent) {
    }
}
