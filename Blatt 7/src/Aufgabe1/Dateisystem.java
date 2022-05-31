package Aufgabe1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.util.ArrayList;
import java.util.Arrays;

public class Dateisystem implements Visitable<File> {
	
	File root;
	
	public Dateisystem(File root) {
		this.root = root;
		if(!this.root.exists()) {
			throw new IllegalArgumentException(root.getPath() + "existiert nicht");
		}
		//this.root = root;

		System.out.println();
	}

	@Override
	public void accept(Visitor<File> v) {
		if(root.isDirectory()) {
			for(File file : root.listFiles()) {
				nextFile(file, v);
			}
		}else {
			v.visit(root);
		}
		
	}
	/**
	 * 
	 * @param current
	 * @param v
	 * @return
	 */
	public VisitResult nextFile(File current, Visitor<File> v) {
		if(!current.canRead()) {
			return v.visitFailed(current);
		}
		if(current.isDirectory()) {
			VisitResult tmp = v.preVisit(current);
			switch(tmp) {
			case CONTINUE:
				File[] files = current.listFiles();
				Arrays.sort(files);
				for(File f : files) {
					if(nextFile(f, v) == VisitResult.END) {
						return VisitResult.END;
					}
					
				}
				tmp = v.postVisit(current);
			default:
				return tmp;
			}
		}else {
			return v.visit(current);
		}
		
	}

}
