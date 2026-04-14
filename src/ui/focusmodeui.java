package ui;

import javax.swing.*;
import java.awt.*;
import service.focuservice;
 

public class focusmodeui {
	private JLabel statusLabel;
	
	 
	
	private JLabel timeLabel;
	private JButton startButton; 
	private JButton stopButton; 
	private JButton addProcessButton;
	private JTextField processField;
	public static JLabel timerLabel;
	
	public focusmodeui(){
		JFrame frame = new JFrame("Focus Mode");
		frame.setSize(400,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		statusLabel = new JLabel("Focus Mode:OFF",JLabel.CENTER);
		
		 timerLabel = new JLabel("00:00",JLabel.CENTER);
		
		
		timeLabel = new JLabel("Enter focus Minutes");
		JTextField timeField = new JTextField();
		
		
		startButton = new JButton("Start");
		stopButton = new JButton("stop");
		addProcessButton = new JButton("Add Process");
		processField = new JTextField();
		
		startButton.addActionListener(e -> {
			focuservice.startfocus(timeField.getText());
			statusLabel.setText("Focus Mode:ON");
		});
		
		stopButton.addActionListener(e -> {
			focuservice.stopfocus();
			statusLabel.setText("Focus Mode:OFF");
		});
		
		addProcessButton.addActionListener(e -> {
			String processname = JOptionPane.showInputDialog("Enter process name:");
			if (processname != null && !processname.isEmpty()) {
				focuservice.addProcess(processname);
			}else{
				JOptionPane.showMessageDialog(frame, "Please enter a valid process name.");
			}
		});
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7,1,10,10));
		
		
		panel.add(statusLabel);
		panel.add(timerLabel);
		panel.add(timeLabel);
		panel.add(timeField);
		panel.add(startButton);
		panel.add(stopButton);
		panel.add(addProcessButton);
		
		frame.add(panel);
		frame.setVisible(true);
		
		
	}

    public static void main(String[] args) {

        SwingUtilities.invokeLater(focusmodeui::new);
    }
}