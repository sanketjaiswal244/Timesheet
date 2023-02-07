package validation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWriter {

	public static void writeToCell() throws IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please Enter Working Hours : ");
		int hours = sc.nextInt();

		String EmpID = TextReader.showEmpID();
		String currentDate = TextReader.showDate();

		int dateINT = Integer.parseInt(currentDate);

		// Creating file object of existing excel file
		File xlsxFile = new File("D:/TimeSheetExcel.xlsx");

		try {
			// Creating input stream
			FileInputStream inputStream = new FileInputStream(xlsxFile);

			// Creating workbook from input stream
			Workbook workbook = WorkbookFactory.create(inputStream);

			// Reading first sheet of excel file
			Sheet sheet = workbook.getSheetAt(0);

			// Getting the count of existing records
			int rowCount = sheet.getLastRowNum();

			// Getting age cell of first row from the sheet
			Cell cell = sheet.getRow(ExcelReader.rowIndex).getCell(dateINT + 1);

			// Updating the cell value with new data

			cell.setCellValue(hours);

			// Close input stream
			inputStream.close();

			// Crating output stream and writing the updated workbook
			FileOutputStream os = new FileOutputStream(xlsxFile);
			workbook.write(os);

			// Close the workbook and output stream
			workbook.close();
			os.close();

			System.out.println("Timesheet of " + hours + " hours has been updated successfully for "
					+ ExcelNameReader.showEmpName() + ".");

		} catch (IOException e) {
			System.err.println("Exception while updating an existing excel file.");
			e.printStackTrace();
		}
	}
}
