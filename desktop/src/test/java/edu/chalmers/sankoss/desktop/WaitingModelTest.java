package edu.chalmers.sankoss.desktop;

import edu.chalmers.sankoss.core.core.CorePlayer;
import edu.chalmers.sankoss.desktop.mvc.waiting.WaitingModel;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Test class for WaitingModel.
 *
 * @author Mikael Malmqvist
 */
public class WaitingModelTest {


    @Test
    public void testAddPlayer() throws Exception {

        WaitingModel testModel = new WaitingModel();
        CorePlayer player = new CorePlayer(1l);

        testModel.addPlayer(player);

        assertTrue (testModel.getPlayers().get(0).equals(player));

    }

    @Test
    public void testRemovePlayer() throws Exception {

        WaitingModel testModel = new WaitingModel();

        CorePlayer player = new CorePlayer(1l);
        CorePlayer player2 = new CorePlayer(2l);

        testModel.addPlayer(player);
        testModel.addPlayer(player2);


        for(CorePlayer corePlayer : testModel.getPlayers()) {
            if(corePlayer.getID().equals(player.getID())) {
                testModel.removePlayer(corePlayer);
            }
        }

        assertTrue (!testModel.getPlayers().get(0).equals(player)
                && !testModel.removePlayer(player));
    }

    @Test
    public void testResetPlayers() throws Exception {

        WaitingModel testModel = new WaitingModel();

        testModel.resetPlayers();

        assertTrue(testModel.getPlayers().isEmpty());
    }


}
