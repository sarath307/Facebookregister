package org.Facebookreg.test;

import junit.framework.Assert;

import org.Facebookreg.main.Registerpage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.utility.Base;

public class Registerpagetest extends Base {
		static WebDriver driver;
		Registerpage registerpage;

		@BeforeClass
		public static void launchBrowser() {
			driver = getDriver();

		}

		@Test
		public void verifyLoginDetails() {
			registerpage = new Registerpage();
			getScreenShot("facebookPage");
			setText(registerpage.getTxtfirstname(), readValueFromExcelSheet().get(1)
					.get("firstname"));
			getScreenShot("firstname");
			setText(registerpage.getTxtlastname(), readValueFromExcelSheet().get(1)
					.get("lastname"));
			getScreenShot("lastname");
			setText(registerpage.getTxtmail(), readValueFromExcelSheet().get(1)
					.get("Email"));
			getScreenShot("Email");
			setText(registerpage.getTxtrenteremailid(), readValueFromExcelSheet().get(1)
					.get("renteremailid"));
			getScreenShot("renteremailid");
			setText(registerpage.getTxtpass(), readValueFromExcelSheet().get(1)
					.get("password"));
			getScreenShot("password");
			
			dropDownSelect(registerpage.getDrpdwnday(),"14");
			dropDownSelect(registerpage.getDrpdwnmonth(),"Aug");
			dropDownSelect(registerpage.getDrpdwnyr(),"1992");
			clickBtn(registerpage.getBtnMale());
			clickBtn(registerpage.getBtnSubmit());	
		}

		@AfterClass
		public static void closeBrowser() {
			driver.quit();

		}

	
}

