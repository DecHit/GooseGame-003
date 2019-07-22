import com.goosegame.commandParser.Command;
import com.goosegame.commandParser.CommandParser;
import com.goosegame.constant.Constants;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;


public class CommandParserTest {

    CommandParser parser;
    @Before()
    public void setup(){
        parser=new CommandParser();
    }
    @Test
    public void  testCaseCommandMove(){
        Command command=parser.parser("move pippo");
        assertTrue(command.getPlayerName().equalsIgnoreCase("pippo"));
        assertTrue(command.isValid());

    }
    @Test
    public void  testCaseFail(){
        Command command=parser.parser("move pippo pippo");
        //assertTrue(command.getPlayerName().equalsIgnoreCase("pippo"));
        assertTrue(command.getErrorMessage().equalsIgnoreCase("NOT valid command"));

    }
    @Test
    public void  testCaseFailNumber(){
        Command command=parser.parser("move pippo 3, 7");
        assertTrue(command.getErrorMessage().equalsIgnoreCase("NOT valid command"));
    }

    @Test
    public void  testCaseCommandAdd(){
        Command command=parser.parser("add player pippo");
        assertSame(command.getType(), Constants.Commands.ADD);
        assertTrue(command.getPlayerName().equalsIgnoreCase("pippo"));

    }
}
