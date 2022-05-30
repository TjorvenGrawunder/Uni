package Aufgabe1;

import java.io.File;
import java.util.Arrays;

public class Ls implements Visitor<File> {
	
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
		//TO-DO
		Ls ls = new Ls();
		
		for(String path : paths) {
			File f = new File(path);
			if(!f.exists()) {
				System.err.println(f.getAbsolutePath() + " existiert nicht");
			}else {
				//TO-DO
				new Dateisystem(f).accept(ls);
			}
		}
	}

	@Override
	public VisitResult preVisit(File o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitResult postVisit(File o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitResult visit(File o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VisitResult visitFailed(File o) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
