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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// 01 - Importing Driver
	public static WebDriver driver;

	// 02 - Launching Browser
	public static void LaunchBrowser() {

		WebDriverManager.edgedriver().setup(); // import maven dependency in POM.xml
		driver = new EdgeDriver();

	}

	// 03 - Window Maximize
	public static void windowMaximize() {

		driver.manage().window().maximize();

	}

	// 04 - Launch URL
	public static void launchURL(String url) {

		driver.get(url);

	}

	// 05 - Page Title
	public static String pagetitle() {

		String title = driver.getTitle();
		return title;

	}

	// 06 - PageURL
	public static String pageUrl() {

		String url = driver.getCurrentUrl();
		return url;

	}

	// 07 - Send Keys
	public static void passText(String txt, WebElement we) {

		we.sendKeys(txt);

	}

	// 08 - Close the Browser
	public static void closeEntireBrowser() {

		driver.quit();

	}

	// 09 - Click Button
	public static void clickBtn(WebElement we) {

		we.click();

	}

	// 10 - Take Screenshot
	public static void Screenshot(String imgName) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location + file name");
		FileUtils.copyFile(image, f);

	}

	// 11 - Actions
	public static Actions a;

	// 12 - Move to Element
	public void moveToCursor(WebElement targetWebelement) {

		a = new Actions(driver);
		a.moveToElement(targetWebelement).perform();

	}

	// 13 - Drag and Drop
	public void dragDrop(WebElement DragWebelement, WebElement DropWebelement) {

		a = new Actions(driver);
		a.dragAndDrop(DragWebelement, DropWebelement);

	}

	// 14 - JavaScript Executor
	public static JavascriptExecutor js;

	// 15 - Scroll Page
	public void scrollPage(WebElement targetelement) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", targetelement);

	}

	// 16 - Scroll Page
	public void scroll(WebElement targetelement) {

		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", targetelement);

	}

	// 17 - Read the Excel File
	public void excelRead(String s, int r, int c, String writeData) throws IOException {

		File f = new File(s);
		Workbook wb = new XSSFWorkbook();
		Sheet S = wb.getSheet("new");
		Row row = S.getRow(r);
		Cell cell = row.getCell(c);
		int cellType = cell.getCellType();

		String val = "";

		if (cellType == 1) {
			String value = cell.getStringCellValue();
			System.out.println(value);

		} else if (DateUtil.isCellDateFormatted(cell)) {

			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat simpD = new SimpleDateFormat("dd-MM-yy");
			String format = simpD.format(dateCellValue);
			System.out.println(format);

		} else {

			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			String valueOf = String.valueOf(l);
			System.out.println(valueOf);

		}

	}

	// 18 - Create Sheet in Excel File
	public void createSheet(String s, int r, int c, String writeData) throws IOException {
		File f = new File(s);
		Workbook wb = new XSSFWorkbook();
		Sheet S = wb.createSheet("new");
		Row row = S.createRow(r);
		Cell cell = row.createCell(c);
		cell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);
	}

	// 19 - Create Cell
	public void createCell(String s, int r, int c, String writeData) throws IOException {

		File f = new File(s);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet S = wb.getSheet("new");
		Row row = S.getRow(r);
		Cell cell = row.createCell(c);
		cell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	// 20 - Create Row
	public void createRow(String s, int r, int c, String writeData) throws IOException {

		File f = new File(s);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet S = wb.getSheet("new");
		Row row = S.createRow(r);
		Cell cell = row.createCell(c);
		cell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	// 21 - Update Particular Cell
	public void updateParticularCell(String s, int r, int c, String writeData, String exiData) throws IOException {

		File f = new File(s);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet S = wb.getSheet("new");
		Row row = S.getRow(r);
		Cell cell = row.getCell(c);
		String cellValue = cell.getStringCellValue();
		if (cellValue.equals(exiData))
			cell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

}
