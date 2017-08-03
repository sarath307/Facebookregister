package org.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public static WebDriver driver;
	static WebDriverWait wait;
	static File f1 = new File("./JSON/Configuration.json");

	public static WebDriver getDriver() {
		JSONObject jsonObject = JSONReadFromFile();
		String browser = (String) jsonObject.get("browser");

		File f = new File("./driver");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", f.getAbsolutePath()
					+ "/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", f.getAbsolutePath()
					+ "/geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", f.getAbsolutePath()
					+ "/IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}

		driver.manage().window().maximize();
		driver.get((String) jsonObject.get("url"));
		return driver;
	}

	public static boolean elementToBeVisible(WebDriver driver, int time,
			WebElement element) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean alertIsPresent(WebDriver driver, int time) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.alertIsPresent());
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean elementToBeClickable(WebDriver driver, int time,
			WebElement element) {
		boolean flag = false;
		try {
			wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static boolean elementFound(WebDriver driver, int time,
			WebElement element) {
		boolean res = false;
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		try {

			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return res;

	}

	public static boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return res;
	}

	public static void setText(WebElement element, String name) {
		if (name != null && elementFound(element)) {
			element.clear();
			element.sendKeys(name);
		}

	}

	public static String getText(WebElement element) {
		String name = null;
		if (elementFound(element)) {
			name = element.getAttribute("value");
		}
		return name;

	}

	public static void clickBtn(WebElement element) {
		if (elementFound(element)) {
			element.click();
		}
	}

	public static JSONObject JSONReadFromFile() {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;
		try {

			Object obj = parser.parse(new FileReader(f1.getAbsoluteFile()));

			jsonObject = (JSONObject) obj;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject;
	}
	public void dropDownSelect(WebElement element,String name) {
		Select s1=new Select(element);
		try{
		s1.selectByVisibleText(name);
		}catch(Exception e){
				e.printStackTrace();
		}
		}
	public static void getScreenShot(String screenShotFileName) {
		File screenShotLocation = new File("./screenshot/" + screenShotFileName
				+ ".png");
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File file = screenshot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, screenShotLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void uploadFiles(File path) {
		try {
			Robot robot = new Robot();
			robot.setAutoDelay(3000);
			StringSelection selection = new StringSelection(
					path.getAbsolutePath());
			Toolkit.getDefaultToolkit().getSystemClipboard()
					.setContents(selection, null);
			// press control+v
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.setAutoDelay(3000);
			// release control+v
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			// press enter
			robot.setAutoDelay(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static List<HashMap<String, String>> readValueFromExcelSheet() {
		List<HashMap<String, String>> mapDatasList = new ArrayList();
		try {
			File excelLocaltion = new File("./Excel/Facebookreg.xlsx");

			String sheetName = "Sheet1";

			FileInputStream f = new FileInputStream(
					excelLocaltion.getAbsolutePath());
			Workbook w = new XSSFWorkbook(f);
			Sheet sheet = w.getSheet(sheetName);
			Row headerRow = sheet.getRow(0);
			for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);
				HashMap<String, String> mapDatas = new HashMap<String, String>();
				for (int j = 0; j < headerRow.getPhysicalNumberOfCells(); j++) {
					Cell currentCell = currentRow.getCell(j);

					switch (currentCell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								currentCell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_NUMERIC:
						mapDatas.put(headerRow.getCell(j).getStringCellValue(),
								String.valueOf(currentCell
										.getNumericCellValue()));

						break;

					}
				}

				mapDatasList.add(mapDatas);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
		return mapDatasList;

	}
}