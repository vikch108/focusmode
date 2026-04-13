package ui;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

    
public class focusmodeui {
    static boolean running = false;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Focus Mode");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        
        
        JLabel statuslabel = new JLabel("focus mode:OFF");
        frame.add(statuslabel);
        
        JButton startButton = new JButton("Start");
        frame.add(startButton);
        
        JButton stopButton = new JButton("Stop");
        frame.add(stopButton);
        
        startButton.addActionListener(e -> {
            running = true;
            statuslabel.setText("focus mode:ON");
            new Thread(() -> {
                while(running){
                    blockapps();
                    
                    try{
                        Thread.sleep(3000);
                    }catch(InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }).start();
        });
        
        stopButton.addActionListener(e -> {
            running = false;
            statuslabel.setText("focus mode:OFF");
        });
    }
    public static void blockapps(){
        killprocess("msedge.exe");
    }
    
    public static void killprocess(String processName){
        try{
            new ProcessBuilder("taskkill","/IM",processName,"/F").start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}