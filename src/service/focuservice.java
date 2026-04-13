package service;
import core.processManager;


import static java.lang.Thread.sleep;

import config.AppConfig;


public class focuservice {
    
    private static  boolean running = false; 
    public  static void startfocus(){
        running = true ;
        
        new Thread(() ->{
            while(running){
                processManager.BlockApps(AppConfig.BLOCKED_APPS);
                    try{
                        Thread.sleep(AppConfig.CHECK_INTERVAL);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
            
        }).start();
    }   
    
    public static void stopfocus(){
        running = false;
    }
}