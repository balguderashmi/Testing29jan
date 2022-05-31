package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	public static String FetchDataFromExcelSheet(int i,int row,int column) throws EncryptedDocumentException, IOException
	{
		String path = "src\\main\\resources\\TestData\\test case formate.xlsx";
		FileInputStream file = new FileInputStream(path);
		String Data= WorkbookFactory.create(file).getSheet("29 jan").getRow(2).getCell(2).getStringCellValue();
		return Data;
	}
	
	public static void CaptureScreenshot(WebDriver driver,String ScreenshotName) throws IOException
	{
	
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Date d = new Date();
		SimpleDateFormat df= new SimpleDateFormat("dd-MM-YYYY_HH mm ss");
		String time = df.format(d);
		File dest = new File(".\\test-output\\Screenshot\\Test-1001"+"-"+ScreenshotName+"-"+time+".png");
	    FileHandler.copy(source, dest);
        
	}
}
