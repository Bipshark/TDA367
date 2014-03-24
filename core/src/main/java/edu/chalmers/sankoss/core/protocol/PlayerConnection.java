package edu.chalmers.sankoss.core.protocol;

import com.esotericsoftware.kryonet.Connection;

public class PlayerConnection extends Connection {
    private Player player;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}