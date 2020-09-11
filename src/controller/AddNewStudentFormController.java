package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Util;
import util.impl.UtilImpl;
import java.io.IOException;

public class AddNewStudentFormController {
    public AnchorPane MainAnchor;
    public JFXTextField txtStId;
    public JFXTextField txtStName;
    public JFXTextField txtStAddress;
    public JFXTextField txtStContact;
    public JFXTextField txtStDob;
    public JFXTextField txtStGender;
    public JFXComboBox cmbSt;
    public JFXComboBox cmbStGender;
    public JFXButton btnRegister;
    public JFXButton btnClear;
    public JFXComboBox cmbStId;
    public JFXButton btnBack;

    Util util = new UtilImpl();


    public void btnRegisterOnAction(ActionEvent actionEvent) {
    }









    public void btnClearOnAction(ActionEvent actionEvent) {
        txtClear();
    }

    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage exit_stage = (Stage) btnBack.getScene().getWindow();
        exit_stage.close();
        util.LoadForm("MainForm.fxml");
    }

    public void txtClear(){
        txtStId.setText("");
        txtStName.setText("");
        txtStAddress.setText("");
        txtStContact.setText("");
        txtStDob.setText("");
        txtStGender.setText("");

    }

}
