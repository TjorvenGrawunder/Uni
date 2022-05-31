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
	/**
	 * Name wird ausgegeben mit optional auch der Groesse. Sollte rekursiv als Argument gegeben sein wird CONTINUE
	 * ausgegeben, ansonsten wird der Teilbaum geskippt.
	 */
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
	/**
	 * Nach dem Visit wird einfach nur CONTINUE ausgegeben
	 */
	@Override
	public VisitResult postVisit(File o) {
		return VisitResult.CONTINUE;
	}
	/**
	 * Der Visitor "besucht" das uebergebene Element und gibt dessen Namen aus. Sollte -s als Argument uebergeben worden
	 * sein, so wird auch die Dateigroesse geprintet. 
	 */
	@Override
	public VisitResult visit(File o) {
		System.out.print(rientro + o.getName() + " ");
		if(s) {
			System.out.println("Size: " + getFileSize(o) + " Bytes");
		}
		return VisitResult.CONTINUE;
	}
	/**
	 * Wenn ein Visit fehlgeschlagen ist wird der Visit insgesamt trotzdem fortgesetzt, aber es kommt eine Meldung, dass
	 * eine Datei nicht gelesen werden konnte.
	 */
	@Override
	public VisitResult visitFailed(File o) {
		System.err.println("Datei " + o + " konnte nicht gelesen werden!");
		return VisitResult.CONTINUE;
	}
	/**
	 * Die Groesse der Datei wird in Bytes berechnet. Sollte es sich um ein Verzeichnis handeln werden rekursiv die Inhalte 
	 * des Verzeichnisses addiert.
	 * @param f
	 * @return Groesse der Datei
	 */
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
