package objectFiles;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class HospitalChargesPage extends ObjectParentClass {
	
	WebDriver driver;
	

	public HospitalChargesPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Title Text
	@FindBy(xpath="//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	//add charge Button
	@FindBy(xpath="//a[@onclick=\"holdModal('myModal')\"]")
	WebElement addChargeButtonElement;
	//select Charge Type in add Charge window
	//@FindBy(xpath="//select[@onchange=\"getcharge_category(this.value, 'charge_category')\"]")
	//@FindBy(xpath="//select[contains(@onchange,\"getcharge_category(this.value, 'charge_category')\")]")
	@FindBy(xpath="(//select[@name='charge_type'])[1]")
	WebElement selectChargeTypeElement;
	//Select Charge Category in add Charge window
	@FindBy(css="#charge_category")
	WebElement selectChargeCategoryElement;
	//code in add Charge window
	@FindBy(xpath="(//input[@name='code'])[1]")
	WebElement codeElement;
	//Standard Charge in add Charge window
	@FindBy(css="#standard_charge")
	WebElement standardChargeElement;
	//apply all button in add Charge window
	@FindBy(xpath="//button[@onclick='apply_to_all()']")
	WebElement applyAllButtonElement;
	//Description in add Charge window
	@FindBy(xpath="(//textarea[@name='description'])[1]")
	WebElement descriptionElement;
	//save Button in add Charge window
	@FindBy(css="#formaddbtn")
	WebElement saveButtonElement;
	// toast Message Element
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement toastMessageElement;
	//close add charge button
	@FindBy(xpath="//div[@id='myModal'] //button[@class='close']")
	WebElement closeAddChargeButtonElement;
	//Show charge Details window Button
	@FindBy(xpath="//a[contains(@onclick,'viewDetail')]//i")
	List<WebElement> showChargeDetailswindowButtonList;
	//row option menu element
	@FindBy(xpath="//div[@class='rowoptionview'][1]")
	List<WebElement> showChargeDetailswindowrowList;
	//charge details page number element
	@FindBy(xpath="//div[@id='detail_paginate']//a[@class='paginate_button current']")
	WebElement chargeDetailsPageNumberElement;
	//close Charge Details Window Button
	@FindBy(xpath="//div[@id='viewModal'] //button[@class='close']")
	WebElement closeChargeDetailsWindowButtonElement;
	//Edit charge details Button element
	@FindBy(xpath="//a[contains(@onclick,'getRecord')]//i")
	List<WebElement> editChargeDetailsWindowButtonList;
	//save Edit Charge Details Window Button
	@FindBy(css="button#formeditbtn")
	WebElement saveEditChargeDetailsWindowButtonElement;
	//close Edit Charge Details Window Button
	@FindBy(xpath="//div[@id='myModaledit'] //button[@class='close']")
	WebElement closeEditChargeDetailsWindowButtonElement;
	//Delete Charges Button
	@FindBy(xpath="//a[contains(@onclick,'delete_recordById')]//i")
	List<WebElement> deleteChargeButtonList;
	
	//charge Category Page link
	@FindBy(xpath="//a[contains(text(),'Charge Category')]")
	WebElement chargeCategoryPageLinkElement;
	//Doctor OPD Charge link
	@FindBy(xpath="//a[contains(text(),'Doctor OPD Charge')]")
	WebElement doctorOPDChargePageLinkElement;
	//Charge Type link
	@FindBy(xpath="//a[contains(text(),'Charge Type')]")
	WebElement chargeTypePageLinkElement;	
		
		
	public String titleTextGetText() {
		waitByElement(titleTextElement);
		String TitleText=titleTextElement.getText();
		return TitleText;
	}
	public void addChargeButtonClick() {
		waitByElement(addChargeButtonElement);
		addChargeButtonElement.click();
	}
	public void selectChargeTypeOption(String selectByValue) {
		waitByElement(selectChargeTypeElement);
		selectOption(selectChargeTypeElement, selectByValue);
	}
	public void selectChargeCategoryOption(String selectByValue) {
		waitByElement(selectChargeCategoryElement);
		selectOption(selectChargeCategoryElement, selectByValue);
	}
	public void enterCode(String codeValue) {
		codeElement.sendKeys(codeValue);
	}
	public void enterStandardChargeAmount(String standardChargeValue) {
		standardChargeElement.sendKeys(standardChargeValue);
	}
	public void applyAllButtonClick() {
		applyAllButtonElement.click();
	}
	public void enterDescription(String descriptionValue) {
		descriptionElement.sendKeys(descriptionValue);
	}
	public void saveButtonClick(String FileName) throws IOException {
		screenshot(FileName);
		saveButtonElement.click();
		waitByElement(toastMessageElement);
	}
	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}
	public void closeAddChargeButtonClick() {
		closeAddChargeButtonElement.click();
	}
	public void showChargeDetailswindowButtonclick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(showChargeDetailswindowButtonList.get(i));
		showChargeDetailswindowButtonList.get(i).click();
		waitByElement(chargeDetailsPageNumberElement);
	}
	public void closeChargeDetailsWindowButtonclick() {
		waitByElement(closeChargeDetailsWindowButtonElement);
		closeChargeDetailsWindowButtonElement.click();
	}
	public void editChargeDetailsWindowButtonclick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(editChargeDetailsWindowButtonList.get(i));
		editChargeDetailsWindowButtonList.get(i).click();
		waitByElement(saveEditChargeDetailsWindowButtonElement);
	} 
	public void saveEditChargeDetailsWindowButtonclick() {
		waitByElement(saveEditChargeDetailsWindowButtonElement);
		saveEditChargeDetailsWindowButtonElement.click();
	}
	public void closeEditChargeDetailsWindowButtonclick() {
		waitByElement(closeEditChargeDetailsWindowButtonElement);
		closeEditChargeDetailsWindowButtonElement.click();
	}
	public void deleteChargeDetailsButtonclick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(deleteChargeButtonList.get(i));
		deleteChargeButtonList.get(i).click();
	}
	public void alertHandlingPositive() {
		driver.switchTo().alert().accept();
	}

	public void alertHandlingNegative() {
		driver.switchTo().alert().dismiss();
	}
	
	
	public ChargeCategoryPage loadChargeCategoryPage() {
		chargeCategoryPageLinkElement.click();
		ChargeCategoryPage chargeCategory =new ChargeCategoryPage(driver);
		return chargeCategory;
	}
	public DoctorOPDChargePage loadDoctorOPDChargePage() {
		doctorOPDChargePageLinkElement.click();
		DoctorOPDChargePage doctorOPDCharge =new DoctorOPDChargePage(driver);
		return doctorOPDCharge;
	}
	public ChargeTypePage loadChargeTypePage() {
		chargeTypePageLinkElement.click();
		ChargeTypePage chargeType= new ChargeTypePage(driver);
		return chargeType;
}
}
