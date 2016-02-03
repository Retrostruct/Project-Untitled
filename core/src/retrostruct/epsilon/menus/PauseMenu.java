package retrostruct.epsilon.menus;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import retrostruct.epsilon.enums.PauseMenuOptions;

public class PauseMenu {
	
	private static PauseMenuOptions selectedOption = PauseMenuOptions.CONTINUE;
	
	public static PauseMenuOptions update() {
		return selectedOption;
	}
	
	public static void render(SpriteBatch batch) {
		
	}

}
