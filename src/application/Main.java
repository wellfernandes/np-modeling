package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import wellfernandes.com.github.controller.ControllerPrincipalView;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {

			stage.setTitle("NP Modeling Tool");
			stage.setResizable(false);

			FXMLLoader loaderView = new FXMLLoader(
					getClass().getResource("/wellfernandes/com/github/view/PrincipalView.fxml"));

			Parent parentXML = loaderView.load();
			Scene scene = new Scene(parentXML);
			stage.setScene(scene);

			ControllerPrincipalView controllerPrincipalView = loaderView.getController();

			stage.setOnCloseRequest(e -> {
				if (controllerPrincipalView.onCloseQuery()) {
					System.exit(0);
				} else {
					e.consume();
				}
			});
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		System.setProperty("org.graphstream.ui", "javafx");
		launch(args);
	}
}
