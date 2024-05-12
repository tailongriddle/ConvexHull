
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import edu.du.dudraw.DUDraw;

/***
 * 
 * @author tai
 *
 */
public class BruteHull {


  /***
   * 
   * This method creates a set of random points
   * 
   * @param size
   * @return PointSet
   */

  public static ArrayList<Point> PointSetGenerator(int size) {

    int x; // x coordinate of point
    int y; // y coorindate of point


    ArrayList<Point> pointSet = new ArrayList<Point>(size); // create new list

    Random rand = new Random(); // create Random instance

    for (int i = 0; i < size; i++) { // populate pointSet
      x = rand.nextInt(100); // generate random x
      y = rand.nextInt(100); // generate random y

      pointSet.add(new Point(x, y)); // add new point to list
      System.out.println(pointSet.get(i));


    }



    return pointSet; // return list

  }

  /***
   * 
   * Brute force algorithm for convex hull
   * 
   * @param test
   * @return convexHull (list of convex hull points)
   */
  public static ArrayList<Point> bruteHull(ArrayList<Point> pointSet) {
    int aX; // x coord for point a
    int aY; // y coord for point a

    int bX; // x coord for point b
    int bY; // y coord for point b

    int crossX; // x vector coord for point a,b
    int crossY; // y vector coord for point a,b

    int pX; // x vector coord for point p
    int pY; // y vector coord for point p

    int expected = 1;
    boolean isConvexPoint = false;

    ArrayList<Point> convexHull = new ArrayList<Point>(); // create new list


    // point a
    for (int indexOne = 0; indexOne < pointSet.size(); indexOne++) {
      aX = pointSet.get(indexOne).x;
      aY = pointSet.get(indexOne).y;

      // point b
      for (int indexTwo = 0; indexTwo < pointSet.size(); indexTwo++) {
        bX = pointSet.get(indexTwo).x;
        bY = pointSet.get(indexTwo).y;

        // find vector for cross-product
        crossX = bX - aX;
        crossY = bY - aY;

     

        if (indexOne != indexTwo) { // if it isn't the same point...
          isConvexPoint = true; // reset convex point to true
          expected = 1; // reset expected to 'neutral' 1

          // point p
          for (int crossIndex = 0; crossIndex < pointSet.size(); crossIndex++) {
            pX = pointSet.get(crossIndex).x - bX;
            pY = pointSet.get(crossIndex).y - bY;


            if ((crossX * pY) - (pX * crossY) > 0) {
              if (expected >= 1) {
                expected = 2;
              } else {
                isConvexPoint = false; // now it is false until next reset

              }



            } else if ((crossX * pY) - (pX * crossY) < 0) {
              if (expected <= 1) {
                expected = 0;

              } else {
                isConvexPoint = false; // now it is false until next reset

              }


            }
          }
        

          if (isConvexPoint == true) {
            convexHull.add(new Point(aX, aY));
            convexHull.add(new Point(bX, bY));



          }


        }


      }

    }
    return convexHull;

  }




  /***
   * 
   * Finds and returns the index of the coordinate with the maximum x value
   * 
   * @param pointSet
   * @return maxXIndex
   */
  public static int findMaxXIndex(ArrayList<Point> pointSet) {

    int maxXIndex = 0; // initialize the index of largest x to 0

    for (int index = 1; index < pointSet.size(); index++) {
      if (pointSet.get(index).x > pointSet.get(maxXIndex).x) {
        maxXIndex = index;
      }
    }

    return maxXIndex;

  }

  /***
   * 
   * finds and returns the index of the coordinate with the minimum X index
   * 
   * @param pointSet
   * @return minXIndex
   */
  public static int findMinXIndex(ArrayList<Point> pointSet) {

    int minXIndex = 0; // initialize the index of smallest x to 0

    for (int index = 1; index < pointSet.size(); index++) {
      if (pointSet.get(index).x < pointSet.get(minXIndex).x) {
        minXIndex = index;
      }
    }

    return minXIndex;

  }



  /***
   * 
   * @param pointSet
   */
  public static void drawHull(ArrayList<Point> pointSet) {
    DUDraw.setPenRadius(3);
    DUDraw.setPenColor(DUDraw.BLUE);


    for (int i = 0; i < pointSet.size(); i++) {
      DUDraw.point(pointSet.get(i).x * 0.01, pointSet.get(i).y * 0.01);
    }
  }


  /***
   * 
   * @param pointSet
   */
  public static void drawMinMaxX(ArrayList<Point> pointSet) {
    DUDraw.setPenRadius(1);
    DUDraw.setPenColor(DUDraw.RED);

    Point min = pointSet.get(findMinXIndex(pointSet));
    Point max = pointSet.get(findMaxXIndex(pointSet));


    System.out.println("Min: " + min);
    System.out.println("Max: " + max);

    DUDraw.line(min.x * 0.01, min.y * 0.01, max.x * 0.01, max.y * 0.01);

  }



  /***
   * Draws a set of points
   * 
   * @param pointSet
   */
  public static void drawPoints(ArrayList<Point> pointSet) {
    DUDraw.setPenRadius(3);
    DUDraw.setPenColor(DUDraw.BLACK);

    for (int i = 0; i < pointSet.size(); i++) {
      DUDraw.point(pointSet.get(i).x * 0.01, pointSet.get(i).y * 0.01);
    }

  }



}


