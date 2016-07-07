package cs1302.calc;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class InputField extends TextField {
	
	/**
	 * Constructor for InputField.
	 */
	public InputField() {
		super();
		configureInputField();
	} // constructor
	
//_______________Helper Methods__________________
	
	/**
	 * Configures the InputField.
	 */
	private void configureInputField() {
		setEditable(false);
		setAlignment(Pos.CENTER_RIGHT);
		setFont(Font.font("Courier New", 30));
		setMaxWidth(Double.MAX_VALUE);
		setStyle("-fx-background-color: #ece8d5; -fx-effect: innershadow(gaussian, #333333, 10, 0, 5, 5);");
	} // configureInputField
	
} // InputField
