package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import testBase.TestBaseDemo;

public class TestUtilDemo extends TestBaseDemo {

	public static FileInputStream Tdata;
	public static XSSFWorkbook dataFile;
	public static XSSFSheet loginDetails;
	public static XSSFSheet NewUserRegsitration;
	
	public TestUtilDemo() throws IOException, FileNotFoundException {
		super();
		}
	
	public static XSSFWorkbook FetchExcel() throws IOException {
		//Setting spreadhseet value
				Tdata = new FileInputStream("C:\\Users\\mahi9\\eclipse-workspace\\com.basspro.demo\\Resources\\Testdata.xlsx");
				@SuppressWarnings("resource")
				XSSFWorkbook dataFile = new XSSFWorkbook(Tdata);
				System.out.println("Data from excel fetched");
				return dataFile;
				
	}
	
	//@SuppressWarnings("resource")
		public static XSSFRow getTestData(String Sheetname, String Scenario) throws IOException {
			
			XSSFWorkbook dataFile = FetchExcel();
			XSSFSheet data = null;
			int i = 0;
			String ScenarioType = "";				
			
			//Setting spreadhseet value	
			if(Sheetname.contentEquals("loginDetails")) {
				data = dataFile.getSheetAt(0);	
				System.out.println("Login details being fetched");
				System.out.println("Printing for debug purpose : " + data.getRow(1).getCell(0).getStringCellValue());
			} else if(Sheetname.contentEquals("UserRegistration")) {
				data = dataFile.getSheetAt(1);			
				System.out.println("New user registration details being fetched");
			} else {
			System.out.println("Incorrect argument for sheetname passed");
			data = null;
			}
			
			for(@SuppressWarnings("unused") Row testData : data) {
				ScenarioType = testData.getCell(0).getStringCellValue();
				if(ScenarioType.contentEquals(Scenario)) {
					i = testData.getRowNum();
				}
			}
			System.out.println(i);
			System.out.println(data.getRow(i).getCell(0).getStringCellValue());
			return data.getRow(i);	
			
			/*do {
				ScenarioType = data.getRow(i).getCell(0).getStringCellValue();
				i++;				
			} while (Scenario.contentEquals(ScenarioType));
			System.out.println("Scenario type for which data is being fetched : " + ScenarioType);*/
			
				
				
			}	
		
		//This merthod is used to write data in spreadhseet based on SheetName, Scenario,Column and vlue to be written
		public static void WriteData(String SheetName, String Scenario, int col, String Value) throws IOException {
			
			XSSFWorkbook dataFile = FetchExcel();
			XSSFSheet data = null;
			int i = 1;
			String ScenarioType = "";	
			
			if(SheetName.contentEquals("LoginDetails")) {
				data = dataFile.getSheetAt(0);				
			} else if(SheetName.contentEquals("UserRegistration")) {
				data = dataFile.getSheetAt(1);			
			} else {
			System.out.println("Incorrect argument for sheetname passed");
			data = null;		
			}
			
			do {
				ScenarioType = data.getRow(i).getCell(0).getStringCellValue();
				i++;			
			} while (Scenario.contentEquals(ScenarioType));
			
			data.getRow(i).createCell(col).setCellValue(Value);
			FileOutputStream WriteData = new FileOutputStream("C:\\Users\\mahi9\\eclipse-workspace\\com.basspro.demo\\Resources\\Testdata.xlsx");
			dataFile.write(WriteData);	
			
		}
		
		public void CaptureScreenshot(String Name) throws Throwable {
			
			//String Location = prop.getProperty(ScreenshotLocation);
			File destination = new File("C:\\Users\\mahi9\\eclipse-workspace\\com.basspro.validation\\src\\Screenshot" + Name + ".jpeg");
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, destination);		
					
		}

}
