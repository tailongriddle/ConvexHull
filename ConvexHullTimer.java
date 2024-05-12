import java.awt.Point;
import java.util.ArrayList;
import edu.du.dudraw.DUDraw;

public class ConvexHullTimer extends QuickHull{
  /***
  *
  * Main method to check correctness of quick hull
  * 
  * @param args
  */
 public static void main(String[] args) {


   int numberOfTrials = 1000;
   long startTime = 0;



   //Time BruteHull
   System.out.println("Time BruteHull: ");



   for (int n = 5; n <= 50; n += 5) {
     ArrayList<Point> test = PointSetGenerator(n); // create new random list

     

     startTime = System.currentTimeMillis(); // start time

     for (int i = 0; i < numberOfTrials; i++) { // test n size 1000 times
              bruteHull(test);
     }
     long endTime = System.currentTimeMillis(); // end time
     System.out.print(n + "  ");

     System.out.println((((endTime - startTime) / ((double) numberOfTrials))));
     
   }


   // Time QuickHull

   System.out.println("Time QuickHull: ");



   for (int j = 5; j <= 50; j += 5) {
     
     ArrayList<Point> test2  = PointSetGenerator(j);
     
     
     while (test2.isEmpty()) {
     test2 = PointSetGenerator(j); // create new random list
     }
     

     startTime = System.currentTimeMillis(); // start time

     for (int i = 0; i < numberOfTrials; i++) { // test n size 1000 times
              quickHull(test2);
     }
     long endTime = System.currentTimeMillis(); // end time
     System.out.print(j + "  ");

     System.out.println((((endTime - startTime) / ((double) numberOfTrials))));
     
   }


 }
}
