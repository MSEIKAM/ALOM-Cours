package fr.lille.alom;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Helloworld extends Thread {

   private Random random = new Random();
   private Map<Long, String> logs = new HashMap<Long, String> ();
   private Long startTime;
   private String name;
   
   private boolean running = true;

   public Helloworld(Long startTime, String name) {
     this.startTime=startTime;
     this.name = name;
  }

   public Map<Long, String> getLogs() {
     return this.logs;
    }

   public void run() {
	   int i=0;
	   while(running) {
		   this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"] count : ["+i+"]");
	       if(random.nextInt(100) < 10) {
	         this.logs.put((System.nanoTime()-startTime),"Thread ["+name+"] yield");
	        Thread.yield();
	      }
	       
	       i++; 
	   } 
  }
   
   public void finish() {
	   running = false;
	   }
}
