package ui;

import javax.swing.*;
import java.awt.*;
import service.focuservice;
 

public class focusmodeui {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Focus Mode");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);

            JLabel statusLabel = new JLabel("Focus Mode: OFF");
            statusLabel.setHorizontalAlignment(JLabel.CENTER);

            JButton startButton = new JButton("Start Focus");
            JButton stopButton = new JButton("Stop Focus");

            startButton.addActionListener(e -> {
                focuservice.startfocus();
                statusLabel.setText("Focus Mode: ON");
            });

            stopButton.addActionListener(e -> {
                focuservice.stopfocus();
                statusLabel.setText("Focus Mode: OFF");
            });

            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(3, 1, 10, 10));
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            panel.add(statusLabel);
            panel.add(startButton);
            panel.add(stopButton);

            frame.add(panel);
            frame.setVisible(true);
        });
    }
}