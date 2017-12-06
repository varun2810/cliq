package automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Apptest1 {
	
	static XSSFWorkbook workbook;
    static XSSFSheet sheet;
	static XSSFCell cell;
	static String URL = "http://www.google.com";
	static WebDriver driver;
	
	static File src=new File(".\\testdata\\Automation.xlsx");
	
	static methods obj = new methods();
	
	
	
	 @Test
	  public static void excel() throws IOException, InterruptedException 
		{ 
				
		 	// Load the file.
			FileInputStream finput = new FileInputStream(src);
			
			// Load the workbook.
			workbook = new XSSFWorkbook(finput);
			
			// Load the sheet in which data is stored.
			sheet= workbook.getSheetAt(0);
			
			int rc=sheet.getLastRowNum();
			
			for(int i=1; i<=rc; i++)							
				
				{					
					 Row row = sheet.getRow(i);	
					 
					 if(row == null || row.getCell(1)==null) {					 
						 continue;
				}
					 				 
					 String testcase = row.getCell(1).toString();									
					 System.out.println(testcase);
					 
					 switch(testcase) {
					 
					 case "App installation":
							System.out.println("testcase : " + testcase);									
							obj.installation();					
							Thread.sleep(3000);
							//updateresult("//*[@id='lst-ib']",i);
							break;
					 
					 }
						 					
						
				     }
		}
	 
}
