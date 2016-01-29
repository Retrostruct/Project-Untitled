package retrostruct.epsilon.desktop;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GdxGame.VIRTUAL_WIDTH;
		config.height = GdxGame.VIRTUAL_HEIGHT;
		new LwjglApplication(new GdxGame(), config);
	}
}