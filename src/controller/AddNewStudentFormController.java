package controller;

import bo.BOFactory;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.StudentDTO;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Util;
import util.impl.UtilImpl;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewStudentFormController implements Initializable {
    public AnchorPane MainAnchor;
    public JFXTextField txtStId;
    public JFXTextField txtStName;
    public JFXTextField txtStAddress;
    public JFXTextField txtStContact;
    public JFXTextField txtStDob;
    public JFXTextField txtStGender;
    public JFXComboBox cmbStGender;
    public JFXButton btnRegister;
    public JFXButton btnClear;
    public JFXComboBox cmbStId;
    public JFXButton btnBack;

    StudentBO studentBO = BOFactory.getInstance().getBo(BOFactory.BOType.STUDENT);

    Util util = new UtilImpl();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

    public void btnRegOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = studentBO.saveStudent(
                new StudentDTO(
                        txtStId.getText(),
                        txtStName.getText(),
                        txtStAddress.getText(),
                        txtStContact.getText(),
                        txtStDob.getText(),
                        txtStGender.getText()
                )
        );
        System.out.println(isSaved);
    }


}
