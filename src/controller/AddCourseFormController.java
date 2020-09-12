package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Util;
import util.impl.UtilImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddCourseFormController implements Initializable {
    public AnchorPane MainAnchor;
    public JFXButton btnBack;
    public JFXButton btnAddCourse;
    public JFXButton btnClear1;
    public JFXTextField txtCode;
    public JFXTextField txtCName;
    public JFXTextField txtCIntake;
    public JFXTextField txtCRupees;
    public JFXTextField txtCDuration;
    public JFXComboBox cmbCourseName;

    Util util = new UtilImpl();
    CourseBO courseBO;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        courseBO = BOFactory.getInstance().getBo(BOFactory.BOType.COURSE);

        setValuesCourseName();
        setCourseCode();
    }
    public void btnAddCourseOnAction(ActionEvent actionEvent) throws Exception {
        boolean isSaved = courseBO.saveCourse(
                new CourseDTO(txtCode.getText(),
                        txtCName.getText(),
                        txtCIntake.getText(),
                        Double.parseDouble(txtCRupees.getText()),
                        txtCDuration.getText()
                ));

        System.out.println(isSaved);
    }
    public void txtCodeOnAction(ActionEvent actionEvent) throws Exception {
        CourseDTO courseDTO = courseBO.getCourse(txtCode.getText());
        if (courseDTO != null) {
            txtCName.setText(courseDTO.getCourseName());
            txtCIntake.setText(courseDTO.getCourseIntake());
            txtCRupees.setText(courseDTO.getCourseFee()+ "");
            txtCDuration.setText(courseDTO.getCourseDuration());

        }
    }
    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage exit_stage = (Stage) btnBack.getScene().getWindow();
        exit_stage.close();
        util.LoadForm("MainForm.fxml");
    }
    public void btnClearOnAction(ActionEvent actionEvent) {
        txtClear();
    }
    public void cmbCourseNameOnAction(ActionEvent actionEvent) {
        try {
            txtCName.setText(cmbCourseName.getSelectionModel().getSelectedItem().toString());
        }catch (NullPointerException ex){}
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
    public void setValuesCourseName(){
        cmbCourseName.getItems().clear();
        cmbCourseName.getItems().add("GDSE50");
        cmbCourseName.getItems().add("GDSE52");
        cmbCourseName.getItems().add("GDSE54");
        cmbCourseName.getItems().add("GDSE56");
        cmbCourseName.getItems().add("CMJD81");
        cmbCourseName.getItems().add("CMJD83");
        cmbCourseName.getItems().add("CMJD85");
    }
    public void setCourseCode(){
        try {
            int CourseCount = courseBO.getRegCount();
            if (CourseCount==0){
                txtCode.setText("C001");
            }
            if (CourseCount>0 && CourseCount<=8){
                txtCode.setText("C00"+(CourseCount+1));
            }
            if (CourseCount>=9 && CourseCount<=98){
                txtCode.setText("C0"+(CourseCount+1));
            }
            if (CourseCount>=99){
                txtCode.setText("C"+(CourseCount+1));
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
