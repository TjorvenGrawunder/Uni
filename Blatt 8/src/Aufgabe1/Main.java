/**
 * 
 */
package Aufgabe1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Timer;

/**
 * @author admin
 *
 */
public class Main {
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length == 0) {
			System.err.println("Bitte Argumente eingeben!");
			System.exit(-1);
		}
		File f = new File(args[0]);
		Timer t = new Timer();
		//ShutdownHook funktioniert nicht in Eclipse, da CTRL+C nicht erkannt wird und terminate das Programm nicht normal beendet
		Runtime.getRuntime().addShutdownHook(new Thread() {
	        public void run() {
	        	try {
					Thread.sleep(200);
		            System.out.println("Shutting down ...");
		            t.cancel();
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					e.printStackTrace();
				}
	        }
	    });
		//TimerTask wird in bestimmten Takt durchgefuehrt
		try {
			t.scheduleAtFixedRate(new FileTimeTask(f), 0, 1000);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
