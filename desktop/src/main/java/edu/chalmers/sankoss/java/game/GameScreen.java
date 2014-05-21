package edu.chalmers.sankoss.java.game;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import edu.chalmers.sankoss.core.Coordinate;
import edu.chalmers.sankoss.core.CorePlayer;
import edu.chalmers.sankoss.core.Ship;
import edu.chalmers.sankoss.java.SankossGame;
import edu.chalmers.sankoss.java.client.SankossClientListener;
import edu.chalmers.sankoss.java.mvc.AbstractScreen;

/**
 * Screen used when placing the ships.
 * Handles game logic, like a controller.
 *
 * @author Mikael Malmqvist
 */
public class GameScreen extends AbstractScreen<GameModel, GameRenderer> {
    private final float GRID_CELL_WIDTH = 32f;
    private final int GRID_CELL_WIDTH_INT = (int)GRID_CELL_WIDTH;

    public GameScreen() {
        /**
         * Listener for GameScreen.
         */
        SankossGame.getInstance().getClient().addListener(new SankossClientListener() {

            @Override
            public void playerChangedNat(CorePlayer player) {

            }


            /**
             * Method runs when opponent is set ready.
             * Calls on update opponent visuals.
             * @param player opponent player.
             */
            @Override
            public void playerIsReady(CorePlayer player) {

            }

            /**
             * Method to run if player has won.
             */
            @Override
            public void winner() {
                getModel().setState(GameModel.State.WON);
            }

            /**
             * Method to run if player has lost.
             */
            @Override
            public void looser() {
                getModel().setState(GameModel.State.LOST);
            }

            @Override
            public void destroyedShip(CorePlayer player, Ship ship) {
                super.destroyedShip(player, ship);
            }

            /**
             * Sets to your turn when getting
             * this package call.
             */
            @Override
            public void turn() {
                getModel().setShootingAllowed(true);

            }

            /**
             * Message when a player has fired.
             * @param target the player that got shot at.
             * @param coordinate coordinate shoot at.
             * @param hit hit or miss.
             */
            @Override
            public void fireResult(CorePlayer target, Coordinate coordinate, boolean hit) {
                super.fireResult(target, coordinate, hit);

                // Determines if you were shot at
                if (target.equals(SankossGame.getInstance().getClient().getPlayer())) {
                    //shotAtYou(coordinate, hit);

                } else {
                    //shotAtOpponent(hit);
                }

            }
        });

        getRenderer().getGrid1().addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {

                /**
                 * Get coordinate from mouse position
                 */
                Coordinate coord = getCoordinateFromGrid(x, y);

                // Left click
                if (button == 0) {
                    SankossGame.getInstance().getClient().fire(getModel().getOpponent(), coord);
                    getModel().addShot(coord);

                    getRenderer().getGrid1().setTouchable(Touchable.disabled);
                } else if (button == 1) {
                    getRenderer().getGrid1().toggleFlag(coord);
                }

                return false;

            }

            @Override
            public boolean mouseMoved(InputEvent event, float x, float y) {
                getRenderer().getGrid1().getCrosshair().setX(((int) x / GRID_CELL_WIDTH_INT) * GRID_CELL_WIDTH_INT);
                getRenderer().getGrid1().getCrosshair().setY(((int) y / GRID_CELL_WIDTH_INT) * GRID_CELL_WIDTH_INT);

                return false;
            }

            @Override
            public void exit(InputEvent event, float x, float y, int pointer, Actor toActor) {
                getRenderer().getGrid1().getCrosshair().setVisible(false);
            }

            @Override
            public void enter(InputEvent event, float x, float y, int pointer, Actor toActor) {
                getRenderer().getGrid1().getCrosshair().setVisible(true);
            }
        });
    }

    public Coordinate getCoordinateFromGrid(float mx, float my) {
        int cX = (int)mx / GRID_CELL_WIDTH_INT + 1;
        int cY = ((int)getRenderer().getGrid1().getHeight() - (int)my) / GRID_CELL_WIDTH_INT + 1;
        return new Coordinate(cX, cY);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void update(float delta) {

    }


}
