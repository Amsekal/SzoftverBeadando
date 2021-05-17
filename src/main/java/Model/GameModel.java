package Model;

import jatek.DominoStartController;
import javafx.beans.property.ReadOnlyObjectWrapper;

import java.security.KeyStore;

public class GameModel {
    public static int ROW_NUMBER=8;
    public static Player activePlayer;

    private int Red_Num=0;
    private int Blue_Num=0;
    private int Orange_Num=0;




    public GameModel(){
        activePlayer=Player.ONE;
    }

    public static Player nextPlayer(){
        if(activePlayer==Player.ONE)
            return Player.TWO;
        else
            return Player.ONE;
    }


    public boolean didEnd(){
        if(Orange_Num==4)
            return true;
        return false;

    }

    public void NewOrange()
    {
       Orange_Num++;
    }

    public void NewRed(){Red_Num++;}

    public void NewBlue(){Blue_Num++;}

    public void LessRed(){Red_Num--;}

    public void LessBlue(){Blue_Num--;}

    public int finalPoint(){
        if(Red_Num<Blue_Num)
            return 2;
        if(Red_Num>Blue_Num)
            return 1;

        return 0;


    }


    public int R_num(){ return Red_Num;}
    public int B_num(){return Blue_Num;}
}
