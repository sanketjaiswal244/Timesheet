package validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextReader {

	public static String showEmpID() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("D:\\Emp_data.txt")));
		String empID = br.readLine(); // Read 1st line which is EMPID in INT format
		return empID;
	}

	public static String showDate() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("D:\\Emp_data.txt")));
		String empID = br.readLine(); // Read 1st line which is EMPID in INT format
		String date = br.readLine();  // Read 2nd line which is date in INT format
		
		String strArr1[] = date.split("-");

		return strArr1[0];
	}
}
