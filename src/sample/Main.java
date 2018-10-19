package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //FXMLLoader loader = new FXMLLoader();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        //Controller controller = loader.getController();

        primaryStage.setTitle("Tablica Judo");
        primaryStage.setScene(new Scene(root, bounds.getWidth() - 1.5, bounds.getHeight() - 25.5));
        primaryStage.show();
        //primaryStage.setOnHidden(x -> controller.exit());
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
