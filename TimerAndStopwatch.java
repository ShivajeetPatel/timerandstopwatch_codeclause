/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.timerandstopwatch;

/**
 *
 * @author shiva
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

public class TimerAndStopwatch {
    private JFrame frame;
    private JLabel timerLabel;
    private JLabel stopwatchLabel;
    private JButton startTimerButton;
    private JButton stopTimerButton;
    private JButton startStopwatchButton;
    private JButton stopStopwatchButton;

    private Timer timer;
    private int timerSeconds;
    private Timer stopwatch;
    private int stopwatchSeconds;

    public TimerAndStopwatch() {
        frame = new JFrame("Timer and Stopwatch");
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        timerLabel = new JLabel("Timer: 0");
        stopwatchLabel = new JLabel("Stopwatch: 0");

        startTimerButton = new JButton("Start Timer");
        stopTimerButton = new JButton("Stop Timer");
        startStopwatchButton = new JButton("Start Stopwatch");
        stopStopwatchButton = new JButton("Stop Stopwatch");

        startTimerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        stopTimerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });

        startStopwatchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startStopwatch();
            }
        });

        stopStopwatchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopStopwatch();
            }
        });

        frame.add(timerLabel);
        frame.add(startTimerButton);
        frame.add(stopTimerButton);
        frame.add(stopwatchLabel);
        frame.add(startStopwatchButton);
        frame.add(stopStopwatchButton);

        frame.setVisible(true);
    }

    public void startTimer() {
        timer = new Timer();
        timerSeconds = 0;
        timerLabel.setText("Timer: " + timerSeconds);
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                timerSeconds++;
                timerLabel.setText("Timer: " + timerSeconds);
            }
        }, 1000, 1000);
    }

    public void stopTimer() {
        if (timer != null) {
            timer.cancel();
        }
    }

    public void startStopwatch() {
        stopwatch = new Timer();
        stopwatchSeconds = 0;
        stopwatchLabel.setText("Stopwatch: " + stopwatchSeconds);
        stopwatch.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                stopwatchSeconds++;
                stopwatchLabel.setText("Stopwatch: " + stopwatchSeconds);
            }
        }, 1000, 1000);
    }

    public void stopStopwatch() {
        if (stopwatch != null) {
            stopwatch.cancel();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimerAndStopwatch();
            }
        });
    }
}
