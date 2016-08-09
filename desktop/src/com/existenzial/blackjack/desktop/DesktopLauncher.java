package com.existenzial.blackjack.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.existenzial.blackjack.Blackjack;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

		config.title = "Blackjack";
		config.width = 800;
		config.height = 480;

		new LwjglApplication(new Blackjack(), config);
	}
}
