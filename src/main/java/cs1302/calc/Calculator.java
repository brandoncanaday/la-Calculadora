package cs1302.calc;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class Calculator extends VBox {
	
	private final InputField inputField;
	private final OutputField outputField;
	private final BinaryField binaryField;
	private final ButtonInterface buttonInterface;

	/**
	 * Constructor for Calculator.
	 */
	public Calculator() {
		super();
		this.inputField = new InputField();
		this.outputField = new OutputField();
		this.binaryField = new BinaryField(this.outputField);
		this.buttonInterface = new ButtonInterface(this.inputField, this.outputField, this.binaryField);
		configureCalculator();
		getChildren().addAll(inputField, outputField, binaryField, buttonInterface);
	} // constructor
	
//______________Helper Methods_______________
	
	/**
	 * Configures the calculator.
	 */
	private void configureCalculator() {
		setSpacing(8);
		setPadding(new Insets(10));
		setStyle("-fx-background-color: #333333;");
	} // configureCalculator
	
} // Calculator
