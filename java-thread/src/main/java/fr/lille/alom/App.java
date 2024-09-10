package fr.lille.alom;

import java.util.Map;
import java.util.TreeSet;

/**
* Hello world!
*
*/
public class App
{
   public static void main( String[] args ) {
	   
    long startTime = System.nanoTime();
    
    Helloworld h1 = new Helloworld(startTime,"A");
    Helloworld h2 = new Helloworld(startTime,"B");
    
    h1.start();
    h2.start();
    
    try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      
      h1.finish();
      h2.finish();

      
      try {
        h1.join();
        h2.join();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      
      
    Map<Long, String> result = h1.getLogs();
    result.putAll(h2.getLogs());
    
     for(Long l : new TreeSet<Long>(result.keySet())) {
      System.out.println("["+l+"] "+result.get(l));
    }
    System.out.println("End of execution");
  }
}