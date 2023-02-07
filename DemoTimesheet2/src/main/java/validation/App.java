package validation;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println("Timesheet Management System");
    	ExcelReader.getCell();
    	System.out.println("Hi " + ExcelNameReader.showEmpName() + ", "+ "you have filled timesheet for " + Counter.getHoursCount() + " days.");
    }
}
