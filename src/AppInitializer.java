import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/MainForm.fxml"))));
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Lording Form");
        primaryStage.centerOnScreen();
        primaryStage.show();

    }
}
