package core;

import static java.lang.Thread.currentThread;

import config.AppConfig;
import java.util.List;



public class processManager{
	public static  boolean running = false;
	public static void BlockApps(List<String> BLOCKED_APPS){
    	new Thread(()->{
    		while(running){
    			for(String process : BLOCKED_APPS) {
       				try {
        				new ProcessBuilder("taskkill","/IM", process , "/F").start();
        				Thread.sleep(AppConfig.CHECK_INTERVAL);
        			} catch (Exception e) {
        				e.fillInStackTrace();
        			}
    			}
    		}
    	}).start();
		
	}

	
}