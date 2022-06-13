package Aufgabe2;

import java.util.ArrayList;

/**
 * An {@code Ant} is created at a specific position of an {@link AntField} with
 * an initial {@code stepCount}. When running an Ant, it will lookup the values
 * on the current and all surrounding {@link Field}
 * (Moore-neighborhood) instances and test if the position is free, i.e. has a
 * value of {@code 0}, or if the value is greater than the {@code stepCount} of
 * this Ant. For both cases, the Ant will set the value of the {@code Field} at
 * the visited position to its own {@code stepCount+1}. After an {@code Ant} has
 * successfully visited one field, it will create new {@code Ant} instances with
 * an incremented {@code stepCount} to visit the other available {@code Field}
 * elements. The Ant will run until it finds no more {@code Field} elements in
 * its neighborhood to be altered.
 * 
 * @author Mathias Menninghaus (mathias.menninghaus@uos.de)
 * 
 */
public class Ant implements Runnable {

	private int x;
	private int y;
	private int stepCount;
	private boolean foundWay = true;

	private AntField fields;
   /**
    * 
    * @param fields
    *           the {@code AntField} on which this {@code Ant} operates
    * @param x
    *           x-axis value of the starting position
    * @param y
    *           y-axis value of the starting position
    * @param stepCount
    *           initial stepCount of this {@code Ant}.
    * 
    * @throws IllegalArgumentException
    *            If the {@code Field} at position {@code x,y} does not exist, or
    *            if its value is < 0
    */
   public Ant(AntField fields, int x, int y, int stepCount) {
	   if(fields.getField(x, y) != null) {
		   fields.getField(x, y).setValue(stepCount);
		   this.x = x;
		   this.y = y;
		   this.fields = fields;
		   this.stepCount = stepCount;
		   fields.increaseAntCount();
	   }else {
		   throw new IllegalArgumentException("Field " + x + ", " + y + " does not exist");
	   }
	   
   }

   public void run() {
	   while(foundWay) {
		   checkNeighbours();
	   }
	   fields.decreaseAntCount();
      
   }
   
   public void checkNeighbours() {
	   boolean firstWay = true;
	   foundWay = false;
	   //2aa
	   //a1a
	   //aaa
	   int x = this.x - 1;
	   int y = this.y - 1;
	   synchronized(fields) {
		   if(fields.getField(x, y) != null) {
			   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
				   if(firstWay) {
					   this.x = x;
					   this.y = y;
					   stepCount++;
					   fields.getField(x, y).setValue(stepCount);
					   firstWay = false;
					   foundWay = true;
				   }else {
					   Ant ant = new Ant(fields, x, y, stepCount);
					   new Thread(ant).start();
				   }
			   }
		   }
	   }
	   //aaa
	   //21a
	   //aaa
	   x = x+1;
	   y = y;
	   synchronized(fields) {
		   if(fields.getField(x, y) != null) {
			   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
				   if(firstWay) {
					   this.x = x;
					   this.y = y;
					   stepCount++;
					   fields.getField(x, y).setValue(stepCount);
					   firstWay = false;
					   foundWay = true;
				   }else {
					   Ant ant = new Ant(fields, x, y, stepCount);
					   new Thread(ant).start();
				   }
			   }
		   }
	   }
	   //aaa
	   //a1a
	   //2aa
	   x = x+1;
	   y = y;
	   synchronized(fields) {
		   if(fields.getField(x, y) != null) {
			   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
				   if(firstWay) {
					   this.x = x;
					   this.y = y;
					   stepCount++;
					   fields.getField(x, y).setValue(stepCount);
					   firstWay = false;
					   foundWay = true;
				   }else {
					   Ant ant = new Ant(fields, x, y, stepCount);
					   new Thread(ant).start();
				   }
			   }
		   }
	   }
	   //aaa
	   //a1a
	   //a2a
	   x = x;
	   y = y+1;
	   synchronized(fields) {
		   if(fields.getField(x, y) != null) {
			   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
				   if(firstWay) {
					   this.x = x;
					   this.y = y;
					   stepCount++;
					   fields.getField(x, y).setValue(stepCount);
					   firstWay = false;
					   foundWay = true;
				   }else {
					   Ant ant = new Ant(fields, x, y, stepCount);
					   new Thread(ant).start();
				   }
			   }
		   }
	   }
	   //aaa
	   //a1a
	   //aa2
	   x = x;
	   y = y+1;
	   synchronized(fields) {
		   if(fields.getField(x, y) != null) {
			   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
				   if(firstWay) {
					   this.x = x;
					   this.y = y;
					   stepCount++;
					   fields.getField(x, y).setValue(stepCount);
					   firstWay = false;
					   foundWay = true;
				   }else {
					   Ant ant = new Ant(fields, x, y, stepCount);
					   new Thread(ant).start();
				   }
			   }
		   }
	   }
	   //aaa
	   //a12
	   //aaa
	   x = x-1;
	   y = y;
	   synchronized(fields) {
		   if(fields.getField(x, y) != null) {
			   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
				   if(firstWay) {
					   this.x = x;
					   this.y = y;
					   stepCount++;
					   fields.getField(x, y).setValue(stepCount);
					   firstWay = false;
					   foundWay = true;
				   }else {
					   Ant ant = new Ant(fields, x, y, stepCount);
					   new Thread(ant).start();
				   }
			   }
		   }
	   }
	   //aa2
	   //a1a
	   //aaa
	   x = x-1;
	   y = y;
	   synchronized(fields) {
		   if(fields.getField(x, y) != null) {
			   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
				   if(firstWay) {
					   this.x = x;
					   this.y = y;
					   stepCount++;
					   fields.getField(x, y).setValue(stepCount);
					   firstWay = false;
					   foundWay = true;
				   }else {
					   Ant ant = new Ant(fields, x, y, stepCount);
					   new Thread(ant).start();
				   }
			   }
		   }
	   }
	   //a2a
	   //a1a
	   //aaa
	   x = x;
	   y = y-1;
	   synchronized (fields) {
		
	   if(fields.getField(x, y) != null) {
		   if(fields.getField(x, y).getValue() > stepCount+1 || fields.getField(x, y).getValue() == 0) {
			   if(firstWay) {
				   this.x = x;
				   this.y = y;
				   stepCount++;
				   fields.getField(x, y).setValue(stepCount);
				   firstWay = false;
				   foundWay = true;
			   }else {
				   Ant ant = new Ant(fields, x, y, stepCount);
				   new Thread(ant).start();
			   }
		   }
	   	}
	   }
   }
   

}
