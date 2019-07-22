
import com.goosegame.cell.Cell;
import com.goosegame.commandParser.Command;
import com.goosegame.gamePlay.GamePlay;
import com.goosegame.player.Player;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class GamePlayTest {
    Player player;
    GamePlay play;
    Cell cell;
    Command command;// CommandParser parser;

    @Before()
    public void setup() {
        play = new GamePlay();
        cell=new Cell(0);
        player=new Player("Pippo",cell );
        command=new Command();
        //parser=new CommandParser();
    }

    @Test
    public void testCaseAdd() {
        play.addplayer("Pippo");
        assertEquals(player.getCells().getPosition(), 0);
        assertEquals(player.getName(), "Pippo");
        assertTrue(play.getPlayers().size()==1);
        play.addplayer("Pippo");
        assertTrue(play.getPlayers().size()==1);
    }

    @Test
    public void testCaseMove(){
        play.moveplayer(player, 1, 3, false);
        assertEquals(4, player.getCells().getPosition());
    }

    @Test
    public void testCaseMoveGoose() {
        play.moveplayer(player, 2, 3, true);
        assertEquals(player.getCells().getPosition(), 10);
    }

    @Test
    public void testCaseMoveBridge(){
        play.moveplayer(player, 3, 3, true);
        assertEquals(12, player.getCells().getPosition());
    }

}
