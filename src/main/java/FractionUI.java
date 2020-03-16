import com.aquafx_project.AquaFx;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FractionUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fractionui.fxml"));
        primaryStage.setTitle("FractionUI");
        primaryStage.setScene(new Scene(root, 1280, 720));
        primaryStage.show();
        AquaFx.style();
    }
}
