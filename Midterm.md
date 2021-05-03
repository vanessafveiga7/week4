Midterm completed with my answers.

Problem 1.  Karel the Robot

    package week4;
    import stanford.karel.*;
    public class InnerBorderKarel extends SuperKarel {
      /**
       * 
       */
      private static final long serialVersionUID = 1L;

      public void run() {
        moveUpRow();
        for(int i = 0; i < 4; i++) {
          handleBorder();
          nextPosition();
        }
      }


      private void handleBorder() {
        move();
        while (frontIsClear()) {

          if (noBeepersPresent()) {
            putBeeper();
          }
          move();
        }
      }
      private void moveUpRow() {
        turnLeft();
        move();
        turnRight();
      }

      private void nextPosition() {
        turnRight();
        move();
        turnRight();
        move();
        turnRight();
      }
    }
    
Problem 2. Java expressions, statements, and methods.
2a)
1.25
false
"B84"

2b)
78
73

Problem 3. Console Programs

    package week4;

    import acm.program.*;
    public class SecondLargest extends ConsoleProgram {
      private static final int SENTINEL = 0;
      public void run() {
        println("This program finds the two largest integers in a");
        println("list. Enter values, one per line, using a "
            + SENTINEL + " to");
        println("signal the end of the list.");
        int largest = -1;
        int secondLargest = -1;
        int input = readInt(" ? ");
        while (input != SENTINEL) {
          if (input > largest) {
            secondLargest = largest;
            largest = input;
          } else if (input > secondLargest) {
            secondLargest = input;
          }
          input = readInt(" ? ");
        }
        println("The largest value is " + largest);
        println("The second largest is " + secondLargest);
      }
    }

Problem 4. Graphics Programs

    package week4;

    import acm.graphics.*;
    import acm.program.*;
    import java.awt.*;
    import java.awt.event.*;
    public class Frogger extends GraphicsProgram {
      /**
       * 
       */
      private static final long serialVersionUID = 1L;
      private GImage frog;
      public void run() {
        // Just for testing purposes; try changing window size here
        setCanvasSize(300, 220);
        frog = new GImage("res/frog.gif");
        double fx = (getWidth() - frog.getWidth()) / 2;
        double fy = getHeight() - frog.getHeight();
        add(frog, fx, fy);
      }
      public void mouseClicked(MouseEvent event) {
        double mouseY = event.getY();
        double frogTop = frog.getY();
        double frogHeight = frog.getHeight();
        double frogBottom = frogTop + frogHeight;
        if (mouseY < frogTop && frogTop >= frogHeight) {
          frog.move(0, -frogHeight);
        } else if (mouseY > frogBottom &&
            frogBottom + frogHeight <= getHeight()) {
          frog.move(0, frogHeight);
        }
      }
    }
    
Problem 5. Strings, Characters and Files

5a) removeDuplicates

    private String removeDuplicates(String str) {
      String result = "";
      for (int i = 0; i < str.length(); i++) {
        char ch = str.charAt(i);
        if (i == 0 || ch != str.charAt(i - 1)) {
          result += ch;
        }
      }
      return result;
    }

5b) removeDuplicatesFromFile

    private void removeDuplicatesFromFile(String filename) {
      try {
        Scanner input = new Scanner(new File(filename));

        while (input.hasNextLine()) {
          String line = input.nextLine();
          Scanner tokens = new Scanner(line);
          while (tokens.hasNext()) {
            String word = tokens.next();
            print(removeDuplicates(word) + " ");
          }
          println();
        }
        input.close();
      } catch (IOException fnfe) {
        println("file could not be read");
      }
