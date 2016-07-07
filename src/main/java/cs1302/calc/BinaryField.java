package cs1302.calc;

import java.lang.Math;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

public class BinaryField extends HBox {
	
	private OutputField outputField;
	private Label[] binaryToggles;
	
	/**
	 * Constructor for BinaryField.
	 * @param outputField the output field to which the BinaryField needs access
	 */
	public BinaryField(OutputField outputField) {
		super();
		setOutputField(outputField);
		setBinaryToggles(makeBinaryToggles());
		configureBinaryField();
	} // constructor
	
//_________________Other Methods_____________________
	
	/**
	 * Updates the toggles to represent the result from output field.
	 * @param result the result to convert to binary for the toggles
	 */
	public void updateToggles(int result) {
		String binaryForm = Integer.toBinaryString(result);
		for(int i = binaryToggles.length-1, j = 0; i >= 0; i--) {
			if(i > binaryForm.length()-1) {
				binaryToggles[i].setText("0");
			} else {
				binaryToggles[i].setText("" + binaryForm.charAt(j));
				j++;
			}
			if(binaryToggles[i].getText().equals("1")) {
				binaryToggles[i].setTextFill(Color.CRIMSON);
			} else {
				binaryToggles[i].setTextFill(Color.BLACK);
			}
		}
	} // updateToggles
	
	/**
	 * Resets the binary toggles by setting the text to all 0's.
	 */
	public void resetToggles() {
		for(Label l : binaryToggles) {
			l.setText("0");
			l.setTextFill(Color.BLACK);
		}
	} // resetToggles
	
//_________________Helper Methods____________________
	
	/**
	 * Configures the binary field.
	 */
	private void configureBinaryField() {
		setStyle("-fx-background-color: #ece8d5; -fx-effect: innershadow(gaussian, #333333, 10, 0, 5, 5);");
		setAlignment(Pos.CENTER_RIGHT);
		setMaxWidth(Double.MAX_VALUE);
		setPadding(new Insets(14, 10, 10, 10));
		for(int i = binaryToggles.length-1; i >= 0; i--) {
			getChildren().add(binaryToggles[i]);
		}
		for(Label l : binaryToggles) {
			l.setOnMouseReleased(event -> {
				toggleText(l);
				outputField.setText("" + evaluateToggles());
			});
		}
	} // configureBinaryField
	
	/**
	 * Creates an array of 32 labels with initial text of "0".
	 * @return an array of Labels, with each Label corresponding to a bit
	 */
	private Label[] makeBinaryToggles() {
		Label[] toggles = new Label[31]; // because 32-bit implementation
		for(int i = 0; i < toggles.length; i++) {
			toggles[i] = new Label();
			toggles[i].setFont(Font.font("Courier New", 24));
			toggles[i].setText("0");
			toggles[i].setTextFill(Color.BLACK);
		}
		return toggles;
	} // makeBinaryToggles
	
	/**
	 * Toggles text of binary label to either 1 or 0.
	 * @param l the label to toggle
	 */
	private void toggleText(Label l) {
		if(l.getText().equals("0")) {
			l.setText("1");
			l.setTextFill(Color.CRIMSON);
		} else {
			l.setText("0");
			l.setTextFill(Color.BLACK);
		} 
	} // toggleText
	
	/**
	 * Evaluates binary toggles.
	 * @return the decimal value
	 */
	private int evaluateToggles() {
		int result = 0;
		for(int i = binaryToggles.length-1; i >= 0; i--) {
			if(binaryToggles[i].getText().equals("1")) {
				result += Math.pow(2, i); 
			}
		}
		return result;
	} // evaluateToggles
	
//____________________Getters______________________
	
	public OutputField getOutputField() {
		return this.outputField;
	}
	
	public Label[] getBinaryToggles() {
		return this.binaryToggles;
	}
	
//____________________Setters______________________
	
	public void setOutputField(OutputField outputField) {
		this.outputField = outputField;
	}
	
	public void setBinaryToggles(Label[] binaryToggles) {
		this.binaryToggles = binaryToggles;
	}

} // BinaryField
