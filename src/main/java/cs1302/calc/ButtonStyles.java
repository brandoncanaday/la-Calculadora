package cs1302.calc;

/**
 * This class provides a concise way to set styles of various nodes using the setStyle() method and CSS.
 * @author Brandon Canaday
 */
public class ButtonStyles {

	// used for numeric StandardButtons
	public static final String STYLE_1 = "-fx-font: 22px 'Courier New'; -fx-text-fill: #96cdcd; " +
								  		 "-fx-background-color: linear-gradient(#817e7e 2%, #383838 25%, #333333 75%, #222222 95%, #000000 100%); " +
								  		 "-fx-focus-color: #000000;" +
								  		 "-fx-border-radius: 5";
	
	// used for operational StandardButtons
	public static final String STYLE_2 = "-fx-font: 22px 'Courier New'; -fx-text-fill: #f08080; " +
			 						     "-fx-background-color: linear-gradient(#817e7e 2%, #383838 25%, #333333 75%, #222222 95%, #000000 100%); " +
			 						     "-fx-focus-color: #000000;" +
			 						     "-fx-border-radius: 5"; 
	
	// used for UtilityButtons
	public static final String STYLE_3 = "-fx-font: 22px 'Courier New'; -fx-text-fill: #85f4a9; " +
	  		 							 "-fx-background-color: linear-gradient(#817e7e 2%, #383838 25%, #333333 75%, #222222 95%, #000000 100%); " +
	  		 							 "-fx-focus-color: #000000;" +
	  		 							 "-fx-border-radius: 5";
	
	// used for all buttons upon being pressed
	public static final String STYLE_PRESSED = "-fx-font: 21px 'Courier New'; -fx-text-fill: #ffffff; " +
		    						    	   "-fx-effect: innershadow(gaussian, #000000, 10, 0, 5, 5);" +
		    						    	   "-fx-background-color: linear-gradient(#817e7e 2%, #383838 25%, #333333 75%, #222222 95%, #000000 100%); " +
		    						    	   "-fx-focus-color: #000000;" +
		    						    	   "-fx-border-radius: 5";
} // ButtonStyles
