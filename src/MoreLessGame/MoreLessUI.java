package MoreLessGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class MoreLessUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JTextField estimateNumber;
    private JButton actionButton;
    private JButton resetButton;
    private JLabel tempResult;
    private MoreLessLogic Logic;

    public MoreLessUI(){
        Logic = new MoreLessLogic();
        Logic.setSearchedNumber();
        CreateAndShowTTT();
        actionButton.addActionListener(this::actionButton);
        resetButton.addActionListener(this::resetButton);
    }
    public static void main(String[] args) {
        MoreLessUI moreLessUI = new MoreLessUI();
    }

    private void CreateAndShowTTT() {
        elementInit();
        mainPanelInit();
        frameInit();
    }
    private void elementInit() {
        actionButton = new JButton("sprawdź");
        actionButton.setMinimumSize(new Dimension(20, 20));
        actionButton.setPreferredSize(new Dimension(100, 60));
        actionButton.setMinimumSize(new Dimension(100,60));

        resetButton = new JButton("reset");
        resetButton.setMinimumSize(new Dimension(20, 20));
        resetButton.setPreferredSize(new Dimension(100, 60));
        resetButton.setMinimumSize(new Dimension(100,60));

        estimateNumber = new JTextField(10);
        estimateNumber.setMinimumSize(new Dimension(20, 20));
        estimateNumber.setPreferredSize(new Dimension(100,60));
        estimateNumber.setMinimumSize(new Dimension(100,60));

        tempResult = new JLabel("początek gry",SwingConstants.CENTER);
        tempResult.setMinimumSize(new Dimension(20, 20));
        tempResult.setPreferredSize(new Dimension(100,60));
        tempResult.setMinimumSize(new Dimension(100,60));



    }
    private void mainPanelInit() {
        mainPanel = new JPanel();
//        mainPanel.setBackground(Color.darkGray);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(actionButton);
        mainPanel.add(estimateNumber);
        mainPanel.add(tempResult);
        mainPanel.add(resetButton);
    }
    private void frameInit() {
        frame = new JFrame("More Less");
        frame.setSize(500,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    public void actionButton(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            Logic.moreORless(Integer.parseInt(estimateNumber.getText()),tempResult);
        }
    }
    public void resetButton(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            Logic.setEndgame(false);
            tempResult.setText("początek gry");
            Logic.resetGame();
        }
    }

}
