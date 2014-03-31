package edu.chalmers.sankoss.core.protocol;
/**
 * 
 * @author Niklas Tegnander
 * @modified Fredrik Thune
 */
public class CreateGame {
    private Long gameID;
    
    public CreateGame() {
        
    }

    public CreateGame(Long gameID) {
        this.gameID = gameID;
    }

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }
}
