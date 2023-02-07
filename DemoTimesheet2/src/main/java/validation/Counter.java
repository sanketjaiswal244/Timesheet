package validation;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Counter {

	static int hoursCount;

	public static int getHoursCount() {
		try {

			// Reading file from local directory
			FileInputStream file = new FileInputStream(new File("D:/TimeSheetExcel.xlsx"));

			// Create Workbook instance holding reference to.xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();

			Row row = sheet.getRow(ExcelReader.rowIndex);

			for (int i = 0; i < 30; i++) {
				Cell cell = row.getCell(i);
				if (cell == null) {
					// do something with an empty cell
					continue;
				}

				switch (cell.getCellType()) {

				case NUMERIC: // Reading from excel cell, if cell type is NUMERIC

					if (cell.getNumericCellValue() == 9) {
						hoursCount++;
					}

					break;
				}
			}

			// Closing file output streams
			file.close();
		}

		// Catch block to handle exceptions
		catch (Exception e) {

			e.printStackTrace(); // Display the exception along with line number using printStackTrace() method
		}
      
		 return hoursCount;
	}
}
