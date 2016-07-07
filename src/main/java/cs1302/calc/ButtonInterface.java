package cs1302.calc;

import javafx.scene.layout.GridPane;

public class ButtonInterface extends GridPane {
	
	private final String[][] layout = {
			{"C", "«", "»", "<"},
			{"7", "8", "9", "+", "*", "!"},
			{"4", "5", "6", "-", "/", "^"},
			{"1", "2", "3", "Use Recursion"},
			{"0",    "=",    "Hide Binary"}
	}; // template of ButtonInterface
	
	private InputField inputField;
	private OutputField outputField;
	private BinaryField binaryField;
	
	/**
	 * Constructor for ButtonInterface.
	 * @param inputField the input field to which the ButtonInterface needs access
	 * @param outputField the output field to which the ButtonInterface needs access
	 * @param binaryField the binary field to which the ButtonInterface needs access
	 */
	public ButtonInterface(InputField inputField, OutputField outputField, BinaryField binaryField) {
		super();
		configureButtonInterface(inputField, outputField, binaryField);
		fillButtonInterface();
	} // constructor
	
//_____________Helper Methods______________
	
	/**
	 * Configures the ButtonInterFace.
	 * @param inputField the input field to which the ButtonInterface needs access
	 * @param outputField the output field to which the ButtonInterface needs access
	 * @param binaryField the binary field to which the ButtonInterface needs access
	 */
	private void configureButtonInterface(InputField inputField, OutputField outputField, BinaryField binaryField) {
		setInputField(inputField);
		setOutputField(outputField);
		setBinaryField(binaryField);
		setHgap(8);
		setVgap(8);
		setStyle("-fx-background-color: #333333");
	} // configureButtonInterface
	
	/**
	 * Fills ButtonInterface in correspondence with the button layout design.
	 */
	private void fillButtonInterface() {
		for(int i = 0; i < layout.length; i++) {
			for(int j = 0; j < layout[i].length; j++) {
				switch(layout[i][j]) {
					case "=": 
						UtilityButton b_Equals = createUtilityButton(layout[i][j]);
						setConstraints(b_Equals, j, i, 2, 1);
						getChildren().add(b_Equals);
						break;
					case "<": 
						add(createUtilityButton(layout[i][j]), j+2, i);
						break;
					case "C": 
						add(createUtilityButton(layout[i][j]), j, i);
						break;
					case "Use Recursion": 
						UtilityButton b_UseRecursion = createUtilityButton(layout[i][j]);
						setConstraints(b_UseRecursion, j, i, 3, 1);
						getChildren().add(b_UseRecursion);
						break;
					case "Hide Binary":
						UtilityButton b_HideBinary = createUtilityButton(layout[i][j]);
						setConstraints(b_HideBinary, j+1, i, 3, 1);
						getChildren().add(b_HideBinary);
						break;
					case "«":
						StandardButton b_ShiftLeft = createStandardButton(layout[i][j]);
						setConstraints(b_ShiftLeft, j, i, 2, 1);
						getChildren().add(b_ShiftLeft);
						break;
					case "»":
						StandardButton b_ShiftRight = createStandardButton(layout[i][j]);
						setConstraints(b_ShiftRight, j+1, i, 2, 1);
						getChildren().add(b_ShiftRight);
						break;
					default: 
						add(createStandardButton(layout[i][j]), j, i);
				} // switch
			} // for
		} // for
	} // fillButtonInterface
	
	/**
	 * Creates a StandardButton, with text color depending on button identifier.
	 * @param text the text to be passed into the constructor for the button
	 * @return a StandardButton
	 */
	private StandardButton createStandardButton(String text) {
		StandardButton b = new StandardButton(this.inputField);
		b.setText(text);
		if(!text.matches("[0-9]")) {
			b.setOriginalStyle(ButtonStyles.STYLE_2);
			b.setStyle(ButtonStyles.STYLE_2);
		}
		return b;
	} // createStandardButton
	
	/**
	 * Creates a UtilityButton.
	 * @param text the text to be passed into the constructor for the button
	 * @return a UtilityButton
	 */
	private UtilityButton createUtilityButton(String text) {
		UtilityButton b = new UtilityButton(this.inputField, this.outputField, this.binaryField);
		b.setText(text);
		b.configureUtilityButton(text);
		return b;
	} // createUtilityButton
	
//_____________Getters________________
	
	public InputField getInputField() {
		return this.inputField;
	}
	
	public OutputField getOutputField() {
		return this.outputField;
	}
	
	public BinaryField getBinaryField() {
		return this.binaryField;
	}
	
	public String[][] getLayout() {
		return this.layout;
	}
	
//_____________Setters________________
	
	public void setInputField(InputField inputField) {
		this.inputField = inputField;
	}
	
	public void setOutputField(OutputField outputField) {
		this.outputField = outputField;
	}
	
	public void setBinaryField(BinaryField binaryField) {
		this.binaryField = binaryField;
	}
	
	// there is no setLayout() method due to the property's intended immutable nature
	
} // ButtonInterface
