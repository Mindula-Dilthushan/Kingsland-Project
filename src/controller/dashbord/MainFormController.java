package controller.dashbord;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainFormController {
    public AnchorPane anchorDashBord;
    public JFXButton btnStudent;
    public JFXButton btnCourse;
    public JFXButton btnClose;

    public void btnCourseOnAction(ActionEvent actionEvent) throws IOException {
        anchorDashBord.getChildren().clear();
        AnchorPane load = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/view/dashbord/CourseForm.fxml"));
        anchorDashBord.getChildren().addAll(load.getChildren());
    }

    public void btnStudentOnAction(ActionEvent actionEvent) throws IOException {
        anchorDashBord.getChildren().clear();
        AnchorPane load = (AnchorPane) FXMLLoader.load(this.getClass().getResource("/view/dashbord/StudentForm.fxml"));
        anchorDashBord.getChildren().addAll(load.getChildren());
    }

    public void btnCloseOnAction(ActionEvent actionEvent) {
        Stage exit_stage = (Stage) btnClose.getScene().getWindow();
        exit_stage.close();
    }
}
