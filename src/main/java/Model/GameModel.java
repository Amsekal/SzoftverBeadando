package Model;

import javafx.beans.property.ReadOnlyObjectWrapper;

public class GameModel {
    public static int ROW_NUMBER=8;
    public static Player activePlayer;



    public GameModel(){
        activePlayer=Player.ONE;
    }

    public static Player nextPlayer(){
        if(activePlayer==Player.ONE)
            return Player.TWO;
        else
            return Player.ONE;
    }
}
