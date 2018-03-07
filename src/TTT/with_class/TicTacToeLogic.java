package TTT.with_class;

import javax.swing.*;
import java.util.Random;

public class TicTacToeLogic {
    private int[] result;
    private boolean flag_round;
    private boolean flag_winner;
    private String[] gameArray;

    public int[] getResult() {
        return result;
    }
    public void plusplusResult(int index) {
        this.result[index]++;
    }
    public boolean isFlag_round() {
        return flag_round;
    }
    public void setFlag_round(boolean flag_round) {
        this.flag_round = flag_round;
    }
    public boolean isFlag_winner() {
        return flag_winner;
    }
    public void setFlag_winner(boolean flag_winner) {
        this.flag_winner = flag_winner;
    }
    public String[] getGameArray() {
        return gameArray;
    }
    public void setGameArray(int index, String value) {
        this.gameArray[index] = value;
    }

    public void InitTTT() {
        flag_round = true;
        flag_winner = false;
        gameArray = new String[9];
        for(int i=0;i<9;i++)
        {
            gameArray[i]="nic";
        }
        result = new int[2];
        result[0]=0;
        result[1]=0;
    }
    public String randomStart() {
        Random generator = new Random();
        flag_round = generator.nextBoolean();
        if(flag_round)
        {
            return "zaczyna X";
        }
        else
        {
            return "zaczyna Y";
        }
    }


    public boolean CheckWinner(){
        String check_who;
        if(this.isFlag_round())
            check_who="X";
        else
            check_who="Y";

        if(gameArray[0]==check_who)
        {
            if(gameArray[1]==check_who)
            {
                if(gameArray[2]==check_who)
                {
//                    WinnerView();
                    return true;
                }
            }
            if(gameArray[3]==check_who)
            {
                if(gameArray[6]==check_who)
                {
//                    WinnerView();
                    return true;
                }
            }
            if(gameArray[4]==check_who)
            {
                if(gameArray[8]==check_who)
                {
//                    WinnerView();
                    return true;
                }
            }
        }
        if(gameArray[3]==check_who)
        {
            if(gameArray[4]==check_who)
            {
                if(gameArray[5]==check_who)
                {
//                    WinnerView();
                    return true;
                }

            }
        }
        if(gameArray[6]==check_who)
        {
            if(gameArray[7]==check_who)
            {
                if(gameArray[8]==check_who)
                {
//                    WinnerView();
                    return true;
                }
            }
        }
        if(gameArray[1]==check_who)
        {
            if(gameArray[4]==check_who)
            {
                if(gameArray[7]==check_who)
                {
//                    WinnerView();
                    return true;
                }
            }
        }
        if(gameArray[2]==check_who)
        {
            if(gameArray[5]==check_who)
            {
                if(gameArray[8]==check_who)
                {
//                    WinnerView();
                    return true;
                }
            }
        }
        if(gameArray[2]==check_who)
        {
            if(gameArray[4]==check_who)
            {
                if(gameArray[6]==check_who)
                {
//                    WinnerView();
                    return true;
                }
            }
        }

        return false;
    }

}
