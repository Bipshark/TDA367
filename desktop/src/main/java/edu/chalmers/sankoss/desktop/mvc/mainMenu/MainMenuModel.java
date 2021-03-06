package edu.chalmers.sankoss.desktop.mvc.mainMenu;

import edu.chalmers.sankoss.desktop.mvc.AbstractModel;

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
        fireChange("connected", connected);

        // Gdx.app.debug("MainMenuModel", "Connected: " + connected);
    }

    @Override
    public void reset() {
        // Connection should not reset

        fireChange("reset");
    }
}
