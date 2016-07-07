package cs1302.calc;

import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class OutputField extends TextField {

	/**
	 * Constructor for OutputField.
	 */
	public OutputField() {
		super();
		configureOutputField();
	} // constructor
	
//______________Helper Methods_______________
	
	/**
	 * Configures the OutputField.
	 */
	private void configureOutputField() {
		setEditable(false);
		setAlignment(Pos.CENTER_RIGHT);
		setFont(Font.font("Courier New", 30));
		setMaxWidth(Double.MAX_VALUE);
		setStyle("-fx-background-color: #ece8d5; -fx-effect: innershadow(gaussian, #333333, 10, 0, 5, 5);");
	} // configureOutputField
	
} // OutputField
