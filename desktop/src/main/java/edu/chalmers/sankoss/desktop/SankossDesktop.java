package edu.chalmers.sankoss.desktop;


import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

/**
 * Class to start the application from.
 * Creates a application window with initial
 * size, title and GL20 support.
 *
 * @author Mikael Malmqvist
 * @date 3/23/14
 */
public class SankossDesktop {
    public static void main(String[] args) {

        /**
         * Load settings from ini file
         */
        Settings.loadSettings();

        LwjglApplicationConfiguration cfg = new LwjglApplicationConfiguration();

        cfg.title = "Battleships";
        cfg.vSyncEnabled = true;
        cfg.width = 800;
        cfg.height = 600;
        
        LwjglApplication application = new LwjglApplication(new SankossGame(), cfg);
    }
}
