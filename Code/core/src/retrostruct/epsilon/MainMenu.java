package retrostruct.epsilon;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.enums.MainMenuOptions;

public class MainMenu {
	
	private static MainMenuOptions selectedOptions = MainMenuOptions.NEW_GAME;

	public static MainMenuOptions update() {
		return selectedOptions;
	}

	public static void render(SpriteBatch batch) {
		
	}

}
