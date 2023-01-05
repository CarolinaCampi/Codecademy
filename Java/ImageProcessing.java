import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Random;
import javax.imageio.ImageIO;
public class ImageProcessing {
	public static void main(String[] args) {
    // The provided images are apple.jpg, flower.jpg, and kitten.jpg
		int[][] imageData = imgToTwoD("./apple.jpg");
    
    // Or load your own image using a URL!
		//int[][] imageData = imgToTwoD("https://content.codecademy.com/projects/project_thumbnails/phaser/bug-dodger.png");
		//viewImageData(imageData);
    
		int[][] trimmed = trimBorders(imageData, 60);
		twoDToImage(trimmed, "./trimmed_apple.jpg");

    int[][] negative = negativeColor(imageData);
    twoDToImage(negative, "./negative_apple.jpg");

    int[][] stretched = stretchHorizontally(imageData);
    twoDToImage(stretched, "./stretched_apple.jpg");

    int[][] shrunk = shrinkVertically(imageData);
    twoDToImage(shrunk, "./shrunk_apple.jpg");

    int[][] inverted = invertImage(imageData);
    twoDToImage(inverted, "./inverted_apple.jpg");

    int[][] filtered = colorFilter(imageData, 100, -50, 100);
    twoDToImage(filtered, "./filtered_apple.jpg");

		int[][] allFilters = stretchHorizontally(shrinkVertically(colorFilter(negativeColor(trimBorders(invertImage(imageData), 50)), 200, 20, 40)));
    twoDToImage(allFilters, "./allfilters_apple.jpg");
		
    // Painting with pixels

    int[][] randomImage = new int[500][500];
    int[][] random = paintRandomImage(randomImage);
    twoDToImage(random, "./random.jpg");

    int[] randomRGBA = {255, 255, 0, 255};
    int randomColor = getColorIntValFromRGBA(randomRGBA);
    int[][] withRectangle = paintRectangle(imageData, 15, 15, 15, 15, randomColor);
    twoDToImage(withRectangle, "./rectangle_apple.jpg");

    int[][] imageWithRectangles = generateRectangles(imageData, 3);
    twoDToImage(imageWithRectangles, "./apple_with_rectangles.jpg");
	}

	
  // Image Processing Methods

  //Trim the borders of the image ImageTwoD by pixelCount on each side
	public static int[][] trimBorders(int[][] imageTwoD, int pixelCount) {
		// Example Method
		if (imageTwoD.length > pixelCount * 2 && imageTwoD[0].length > pixelCount * 2) {
			int[][] trimmedImg = new int[imageTwoD.length - pixelCount * 2][imageTwoD[0].length - pixelCount * 2];
			for (int i = 0; i < trimmedImg.length; i++) {
				for (int j = 0; j < trimmedImg[i].length; j++) {
					trimmedImg[i][j] = imageTwoD[i + pixelCount][j + pixelCount];
				}
			}
			return trimmedImg;
		} else {
			System.out.println("Cannot trim that many pixels from the given image.");
			return imageTwoD;
		}
	}

  // Obtain an image with the negative colors of the original
	public static int[][] negativeColor(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    int[][] negativeImg = new int[imageTwoD.length][imageTwoD[0].length];
    for (int i = 0; i < imageTwoD.length; i++) {
				for (int j = 0; j < imageTwoD[i].length; j++) {
					int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
          rgba[0] = 255 - rgba[0];
          rgba[1] = 255 - rgba[1];
          rgba[2] = 255 - rgba[2];
          negativeImg[i][j] = getColorIntValFromRGBA(rgba);
				}
			}
		return negativeImg;
	}

  // stretchHorizontally() will double the width of the provided image data. 
	public static int[][] stretchHorizontally(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    int[][] stretchedImg = new int[imageTwoD.length][2*imageTwoD[0].length];
     for (int i = 0; i < imageTwoD.length; i++) {
				for (int j = 0; j < imageTwoD[i].length; j++) {
          int it = j*2;
          stretchedImg[i][it] = imageTwoD[i][j];
          stretchedImg[i][it+1] = imageTwoD[i][j];
				}
			}
		return stretchedImg;
	}

