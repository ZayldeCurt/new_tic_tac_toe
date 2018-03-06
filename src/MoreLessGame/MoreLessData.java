package MoreLessGame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class MoreLessData {
    private int result;
    private int randomNumber;

    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public int getRandomNumber() {
        return randomNumber;
    }
    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public MoreLessData() {
    }
    public MoreLessData(int result, int randomNumber) {
        this.result = result;
        this.randomNumber = randomNumber;
    }
    public MoreLessData(int randomNumber) {
        this.randomNumber = randomNumber;
    }


}
