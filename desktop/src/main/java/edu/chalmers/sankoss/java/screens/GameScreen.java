package edu.chalmers.sankoss.java.screens;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import edu.chalmers.sankoss.core.Coordinate;
import edu.chalmers.sankoss.core.Player;
import edu.chalmers.sankoss.core.Room;
import edu.chalmers.sankoss.core.Ship;
import edu.chalmers.sankoss.java.Models.GameModel;
import edu.chalmers.sankoss.java.Renderers.GameRenderer;
import edu.chalmers.sankoss.java.SankossController;
import edu.chalmers.sankoss.java.SankossGame;
import edu.chalmers.sankoss.java.client.SankossClientListener;

import java.util.List;
import java.util.Map;

/**
 * Screen used when placing the ships.
 * Handles game logic when placing ships, almost like a controller.
 *
 * @author Mikael Malmqvist
 * @date 3/24/14
 */
public class GameScreen extends AbstractScreen implements SankossClientListener {

    private final int GRID_SIDE=10;
    private final int GRID_TILE_SIDE=45;

    // Controllers
    private Label nameLabel;

    //Containers
    private WidgetGroup gridPanel;

    /**
     * This will keep a reference of the main game.
     * @param game reference to the SankossGame class
     * @param controller reference to the SankossController class
     */
    public GameScreen(SankossController controller, SankossGame game) {
        super(controller, game);
        model = new GameModel();
        model.getClient().addListener(this);
        renderer = new GameRenderer(model);

        create();
    }

    /**
     * @inheritdoc
     */
    @Override
    public void show() {

    }

    /**
     * @inheritdoc
     */
    @Override
    public void hide() {
        if(stage.getRoot().hasChildren()) {
            stage.getRoot().clearChildren();
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    /**
     * Method to run upon creation of instance.
     * Configs visual controllers and sets listeners.
     */
    @Override
    public void create() {

        super.create();
        renderer.drawControllers(this);

        BitmapFont font = new BitmapFont();
        font.scale(1); // Sets font's scale relative to current scale

        // Adds font to skin
        skin.add("default", font);


        // Sets the stage as input source
        controller.changeInput(stage);

        labelStyle.font = skin.getFont("default");

        // Label better of here than in Renderer cause of the model, client, player name
        nameLabel = new Label(model.getClient().getPlayer().getName(), labelStyle);
        nameLabel.setX(10);
        nameLabel.setY(110);

        ((GameRenderer) renderer).getPlayerTable().addActor(nameLabel);

        stage.addActor(renderer.getActorPanel());
        stage.draw();

    }

    /**
     * @inheritdoc
     */
    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
        renderer.resize(width, height);
    }

    @Override
    public void render() {

    }

    @Override
    public void connected(Long playerID) {

    }

    @Override
    public void fetchedRooms(Map<Long, Room> rooms) {

    }

    @Override
    public void createdRoom(Long roomID) {

    }

    @Override
    public void joinedRoom(Player player) {

    }

    @Override
    public void startedGame(Long gameID, List<Player> players) {

    }

    @Override
    public void gameReady() {

    }

    @Override
    public void playerIsReady(Player player) {
        System.out.println("SERVER: " + model.getClient().getPlayer().getName() + " is ready!");
    }

    @Override
    public void turn() {

    }

    @Override
    public void fireResult(Long gameID, Player target, Coordinate coordinate, boolean hit) {

    }

    @Override
    public void destroyedShip(Player player, Ship ship) {

    }

    @Override
    public void disconnected() {

    }

}
