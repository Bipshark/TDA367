package edu.chalmers.sankoss.java.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import edu.chalmers.sankoss.java.Models.ScreenModel;
import edu.chalmers.sankoss.java.Renderers.Renderer;
import edu.chalmers.sankoss.java.SankossController;
import edu.chalmers.sankoss.java.SankossGame;

/**
 * Abstraction of Screen implementation.
 * All
 *
 * @author Mikael Malmqvist
 * @date 3/31/14
 */
public abstract class AbstractScreen implements Screen {

    protected ScreenModel model;
    protected Renderer renderer;
    protected SankossGame game;
    protected SankossController controller;

    protected Stage stage;
    protected Skin skin;
    protected SpriteBatch batch;
    protected TextButton.TextButtonStyle btnStyle;
    protected Label.LabelStyle labelStyle;

    /**
     * This will keep a reference of the main game.
     * @param game reference to the SankossGame class
     * @param controller reference to the SankossController class
     */
    public AbstractScreen(SankossController controller, SankossGame game) {
        this.controller = controller;
        this.game = game;

    }

    /**
     * Game loop for the current Screen.
     * This method loops as long this Screen is active.
     * @param delta
     */
    @Override
    public void render(float delta) {
        renderer.render();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        Table.drawDebug(stage);

        stage.draw();
    }

    /**
     * Resizes necessary variables to fit.
     * @param width is the new width of the window
     * @param height is the new height of the window
     */
    @Override
    public void resize(int width, int height) {
        stage.setViewport( width, height, true );
    }

    /**
     * Method for when this Screen is set.
     * This method is called automatically when the game sets
     * this Screen as its active Screen. It instantiates its
     * model and renderer.
     */
    @Override
    public abstract void show();

    /**
     * Method called when this Screen is no longer the active Screen.
     */
    @Override
    public abstract void hide();

    @Override
    public abstract void pause();

    @Override
    public abstract void resume();

    @Override
    public void dispose() {
        stage.dispose();
        skin.dispose();
    }
}