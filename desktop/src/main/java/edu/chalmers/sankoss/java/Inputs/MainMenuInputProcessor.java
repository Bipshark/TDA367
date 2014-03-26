package edu.chalmers.sankoss.java.Inputs;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

/**
 * Handles input for the MainMenu Screen.
 * The SankossController will switch to this InputProcessor
 * when the MainMenuScreen to set to its active Screen.
 *
 * @author Mikael Malmqvist
 * @date 3/26/14
 */
public class MainMenuInputProcessor implements InputProcessor {

    @Override
    public boolean keyDown(int i) {
        if(Gdx.input.isKeyPressed(Input.Keys.F5)) {
            System.out.println("Refresh from MainMenuInputProcessor!");
            return true;
        }

        return false;
    }

    @Override
    public boolean keyUp(int i) {
        return false;
    }

    @Override
    public boolean keyTyped(char c) {
        return false;
    }

    @Override
    public boolean touchDown(int i, int i2, int i3, int i4) {
        return false;
    }

    @Override
    public boolean touchUp(int i, int i2, int i3, int i4) {
        return false;
    }

    @Override
    public boolean touchDragged(int i, int i2, int i3) {
        return false;
    }

    @Override
    public boolean mouseMoved(int i, int i2) {
        return false;
    }

    @Override
    public boolean scrolled(int i) {
        return false;
    }
}
