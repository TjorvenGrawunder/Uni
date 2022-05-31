package Aufgabe1;

import java.io.File;

public class LsVisitor implements Visitor<File>{
	boolean r = false;
	boolean s = false;
	String rientro = "		";
	
	public LsVisitor(boolean r, boolean s) {
		this.r = r;
		this.s = s;
	}

	@Override
	public VisitResult preVisit(File o) {
		System.out.print("Ordner: " + o.getName() + " ");
		if(s) {
			System.out.println("Size: " + getFileSize(o) + " Bytes");
		}else {
			System.out.print("/n");
		}
		if(r) {
			return VisitResult.CONTINUE;
		}else {
			return VisitResult.SKIP;
		}
	}

	@Override
	public VisitResult postVisit(File o) {
		return VisitResult.CONTINUE;
	}

	@Override
	public VisitResult visit(File o) {
		System.out.print(rientro + o.getName() + " ");
		if(s) {
			System.out.println("Size: " + getFileSize(o) + " Bytes");
		}
		return VisitResult.CONTINUE;
	}

	@Override
	public VisitResult visitFailed(File o) {
		System.err.println("Datei " + o + " konnte nicht gelesen werden!");
		return VisitResult.CONTINUE;
	}

	private long getFileSize(File f) {
		long size = 0;
		if(!f.isDirectory()) {
			size = f.length();
		}else {
			File[] fs = f.listFiles();
			for (File file : fs) {
				size += getFileSize(file);
			}
		}
		return size;
	}

}
