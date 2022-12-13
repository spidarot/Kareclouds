package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class ChargeCategoryPage extends ObjectParentClass{

	WebDriver driver;
	
	public ChargeCategoryPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	//Add Charge Category button
	@FindBy(xpath="//a[contains(text(),' Add Charge Category')]")
	WebElement addChargeCategoryButtonElement;
	//Name in Add Charge Category Window
	@FindBy(css="#type")
	WebElement nameInAddChargeCategoryElement;
	//Description in Add Charge Category Window
	@FindBy(xpath="//div[@id='myModal']//textarea[@name='description']")
	WebElement descriptionInAddChargeCategoryElement;
	//selectChargeType in Add Charge Category Window
	@FindBy(xpath="//div[@id='myModal']//select[@name='charge_type']")
	WebElement selectChargeTypeInAddChargeCategoryElement;
	//Add Charge Category Save button
	@FindBy(css="#formaddbtn")
	WebElement saveAddChargeCategoryButtonElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;
	//Edit Charge Category Button
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[contains(@onclick,'get')]")
	List<WebElement> editChargeCategoryButtonList;
	//Edit Charge Category Save button
	@FindBy(css="#editformaddbtn")
	WebElement saveEditChargeCategoryButtonElement;
	//close Edit Charge Category Button
	@FindBy(xpath="//div[@id='editmyModal']//button[@class='close']")
	WebElement closeEditChargeCategoryButtonElement;
	//delete Charge Category Button
	@FindBy(xpath="//table[@id='DataTables_Table_0']//a[contains(@onclick,'delete_recordById')]")
	List<WebElement> deleteChargeCategoryButtonList;
	
	public void addChargeCategoryButtonClick() {
		waitByElement(addChargeCategoryButtonElement);
		addChargeCategoryButtonElement.click();
		waitByElement(saveAddChargeCategoryButtonElement);
	}
	public  void enterNameInAddChargeCategory(String EnterName) {
		nameInAddChargeCategoryElement.sendKeys(EnterName);
	}
	public void enterDescriptionInAddChargeCategory(String EnterDescription) {
		descriptionInAddChargeCategoryElement.sendKeys(EnterDescription);
	}
	public void selectChargeTypeInAddChargeCategory(String SelectByValue) {
		selectOption(selectChargeTypeInAddChargeCategoryElement, SelectByValue);
	}
	public void saveAddChargeCategoryButtonClick() {
		saveAddChargeCategoryButtonElement.click();
		
	}
	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}
	public void editChargeCategoryButtonClick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(editChargeCategoryButtonList.get(i));
		editChargeCategoryButtonList.get(i).click();
		waitByElement(saveEditChargeCategoryButtonElement);
	}
	public void saveEditChargeCategoryButtonClick() {
		saveEditChargeCategoryButtonElement.click();
	}
	public void closeEditChargeCategoryButtonClick() {
		closeEditChargeCategoryButtonElement.click();
	}
	public void alertHandlingPositive() {
		driver.switchTo().alert().accept();
	}

	public void alertHandlingNegative() {
		driver.switchTo().alert().dismiss();
	}
	public void deleteChargeCategoryButtonClick(int ElementNumberToBeSelected) {
		int i=ElementNumberToBeSelected-1;
		actions(deleteChargeCategoryButtonList.get(i));
		deleteChargeCategoryButtonList.get(i).click();
	}
}
