package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;

public class ResultFile {

	// to check if a file is already exist
	public static void checkFileExistance(String fileName, String dotFormat) {
		File x = new File("C:\\Users\\itszakaria_\\workspace\\appleWebAppDefault\\src\\test\\documentation\\" + fileName + dotFormat);

		if (x.exists())
			System.out.println(x.getName() + " > : exist!");
		else
			System.out.println(x.getName() + " > : does not exist!");
	}

	
	
	// to create a file and write the result

	public static void writeTestResult(String filename, String dotFormat, String testName, String testResult) {
		Formatter f = null;
		try {
			f = new Formatter("C:\\Users\\itszakaria\\workspace\\appleWebAppDefault\\src\\test\\documentation\\" + filename + dotFormat);
			System.out.println("We created a file named : " + filename + dotFormat);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("we got an error");
		}

		f.format("%s %s \n", testName, testResult);
		f.close();
		
		
		
	}

}
