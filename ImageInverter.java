package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageInverter {

	public static BufferedImage verticalInverter(BufferedImage input) throws IOException {
		// Initiating output to same size and type as input.
		BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
		// Getting length and height of image
		int width = input.getWidth();
		int height = input.getHeight();

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int pixel = input.getRGB(x, y);
				output.setRGB(width - x - 1, y, pixel);
			}
		}
		try {
			ImageIO.write(output, "png", new File("verticalInvertedOutput.png"));
		} catch (IOException e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("Error! Please try again");
			System.out.println(ConsoleColour.RESET);
		}
		return output;
	}

	public static BufferedImage horizontalInverter(BufferedImage input) throws IOException {
		// Initiating output to same size and type as input.
		BufferedImage output = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
		// Getting length and height of image
		int width = input.getWidth();
		int height = input.getHeight();

		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				int pixel = input.getRGB(x, y);
				output.setRGB(x, height - y - 1, pixel);
			}
		}
		try {
			ImageIO.write(output, "png", new File("horizontalInvertedOutput.png"));
		} catch (IOException e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("Error! Please try again");
			System.out.println(ConsoleColour.RESET);
		}
		return output;
	}
}
