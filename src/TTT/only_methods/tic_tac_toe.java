package TTT.only_methods;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;
import java.util.List;

public class tic_tac_toe {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel subsidiaryPanel;
    private JPanel panel;
    private String[] gameArray;
    private List<JButton> gameButtons = new ArrayList<>();
    private boolean flag_round;
    private boolean flag_winner;
    private JLabel round;
    private JLabel resultView;
    private JButton resetButton;
    private int[] result;



    public tic_tac_toe() {
        InitTTT();
        CreateAndShowTTT();
        resetButton.addActionListener(this::actionButtonReset);
        for(int i=0;i<10;i++) {
            gameButtons.get(i).addActionListener(this::actionButton);
        }

    }
    private void InitTTT() {
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
    private void CreateAndShowTTT(){
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
            JButton button = new JButton("");
            button.setPreferredSize(new Dimension(100, 100));
            gameButtons.add(i,button);

            panel.add(gameButtons.get(i));
        }
    }
    private void gameButtonsInit() {

//        gameArray =new JButton[9];
//        for(int i=0;i<9;i++) {
//            gameArray[i] = new JButton();
////            gameButtons.get(i).setPreferredSize(new Dimension(100, 100));
//            gameArray[i].setPreferredSize(new Dimension(100, 100));
//        }
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
            String lol;
            if(!flag_winner)
            {
                if(!((((JButton) e.getSource()).getText()=="X")||(((JButton) e.getSource()).getText()=="Y"))) {
                    if(flag_round) {
                        ((JButton) e.getSource()).setText("X");
                        gameArray[gameButtons.indexOf(((JButton) e.getSource()))]="X"; //pobieranie indexu w liscie
                    }
                    else {
                        ((JButton) e.getSource()).setText("Y");
                        gameArray[gameButtons.indexOf(((JButton) e.getSource()))]="Y";
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
                gameButtons.get(i).setEnabled(true);
                gameButtons.get(i).setText("");
                gameArray[i] = " ";
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
            JOptionPane.showMessageDialog(frame, "wygrał X");
            result[0]++;
        }
        else
        {
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

        if(gameArray[0]==check_who)
        {
            if(gameArray[1]==check_who)
            {
                if(gameArray[2]==check_who)
                {
                    WinnerView();
                }
            }
            if(gameArray[3]==check_who)
            {
                if(gameArray[6]==check_who)
                {
                    WinnerView();
                }
            }
            if(gameArray[4]==check_who)
            {
                if(gameArray[8]==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameArray[3]==check_who)
        {
            if(gameArray[4]==check_who)
            {
                if(gameArray[5]==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameArray[6]==check_who)
        {
            if(gameArray[7]==check_who)
            {
                if(gameArray[8]==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameArray[1]==check_who)
        {
            if(gameArray[4]==check_who)
            {
                if(gameArray[7]==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameArray[2]==check_who)
        {
            if(gameArray[5]==check_who)
            {
                if(gameArray[8]==check_who)
                {
                    WinnerView();
                }
            }
        }
        if(gameArray[2]==check_who)
        {
            if(gameArray[4]==check_who)
            {
                if(gameArray[6]==check_who)
                {
                    WinnerView();
                }
            }
        }


    }
}