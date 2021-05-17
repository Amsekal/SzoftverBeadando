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


    /**
     * konstruktor.
     */
    public GameModel(){
        activePlayer=Player.ONE;
    }


    /**
     *
     * @return visszaadja, hogy vege e a jateknak.
     */

    public boolean didEnd(int Orange){
        if(Orange==4)
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


    /**
     *
     * @return visszaadja a gyoztes jatekos szamat, ha dontetlen akkor pedig 0
     */
    public int finalPoint(int Red, int Blue){
        if(Red<Blue)
            return 2;
        if(Red>Blue)
            return 1;

        return 0;


    }

    /**
     *
     * @param player A jatekos akinek kivancsi vagyunk a pontjaira
     * @return a pontok szama
     */
    public int Return_num(Player player){
        if(player==Player.ONE)
        return Red_Num;
        return Blue_Num;
    }
    public int Return_Orange(){ return Orange_Num;}
    /**
     *
     * @return visszadja hany pontja van a kek jatekosnak
     */
    public int B_num(){return Blue_Num;}
}
