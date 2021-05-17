import Model.GameModel;
import Model.Player;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class ModelTest {

    @Test
    void Return_num_test(){

        GameModel gameModel=new GameModel();
        Player player=Player.ONE;
        assertEquals(0,gameModel.Return_num(player));
        gameModel.NewRed();
        assertEquals(1,gameModel.Return_num(player));
        gameModel.LessRed();
        assertEquals(0,gameModel.Return_num(player));
        player=Player.TWO;
        assertEquals(0,gameModel.Return_num(player));
        gameModel.NewBlue();
        assertEquals(1,gameModel.Return_num(player));
        gameModel.LessBlue();
        assertEquals(0,gameModel.Return_num(player));
    }

    @Test
    void didEnd_test(){
        GameModel gameModel=new GameModel();
        int Orange_Num=4;
        assertTrue(gameModel.didEnd(Orange_Num));
    }


    @Test
    void finalPoint_test(){
        GameModel gameModel=new GameModel();
        int a=4;
        int b=5;
        assertEquals(2,gameModel.finalPoint(a,b));
        assertEquals(1,gameModel.finalPoint(b,a));
        assertEquals(0,gameModel.finalPoint(b,b));
    }
}
