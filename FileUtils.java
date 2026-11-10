import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * FileUtils is the class that will be used to drive the creation of reading in an image
 * and writing to a new file. The main method, which contains the logic for this, facilitates
 * manipulating each pixel in a 2d image array.
 * 
 * @author Vikash Sahu
 * @date 9/29/2025
 * @course Computer Graphics, MBHS Fall 2025
 * @sources many, detailed in the project spec -- primarily Wikipedia
 * @aiusage none :)
 */

public class FileUtils {
	public static void main(String[] args) throws IOException {
		
		// replace basePath below with the actual path to your containing folder
		// you can find the path by right-clicking on the image and selecting "properties"
		String basePath = "C:\\Users\\SAHUVIKA\\eclipse\\GraphicsFall25\\src\\GraphicsFall25\\";
		
		// replace inputFileName below with the actual file name of the image (with no file extension) you're reading in
		String inputFileName = "wheel";
		
		String fileExtension = ".jpg";
		
		String outputFileName = "output";
		
		BufferedImage img = ImageIO.read(new File(basePath + inputFileName + fileExtension));

		// TODO: iterate over each pixel in the BufferedImage, and manipulate it according to the requirements.
			
		File outputFile = new File(basePath + outputFileName + fileExtension);
			
		if (outputFile.createNewFile()) {
			ImageIO.write(img, "jpg", outputFile);
			System.out.println("creating output file " + basePath + outputFileName + fileExtension + " succeeded.");
			System.out.println("refresh the folder in Eclipse to see it.");
		} else {
			System.out.println("output file creation failed");
			System.out.println("creating output file " + basePath + outputFileName + fileExtension + " failed.");
			System.out.println("trying now by appending a random number to the filename: ");
			outputFile = new File(basePath + outputFileName + "-" + (int)(Math.random() * 100) + fileExtension);
			
			if (outputFile.createNewFile()) {
				ImageIO.write(img, "jpg", outputFile);
				System.out.println("creating output file with random int appended to filename succeeded.");
				System.out.println("refresh the folder in Eclipse to see it.");
			} else {
				System.out.println("trying to create the output file a second time failed.");
				System.out.println("Something is wrong. Please debug and try again.");
			}
		}
	}
}
