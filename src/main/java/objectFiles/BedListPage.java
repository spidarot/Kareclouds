package objectFiles;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractParentFiles.ObjectParentClass;

public class BedListPage extends ObjectParentClass {

	WebDriver driver;

	public BedListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Title Text
	@FindBy(xpath = "//h3[@class='box-title titlefix']")
	WebElement titleTextElement;
	// add button
	@FindBy(xpath = "//a[@data-target='#myModal']")
	WebElement addButtonElement;
	// close add button
	@FindBy(xpath = "//div[@id='myModal']//button[@class='close']")
	WebElement closeAddButtonElement;
	// Name Field in add window
	@FindBy(xpath = "//div[@id='myModal']//input[@class='form-control']")
	WebElement nameFieldElement;
	// Select Bed Type option
	@FindBy(css = "select#bed_type")
	WebElement selectBedTypeOptionElement;
	// Select Bed Group option
	@FindBy(css = "select#bed_group")
	WebElement selectBedGroupOptionElement;
	// save add window button
	@FindBy(css = "button#addbedbtn")
	WebElement saveAddWindowButtonElement;
	// edit Bed List Element Button
	@FindBy(xpath = "//a[contains(@onclick,'getRecord')]")
	List<WebElement> editBedListButtonList;
	// delete Bed List element Button
	@FindBy(xpath = "//a[contains(@onclick,'delete_recordById')]//i")
	List<WebElement> deleteBedListButtonList;
	// close edit Bed List window Button
	@FindBy(xpath = "//div[@id='myModalEdit']//button[@class='close']")
	WebElement closeEditBedListWindowButtonElement;
	// save edit Bed List window Button
	@FindBy(css = "button#editbedbtn")
	WebElement saveEditBedListWindowButtonElement;
	// toast Message Element
	@FindBy(xpath = "//body//div[@id='toast-container']//div[@class='toast-message']")
	WebElement toastMessageElement;

	public String titleTextGetText() {
		waitByElement(titleTextElement);
		String TitleText = titleTextElement.getText();
		return TitleText;
	}

	public void addButtonClick() {
		waitByElement(addButtonElement);
		addButtonElement.click();
		waitByElement(closeAddButtonElement);
	}

	public void enterNameField(String enterNameField) {
		nameFieldElement.sendKeys(enterNameField);
	}

	public void selectBedTypeOption(String BedTypeValue) {
		selectOptionByText(selectBedTypeOptionElement, BedTypeValue);
	}

	public void selectBedGroupOption(String BedGroupValue) {
		selectOptionByText(selectBedGroupOptionElement, BedGroupValue);
	}

	public void saveAddWindowButtonClick() {
		waitByElement(saveAddWindowButtonElement);
		saveAddWindowButtonElement.click();

	}

	public void closeAddButtonClick() {
		waitByElement(closeAddButtonElement);
		closeAddButtonElement.click();
	}

	public void editBedListButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(editBedListButtonList.get(i));
		editBedListButtonList.get(i).click();
		waitByElement(closeEditBedListWindowButtonElement);
	}

	public void closeEditBedListWindowButtonClick() {
		closeEditBedListWindowButtonElement.click();
	}

	public void saveEditBedListWindowButtonClick() {
		waitByElement(saveEditBedListWindowButtonElement);
		saveEditBedListWindowButtonElement.click();
	}

	public void deleteBedListButtonClick(int ElementNumberToBeSelected) {
		int i = ElementNumberToBeSelected - 1;
		actions(deleteBedListButtonList.get(i));
		deleteBedListButtonList.get(i).click();
	}

	public String toastMessageGetText() {
		waitByElement(toastMessageElement);
		String toastMessage = toastMessageElement.getText();
		return toastMessage;
	}

}
