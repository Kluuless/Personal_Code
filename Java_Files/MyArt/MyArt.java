import java.awt.Color;
/**
 * Make a picture!
 * 
 * @author Kyle Luu
 * @version 1.0
 */
public class MyArt
{
    private Picture image;

    /**
     *  Default Constructor: "puppy.jpg"
     */
    public MyArt()
    {
        image = new Picture("puppy.jpg");
    }
    
    /**
     *  Create an Art object using the jpg or bmp at the location "filename"
     */
    public MyArt(String filename) //parts a and b together
    {
        if(filename.equals(""))
        {
            image = new Picture("puppy.jpg"); //if empty string, makes object from "puppy.jpg"
        }
        else
        {
            image = new Picture(filename); 
        }
    }

    /**
     *  Show the Art object.
     */
    public void show()
    {
        image.show();
    }

    /**
     *  Creates new image with a size (tbd by user) and random background color
     */
    public MyArt(int mySize)
    {
        //sets a value for width of picture and height
        final int WIDTH = mySize * 16 / 9; //my preferred image size
        final int HEIGHT = (mySize);

        //makes new picture of width and height as set before
        image = new Picture(WIDTH, HEIGHT);

        /** generates RGB values with random colors **/
        int red = (int)(Math.random() * 255);
        int green = (int)(Math.random() * 255);
        int blue = (int)(Math.random() * 255);

        /** makes each pixel have RGB values as set before **/
        for(int x = 0; x < image.getWidth(); x++)
        {
            for(int y = 0; y < image.getHeight(); y++)
            {
                Pixel pixelObj = image.getPixel(x, y);

                pixelObj.setRed(red);
                pixelObj.setGreen(green);
                pixelObj.setBlue(blue);
            }
        }
    }

    /**
     *  Creates a new image with a side lengths (set by user), with each pixel a random color
     */
    public MyArt(int myWidth, int myLength)
    {
        final int WIDTH = myWidth;
        final int LENGTH = myLength;

        image = new Picture(WIDTH, LENGTH);

        /** generates image with random pixel colors **/
        for(int x = 0; x < image.getWidth(); x++)
        {
            for(int y = 0; y < image.getHeight(); y++)
            {
                Pixel pixelObj = image.getPixel(x, y);

                pixelObj.setRed((int)(Math.random() * 255));
                pixelObj.setGreen((int)(Math.random() * 255));
                pixelObj.setBlue((int)(Math.random() * 255));
            }
        }
    }

