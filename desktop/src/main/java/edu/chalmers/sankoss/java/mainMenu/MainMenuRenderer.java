package edu.chalmers.sankoss.java.mainMenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import edu.chalmers.sankoss.java.SankossGame;
import edu.chalmers.sankoss.java.mvc.AbstractRenderer;

import java.util.Observable;

/**
 * Description of class.
 * More detailed description.
 *
 * @author Mikael Malmqvist
 * @modified Niklas Tegnander
 * @date 3/24/14
 */
public class MainMenuRenderer extends AbstractRenderer<MainMenuModel> {

    Image logo = new Image(new Texture(Gdx.files.internal("logo.png")));
    TextButton btnMultiPlayer = new TextButton("Multiplayer", SankossGame.getInstance().getSkin());
    TextButton btnOptions = new TextButton("Options", SankossGame.getInstance().getSkin());
    TextButton btnCredits = new TextButton("Credits", SankossGame.getInstance().getSkin());
    TextButton btnExit = new TextButton("Exit", SankossGame.getInstance().getSkin());

    public MainMenuRenderer(MainMenuModel model) {
        super(model);

        btnMultiPlayer.pad(8f);
        btnOptions.pad(8f);
        btnCredits.pad(8f);
        btnExit.pad(8f);

        getTable().add(logo);
        getTable().row();
        getTable().add(btnMultiPlayer).fillX().pad(8f);
        getTable().row();
        getTable().add(btnOptions).fillX().pad(8f);
        getTable().row();
        getTable().add(btnCredits).fillX().pad(8f);
        getTable().row();
        getTable().add(btnExit).fillX().pad(8f);
        getTable().row();
        //getTable().debug();
        getStage().addActor(getTable());

        btnMultiPlayer.setDisabled(true);
    }

    public TextButton getBtnMultiPlayer() {
        return btnMultiPlayer;
    }

    public TextButton getBtnOptions() {
        return btnOptions;
    }

    public TextButton getBtnCredits() {
        return btnCredits;
    }

    public TextButton getBtnExit() {
        return btnExit;
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0.09f, 0.28f, 0.2f, 1);

        getStage().act(delta);
        getStage().draw();
        Table.drawDebug(getStage());
    }

    @Override
    public void update(Observable object, Object arg) {
        if (arg.equals("connected")) {
            btnMultiPlayer.setDisabled(false);
        }
    }
}
