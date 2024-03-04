package org.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class C_00Base {

	// 1 - Importing driver
	public static WebDriver driver;

	// 2 - Launching Browser
	public static void launchBrowser() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

	}

	// 3 - Window Maximize
	public static void windowMaximize() {

		driver.manage().window().maximize();

	}

	// 4 - Launch URL
	public static void launchUrl(String url) {

		driver.get(url);

	}

	// 5 - Page Title
	public static String pageTitle() {

		String title = driver.getTitle();
		return title;

	}

	// 6 - Page URL
	public static String pageUrl() {

		String url = driver.getCurrentUrl();
		return url;

	}

	// 7 - Send Keys
	public static void passText(String txt, WebElement ele) {

		ele.sendKeys(txt);

	}

	// 8 - Close Browser
	public static void closeEntireBrowser() {

		driver.quit();

	}

	// 9 - Click Button
	public static void clickBtn(WebElement ele) {

		ele.click();

	}

	// 10 - Take Screenshot
	public static void screenshot(String imgName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("Location + imageName.png");
		FileUtils.copyFile(image, f);

	}

	// 11 - Actions
	public static Actions a;

	// 12 - Move the Cursor
	public static void moveTheCursor(WebElement targetWebElement) {

		a = new Actions(driver);
		a.moveToElement(targetWebElement).perform();

	}

	// 13 - Drag and Drop
	public static void dragDrop(WebElement dragWebElement, WebElement dropWebElement) {

		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropWebElement).perform();

	}

	// 14 - JavaScript Executor
	public static JavascriptExecutor js;

	// 15 - Scroll the Page
	public static void scrollThePage(WebElement targetWebElement) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(true)", targetWebElement);

	}

	// 16 - Scroll
	public static void scroll(WebElement element) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(false)", element);

	}

	// 17 - Excel Read
	public static void excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("C:\\Users\\yoges\\eclipse-workspace\\mavenProject\\Excel\\dataDriven04.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mysheet = wb.getSheet(sheetName);
		Row r = mysheet.getRow(rowNum);
		Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();
		String value = " ";
		if (cellType == 1) {

			String value2 = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {

			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);

		} else {

			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);

		}

	}

	// 18 - Create New Excel File
	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("C:\\Users\\yoges\\eclipse-workspace\\mavenProject\\Excel\\dataDriven04.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet("Datas");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	// 19 - Create Row
	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("C:\\Users\\yoges\\eclipse-workspace\\mavenProject\\Excel\\dataDriven04.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	// 20 - Create Cell
	public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\yoges\\eclipse-workspace\\mavenProject\\Excel\\dataDriven04.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	// 21 - Update Date To Particular Cell
	public static void updateDateToParticularCell(int getRow, int getCell, String sheetName, String existingData,
			String WriteNewData) throws IOException {

		File f = new File("C:\\Users\\yoges\\eclipse-workspace\\mavenProject\\Excel\\dataDriven04.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet newSheet = wb.createSheet("Datas");
		Row r = newSheet.getRow(getRow);
		Cell c = r.createCell(getCell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {

			c.setCellValue(WriteNewData);

		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

}
