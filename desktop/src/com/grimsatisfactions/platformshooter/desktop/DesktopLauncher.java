package com.grimsatisfactions.platformshooter.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.grimsatisfactions.platformshooter.Main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1440;
		config.height = 900;
		config.backgroundFPS = 60;
		config.foregroundFPS = 60;
		new LwjglApplication(new Main(), config);
	}
}
