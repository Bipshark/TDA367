package edu.chalmers.sankoss.desktop.client;

import edu.chalmers.sankoss.core.*;
import edu.chalmers.sankoss.core.core.Coordinate;
import edu.chalmers.sankoss.core.core.CorePlayer;
import edu.chalmers.sankoss.core.core.Room;
import edu.chalmers.sankoss.core.core.Ship;

import java.util.Map;

/**
 * @author Niklas Tegnander
 * @modified Fredrik Thune
 */
public class SankossClientListener implements ISankossClientListener {

    @Override
    public void connected() {

    }

    @Override
    public void fetchedRooms(Map<Long, Room> rooms) {

    }

    @Override
    public void createdRoom(Room room) {

    }

    @Override
    public void joinedRoom(CorePlayer player) {

    }

    @Override
    public void startedGame(Long gameID) {

    }

    @Override
    public void gameReady() {

    }

    @Override
    public void playerIsReady(CorePlayer player) {

    }

    @Override
    public void turn() {

    }

    @Override
    public void fireResult(CorePlayer target, Coordinate coordinate, boolean hit) {

    }

    @Override
    public void destroyedShip(CorePlayer player, Ship ship) {

    }

    @Override
    public void disconnected() {

    }

    @Override
    public void playerChangedName(CorePlayer player) {

    }

    @Override
    public void playerChangedNat(CorePlayer player) {

    }

    @Override
    public void playerChangeNat(CorePlayer player) {

    }

    @Override
    public void leftGame(CorePlayer player) {

    }

    @Override
    public void leftRoom(CorePlayer player) {

    }

    @Override
    public void removedRoom() {

    }

    @Override
    public void looser() {

    }

    @Override
    public void winner() {

    }

    @Override
    public void errorMsg(Object errorObject, String errorMessage) {

    }


}
