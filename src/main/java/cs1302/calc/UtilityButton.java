package cs1302.calc;

public class UtilityButton extends StandardButton {

	private enum Function {
		EQUALS, BACKSPACE, CLEAR, USE_RECURSION, HIDE_BINARY;
	} // Function
	
	private OutputField outputField;
	private BinaryField binaryField;
	private Function function;
	private boolean isPressed;
	private Math recursiveMath;
	private Math iterativeMath;
	private static boolean useRecursion = false;
	
	/**
	 * Constructor for UtilityButton. These are buttons that do not display their identifier in the output field when pressed, but perform various
	 * other functions instead.
	 * @param inputField the input field to which the UtilityButton needs access
	 * @param outputField the output field to which the UtilityButton needs access
	 * @param binaryField the binary field to which the UtilityButton needs access
	 */
	public UtilityButton(InputField inputField, OutputField outputField, BinaryField binaryField) {
		super(inputField);
		setOutputField(outputField);
		setBinaryField(binaryField);
	} // constructor
	
//__________Other Methods____________
	
	/**
	 * Configures the UtilityButton.
	 * @param text the text which determines functionality
	 */
	public void configureUtilityButton(String text) {
		switch(text) {
			case "=": setFunction(Function.EQUALS); break;
			case "<": setFunction(Function.BACKSPACE); break;
			case "C": setFunction(Function.CLEAR); break;
			case "Use Recursion": setFunction(Function.USE_RECURSION); break;
			case "Hide Binary": setFunction(Function.HIDE_BINARY);
		} 
		setIsPressed(false);
		setRecursiveMath(new RecursiveMath());
		setIterativeMath(new IterativeMath());
		setStyle(ButtonStyles.STYLE_3);
		configMousePressAction();
		configMouseReleaseAction();
	} // configureUtilityButton
	
//__________Helper Methods____________
	
	/**
	 * Configures the action for when the mouse is pressed.
	 */
	private void configMousePressAction() {
		setOnMousePressed(event -> { 
			setStyle(ButtonStyles.STYLE_PRESSED);
			if(!isPressed) { 
				setIsPressed(true);  
			} else {
				setIsPressed(false);
			} 
		});
	} // configMousePressAction
	
	/**
	 * Configures the action for when the mouse is released.
	 */
	private void configMouseReleaseAction() {
		setOnMouseReleased(event -> {
			if(function == Function.EQUALS) {
				setStyle(ButtonStyles.STYLE_3);
				equals();
			} else if(function == Function.BACKSPACE) {
				setStyle(ButtonStyles.STYLE_3);
				backspace();
			} else if(function == Function.CLEAR) {
				setStyle(ButtonStyles.STYLE_3);
				clear();
			} else if(function == Function.USE_RECURSION) {
				toggleRecursion();
				if(!isPressed) {
					setStyle(ButtonStyles.STYLE_3);
				} // if
			} else if(function == Function.HIDE_BINARY) {
				toggleBinary();
				if(!isPressed) {
					setStyle(ButtonStyles.STYLE_3);
				} 
			} // if/else
		});
	} // configMouseReleaseAction
	
	/**
	 * Evaluates expression in input field.
	 */
	private void equals() {
		String expression = getInputField().getText().trim(); // contains infix version of math expression displayed in input field
		if(!expression.isEmpty()) {
			String[] infixArray = expression.split(" "); // converts the expression into an array, using white space as delimiter
			String[] postfixArray = ReversePolishNotation.infixToPostfix(infixArray); // converts infix to postfix
			Math math; // math object type depends on toggled state of "Use Recursion" button
			if(useRecursion) {
				math = this.recursiveMath;
			} else {							
				math = this.iterativeMath;
			} // if/else
			try {
				int result = ReversePolishNotation.evaluate(math, postfixArray); // result to display in output field
				outputField.setText("" + result); 
				binaryField.updateToggles(result);
			} catch(StackOverflowError oe) {
				Driver.showErrorPopUp("StackOverFlowError. Too many recursive calls.");
				System.out.println(oe);
			} catch(MalformedPostfixException pe) {
				Driver.showErrorPopUp("MalformedPostfixException. Unable to evaluate expression as typed.");
				System.out.println(pe);
			} catch(ArithmeticException ae) {
				Driver.showErrorPopUp("ArithmeticException. One or more invalid math operations.");
				System.out.println(ae);
			} // try/catch
		}
	} // equals
	
	/**
	 * Removes the most recent identifier typed into input field.
	 */
	private void backspace() {
		String currentInput = getInputField().getText();
		String backspacedInput;
		String lastChar;
		if(!currentInput.isEmpty()) {
			lastChar = "" + currentInput.charAt(currentInput.length()-1);
		} else {
			lastChar = "";
		} 
		if(lastChar.matches("[0-9]")) {
			if(currentInput.length() > 1 && currentInput.charAt(currentInput.length()-2) == ' ') {
				backspacedInput = currentInput.substring(0, currentInput.length()-2);
			} else {
				backspacedInput = currentInput.substring(0, currentInput.length()-1);
			}
		} else if(lastChar.equals("")) {
			backspacedInput = "";
		} else {
			backspacedInput = currentInput.substring(0, currentInput.length()-2);
		}
		getInputField().setText(backspacedInput);
	} // backspace
	
	/**
	 * Sets input field and binary field to 0.
	 */
	private void clear() {
		getInputField().setText("");
		outputField.setText("");
		binaryField.resetToggles();
	} // clear
	
	/**
	 * Toggles whether or not recursive implementation of math functions should be used.
	 */
	private void toggleRecursion() {
		if(useRecursion) {
			setUseRecursion(false);
		} else {
			setUseRecursion(true);
		}
	} // useRecursion
	
	/**
	 * Toggles visibility of the binary field.
	 */
	private void toggleBinary() {
		if(binaryField.isVisible()) {
			binaryField.setVisible(false);
		} else {
			binaryField.setVisible(true);
		}
	} // hideBinary
	
//___________Getters___________
	
	public OutputField getOutputField() {
		return this.outputField;
	}
	
	public BinaryField getBinaryField() {
		return this.binaryField;
	}
	
	public Function getFunction() {
		return this.function;
	}
	
	public boolean getIsPressed() {
		return this.isPressed;
	}
	
	public boolean getUseRecursion() {
		return useRecursion;
	}
	
	public Math getMathImplementation() {
		if(useRecursion) {
			return this.recursiveMath;
		} else {
			return this.iterativeMath;
		}
	}
	
//___________Setters___________
	
	public void setOutputField(OutputField outputField) {
		this.outputField = outputField;
	}
	
	public void setBinaryField(BinaryField binaryField) {
		this.binaryField = binaryField;
	}
	
	public void setFunction(Function function) {
		this.function = function;
	}
	
	public void setIsPressed(boolean value) {
		this.isPressed = value;
	}
	
	public void setUseRecursion(boolean value) {
		useRecursion = value;
	}
	
	public void setRecursiveMath(Math recursiveImplementation) {
		this.recursiveMath = recursiveImplementation;
	}
	
	public void setIterativeMath(Math iterativeImplementation) {
		this.iterativeMath = iterativeImplementation;
	}
	
} // UtilityButton
