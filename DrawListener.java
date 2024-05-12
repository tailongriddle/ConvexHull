/******************************************************************************
 *  Compilation:  javac DrawListener.java
 *  Execution:    none
 *  Dependencies: none
 *
 *  Interface that accompanies Draw.java.
 ******************************************************************************/

/**
 *  <i>DrawListener</i>. This interface provides a basic capability for
 *  responding to keyboard in mouse events from {@link Draw} via callbacks.
 *  You can see some examples in
 *  <a href="https://introcs.cs.princeton.edu/java/36inheritance">Section 3.6</a>.
 *
 *  <p>
 *  For additional documentation, see
 *  <a href="https://introcs.cs.princeton.edu/31datatype">Section 3.1</a> of
 *  <i>Computer Science: An Interdisciplinary Approach</i> by Robert Sedgewick and Kevin Wayne.
 *
 *
 * Original Authors:
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 *
 * DUDraw Fork Additions by:
 *  @author Joseph Brooksbank
 *  @author Ryan Dunagan
 *  @author Declan Kahn
 *  @author Eddy Rogers
 */
package edu.du.dudraw;
public interface DrawListener {

    /**
     * Invoked when the mouse has been pressed.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    void mousePressed(double x, double y);

    /**
     * Invoked when the mouse has been dragged.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    void mouseDragged(double x, double y);

    /**
     * Invoked when the mouse has been released.
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    void mouseReleased(double x, double y);

    /**
     * Invoked when the mouse has been clicked (pressed and released without the cursor moving).
     *
     * @param x the x-coordinate of the mouse
     * @param y the y-coordinate of the mouse
     */
    void mouseClicked(double x, double y);

    /**
     * Invoked when a key has been typed.
     *
     * @param c the character typed
     */
    void keyTyped(char c);

    /**
     * Invoked when a key has been pressed.
     *
     * @param keycode the key combination pressed
     */
    void keyPressed(int keycode);

    /**
     * Invoked when a key has been released.
     *
     * @param keycode the key combination released
     */
    void keyReleased(int keycode);

    /**
     * Invoked every update period, specified with {@link Draw#setFrameTime(int)}.
     * <br>
     * Started with {@link Draw#startUpdate()}.
     * <br>
     * Stopped with {@link Draw#stopUpdate()}.
     */
    void update();
}
