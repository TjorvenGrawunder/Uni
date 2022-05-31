package Aufgabe1;

import java.io.File;
import java.util.Arrays;

public class Ls{
	
	static boolean r = false;
	static boolean s = false;
	static boolean argsEnd = false;
	
	public static void main(String args[]){
		int i = 0;
		while(!argsEnd && i < args.length) {
			if(args[i].equals("-r")) {
				r = true;
				i++;
			}else if(args[i].equals("-s")) {
				s = true;
				i++;
			}else {
				argsEnd = true;
			}
		}
		String[] paths = Arrays.copyOfRange(args, i, args.length);
		
		if(paths.length == 0) {
			paths = new String[] { "." };
		}
		
		LsVisitor visitor = new LsVisitor(r, s);
		
		for(String path : paths) {
			System.out.println("Listing " + path);
			File f = new File(path);
			if(!f.exists()) {
				System.err.println(" existiert nicht");
			}else {
				//TO-DO
				new Dateisystem(f).accept(visitor);
			}
		}
	}
	

	
}