  // Shrinks vertically an image by halfing the height and selecting every other pixel down each column.
	public static int[][] shrinkVertically(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    int[][] shrunkImg = new int[imageTwoD.length/2][imageTwoD[0].length];
     for (int i = 0; i < imageTwoD[0].length; i++) {
				for (int j = 0; j < (imageTwoD.length - 1); j+=2) {
          shrunkImg[j/2][i] = imageTwoD[j][i];
				}
			}
		return shrunkImg;
	}

  // invertImage inverts the image upside down
	public static int[][] invertImage(int[][] imageTwoD) {
		// TODO: Fill in the code for this method
    int[][] invertedImg = new int[imageTwoD.length][imageTwoD[0].length];
    for (int i = 0; i < imageTwoD.length; i++) {
				for (int j = 0; j < imageTwoD[i].length; j++) {
          invertedImg[i][j] = imageTwoD[(imageTwoD.length-1)-i][(imageTwoD[i].length-1)-j];
				}
			}
		return invertedImg;
	}

  public static int checkAndChangeRGB(int originalRGB, int modifier){
     int newRGB = originalRGB + modifier;
    if (newRGB > 255) {
      newRGB = 255;
    } else if (newRGB < 0) {
      newRGB = 0;
    } 
    return newRGB;
  }


 //colorFilter() modifies every pixel in the image by provided R, G, and B values as input parameters. 
	public static int[][] colorFilter(int[][] imageTwoD, int redChangeValue, int greenChangeValue, int blueChangeValue) {
		// TODO: Fill in the code for this method
    int[][] filteredImg = new int[imageTwoD.length][imageTwoD[0].length];
    for (int i = 0; i < imageTwoD.length; i++) {
				for (int j = 0; j < imageTwoD[i].length; j++) {
          int[] rgba = getRGBAFromPixel(imageTwoD[i][j]);
          rgba[0] = checkAndChangeRGB(rgba[0], redChangeValue);
          rgba[1] = checkAndChangeRGB(rgba[1], greenChangeValue);
          rgba[2] = checkAndChangeRGB(rgba[2], blueChangeValue);
          filteredImg[i][j] = getColorIntValFromRGBA(rgba);
				}
			}
		return filteredImg;
	}
  
	// Painting Methods

    //paintRandomImage() modifies the image passed in by replacing every pixel with a randomly colored pixel.
	public static int[][] paintRandomImage(int[][] canvas) {
		// TODO: Fill in the code for this method
    Random rand = new Random();
    for (int i = 0; i < canvas.length; i++) {
				for (int j = 0; j < canvas[i].length; j++) {
          int randomR = rand.nextInt(256);
          int randomB = rand.nextInt(256);
          int randomG = rand.nextInt(256);
          int[] randomRGB = {randomR, randomB, randomG, 255};
          canvas[i][j] = getColorIntValFromRGBA(randomRGB);
				}
			}
		return canvas;
	}

  // paintRectangle() draws a rectangle on an image using a provided width, height, rowPosition, columnPosition, and color. 
	public static int[][] paintRectangle(int[][] canvas, int width, int height, int rowPosition, int colPosition, int color) {
		// TODO: Fill in the code for this method
    for (int i = 0; i < canvas.length; i++) {
				for (int j = 0; j < canvas[i].length; j++) {
            if (i >= rowPosition && i <= (rowPosition + width)){
              if (j >= colPosition && j <= (colPosition + height)){
                canvas[i][j] = color;
              }
            }
				}
			}
		return canvas;
	}

  // generateRectangles() will use the paintRectangles() method in order to paint a piece of art. It will generate randomly positioned, sized, and colored rectangles based on the provided number. The input parameter, numRectangles will determine how many randomly generated rectangles will be placed in the image.
	public static int[][] generateRectangles(int[][] canvas, int numRectangles) {
		// TODO: Fill in the code for this method
    Random rand = new Random();
    for (int i = 0; i < numRectangles; i++){
      int width = rand.nextInt(canvas[0].length);
      int height = rand.nextInt(canvas.length);
      int rowPosition = rand.nextInt(canvas.length - height);
      int colPosition = rand.nextInt(canvas[0].length - width);
      int randomR = rand.nextInt(256);
      int randomB = rand.nextInt(256);
      int randomG = rand.nextInt(256);
      int[] randomRGBA = {randomR, randomB, randomG, 255};
      int randomColor = getColorIntValFromRGBA(randomRGBA);
      canvas = paintRectangle(canvas, width, height, rowPosition, colPosition, randomColor);
    }

		return canvas;
	}


