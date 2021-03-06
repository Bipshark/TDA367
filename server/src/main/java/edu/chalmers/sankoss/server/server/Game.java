package edu.chalmers.sankoss.server.server;

import edu.chalmers.sankoss.core.core.Coordinate;
import edu.chalmers.sankoss.core.core.Ship;

import java.util.List;

/**
 * 
 * @author Niklas Tegnander
 * @modified Fredrik Thune
 * 
 */
public class Game {
    private Long id;
    private List<Player> players;
    private Player attacker;

    
    public Game() {

    }
    
    public Game(Long id, List<Player> players) {
        this.id = id;
        this.players = players;
    }
    
    public Long getID() {
        return id;
    }
    public void setID(Long id) {
        this.id = id;
    }
    public List<Player> getPlayers() {
        return players;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

	public Player getAttacker() {
		return attacker;
	}

	public void setAttacker(Player attacker) {
		this.attacker = attacker;
	}
	
	public void changeAttacker() {
        setAttacker((players.indexOf(attacker) >= players.size() - 1) ? players.get(0) : players.get(players.indexOf(attacker) + 1));
	}

    public Ship fire(Player target, Coordinate coordinate) throws UsedCoordinateException {

        if (getAttacker().getUsedCoordinates().contains(coordinate)) {
            throw new UsedCoordinateException("Already fired at that coordinate");
        }

        getAttacker().addUsedCoordiante(coordinate);

        //System.out.println(String.format("Fire: #%d %d,%d", target.getID(), coordinate.getX(), coordinate.getY()));

        for (Ship ship : target.getFleet()) {
            if (ship.isShip(coordinate)) {
                ship.shipHit();
                return ship;
            }
        }

        return null;
    }


    public boolean hasPlayerWithID(Long id) {
        for (Player player : players) {
            if (player.getID().equals(id))
                return true;
        }

        return false;
    }

    public boolean isPlayerWithIDHost(Long id) {
        return players.get(0).getID().equals(id);
    }

    public void removePlayerWithID(Long id) {
        for (Player player : players) {
            if (player.getID().equals(id)) {
                players.remove(player);

                return;
            }

        }
    }
}
