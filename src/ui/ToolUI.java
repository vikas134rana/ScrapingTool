package ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ToolUI extends Application {

	public static void main(String[] args) {
		launch(args);
	}

//	@Override
	public void start1(Stage stage) throws Exception {

		StackPane pane = new StackPane();

		Button button = new Button();
		button.setText("Click Me!");
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				System.out.println("Hello World");

			}
		});

		pane.getChildren().add(button);

		Scene scene = new Scene(pane, 500, 300);
		stage.setTitle("First JavaFX App");
		stage.setScene(scene);
		stage.show();

	}

	@Override
	public void start(Stage stage) throws Exception {

		GridPane pane = new GridPane();
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(40));
		pane.setHgap(10);
		pane.setVgap(10);

		Label usernameLabel = new Label("UserName");
		TextField usernameTextField = new TextField();

		Label passwordLabel = new Label("Password");
		PasswordField passwordTextField = new PasswordField();

		Button loginButton = new Button("Login");

		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				String username = usernameTextField.getText();
				String password = passwordTextField.getText();
				System.out.println("username: " + username);
				System.out.println("password: " + password);
			}
		});

		pane.add(usernameLabel, 0, 0);
		pane.add(usernameTextField, 1, 0);

		pane.add(passwordLabel, 0, 1);
		pane.add(passwordTextField, 1, 1);

		pane.add(loginButton, 1, 2);

		Scene scene = new Scene(pane, 500, 300);
		stage.setTitle("First JavaFX App");
		stage.setScene(scene);
		stage.show();

	}

}
