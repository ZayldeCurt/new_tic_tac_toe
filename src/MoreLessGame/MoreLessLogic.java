package MoreLessGame;

import javax.swing.*;
import java.util.Random;

public class MoreLessLogic {

    private MoreLessData data;
    private int step;
    private boolean endgame;

    public MoreLessLogic() {
        this.data = new MoreLessData();
        step=0;
        endgame= false;
    }

    public void setSearchedNumber() {
        Random generator = new Random();
        this.data.setRandomNumber(generator.nextInt(100));
    }
    public int getSearchedNumber(){
        return this.data.getRandomNumber();
    }

    public boolean isEndgame() {
        return endgame;
    }
    public void setEndgame(boolean endgame) {
        this.endgame = endgame;
    }

    public void resetGame()
    {
        step=0;
        setSearchedNumber();
    }

    public void moreORless(int usernumber, JLabel label)
    {
        if(!endgame)
        {
            if(usernumber>data.getRandomNumber()) {
                label.setText("more");
            }
            else if(usernumber<data.getRandomNumber()) {
                label.setText("less");
            }
            else {
                label.setText("equal, in "+Integer.toString(step));
                endgame=true;
            }
            step++;
        }
    }


}
