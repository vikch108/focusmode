package service;

import ui.focusmodeui;
import javax.swing.SwingUtilities;

import static java.lang.Thread.sleep;

import config.AppConfig;
import core.processManager;


public class focuservice {
    
     
        
    public static void startfocus(String time){
        try{
            int minutes = Integer.parseInt(time);
            processManager.running = true;
            startTimer(minutes);
        } catch (NumberFormatException e) {
            e.fillInStackTrace();
        }
        
    }
    
    public static void addProcess(String processName){
        try{
            AppConfig.BLOCKED_APPS.add(processName);
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
    
    public static void startTimer(int minutes){
        new Thread(() ->{
            int timeleft= minutes*60;
            processManager.BlockApps(AppConfig.BLOCKED_APPS);
            
            while(timeleft>0 && processManager.running){
                int min = timeleft/60;
                int sec = timeleft % 60;
                
                String time = String.format("%02d:%02d", min, sec);
                
                                SwingUtilities.invokeLater(() ->
                                        focusmodeui.timerLabel.setText(time)
                );
                
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.fillInStackTrace();
                }
                
                timeleft--;
            }
        }).start();
    }
    
    public static void stopfocus(){
        processManager.running = false;
        
    }
}