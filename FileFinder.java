package ie.gmit.dip;
import java.io.File;
import java.util.Scanner;

public class FileFinder {
	private final static Scanner sc = new Scanner(System.in);
	
	public static File getFile() throws Exception {
		System.out.println(ConsoleColour.CYAN);
		System.out.println("Enter File Name. Please enter full directory and ensure it is a PNG file!");
		System.out.println(ConsoleColour.RESET);
		String userPath = sc.next();
		File f = new File(userPath);
		if (f.exists()){
			System.out.println(ConsoleColour.GREEN);
			System.out.println("File Path exists");
			System.out.println(ConsoleColour.RESET);
		    return f;
		  }else{
			  System.out.println(ConsoleColour.RED);
		    throw new Exception("Invalid path name...!");
		    
		  }
		
	}
	
	

}
