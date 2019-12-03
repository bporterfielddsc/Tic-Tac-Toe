package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Controller
{
    @FXML
    private Button Button1;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

    @FXML
    private Button Button9;

    @FXML
    private Button playerButton;

    @FXML
    private Text timerButton;

    @FXML
    private Button resetButton;

    boolean player = true;


    Timer timer = new Timer();

    @FXML
    protected void initialize()//starts timer when program starts
    {

        TimerTask task = new TimerTask()
        {

            @Override

            public void run()
            {
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (timerButton.getText().equals("0"))
                        {
                            timerButton.setText("16");

                            timerButton.setText(Integer.toString(Integer.parseInt(timerButton.getText()) - 1));
                            if (player)
                            {
                                playerButton.setText("P2");
                                player = false;
                            } else
                            {
                                playerButton.setText("P1");
                                player = true;
                            }

                        } else
                        {
                            timerButton.setText(Integer.toString(Integer.parseInt(timerButton.getText()) - 1));


                        }
                    }
                });

            }
        };
        timer.schedule(task, 1000, 1000);
    }


    public void ButtonAction(ActionEvent event)//controls whether an X is placed or an O is placed based on what player is playing
    {
        if (((Button) event.getSource()).getText().equals(""))
        {
            if (player == true)
            {
                ((Button) event.getSource()).setText("X");

                playerButton.setText("P2");

                player = false;

                timerButton.setText("16");
                winner();


            } else if (player == false)
            {

                ((Button) event.getSource()).setText("O");

                playerButton.setText("P1");

                player = true;
                timerButton.setText("16");
                winner();
            }
        }
    }


    public void resetActionButton(ActionEvent event)//resets board when reset button is pressed
    {
        Button1.setText("");
        Button2.setText("");
        Button3.setText("");
        Button4.setText("");
        Button5.setText("");
        Button6.setText("");
        Button7.setText("");
        Button8.setText("");
        Button9.setText("");
        Button1.setDisable(false);
        Button2.setDisable(false);
        Button3.setDisable(false);
        Button4.setDisable(false);
        Button5.setDisable(false);
        Button6.setDisable(false);
        Button7.setDisable(false);
        Button8.setDisable(false);
        Button9.setDisable(false);


        player = true;

        playerButton.setText("P1");

        timer.purge();
        timer.cancel();

        timerButton.setText("15");

        newTimer();

    }

    private void newTimer()//creates new timer
    {
        timer = new Timer();

        TimerTask task = new TimerTask()
        {

            @Override
            public void run()//method for timerTask
            {
                Platform.runLater(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        if (timerButton.getText().equals("0"))
                        {
                            timerButton.setText("16");

                            timerButton.setText(Integer.toString(Integer.parseInt(timerButton.getText()) - 1));
                            if (player)
                            {
                                playerButton.setText("P2");
                                player = false;
                            } else
                            {
                                playerButton.setText("P1");
                                player = true;
                            }

                        } else
                        {
                            timerButton.setText(Integer.toString(Integer.parseInt(timerButton.getText()) - 1));


                        }
                    }
                });
            }
        };

        timer.schedule(task, 1000, 1000);
    }


    private void winner()//determines when someone has won the game
    {
        if ((Button1.getText().equals("X") && Button2.getText().equals("X") && Button3.getText().equals("X")) ||
                (Button1.getText().equals("O") && Button2.getText().equals("O") && Button3.getText().equals("O")))
        {
            timer.cancel();
            Button1.getStyleClass().add("changeColor");
            Button2.getStyleClass().add("changeColor");
            Button3.getStyleClass().add("changeColor");

            Button4.setDisable(true);
            Button5.setDisable(true);
            Button6.setDisable(true);
            Button7.setDisable(true);
            Button8.setDisable(true);
            Button9.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");


        } else if ((Button4.getText().equals("X") && Button5.getText().equals("X") && Button6.getText().equals("X")) ||
                (Button4.getText().equals("O") && Button5.getText().equals("O") && Button6.getText().equals("O")))
        {
            timer.cancel();
            Button4.getStyleClass().add("changeColor");
            Button5.getStyleClass().add("changeColor");
            Button6.getStyleClass().add("changeColor");
            Button1.setDisable(true);
            Button2.setDisable(true);
            Button3.setDisable(true);

            Button7.setDisable(true);
            Button8.setDisable(true);
            Button9.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");
        } else if ((Button7.getText().equals("X") && Button8.getText().equals("X") && Button9.getText().equals("X")) ||
                (Button7.getText().equals("O") && Button8.getText().equals("O") && Button9.getText().equals("O")))
        {
            timer.cancel();
            Button7.getStyleClass().add("changeColor");
            Button8.getStyleClass().add("changeColor");
            Button9.getStyleClass().add("changeColor");
            Button1.setDisable(true);
            Button2.setDisable(true);
            Button3.setDisable(true);
            Button4.setDisable(true);
            Button5.setDisable(true);
            Button6.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");
        } else if ((Button1.getText().equals("X") && Button4.getText().equals("X") && Button7.getText().equals("X")) ||
                (Button1.getText().equals("O") && Button4.getText().equals("O") && Button7.getText().equals("O")))
        {
            timer.cancel();
            Button1.getStyleClass().add("changeColor");
            Button4.getStyleClass().add("changeColor");
            Button7.getStyleClass().add("changeColor");

            Button2.setDisable(true);
            Button3.setDisable(true);

            Button5.setDisable(true);
            Button6.setDisable(true);

            Button8.setDisable(true);
            Button9.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");

        } else if ((Button2.getText().equals("X") && Button5.getText().equals("X") && Button8.getText().equals("X")) ||
                (Button2.getText().equals("O") && Button5.getText().equals("O") && Button8.getText().equals("O")))
        {
            timer.cancel();
            Button2.getStyleClass().add("changeColor");
            Button5.getStyleClass().add("changeColor");
            Button8.getStyleClass().add("changeColor");
            Button1.setDisable(true);

            Button3.setDisable(true);
            Button4.setDisable(true);

            Button6.setDisable(true);
            Button7.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");
            Button9.setDisable(true);
        } else if ((Button3.getText().equals("X") && Button6.getText().equals("X") && Button9.getText().equals("X")) ||
                (Button3.getText().equals("O") && Button6.getText().equals("O") && Button9.getText().equals("O")))
        {
            timer.cancel();
            Button3.getStyleClass().add("changeColor");
            Button6.getStyleClass().add("changeColor");
            Button9.getStyleClass().add("changeColor");
            Button1.setDisable(true);
            Button2.setDisable(true);

            Button4.setDisable(true);
            Button5.setDisable(true);

            Button7.setDisable(true);
            Button8.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");

        } else if ((Button1.getText().equals("X") && Button5.getText().equals("X") && Button9.getText().equals("X")) ||
                (Button1.getText().equals("O") && Button5.getText().equals("O") && Button9.getText().equals("O")))
        {
            timer.cancel();
            Button1.getStyleClass().add("changeColor");
            Button5.getStyleClass().add("changeColor");
            Button9.getStyleClass().add("changeColor");

            Button2.setDisable(true);
            Button3.setDisable(true);
            Button4.setDisable(true);

            Button6.setDisable(true);
            Button7.setDisable(true);
            Button8.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");

        } else if ((Button3.getText().equals("X") && Button5.getText().equals("X") && Button7.getText().equals("X")) ||
                (Button3.getText().equals("O") && Button5.getText().equals("O") && Button7.getText().equals("O")))
        {
            timer.cancel();
            Button3.getStyleClass().add("changeColor");
            Button5.getStyleClass().add("changeColor");
            Button7.getStyleClass().add("changeColor");
            Button1.setDisable(true);
            Button2.setDisable(true);

            Button4.setDisable(true);

            Button6.setDisable(true);

            Button8.setDisable(true);
            Button9.setDisable(true);
            JOptionPane.showMessageDialog(null, "You win!! Press reset to dominate in tic tac toe again!!");
        }
    }


}
