package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class DoctorOPDChargePage extends ObjectParentClass {

	WebDriver driver;
	
	public DoctorOPDChargePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//Add Charge button
	@FindBy(xpath="//a[contains(text(),' Add Charge')]")
	WebElement addChargeButtonElement;
	//Show Doctor options
	@FindBy(xpath="(//span[contains(@class,'select2')])[1]")
	WebElement showDoctorElement;
	//Select Doctor option
	//@FindBy(xpath="//div[@id='myModal']//select[@class='form-control select2 select2-hidden-accessible']")
	@FindBy(xpath="//ul[@class='select2-results__options']/li")
	List<WebElement> selectFromDoctorOptionsElement;
	//Standard Charges element
	@FindBy(css="#standard_charge")
	WebElement standardChargeselement;
	//apply to all button element
	@FindBy(xpath="//button[@onclick='apply_to_all()']")
	WebElement applyToAllButtonElement;
	//save button element
	@FindBy(xpath="//button[@id='formaddbtn']")
	WebElement saveButtonElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
	//close Add Charge Button
	@FindBy(xpath="//div[@id='myModal']//button[@class='close']")
	WebElement closeAddChargeButtonElement;
	//view charge details button
	@FindBy(xpath="//a[contains(@onclick,'viewDetail')]")
	List<WebElement> viewChargeDetailsButtonList;
	//close View Charge Details Button
	@FindBy(xpath="//div[@id='viewModal']//button[@class='close']")
	WebElement closeViewChargeDetailsButtonElement;
	//edit Charge Details Button
	@FindBy(xpath="//a[contains(@onclick,'getRecord')]")
	List<WebElement> editChargeDetailsButtonList;
	//close Edit Charge Details Button
	@FindBy(xpath="//div[@id='myModaledit']//button[@class='close']")
	WebElement closeEditChargeDetailsButtonElement;
	//save Edit button element
	@FindBy(xpath="//button[@id='formeditbtn']")
	WebElement saveEditButtonElement;
	//delete Charge Details Button
	@FindBy(xpath="//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deleteChargeDetailsButtonList;
	
	public void addChargeButtonClick() {
		waitByElement(addChargeButtonElement);
		addChargeButtonElement.click();
	}
	public void showDoctorOption() {
		showDoctorElement.click();
		waitByElement(selectFromDoctorOptionsElement.get(0));
	}
	public void selectDoctorOption(String selectByText) {
		waitByElement(selectFromDoctorOptionsElement.get(0));
		for(int i=0;i<selectFromDoctorOptionsElement.size();i++)
			{
			String optiontext=selectFromDoctorOptionsElement.get(i).getText();
			if(optiontext.contains(selectByText)) {
				selectFromDoctorOptionsElement.get(i).click();
				System.out.println(optiontext);
				break;
			}
			}
	}
	public void enterStandardCharges(String standardChargeValue) {
		standardChargeselement.click();
		standardChargeselement.sendKeys(standardChargeValue);
	}
	public void applyToAllButtonClick() {
		applyToAllButtonElement.click();
	}
	public void saveButtonClick() {
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
	public void viewChargeDetailsButtonClick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(viewChargeDetailsButtonList.get(i));
		viewChargeDetailsButtonList.get(i).click();
		waitByElement(closeViewChargeDetailsButtonElement);
	}
	public void closeViewChargeDetailsButtonClick() {
		closeViewChargeDetailsButtonElement.click();
	}
	public void editChargeDetailsButtonClick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(editChargeDetailsButtonList.get(i));
		editChargeDetailsButtonList.get(i).click();
		waitByElement(closeEditChargeDetailsButtonElement);
	}
	public void closeEditChargeDetailsButtonClick() {
		closeEditChargeDetailsButtonElement.click();
	}
	public void saveEditButtonClick() {
		saveEditButtonElement.click();
	}
	public void deleteChargeDetailsButtonClick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(deleteChargeDetailsButtonList.get(i));
		deleteChargeDetailsButtonList.get(i).click();
	}
}
