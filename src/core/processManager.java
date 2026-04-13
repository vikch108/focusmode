package core;
import java.io.IOException;
import java.lang.ProcessBuilder;

import config.AppConfig;

public class processManager{
	
	public static void BlockApps(String[] BLOCKED_APPS){
		for(String process :  BLOCKED_APPS){
			kill(process);
		}
		
		
	}
	public static void kill(String process){
		try{
			new ProcessBuilder("taskkill","/IM", process , "/F").start();
		}catch(Exception e ){
			System.out.println(e);
		}
	}
	
}