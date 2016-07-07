package cs1302.calc;

import javafx.application.Application;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Insets;
import javafx.scene.image.Image;

public class Driver extends Application {
	
	public static void main(String[] args) {
		launch(args);
	} // main

	@Override
	public void start(Stage primaryStage) {
		Calculator root = new Calculator();
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(new KonamiCodeHandler());
		configureStage(primaryStage, scene);
		primaryStage.show();
	} // start
	
//_________Other Methods___________
	
	/**
	 * Utility method that displays an error pop-up window.
	 * @param errorMessage the message to be displayed
	 */
	public static void showErrorPopUp(String errorMessage) {
		Stage errorStage = new Stage(StageStyle.UTILITY);
		
		BorderPane root = new BorderPane();
		root.setCenter(new Label(errorMessage));; 
		root.setPadding(new Insets(20, 50, 20, 50));
		
		Scene scene = new Scene(root);
		
		errorStage.setScene(scene);
		errorStage.setTitle("ERROR");
		errorStage.getIcons().add(new Image("file:resources/calculator.png")); 
		errorStage.initModality(Modality.APPLICATION_MODAL);
		errorStage.show();
	} // showErrorPopUp
	
//_________Helper Methods__________
	
	/**
	 * Configure stage.
	 * @param stage the stage to be configured
	 * @param scene the scene to be set
	 */
	private void configureStage(Stage stage, Scene scene) {
		stage.setTitle("La Calculadora");
		stage.getIcons().add(new Image("file:resources/calculator.png")); 
		stage.setScene(scene);
		stage.setResizable(false);
		stage.sizeToScene();
	} // configureStage
	
} // Driver
