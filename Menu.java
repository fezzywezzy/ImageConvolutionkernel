package ie.gmit.dip;

import java.util.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Menu {
	private static Scanner s = new Scanner(System.in);
	// public static EnumSet<Kernel> kernelSet = EnumSet.allOf(Kernel.class);
//	static String[] SELECTION = {"IDENTITY", "EDGE_DETECTION_1", "EDGE_DETECTION_2", 
//            "LAPLACIAN", "SHARPEN", "VERTICAL_LINES","HORIZONTAL_LINES",
//            "DIAGONAL_45_LINES", "BOX_BLUR","SOBEL_HORIZONTAL", "SOBEL_VERTICAL"};

	// This initiates the inputimage and choice outside the scope of the first
	// switch statement
	static BufferedImage inputimage = null;
	static double[][] theChoice2 = null;
	static BufferedImage outputimage = null;

	public Menu() {

	}

	// This starts the show
	public void start() throws IOException {
		// Calling header display
		header();
		boolean keepRunning = true;
		while (keepRunning) {
			showOptions();
			// Calls enterInput function
			int choice = enterInput();
			switch (choice) {
			case 1:
				loadFile();
				break;
			case 2:
				selectFilter();
				break;
			case 3:
				createYourOwnFilter();
				break;
			case 4:
				applyConvolution();
				break;
			case 5:
				flip();
				break;
			case 6:
				System.out.println(ConsoleColour.GREEN_BOLD_BRIGHT);
				System.out.println("Shutting down now, I hope you had fun and stay beautiful");

				keepRunning = false;
				break;
			default:
				// I see his comes up twice as there is already a catch in the enterInput
				// class.. but to be safe I will leave a default
				System.out.println(ConsoleColour.RED);
				System.out.println("Invalid selection!");
				System.out.println(ConsoleColour.RESET);
			}

		}
	}

	// Option menu
	private void showOptions() {
		System.out.println(ConsoleColour.YELLOW_BOLD);
		System.out.println("1) Enter Image Name");
		System.out.println("2) Select a Filter");
		System.out.println("3) Or create a filter");
		System.out.println("4) Apply your selected filter");
		System.out.println("5) Invert or Flip Image");
		System.out.println("6) Quit");
		System.out.println("\nSelect Option [1-6]>");
		System.out.println(ConsoleColour.RESET);
	}

	private void header() {
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println(ConsoleColour.RESET);
	}

	// Enter input method
	private static int enterInput() {
		int choice = 0;
		try {
			choice = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("Invalid Input!");
			System.out.println(ConsoleColour.RESET);
		}
		return choice;
	}

	// Display Array/kernel method
	public static void printdblarray(double[][] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(ConsoleColour.PURPLE_BOLD);
			System.out.println(" ");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
			System.out.println(ConsoleColour.RESET);

		}
	}

	// The following methods are for the menu choices

	// LOAD FILE
	public static void loadFile() {
		try {
			inputimage = ImageIO.read(FileFinder.getFile());
			System.out.println(ConsoleColour.GREEN);
			System.out.println("Image loaded successfully.");
			System.out.println(ConsoleColour.RESET);

		} catch (Exception e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("No image here!! Please try again");
			System.out.println(ConsoleColour.RESET);
		}

	}

	// SELECT FILTER
	public void selectFilter() throws IOException {
		System.out.println(ConsoleColour.YELLOW_UNDERLINED);
		System.out.println("Please select a Kernel");
		System.out.println(ConsoleColour.RESET);
		Kernel[] numberedKernels = Kernel.values();
		System.out.println(ConsoleColour.CYAN_BOLD);
		for (Kernel i : numberedKernels) {
			System.out.println(i.ordinal() + " " + i.name());
		}
		// User input selection..
		int kernelSelection = enterInput();
		// Selecting a Kernel object from the array...
		try {
			Kernel theChoice = numberedKernels[kernelSelection];
			theChoice2 = theChoice.getKernel();
			// Just testing to see if it is considering it an array type and printing it!
			System.out.println("The array you have selected is:");
			printdblarray(theChoice2);
			System.out.println("");
			System.out.println(ConsoleColour.RESET);
		}

		catch (Exception e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("Number out of range!");
			System.out.println(ConsoleColour.RESET);
		}

	}

	// CreateYourOwnFilter
	public void createYourOwnFilter() {
		System.out.println("Enter Kernel dimension:");
		int order = enterInput();
		if (order % 2 == 0 || order < 3) {
			System.out.println(ConsoleColour.RED);
			System.out.println("You need an odd numbered or positive numbered kernel! Try 3, 5, 7");
			System.out.println(ConsoleColour.RESET);
		} else {

			try {
				theChoice2 = CreateYourOwnFilter.userKernel(order);
			} catch (Exception e1) {
				System.out.println(ConsoleColour.RED);
				System.out.println("Error applying your filter!");
				System.out.println(ConsoleColour.RESET);
			}
		}
	}

	// APPLY CONVOLUTION
	public void applyConvolution() {
		try {
			System.out.println(ConsoleColour.CYAN_BOLD);
			System.out.println("Processing..");
			System.out.println(ConsoleColour.RESET);
			ImageConvolution.convolution(inputimage, theChoice2, outputimage);
			System.out.println(ConsoleColour.GREEN_BOLD);
			System.out.println("Complete! Find your convoluted image in the project folder.");
			System.out.println(ConsoleColour.RESET);
		} catch (Exception e) {
			System.out.println(ConsoleColour.RED);
			System.out.println("Error! Please make sure you have inserted an image or selected/created a kernel");
			System.out.println(ConsoleColour.RESET);
		}

	}

	// Inversions
	public void flip() {
		System.out.println(ConsoleColour.PURPLE_BOLD);
		System.out.println("Would you like to flip your output (1)vertically or (2)horizontally?");
		System.out.println(ConsoleColour.RESET);
		int flipper = enterInput();
		switch (flipper) {
		case 1:
			try {

				ImageInverter.verticalInverter(inputimage);
				System.out.println(ConsoleColour.GREEN_BOLD);
				System.out.println("Complete! Find your inverted image in the project folder.");
				System.out.println(ConsoleColour.RESET);
			} catch (Exception e) {
				System.out.println(ConsoleColour.RED);
				System.out.println("Error. Do you have an input file?");
				System.out.println(ConsoleColour.RESET);
			}
			break;
		case 2:
			try {

				ImageInverter.horizontalInverter(inputimage);
				System.out.println(ConsoleColour.GREEN_BOLD);
				System.out.println("Complete! Find your inverted image in the project folder.");
				System.out.println(ConsoleColour.RESET);
			} catch (Exception e) {
				System.out.println(ConsoleColour.RED);
				System.out.println("Error. hmmmmm Do you have an input file?");
				System.out.println(ConsoleColour.RESET);
			}
			break;
		default:
			System.out.println(ConsoleColour.RED);
			System.out.println("Invalid selection!");
			System.out.println(ConsoleColour.RESET);
		}
	}

}