	// Utility Methods

  //imgToTwoD() accepts a String which can be a file path or image URL. It returns a 2D array of integers that contains every pixel from the image stored as int hexadecimal values containing the RGBA values for the pixel. 
	public static int[][] imgToTwoD(String inputFileOrLink) {
		try {
			BufferedImage image = null;
			if (inputFileOrLink.substring(0, 4).toLowerCase().equals("http")) {
				URL imageUrl = new URL(inputFileOrLink);
				image = ImageIO.read(imageUrl);
				if (image == null) {
					System.out.println("Failed to get image from provided URL.");
				}
			} else {
				image = ImageIO.read(new File(inputFileOrLink));
			}
			int imgRows = image.getHeight();
			int imgCols = image.getWidth();
			int[][] pixelData = new int[imgRows][imgCols];
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					pixelData[i][j] = image.getRGB(j, i);
				}
			}
			return pixelData;
		} catch (Exception e) {
			System.out.println("Failed to load image: " + e.getLocalizedMessage());
			return null;
		}
	}
  
  // twoDToImage() accepts a 2D array of integers and a String for the file name. It converts the 2D array of int pixel data into an image and saves it.
	public static void twoDToImage(int[][] imgData, String fileName) {
		try {
			int imgRows = imgData.length;
			int imgCols = imgData[0].length;
			BufferedImage result = new BufferedImage(imgCols, imgRows, BufferedImage.TYPE_INT_RGB);
			for (int i = 0; i < imgRows; i++) {
				for (int j = 0; j < imgCols; j++) {
					result.setRGB(j, i, imgData[i][j]);
				}
			}
			File output = new File(fileName);
			ImageIO.write(result, "jpg", output);
		} catch (Exception e) {
			System.out.println("Failed to save image: " + e.getLocalizedMessage());
		}
	}

  //getRGBAFromPixel() accepts an int value representing the pixel hexadecimal value and returns a 4 element int array consisting of the R, G, B, and A values (between 0 and 255). 
	public static int[] getRGBAFromPixel(int pixelColorValue) {
		Color pixelColor = new Color(pixelColorValue);
		return new int[] { pixelColor.getRed(), pixelColor.getGreen(), pixelColor.getBlue(), pixelColor.getAlpha() };
	}

  //getColorIntValFromRGBA() accepts an array of integers that represent the RGBA values and convert it into a single int value representing the pixel hexadecimal value.
	public static int getColorIntValFromRGBA(int[] colorData) {
		if (colorData.length == 4) {
			Color color = new Color(colorData[0], colorData[1], colorData[2], colorData[3]);
			return color.getRGB();
		} else {
			System.out.println("Incorrect number of elements in RGBA array.");
			return -1;
		}
	}

  //viewImageData is used for extracting a 3x3 section from the top left of the image. It's used to view the structure of the image data in both the raw pixel form and the extracted RGBA form. 
	public static void viewImageData(int[][] imageTwoD) {
		if (imageTwoD.length > 3 && imageTwoD[0].length > 3) {
			int[][] rawPixels = new int[3][3];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rawPixels[i][j] = imageTwoD[i][j];
				}
			}
			System.out.println("Raw pixel data from the top left corner.");
			System.out.print(Arrays.deepToString(rawPixels).replace("],", "],\n") + "\n");
			int[][][] rgbPixels = new int[3][3][4];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					rgbPixels[i][j] = getRGBAFromPixel(imageTwoD[i][j]);
				}
			}
			System.out.println();
			System.out.println("Extracted RGBA pixel data from top the left corner.");
			for (int[][] row : rgbPixels) {
				System.out.print(Arrays.deepToString(row) + System.lineSeparator());
			}
		} else {
			System.out.println("The image is not large enough to extract 9 pixels from the top left corner");
		}
	}
}
