package ie.gmit.dip;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageConvolution {
	
	public static BufferedImage convolution(BufferedImage input, double[][] kernel, BufferedImage output) throws IOException {
		// Initiating output to same size and type as input.
		output = new BufferedImage(input.getWidth(), input.getHeight(), input.getType());
		// Getting length and height of image
		int width = input.getWidth();
		int height = input.getHeight();

		// Loop Input image
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
					
				
				float red = 0f, green = 0f, blue = 0f;
				// loop kernel
				for (int i = 0; i < kernel.length; i++) {
					for (int j = 0; j < kernel.length; j++) {

						// Calculating X and Y coordinates of the pixel to be multiplied
						// with current kernel element
						// The modulo %WIDTH will take care of the edges,it will use a pixel 
						// from opposite edge
						int pixelX = (x - (kernel.length - 1) / 2 + i + width) % width;
						int pixelY = (y - (kernel.length - 1) / 2 + j + height) % height;
						
						// Getting RGB value of pixel using a Java inbuilt method.
						// The bitshift then gets each individual red,blue, green colour.
						int RGB = input.getRGB(pixelX, pixelY);
						int R = (RGB >> 16) & 0xff; // Red 
						int G = (RGB >> 8) & 0xff; 	// Green
						int B = (RGB) & 0xff; 		// Blue

						// Multiplying each value by the current kernel element
						red += (R * kernel[i][j]);
						green += (G * kernel[i][j]);
						blue += (B * kernel[i][j]);
					}
				}
				int outR, outG, outB;
				// If the value goes below 0, or above 255, it will be truncated to either.
				outR = Math.min(Math.max((int) (red), 0), 255);
				outG = Math.min(Math.max((int) (green), 0), 255);
				outB = Math.min(Math.max((int) (blue), 0), 255);
				
				// Pixel is written to output image
				output.setRGB(x, y, new Color(outR, outG, outB).getRGB());
			}
		}
		//Writing output into file
		try {
			ImageIO.write(output, "png", new File("output.png"));
		} catch (IOException e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("Error! Please try again");
			System.out.println(ConsoleColour.RESET);
		}
		
		return output;
	}

}
