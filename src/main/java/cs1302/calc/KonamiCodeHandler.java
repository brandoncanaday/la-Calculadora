package cs1302.calc;

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.layout.BorderPane;

public class KonamiCodeHandler implements EventHandler<KeyEvent> {
	
	private List<KeyCode> correctSequence;
	private List<KeyCode> keyInputs;
	private int index;
	
	/**
	 * Constructor for KonamiCodeHandler
	 */
	public KonamiCodeHandler() {
		this.correctSequence = new ArrayList<KeyCode>();
		this.keyInputs = new ArrayList<KeyCode>();
		this.index = 0;
		
		correctSequence.add(KeyCode.UP);
		correctSequence.add(KeyCode.UP);
		correctSequence.add(KeyCode.DOWN);
		correctSequence.add(KeyCode.DOWN);
		correctSequence.add(KeyCode.LEFT);
		correctSequence.add(KeyCode.RIGHT);
		correctSequence.add(KeyCode.LEFT);
		correctSequence.add(KeyCode.RIGHT);
		correctSequence.add(KeyCode.B);
		correctSequence.add(KeyCode.A);
		// this was the best way to initialize an ArrayList I could find. all other ways involved returning an immutable list
		 
	} // constructor
	
	@Override
	public void handle(KeyEvent event) {
		if(event.getCode() == correctSequence.get(index)) {
			keyInputs.add(event.getCode());
			index++;
		} else {
			keyInputs.clear();
			index = 0;
		}
		if(keyInputs.size() == correctSequence.size()) {
			keyInputs.clear();
			index = 0;
			showSurpriseGame();
		}
	} // handle
	
	//_____________Getters_________________
	
	public List<KeyCode> getCorrectSequence() {
		return this.correctSequence;
	}
	
	public List<KeyCode> getKeyInputs() {
		return this.keyInputs;
	}
	
	//______________Setters______________
	
	public void setCorrectSequence(List<KeyCode> correctSequence) {
		this.correctSequence = correctSequence;
	}
	
	public void setKeyInputs(List<KeyCode> keyInputs) {
		this.keyInputs = keyInputs;
	}
	
	//______________Other Methods________________
	
	/**
	 * Displays the stage that contains the surprise game.
	 */
	private void showSurpriseGame() { // TODO: actually implement pong game
		Stage stage = new Stage();
		BorderPane root = new BorderPane();
		
		stage.setScene(new Scene(root));
		stage.setTitle("PONG");
		stage.show();
	} // showSurpriseGame
	
} // KonamiCodeHandler
