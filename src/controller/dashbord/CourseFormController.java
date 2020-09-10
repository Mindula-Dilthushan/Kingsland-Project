package controller.dashbord;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

public class CourseFormController {
    public AnchorPane anchorDashBord;
    public JFXButton btnAddCourse;
    public JFXButton btnClear;
    public JFXButton btnClose;
    public JFXTextField txtCode;
    public JFXTextField txtCName;
    public JFXTextField txtCIntake;
    public JFXTextField txtCRupees;
    public JFXTextField txtCDuration;
    public JFXComboBox cmbCName;
    public TableView tblCourseMain;
    public TableColumn colCode;
    public TableColumn colName;
    public TableColumn colIntake;
    public TableColumn colFee;
    public TableColumn colDuration;

    public void btnCloseOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnAddCourseOnAction(ActionEvent actionEvent) {
    }
}
