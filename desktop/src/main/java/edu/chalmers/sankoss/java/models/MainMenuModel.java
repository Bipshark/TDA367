package edu.chalmers.sankoss.java.models;

import com.badlogic.gdx.Gdx;

/**
 * Description of class.
 * More detailed description.
 *
 * @author Mikael Malmqvist
 * @modified Niklas Tegnander
 * @date 3/24/14
 */
public class MainMenuModel extends AbstractModel {
    private boolean connected = false;

    public MainMenuModel() {
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;

        setChanged();
        notifyObservers("connected");

        Gdx.app.debug("MainMenuModel", "Connected: " + connected);
    }
}