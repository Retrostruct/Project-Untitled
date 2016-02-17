package retrostruct.epsilon.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import retrostruct.epsilon.GdxGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// Set the width and height of the game
		config.width = GdxGame.VIRTUAL_WIDTH;
		config.height = GdxGame.VIRTUAL_HEIGHT;
		new LwjglApplication(new GdxGame(), config);
	}
}