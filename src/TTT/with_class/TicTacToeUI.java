package TTT.with_class;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TicTacToeUI {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel subsidiaryPanel;
    private JPanel panel;
    private List<JButton> gameButtons = new ArrayList<>();
    private JLabel round;
    private JLabel resultView;
    private JButton resetButton;

    private TicTacToeLogic Logic;
//    private String[] gameArray;

    public TicTacToeUI() {
        Logic = new TicTacToeLogic();
        Logic.InitTTT();
        CreateAndShowTTT();
        resetButton.addActionListener(this::actionButtonReset);
        for(int i=0;i<10;i++) {
            gameButtons.get(i).addActionListener(this::actionButton);
        }
        round.setText(Logic.randomStart());
    }


    public static void main(String[] args)
    {
        TicTacToeUI ticTacToe = new TicTacToeUI();
    }

    private void CreateAndShowTTT() {
        elementInit();
        panelInit();
        frameInit();
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
        resultView =new JLabel(Logic.getResult()[0]+" : "+Logic.getResult()[1],SwingConstants.CENTER);
        resultView.setFont(new Font("SansSerif", Font.BOLD, 15));
    }
    private void roundInit() {
        round = new JLabel("Początek Gry");
        round.setFont(new Font("SansSerif", Font.BOLD, 30));
    }
    private void resetButtonInit() {
        resetButton = new JButton("reset");
        resetButton.setMinimumSize(new Dimension(100, 50));
        resetButton.setPreferredSize(new Dimension(100, 50));
        resetButton.setMinimumSize(new Dimension(100,50));
    }
    private void gameButtonsInit() {

//        gameArray =new JButton[9];
//        for(int i=0;i<9;i++) {
//            gameArray[i] = new JButton();
////            gameButtons.get(i).setPreferredSize(new Dimension(100, 100));
//            gameArray[i].setPreferredSize(new Dimension(100, 100));
//        }
    }

    public void actionButton(ActionEvent e) {
        if (e.getSource() instanceof JButton)
        {
            String lol;
            if(!Logic.isFlag_winner())
            {
                if(!((((JButton) e.getSource()).getText()=="X")||(((JButton) e.getSource()).getText()=="Y"))) {
                    if(Logic.isFlag_round()) {
                        ((JButton) e.getSource()).setText("X");
                        Logic.setGameArray(gameButtons.indexOf(((JButton) e.getSource())),"X");
                    }
                    else {
                        ((JButton) e.getSource()).setText("Y");
                        Logic.setGameArray(gameButtons.indexOf(((JButton) e.getSource())),"Y");
                    }
                    ((JButton) e.getSource()).setEnabled(false);
                }

                if(Logic.CheckWinner())
                {
                    WinnerView();
                }
                Logic.setFlag_round(!Logic.isFlag_round());
            }
            if(!Logic.isFlag_winner()) {
                if (Logic.isFlag_round())
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
                Logic.setGameArray(i, " ");
            }
            Logic.setFlag_winner(false);
            if (Logic.isFlag_round())
                round.setText("Kolejka X");
            else
                round.setText("Kolejka Y");

            Logic.randomStart();
        }
    }
    private void WinnerView(){
        if(Logic.isFlag_round()) {
            JOptionPane.showMessageDialog(frame, "wygrał X");
            Logic.plusplusResult(0);
        }
        else {
            JOptionPane.showMessageDialog(frame, "wygrał Y");
            Logic.plusplusResult(1);
        }
        Logic.setFlag_winner(true);
        resultView.setText(Logic.getResult()[0]+" : "+Logic.getResult()[1]);
    }

}