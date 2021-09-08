package ie.gmit.dip;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.System.out;

public class CreateYourOwnFilter {
	private static Scanner s = new Scanner(System.in);
	static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	public static double[][] userKernel(int order) throws Exception {
		int len = order - 1;
		double[][] userKernel = new double[order][order];
		System.out.println(ConsoleColour.PURPLE_BOLD);
		System.out.println(
				"Enter the individual values for the Kernel, sarting and 0,0, and ending at " + len + "," + len);
		System.out.println(ConsoleColour.RESET);
		for (int i = 0; i < order; i++)
			for (int j = 0; j < order; j++) {
				System.out.println((i + "," + j + ":"));
				// out.print(i+","+j+":");
				userKernel[i][j] = enterInput();
			}
		System.out.println(ConsoleColour.RESET);

		// Printing homemade kernel
		printdblarray(userKernel);
		System.out.println(ConsoleColour.CYAN);
		System.out.println("\nThe sum of matrix elements is: " + sumofelements(userKernel));
		if (sumofelements(userKernel) < 1) {
			System.out.println("Please note your output will be less bright than your input image.");
		} else if (sumofelements(userKernel) > 1) {
			System.out.println("Please note your output will be brighter than your input image.");
		} else {
			System.out.println("The output image will be of equal brightness");

		}
		System.out.println(ConsoleColour.RESET);
		return userKernel;

	}

	private static double enterInput() {
		double choice = 0;
		try {
			choice = Integer.parseInt(s.nextLine());
		} catch (NumberFormatException e) {

		}
		return choice;
	}

//	private static double enterInput2() {
//		double choice = 0;
//		try {
//			choice = Integer.parseInt(s.nextLine());
//		} catch (NumberFormatException e) {
//
//		}
//		return choice;
//	}

	public static void printdblarray(double[][] arr) {
		System.out.println(ConsoleColour.PURPLE);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("");
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println(ConsoleColour.RESET);
	}

	public static int sumofelements(double[][] arr) {
		int sum1 = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				sum1 += arr[i][j];
			}
		}
		return sum1;
	}
}
