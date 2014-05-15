package edu.chalmers.sankoss.java.models;

import edu.chalmers.sankoss.core.BasePlayer;
import edu.chalmers.sankoss.core.Coordinate;
import edu.chalmers.sankoss.core.Room;
import edu.chalmers.sankoss.java.misc.ShipButton;

import java.util.Map;
import java.util.Set;

/**
 * Description of class.
 * More detailed description.
 *
 */
public class GameModel extends ScreenModel{

    private Map<Coordinate, ShipButton.Direction> rotationMap;
    private Map<Integer, Set<Coordinate>> shipMap;
    private String hitMsg = "";
    private int x;
    private int y;
    private int yourShipsDestroyed;
    private int oppShipsDestroyed;
    private boolean gameOver;
    private BasePlayer loser;
    
    //TODO Only provisional
    private Coordinate enemyTarget;
    private boolean enemyHit;

    public GameModel(Map<Integer, Set<Coordinate>> shipMap, Map<Coordinate, ShipButton.Direction> rotationMap) {
        this.shipMap = shipMap;
        this.rotationMap = rotationMap;
        yourShipsDestroyed = 0;
        oppShipsDestroyed = 0;

    }

    public void incrementShipsDestroyed(BasePlayer player) {

        // Determines if it was your ship or the opponents
        if(player.equals(getClient().getPlayer())) {
            yourShipsDestroyed++;

        } else {
            oppShipsDestroyed++;
        }
    }

    public int getYourShipsDestroyed() {
        return yourShipsDestroyed;
    }

    public int getOppShipsDestroyed() {
        return oppShipsDestroyed;
    }

    /**
     * Checks if all ships are destroyed.
     * If more than 4 ships are destroyed you have lost.
     */
    public void updateGameOverStatus() {

        if(yourShipsDestroyed > 4 || oppShipsDestroyed > 4) {
            setGameOver(true);
        }
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;

        // Determines whom is the loser
        if(yourShipsDestroyed > 4) {
            setLoser(client.getPlayer());
        } else {
            setLoser(client.getOpponents().get(0));
        }
    }

    public boolean getGameOver() {
        return gameOver;
    }

    public void setLoser(BasePlayer loser) {
        this.loser = loser;
    }

    public BasePlayer getLoser() {
        return loser;
    }

    public Map<Integer, Set<Coordinate>> getShipMap() {
        return shipMap;
    }

    public Map<Coordinate, ShipButton.Direction> getRotationMap() {
        return rotationMap;
    }

    /**
     * @inheritdoc
     */
    public Room getRoomByName(String roomName, Map<Long, Room> rooms) {
        return null;
    }

    public void setHitOrMiss(int x, int y, String msg) {
        hitMsg = msg;
        this.x = x;
        this.y = y;
    }

    public String getHitMsg() {
        return hitMsg;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void setEnemyTarget(Coordinate target, boolean hit){
    	this.enemyTarget = target;
    	this.enemyHit = hit;
    }
    
    public Coordinate getEnemyTargetCoordinate(){
    	return enemyTarget;
    }
    
    public boolean enemyHit(){
    	return enemyHit;
    }

    /**
     * @inheritdoc
     */
    public void setRoomMap(Map<Long, Room> roomMap) {

    }

}
