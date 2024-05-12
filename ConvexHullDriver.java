import java.awt.Point;
import java.util.ArrayList;
import edu.du.dudraw.DUDraw;

/***
 * 
 * Test driver for ConvexHull class
 * 
 * @author tai
 *
 */
public class ConvexHullDriver extends QuickHull {



  /***
   *
   * Main method to check correctness of quick hull
   * 
   * @param args
   */
  public static void main(String[] args) {

    ArrayList<Point> test = PointSetGenerator(50);

    drawPoints(test);
    drawMinMaxX(test);


    //Test BruteHull
    DUDraw.setPenRadius(5);
    DUDraw.setPenColor(DUDraw.RED); //Makes points red outline
    
    
    
    drawHull(bruteHull(test));

    // Test QuickHull
    DUDraw.setPenRadius(3);
    DUDraw.setPenColor(DUDraw.GREEN); //Makes points green center
    
    drawHull(quickHull(test));



  }
}