    /**
     *  Horizontally reflects the object.
     */
    public void reflect()
    {
        for(int x = 0; x < image.getWidth()/2; x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel pixelOne = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelOneRed = pixelOne.getRed(); //stores the left half pixel's red value
                int pixelOneBlue = pixelOne.getBlue(); //stores the left half pixel's blue value
                int pixelOneGreen = pixelOne.getGreen(); //stores the left half pixel's green value

                Pixel pixelTwo = image.getPixel(image.getWidth() - 1 - x, y); //new pixel object of pixel starting at top right

                int pixelTwoRed = pixelTwo.getRed(); //stores the right half pixel's red value
                int pixelTwoBlue = pixelTwo.getBlue(); //stores the right half pixel's blue value
                int pixelTwoGreen = pixelTwo.getGreen(); //stores the right half pixel's green value

                //////////////////////////////////////sets the pixels equal to each other//////////////////////////////////////

                //for left half
                pixelOne.setRed(pixelTwoRed);
                pixelOne.setBlue(pixelTwoBlue);
                pixelOne.setGreen(pixelTwoGreen);

                //for right half
                pixelTwo.setRed(pixelOneRed);
                pixelTwo.setBlue(pixelOneBlue);
                pixelTwo.setGreen(pixelOneGreen);
            }
        }
    }

    /**
     *  Adds another copy of the image to the right
     */
    public void doubleHorizontal()
    {
        final int NEW_WIDTH = image.getWidth() * 2; //sets the value of the new width
        final int HEIGHT = image.getHeight(); //sets the value of the height

        Picture newPic = new Picture(NEW_WIDTH,HEIGHT); //creates new object with 2 times the width

        for(int x = 0; x < image.getWidth(); x++) //for every pixel row
        {
            for(int y = 0; y < image.getHeight(); y++) //for every pixel column
            {
                Pixel scannedPixel = image.getPixel(x, y); //takes the RGB values of a pixel
                int pixelRed = scannedPixel.getRed(); //stores the redness
                int pixelGreen = scannedPixel.getGreen(); //stores the greenness
                int pixelBlue = scannedPixel.getBlue(); //stores the blueness

                Pixel leftHalf = newPic.getPixel(x, y); //manipulates the left half
                leftHalf.setRed(pixelRed); //sets the newPic red values equal to the original image
                leftHalf.setGreen(pixelGreen); //sets the newPic green values equal to the original image
                leftHalf.setBlue(pixelBlue); //sets the newPic blue values equal to the original image

                Pixel rightHalf = newPic.getPixel(image.getWidth() + x, y); //manipulates the right half
                rightHalf.setRed(pixelRed); //sets the newPic red values equal to the original image
                rightHalf.setGreen(pixelGreen); //sets the newPic green values equal to the original image
                rightHalf.setBlue(pixelBlue); //sets the newPic blue values equal to the original iimage
            }
        }

        image = newPic; //replace image with newPic
    }

    /**
     *  Adds another copy of the image below.
     */
    public void doubleVertical()
    {
        final int NEW_WIDTH = image.getWidth(); //sets value of the width
        final int HEIGHT = image.getHeight() * 2; //sets the value of the new height

        Picture newPic = new Picture(NEW_WIDTH,HEIGHT); //makes a new object with width equal to double the original width

        for(int x = 0; x < image.getWidth(); x++) //for every pixel row
        {
            for(int y = 0; y < image.getHeight(); y++) //for every pixel column
            {
                Pixel scannedPixel = image.getPixel(x, y); //takes the RGB values of a pixel
                int pixelRed = scannedPixel.getRed(); //stores the redness
                int pixelGreen = scannedPixel.getGreen(); //stores the greenness
                int pixelBlue = scannedPixel.getBlue(); //stores the blueness

                Pixel topHalf = newPic.getPixel(x, y); //manipulates the top half
                topHalf.setRed(pixelRed); //sets the newPic red values equal to the original image
                topHalf.setGreen(pixelGreen); //sets the newPic green values equal to the original image
                topHalf.setBlue(pixelBlue); //sets the newPic blue values equal to the original image

                Pixel bottomHalf = newPic.getPixel(x, image.getHeight() + y); //manipulates the bottom half
                bottomHalf.setRed(pixelRed); //sets the newPic red values equal to the original image
                bottomHalf.setGreen(pixelGreen); //sets the newPic green values equal to the original image
                bottomHalf.setBlue(pixelBlue); //sets the newPic blue values equal to the original image
            }
        }

        image = newPic; //replace image with newPic
    }

    /**
     *  puts a border around the image.
     */
    public void borderArea()
    {
        int wBorder = (int)(0.02 * image.getWidth()); //sets the side border length
        int hBorder = (int)(0.02 * image.getHeight()); //sets the top and bottom border length

        //new picture with dimensions including the border
        Picture newPic = new Picture(2 * wBorder + image.getWidth() , 2 * hBorder + image.getHeight());

        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel pixelOne = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = pixelOne.getRed(); //stores the image pixel's red value
                int pixelBlue = pixelOne.getBlue(); //stores the image pixel's blue value
                int pixelGreen = pixelOne.getGreen(); //stores the image pixel's green value

                Pixel pixelTwo = newPic.getPixel(x + wBorder, y + hBorder);
                //sets newPic pixels equal to the image's pixels, with respect to the border

                pixelTwo.setRed(pixelRed);
                pixelTwo.setBlue(pixelBlue);
                pixelTwo.setGreen(pixelGreen);
            }
        }

        //calculates the area and prints it, if desired, un-commment
        //int areaImage = image.getHeight() * image.getWidth();
        //int areaNewPic = newPic.getHeight() * newPic.getWidth();
        //System.out.println("Area increase is: " + (((double)areaNewPic - areaImage) / areaImage) * 100) + " percent";

        image = newPic; //replaces old image with newPic
    }
    
    /**
     *  puts a border around the image.
     */
    public void border()
    {
        int wBorder = (int)(0.05 * image.getWidth()); //sets the side border length
        int hBorder = (int)(0.05 * image.getHeight()); //sets the top and bottom border length

        //new picture with dimensions including the border
        Picture newPic = new Picture(2 * wBorder + image.getWidth() , 2 * hBorder + image.getHeight());

        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel pixelOne = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = pixelOne.getRed(); //stores the image pixel's red value
                int pixelBlue = pixelOne.getBlue(); //stores the image pixel's blue value
                int pixelGreen = pixelOne.getGreen(); //stores the image pixel's green value

                Pixel pixelTwo = newPic.getPixel(x + wBorder, y + hBorder);
                //sets newPic pixels equal to the image's pixels, with respect to the border

                pixelTwo.setRed(pixelRed);
                pixelTwo.setBlue(pixelBlue);
                pixelTwo.setGreen(pixelGreen);
            }
        }

        //calculates the area and prints it, if desired, un-commment
        //int areaImage = image.getHeight() * image.getWidth();
        //int areaNewPic = newPic.getHeight() * newPic.getWidth();
        //System.out.println("Area increase is: " + (((double)areaNewPic - areaImage) / areaImage) * 100) + " percent";

        image = newPic; //replaces old image with newPic
    }
    
    /**
     *  Swaps the R value with G, G with B, and B with R
     */
    public void swapColors()
    {
        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel scannedPixel = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = scannedPixel.getRed(); //stores the image pixel's red value
                int pixelBlue = scannedPixel.getBlue(); //stores the image pixel's blue value
                int pixelGreen = scannedPixel.getGreen(); //stores the image pixel's green value

                scannedPixel.setRed(pixelBlue);
                scannedPixel.setBlue(pixelGreen);
                scannedPixel.setGreen(pixelRed);
            }
        }
    }
    
    /**
     * Returns the image
     */
    public Picture getImage()
    {
        return this.image;
    }
    
    /**
     *  Vertically reflects the image (makes it upside down)
     */
    public void verticalReflect()
    {
        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight()/2; y++) //performs loop for every row
            {
                Pixel pixelOne = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelOneRed = pixelOne.getRed(); //stores the left half pixel's red value
                int pixelOneBlue = pixelOne.getBlue(); //stores the left half pixel's blue value
                int pixelOneGreen = pixelOne.getGreen(); //stores the left half pixel's green value

                Pixel pixelTwo = image.getPixel(x, image.getHeight() - 1 - y); //new pixel object of pixel starting at top right

                int pixelTwoRed = pixelTwo.getRed(); //stores the right half pixel's red value
                int pixelTwoBlue = pixelTwo.getBlue(); //stores the right half pixel's blue value
                int pixelTwoGreen = pixelTwo.getGreen(); //stores the right half pixel's green value

                //////////////////////////////////////sets the pixels equal to each other//////////////////////////////////////

                //for left half
                pixelOne.setRed(pixelTwoRed);
                pixelOne.setBlue(pixelTwoBlue);
                pixelOne.setGreen(pixelTwoGreen);

                //for right half
                pixelTwo.setRed(pixelOneRed);
                pixelTwo.setBlue(pixelOneBlue);
                pixelTwo.setGreen(pixelOneGreen);
            }
        }
    }
    
    /**
     *  inverts the colors (255-colorValue)
     */
    public void invertColors()
    {
        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel scannedPixel = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = 255 - scannedPixel.getRed(); //stores the image pixel's red value
                int pixelBlue = 255 - scannedPixel.getBlue(); //stores the image pixel's blue value
                int pixelGreen = 255 - scannedPixel.getGreen(); //stores the image pixel's green value

                scannedPixel.setRed(pixelBlue);
                scannedPixel.setBlue(pixelGreen);
                scannedPixel.setGreen(pixelRed);
            }
        }
    }
    
    public void masterpiece()
    {
        Picture finalImage = new Picture (2 * image.getWidth(), 2 * image.getHeight());

        reflect();
        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel scannedPixel = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = scannedPixel.getRed(); //stores the image pixel's red value
                int pixelBlue = scannedPixel.getBlue(); //stores the image pixel's blue value
                int pixelGreen = scannedPixel.getGreen(); //stores the image pixel's green value

                Pixel thePixel = finalImage.getPixel(x,y);
                thePixel.setRed(pixelRed);
                thePixel.setBlue(pixelBlue);
                thePixel.setGreen(pixelGreen);
            }
        }

        reflect();
        swapColors();
        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel scannedPixel = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = scannedPixel.getRed(); //stores the image pixel's red value
                int pixelBlue = scannedPixel.getBlue(); //stores the image pixel's blue value
                int pixelGreen = scannedPixel.getGreen(); //stores the image pixel's green value

                Pixel thePixel = finalImage.getPixel(x + image.getWidth() - 1,y);
                thePixel.setRed(pixelRed);
                thePixel.setBlue(pixelBlue);
                thePixel.setGreen(pixelGreen);
            }
        }

        verticalReflect();
        reflect();
        swapColors();
        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel scannedPixel = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = scannedPixel.getRed(); //stores the image pixel's red value
                int pixelBlue = scannedPixel.getBlue(); //stores the image pixel's blue value
                int pixelGreen = scannedPixel.getGreen(); //stores the image pixel's green value

                Pixel thePixel = finalImage.getPixel(x,y + image.getHeight() - 1);
                thePixel.setRed(pixelRed);
                thePixel.setBlue(pixelBlue);
                thePixel.setGreen(pixelGreen);
            }
        }

        reflect();
        invertColors();
        for(int x = 0; x < image.getWidth(); x++) //mirrors the right half to the left and the left to the right
        {
            for (int y = 0; y < image.getHeight(); y++) //performs loop for every row
            {
                Pixel scannedPixel = image.getPixel(x, y); //new pixel object of pixel starting at top left

                int pixelRed = scannedPixel.getRed(); //stores the image pixel's red value
                int pixelBlue = scannedPixel.getBlue(); //stores the image pixel's blue value
                int pixelGreen = scannedPixel.getGreen(); //stores the image pixel's green value

                Pixel thePixel = finalImage.getPixel(x + image.getWidth() - 1,y + image.getHeight() - 1);
                thePixel.setRed(pixelRed);
                thePixel.setBlue(pixelBlue);
                thePixel.setGreen(pixelGreen);
            }
        }
        
        image = finalImage;
    }
}
