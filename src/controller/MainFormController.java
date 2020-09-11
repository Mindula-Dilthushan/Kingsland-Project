package controller;

import com.jfoenix.controls.JFXButton;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainFormController implements Initializable {
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnClose;
    public JFXButton btnAddNewSt;
    public JFXButton btnAddNewCourse;
    public TableView tblStMain;
    public TableColumn colStId;
    public TableColumn colStName;
    public TableColumn colStAddress;
    public TableColumn colStContact;
    public TableColumn colStDob;
    public TableColumn colStGender;
    public TableView tblCourseMain;
    public TableColumn colCoruseCode;
    public TableColumn colCoruseName;
    public TableColumn colCoruseIntake;
    public TableColumn colCoruseFees;
    public TableColumn colCoruseDuration;
    public AnchorPane MainAnchor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        generateDateTime();
       // loadAllCustomers();

        colStId.setCellValueFactory(new PropertyValueFactory("stId"));
        colStName.setCellValueFactory(new PropertyValueFactory("stName"));
        colStAddress.setCellValueFactory(new PropertyValueFactory("stAddress"));
        colStContact.setCellValueFactory(new PropertyValueFactory("stContact"));
        colStDob.setCellValueFactory(new PropertyValueFactory("stDob"));
        colStGender.setCellValueFactory(new PropertyValueFactory("stGender"));

    }

    private void loadAllCustomers() throws Exception {
        /*ObservableList<StudentTM> tmList =
                FXCollections.observableArrayList();
        List<StudentDTO> allStudent = bo.getAllCustomers();
        for (StudentDTO studentDTO : allCustomers){

            StudentTM studentTM = new StudentTM(dto.getId(), dto.getName(), dto.getAddress());

            tmList.add(tm);

        }
        tblCourseMain.setItems(tmList);


         */
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

    public void btnAddNewCourseOnAction(ActionEvent actionEvent) throws IOException {
        SetUI("AddCourseForm.fxml");
    }

    public void btnAddNewStOnAction(ActionEvent actionEvent) throws IOException {
        SetUI("AddNewStudentForm.fxml");
    }

    public void SetUI(String location) throws IOException {
        MainAnchor.getChildren().clear();
        AnchorPane load = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/view/" + location));
        MainAnchor.getChildren().addAll(load.getChildren());
    }
}
