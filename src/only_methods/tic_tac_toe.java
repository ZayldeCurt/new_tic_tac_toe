package only_methods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class tic_tac_toe {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel subsidiaryPanel;
    private JPanel panel;
    private JButton[] gameButtons;
    private boolean flag_round;
    private boolean flag_winner;
    private JLabel round;
    private JLabel resultView;
    private JButton resetButton;
    private int[] result;
    private int[][] resultArray;



    public tic_tac_toe() {
        InitTTT();
        CreateAndShowTTT();
        resetButton.addActionListener(this::actionButtonReset);
        for(int i=0;i<10;i++) {
            gameButtons[i].addActionListener(this::actionButton);
//            ButtonAction(gameButtons[i]);
        }

    }
    private void InitTTT() {
        flag_round = true;
        flag_winner = false;
        resultArray = new int[3][3];
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                resultArray[i][j]=0;
            }
        }
        result = new int[2];
        result[0]=0;
        result[1]=0;
    }
    private void CreateAndShowTTT()
    {
        elementInit();
        panelInit();
        frameInit();
        randomStart();
    }
    public static void main(String[] args)
    {
        tic_tac_toe ticTacToe = new tic_tac_toe();
    }





    private void randomStart() {
        Random generator = new Random();
        flag_round = generator.nextBoolean();
        if(flag_round)
        {
            round.setText("zaczyna X");
        }
        else
        {
            round.setText("zaczyna Y");
        }
    }
    private void elementInit() {
        gameButtonsInit(); //game buttons init
        resetButtonInit(); //reset button init
        roundInit();//label
        resultViewInit();//label winner
    }
    private void panelInit() {
        subsidiaryPanelInit();//subsidiary panel
        gridPanelInit();//game panel
        mainPanelInit();//main panel
    }
    private void gridPanelInit() {
        panel = new JPanel();
        panel.setBackground(Color.darkGray);
        GridLayout layout = new GridLayout(3,3);
        panel.setLayout(layout);
        for(int i=0;i<9;i++) {
            panel.add(gameButtons[i]);
        }
    }
    private void gameButtonsInit() {

        gameButtons =new JButton[9];
        for(int i=0;i<9;i++) {
            gameButtons[i] = new JButton();
            gameButtons[i].setPreferredSize(new Dimension(100, 100));
        }
    }
    private void mainPanelInit() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(panel);
        mainPanel.add(subsidiaryPanel,BorderLayout.NORTH);

    }
    private void subsidiaryPanelInit() {
        subsidiaryPanel = new JPanel();
        subsidiaryPanel.setLayout(new BorderLayout());
        subsidiaryPanel.add(round,BorderLayout.CENTER);
        subsidiaryPanel.add(resetButton,BorderLayout.EAST);
        subsidiaryPanel.add(resultView,BorderLayout.WEST);
    }
    private void frameInit() {
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
    private void resultViewInit() {
        resultView =new JLabel(result[0]+" : "+result[1],SwingConstants.CENTER);
        resultView.setFont(new Font("SansSerif", Font.BOLD, 15));
    }
    private void roundInit() {
        round = new JLabel("Początek Gry",SwingConstants.CENTER);
        round.setFont(new Font("SansSerif", Font.BOLD, 30));
    }
    private void resetButtonInit() {
        resetButton = new JButton("reset");
        resetButton.setMinimumSize(new Dimension(100, 50));
        resetButton.setPreferredSize(new Dimension(100, 50));
        resetButton.setMinimumSize(new Dimension(100,50));
    }
    public void actionButton(ActionEvent e) {
        if (e.getSource() instanceof JButton)
        {
            if(!flag_winner)
            {
                if(!((((JButton) e.getSource()).getText()=="X")||(((JButton) e.getSource()).getText()=="Y"))) {
                    if(flag_round) {
                        ((JButton) e.getSource()).setText("X");
                    }
                    else {
                        ((JButton) e.getSource()).setText("Y");
                    }
                    ((JButton) e.getSource()).setEnabled(false);
                }
                CheckWinner();
                flag_round=!flag_round;
            }
            if(!flag_winner) {
                if (flag_round)
                    round.setText("Kolejka X");
                else
                    round.setText("Kolejka Y");
            }
        }
    }
    public void actionButtonReset(ActionEvent e) {
        if (e.getSource() instanceof JButton)
        {
            for(int i=0;i<9;i++) {
                gameButtons[i].setEnabled(true);
                gameButtons[i].setText("");
            }
            flag_winner = false;
            if (flag_round)
                round.setText("Kolejka X");
            else
                round.setText("Kolejka Y");

            randomStart();
        }
    }

    private void WinnerView(){
        if(flag_round)
        {
//            round.setText("wygrał X");
            JOptionPane.showMessageDialog(frame, "wygrał X");
            result[0]++;
        }
        else
        {
//            round.setText("wygrał Y");
            JOptionPane.showMessageDialog(frame, "wygrał Y");
            result[1]++;
        }
        flag_winner=true;
        resultView.setText(result[0]+" : "+result[1]);


    }

    private void CheckWinner(){
        String check_who;
        if(flag_round)
            check_who="X";
        else
            check_who="Y";

        if(gameButtons[0].getText()==check_who)
        {
            if(gameButtons[1].getText()==check_who)
            {
                if(gameButtons[2].getText()==check_who)
                {
                    WinnerView();
                }
            }
            if(gameButtons[3].getText()==check_who)
            {
                if(gameButtons[6].getText()==check_who)
                {
                    WinnerView();
                }
            }
            if(gameButtons[4].getText()==check_who)
            {
                if(gameButtons[8].getText()==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameButtons[3].getText()==check_who)
        {
            if(gameButtons[4].getText()==check_who)
            {
                if(gameButtons[5].getText()==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameButtons[6].getText()==check_who)
        {
            if(gameButtons[7].getText()==check_who)
            {
                if(gameButtons[8].getText()==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameButtons[1].getText()==check_who)
        {
            if(gameButtons[4].getText()==check_who)
            {
                if(gameButtons[7].getText()==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameButtons[2].getText()==check_who)
        {
            if(gameButtons[5].getText()==check_who)
            {
                if(gameButtons[8].getText()==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameButtons[2].getText()==check_who)
        {
            if(gameButtons[4].getText()==check_who)
            {
                if(gameButtons[6].getText()==check_who)
                {
                    WinnerView();
                }
            }
        }


    }
}