import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import edu.du.dudraw.DUDraw;

public class QuickHull extends BruteHull{


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


    }

    

    return pointSet; // return list

  }
  



  /***
   * 
   * Quicksort convex hull algorithm
   * 
   * @param pointSet
   * @return convexHull (ArrayList of points of convex hull)
   */
  public static ArrayList<Point> quickHull(ArrayList<Point> pointSet) {


    Point A = pointSet.get(findMinXIndex(pointSet)); // min x point
    Point B = pointSet.get(findMaxXIndex(pointSet)); // max x point
    ArrayList<Point> convexHull = new ArrayList<Point>();

    convexHull.add(A); //add min x to convex hull
    convexHull.add(B); //add max x to convex hull


    ArrayList<Point> upperHull = new ArrayList<Point>(); //create upperHull
    ArrayList<Point> lowerHull = new ArrayList<Point>(); //create lowerHull


    
    for (Point p : pointSet) { //for each point in the set
      if (distance(A, B, p) > 0) {
        upperHull.add(p);
      } else if (distance(A, B, p) < 0) {
        lowerHull.add(p);
      }
    }

    if (upperHull.size() > 0) {
    upperHull(upperHull, A, B, convexHull);
    } 
    
    if (lowerHull.size() > 0) {
    lowerHull(lowerHull, A, B, convexHull);
    }

    return convexHull;
  }

  /***
   * 
   * @param pointSet
   * @param a
   * @param b
   * @param Result
   * @return result(upperHull part of convex hull)
   */
  public static ArrayList<Point> upperHull(ArrayList<Point> pointSet, Point a, Point b,
      ArrayList<Point> Result) {

    Point furthest = findFurthest(pointSet, a, b);

    Result.add(furthest);

    ArrayList<Point> left = new ArrayList<Point>();
    ArrayList<Point> right = new ArrayList<Point>();


    for (Point p : pointSet) {

      if (distance(a, furthest, p) > 0) {
        left.add(p);
      } else if (distance(b, furthest, p) < 0) {
        right.add(p);
      }
    }

    if (left.size() != 0) {
      upperHull(left, a, furthest, Result);
    }

    if (right.size() != 0) {
      upperHull(right, furthest, b, Result);
    }

    return Result;
  }

/**
 * 
 * 
 * 
 * @param pointSet
 * @param a
 * @param b
 * @param Result
 * @return result (lower hull of convex hull)
 */
  public static ArrayList<Point> lowerHull(ArrayList<Point> pointSet, Point a, Point b,
      ArrayList<Point> Result) {

    Point furthest = lowerFindFurthest(pointSet, a, b);

    Result.add(furthest);

    ArrayList<Point> left = new ArrayList<Point>();
    ArrayList<Point> right = new ArrayList<Point>();


    for (Point p : pointSet) {

      if (distance(furthest, a, p) > 0) {
        left.add(p);
      } else if (distance(furthest, b, p) < 0) {
        right.add(p);
      }
    }

    if (left.size() != 0) {
      lowerHull(left, a, furthest, Result);
    }

    if (right.size() != 0) {
      lowerHull(right, furthest, b, Result);
    }

    return Result;
  }

  /***
   * 
   * Finds distance between line and point
   * 
   * @param a
   * @param b
   * @param p
   * @return distance between line and point
   */
  public static int distance(Point a, Point b, Point p) {


    int v1x = b.x - a.x;
    int v1y = b.y - a.y;
    int v2x = p.x - a.x;
    int v2y = p.y - a.y;


    // Math.abs
    return (v1x * v2y) - (v1y * v2x);



  }


/***
 * 
 * Finds furthest point from line
 * 
 * @param pointSet
 * @param a
 * @param b
 * @return furthestPoint
 */
  public static Point findFurthest(ArrayList<Point> pointSet, Point a, Point b) {

    Point furthestPoint = pointSet.get(0);


    for (int index = 1; index < pointSet.size(); index++) {
      if (distance(a, b, pointSet.get(index)) > distance(a, b, furthestPoint)) {
        furthestPoint = pointSet.get(index);
      }
    }
    

    return furthestPoint;
    
    
  }

  
  /***
   * Find furthest point from line but edited for the lower hull
   * 
   * @param pointSet
   * @param a
   * @param b
   * @return furthestPoint
   */
  public static Point lowerFindFurthest(ArrayList<Point> pointSet, Point a, Point b) {

    Point furthestPoint = pointSet.get(0);


    for (int index = 1; index < pointSet.size(); index++) {
      if ((-1 * distance(a, b, pointSet.get(index))) > (-1 * distance(a, b, furthestPoint))) {
        furthestPoint = pointSet.get(index);
      }
    }

    return furthestPoint;
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
      System.out.println(pointSet.get(i).toString());
      DUDraw.point(pointSet.get(i).x * 0.01, pointSet.get(i).y * 0.01);
    }

  }








 



}
