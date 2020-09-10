//Programmer Mindula Dilthushan
//Product Company Alpha X Software Solution
//Kingsland Project
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/loarding/LoadingForm.fxml"))));
        //primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Lording Form");
        primaryStage.centerOnScreen();
        primaryStage.show();
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Stage window = (Stage) primaryStage.getScene().getWindow();
                            primaryStage.centerOnScreen();
                            try {
                                window.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("/view/dashbord/MainForm.fxml"))));
                                primaryStage.setTitle("DashBord Form");
                                primaryStage.centerOnScreen();
                                primaryStage.show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            },500);
    }
}
