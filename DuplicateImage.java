/**
 * Jordan Marx
 *
 * Class for duplicating an image the number of times indicated by the integer value
 * given by the user. The images line up from top to bottom.
 */

import java.awt.Color;

public class DuplicateImage
{

  public static void main (String[] args)
  {

    // Select a picture from the computer
    String filename1;
    filename1 = FileChooser.pickAFile ();
    System.out.println (filename1);

    // Create a picture
    Picture pic1 = new Picture (filename1);

    // Prompt the user for a number within a range of values
    int value;
    value = SimpleInput.getIntNumber ("Please enter an integer value between 1 and 10.", 1, 10);

    // Display the value entered by the user
    System.out.println ("The user entered: " + value);

    // Call a method to modify the picture
    Picture pic2;
    pic2 = duplicateImage(pic1, value);

    // Show the world
    pic2.show();

    // Save the picture
    String filename2;
    filename2 = FileChooser.pickAFile ();
    pic2.write (filename2);

  }

// Method for duplicating image a given number of times
  public static Picture duplicateImage (Picture p, int numDup)
  {
    Picture result = new Picture (  p.getWidth(), p.getHeight() * numDup );

    int x;
    int y;
    int z;
    int xMod;
    int yMod;
    Color c1;
    Pixel pix1, pixR;


    for ( x = 0 ; x < p.getWidth()  ; ++x )
    {
      for ( y = 0 ; y < p.getHeight()   ; ++y )
      {
        // Access the pixel at position (x,y)
        pix1 = p.getPixel (x, y);
        // Access the color value at that pixel
        c1 = pix1.getColor();

       for ( z = 0 ; z < numDup ; ++z )
       {
          xMod = x;
          yMod = y + z * p.getHeight();
          // Access the pixel at the modified position
          pixR = result.getPixel (xMod, yMod);
          // Store the color value in this second pixel
          pixR.setColor(c1);
       }
      }
    }
    
   return result;
  }


}
