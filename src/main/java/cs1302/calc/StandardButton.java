package cs1302.calc;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.geometry.Insets;

public class StandardButton extends Button {
	
	private String originalStyle;
	private InputField inputField;
	
	/**
	 * Constructor for StandardButton. These are buttons that display their identifier in the output field when pressed.
	 * @param inputField the input field to which the StandardButton needs access
	 */
	public StandardButton(InputField inputField) {
		super();
		configureStandardButton(inputField);
	} // constructor
	
//_______________Helper Methods________________

	/**
	 * Configures the StandardButton.
	 * @param inputField the inputField to which the StandardButton needs access
	 */
	private void configureStandardButton(InputField inputField) {
		setInputField(inputField);
		setMaxWidth(Double.MAX_VALUE);
		setPadding(new Insets(15, 30, 15, 30));
		setEffect(new DropShadow());
		setOriginalStyle(ButtonStyles.STYLE_1);
		setStyle(originalStyle);
		setOnMousePressed(event -> setStyle(ButtonStyles.STYLE_PRESSED));
		setOnMouseReleased(event -> {
			setStyle(originalStyle);
			sendTextToInputField();
		});
	} // configureStandardButton
	
	/**
	 * Sends identifier text of button to input field.
	 */
	private void sendTextToInputField() {
		String lastTextFieldChar;
		if(!inputField.getText().isEmpty()) {
			lastTextFieldChar = "" + inputField.getText().charAt(inputField.getText().length()-1);
		} else {
			lastTextFieldChar = "";
		} 
		if(!getText().matches("[0-9]")) {
			inputField.appendText(" " + getText());
		} else {
			if(lastTextFieldChar.matches("[0-9]") || lastTextFieldChar.isEmpty()) {
				inputField.appendText(getText());
			} else {
				inputField.appendText(" " + getText());
			}
		}
	} // sendTextToInputField

//__________________Getters______________________
	
	public String getOriginalStyle() {
		return this.originalStyle;
	}
	
	public InputField getInputField() {
		return this.inputField;
	}
	
//__________________Setters______________________
	
	public void setOriginalStyle(String style) {
		this.originalStyle = style;
	}
	
	public void setInputField(InputField inputField) {
		this.inputField = inputField;
	}
	
} // StandardButton
