package org.Facebookreg.main;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utility.Base;

public class Registerpage {
	@FindBy(id="u_0_2")
	private WebElement txtfirstname;
	@FindBy(id="u_0_4")
	private WebElement txtlastname;
	@FindBy(id="u_0_7")
	private WebElement txtmail;
	@FindBy(id="u_0_a")
	private WebElement txtrenteremailid;
	@FindBy(id="u_0_e")
	private WebElement txtpass;
	@FindBy(id="day")
	private WebElement drpdwnday;
	@FindBy(id="month")
	private WebElement drpdwnmonth;
	@FindBy(id="year")
	private WebElement drpdwnyr; 
	@FindBy(id="u_0_i")  
	private WebElement BtnMale;
	@FindBy(id="u_0_m")
	private WebElement BtnSubmit;
	
	public WebElement getTxtfirstname() {
		return txtfirstname;
	}
	public void setTxtfirstname(WebElement txtfirstname) {
		this.txtfirstname = txtfirstname;
	}
	public WebElement getTxtlastname() {
		return txtlastname;
	}
	public void setTxtlastname(WebElement txtlastname) {
		this.txtlastname = txtlastname;
	}
	public WebElement getTxtmail() {
		return txtmail;
	}
	public void setTxtmail(WebElement txtmail) {
		this.txtmail = txtmail;
	}
	public WebElement getTxtRenteremail() {
		return txtrenteremailid;
	}
	public void setTxtRenteremail(WebElement txtRenteremail) {
		this.txtrenteremailid = txtRenteremail;
	}
	public WebElement getTxtpass() {
		return txtpass;
	}
	public WebElement getTxtrenteremailid() {
		return txtrenteremailid;
	}
	public void setTxtrenteremailid(WebElement txtrenteremailid) {
		this.txtrenteremailid = txtrenteremailid;
	}
	public void setTxtpass(WebElement txtpass) {
		this.txtpass = txtpass;
	}
	public WebElement getDrpdwnday() {
		return drpdwnday;
	}
	public void setDrpdwnday(WebElement drpdwnday) {
		this.drpdwnday = drpdwnday;
	}
	public WebElement getDrpdwnmonth() {
		return drpdwnmonth;
	}
	public void setDrpdwnmonth(WebElement drpdwnmonth) {
		this.drpdwnmonth = drpdwnmonth;
	}
	public WebElement getDrpdwnyr() {
		return drpdwnyr;
	}
	public void setDrpdwnyr(WebElement drpdwnyr) {
		this.drpdwnyr = drpdwnyr;
	}
	public WebElement getBtnMale() {
		return BtnMale;
	}
	public void setBtnMale(WebElement btnMale) {
		BtnMale = btnMale;
	}
	public WebElement getBtnSubmit() {
		return BtnSubmit;
	}
	public void setBtnSubmit(WebElement btnSubmit) {
		BtnSubmit = btnSubmit;
	}
	public WebElement getRdbtn() {
		return BtnMale;
	}
	public void setRdbtn(WebElement rdbtn) {
		BtnMale = rdbtn;
	}
	public WebElement getBtnclk() {
		return BtnSubmit;
	}
	public void setBtnclk(WebElement btnclk) {
		this.BtnSubmit = btnclk;
	}							

	public  Registerpage() {
		PageFactory.initElements(Base.driver, this);  
	}
	}