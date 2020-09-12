package controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import bo.custom.RegistrationBO;
import bo.custom.StudentBO;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.RegistrationDTO;
import dto.StudentDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.Util;
import util.impl.UtilImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public JFXButton btnBack;
    public JFXTextField txtCName;
    public JFXTextField txtCode;
    public JFXTextField txtCIntake;
    public JFXTextField txtCRupees;
    public JFXTextField txtCDuration;
    public JFXComboBox cmbCourseName;
    public JFXComboBox cmbCourseCode;
    public JFXComboBox cmbStID;
    public JFXTextField txtRegDate;
    public JFXTextField txtRegFees;
    public JFXTextField txtRegNo;
    public JFXComboBox cmbRegNo;

    StudentBO studentBO;
    CourseBO courseBO;
    RegistrationBO registrationBO;
    Util util = new UtilImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        studentBO = BOFactory.getInstance().getBo(BOFactory.BOType.STUDENT);
        registrationBO = BOFactory.getInstance().getBo(BOFactory.BOType.REGISTRATION);
        courseBO = BOFactory.getInstance().getBo(BOFactory.BOType.COURSE);

        setValuesToCmbGender();
        setStudentID();
        setRegNo();
        setCourseCode();

        try {
            addValuesToCmbCourses();
            addValuesToCmbStudent();
            addValuesToCmbReg();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void cmbStGenderOnAction(ActionEvent actionEvent) {
        try {
            txtStGender.setText(cmbStGender.getSelectionModel().getSelectedItem().toString());
        }catch (NullPointerException ex){}
    }
    public void setValuesToCmbGender(){
        cmbStGender.getItems().clear();
        cmbStGender.getItems().add("Male");
        cmbStGender.getItems().add("Female");
    }
    public void setStudentID(){
        try {
            int studentCount = studentBO.getRegCount();
            if (studentCount==0){
                txtStId.setText("S001");
            }
            if (studentCount>0 && studentCount<=8){
                txtStId.setText("S00"+(studentCount+1));
            }
            if (studentCount>=9 && studentCount<=98){
                txtStId.setText("S0"+(studentCount+1));
            }
            if (studentCount>=99){
                txtStId.setText("S"+(studentCount+1));
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void setRegNo(){
        try {
            int regCount = registrationBO.getRegCount();
            if (regCount==0){
                txtRegNo.setText("R001");
            }
            if (regCount>0 && regCount<=8){
                txtRegNo.setText("R00"+(regCount+1));
            }
            if (regCount>=9 && regCount<=98){
                txtRegNo.setText("R0"+(regCount+1));
            }
            if (regCount>=99){
                txtRegNo.setText("R"+(regCount+1));
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void setValuesStId(){
        cmbStGender.getItems().clear();
        cmbStGender.getItems().add("Male");
        cmbStGender.getItems().add("Female");
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

                    boolean isSaveded = courseBO.saveCourse(
                        new CourseDTO(txtCode.getText(),
                                txtCName.getText(),
                                txtCIntake.getText(),
                                Double.parseDouble(txtCRupees.getText()),
                                txtCDuration.getText()
                        ));

                        System.out.println(isSaveded);

//                            boolean isSavededd = registrationBO.saveReg(
//                                    new RegistrationDTO(
//                                            txtRegNo.getText(),
//                                            txtRegDate.getText(),
//                                            Double.parseDouble(txtCIntake.getText()),
//                                            txtStId.getText(),
//                                            txtCode.getText())
//                            );
//
//                            System.out.println(isSavededd);
    }
    public void txtStIdOnAction(ActionEvent actionEvent) throws Exception {
        StudentDTO studentDTO = studentBO.getStudent(txtStId.getText());
        if (studentDTO != null) {
            txtStName.setText(studentDTO.getStName());
            txtStAddress.setText(studentDTO.getStAddress());
            txtStContact.setText(studentDTO.getStContact());
            txtStDob.setText(studentDTO.getStDob());
            txtStGender.setText(studentDTO.getStGender());
        }
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
        txtStId.setText(null);
        txtStName.setText(null);
        txtStAddress.setText(null);
        txtStContact.setText(null);
        txtStDob.setText(null);
        txtStGender.setText(null);

        txtCode.setText(null);
        txtCName.setText(null);
        txtCRupees.setText(null);
        txtCIntake.setText(null);
        txtCDuration.setText(null);

        txtRegNo.setText(null);
        txtRegFees.setText(null);
        txtRegDate.setText(null);

    }
    public void cmbCourseNameOnAction(ActionEvent actionEvent) {
        try {
            txtCName.setText(cmbCourseName.getSelectionModel().getSelectedItem().toString());
        }catch (NullPointerException ex){}
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

    public void cmbCourseCodeOnAction(ActionEvent actionEvent) throws Exception {
        try {
            CourseDTO courseDTO= courseBO.getCourse(cmbCourseCode.getSelectionModel().getSelectedItem().toString());
            System.out.println(courseDTO);
            if (courseDTO!=null){
                txtCode.setText(courseDTO.getCourseCode());
                txtCName.setText(courseDTO.getCourseName());
                txtCIntake.setText(courseDTO.getCourseIntake());
                txtCRupees.setText(courseDTO.getCourseFee()+"");
                txtCDuration.setText(courseDTO.getCourseDuration());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }catch (NullPointerException ex){
            txtCode.setText(null);
            txtCName.setText(null);
            txtCIntake.setText(null);
            txtCRupees.setText(null);
            txtCDuration.setText(null);
        }

    }
    public void addValuesToCmbCourses() throws Exception {
        cmbCourseCode.getItems().clear();
        cmbCourseCode.getItems().add(new String("None"));
        try {
            ArrayList<CourseDTO> courseDTOArrayList = courseBO.getAllCourse();
            for (CourseDTO c : courseDTOArrayList) {
                cmbCourseCode.getItems().add(c.getCourseCode());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void addValuesToCmbStudent() throws Exception {
        cmbStID.getItems().clear();
        cmbStID.getItems().add(new String("None"));
        try {
            ArrayList<StudentDTO> studentDTOArrayList = studentBO.getAllStudent();
            for (StudentDTO studentDTO : studentDTOArrayList) {
                cmbStID.getItems().add(studentDTO.getStId());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void addValuesToCmbReg() throws Exception {
        cmbRegNo.getItems().clear();
        cmbRegNo.getItems().add(new String("None"));
        try {
            ArrayList<RegistrationDTO> registrationDTOArrayList = registrationBO.getAllRegister();
            for (RegistrationDTO registrationDTO : registrationDTOArrayList) {
                cmbRegNo.getItems().add(registrationDTO.getRegNo());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void cmbStIDOnAction(ActionEvent actionEvent) throws Exception {
        try {
            StudentDTO studentDTO= studentBO.getStudent(cmbStID.getSelectionModel().getSelectedItem().toString());
            System.out.println(studentDTO);
            if (studentDTO!=null){
                txtStId.setText(studentDTO.getStId());
                txtStName.setText(studentDTO.getStName());
                txtStAddress.setText(studentDTO.getStAddress());
                txtStContact.setText(studentDTO.getStContact());
                txtStDob.setText(studentDTO.getStDob());
                txtStGender.setText(studentDTO.getStGender());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }catch (NullPointerException ex){
            txtStId.setText(null);
            txtStName.setText(null);
            txtStAddress.setText(null);
            txtStContact.setText(null);
            txtStDob.setText(null);
            txtStGender.setText(null);
        }
    }
    public void cmbRegNoOnAction(ActionEvent actionEvent) throws Exception {
        try {
            RegistrationDTO registrationDTO= registrationBO.getRegister(cmbRegNo.getSelectionModel().getSelectedItem().toString());
            System.out.println(registrationDTO);
            if (registrationDTO!=null){
                txtRegNo.setText(registrationDTO.getRegNo());
                txtRegDate.setText(registrationDTO.getRegDate());
                txtRegFees.setText(registrationDTO.getRegFee()+"");
                txtStId.setText(registrationDTO.getStID());
                txtCode.setText(registrationDTO.getCourseCode());
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }catch (NullPointerException ex){
            txtRegNo.setText(null);
            txtRegDate.setText(null);
            txtRegFees.setText(null);
            txtStId.setText(null);
            txtCode.setText(null);
        }
    }

    public void txtRegNoOnAction(ActionEvent actionEvent) {
    }

    public void txtRegFeesOnAction(ActionEvent actionEvent) {
    }

    public void txtRegDateOnAction(ActionEvent actionEvent) {
    }
}
